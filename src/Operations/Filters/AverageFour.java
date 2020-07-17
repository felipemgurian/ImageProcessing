package Operations.Filters;

import Utils.Image;
import Utils.Utils;

public class AverageFour {
	public static Image averageFour(Image a) {
		Image result = new Image(a.getW(), a.getH());
		
		for(int j = 0; j < a.getH(); j++) {
			for(int i = 0; i < a.getW(); i++) {
				int acumR = Utils.red(a.getP(i,j-1)) + Utils.red(a.getP(i, j)) + Utils.red(a.getP(i, j+1)) + Utils.red(a.getP(i-1, j)) + Utils.red(a.getP(i+1, j));
				int acumG = Utils.green(a.getP(i,j-1)) + Utils.green(a.getP(i, j)) + Utils.green(a.getP(i, j+1)) + Utils.green(a.getP(i-1, j)) + Utils.green(a.getP(i+1, j));
				int acumB = Utils.blue(a.getP(i,j-1)) + Utils.blue(a.getP(i, j)) + Utils.blue(a.getP(i, j+1)) + Utils.blue(a.getP(i-1, j)) + Utils.blue(a.getP(i+1, j));
				acumR /= 5;
				acumG /= 5;
				acumB /= 5;
				
				result.setP(i, j, acumR<<16|acumG<<8|acumB);
			}
		}
		
		return result;
	}
}
