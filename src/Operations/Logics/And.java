package Operations.Logics;

import Utils.Image;
import Utils.Color;
public class And {
	public static Image and(Image a, Image b) {
        Image result = new Image(Math.max(a.getW(), b.getW()),Math.max(a.getH(), b.getH()));
		
		 for(int j = 0; j < result.getH(); j++){
	            for(int i = 0; i < result.getW(); i++){
	            	//Separa os canais de cor de A
	            	int cora = a.getP(i, j);
	            	int ra   = Color.red(cora);
	                int ga   = Color.green(cora);
	                int ba   = Color.blue(cora);
	                
	            	//Separa os canais de cor de B
	                int corb = b.getP(i,j);
	                int rb   = Color.red(corb);
	                int gb   = Color.green(corb);
	                int bb   = Color.blue(corb);

	                //Pra cada canal faz Ra & Rb
	                int resR = ra & rb;
	                int resG = ga & gb;
	                int resB = ba & bb;
	                
	                //Junta os resultados e salva o pixel na Image resultante
	                int corR = resR << 16 | resG << 8 | resB;
	                result.setP(i, j, corR);
	            }
		 }
		return result;
	}
	
	public static Image and(Image a, int cor) {
        Image result = new Image(a.getW(), a.getH());
        
        int r   = Color.red(cor);
        int g   = Color.green(cor);
        int b   = Color.blue(cor);
               
		for(int j = 0; j < result.getH(); j++){
	            for(int i = 0; i < result.getW(); i++){
	            	
	            	int cora = a.getP(i, j);
	            	int ra   = Color.red(cora);
	                int ga   = Color.green(cora);
	                int ba   = Color.blue(cora);

	                int resR = ra & r;
	                int resG = ga & g;
	                int resB = ba & b;
	                
	                int corR = resR << 16 | resG << 8 | resB;
	                result.setP(i, j, corR);
	            }
		 }
		return result;
	}
}
