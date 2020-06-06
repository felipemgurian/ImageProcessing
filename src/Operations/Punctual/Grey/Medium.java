package Operations.Punctual.Grey;

import Utils.Image;

public class Medium {
	public static Image medium(Image a) {
		Image result = new Image(a.getW(),a.getH());
		for(int j = 0; j < a.getH(); j++) {
			for(int i = 0; i <a.getW(); i++) {
				
				int c = a.getP(i, j);
				int r = c >> 16 & 0xff;
				int g = c >> 8 & 0xff;
				int b = c & 0xff;
				
				float media = (r + g + b) / 3.0f;
				
				int mediaI = (int) Math.round(media);
				mediaI = mediaI << 16 | mediaI << 8 | mediaI;
				
				result.setP(i, j, mediaI);
			}
			
		}
		return result;
	}
}
