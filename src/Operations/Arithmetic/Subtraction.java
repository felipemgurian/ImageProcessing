package Operations.Arithmetic;

import Utils.Color;
import Utils.Image;

public class Subtraction {
	public static Image sub(Image a, Image b){
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

                int resR = ra - rb<0?0:ra-rb;
                int resG = ga - gb<0?0:ga-gb;
                int resB = ba - bb<0?0:ba-bb;

                int corResult = resR << 16 | resG << 8| resB;
                result.setP(i, j, corResult);
            }
        }
        return result;
    }

    public static Image sub(Image a, int cor){
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

                int resR = ra - r<0?0:ra-r;
                int resG = ga - g<0?0:ga-g;
                int resB = ba - b<0?0:ba-b;

                int corResult = resR << 16 | resG << 8| resB;
                result.setP(i, j, corResult);
            }
        }
        return result;
    }
}