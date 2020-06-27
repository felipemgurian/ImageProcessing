import java.awt.Color;
import java.awt.Dimension;
import java.io.File;
import java.io.IOException;
import javax.swing.JPanel;

import Operations.Geometric.Scale;
import Utils.Image;

public class Content extends JPanel {

	private static final long serialVersionUID = 1L;
	Color color;
	public Dimension size;
	int width;
	int height;
	
	public Content(Color color, Dimension size) {
		super();
		this.color = color;
		this.size = size;
		this.width = (int) size.getWidth() * 80 / 100;
		this.height = (int) size.getHeight() * 88 / 100;
		this.setLayout(null);
		
	}
	
	public void init(){
		this.setBounds((int) size.getWidth() * 1 / 100, 11, width, height);
		this.setBackground(color);
	}
	
	public void reload(Dimension size) {
		this.size = size;
		this.width = (int) size.getWidth() * 80 / 100;
		this.height = (int) size.getHeight() * 88 / 100;
		this.setBounds((int) width * 1 / 100, 11, width, height);
	}
	
	public int getW() {
		return this.width;
	}
	
	public int getH() {
		return this.height;
	}
	
}
