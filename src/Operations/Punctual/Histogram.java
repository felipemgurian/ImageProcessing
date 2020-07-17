package Operations.Punctual;

import Utils.Utils;
import Utils.Image;

public class Histogram {
	
    public static Image histogram(Image a) {
        Image result = new Image(256, 150);
        int[] cor = new int[256];
        int max = 0;
        int linhaCor = 255 << 16 | 255 << 8 | 255;
        
        for(int j = 0; j < a.getH(); j++) {
            for(int i = 0; i < a.getW(); i++) {
                
                // Somando 1 na posicao referente a cor do pixel lido
                int pixel = Utils.red(a.getP(i, j));
                cor[pixel]++;
                
                // Condicao para pegar o maior valor do vetor cor[pixel]
                if(cor[pixel] > max) {
                    max = cor[pixel];
                }
                
                // Conjunto de lacos para plotar o histograma
                for(int x = 0; x < result.getW(); x++) {
                    int mapVar = map(cor[x], max, 150);
                    result.setP(x, mapVar, linhaCor); 
                    
                    for(int y = mapVar; y < result.getH(); y++) {
                        result.setP(x, y, linhaCor);
                    }
                }
                
            }
        }
        return result;
    }
    
    public static int map(int valor, int valorMax, int num) {
		int valorMap = (((-1*num)*valor)/valorMax) + num;
		return valorMap; 
	}
}
