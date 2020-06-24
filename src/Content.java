import java.awt.Color;
import java.awt.Dimension;
import javax.swing.JPanel;

public class Content extends JPanel {

	private static final long serialVersionUID = 1L;
	Color color;
	Dimension size;
	
	public Content(Color color, Dimension size) {
		super();
		this.color = color;
		this.size = size;
	}
	
	public void init(){
		this.setBounds((int) size.getWidth() * 1 / 100, 11, (int) size.getWidth() * 80 / 100, 668);
		this.setBackground(color);
	}
	
	public void reload(Dimension size) {
		this.size = size;
		this.setBounds((int) size.getWidth() * 1 / 100, 11, (int) size.getWidth() * 80 / 100, 668);
		this.repaint();
	}
	
}
