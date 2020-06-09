package Operations.Filters;

import Utils.Image;
import Utils.Color;

public class AverageFour {
	public static Image averageFour(Image a) {
		Image result = new Image(a.getW(), a.getH());
		
		for(int j = 0; j < a.getH(); j++) {
			for(int i = 0; i < a.getW(); i++) {
				int acumR = Color.red(a.getP(i,j-1)) + Color.red(a.getP(i, j)) + Color.red(a.getP(i, j+1)) + Color.red(a.getP(i-1, j)) + Color.red(a.getP(i+1, j));
				int acumG = Color.green(a.getP(i,j-1)) + Color.green(a.getP(i, j)) + Color.green(a.getP(i, j+1)) + Color.green(a.getP(i-1, j)) + Color.green(a.getP(i+1, j));
				int acumB = Color.blue(a.getP(i,j-1)) + Color.blue(a.getP(i, j)) + Color.blue(a.getP(i, j+1)) + Color.blue(a.getP(i-1, j)) + Color.blue(a.getP(i+1, j));
				acumR /= 5;
				acumG /= 5;
				acumB /= 5;
				
				result.setP(i, j, acumR<<16|acumG<<8|acumB);
			}
		}
		
		return result;
	}
}
