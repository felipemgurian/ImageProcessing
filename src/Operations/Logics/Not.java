package Operations.Logics;

import Utils.Image;

public class Not {
	public static Image not(Image a) {
        Image result = new Image(a.getW(), a.getH());
		
		 for(int j = 0; j < result.getH(); j++){
	            for(int i = 0; i < result.getW(); i++){
	            	
	            	int cora = a.getP(i, j);	                
	                int corR = ~cora;
	                
	                result.setP(i, j, corR);
	            }
		 }
		return result;
	}
}
