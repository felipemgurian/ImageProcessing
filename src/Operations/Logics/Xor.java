package Operations.Logics;

import Utils.Utils;
import Utils.Image;

public class Xor {
	public static Image xor(Image a, Image b) {
		Image result = new Image(Math.max(a.getW(), b.getW()), Math.max(a.getH(), b.getH()));
		for(int j = 0; j < result.getH(); j++) {
			for(int i = 0; i < result.getW(); i++) {
				int cora = a.getP(i,j);
				int ra = Utils.red(cora);
				int ga = Utils.green(cora);
				int ba = Utils.blue(cora);
				
				int corb = b.getP(i,j);
				int rb = Utils.red(corb);
				int gb = Utils.green(corb);
				int bb = Utils.blue(corb);

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
		
        int r   = Utils.red(cor);
        int g   = Utils.green(cor);
        int b   = Utils.blue(cor);
        
		for(int j = 0; j < result.getH(); j++) {
			for(int i = 0; i < result.getW(); i++) {
				int cora = a.getP(i,j);
				int ra = Utils.red(cora);
				int ga = Utils.green(cora);
				int ba = Utils.blue(cora);

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
