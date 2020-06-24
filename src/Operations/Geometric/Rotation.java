package Operations.Geometric;

import Utils.Image;

public class Rotation {
	public static Image rotation(Image a, int alpha, int cx, int cy) {		
		return rotation(a, Math.toRadians(alpha),  cx,  cy);
	}
	
	public static Image rotation(Image a, double radians, int cx, int cy) {
		Image result = new Image(a.getW(), a.getH());
		
		for(int j = 0; j < a.getH(); j++) {
			for(int i = 0; i < a.getW(); i++) {
				
				int ni = i - cx;
				int nj = j - cy;
				
				int x = (int) Math.round(ni * Math.cos(radians) + nj * Math.sin(radians));
				int y = (int) Math.round(-ni * Math.sin(radians) + nj * Math.cos(radians));
				
				int nx = x + cx;
				int ny = y + cy;
				
				result.setP(nx, ny, a.getP(i,j));
			}
		}
		
		return result;
	}
}
