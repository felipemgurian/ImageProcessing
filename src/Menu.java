
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
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.filechooser.FileNameExtensionFilter;
import java.awt.Font;

//My Libs :)
import Utils.Image;
import Operations.Geometric.Translation;
import Operations.Logics.Not;

public class Menu extends JFrame {

	private static final long serialVersionUID = 1L;
	private JTextField txtLayers;
	private JFileChooser jfc;
	
	/**
	 * Colors Variables
	 */
	
	private Color menuBarColor      = new Color(98,98,100);
	private Color backgroundColor   = new Color(98,98,100);
	private Color sideBarColor      = new Color(98,98,100);
	private Color imageContentColor = new Color(52,51,49);
	
	/**
	 * Main Method
	 */
	
	public static void main(String[] args) {
		new Menu();
	}
	
	/**
	 * Main Menu
	 */
	
	public Menu() {
	    Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
		
		getContentPane().setBackground(backgroundColor);
		getContentPane().setForeground(Color.BLACK);
		getContentPane().setEnabled(false);
		getContentPane().setLayout(null);
		
		/**
		 * Central Content Panel
		 */
		
		JPanel contentPanel = new JPanel();
		contentPanel.setBounds(41, 11, 1078, 668);
		contentPanel.repaint();
		contentPanel.setBackground(imageContentColor);
		getContentPane().add(contentPanel);
		
		//Imagem estática para testes
		Image img = null;
		Image imgNot = null;
		try {
			img = new Image(new File("C:\\Users\\fgurian\\Pictures\\lena.jpg"));
			imgNot = Not.not(img);
		} catch (IOException e2) {
			// TODO Auto-generated catch block
			e2.printStackTrace();
		}
		contentPanel.add(imgNot, BorderLayout.CENTER);
        contentPanel.repaint();
        
		/**
		 * SIDE BAR
		 */
		
		JPanel sidePanel = new JPanel();
		sidePanel.setBackground(sideBarColor);
		sidePanel.setBounds(0, 11, 40,  668);
		getContentPane().add(sidePanel);
		sidePanel.setLayout(null);
		
		JButton btnBt = new JButton("");
		btnBt.setIcon(new ImageIcon(this.getClass().getResource("Resources\\Img\\Seta.png")));
		btnBt.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		
		btnBt.setForeground(Color.WHITE);
		btnBt.setBounds(10, 0, 20, 20);
		sidePanel.add(btnBt);
		
		JButton button = new JButton("");
		button.setIcon(new ImageIcon(this.getClass().getResource("Resources\\Img\\Lapiz.png")));
		button.setBounds(10, 40, 20, 20);
		sidePanel.add(button);
		
		JButton button_1 = new JButton("");
		button_1.setIcon(new ImageIcon(this.getClass().getResource("Resources\\Img\\Borracha.png")));
		button_1.setForeground(Color.WHITE);
		button_1.setBounds(10, 80, 20, 20);
		sidePanel.add(button_1);
		
		JButton button_2 = new JButton("");
		button_2.setIcon(new ImageIcon(this.getClass().getResource("Resources\\Img\\Lupa.png")));
		button_2.setForeground(Color.WHITE);
		button_2.setBounds(10, 120, 20, 20);
		sidePanel.add(button_2);
		
		JButton button_3 = new JButton("");
		button_3.setIcon(new ImageIcon(this.getClass().getResource("Resources\\Img\\Balde.png")));
		button_3.setForeground(Color.WHITE);
		button_3.setBounds(10, 160, 20, 20);
		sidePanel.add(button_3);
		
		
	    /**
	     * LAYERS PANEL
	     */
	    
		txtLayers = new JTextField();
		txtLayers.setHorizontalAlignment(SwingConstants.CENTER);
		txtLayers.setEditable(false);
		txtLayers.setText("Layers");
		txtLayers.setBounds(1127, 11, 213, 20);
		getContentPane().add(txtLayers);
		txtLayers.setColumns(10);
		
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(1127, 152, (int) (screenSize.width * 0.16), 526);
		getContentPane().add(scrollPane);
		
	    JPanel paneel2= new JPanel();
	    paneel2.setSize(new Dimension(400,400));
	    scrollPane.setViewportView(paneel2);
		
		/**
		 * TOP MENU BAR
		 */
		
	    JMenuBar menuBar = new JMenuBar();
	    menuBar.setBorderPainted(false);
	    menuBar.setBackground(menuBarColor);
	    setJMenuBar(menuBar);
	    
	    JMenu mnFile = new JMenu("File");
	    menuBar.add(mnFile);
	    
	    JMenuItem mntmNew = new JMenuItem("New");  
	    mnFile.add(mntmNew);
	    
	    JMenuItem mntmOpen = new JMenuItem("Open");
	    
	    mntmOpen.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e){
		     jfc = new JFileChooser();
		        jfc.setAcceptAllFileFilterUsed(false);
		        jfc.setFileFilter(new FileNameExtensionFilter("Image File", "jpg", "png"));
		        if(jfc.showOpenDialog(null)==JFileChooser.APPROVE_OPTION){
	                Image img;
					try {
						img = new Image(jfc.getSelectedFile());
						contentPanel.add(img, BorderLayout.CENTER);
		                contentPanel.repaint();
					} catch (IOException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
		        }
			}
	    });

	    mnFile.add(mntmOpen);
	    
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
