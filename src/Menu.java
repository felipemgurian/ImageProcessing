
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Point;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.JPopupMenu;
import javax.swing.filechooser.FileNameExtensionFilter;
import javax.swing.JOptionPane;
import java.awt.event.MouseAdapter;
import Utils.Image;

//My Libs :)
import Operations.Arithmetic.*;
import Operations.Filters.*;
import Operations.Logics.*;
import Operations.Punctual.Grey.*;
import Operations.Punctual.*;
import Operations.Geometric.*;

public class Menu extends JFrame {

	private static final long serialVersionUID = 1L;

	/**
	 * Colors Variables
	 */

	private static Color menuBarColor  = new Color(98,98,100);
	private Color backgroundColor   = new Color(98,98,100);
	private static Color imageContentColor = new Color(52,51,49);

	private static JFileChooser jfc;

	static ArrayList<Image> imagesList;
	static Menu menu;
	static Header header;
	static Content content;
	static Layers layers;
	
	static Point layerSelected;
	/**
	 * Main Method
	 */

	public static void main(String[] args) {
		Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
		imagesList = new ArrayList<Image>();
		layerSelected = new Point();

		//Create Menu
		menu = new Menu();


		//Create Header
		header = new Header(menuBarColor, menu.getSize());
		header.init();

		//Create Content
		content = new Content(imageContentColor, menu.getSize());
		content.init();

		//Create Layers
		layers = new Layers(menu.getSize());
		layers.init();
		
		//Listeners

		//Add Header
		menu.add(header);
		menu.setJMenuBar(header);

		//Add Content
		menu.add(content);

		//Add Layers
		menu.add(layers);

		menu.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		/*
		 * ON RESIZE
		 */
		menu.addComponentListener(new java.awt.event.ComponentAdapter(){
			@Override
			public void componentResized(java.awt.event.ComponentEvent evt)
			{
				reloadAll();
			}

		});
		
		JPopupMenu  menuLayer = new JPopupMenu ();
		
        JMenuItem itemLayerUp = new JMenuItem("Up");
        JMenuItem itemLayerDown = new JMenuItem("Down");
        JMenuItem itemLayerDelete = new JMenuItem("Delete");
        
        menuLayer.add(itemLayerUp);  
        menuLayer.add(itemLayerDown);  
        menuLayer.add(itemLayerDelete);  
        
        itemLayerUp.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
            	JPanel layer = (JPanel) layers.getComponentAt(layerSelected);
            	if(layer.getY()/41 != 0) {
	            	Image tmpUP = imagesList.get(layer.getY()/41 - 1);
	            	Image tmpDOWN = imagesList.get(layer.getY()/41);
	            	imagesList.remove(layer.getY()/41);
	            	imagesList.remove(layer.getY()/41 - 1);
	            	imagesList.add(layer.getY()/41 - 1, tmpDOWN);
	            	imagesList.add(layer.getY()/41, tmpUP);

	            	reloadAll();
            	}
            	layerSelected = null;
            }
            
         });
	    itemLayerDown.addActionListener(new ActionListener() {
	
	        @Override
	        public void actionPerformed(ActionEvent e) {
	        	JPanel layer = (JPanel) layers.getComponentAt(layerSelected);
	        	if(layer.getY()/41 + 1 < imagesList.size()) {
	        		
	            	Image tmpUP = imagesList.get(layer.getY()/41);
	            	Image tmpDOWN = imagesList.get(layer.getY()/41 + 1);
	            	imagesList.remove(layer.getY()/41 + 1);
	            	imagesList.remove(layer.getY()/41);
	            	imagesList.add(layer.getY()/41, tmpDOWN);
	            	imagesList.add(layer.getY()/41 +1, tmpUP);
	            	reloadAll();
	        	}
	        	layerSelected = null;
	        }
	        
	     });
        
        itemLayerDelete.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
            	JPanel layer = (JPanel) layers.getComponentAt(layerSelected);
            	imagesList.remove(layer.getY()/41);
            	reloadAll();
            	layerSelected = null;
            }
         });

		layers.addMouseListener( new MouseAdapter() {
				@Override
				    public void mouseClicked(MouseEvent e) {
					Point p = e.getPoint();
					//JPanel source = null;
					    if (layers.getComponentAt(p) != null && layers.getComponentAt(p) != layers) {
					    	//source = (JPanel) layers.getComponentAt(p);
					    	menuLayer.show(layers, p.x, p.y);
					    	layerSelected = p;
					    }
				   	}
				
			    }
		);
		
		/*
		 *  MENU BUTTOM OPERATIONS
		 */
		
		
		header.menuItemOpen.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e){
				jfc = new JFileChooser();
				jfc.setAcceptAllFileFilterUsed(false);
				jfc.setFileFilter(new FileNameExtensionFilter("Image File", "jpg", "png"));

				if(jfc.showOpenDialog(null)==JFileChooser.APPROVE_OPTION){

					Image img;

					try {

						img = new Image(jfc.getSelectedFile());

						imagesList.add(img);

						reloadAll();

					} catch (IOException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
				}
			}
		});

		/*
		 *  MENU BUTTOM OPERATIONS ARITHMETICS
		 */
		
		header.menuItemSum.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e){

				Object[] selectionValues = imagesList.toArray();
				Object image1 = null;
				Object image2 = null;
				Image imgResult = new Image();

				String[] image1Array = new String[2];
				String[] image2Array = new String[2];

				for(int i = 0; i< selectionValues.length; i++) {
					selectionValues[i] = "Image " + i;
				}

				int initialSelection = 0;
				image1 = JOptionPane.showInputDialog(null, "Select the image 1",
						"image1", JOptionPane.QUESTION_MESSAGE, null, selectionValues, initialSelection);
				if(image1 != null) {
					image2 = JOptionPane.showInputDialog(null, "Select the image 2",
							"image2", JOptionPane.QUESTION_MESSAGE, null, selectionValues, initialSelection);
				}

				if(image2 != null) {
					image1Array = ((String) image1).split(" ");
					image2Array = ((String) image2).split(" ");
					imgResult = Sum.sum(imagesList.get(Integer.parseInt(image1Array[1])), imagesList.get(Integer.parseInt(image2Array[1])));

					if(Integer.parseInt(image1Array[1]) > Integer.parseInt(image2Array[1])) {
						imagesList.remove(Integer.parseInt(image1Array[1]));
						imagesList.remove(Integer.parseInt(image2Array[1]));
					}else if(Integer.parseInt(image1Array[1]) < Integer.parseInt(image2Array[1])) {	
						imagesList.remove(Integer.parseInt(image2Array[1]));
						imagesList.remove(Integer.parseInt(image1Array[1]));
					}else if(Integer.parseInt(image1Array[1]) == Integer.parseInt(image2Array[1])){
						imagesList.remove(Integer.parseInt(image1Array[1]));
					}

					imagesList.add(imgResult);
				}
				reloadAll();

			}
		});

		header.menuItemSub.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e){

				Object[] selectionValues = imagesList.toArray();
				Object image1 = null;
				Object image2 = null;
				Image imgResult = new Image();

				String[] image1Array = new String[2];
				String[] image2Array = new String[2];

				for(int i = 0; i< selectionValues.length; i++) {
					selectionValues[i] = "Image " + i;
				}

				int initialSelection = 0;
				image1 = JOptionPane.showInputDialog(null, "Select the image 1",
						"image1", JOptionPane.QUESTION_MESSAGE, null, selectionValues, initialSelection);
				if(image1 != null) {
					image2 = JOptionPane.showInputDialog(null, "Select the image 2",
							"image2", JOptionPane.QUESTION_MESSAGE, null, selectionValues, initialSelection);
				}

				if(image2 != null) {
					image1Array = ((String) image1).split(" ");
					image2Array = ((String) image2).split(" ");

					imgResult = Subtraction.sub(imagesList.get(Integer.parseInt(image1Array[1])), imagesList.get(Integer.parseInt(image2Array[1])));

					if(Integer.parseInt(image1Array[1]) > Integer.parseInt(image2Array[1])) {
						imagesList.remove(Integer.parseInt(image1Array[1]));
						imagesList.remove(Integer.parseInt(image2Array[1]));
					}else if(Integer.parseInt(image1Array[1]) < Integer.parseInt(image2Array[1])) {	
						imagesList.remove(Integer.parseInt(image2Array[1]));
						imagesList.remove(Integer.parseInt(image1Array[1]));
					}else {
						imagesList.remove(Integer.parseInt(image1Array[1]));
					}

					imagesList.add(imgResult);
				}
				reloadAll();
			}
		});

		header.menuItemDiv.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e){

				Object[] selectionValues = imagesList.toArray();
				Object image1 = null;
				Object image2 = null;
				Image imgResult = new Image();

				String[] image1Array = new String[2];
				String[] image2Array = new String[2];

				for(int i = 0; i< selectionValues.length; i++) {
					selectionValues[i] = "Image " + i;
				}

				int initialSelection = 0;
				image1 = JOptionPane.showInputDialog(null, "Select the image 1",
						"image1", JOptionPane.QUESTION_MESSAGE, null, selectionValues, initialSelection);
				if(image1 != null) {
					image2 = JOptionPane.showInputDialog(null, "Select the image 2",
							"image2", JOptionPane.QUESTION_MESSAGE, null, selectionValues, initialSelection);
				}

				if(image2 != null) {
					image1Array = ((String) image1).split(" ");
					image2Array = ((String) image2).split(" ");

					imgResult = Division.div(imagesList.get(Integer.parseInt(image1Array[1])), imagesList.get(Integer.parseInt(image2Array[1])));

					if(Integer.parseInt(image1Array[1]) > Integer.parseInt(image2Array[1])) {
						imagesList.remove(Integer.parseInt(image1Array[1]));
						imagesList.remove(Integer.parseInt(image2Array[1]));
					}else if(Integer.parseInt(image1Array[1]) < Integer.parseInt(image2Array[1])) {	
						imagesList.remove(Integer.parseInt(image2Array[1]));
						imagesList.remove(Integer.parseInt(image1Array[1]));
					}else {
						imagesList.remove(Integer.parseInt(image1Array[1]));
					}

					imagesList.add(imgResult);
				}
				reloadAll();
			}
		});

		header.menuItemMul.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e){

				Object[] selectionValues = imagesList.toArray();
				Object image1 = null;
				Object image2 = null;
				Image imgResult = new Image();

				String[] image1Array = new String[2];
				String[] image2Array = new String[2];

				for(int i = 0; i< selectionValues.length; i++) {
					selectionValues[i] = "Image " + i;
				}

				int initialSelection = 0;
				image1 = JOptionPane.showInputDialog(null, "Select the image 1",
						"image1", JOptionPane.QUESTION_MESSAGE, null, selectionValues, initialSelection);
				if(image1 != null) {
					image2 = JOptionPane.showInputDialog(null, "Select the image 2",
							"image2", JOptionPane.QUESTION_MESSAGE, null, selectionValues, initialSelection);
				}

				if(image2 != null) {
					image1Array = ((String) image1).split(" ");
					image2Array = ((String) image2).split(" ");

					imgResult = Multiplication.mul(imagesList.get(Integer.parseInt(image1Array[1])), imagesList.get(Integer.parseInt(image2Array[1])));

					if(Integer.parseInt(image1Array[1]) > Integer.parseInt(image2Array[1])) {
						imagesList.remove(Integer.parseInt(image1Array[1]));
						imagesList.remove(Integer.parseInt(image2Array[1]));
					}else if(Integer.parseInt(image1Array[1]) < Integer.parseInt(image2Array[1])) {	
						imagesList.remove(Integer.parseInt(image2Array[1]));
						imagesList.remove(Integer.parseInt(image1Array[1]));
					}else {
						imagesList.remove(Integer.parseInt(image1Array[1]));
					}

					imagesList.add(imgResult);
				}
				reloadAll();
			}
		});

		header.menuItemBlending.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e){

				Object[] selectionValues = imagesList.toArray();
				Object image1 = null;
				Object image2 = null;
				Object pA = null;
				Image imgResult = new Image();

				String[] image1Array = new String[2];
				String[] image2Array = new String[2];

				for(int i = 0; i< selectionValues.length; i++) {
					selectionValues[i] = "Image " + i;
				}

				int initialSelection = 0;
				image1 = JOptionPane.showInputDialog(null, "Select the image 1",
						"image1", JOptionPane.QUESTION_MESSAGE, null, selectionValues, initialSelection);
				if(image1 != null) {
					image2 = JOptionPane.showInputDialog(null, "Select the image 2",
							"image2", JOptionPane.QUESTION_MESSAGE, null, selectionValues, initialSelection);
				}

				if(image2 != null) {
					pA = JOptionPane.showInputDialog(null, "pA Value");
				}

				if(pA != null) {
					image1Array = ((String) image1).split(" ");
					image2Array = ((String) image2).split(" ");

					imgResult = Blending.blending(imagesList.get(Integer.parseInt(image1Array[1])), imagesList.get(Integer.parseInt(image2Array[1])), Float.parseFloat((String) pA));

					if(Integer.parseInt(image1Array[1]) > Integer.parseInt(image2Array[1])) {
						imagesList.remove(Integer.parseInt(image1Array[1]));
						imagesList.remove(Integer.parseInt(image2Array[1]));
					}else if(Integer.parseInt(image1Array[1]) < Integer.parseInt(image2Array[1])) {	
						imagesList.remove(Integer.parseInt(image2Array[1]));
						imagesList.remove(Integer.parseInt(image1Array[1]));
					}else {
						imagesList.remove(Integer.parseInt(image1Array[1]));
					}

					imagesList.add(imgResult);
				}
				reloadAll();
			}
		});
		
		/*
		 *  MENU BUTTOM OPERATIONS LOGICS
		 */
		
		header.menuItemAnd.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e){

				Object[] selectionValues = imagesList.toArray();
				Object image1 = null;
				Object image2 = null;
				Image imgResult = new Image();

				String[] image1Array = new String[2];
				String[] image2Array = new String[2];

				for(int i = 0; i< selectionValues.length; i++) {
					selectionValues[i] = "Image " + i;
				}

				int initialSelection = 0;
				image1 = JOptionPane.showInputDialog(null, "Select the image 1",
						"image1", JOptionPane.QUESTION_MESSAGE, null, selectionValues, initialSelection);
				if(image1 != null) {
					image2 = JOptionPane.showInputDialog(null, "Select the image 2",
							"image2", JOptionPane.QUESTION_MESSAGE, null, selectionValues, initialSelection);
				}

				if(image2 != null) {
					image1Array = ((String) image1).split(" ");
					image2Array = ((String) image2).split(" ");

					imgResult = And.and(imagesList.get(Integer.parseInt(image1Array[1])), imagesList.get(Integer.parseInt(image2Array[1])));

					if(Integer.parseInt(image1Array[1]) > Integer.parseInt(image2Array[1])) {
						imagesList.remove(Integer.parseInt(image1Array[1]));
						imagesList.remove(Integer.parseInt(image2Array[1]));
					}else if(Integer.parseInt(image1Array[1]) < Integer.parseInt(image2Array[1])) {	
						imagesList.remove(Integer.parseInt(image2Array[1]));
						imagesList.remove(Integer.parseInt(image1Array[1]));
					}else {
						imagesList.remove(Integer.parseInt(image1Array[1]));
					}

					imagesList.add(imgResult);
				}
				reloadAll();
			}
		});

		header.menuItemOr.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e){

				Object[] selectionValues = imagesList.toArray();
				Object image1 = null;
				Object image2 = null;
				Image imgResult = new Image();

				String[] image1Array = new String[2];
				String[] image2Array = new String[2];

				for(int i = 0; i< selectionValues.length; i++) {
					selectionValues[i] = "Image " + i;
				}

				int initialSelection = 0;
				image1 = JOptionPane.showInputDialog(null, "Select the image 1",
						"image1", JOptionPane.QUESTION_MESSAGE, null, selectionValues, initialSelection);
				if(image1 != null) {
					image2 = JOptionPane.showInputDialog(null, "Select the image 2",
							"image2", JOptionPane.QUESTION_MESSAGE, null, selectionValues, initialSelection);
				}

				if(image2 != null) {
					image1Array = ((String) image1).split(" ");
					image2Array = ((String) image2).split(" ");

					imgResult = Or.or(imagesList.get(Integer.parseInt(image1Array[1])), imagesList.get(Integer.parseInt(image2Array[1])));

					if(Integer.parseInt(image1Array[1]) > Integer.parseInt(image2Array[1])) {
						imagesList.remove(Integer.parseInt(image1Array[1]));
						imagesList.remove(Integer.parseInt(image2Array[1]));
					}else if(Integer.parseInt(image1Array[1]) < Integer.parseInt(image2Array[1])) {	
						imagesList.remove(Integer.parseInt(image2Array[1]));
						imagesList.remove(Integer.parseInt(image1Array[1]));
					}else {
						imagesList.remove(Integer.parseInt(image1Array[1]));
					}

					imagesList.add(imgResult);
				}
				reloadAll();
			}
		});

		header.menuItemXor.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e){

				Object[] selectionValues = imagesList.toArray();
				Object image1 = null;
				Object image2 = null;
				Image imgResult = new Image();

				String[] image1Array = new String[2];
				String[] image2Array = new String[2];

				for(int i = 0; i< selectionValues.length; i++) {
					selectionValues[i] = "Image " + i;
				}

				int initialSelection = 0;
				image1 = JOptionPane.showInputDialog(null, "Select the image 1",
						"image1", JOptionPane.QUESTION_MESSAGE, null, selectionValues, initialSelection);
				if(image1 != null) {
					image2 = JOptionPane.showInputDialog(null, "Select the image 2",
							"image2", JOptionPane.QUESTION_MESSAGE, null, selectionValues, initialSelection);
				}

				if(image2 != null) {
					image1Array = ((String) image1).split(" ");
					image2Array = ((String) image2).split(" ");

					imgResult = Xor.xor(imagesList.get(Integer.parseInt(image1Array[1])), imagesList.get(Integer.parseInt(image2Array[1])));

					if(Integer.parseInt(image1Array[1]) > Integer.parseInt(image2Array[1])) {
						imagesList.remove(Integer.parseInt(image1Array[1]));
						imagesList.remove(Integer.parseInt(image2Array[1]));
					}else if(Integer.parseInt(image1Array[1]) < Integer.parseInt(image2Array[1])) {	
						imagesList.remove(Integer.parseInt(image2Array[1]));
						imagesList.remove(Integer.parseInt(image1Array[1]));
					}else {
						imagesList.remove(Integer.parseInt(image1Array[1]));
					}

					imagesList.add(imgResult);
				}
				reloadAll();
			}
		});

		header.menuItemNot.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e){

				Object[] selectionValues = imagesList.toArray();
				Object image1 = null;
				Image imgResult = new Image();

				String[] image1Array = new String[2];


				for(int i = 0; i< selectionValues.length; i++) {
					selectionValues[i] = "Image " + i;
				}

				int initialSelection = 0;
				image1 = JOptionPane.showInputDialog(null, "Select the image 1",
						"image1", JOptionPane.QUESTION_MESSAGE, null, selectionValues, initialSelection);



				if(image1 != null) {
					image1Array = ((String) image1).split(" ");

					imgResult = Not.not(imagesList.get(Integer.parseInt(image1Array[1])));


					imagesList.remove(Integer.parseInt(image1Array[1]));


					imagesList.add(imgResult);
				}
				reloadAll();
			}
		});
		
		/*
		 *  MENU BUTTOM OPERATIONS GEOMETRICS
		 */
		
		header.menuItemRotation.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e){

				Object[] selectionValues = imagesList.toArray();
				Object image1 = null;
				Object alpha = null;

				Image imgResult = new Image();

				String[] image1Array = new String[2];

				for(int i = 0; i< selectionValues.length; i++) {
					selectionValues[i] = "Image " + i;
				}

				int initialSelection = 0;
				image1 = JOptionPane.showInputDialog(null, "Select the image 1",
						"image1", JOptionPane.QUESTION_MESSAGE, null, selectionValues, initialSelection);

				if(image1 != null) {
					alpha = JOptionPane.showInputDialog(null, "Degrees Value");
				}


				if(alpha != null) {
					image1Array = ((String) image1).split(" ");

					imgResult = Rotation.rotation(imagesList.get(Integer.parseInt(image1Array[1])), Integer.parseInt((String)alpha),imagesList.get(Integer.parseInt(image1Array[1])).getW()/2, imagesList.get(Integer.parseInt(image1Array[1])).getH()/2 );

					imagesList.remove(Integer.parseInt(image1Array[1]));


					imagesList.add(imgResult);
				}
				reloadAll();
			}

		});

		header.menuItemTranslation.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e){

				Object[] selectionValues = imagesList.toArray();
				Object image1 = null;
				Object tx = null;
				Object ty = null;

				Image imgResult = new Image();

				String[] image1Array = new String[2];

				for(int i = 0; i< selectionValues.length; i++) {
					selectionValues[i] = "Image " + i;
				}

				int initialSelection = 0;
				image1 = JOptionPane.showInputDialog(null, "Select the image 1",
						"image1", JOptionPane.QUESTION_MESSAGE, null, selectionValues, initialSelection);

				if(image1 != null) {
					tx = JOptionPane.showInputDialog(null, "tx Value");
				}

				if(tx != null) {
					ty = JOptionPane.showInputDialog(null, "ty Value");
				}
				if(ty != null) {
					image1Array = ((String) image1).split(" ");

					imgResult = Translation.translation(imagesList.get(Integer.parseInt(image1Array[1])), Integer.parseInt((String)tx), Integer.parseInt((String)ty));

					imagesList.remove(Integer.parseInt(image1Array[1]));


					imagesList.add(imgResult);
				}
				reloadAll();
			}

		});

		header.menuItemScale.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e){

				Object[] selectionValues = imagesList.toArray();
				Object image1 = null;
				Object scaleMultiply = null;

				Image imgResult = new Image();

				String[] image1Array = new String[2];

				for(int i = 0; i< selectionValues.length; i++) {
					selectionValues[i] = "Image " + i;
				}

				int initialSelection = 0;
				image1 = JOptionPane.showInputDialog(null, "Select the image 1",
						"image1", JOptionPane.QUESTION_MESSAGE, null, selectionValues, initialSelection);

				if(image1 != null) {
					scaleMultiply = JOptionPane.showInputDialog(null, "Scale Value");
				}


				if(scaleMultiply != null) {
					image1Array = ((String) image1).split(" ");

					imgResult = Scale.bilinear(imagesList.get(Integer.parseInt(image1Array[1])), Float.parseFloat((String)scaleMultiply));

					imagesList.remove(Integer.parseInt(image1Array[1]));

					imagesList.add(imgResult);
				}
				reloadAll();
			}

		});
		
		/*
		 *  MENU BUTTOM OPERATIONS PUNCTUALS
		 */
		
		header.menuItemGreyHdr.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e){

				Object[] selectionValues = imagesList.toArray();
				Object image1 = null;

				Image imgResult = new Image();

				String[] image1Array = new String[2];

				for(int i = 0; i< selectionValues.length; i++) {
					selectionValues[i] = "Image " + i;
				}

				int initialSelection = 0;
				image1 = JOptionPane.showInputDialog(null, "Select the image 1",
						"image1", JOptionPane.QUESTION_MESSAGE, null, selectionValues, initialSelection);

				if(image1 != null) {
					image1Array = ((String) image1).split(" ");

					imgResult = Hdr.hdr(imagesList.get(Integer.parseInt(image1Array[1])));

					imagesList.remove(Integer.parseInt(image1Array[1]));

					imagesList.add(imgResult);
				}
				reloadAll();
			}

		});

		header.menuItemGreyHdtv.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e){

				Object[] selectionValues = imagesList.toArray();
				Object image1 = null;

				Image imgResult = new Image();

				String[] image1Array = new String[2];

				for(int i = 0; i< selectionValues.length; i++) {
					selectionValues[i] = "Image " + i;
				}

				int initialSelection = 0;
				image1 = JOptionPane.showInputDialog(null, "Select the image 1",
						"image1", JOptionPane.QUESTION_MESSAGE, null, selectionValues, initialSelection);

				if(image1 != null) {
					image1Array = ((String) image1).split(" ");

					imgResult = Hdtv.hdtv(imagesList.get(Integer.parseInt(image1Array[1])));

					imagesList.remove(Integer.parseInt(image1Array[1]));

					imagesList.add(imgResult);
				}
				reloadAll();
			}

		});

		header.menuItemGreyMedium.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e){

				Object[] selectionValues = imagesList.toArray();
				Object image1 = null;

				Image imgResult = new Image();

				String[] image1Array = new String[2];

				for(int i = 0; i< selectionValues.length; i++) {
					selectionValues[i] = "Image " + i;
				}

				int initialSelection = 0;
				image1 = JOptionPane.showInputDialog(null, "Select the image 1",
						"image1", JOptionPane.QUESTION_MESSAGE, null, selectionValues, initialSelection);

				if(image1 != null) {
					image1Array = ((String) image1).split(" ");

					imgResult = Medium.medium(imagesList.get(Integer.parseInt(image1Array[1])));

					imagesList.remove(Integer.parseInt(image1Array[1]));

					imagesList.add(imgResult);
				}
				reloadAll();
			}

		});

		header.menuItemGreyNtsc.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e){

				Object[] selectionValues = imagesList.toArray();
				Object image1 = null;

				Image imgResult = new Image();

				String[] image1Array = new String[2];

				for(int i = 0; i< selectionValues.length; i++) {
					selectionValues[i] = "Image " + i;
				}

				int initialSelection = 0;
				image1 = JOptionPane.showInputDialog(null, "Select the image 1",
						"image1", JOptionPane.QUESTION_MESSAGE, null, selectionValues, initialSelection);

				if(image1 != null) {
					image1Array = ((String) image1).split(" ");

					imgResult = Ntsc.ntsc(imagesList.get(Integer.parseInt(image1Array[1])));

					imagesList.remove(Integer.parseInt(image1Array[1]));

					imagesList.add(imgResult);
				}
				reloadAll();
			}

		});
		
		header.menuItemHistogram.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e){

				Object[] selectionValues = imagesList.toArray();
				Object image1 = null;
				JFrame jPopupMenu = new JFrame();
				
				Image imgResult = new Image();

				String[] image1Array = new String[2];

				for(int i = 0; i< selectionValues.length; i++) {
					selectionValues[i] = "Image " + i;
				}

				int initialSelection = 0;
				image1 = JOptionPane.showInputDialog(null, "Select the image 1",
						"image1", JOptionPane.QUESTION_MESSAGE, null, selectionValues, initialSelection);

				if(image1 != null) {
					image1Array = ((String) image1).split(" ");

					imgResult = Histogram.histogram(imagesList.get(Integer.parseInt(image1Array[1])));
					jPopupMenu.setBounds(imgResult.getW(), imgResult.getH(), 800, 800);
					jPopupMenu.setSize(imgResult.getW(), imgResult.getH());
					jPopupMenu.setTitle("Histogram");
					jPopupMenu.setLocation(dim.width/2-jPopupMenu.getSize().width/2, dim.height/2-jPopupMenu.getSize().height/2);
					jPopupMenu.add(imgResult);
					jPopupMenu.setVisible(true);
				}

			}

		});
		
		header.menuItemThreshold.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e){

				Object[] selectionValues = imagesList.toArray();
				Object image1 = null;
				Object maskSize = null;
				Object c = null;

				Image imgResult = new Image();

				String[] image1Array = new String[2];

				for(int i = 0; i< selectionValues.length; i++) {
					selectionValues[i] = "Image " + i;
				}

				int initialSelection = 0;
				image1 = JOptionPane.showInputDialog(null, "Select the image 1",
						"image1", JOptionPane.QUESTION_MESSAGE, null, selectionValues, initialSelection);

				if(image1 != null) {
					maskSize = JOptionPane.showInputDialog(null, "MaskSize Value");
				}
				if(maskSize != null) {
					c = JOptionPane.showInputDialog(null, "C Value");

					imgResult = Threshold.threshold(imagesList.get(Integer.parseInt(image1Array[1])), Integer.parseInt((String) maskSize), Integer.parseInt((String) c));

					imagesList.remove(Integer.parseInt(image1Array[1]));

					imagesList.add(imgResult);
				}
				reloadAll();
			}

		});
		
		/*
		 *  MENU BUTTOM OPERATIONS FILTERS
		 */
		
		header.menuItemAverageFour.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e){

				Object[] selectionValues = imagesList.toArray();
				Object image1 = null;

				Image imgResult = new Image();

				String[] image1Array = new String[2];

				for(int i = 0; i< selectionValues.length; i++) {
					selectionValues[i] = "Image " + i;
				}

				int initialSelection = 0;
				image1 = JOptionPane.showInputDialog(null, "Select the image 1",
						"image1", JOptionPane.QUESTION_MESSAGE, null, selectionValues, initialSelection);

				if(image1 != null) {
					image1Array = ((String) image1).split(" ");

					imgResult = AverageFour.averageFour(imagesList.get(Integer.parseInt(image1Array[1])));

					imagesList.remove(Integer.parseInt(image1Array[1]));

					imagesList.add(imgResult);
				}
				reloadAll();
			}

		});

		header.menuItemAverageR.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e){

				Object[] selectionValues = imagesList.toArray();
				Object image1 = null;
				Object r = null;
				Image imgResult = new Image();

				String[] image1Array = new String[2];

				for(int i = 0; i< selectionValues.length; i++) {
					selectionValues[i] = "Image " + i;
				}

				int initialSelection = 0;
				image1 = JOptionPane.showInputDialog(null, "Select the image 1",
						"image1", JOptionPane.QUESTION_MESSAGE, null, selectionValues, initialSelection);

				if(image1 != null) {
					r = JOptionPane.showInputDialog(null, "R Value");
				}

				if(r != null) {
					image1Array = ((String) image1).split(" ");

					imgResult = AverageR.averageR(imagesList.get(Integer.parseInt(image1Array[1])), Integer.parseInt((String) r));

					imagesList.remove(Integer.parseInt(image1Array[1]));

					imagesList.add(imgResult);
				}
				reloadAll();
			}

		});
		
		header.menuItemMedianFour.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e){

				Object[] selectionValues = imagesList.toArray();
				Object image1 = null;

				Image imgResult = new Image();

				String[] image1Array = new String[2];

				for(int i = 0; i< selectionValues.length; i++) {
					selectionValues[i] = "Image " + i;
				}

				int initialSelection = 0;
				image1 = JOptionPane.showInputDialog(null, "Select the image 1",
						"image1", JOptionPane.QUESTION_MESSAGE, null, selectionValues, initialSelection);

				if(image1 != null) {
					image1Array = ((String) image1).split(" ");

					imgResult = MedianFour.medianFour(imagesList.get(Integer.parseInt(image1Array[1])));

					imagesList.remove(Integer.parseInt(image1Array[1]));

					imagesList.add(imgResult);
				}
				reloadAll();
			}

		});
		
		header.menuItemMedianR.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e){

				Object[] selectionValues = imagesList.toArray();
				Object image1 = null;
				Object r = null;
				Image imgResult = new Image();

				String[] image1Array = new String[2];

				for(int i = 0; i< selectionValues.length; i++) {
					selectionValues[i] = "Image " + i;
				}

				int initialSelection = 0;
				image1 = JOptionPane.showInputDialog(null, "Select the image 1",
						"image1", JOptionPane.QUESTION_MESSAGE, null, selectionValues, initialSelection);

				if(image1 != null) {
					r = JOptionPane.showInputDialog(null, "R Value");
				}

				if(r != null) {
					image1Array = ((String) image1).split(" ");

					imgResult = MedianR.medianR(imagesList.get(Integer.parseInt(image1Array[1])), Integer.parseInt((String) r));

					imagesList.remove(Integer.parseInt(image1Array[1]));

					imagesList.add(imgResult);
				}
				reloadAll();
			}

		});
		
		header.menuItemConvolve.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e){

				Object[] selectionValues = imagesList.toArray();
				Object image1 = null;
				Object r = null;

				Image imgResult = new Image();

				String[] image1Array = new String[2];

				for(int i = 0; i< selectionValues.length; i++) {
					selectionValues[i] = "Image " + i;
				}

				int initialSelection = 0;
				image1 = JOptionPane.showInputDialog(null, "Select the image 1",
						"image1", JOptionPane.QUESTION_MESSAGE, null, selectionValues, initialSelection);

				if(image1 != null) {
					r = JOptionPane.showInputDialog(null, "R Value");
				}
				
				if(r != null) {
					image1Array = ((String) image1).split(" ");

					imgResult = Convolve.convolve(imagesList.get(Integer.parseInt(image1Array[1])), new Kernel(Integer.parseInt((String) r)));

					imagesList.remove(Integer.parseInt(image1Array[1]));

					imagesList.add(imgResult);
				}
				reloadAll();
			}

		});

		
		header.menuItemGaussianBlur.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e){

				Object[] selectionValues = imagesList.toArray();
				Object image1 = null;
				Object r = null;
				Object sigma = null;
				Object amp = null;
				Image imgResult = new Image();

				String[] image1Array = new String[2];

				for(int i = 0; i< selectionValues.length; i++) {
					selectionValues[i] = "Image " + i;
				}

				int initialSelection = 0;
				image1 = JOptionPane.showInputDialog(null, "Select the image 1",
						"image1", JOptionPane.QUESTION_MESSAGE, null, selectionValues, initialSelection);

				if(image1 != null) {
					r = JOptionPane.showInputDialog(null, "R Value");
				}
				
				if(r != null) {
					sigma = JOptionPane.showInputDialog(null, "Sigma Value");
				}
				
				if(sigma != null) {
					amp = JOptionPane.showInputDialog(null, "Amp Value");
				}
				
				if(amp != null) {
					image1Array = ((String) image1).split(" ");

					imgResult = GaussianBlur.gaussianBlur(imagesList.get(Integer.parseInt(image1Array[1])), Integer.parseInt((String) r), Float.parseFloat((String) sigma), Float.parseFloat((String) amp));

					imagesList.remove(Integer.parseInt(image1Array[1]));

					imagesList.add(imgResult);
				}
				reloadAll();
			}

		});
		
		header.menuItemUnsharpMask.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e){

				Object[] selectionValues = imagesList.toArray();
				Object image1 = null;
				Object r = null;
				Object v = null;
				Object sigma = null;
				Object amp = null;
				Image imgResult = new Image();

				String[] image1Array = new String[2];

				for(int i = 0; i< selectionValues.length; i++) {
					selectionValues[i] = "Image " + i;
				}

				int initialSelection = 0;
				image1 = JOptionPane.showInputDialog(null, "Select the image 1",
						"image1", JOptionPane.QUESTION_MESSAGE, null, selectionValues, initialSelection);

				if(image1 != null) {
					r = JOptionPane.showInputDialog(null, "R Value");
				}
				if(r != null) {
					v = JOptionPane.showInputDialog(null, "R Value");
				}
				if(v != null) {
					sigma = JOptionPane.showInputDialog(null, "R Value");
				}
				if(sigma != null) {
					amp = JOptionPane.showInputDialog(null, "R Value");
				}
				
				if(amp != null) {
					image1Array = ((String) image1).split(" ");

					imgResult = UnsharpMask.unsharpMask(imagesList.get(Integer.parseInt(image1Array[1])), Float.parseFloat((String) v), Integer.parseInt((String) r), Float.parseFloat((String) sigma), Float.parseFloat((String) amp));

					imagesList.remove(Integer.parseInt(image1Array[1]));

					imagesList.add(imgResult);
				}
				reloadAll();
			}

		});
		
		header.menuItemRoberts.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e){
				Object[] selectionValues = imagesList.toArray();
				Object image1 = null;

				Image imgResult = new Image();

				String[] image1Array = new String[2];

				for(int i = 0; i< selectionValues.length; i++) {
					selectionValues[i] = "Image " + i;
				}

				int initialSelection = 0;
				image1 = JOptionPane.showInputDialog(null, "Select the image 1",
						"image1", JOptionPane.QUESTION_MESSAGE, null, selectionValues, initialSelection);


				if(image1 != null) {
					image1Array = ((String) image1).split(" ");

					imgResult = Roberts.roberts(imagesList.get(Integer.parseInt(image1Array[1])));

					imagesList.remove(Integer.parseInt(image1Array[1]));

					imagesList.add(imgResult);
				}
				reloadAll();
				
				}
		});
		
		header.menuItemCanny.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e){
				JOptionPane.showMessageDialog(null, "Not Implemented!");
				}
		});

		header.menuItemSobel.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e){
				JOptionPane.showMessageDialog(null, "Not Implemented!");
				}
		});

		menu.repaint();

	}
	
	
	/**
	 * Main Menu
	 */

	public static void reloadAll() {
		content.removeAll();
		layers.removeAll();
		
		content.reload(menu.getSize());
		layers.reload(menu.getSize());
		header.reload(menu.getSize());
		for(int i = 0; i < imagesList.size(); i++) {
			JPanel panel = new JPanel();
			panel.setBounds(0, i*41, layers.getWidth(), 40);
			panel.setBackground(Color.WHITE);

			JLabel title = new JLabel("Image " + i );
			title.setBounds(55, 11, 46, 14);
			panel.add(Scale.bilinearPixel(imagesList.get(i), 50, 50));
			panel.add(title);

			content.add(imagesList.get(i));
			layers.add(panel, i);
			imagesList.get(i).setLocation(content.getW()/2 - imagesList.get(i).getW()/2, content.getH()/2 - imagesList.get(i).getH()/2);

		}

		content.repaint();
		layers.repaint();
	}

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
		this.setMinimumSize(this.getSize());
		this.setLocation(dim.width/2-this.getSize().width/2, dim.height/2-this.getSize().height/2);
		this.setVisible(true);
	}
}
