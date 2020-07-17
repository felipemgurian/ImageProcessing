package Operations.Filters;

import Utils.Utils;
import Utils.Image;

public class Convolve {
	
	public static Image convolve(Image a, Kernel k) {
		Image result = new Image(a.getW(), a.getH());
		
		for(int j = 0; j < a.getH(); j++) {
			for(int i = 0; i < a.getW(); i++) {
				float accumR = 0;
				float accumG = 0;
				float accumB = 0;

				for(int l = 0; l < k.k.length; l++) {
					for(int m = 0; m < k.k[0].length; m++) {
						
						int color = a.getP(i-k.cx+l, j-k.cy+m);
						int r = Utils.red(color);
						int g = Utils.green(color);
						int b = Utils.blue(color);		
						
						accumR += k.k[l][m]*r;
						accumG += k.k[l][m]*g;
						accumB += k.k[l][m]*b;		
						
					}
				}
				
				int r = Math.round(accumR);
				int g = Math.round(accumG);
				int b = Math.round(accumB);
				
				r = r>255?255:r;
				g = g>255?255:g;
				b = b>255?255:b;
				
				result.setP(i, j, r<<16|g<<8|b);
			}
		}
		return result;
	}
	

}
