package Operations.Punctual.Grey;

import Utils.Image;

public class Hdtv {
	public static Image hdtv(Image a) {
		Image result = new Image(a.getW(),a.getH());
		for(int j = 0; j < a.getH(); j++) {
			for(int i = 0; i <a.getW(); i++) {
				
				int c = a.getP(i, j);
				int r = c >> 16 & 0xff;
				int g = c >> 8 & 0xff;
				int b = c & 0xff;
				
				float corR = (0.2126f*r + 0.7152f*g + 0.0722f*b);
				
				int corRI = (int) Math.round(corR);
				corRI = corRI << 16 | corRI << 8 | corRI;
				
				result.setP(i, j, corRI);
			}
			
		}
		return result;
	}
}
