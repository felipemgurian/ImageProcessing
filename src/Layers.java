import java.awt.Color;
import java.awt.Dimension;
import java.util.ArrayList;

import javax.swing.JList;
import javax.swing.JPanel;
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
		this.setBounds((int) size.getWidth() * 82 / 100, 11, (int) size.getWidth() * 16 / 100, 668);
		this.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
	}
	
	public void reload(Dimension size) {
		this.size = size;
		this.setBounds((int) size.getWidth() * 82 / 100, 11, (int) size.getWidth() * 16 / 100, 668);
		this.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
		this.repaint();
	}
	
	public void addLayer(Image a) {
		imgList.add(a);
	}
	
	private JPanel layer(int index) {
		JPanel layer = new JPanel();
		layer.setBounds((int) size.getWidth() * 82 / 100, index * 20, 20, 20);
		layer.setBackground(Color.BLACK);
		layer.repaint();
		return layer;
	}
	
	public void loadLayers(){
		
		for(int i = 0; i < imgList.size(); i++) {
			this.add(layer(i));
			System.out.println(imgList.get(i));
		}
		
		
	}
}
