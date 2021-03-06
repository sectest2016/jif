 /*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.mbl.jif.imaging.nav.util;

import java.io.File;
import java.io.IOException;
import java.nio.file.Path;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.logging.Level;
import java.util.logging.Logger;

import org.apache.commons.io.FilenameUtils;

/**
 *
 * @author GBH
 */
public class FilePathUtils {

   public static final String SHORTENER_ELLIPSE = "...";

   /**
    * Compacts a path into a given number of characters. The result is similar to the Win32 API
    * PathCompactPathExA.
    *
    * @param path the path to the file (relative or absolute)
    * @param limit the number of characters to which the path should be limited
    * @return shortened path
    */
   public static String limitPath(final String path, final int limit) {
      if (path.length() <= limit) {
         return path;
      }
      final char shortPathArray[] = new char[limit];
      final char pathArray[] = path.toCharArray();
      final char ellipseArray[] = SHORTENER_ELLIPSE.toCharArray();
      final int pathindex = pathArray.length - 1;
      final int shortpathindex = limit - 1;
      // fill the array from the end
      int i = 0;
      for (; i < limit; i++) {
         if (pathArray[pathindex - i] != '/' && pathArray[pathindex - i] != '\\') {
            shortPathArray[shortpathindex - i] = pathArray[pathindex - i];
         } else {
            break;
         }
      }
      // check how much space is left
      final int free = limit - i;
      if (free < SHORTENER_ELLIPSE.length()) {
         // fill the beginning with ellipse
         for (int j = 0; j < ellipseArray.length; j++) {
            shortPathArray[j] = ellipseArray[j];
         }
      } else {
         // fill the beginning with path and leave room for the ellipse
         int j = 0;
         for (; j + ellipseArray.length < free; j++) {
            shortPathArray[j] = pathArray[j];
         }
         // ... add the ellipse
         for (int k = 0; j + k < free; k++) {
            shortPathArray[j + k] = ellipseArray[k];
         }
      }
      return new String(shortPathArray);
   }

   public static String forceForwardSlashes(String dirPath) {
      String foreslash = "/";
      String regex = "\\\\";
      final String dirPathFixed = dirPath.replaceAll(regex, foreslash);
      return dirPathFixed;
   }

   public static String getRelativePath(String containingPath, String pathOfFile)
           throws IllegalArgumentException {
      String filePath = FilePathUtils.forceForwardSlashes(pathOfFile);
      // Why? to deal with case of "/C:..."
      if (filePath.startsWith("/")) {
         filePath = filePath.substring(1, filePath.length());
      }
      String dirPath = FilePathUtils.forceForwardSlashes(containingPath);
      String commonPath = commonPath(new String[]{dirPath, filePath});
      // DEBUG
      //System.out.println("commonPath: " + commonPath);
      //System.out.println("filePath: " + filePath);
      //
      String relativePath = relativize(commonPath, filePath);
      return relativePath;
   }

   private static String commonPath(String... paths) {
      String commonPath = "";
      String[][] folders = new String[paths.length][];
      for (int i = 0; i < paths.length; i++) {
         folders[i] = paths[i].split("/");
      }
      for (int j = 0; j < folders[0].length; j++) {
         String thisFolder = folders[0][j];
         boolean allMatched = true; //assume all have matched in case there are no more paths
         for (int i = 1; i < folders.length && allMatched; i++) {
            if (folders[i].length < j) {
               allMatched = false;
               break; //stop looking because we've gone as far as we can
            }
            allMatched &= folders[i][j].equals(thisFolder);
         }
         if (allMatched) {
            commonPath += thisFolder + "/";
         } else {
            //otherwise
            break; //stop looking
         }
      }
      return commonPath;
   }

   /**
    * Calculates the relative path between a specified root directory and a target path.
    *
    * @param root The absolute path of the root directory.
    * @param target The path to the target file or directory.
    * @return The relative path between the specified root directory and the target path.
    * @throws IllegalArgumentException <ul><li>The root file cannot be null.</li><li>The target
    * cannot be null.</li><li>The root file must be a directory.</li><li>The root file must be
    * absolute.</li></ul>
    */
   private static String relativize(final String root, final String target)
           throws IllegalArgumentException {
      return relativize(new File(root), new File(target));
   }

   private static String relativize(final File root, final File target)
           throws IllegalArgumentException {
      if (root == null) {
         throw new IllegalArgumentException("The root file cannot be null.");
      }
      if (target == null) {
         throw new IllegalArgumentException("The target cannot be null.");
      }
      if (!root.isDirectory()) {
         throw new IllegalArgumentException("The root file must be a directory: " + root);
      }
      if (!root.isAbsolute()) {
         throw new IllegalArgumentException("The root file must be absolute: " + root);
      }
      if (!target.isAbsolute()) {
         return target.toString();
      }
      if (root.equals(target)) {
         return ".";
      }
      final Deque<File> rootHierarchy = new ArrayDeque<File>();
      for (File f = root; f != null; f = f.getParentFile()) {
         rootHierarchy.push(f);
      }
      final Deque<File> targetHierarchy = new ArrayDeque<File>();
      for (File f = target; f != null; f = f.getParentFile()) {
         targetHierarchy.push(f);
      }
      while (rootHierarchy.size() > 0 && targetHierarchy.size() > 0 && rootHierarchy.peek().equals(
              targetHierarchy.peek())) {
         rootHierarchy.pop();
         targetHierarchy.pop();
      }
      final StringBuilder sb = new StringBuilder(rootHierarchy.size() * 3 + targetHierarchy.size()
              * 32);
      while (rootHierarchy.size() > 0) {
         sb.append("..");
         rootHierarchy.pop();
         if (rootHierarchy.size() > 0 || targetHierarchy.size() > 0) {
            sb.append("/");
         }
      }
      while (targetHierarchy.size() > 0) {
         sb.append(targetHierarchy.pop().getName());
         if (targetHierarchy.size() > 0) {
            sb.append("/");
         }
      }
      return sb.toString();
   }

   // ================================================
   public static void main(String[] args) {
      //String root = "C:\\MicroManagerData\\Test";
      String root = "C:/MicroManagerData/Test";
      String target = "C:\\MicroManagerData\\Test\\dataXMT16_1\\dataXMT16_MMImages_Pos0.ome.tif";
      //String target = "MicroManagerData/Test/dataXMT16_1/dataXMT16_MMImages_Pos0.ome.tif";
      test(root, target);

      root = "C:\\Program Files\\Program Files\\PROJECT1PROJECT1";
      target = "C:\\Program Files\\PROJECT1";
//              "Program Files\\PROJECT1\\PROJECT1.cfg";
      test(root, target);
      root = "C:\\Windows\\Local Settings\\Application Data\\PROJECT1";
      target = "C:\\Windows\\Local Settings\\Application Data\\PROJECT1\\PROJECT1.cfg";
      test(root, target);
      root = "/etc";
      target = "/etc/project1.cfg";
      test(root, target);
      root = "/Users/user/.config/project1";
      target = "/Users/user/.config/project1/project1.cfg";
      test(root, target);
   }

   public static void test(String root, String target) {
      try {
         System.out.println("" + root + "\n" + target);

         System.out.println("normalized:  " + FilenameUtils.normalize(root));
         File f = new File(root);
         System.out.println("canonical:   " + f.getCanonicalPath());
         System.out.println("absolute:    " + f.getAbsolutePath());
         Path p = f.toPath();
         System.out.println("path:        " + p.toString());
         if (f.isDirectory()) {
            String result = FilePathUtils.getRelativePath(root, target);
            System.out.println("relative:    " + result);
         } else {
            System.out.println("root not a directory");
         }
         

//      String rootFixed = FilePathUtils.forceForwardSlashes(root);
//      String targetFixed = FilePathUtils.forceForwardSlashes(target);
//      System.out.println("commonPath:   " + FilePathUtils.commonPath(new String[]{rootFixed, targetFixed}));
//      System.out.println("limitPath:    " + limitPath(target, 55));
//      System.out.println("limitPath(/): " + limitPath(targetFixed, 55));
         System.out.println("");
      } catch (Exception ex) {
         Logger.getLogger(FilePathUtils.class.getName()).log(Level.SEVERE, null, ex);
      }
   }

}
