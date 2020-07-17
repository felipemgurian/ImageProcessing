
import java.awt.Dimension;

import javax.swing.JPanel;

public class Layers extends JPanel {
	
	private static final long serialVersionUID = 1L;
	Dimension size;
	
	public Layers(Dimension size) {
		super();
		this.size = size;
		
	}
	 
	public void init() {
		this.setBounds((int) size.getWidth() * 82 / 100, 11, (int) size.getWidth() * 16 / 100, (int) size.getHeight() * 88 / 100);
	}
	
	public void reload(Dimension size) {
		this.size = size;
		this.setBounds((int) size.getWidth() * 82 / 100, 11, (int) size.getWidth() * 16 / 100, (int) size.getHeight() * 88 / 100);
	}
	
}
