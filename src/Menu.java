
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Toolkit;
import java.net.URL;
import java.util.ArrayList;

import javax.swing.JFrame;
import javax.swing.JTextField;

import Utils.Image;

//My Libs :)



public class Menu extends JFrame {

	private static final long serialVersionUID = 1L;
	
	/**
	 * Colors Variables
	 */
	
	private static Color menuBarColor  = new Color(98,98,100);
	private Color backgroundColor   = new Color(98,98,100);
	private static Color sideBarColor      = new Color(98,98,100);
	private static Color imageContentColor = new Color(52,51,49);
	
	/**
	 * Main Method
	 */
	
	public static void main(String[] args) {
		
		ArrayList<Image> imagesList = new ArrayList<Image>();
		
		//Create Menu
		Menu menu = new Menu();
		Dimension size = menu.getSize();
		
		//Create Header
		Header header = new Header(menuBarColor, size);
		header.init();
		
		//Create Content
		Content content = new Content(imageContentColor, size);
		content.init();
		
		//Create Layers
		Layers layers = new Layers(size);
		layers.init();
	
		//Listeners
		header.listen(content, layers, imagesList);
		
		//Add Header
		menu.add(header);
		menu.setJMenuBar(header);
		
		//Add Content
		menu.add(content);
		
		//Add Layers
		menu.add(layers, BorderLayout.CENTER);
		
		menu.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		menu.addComponentListener(new java.awt.event.ComponentAdapter(){
            @Override
            public void componentResized(java.awt.event.ComponentEvent evt)
            {
                Dimension d = menu.getSize();
                content.reload(d);
                layers.reload(d);
                for(int i = 0; i < imagesList.size(); i++) {
                	imagesList.get(i).setLocation(content.getW()/2 - imagesList.get(i).getW()/2, content.getH()/2 - imagesList.get(i).getH()/2);
                }
            }
        });
		
		menu.repaint();
		
	}
	
	/**
	 * Main Menu
	 */
	
	public Menu() {
		Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
		getContentPane().setBackground(backgroundColor);
		getContentPane().setForeground(Color.BLACK);
		getContentPane().setEnabled(false);
		getContentPane().setLayout(null);		
	    
		/**
		 * JFRAME CONFIG
		 */
	    
		this.setTitle("P2 Sistemas Multimidia e Jogos Digitais - 2020");
		
		URL url = this.getClass().getResource("Resources\\Img\\Icon.png");
		java.awt.Image titleImage = Toolkit.getDefaultToolkit().getImage(url);
		this.setIconImage(titleImage);
		
		this.pack();
	    this.setLocationRelativeTo(null);
	    this.setSize(1200,700);
	    this.setLocation(dim.width/2-this.getSize().width/2, dim.height/2-this.getSize().height/2);
	    //this.setExtendedState(JFrame.MAXIMIZED_BOTH);
		this.setVisible(true);
	}
}
