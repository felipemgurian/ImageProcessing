
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JDesktopPane;
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
import Utils.Image;

public class Menu extends JFrame {

	private static final long serialVersionUID = 1L;
	private JTextField txtActions;
	private JTextField txtLayers;
	private JFileChooser jfc;
	private String ProjectPath = "C:\\Users\\fgurian\\Documents\\Faculdade\\Sistemas de Multimidia e Jogos Digitais\\ImageProcessing\\src";
	
	public static void main(String[] args) {
		new Menu();
	}
	
	public Menu() {
	    Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
		
		this.setPreferredSize(new Dimension(screenSize.width, screenSize.height));
		this.pack();
	    this.setLocationRelativeTo(null);
	    
		getContentPane().setBackground(Color.WHITE);
		getContentPane().setForeground(Color.BLACK);
		getContentPane().setEnabled(false);
		getContentPane().setLayout(null);
		
		JDesktopPane desktopPane = new JDesktopPane();
		desktopPane.setBounds(168, 110, 1, 1);
		getContentPane().add(desktopPane);
		
		/**
		 * Central Content Panel
		 */
		
		JPanel panel_1 = new JPanel();
		panel_1.setBounds(136, 11, (int) (screenSize.width * 0.72), (int) (screenSize.height * 0.87));
		panel_1.repaint();
		getContentPane().add(panel_1);
		
		/**
		 * SIDE BUTTOM BAR
		 */
		
		JPanel panel = new JPanel();
		panel.setBackground(Color.WHITE);
		panel.setBounds(0, 0, (int) (screenSize.width * 0.10),  (int) (screenSize.height * 0.87));
		getContentPane().add(panel);
		panel.setLayout(null);
		
		txtActions = new JTextField();
		txtActions.setEditable(false);
		txtActions.setHorizontalAlignment(SwingConstants.CENTER);
		txtActions.setText("Actions");
		txtActions.setBounds(20, 11, 86, 20);
		panel.add(txtActions);
		txtActions.setColumns(10);
		
		JButton btnBt = new JButton("");
		btnBt.setIcon(new ImageIcon(ProjectPath + "\\Resources\\Img\\Seta.png"));
		btnBt.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnBt.setForeground(Color.WHITE);
		btnBt.setBounds(20, 41, 38, 38);
		panel.add(btnBt);
		
		JButton button = new JButton("");
		button.setIcon(new ImageIcon(ProjectPath + "\\Resources\\Img\\Lapiz.png"));
		button.setBounds(68, 41, 38, 38);
		panel.add(button);
		
		JButton button_1 = new JButton("");
		button_1.setIcon(new ImageIcon(ProjectPath + "\\Resources\\Img\\Borracha.png"));
		button_1.setForeground(Color.WHITE);
		button_1.setBounds(20, 90, 38, 38);
		panel.add(button_1);
		
		JButton button_2 = new JButton("");
		button_2.setIcon(new ImageIcon(ProjectPath + "\\Resources\\Img\\Lupa.png"));
		button_2.setForeground(Color.WHITE);
		button_2.setBounds(68, 90, 38, 38);
		panel.add(button_2);
		
		JButton button_3 = new JButton("");
		button_3.setIcon(new ImageIcon(ProjectPath + "\\Resources\\Img\\Balde.png"));
		button_3.setForeground(Color.WHITE);
		button_3.setBounds(20, 139, 38, 38);
		panel.add(button_3);
		
		
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
	    scrollPane.getViewport().add(paneel2,null);
		
		/**
		 * TOP MENU BAR
		 */
		
	    JMenuBar menuBar = new JMenuBar();
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
						panel_1.add(img, BorderLayout.CENTER);
		                panel_1.repaint();
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
	    
	    this.setExtendedState(JFrame.MAXIMIZED_BOTH); 
		this.setVisible(true);
	}
}
