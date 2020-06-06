package Utils;

import java.awt.Component;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

public class Image extends Component {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = (long)Math.random();
	BufferedImage img;
	
	public Image() {
		img = new BufferedImage(800, 600, BufferedImage.TYPE_INT_RGB);
		compSize();
	}
	
	public Image(int width, int height) {
		img = new BufferedImage(width, height, BufferedImage.TYPE_INT_RGB);
		compSize();
	}
	
	public Image(File f) throws IOException {
		img = ImageIO.read(f);
		compSize();
	}
	
	public Image(int width, int height, int color) {
		img = new BufferedImage(width, height, BufferedImage.TYPE_INT_RGB);
		for(int j = 0; j < height; j++){
			for(int i = 0; i < width; i++) {
				img.setRGB(i, j, color);
			}	
		}
		compSize();
	}
	
	public int getP(int x, int y){
		if(x >= 0 && x < img.getWidth() && y >= 0 & y < img.getHeight())
			return img.getRGB(x, y);
		return 0;
	}

	public void setP(int x, int y, int cor){
		if(x >= 0 && x < img.getWidth() && y >= 0 & y < img.getHeight() )
		img.setRGB(x, y, cor); 
	}

	public int getW() {
		return img.getWidth();
	}

	public int getH(){
		return img.getHeight();
	}

	@Override
	public void paint(Graphics g) {
		g.drawImage(img,0,0,this);
	}
	
    private void compSize(){
        setPreferredSize(new Dimension(img.getWidth(), img.getHeight()));
        setSize(img.getWidth(), img.getHeight());
    }
}
