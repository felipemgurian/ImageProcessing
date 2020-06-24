package Operations.Filters;

import Utils.Color;
import Utils.Image;

public class AverageR {
	public static Image averageR(Image a, int r) {
		Image result = new Image(a.getW(), a.getH());
		
		for(int j = 0; j < a.getH(); j++) {
			for(int i = 0; i < a.getW(); i++) {
				
			    int acumR = 0;
                int acumG = 0;
                int acumB = 0; 
				
				for(int x = 0; x < r; x++) {
					for(int y = 0; y < r; y++) {
						acumR = acumR + Color.red(a.getP(i + x, j + y));
                        acumG = acumG + Color.green(a.getP(i + x, j + y));
                        acumB = acumB + Color.blue(a.getP(i + x, j + y));
					}
				}
				
			    acumR = acumR / ((2*r+1) * (2*r+1));
                acumG = acumG / ((2*r+1) * (2*r+1));
                acumB = acumB / ((2*r+1) * (2*r+1));
                
                result.setP(i, j, acumR << 16 | acumG << 8 | acumB);
	                
			}
		}
		return result;
	}
}
