
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;
import java.net.URL;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JList;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.filechooser.FileNameExtensionFilter;

//My Libs :)
import Utils.Image;
import Operations.Filters.GaussianBlur;
import Operations.Geometric.Rotation;
import Operations.Geometric.Scale;
import Operations.Geometric.Translation;


public class Menu extends JFrame {

	private static final long serialVersionUID = 1L;
	private JTextField txtLayers;
	
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
		header.listenerMenuOpen(content, layers);
		
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
            }
        });
		
		menu.repaint();
		
	}
	
	/**
	 * Main Menu
	 */
	
	public Menu() {
	 
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
	    this.setExtendedState(JFrame.MAXIMIZED_BOTH);
		this.setVisible(true);
	}
}
