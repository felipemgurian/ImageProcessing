import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

import javax.swing.JComponent;
import javax.swing.JFileChooser;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.filechooser.FileNameExtensionFilter;
import javax.swing.plaf.basic.BasicMenuBarUI;

import Utils.Image;

public class Header extends JMenuBar{

	private static final long serialVersionUID = 1L;
	private Color menuBarColor;
	Dimension size;
	
	//Components
	private JFileChooser jfc;
	private JMenu menuFile;
	private JMenu menuArithmetics;
	private JMenu menuGeometrics;
	private JMenu menuLogics;
	private JMenu menuPunctuals;
	private JMenu menuGrey;
	private JMenu menuFilters;
	
	private JMenuItem menuItemOpen;
	private JMenuItem menuItemSum;
	private JMenuItem menuItemSub;
	private JMenuItem menuItemDiv;
	private JMenuItem menuItemMul;
	private JMenuItem menuItemBlending;
	private JMenuItem menuItemTranslation;
	private JMenuItem menuItemScale;
	private JMenuItem menuItemRotation;
	private JMenuItem menuItemAnd;
	private JMenuItem menuItemNot;
	private JMenuItem menuItemOr;
	private JMenuItem menuItemXor;
	private JMenuItem menuItemGreyHdr;
	private JMenuItem menuItemGreyHdtv;
	private JMenuItem menuItemGreyMedium;
	private JMenuItem menuItemGreyNtsc;
	private JMenuItem menuItemHistogram;
	private JMenuItem menuItemThreshold;
	private JMenuItem menuItemAverageFour;
	private JMenuItem menuItemAverageR;
	private JMenuItem menuItemCanny;
	private JMenuItem menuItemRoberts;
	private JMenuItem menuItemSobel;
	private JMenuItem menuItemGaussianBlur;
	private JMenuItem menuItemConvolve;
	private JMenuItem menuItemUnsharpMask;
	private JMenuItem menuItemMedianFour;
	private JMenuItem menuItemMedianR;

	public Header(Color color, Dimension size) {
		super();
		this.menuBarColor = color;
		this.size = size;
	}
	
	public void init() {
		
		this.setBorderPainted(false);
	    this.setBackground(menuBarColor);
	    this.setUI(new BasicMenuBarUI() {

	    	@Override
	        public void paint(Graphics g, JComponent c) {
	            g.setColor(Color.black);
	            g.fillRect(0, 0, c.getWidth(), c.getHeight());
	        }
	
	    });
	    menuFile = new JMenu("File");
	    menuArithmetics = new JMenu("Arithmetics");
	    menuGeometrics = new JMenu("Geometrics");
	    menuLogics = new JMenu("Logics");
	    menuPunctuals = new JMenu("Punctuals");
	    menuFilters = new JMenu("Filters");

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

	}
	
	public void listenerMenuOpen(Content content, Layers layers){
	    menuItemOpen.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e){
		     jfc = new JFileChooser();
		        jfc.setAcceptAllFileFilterUsed(false);
		        jfc.setFileFilter(new FileNameExtensionFilter("Image File", "jpg", "png"));
		        if(jfc.showOpenDialog(null)==JFileChooser.APPROVE_OPTION){
	                Image img;
					try {
						img = new Image(jfc.getSelectedFile());
						content.add(img, BorderLayout.CENTER);
						layers.addLayer(img);
						layers.loadLayers();
						content.repaint();
						System.out.println("Image added!");
					} catch (IOException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
		        }
			}
	    });
	}
	
}
