import java.awt.Dimension;
import java.util.ArrayList;
import javax.swing.JScrollPane;

import Utils.Image;

public class Layers extends JScrollPane{
	
	private static final long serialVersionUID = 1L;
	Dimension size;
	ArrayList<Image> imgList = new ArrayList<Image>();

	
	public Layers(Dimension size) {
		super();
		this.size = size;
	}
	 
	public void init() {
		this.setBounds((int) size.getWidth() * 82 / 100, 11, (int) size.getWidth() * 16 / 100, (int) size.getHeight() * 88 / 100);
		this.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
	}
	
	public void reload(Dimension size) {
		this.size = size;
		this.setBounds((int) size.getWidth() * 82 / 100, 11, (int) size.getWidth() * 16 / 100, (int) size.getHeight() * 88 / 100);
		this.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
		this.repaint();
	}
	
	
}
