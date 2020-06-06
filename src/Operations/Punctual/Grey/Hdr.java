package Operations.Punctual.Grey;

import Utils.Image;

public class Hdr {
	public static Image hdr(Image a) {
		Image result = new Image(a.getW(),a.getH());
		for(int j = 0; j < a.getH(); j++) {
			for(int i = 0; i <a.getW(); i++) {
				
				int c = a.getP(i, j);
				int r = c >> 16 & 0xff;
				int g = c >> 8 & 0xff;
				int b = c & 0xff;
				
				float corR = (0.2627f*r + 0.6780f*g + 0.0593f*b);
				
				int corRI = (int) Math.round(corR);
				corRI = corRI << 16 | corRI << 8 | corRI;
				
				result.setP(i, j, corRI);
			}
			
		}
		return result;
	}
}
