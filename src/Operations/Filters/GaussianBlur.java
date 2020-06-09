package Operations.Filters;

import Utils.Image;

public class GaussianBlur {
	
	public static Image gaussianBlur(Image a, int r, float sigma, float amp) {
		Kernel k = new Kernel(r);
		gauss(k, 1.0f, 1.1f);
	
		Image result = Convolve.convolve(a, k);
		return result;
	}
	
	private static Kernel gauss(Kernel k, float sigma, float amp) {
		float uini = -2;
		float uend = 2;
		
		for(int i = 0; i< k.k.length; i++){
			for(int j = 0; j < k.k[0].length; j++){
				float x = (uend-uini)*i/(float)(k.k.length-1) + uini;
				float y = (uini-uend)*j/(float)(k.k[0].length-1) +uend;
				k.k[i][j] = (float) (amp*Math.exp(-(x*x+y*y)/sigma));
			}
		}
		return k;
	}
	
	//1:08:29 minutos video
}
