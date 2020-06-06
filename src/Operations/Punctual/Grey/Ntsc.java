package Operations.Punctual.Grey;

import Utils.Image;

public class Ntsc {
	public static Image ntsc(Image a) {
		Image result = new Image(a.getW(),a.getH());
		for(int j = 0; j < a.getH(); j++) {
			for(int i = 0; i <a.getW(); i++) {
				
				int c = a.getP(i, j);
				int r = c >> 16 & 0xff;
				int g = c >> 8 & 0xff;
				int b = c & 0xff;
				
				float corR = (0.299f*r + 0.587f*g + 0.114f*b);
				
				int corRI = (int) Math.round(corR);
				corRI = corRI << 16 | corRI << 8 | corRI;
				
				result.setP(i, j, corRI);
			}
		}
		return result;
	}	
}
