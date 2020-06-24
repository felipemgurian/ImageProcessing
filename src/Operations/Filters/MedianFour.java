package Operations.Filters;

import Utils.Color;
import Utils.Image;
import java.util.Arrays;

public class MedianFour {
	public static Image medianFour(Image a) {
		Image result = new Image(a.getW(), a.getH());
		
		for(int j = 0; j < a.getH(); j++) {
			for(int i = 0; i < a.getW(); i++) {		
				int[] arrayR = {Color.red(a.getP(i,j-1)),Color.red(a.getP(i, j)),Color.red(a.getP(i, j+1)),Color.red(a.getP(i-1, j)),Color.red(a.getP(i+1, j))};
				int[] arrayG = {Color.green(a.getP(i,j-1)),Color.green(a.getP(i, j)),Color.green(a.getP(i, j+1)),Color.green(a.getP(i-1, j)),Color.green(a.getP(i+1, j))};
				int[] arrayB = {Color.blue(a.getP(i,j-1)),Color.blue(a.getP(i, j)),Color.blue(a.getP(i, j+1)),Color.blue(a.getP(i-1, j)),Color.blue(a.getP(i+1, j))};
				
				Arrays.sort(arrayR);
				int medianR = arrayR[arrayR.length/2];
				Arrays.sort(arrayG);
				int medianG = arrayG[arrayG.length/2];
				Arrays.sort(arrayB);
				int medianB = arrayB[arrayB.length/2];
				
				result.setP(i, j, medianR<<16|medianG<<8|medianB);
			}
		}
		
		return result;
	}
}
