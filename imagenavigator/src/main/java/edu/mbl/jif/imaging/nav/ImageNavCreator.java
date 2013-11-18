package edu.mbl.jif.imaging.nav;

import edu.mbl.jif.imaging.nav.dirtree.DirectorySelectionListener;
import edu.mbl.jif.imaging.nav.util.FilePathUtils;
//import edu.mbl.jif.imaging.nav.util.PathUtils;
import edu.mbl.jif.imaging.nav.util.PathWatcherObserver;

import edu.mbl.jif.imaging.nav.util.PathWatcher;
import edu.mbl.jif.imaging.nav.util.StaticSwingUtils;
import java.awt.event.ActionEvent;
import java.io.File;
import javax.swing.AbstractAction;
import javax.swing.Action;
import javax.swing.JMenuItem;
import javax.swing.JPopupMenu;
import net.trevize.galatee.GEvent;
import net.trevize.galatee.GListener;
import net.trevize.galatee.Galatee;
import net.trevize.galatee.GalateeFactory;
import net.trevize.galatee.GalateeProperties;
//import org.apache.commons.io.DirectoryWalker;
//import org.apache.commons.io.comparator.NameFileComparator;
//import org.apache.commons.io.filefilter.FileFilterUtils;
//import org.apache.commons.io.filefilter.HiddenFileFilter;
//import org.apache.commons.io.filefilter.IOFileFilter;

/**
 * Creates the image navigation table based on all the settings.
 *
 * @author GBH
 */
public class ImageNavCreator implements DirectorySelectionListener, PathWatcherObserver {

   private ImageNavigator imgNav;
   private File dir;
   private boolean recurseSubDirs = false;
   private boolean firstOnly;
   private Galatee currentGalatee;
   // View
   private boolean equalizeHisto;
   private int currentView;
   private int numColumns = 1;
   private int numColumnsGridView = 4;
   private int thumbWidth = 64;
   private boolean showDescription = true;
   public static final int GRID = 0;
   public static final int SINGLE = 1;
   //
   private String currentSelection;
   // for Path Watching...
   private PathWatcher pathWatcher;
   private boolean watchRecursively;
   private boolean watchingPath;
   //
   private FileOpener fileOpener;
   //

   public ImageNavCreator(ImageNavigator imgNav) {
      this.imgNav = imgNav;
      pathWatcher = new PathWatcher(this);
      numColumnsGridView = Prefs.getInt(this.getClass(), "numColsGrid", 4);
      thumbWidth = Prefs.getInt(this.getClass(), "thumbWidth", 64);
      GalateeProperties.setImage_width(thumbWidth);
      GalateeProperties.setImage_height(thumbWidth);
      fileOpener = new FileOpener();
   }

   //g.enableSearchFunctionality();
   public void setView(int view) {
      this.currentView = view;
      if (view == GRID) {
         numColumns = numColumnsGridView;
         showDescription = false;
      } else if (view == SINGLE) {
         numColumns = 1;
         showDescription = true;
      }
      Prefs.put(this.getClass(), "view", currentView);
      currentGalatee.setView(numColumns, showDescription);
   }

   public void setRecurseSubDirs(boolean recurse) {
      this.recurseSubDirs = recurse;
      this.setWatchRecursively(recurse);
      if (this.recurseSubDirs) {
         GalateeProperties.setSelected_item_background_color("#779438");
      } else {
         GalateeProperties.setSelected_item_background_color("#127990");
      }
   }

   public void setFirstOnly(boolean selected) {
      this.firstOnly = selected;
   }

   public void setEqualizeHisto(boolean equalizeHisto) {
      this.equalizeHisto = equalizeHisto;
   }

   public void setThumbnailSize(int size, int panelWidth) {
      numColumnsGridView = (int) Math.floor(panelWidth / ((double) size + 10));
      Prefs.put(this.getClass(), "numColsGrid", numColumnsGridView);
      Prefs.put(this.getClass(), "thumbWidth", size);
      this.thumbWidth = size;
      GalateeProperties.setImage_width(thumbWidth);
      GalateeProperties.setImage_height(thumbWidth);
      if (this.currentView == GRID) {
         numColumns = numColumnsGridView;
         showDescription = false;
      } else if (this.currentView == SINGLE) {
         numColumns = 1;
         showDescription = true;
      }
      updateImageNav();
   }

   public int getThumbWidth() {
      return thumbWidth;
   }

   @Override
   /* When a new directory is selected, a new ImageNav is created containing thumbnails for the 
    * images/dataset in that directory and maybe its sub-dirs
    */
   public void directorySelected(final File directory) {
      this.dir = directory;
      System.out.println("directorySelected:" + directory.getPath());
      updateImageNav();
      if (isWatchingPath()) {
         pathWatcher.startWatching(this.dir.getAbsolutePath(), isWatchRecursively());
      }
   }

   void updateImageNav() {
      if (dir != null) {
         new UpdateImageNavThread(dir.getPath(), this.recurseSubDirs).run();
      }
   }

   class UpdateImageNavThread extends Thread {

      private final String path;
      private final boolean recursive;

      public UpdateImageNavThread(String path, boolean recursive) {
         this.path = path;
         this.recursive = recursive;
      }

      public void run() {
         imgNav.setLabelWorking();
         imgNav.showBusyDialog();
         currentGalatee = createNewImageNav(path, this.recursive);
         imgNav.replaceGalatee(currentGalatee);
         imgNav.setCurrentDirLabel(path);
         imgNav.setSelectedFileLabel("");
         imgNav.closeBusyDialog();
      }
   }

   public Galatee createNewImageNav(String path, boolean recursive) {
      Galatee g = GalateeFactory.loadDatasetFromDirectory(path, recursive, firstOnly,
              numColumns, showDescription, equalizeHisto);
      //Galatee g = createGalatee(path + "/*.tif", 88, numColumns, false);
      g.addGalateeListener(createActionsListener());
      addPopUps(g);
      return g;
   }

   // unused...
//   public Galatee createGalateeWithFileSpec(String path, int size, int numColumns, boolean recursive) {
//      //loading files and metadata.
//      Vector<URI> v_uri = new Vector<URI>();
//      Vector<Vector<Object>> v_object = new Vector<Vector<Object>>();
//      if (!recursive) {
//         File[] files = new File(path).listFiles();
//         if (files != null) {
//            Arrays.sort(files, NameFileComparator.NAME_INSENSITIVE_COMPARATOR);
//            for (int i = 0; i < files.length; ++i) {
//               if (files[i].getName().endsWith(".png")
//                       || files[i].getName().endsWith(".jpg")
//                       || files[i].getName().endsWith(".gif")
//                       || files[i].getName().endsWith(".jpeg")
//                       || files[i].getName().endsWith(".svg")
//                       || files[i].getName().endsWith(".bmp")
//                       || files[i].getName().endsWith(".tif")
//                       || files[i].getName().endsWith(".ppm")) {
//
//                  v_uri.add(files[i].toURI());
//                  Vector<Object> v = new Vector<Object>();
//                  v.add(files[i].getName());
//                  v_object.add(v);
//               }
//            }
//         }
//      } else { // look in all sub-dirs...
////		// for Micro-Manager Datasets:
////		// for PolScope images, path + "/*retardance*.tif" works using DeepFileSet
////		// If a directory contains a 
////		// only first one...
//         // Use the filters to construct the walker
//         FooDirectoryWalker walker = new FooDirectoryWalker(
//                 HiddenFileFilter.VISIBLE,
//                 FileFilterUtils.suffixFileFilter(".txt"));
//
//         for (File f : new DeepFileSet(path)) {
//            v_uri.add(f.toURI());
//            Vector<Object> v = new Vector<Object>();
//            //v.add(f.getName());
//            //v.add(f.getPath());
//            v.add(f.getParentFile().getName() + "\n" + f.getName());
//            v_object.add(v);
//            // System.out.println(f.getAbsolutePath() + " : " + f.getParent() + " " + f.getName());
//         }
//      }
//      //}
//      Galatee g = new Galatee(v_uri, v_object, new Dimension(size, size), 400, numColumns);
//      g.addGalateeListener(createActionsListener());
//      return g;
//   }
//
//   public class FooDirectoryWalker extends DirectoryWalker {
//
//      public FooDirectoryWalker(IOFileFilter dirFilter, IOFileFilter fileFilter) {
//         super(dirFilter, fileFilter, -1);
//      }
//   }
//<editor-fold defaultstate="collapsed" desc="=== Watch Files ======================">
   public void setWatchRecursively(boolean watchRecursively) {
      this.watchRecursively = watchRecursively;
   }

   public void setWatchingPath(boolean watchingPath) {
      this.watchingPath = watchingPath;
   }

   private boolean isWatchRecursively() {
      return this.watchRecursively;
   }

   private boolean isWatchingPath() {
      return this.watchingPath;
   }

   // CaresAboutFileChanges implementation ...
   @Override
   public void fileCreated(String file) {
      updateImageNav();
      System.out.println("File created: " + file);
   }

   @Override
   public void fileDeleted(String file) {
      updateImageNav();
      System.out.println("File deleted: " + file);
   }

   public void terminate() {
      pathWatcher.stopWatching();
   }
   //</editor-fold>

// <editor-fold defaultstate="collapsed" desc=" === Actions =======================================">
   // Galatee makes callbacks here on selection or double click
   private GListener createActionsListener() {
      return new GListener() {
//         class SystemCommandThread extends Thread {
//            private SystemCommandHandler2 sch2 = new SystemCommandHandler2();
//            private String command;
//
//            public SystemCommandThread(String command) {
//               this.command = command;
//            }
//
//            public void run() {
//               String[] commands = new String[1];
//               commands[0] = command;
//               sch2.exec(commands);
//            }
//         }
         @Override
         public void itemDoubleClicked(GEvent e) {
            // TODO add image viewer here...
            System.out.println("item doubleclicked ["
                    + e.getSelectedItem().getLocalFilepath() + "]");
            processDoubleClick(e.getSelectedItem().getLocalFilepath());
         }

         @Override
         public void selectionChanged(GEvent e) {
            if (e.getSelectedItem() == null) {
            } else {
//               String relativePath = PathUtils.getRelativePath(e.getSelectedItem().getLocalFilepath(),
//                       ImageNavCreator.this.dir.getAbsolutePath());
//               imgNav.setSelectedFileLabel(relativePath);
               // TODO only show path below currently selected dir in tree...
            }
//            File file = new File(currentSelection);
//            //imgExp.setCurrentDirLabel(file.getParent());
//            imgExp.setCurrentDirLabel(file.getParent());
//            System.out.println("changing selection for ["
//                    + e.getSelectedItem().getLocalFilepath() + "]");
         }
      };
   }
//
//   private static String getRelativePath(String pathOfFile, String containingPath) {
//      String currentSelection = PathUtils.forceForwardSlashes(pathOfFile);
//      if (currentSelection.startsWith("/")) {
//         currentSelection = currentSelection.substring(1, currentSelection.length());
//      }
//      String dirPath = PathUtils.forceForwardSlashes(containingPath);
//      String relativePath = PathUtils.relativize(dirPath, currentSelection);
//      return relativePath;
//   }

   // On double-click, open image
   private void processDoubleClick(String localFilepath) {
      fileOpener.openFile(localFilepath);
   }

   //
   public void addPopUps(Galatee g) {
      // Add popup menu options...
      JPopupMenu popup_menu = new JPopupMenu();
      JMenuItem item;
      item = new JMenuItem("Title");
      item.setEnabled(false);
      popup_menu.add(item);
      popup_menu.addSeparator();
      item = new JMenuItem("Open in ImageJ");
      popup_menu.add(item);
      item = new JMenuItem("Open in MMgr");
      popup_menu.add(item);
      item = new JMenuItem(openTreeAtDirectory);
      popup_menu.add(item);
      popup_menu.addSeparator();
      item = new JMenuItem("Copy Path");
      popup_menu.add(item);
      g.setPopup_menu(popup_menu);
   }
   //
   Action openTreeAtDirectory = new AbstractAction("OpenDirectory") {
      // TODO -- This is very slow...
      // Open the Directory tree at the directory of the selected file
      @Override
      public void actionPerformed(ActionEvent e) {
         if (currentSelection == null) {
            return;
         }
         System.out.println("currentSelection: " + currentSelection);
         File f = new File(currentSelection);
         String dirPath = f.getParent();
         System.out.println("parent: " + dirPath);
//         String foreslash = "/";
//         String regex = "\\\\";
//         final String dirPathFixed = dirPath.replaceAll(regex, foreslash);
//         System.out.println("dirPathFixed: " + dirPathFixed);
         final String dirPathFixed = FilePathUtils.forceForwardSlashes(dirPath);
//         imgExp.showBusyDialog();

         StaticSwingUtils.dispatchToEDT(new Runnable() {
            public void run() {
               imgNav.getDirTree().openDirNode(dirPathFixed);



            }
         });
//         imgExp.closeBusyDialog();
      }
   };
// </editor-fold>
//
}
