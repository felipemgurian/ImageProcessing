package Operations.Arithmetic;

import Utils.Color;
import Utils.Image;

public class Division {
	public static Image div(Image a, Image b){
        Image result = new Image(Math.max(a.getW(), b.getW()),Math.max(a.getH(), b.getH()));
        
        for(int j = 0; j < result.getH(); j++){
            for(int i = 0; i < result.getW(); i++){
                int cora = a.getP(i, j);
                int ra   = Color.red(cora);
                int ga   = Color.green(cora);
                int ba   = Color.blue(cora);

                int corb = b.getP(i,j);
                int rb   = corb >> 16 & 0xff;
                int gb   = corb >> 8  & 0xff;
                int bb   = corb       & 0xff;
                        
                int resR = rb > 0 ? ra/rb : ra;       
                int resG = gb > 0 ? ga/gb : ga;
                int resB = bb > 0 ? ba/bb : ba;
              
                int corResult = resR << 16 | resG << 8| resB;
                result.setP(i, j, corResult);
            }
        }
        return result;
    }

    public static Image div(Image a, int cor){
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

                int resR = r > 0 ? ra/r : ra;       
                int resG = g > 0 ? ga/g : ga;
                int resB = b > 0 ? ba/b : ba;
              
                int corResult = resR << 16 | resG << 8| resB;
                result.setP(i, j, corResult);
            }
        }
        return result;
    }
}
