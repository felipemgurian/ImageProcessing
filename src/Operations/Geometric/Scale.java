package Operations.Geometric;

import Utils.Utils;
import Utils.Image;

public class Scale {
	public static Image bilinear(Image a, float s) {	
		return bilinear(a, s, s);
	}
 
    private static float lerp(float s, float e, float t) {
        return s + (e - s) * t;
    }
 
    private static float blerp(final Float c00, float c10, float c01, float c11, float tx, float ty) {
        return lerp(lerp(c00, c10, tx), lerp(c01, c11, tx), ty);
    }
	
	 public static Image bilinear(Image a, float sx, float sy) {
	        int newW = (int) (a.getW() * sx);
	        int newH = (int) (a.getH() * sy);
	        Image result = new Image(newW, newH);
	        for (int x = 0; x < newW; ++x) {
	            for (int y = 0; y < newH; ++y) {
	                float gx = ((float) x) / newW * (a.getWidth() - 1);
	                float gy = ((float) y) / newH * (a.getHeight() - 1);
	                int gxi = (int) gx;
	                int gyi = (int) gy;
	                int c00 = a.getP(gxi, gyi);
	                int c10 = a.getP(gxi + 1, gyi);
	                int c01 = a.getP(gxi, gyi + 1);
	                int c11 = a.getP(gxi + 1, gyi + 1);
	                
	                int r = ((int) blerp((float) Utils.red(c00), Utils.red(c10), Utils.red(c01), Utils.red(c11), gx - gxi, gy - gyi)) ;
	                int g = ((int) blerp((float) Utils.green(c00), Utils.green(c10), Utils.green(c01), Utils.green(c11), gx - gxi, gy - gyi)) ;
	                int b = ((int) blerp((float) Utils.blue(c00), Utils.blue(c10), Utils.blue(c01), Utils.blue(c11), gx - gxi, gy - gyi));

	                int resultRGB = r << 16 | g << 8 | b;
	                result.setP(x, y, resultRGB);
	            }
	        }
	        return result;
	    }
	 
	 public static Image bilinearPixel(Image a, int sx, int sy) {
		 	
	        int newW = (int) sx;
	        int newH = (int) sy;
	        Image result = new Image(newW, newH);
	        for (int x = 0; x < newW; ++x) {
	            for (int y = 0; y < newH; ++y) {
	                float gx = ((float) x) / newW * (a.getWidth() - 1);
	                float gy = ((float) y) / newH * (a.getHeight() - 1);
	                int gxi = (int) gx;
	                int gyi = (int) gy;
	                int c00 = a.getP(gxi, gyi);
	                int c10 = a.getP(gxi + 1, gyi);
	                int c01 = a.getP(gxi, gyi + 1);
	                int c11 = a.getP(gxi + 1, gyi + 1);
	                
	                int r = ((int) blerp((float) Utils.red(c00), Utils.red(c10), Utils.red(c01), Utils.red(c11), gx - gxi, gy - gyi)) ;
	                int g = ((int) blerp((float) Utils.green(c00), Utils.green(c10), Utils.green(c01), Utils.green(c11), gx - gxi, gy - gyi)) ;
	                int b = ((int) blerp((float) Utils.blue(c00), Utils.blue(c10), Utils.blue(c01), Utils.blue(c11), gx - gxi, gy - gyi));

	                int resultRGB = r << 16 | g << 8 | b;
	                result.setP(x, y, resultRGB);
	            }
	        }
	        return result;
	    }

}
