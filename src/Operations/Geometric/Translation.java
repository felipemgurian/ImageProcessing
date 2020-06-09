package Operations.Geometric;

import Utils.Image;

public class Translation {
	public static Image translation(Image a, int tx, int ty) {
		Image result = new Image(a.getW()+Math.abs(tx), a.getH()+Math.abs(ty));
		
		for(int j = 0; j < a.getH(); j++) {
			for(int i = 0; i< a.getW(); i++) {
				
				int x = 0;
				int y = 0;
				
				if(tx < 0) {
					x = i;
				}
				
				if(ty < 0) {
					y = j;
				}
				
				if(tx > 0) {
					x = i+tx;
				}
				
				if(ty > 0) {
					y = j+ty;
				}
								
				result.setP(x,y, a.getP(i, j));
			}
		}
		
		return result;
	}
}
