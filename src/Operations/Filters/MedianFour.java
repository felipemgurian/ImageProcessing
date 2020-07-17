package Operations.Filters;

import Utils.Utils;
import Utils.Image;
import java.util.Arrays;

public class MedianFour {
	public static Image medianFour(Image a) {
		Image result = new Image(a.getW(), a.getH());
		
		for(int j = 0; j < a.getH(); j++) {
			for(int i = 0; i < a.getW(); i++) {		
				int[] arrayR = {Utils.red(a.getP(i,j-1)),Utils.red(a.getP(i, j)),Utils.red(a.getP(i, j+1)),Utils.red(a.getP(i-1, j)),Utils.red(a.getP(i+1, j))};
				int[] arrayG = {Utils.green(a.getP(i,j-1)),Utils.green(a.getP(i, j)),Utils.green(a.getP(i, j+1)),Utils.green(a.getP(i-1, j)),Utils.green(a.getP(i+1, j))};
				int[] arrayB = {Utils.blue(a.getP(i,j-1)),Utils.blue(a.getP(i, j)),Utils.blue(a.getP(i, j+1)),Utils.blue(a.getP(i-1, j)),Utils.blue(a.getP(i+1, j))};
				
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
