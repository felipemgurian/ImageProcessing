package Operations.Arithmetic;

import Utils.Image;
import Utils.Utils;
public class Blending {	
	public static Image blending(Image a, Image b, float pA) {
		Image result = new Image(Math.max(a.getW(), b.getW()), Math.max(a.getH(), b.getH()));
		float pB = 1 - pA;
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
				
				int resR = Math.round(pA*ra + pB*rb);
				int resG = Math.round(pA*ga + pB*gb);
				int resB = Math.round(pA*ba + pB*bb);
				
				int corResult = resR << 16 | resG << 8 | resB;
				
				result.setP(i, j, corResult);
			}
		}
		return result;
	}	
}
