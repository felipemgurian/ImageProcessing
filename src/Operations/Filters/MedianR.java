package Operations.Filters;

import java.util.ArrayList;
import java.util.Collections;
import Utils.Color;
import Utils.Image;

public class MedianR {
	public static Image medianR(Image a, int r) {
		Image result = new Image(a.getW(), a.getH());
		
		for(int j = 0; j < a.getH(); j++) {
			for(int i = 0; i < a.getW(); i++) {		
				ArrayList<Integer> arrayR = new ArrayList<Integer>();
				ArrayList<Integer> arrayG = new ArrayList<Integer>();
				ArrayList<Integer> arrayB = new ArrayList<Integer>();
				
				for(int x = 0; x < r; x++) {
					for(int y = 0; y < r; y++) {
						arrayR.add((Color.red(a.getP(i + x, j + y))));
						arrayG.add((Color.green(a.getP(i + x, j + y))));
						arrayB.add((Color.blue(a.getP(i + x, j + y))));
					}
				}
				
				Collections.sort(arrayR);
				int medianR = (int) arrayR.size() % 2 == 0 ? (arrayR.get(arrayR.size()/2)+arrayR.get(arrayR.size()/2+1))/2 : arrayR.get(arrayR.size()/2);
				Collections.sort(arrayG);
				int medianG = (int) arrayG.size() % 2 == 0 ? (arrayG.get(arrayG.size()/2)+arrayG.get(arrayG.size()/2+1))/2 : arrayG.get(arrayG.size()/2);
				Collections.sort(arrayB);
				int medianB = (int) arrayB.size() % 2 == 0 ? (arrayB.get(arrayB.size()/2)+arrayB.get(arrayB.size()/2+1))/2 : arrayB.get(arrayB.size()/2);
				
				result.setP(i, j, medianR<<16|medianG<<8|medianB);
			}
		}
		
		return result;
	}
}
