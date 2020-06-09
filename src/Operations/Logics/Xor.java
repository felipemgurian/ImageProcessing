package Operations.Logics;

import Utils.Color;
import Utils.Image;

public class Xor {
	public static Image xor(Image a, Image b) {
		Image result = new Image(Math.max(a.getW(), b.getW()), Math.max(a.getH(), b.getH()));
		for(int j = 0; j < result.getH(); j++) {
			for(int i = 0; i < result.getW(); i++) {
				int cora = a.getP(i,j);
				int ra = Color.red(cora);
				int ga = Color.green(cora);
				int ba = Color.blue(cora);
				
				int corb = b.getP(i,j);
				int rb = Color.red(corb);
				int gb = Color.green(corb);
				int bb = Color.blue(corb);

				int resR = ra ^ rb;
				int resG = ga ^ gb;
				int resB = ba ^ bb;

				int corResult = resR << 16 | resG << 8 | resB;

				result.setP(i,j,corResult);
			}
		}
		return result;
	}
	
	public static Image xor(Image a, int cor) {
		Image result = new Image(a.getW(), a.getH());
		
        int r   = Color.red(cor);
        int g   = Color.green(cor);
        int b   = Color.blue(cor);
        
		for(int j = 0; j < result.getH(); j++) {
			for(int i = 0; i < result.getW(); i++) {
				int cora = a.getP(i,j);
				int ra = Color.red(cora);
				int ga = Color.green(cora);
				int ba = Color.blue(cora);

				int resR = ra ^ r;
				int resG = ga ^ g;
				int resB = ba ^ b;

				int corResult = resR << 16 | resG << 8 | resB;

				result.setP(i,j,corResult);
			}
		}
		return result;
	}
}
