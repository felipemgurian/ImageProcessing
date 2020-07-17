package Operations.Filters;

import Utils.Utils;
import Utils.Image;

public class Roberts {
	public static Image roberts(Image a) {
		Image result = new Image(a.getW(),a.getH());
		Kernel kx = new Kernel(2,2,2,2);
		Kernel ky = new Kernel(2,2,2,2);
		
		Image gx = null;
		Image gy = null;
		
		kx.k[0][0] = 1;
		kx.k[0][1] = 0;
		kx.k[1][0] = 0;
		kx.k[1][1] = -1;
		
		ky.k[0][0] = 0;
		ky.k[0][1] = 1;
		ky.k[1][0] = -1;
		ky.k[1][1] = 0;

		
		gx = Convolve.convolve(a, kx);
		gy = Convolve.convolve(a, ky);
		
		for(int j = 0; j < gx.getH(); j++) {
			for(int i = 0; i < gx.getW(); i++) {
				int pixelGx = gx.getP(i, j);
				int pixelGy = gy.getP(i, j);
				
				int resR = (int) Math.sqrt(Math.pow(Utils.red(pixelGx),2) + Math.pow(Utils.red(pixelGy),2));
				int resG = (int) Math.sqrt(Math.pow(Utils.green(pixelGx),2) + Math.pow(Utils.green(pixelGy),2));
				int resB = (int) Math.sqrt(Math.pow(Utils.blue(pixelGx), 2) + Math.pow(Utils.blue(pixelGy), 2));
				
				int resultRGB = resR << 16 | resG << 8 | resB;
				result.setP(i, j, resultRGB);
			}	
		}
		return result;
	}
}
