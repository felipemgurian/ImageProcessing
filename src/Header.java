import java.awt.Color;
import java.awt.Dimension;
import java.awt.Toolkit;
import java.net.URL;
import javax.swing.ImageIcon;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;

public class Header extends JMenuBar{

	private static final long serialVersionUID = 1L;
	private Color menuBarColor;
	Dimension size;
	
	//Components

	private JMenu menuFile;
	private JMenu menuArithmetics;
	private JMenu menuGeometrics;
	private JMenu menuLogics;
	private JMenu menuPunctuals;
	private JMenu menuGrey;
	private JMenu menuFilters;
	
	public JMenuItem menuItemOpen;
	public JMenuItem menuItemSum;
	public JMenuItem menuItemSub;
	public JMenuItem menuItemDiv;
	public JMenuItem menuItemMul;
	public JMenuItem menuItemBlending;
	public JMenuItem menuItemTranslation;
	public JMenuItem menuItemScale;
	public JMenuItem menuItemRotation;
	public JMenuItem menuItemAnd;
	public JMenuItem menuItemNot;
	public JMenuItem menuItemOr;
	public JMenuItem menuItemXor;
	public JMenuItem menuItemGreyHdr;
	public JMenuItem menuItemGreyHdtv;
	public JMenuItem menuItemGreyMedium;
	public JMenuItem menuItemGreyNtsc;
	public JMenuItem menuItemHistogram;
	public JMenuItem menuItemThreshold;
	public JMenuItem menuItemAverageFour;
	public JMenuItem menuItemAverageR;
	public JMenuItem menuItemCanny;
	public JMenuItem menuItemRoberts;
	public JMenuItem menuItemSobel;
	public JMenuItem menuItemGaussianBlur;
	public JMenuItem menuItemConvolve;
	public JMenuItem menuItemUnsharpMask;
	public JMenuItem menuItemMedianFour;
	public JMenuItem menuItemMedianR;

	public Header(Color color, Dimension size) {
		super();
		this.menuBarColor = color;
		this.size = size;
		this.setBounds(0, 0, (int) size.getWidth(), 31);
	}
	
	public void init() {
		
		this.setBorderPainted(false);
	    this.setBackground(menuBarColor);

	    menuFile        = new JMenu("File");
	    
	    URL filesUrl = this.getClass().getResource("Resources\\Img\\folder.png");
		java.awt.Image fileImg = Toolkit.getDefaultToolkit().getImage(filesUrl);
		menuFile.setIcon(new ImageIcon(fileImg));
	    menuFile.setForeground(Color.WHITE);
	    
	    menuArithmetics = new JMenu("Arithmetics");
	    
	    URL arithmeticsUrl = this.getClass().getResource("Resources\\Img\\arithmetic.png");
		java.awt.Image arithmeticsImg = Toolkit.getDefaultToolkit().getImage(arithmeticsUrl);
	    menuArithmetics.setIcon(new ImageIcon(arithmeticsImg));
	    menuArithmetics.setForeground(Color.WHITE);
	    
	    menuGeometrics  = new JMenu("Geometrics");
	    
	    URL geometricsUrl = this.getClass().getResource("Resources\\Img\\geometric.png");
		java.awt.Image geometricsIcon = Toolkit.getDefaultToolkit().getImage(geometricsUrl);
		menuGeometrics.setIcon(new ImageIcon(geometricsIcon));
		menuGeometrics.setForeground(Color.WHITE);
		
	    menuLogics      = new JMenu("Logics");
	    
	    URL logicsUrl = this.getClass().getResource("Resources\\Img\\logic.png");
		java.awt.Image logicsIcon = Toolkit.getDefaultToolkit().getImage(logicsUrl);
		menuLogics.setIcon(new ImageIcon(logicsIcon));
	    menuLogics.setForeground(Color.WHITE);
	    
	    menuPunctuals   = new JMenu("Punctuals");
	    
	    URL punctualsUrl = this.getClass().getResource("Resources\\Img\\contrast.png");
		java.awt.Image punctualsIcon = Toolkit.getDefaultToolkit().getImage(punctualsUrl);
		menuPunctuals.setIcon(new ImageIcon(punctualsIcon));
	    menuPunctuals.setForeground(Color.WHITE);
		
	    menuFilters     = new JMenu("Filters");
	    
	    URL filterUrl = this.getClass().getResource("Resources\\Img\\filter.png");
		java.awt.Image filterIcon = Toolkit.getDefaultToolkit().getImage(filterUrl);
	    menuFilters.setIcon(new ImageIcon(filterIcon));
	    menuFilters.setForeground(Color.WHITE);
	    
	    this.add(menuFile);
	    
	    menuItemOpen = new JMenuItem("   Open                                                  ");
	    menuFile.add(menuItemOpen);
	    
	    this.add(menuArithmetics);
	    
	    menuItemSum       = new JMenuItem("   Sum                                                   ");
	    menuItemSub       = new JMenuItem("   Subtraction                                           ");
	    menuItemDiv       = new JMenuItem("   Division                                              ");
	    menuItemMul       = new JMenuItem("   Multiplication                                        ");
	    menuItemBlending  = new JMenuItem("   Blending                                              ");
	    
	    menuArithmetics.add(menuItemSum);
	    menuArithmetics.add(menuItemSub);
	    menuArithmetics.add(menuItemDiv);
	    menuArithmetics.add(menuItemMul);
	    menuArithmetics.add(menuItemBlending);
	    
	    this.add(menuGeometrics);
	    
	    menuItemTranslation       = new JMenuItem("   Translation                                           ");
	    menuItemRotation          = new JMenuItem("   Rotation                                              ");
	    menuItemScale             = new JMenuItem("   Scale                                                 ");
	    
	    menuGeometrics.add(menuItemTranslation);
	    menuGeometrics.add(menuItemRotation);
	    menuGeometrics.add(menuItemScale);
	    
	    this.add(menuLogics);
	    
	    menuItemAnd       = new JMenuItem("   And                                                   ");
	    menuItemOr        = new JMenuItem("   Or                                                    ");
	    menuItemNot       = new JMenuItem("   Not                                                   ");
	    menuItemXor       = new JMenuItem("   Xor                                                   ");
	    
	    menuLogics.add(menuItemAnd);
	    menuLogics.add(menuItemOr);
	    menuLogics.add(menuItemNot);
	    menuLogics.add(menuItemXor);
	    
	    this.add(menuPunctuals);
	    
	    menuGrey           = new     JMenu("   Grey                                                   ");
	    menuItemGreyHdr    = new JMenuItem("   Hdr                                                    ");
	    menuItemGreyHdtv   = new JMenuItem("   Hdtv                                                   ");
	    menuItemGreyMedium = new JMenuItem("   Medium                                                 ");
	    menuItemGreyNtsc   = new JMenuItem("   Ntsc                                                   ");
	    
	    menuGrey.add(menuItemGreyHdr);
	    menuGrey.add(menuItemGreyHdtv);
	    menuGrey.add(menuItemGreyMedium);
	    menuGrey.add(menuItemGreyNtsc);
	    
	    menuItemHistogram   = new JMenuItem("   Histogram                                              ");
	    menuItemThreshold   = new JMenuItem("   Threshold                                              ");
	    
	    menuPunctuals.add(menuGrey);
	    menuPunctuals.add(menuItemHistogram);
	    menuPunctuals.add(menuItemThreshold);
	    
	    this.add(menuFilters);
	     
	    menuItemAverageFour  = new JMenuItem("   Average Four                                         ");
		menuItemAverageR     = new JMenuItem("   Average R                                            ");
		menuItemCanny        = new JMenuItem("   Canny                                                ");
		menuItemRoberts      = new JMenuItem("   Roberts                                              ");
		menuItemSobel        = new JMenuItem("   Sobel                                                ");
		menuItemGaussianBlur = new JMenuItem("   GaussianBlur                                         ");
		menuItemConvolve     = new JMenuItem("   Convolve                                             ");
		menuItemUnsharpMask  = new JMenuItem("   UnsharpMask                                          ");
		menuItemMedianFour   = new JMenuItem("   Median Four                                          ");
		menuItemMedianR      = new JMenuItem("   Median R                                             ");
	    
		menuFilters.add(menuItemAverageFour);
		menuFilters.add(menuItemAverageR);
		menuFilters.add(menuItemCanny);
		menuFilters.add(menuItemRoberts);
		menuFilters.add(menuItemSobel);
		menuFilters.add(menuItemGaussianBlur);
		menuFilters.add(menuItemConvolve);
		menuFilters.add(menuItemUnsharpMask);
		menuFilters.add(menuItemMedianFour);
		menuFilters.add(menuItemMedianR);
		
		this.repaint();
	}
	
	public void reload(Dimension size) {
		this.size = size;
		this.setBounds(0, 0, (int) size.getWidth(), 31);
		this.setBorderPainted(false);
		this.setBackground(menuBarColor);
		this.repaint();
	}
	
}
