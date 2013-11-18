package edu.mbl.jif.imaging.lut;

//==============================================================================
// BTY ColorRGB SCALE Class
//
//   Phil Robertson, CSIRO, Canbera, Australia
// 
// AGG - Alexander Gee
//
// 041497 - created
//==============================================================================
public class BTY 
{
	static public int size = 256;  // 256 defined RGB ColorRGBs

	static public ColorRGB[] rgb;

	public BTY()
	{
		rgb = new ColorRGB[size];

		rgb[  0] = new ColorRGB(   7,   7, 254 );
		rgb[  1] = new ColorRGB(  23,  23, 252 );
		rgb[  2] = new ColorRGB(  30,  30, 250 );
		rgb[  3] = new ColorRGB(  36,  36, 248 );
		rgb[  4] = new ColorRGB(  40,  40, 247 );
		rgb[  5] = new ColorRGB(  44,  44, 245 );
		rgb[  6] = new ColorRGB(  47,  47, 243 );
		rgb[  7] = new ColorRGB(  50,  50, 242 );
		rgb[  8] = new ColorRGB(  52,  52, 240 );
		rgb[  9] = new ColorRGB(  55,  55, 239 );
		rgb[ 10] = new ColorRGB(  57,  57, 238 );
		rgb[ 11] = new ColorRGB(  59,  59, 236 );
		rgb[ 12] = new ColorRGB(  61,  61, 235 );
		rgb[ 13] = new ColorRGB(  63,  63, 234 );
		rgb[ 14] = new ColorRGB(  65,  65, 233 );
		rgb[ 15] = new ColorRGB(  66,  66, 231 );
		rgb[ 16] = new ColorRGB(  68,  68, 230 );
		rgb[ 17] = new ColorRGB(  69,  69, 229 );
		rgb[ 18] = new ColorRGB(  71,  71, 228 );
		rgb[ 19] = new ColorRGB(  72,  72, 227 );
		rgb[ 20] = new ColorRGB(  74,  74, 226 );
		rgb[ 21] = new ColorRGB(  75,  75, 225 );
		rgb[ 22] = new ColorRGB(  76,  76, 225 );
		rgb[ 23] = new ColorRGB(  78,  78, 224 );
		rgb[ 24] = new ColorRGB(  79,  79, 223 );
		rgb[ 25] = new ColorRGB(  80,  80, 222 );
		rgb[ 26] = new ColorRGB(  81,  81, 221 );
		rgb[ 27] = new ColorRGB(  82,  82, 221 );
		rgb[ 28] = new ColorRGB(  84,  84, 220 );
		rgb[ 29] = new ColorRGB(  85,  85, 219 );
		rgb[ 30] = new ColorRGB(  86,  86, 218 );
		rgb[ 31] = new ColorRGB(  87,  87, 218 );
		rgb[ 32] = new ColorRGB(  88,  88, 217 );
		rgb[ 33] = new ColorRGB(  89,  89, 216 );
		rgb[ 34] = new ColorRGB(  90,  90, 216 );
		rgb[ 35] = new ColorRGB(  91,  91, 215 );
		rgb[ 36] = new ColorRGB(  92,  92, 214 );
		rgb[ 37] = new ColorRGB(  93,  93, 214 );
		rgb[ 38] = new ColorRGB(  94,  94, 213 );
		rgb[ 39] = new ColorRGB(  95,  95, 213 );
		rgb[ 40] = new ColorRGB(  96,  96, 212 );
		rgb[ 41] = new ColorRGB(  97,  97, 212 );
		rgb[ 42] = new ColorRGB(  98,  98, 211 );
		rgb[ 43] = new ColorRGB(  98,  98, 210 );
		rgb[ 44] = new ColorRGB(  99,  99, 210 );
		rgb[ 45] = new ColorRGB( 100, 100, 209 );
		rgb[ 46] = new ColorRGB( 101, 101, 209 );
		rgb[ 47] = new ColorRGB( 102, 102, 208 );
		rgb[ 48] = new ColorRGB( 103, 103, 208 );
		rgb[ 49] = new ColorRGB( 104, 104, 208 );
		rgb[ 50] = new ColorRGB( 105, 105, 207 );
		rgb[ 51] = new ColorRGB( 105, 105, 207 );
		rgb[ 52] = new ColorRGB( 106, 106, 206 );
		rgb[ 53] = new ColorRGB( 107, 107, 206 );
		rgb[ 54] = new ColorRGB( 108, 108, 205 );
		rgb[ 55] = new ColorRGB( 109, 109, 205 );
		rgb[ 56] = new ColorRGB( 110, 110, 204 );
		rgb[ 57] = new ColorRGB( 110, 110, 204 );
		rgb[ 58] = new ColorRGB( 111, 111, 204 );
		rgb[ 59] = new ColorRGB( 112, 112, 203 );
		rgb[ 60] = new ColorRGB( 113, 113, 203 );
		rgb[ 61] = new ColorRGB( 114, 114, 202 );
		rgb[ 62] = new ColorRGB( 114, 114, 202 );
		rgb[ 63] = new ColorRGB( 115, 115, 202 );
		rgb[ 64] = new ColorRGB( 116, 116, 201 );
		rgb[ 65] = new ColorRGB( 117, 117, 201 );
		rgb[ 66] = new ColorRGB( 118, 118, 200 );
		rgb[ 67] = new ColorRGB( 118, 118, 200 );
		rgb[ 68] = new ColorRGB( 119, 119, 200 );
		rgb[ 69] = new ColorRGB( 120, 120, 199 );
		rgb[ 70] = new ColorRGB( 121, 121, 199 );
		rgb[ 71] = new ColorRGB( 121, 121, 199 );
		rgb[ 72] = new ColorRGB( 122, 122, 198 );
		rgb[ 73] = new ColorRGB( 123, 123, 198 );
		rgb[ 74] = new ColorRGB( 124, 124, 198 );
		rgb[ 75] = new ColorRGB( 124, 124, 197 );
		rgb[ 76] = new ColorRGB( 125, 125, 197 );
		rgb[ 77] = new ColorRGB( 126, 126, 197 );
		rgb[ 78] = new ColorRGB( 127, 127, 196 );
		rgb[ 79] = new ColorRGB( 128, 128, 196 );
		rgb[ 80] = new ColorRGB( 128, 128, 195 );
		rgb[ 81] = new ColorRGB( 129, 129, 195 );
		rgb[ 82] = new ColorRGB( 130, 130, 195 );
		rgb[ 83] = new ColorRGB( 130, 130, 194 );
		rgb[ 84] = new ColorRGB( 131, 131, 194 );
		rgb[ 85] = new ColorRGB( 132, 132, 194 );
		rgb[ 86] = new ColorRGB( 133, 133, 193 );
		rgb[ 87] = new ColorRGB( 133, 133, 193 );
		rgb[ 88] = new ColorRGB( 134, 134, 193 );
		rgb[ 89] = new ColorRGB( 135, 135, 192 );
		rgb[ 90] = new ColorRGB( 136, 136, 192 );
		rgb[ 91] = new ColorRGB( 136, 136, 192 );
		rgb[ 92] = new ColorRGB( 137, 137, 191 );
		rgb[ 93] = new ColorRGB( 138, 138, 191 );
		rgb[ 94] = new ColorRGB( 139, 139, 191 );
		rgb[ 95] = new ColorRGB( 139, 139, 190 );
		rgb[ 96] = new ColorRGB( 140, 140, 190 );
		rgb[ 97] = new ColorRGB( 141, 141, 190 );
		rgb[ 98] = new ColorRGB( 142, 142, 189 );
		rgb[ 99] = new ColorRGB( 142, 142, 189 );
		rgb[100] = new ColorRGB( 143, 143, 189 );
		rgb[101] = new ColorRGB( 144, 144, 188 );
		rgb[102] = new ColorRGB( 144, 144, 188 );
		rgb[103] = new ColorRGB( 145, 145, 188 );
		rgb[104] = new ColorRGB( 146, 146, 187 );
		rgb[105] = new ColorRGB( 147, 147, 187 );
		rgb[106] = new ColorRGB( 147, 147, 187 );
		rgb[107] = new ColorRGB( 148, 148, 186 );
		rgb[108] = new ColorRGB( 149, 149, 186 );
		rgb[109] = new ColorRGB( 149, 149, 186 );
		rgb[110] = new ColorRGB( 150, 150, 185 );
		rgb[111] = new ColorRGB( 151, 151, 185 );
		rgb[112] = new ColorRGB( 152, 152, 185 );
		rgb[113] = new ColorRGB( 152, 152, 184 );
		rgb[114] = new ColorRGB( 153, 153, 184 );
		rgb[115] = new ColorRGB( 154, 154, 184 );
		rgb[116] = new ColorRGB( 154, 154, 183 );
		rgb[117] = new ColorRGB( 155, 155, 183 );
		rgb[118] = new ColorRGB( 156, 156, 182 );
		rgb[119] = new ColorRGB( 157, 157, 182 );
		rgb[120] = new ColorRGB( 157, 157, 182 );
		rgb[121] = new ColorRGB( 158, 158, 181 );
		rgb[122] = new ColorRGB( 159, 159, 181 );
		rgb[123] = new ColorRGB( 159, 159, 181 );
		rgb[124] = new ColorRGB( 160, 160, 180 );
		rgb[125] = new ColorRGB( 161, 161, 180 );
		rgb[126] = new ColorRGB( 162, 162, 180 );
		rgb[127] = new ColorRGB( 162, 162, 179 );
		rgb[128] = new ColorRGB( 163, 163, 179 );
		rgb[129] = new ColorRGB( 164, 164, 178 );
		rgb[130] = new ColorRGB( 164, 164, 178 );
		rgb[131] = new ColorRGB( 165, 165, 178 );
		rgb[132] = new ColorRGB( 166, 166, 177 );
		rgb[133] = new ColorRGB( 167, 167, 177 );
		rgb[134] = new ColorRGB( 167, 167, 176 );
		rgb[135] = new ColorRGB( 168, 168, 176 );
		rgb[136] = new ColorRGB( 169, 169, 176 );
		rgb[137] = new ColorRGB( 169, 169, 175 );
		rgb[138] = new ColorRGB( 170, 170, 175 );
		rgb[139] = new ColorRGB( 171, 171, 174 );
		rgb[140] = new ColorRGB( 172, 172, 174 );
		rgb[141] = new ColorRGB( 172, 172, 173 );
		rgb[142] = new ColorRGB( 173, 173, 173 );
		rgb[143] = new ColorRGB( 174, 174, 173 );
		rgb[144] = new ColorRGB( 174, 174, 172 );
		rgb[145] = new ColorRGB( 175, 175, 172 );
		rgb[146] = new ColorRGB( 176, 176, 171 );
		rgb[147] = new ColorRGB( 177, 177, 171 );
		rgb[148] = new ColorRGB( 177, 177, 170 );
		rgb[149] = new ColorRGB( 178, 178, 170 );
		rgb[150] = new ColorRGB( 179, 179, 169 );
		rgb[151] = new ColorRGB( 179, 179, 169 );
		rgb[152] = new ColorRGB( 180, 180, 168 );
		rgb[153] = new ColorRGB( 181, 181, 168 );
		rgb[154] = new ColorRGB( 181, 181, 167 );
		rgb[155] = new ColorRGB( 182, 182, 167 );
		rgb[156] = new ColorRGB( 183, 183, 166 );
		rgb[157] = new ColorRGB( 184, 184, 166 );
		rgb[158] = new ColorRGB( 184, 184, 165 );
		rgb[159] = new ColorRGB( 185, 185, 165 );
		rgb[160] = new ColorRGB( 186, 186, 164 );
		rgb[161] = new ColorRGB( 186, 186, 164 );
		rgb[162] = new ColorRGB( 187, 187, 163 );
		rgb[163] = new ColorRGB( 188, 188, 163 );
		rgb[164] = new ColorRGB( 189, 189, 162 );
		rgb[165] = new ColorRGB( 189, 189, 162 );
		rgb[166] = new ColorRGB( 190, 190, 161 );
		rgb[167] = new ColorRGB( 191, 191, 161 );
		rgb[168] = new ColorRGB( 191, 191, 160 );
		rgb[169] = new ColorRGB( 192, 192, 159 );
		rgb[170] = new ColorRGB( 193, 193, 159 );
		rgb[171] = new ColorRGB( 194, 194, 158 );
		rgb[172] = new ColorRGB( 194, 194, 158 );
		rgb[173] = new ColorRGB( 195, 195, 157 );
		rgb[174] = new ColorRGB( 196, 196, 157 );
		rgb[175] = new ColorRGB( 196, 196, 156 );
		rgb[176] = new ColorRGB( 197, 197, 155 );
		rgb[177] = new ColorRGB( 198, 198, 155 );
		rgb[178] = new ColorRGB( 199, 199, 154 );
		rgb[179] = new ColorRGB( 199, 199, 153 );
		rgb[180] = new ColorRGB( 200, 200, 153 );
		rgb[181] = new ColorRGB( 201, 201, 152 );
		rgb[182] = new ColorRGB( 201, 201, 151 );
		rgb[183] = new ColorRGB( 202, 202, 151 );
		rgb[184] = new ColorRGB( 203, 203, 150 );
		rgb[185] = new ColorRGB( 204, 204, 149 );
		rgb[186] = new ColorRGB( 204, 204, 149 );
		rgb[187] = new ColorRGB( 205, 205, 148 );
		rgb[188] = new ColorRGB( 206, 206, 147 );
		rgb[189] = new ColorRGB( 206, 206, 146 );
		rgb[190] = new ColorRGB( 207, 207, 146 );
		rgb[191] = new ColorRGB( 208, 208, 145 );
		rgb[192] = new ColorRGB( 209, 209, 144 );
		rgb[193] = new ColorRGB( 209, 209, 143 );
		rgb[194] = new ColorRGB( 210, 210, 143 );
		rgb[195] = new ColorRGB( 211, 211, 142 );
		rgb[196] = new ColorRGB( 211, 211, 141 );
		rgb[197] = new ColorRGB( 212, 212, 140 );
		rgb[198] = new ColorRGB( 213, 213, 139 );
		rgb[199] = new ColorRGB( 214, 214, 138 );
		rgb[200] = new ColorRGB( 214, 214, 138 );
		rgb[201] = new ColorRGB( 215, 215, 137 );
		rgb[202] = new ColorRGB( 216, 216, 136 );
		rgb[203] = new ColorRGB( 216, 216, 135 );
		rgb[204] = new ColorRGB( 217, 217, 134 );
		rgb[205] = new ColorRGB( 218, 218, 133 );
		rgb[206] = new ColorRGB( 219, 219, 132 );
		rgb[207] = new ColorRGB( 219, 219, 131 );
		rgb[208] = new ColorRGB( 220, 220, 130 );
		rgb[209] = new ColorRGB( 221, 221, 129 );
		rgb[210] = new ColorRGB( 221, 221, 128 );
		rgb[211] = new ColorRGB( 222, 222, 127 );
		rgb[212] = new ColorRGB( 223, 223, 126 );
		rgb[213] = new ColorRGB( 224, 224, 125 );
		rgb[214] = new ColorRGB( 224, 224, 124 );
		rgb[215] = new ColorRGB( 225, 225, 123 );
		rgb[216] = new ColorRGB( 226, 226, 122 );
		rgb[217] = new ColorRGB( 226, 226, 121 );
		rgb[218] = new ColorRGB( 227, 227, 119 );
		rgb[219] = new ColorRGB( 228, 228, 118 );
		rgb[220] = new ColorRGB( 229, 229, 117 );
		rgb[221] = new ColorRGB( 229, 229, 116 );
		rgb[222] = new ColorRGB( 230, 230, 114 );
		rgb[223] = new ColorRGB( 231, 231, 113 );
		rgb[224] = new ColorRGB( 232, 232, 112 );
		rgb[225] = new ColorRGB( 232, 232, 110 );
		rgb[226] = new ColorRGB( 233, 233, 109 );
		rgb[227] = new ColorRGB( 234, 234, 107 );
		rgb[228] = new ColorRGB( 234, 234, 106 );
		rgb[229] = new ColorRGB( 235, 235, 104 );
		rgb[230] = new ColorRGB( 236, 236, 103 );
		rgb[231] = new ColorRGB( 237, 237, 101 );
		rgb[232] = new ColorRGB( 237, 237, 100 );
		rgb[233] = new ColorRGB( 238, 238,  98 );
		rgb[234] = new ColorRGB( 239, 239,  96 );
		rgb[235] = new ColorRGB( 239, 239,  94 );
		rgb[236] = new ColorRGB( 240, 240,  92 );
		rgb[237] = new ColorRGB( 241, 241,  91 );
		rgb[238] = new ColorRGB( 242, 242,  89 );
		rgb[239] = new ColorRGB( 242, 242,  86 );
		rgb[240] = new ColorRGB( 243, 243,  84 );
		rgb[241] = new ColorRGB( 244, 244,  82 );
		rgb[242] = new ColorRGB( 245, 245,  80 );
		rgb[243] = new ColorRGB( 245, 245,  77 );
		rgb[244] = new ColorRGB( 246, 246,  74 );
		rgb[245] = new ColorRGB( 247, 247,  72 );
		rgb[246] = new ColorRGB( 247, 247,  69 );
		rgb[247] = new ColorRGB( 248, 248,  65 );
		rgb[248] = new ColorRGB( 249, 249,  62 );
		rgb[249] = new ColorRGB( 250, 250,  58 );
		rgb[250] = new ColorRGB( 250, 250,  54 );
		rgb[251] = new ColorRGB( 251, 251,  49 );
		rgb[252] = new ColorRGB( 252, 252,  44 );
		rgb[253] = new ColorRGB( 253, 253,  37 );
		rgb[254] = new ColorRGB( 253, 253,  28 );
		rgb[255] = new ColorRGB( 254, 254,  13 );
	}
}

