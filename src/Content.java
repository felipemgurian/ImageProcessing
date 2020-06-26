import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.Graphics;

import javax.swing.BoxLayout;
import javax.swing.JPanel;

import Utils.Image;

public class Content extends JPanel {

	private static final long serialVersionUID = 1L;
	Color color;
	Dimension size;
	int width;
	int height;
	
	public Content(Color color, Dimension size) {
		super();
		this.color = color;
		this.size = size;
		this.width = (int) size.getWidth() * 80 / 100;
		this.height = (int) size.getHeight() * 88 / 100;
	}
	
	public void init(){
		this.setBounds((int) size.getWidth() * 1 / 100, 11, width, height);
		this.setBackground(color);
		this.setLayout(new BoxLayout(this, BoxLayout.X_AXIS));
	}
	
	public void reload(Dimension size) {
		this.size = size;
		this.width = (int) size.getWidth() * 80 / 100;
		this.height = (int) size.getHeight() * 88 / 100;
		this.setBounds((int) size.getWidth() * 1 / 100, 11, width, height);
		this.repaint();
	}
	
	public int getW() {
		return this.width;
	}
	
	public int getH() {
		return this.height;
	}

	
}
