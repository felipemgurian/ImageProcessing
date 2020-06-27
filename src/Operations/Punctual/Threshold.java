package Operations.Punctual;

import Utils.Image;

public class Threshold {
	public static Image threshold(Image a, int maskSize, int C){
	        
	        int width = a.getW();
	        int height = a.getH();
	        
	        int output[] = new int[width * height];
	        
	        int blue, mean, count;
	        
	        for(int j = 0; j < height; j++){
	            for(int i = 0; i < width; i++){
	            	int cora = a.getP(i, j);
					int ba = cora & 0xff;
					
	                blue = 0;
	                count = 0;
	                for(int r = j - (maskSize / 2); r <= j + (maskSize / 2); r++){
	                    for(int c = i - (maskSize / 2); c <= i + (maskSize / 2); c++){
	                        if(r < 0 || r >= height || c < 0 || c >= width){
	                            continue;
	                        }else{
	                            try{
	                            	int corat = a.getP(c, r);
	                            	int bat = corat & 0xff;
	                                blue += bat;
	                                count++;
	                            }catch(ArrayIndexOutOfBoundsException e){
	                            }
	                        }
	                    }
	                }
	                
	                mean = blue/count - C;
	                
	                if(ba >= mean){
	                    output[i+j*width] = 0xffffffff; 
	                }else{
	                    output[i+j*width] = 0xff000000;   
	                }
	            }
	        }
	        
	        for(int j = 0; j < height; j++){
	            for(int i = 0; i < width; i++){
	                a.setP(i, j, output[i+j*width]);
	            }
	        }
	        return a;
	    }
	
}
