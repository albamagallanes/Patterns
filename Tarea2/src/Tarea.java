import java.awt.Color;
import java.awt.Component;
import java.awt.EventQueue;
import java.awt.FontMetrics;
import java.awt.Graphics;
import java.awt.Rectangle;

import javax.imageio.ImageIO;
import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTabbedPane;
import java.awt.BorderLayout;
import javax.swing.BoxLayout;
import javax.swing.JTextPane;
import javax.swing.JLabel;

import net.sf.image4j.codec.bmp.BMPDecoder;

import java.awt.FlowLayout;
import javax.swing.SpringLayout;
import java.awt.Font;

import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JComboBox;
import javax.swing.JButton;
import javax.swing.JDesktopPane;
import javax.swing.JFileChooser;
import javax.swing.JTable;
import javax.swing.JCheckBox;
import javax.swing.JTextField;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.image.BufferedImage;
import javax.swing.JEditorPane;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.io.File;
import java.io.IOException;

import javax.swing.border.Border;
import javax.swing.border.LineBorder;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableCellEditor;
import javax.swing.table.TableCellRenderer;
import javax.swing.table.TableModel;
import javax.swing.UIManager;




public class Tarea {

	private JFrame frmTarea;
	private JTextField textFieldPixelsOne;
	private JTextField textFieldPixelsOneInOcho;
	private JTable tableExercise1;

	public Image image = new Image();
	private JTable table1E2;
	private JTable table2E2;
	private JTable table1E3;
	private JTable table2E3;
	private JTable table1E4;
	private JTable tableColsE4;
	private JTable tableRowsE4;
	private JTable table1E5;
	private JTextField tfNumeroDeObjetos;
	private JLabel lbImageOtsuResult7;
	private JLabel lbImageKittlerResult7;
	private JLabel lbOtsu7;
	private JLabel lov7;
	private JLabel lblObjetos7;
	private JLabel loo7;
	private JLabel lblKittlerValue7;
	private JLabel lkv7;
	private JLabel label_47;
	private JLabel lko7;
	private JLabel lbImage7;
	private JButton btnLoadimage7;
	private JButton btnNewButton_17;
	private JLabel lbImageSahooResult7;
	private JLabel lblSahooValue7;
	private JLabel lsv7;
	private JLabel lso7;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Tarea window = new Tarea();
					window.frmTarea.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public Tarea() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmTarea = new JFrame();
		frmTarea.setTitle("Tarea 2 - Alba Magallanes");
		frmTarea.setBounds(100, 100, 802, 654);
		frmTarea.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		Border border = LineBorder.createGrayLineBorder();
		
		JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		frmTarea.getContentPane().add(tabbedPane, BorderLayout.CENTER);

		
		
		JPanel panel6 = new JPanel();
		tabbedPane.add("Excercise6", panel6);
		
		SpringLayout sl_panel6 = new SpringLayout();
		panel6.setLayout(sl_panel6);
		
		final JLabel lbImage = new JLabel("        ");
		sl_panel6.putConstraint(SpringLayout.EAST, lbImage, -10, SpringLayout.EAST, panel6);
		lbImage.setBackground(new Color(255, 240, 245));
		lbImage.setBorder(border);
		sl_panel6.putConstraint(SpringLayout.NORTH, lbImage, 10, SpringLayout.NORTH, panel6);
		sl_panel6.putConstraint(SpringLayout.SOUTH, lbImage, -338, SpringLayout.SOUTH, panel6);
		panel6.add(lbImage);
		
		final JLabel lbImageOtsuResult = new JLabel("");
		lbImageOtsuResult.setForeground(Color.RED);
		sl_panel6.putConstraint(SpringLayout.WEST, lbImage, 69, SpringLayout.EAST, lbImageOtsuResult);
		lbImageOtsuResult.setBackground(Color.WHITE);
		lbImageOtsuResult.setBorder(border);
		lbImageOtsuResult.setToolTipText("Otsu");
		sl_panel6.putConstraint(SpringLayout.WEST, lbImageOtsuResult, 10, SpringLayout.WEST, panel6);
		sl_panel6.putConstraint(SpringLayout.EAST, lbImageOtsuResult, -471, SpringLayout.EAST, panel6);
		sl_panel6.putConstraint(SpringLayout.SOUTH, lbImageOtsuResult, -334, SpringLayout.SOUTH, panel6);
		sl_panel6.putConstraint(SpringLayout.NORTH, lbImageOtsuResult, 14, SpringLayout.NORTH, panel6);
		panel6.add(lbImageOtsuResult);
				
		final JLabel lbImageKittlerResult = new JLabel("");
		sl_panel6.putConstraint(SpringLayout.WEST, lbImageKittlerResult, 10, SpringLayout.WEST, panel6);
		sl_panel6.putConstraint(SpringLayout.SOUTH, lbImageKittlerResult, -56, SpringLayout.SOUTH, panel6);
		lbImageKittlerResult.setToolTipText("Kittler");
		lbImageKittlerResult.setBackground(new Color(255, 228, 225));
		lbImageKittlerResult.setBorder(border);
		panel6.add(lbImageKittlerResult);
		
		final JLabel lbImageSahooResult = new JLabel("        ");
		sl_panel6.putConstraint(SpringLayout.NORTH, lbImageSahooResult, 0, SpringLayout.NORTH, lbImageKittlerResult);
		sl_panel6.putConstraint(SpringLayout.WEST, lbImageSahooResult, 159, SpringLayout.EAST, lbImageKittlerResult);
		sl_panel6.putConstraint(SpringLayout.SOUTH, lbImageSahooResult, -72, SpringLayout.SOUTH, panel6);
		sl_panel6.putConstraint(SpringLayout.EAST, lbImageSahooResult, 0, SpringLayout.EAST, lbImage);
		lbImageSahooResult.setToolTipText("Sahoo");
		lbImageSahooResult.setBackground(new Color(255, 240, 245));
		lbImageSahooResult.setBorder(border);
		panel6.add(lbImageSahooResult);
				
				JButton btnNewButton_1 = new JButton("Change");
				btnNewButton_1.setEnabled(false);
				sl_panel6.putConstraint(SpringLayout.NORTH, btnNewButton_1, 6, SpringLayout.SOUTH, lbImage);
				sl_panel6.putConstraint(SpringLayout.WEST, btnNewButton_1, 575, SpringLayout.WEST, panel6);
				btnNewButton_1.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent arg0) {
						image.segmenta100Imagenes();
					}
				});
				panel6.add(btnNewButton_1);
				
				JLabel lbOtsu = new JLabel("Otsu Value");
				sl_panel6.putConstraint(SpringLayout.NORTH, lbImageKittlerResult, 6, SpringLayout.SOUTH, lbOtsu);
				sl_panel6.putConstraint(SpringLayout.EAST, lbOtsu, -503, SpringLayout.WEST, btnNewButton_1);
				lbOtsu.setFont(new Font("Segoe UI", Font.PLAIN, 13));
				panel6.add(lbOtsu);
				
				final JLabel lov = new JLabel("0");
				sl_panel6.putConstraint(SpringLayout.WEST, lov, 9, SpringLayout.EAST, lbOtsu);
				sl_panel6.putConstraint(SpringLayout.EAST, lov, 49, SpringLayout.EAST, lbOtsu);
				lov.setFont(new Font("Segoe UI", Font.PLAIN, 13));
				panel6.add(lov);
				
				JLabel lblObjetos = new JLabel("# Objetos");
				sl_panel6.putConstraint(SpringLayout.SOUTH, lblObjetos, -6, SpringLayout.NORTH, lbImageKittlerResult);
				lblObjetos.setFont(new Font("Segoe UI", Font.PLAIN, 13));
				panel6.add(lblObjetos);
				
				final JLabel loo = new JLabel("0");
				sl_panel6.putConstraint(SpringLayout.NORTH, loo, 273, SpringLayout.NORTH, panel6);
				sl_panel6.putConstraint(SpringLayout.WEST, loo, 277, SpringLayout.WEST, panel6);
				sl_panel6.putConstraint(SpringLayout.EAST, loo, -265, SpringLayout.WEST, btnNewButton_1);
				sl_panel6.putConstraint(SpringLayout.EAST, lblObjetos, -6, SpringLayout.WEST, loo);
				loo.setFont(new Font("Segoe UI", Font.PLAIN, 13));
				panel6.add(loo);
				
				JLabel lblKittlerValue = new JLabel("Kittler Value");
				sl_panel6.putConstraint(SpringLayout.NORTH, lblKittlerValue, 6, SpringLayout.SOUTH, lbImageKittlerResult);
				sl_panel6.putConstraint(SpringLayout.WEST, lblKittlerValue, 10, SpringLayout.WEST, panel6);
				lblKittlerValue.setFont(new Font("Segoe UI", Font.PLAIN, 13));
				panel6.add(lblKittlerValue);
				
				final JLabel lko = new JLabel("0");
				sl_panel6.putConstraint(SpringLayout.NORTH, lko, 6, SpringLayout.SOUTH, lbImageKittlerResult);
				sl_panel6.putConstraint(SpringLayout.WEST, lko, 270, SpringLayout.WEST, panel6);
				sl_panel6.putConstraint(SpringLayout.EAST, lko, -471, SpringLayout.EAST, panel6);
				lko.setFont(new Font("Segoe UI", Font.PLAIN, 13));
				panel6.add(lko);
				
				JLabel label_4 = new JLabel("# Objetos");
				sl_panel6.putConstraint(SpringLayout.NORTH, label_4, 0, SpringLayout.NORTH, lblKittlerValue);
				sl_panel6.putConstraint(SpringLayout.EAST, label_4, -12, SpringLayout.WEST, lko);
				label_4.setFont(new Font("Segoe UI", Font.PLAIN, 13));
				panel6.add(label_4);
				
				final JLabel lkv = new JLabel("0");
				sl_panel6.putConstraint(SpringLayout.NORTH, lkv, 6, SpringLayout.SOUTH, lbImageKittlerResult);
				sl_panel6.putConstraint(SpringLayout.WEST, lkv, 1, SpringLayout.EAST, lblKittlerValue);
				sl_panel6.putConstraint(SpringLayout.EAST, lkv, -95, SpringLayout.WEST, label_4);
				lkv.setFont(new Font("Segoe UI", Font.PLAIN, 13));
				panel6.add(lkv);
				
				final JLabel lsv = new JLabel("0");
				sl_panel6.putConstraint(SpringLayout.NORTH, lsv, 6, SpringLayout.SOUTH, lbImageSahooResult);
				lsv.setFont(new Font("Segoe UI", Font.PLAIN, 13));
				panel6.add(lsv);
				
				JLabel label_6 = new JLabel("# Objetos");
				sl_panel6.putConstraint(SpringLayout.NORTH, label_6, 0, SpringLayout.NORTH, lsv);
				label_6.setFont(new Font("Segoe UI", Font.PLAIN, 13));
				panel6.add(label_6);
				
				final JLabel lso = new JLabel("0");
				sl_panel6.putConstraint(SpringLayout.EAST, label_6, -6, SpringLayout.WEST, lso);
				sl_panel6.putConstraint(SpringLayout.WEST, lso, -33, SpringLayout.EAST, lbImage);
				sl_panel6.putConstraint(SpringLayout.NORTH, lso, 6, SpringLayout.SOUTH, lbImageSahooResult);
				sl_panel6.putConstraint(SpringLayout.EAST, lso, 0, SpringLayout.EAST, lbImage);
				lso.setFont(new Font("Segoe UI", Font.PLAIN, 13));
				panel6.add(lso);
				
				JLabel lblSahooValue = new JLabel("Sahoo Value");
				sl_panel6.putConstraint(SpringLayout.EAST, lbImageKittlerResult, -157, SpringLayout.WEST, lblSahooValue);
				sl_panel6.putConstraint(SpringLayout.WEST, lsv, 6, SpringLayout.EAST, lblSahooValue);
				sl_panel6.putConstraint(SpringLayout.EAST, lsv, 39, SpringLayout.EAST, lblSahooValue);
				sl_panel6.putConstraint(SpringLayout.NORTH, lblSahooValue, 6, SpringLayout.SOUTH, lbImageSahooResult);
				sl_panel6.putConstraint(SpringLayout.WEST, lblSahooValue, 0, SpringLayout.WEST, lbImage);
				lblSahooValue.setFont(new Font("Segoe UI", Font.PLAIN, 13));
				panel6.add(lblSahooValue);
				
				JButton btnLoadimage = new JButton("loadImage");
				sl_panel6.putConstraint(SpringLayout.SOUTH, lov, 0, SpringLayout.SOUTH, btnLoadimage);
				sl_panel6.putConstraint(SpringLayout.NORTH, lbOtsu, -14, SpringLayout.SOUTH, btnLoadimage);
				sl_panel6.putConstraint(SpringLayout.SOUTH, lbOtsu, 0, SpringLayout.SOUTH, btnLoadimage);
				sl_panel6.putConstraint(SpringLayout.EAST, btnNewButton_1, -8, SpringLayout.WEST, btnLoadimage);
				sl_panel6.putConstraint(SpringLayout.NORTH, btnLoadimage, 6, SpringLayout.SOUTH, lbImage);
				sl_panel6.putConstraint(SpringLayout.EAST, btnLoadimage, 0, SpringLayout.EAST, lbImage);
				btnLoadimage.addActionListener(new ActionListener() {
					
					public void actionPerformed(ActionEvent e) {
						String filename = File.separator+"imagenes";
						JFileChooser fc = new JFileChooser(new File(filename));

						// Show open dialog; this method does not return until the dialog is closed
						fc.showOpenDialog(frmTarea);
						File selFile = fc.getSelectedFile();
						
						BufferedImage imageLoad = null;
						try {
							imageLoad = BMPDecoder.read(selFile);
							ImageIcon iconOriginal = new ImageIcon(imageLoad);
							lbImage.setIcon(iconOriginal);
						} catch (IOException e1) {
							// TODO Auto-generated catch block
							e1.printStackTrace();
						}
						try {
							BufferedImage imageLoadOtsu = BMPDecoder.read(selFile);
							int number = image.otsuMagicMethod(imageLoadOtsu);
							BufferedImage imageOtsuResult = image.umbralIt(imageLoadOtsu, number);//150
							ImageIcon iconOtsu = new ImageIcon(imageOtsuResult);
							lbImageOtsuResult.setIcon(iconOtsu);
							lov.setText(Integer.toString(number));
							Pixel [][] matrixOtsu = image.convertBItoPM(imageOtsuResult);
							int otsuObjects = image.cuentaObjetos(matrixOtsu);
							loo.setText(Integer.toString(otsuObjects));
							
						} catch (IOException e1) {
							// TODO Auto-generated catch block
							e1.printStackTrace();
						}
						
						try {
							BufferedImage imageLoadKittler = BMPDecoder.read(selFile);
							int numberKI = image.kittlerIllingworthMethod(imageLoadKittler);
							BufferedImage imageKittlerResult = image.umbralIt(imageLoadKittler, numberKI);//150
							ImageIcon iconKittler = new ImageIcon(imageKittlerResult);
							lbImageKittlerResult.setIcon(iconKittler);
							lkv.setText(Integer.toString(numberKI));
							Pixel [][] matrixKittler = image.convertBItoPM(imageKittlerResult);
							int kittlerObjects = image.cuentaObjetos(matrixKittler);
							lko.setText(Integer.toString(kittlerObjects));
						} catch (IOException e1) {
							// TODO Auto-generated catch block
							e1.printStackTrace();
						}
						try {
							BufferedImage imageLoadSahoo = BMPDecoder.read(selFile);
							int numberS = image.magicianSahooMethod(imageLoadSahoo, 0.15);
							BufferedImage imageSahooResult = image.umbralIt(imageLoadSahoo, numberS);//150
							ImageIcon iconSahoo = new ImageIcon(imageSahooResult);
							lbImageSahooResult.setIcon(iconSahoo);
							lsv.setText(Integer.toString(numberS));
							Pixel [][] matrixSahoo = image.convertBItoPM(imageSahooResult);
							int sahooObjects = image.cuentaObjetos(matrixSahoo);
							lso.setText(Integer.toString(sahooObjects));
						} catch (IOException e1) {
							// TODO Auto-generated catch block
							e1.printStackTrace();
						}
					}
				});
				
				panel6.add(btnLoadimage);
				
				JButton btnGetcentroide = new JButton("GetCentroide");
				btnGetcentroide.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent arg0) {
//						
//						String filename = File.separator+"imagenes";
//						JFileChooser fc = new JFileChooser(new File(filename));
//
//						// Show open dialog; this method does not return until the dialog is closed
//						fc.showOpenDialog(frmTarea);
//						File selFile = fc.getSelectedFile();
////						
						BufferedImage imageLoad = null;
						try {
							imageLoad = BMPDecoder.read(new File("imagenes/IMAG001.BMP"));
							ImageIcon iconOriginal = new ImageIcon(imageLoad);
							lbImage.setIcon(iconOriginal);
						} catch (IOException e1) {
							// TODO Auto-generated catch block
							e1.printStackTrace();
						}
						try {
							BufferedImage imageLoadOtsu = BMPDecoder.read(new File("imagenes/IMAG001.BMP"));
							int number = image.otsuMagicMethod(imageLoadOtsu);
							//int number = image.magicianSahooMethod(imageLoadOtsu,0.1);
							BufferedImage imageOtsuResult = image.umbralIt(imageLoadOtsu, number);//150
							
							//ImageIcon iconOtsu = new ImageIcon(imageOtsuResult);
							//lbImageOtsuResult.setIcon(iconOtsu);
							
							Pixel [][] matrixOtsu = image.convertBItoPM(imageOtsuResult);

							int otsuObjectsEtiq = image.etiquetaYCuenta(matrixOtsu);
							
							for(int i=2; i<otsuObjectsEtiq+2; i++){
								Point temp1= image.getCentroide(i);
								imageOtsuResult = image.pintaCruz(temp1.x, temp1.y, imageOtsuResult);
								System.out.printf("Objeto %d: %f \n",i,image.getHu1(i));
								System.out.printf("Objeto %d: %f \n",i,image.getHu2(i));
							}
							ImageIcon iconOtsu = new ImageIcon(imageOtsuResult);
							lbImageOtsuResult.setIcon(iconOtsu);
							
							
							
							
						} catch (IOException e1) {
							// TODO Auto-generated catch block
							e1.printStackTrace();
						}
						
						
					}
				});
				sl_panel6.putConstraint(SpringLayout.NORTH, btnGetcentroide, 6, SpringLayout.SOUTH, lbImage);
				sl_panel6.putConstraint(SpringLayout.EAST, btnGetcentroide, 0, SpringLayout.EAST, lblSahooValue);
				panel6.add(btnGetcentroide);
				JPanel panel7 = new JPanel();		
				
				//--------------------------------------------------------------------------------------------------------------------------------------------------------		
				
				tabbedPane.add("Excercise7 & 8", panel7);
				
				
				SpringLayout sl_panel7 = new SpringLayout();
				panel7.setLayout(sl_panel7);
				lbImage7 = new JLabel("        ");
				sl_panel7.putConstraint(SpringLayout.WEST, lbImage7, 469, SpringLayout.WEST, panel7);
				sl_panel7.putConstraint(SpringLayout.EAST, lbImage7, -10, SpringLayout.EAST, panel7);
				lbImage7.setBackground(new Color(255, 240, 245));
				lbImage7.setBorder(border);
				sl_panel7.putConstraint(SpringLayout.NORTH, lbImage7, 10, SpringLayout.NORTH, panel7);
				sl_panel7.putConstraint(SpringLayout.SOUTH, lbImage7, -338, SpringLayout.SOUTH, panel7);
				panel7.add(lbImage7);
				lbImageOtsuResult7 = new JLabel("");
				sl_panel7.putConstraint(SpringLayout.NORTH, lbImageOtsuResult7, 0, SpringLayout.NORTH, panel7);
				sl_panel7.putConstraint(SpringLayout.WEST, lbImageOtsuResult7, 10, SpringLayout.WEST, panel7);
				sl_panel7.putConstraint(SpringLayout.SOUTH, lbImageOtsuResult7, -348, SpringLayout.SOUTH, panel7);
				sl_panel7.putConstraint(SpringLayout.EAST, lbImageOtsuResult7, -159, SpringLayout.WEST, lbImage7);
				lbImageOtsuResult7.setBackground(new Color(255, 240, 245));
				lbImageOtsuResult7.setBorder(border);
				lbImageOtsuResult7.setToolTipText("Otsu");
				panel7.add(lbImageOtsuResult7);
				lbImageKittlerResult7 = new JLabel("");
				sl_panel7.putConstraint(SpringLayout.WEST, lbImageKittlerResult7, 10, SpringLayout.WEST, panel7);
				sl_panel7.putConstraint(SpringLayout.EAST, lbImageKittlerResult7, -469, SpringLayout.EAST, panel7);
				sl_panel7.putConstraint(SpringLayout.SOUTH, lbImageKittlerResult7, -56, SpringLayout.SOUTH, panel7);
				lbImageKittlerResult7.setToolTipText("Kittler");
				lbImageKittlerResult7.setBackground(new Color(255, 228, 225));
				lbImageKittlerResult7.setBorder(border);
				panel7.add(lbImageKittlerResult7);
				lbImageSahooResult7 = new JLabel("        ");
				sl_panel7.putConstraint(SpringLayout.WEST, lbImageSahooResult7, 159, SpringLayout.EAST, lbImageKittlerResult7);
				sl_panel7.putConstraint(SpringLayout.EAST, lbImageSahooResult7, -10, SpringLayout.EAST, panel7);
				lbImageSahooResult7.setToolTipText("Sahoo");
				lbImageSahooResult7.setBackground(new Color(255, 240, 245));
				lbImageSahooResult7.setBorder(border);
				panel7.add(lbImageSahooResult7);
				btnNewButton_17 = new JButton("100 Imagenes");
				sl_panel7.putConstraint(SpringLayout.NORTH, lbImageSahooResult7, 6, SpringLayout.SOUTH, btnNewButton_17);
				sl_panel7.putConstraint(SpringLayout.NORTH, btnNewButton_17, 6, SpringLayout.SOUTH, lbImage7);
				sl_panel7.putConstraint(SpringLayout.WEST, btnNewButton_17, 575, SpringLayout.WEST, panel7);
				btnNewButton_17.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent arg0) {
						image.segmenta100Imagenes();
					}
				});
				panel7.add(btnNewButton_17);
				lbOtsu7 = new JLabel("Otsu Value");
				sl_panel7.putConstraint(SpringLayout.NORTH, lbImageKittlerResult7, 13, SpringLayout.SOUTH, lbOtsu7);
				sl_panel7.putConstraint(SpringLayout.EAST, lbOtsu7, -503, SpringLayout.WEST, btnNewButton_17);
				lbOtsu7.setFont(new Font("Segoe UI", Font.PLAIN, 13));
				panel7.add(lbOtsu7);
				lov7 = new JLabel("0");
				sl_panel7.putConstraint(SpringLayout.WEST, lov7, 9, SpringLayout.EAST, lbOtsu7);
				sl_panel7.putConstraint(SpringLayout.EAST, lov7, 49, SpringLayout.EAST, lbOtsu7);
				lov7.setFont(new Font("Segoe UI", Font.PLAIN, 13));
				panel7.add(lov7);
				lblObjetos7 = new JLabel("<html># Objetos Tetrapixel <br> # Objetos Etiquetado</html>");
				sl_panel7.putConstraint(SpringLayout.NORTH, lblObjetos7, 6, SpringLayout.SOUTH, lbImageOtsuResult7);
				sl_panel7.putConstraint(SpringLayout.WEST, lblObjetos7, 6, SpringLayout.EAST, lov7);
				sl_panel7.putConstraint(SpringLayout.SOUTH, lblObjetos7, -13, SpringLayout.NORTH, lbImageKittlerResult7);
				sl_panel7.putConstraint(SpringLayout.EAST, lblObjetos7, 147, SpringLayout.EAST, lov7);
				lblObjetos7.setFont(new Font("Segoe UI", Font.PLAIN, 13));
				panel7.add(lblObjetos7);
				loo7 = new JLabel("0");
				sl_panel7.putConstraint(SpringLayout.NORTH, loo7, -2, SpringLayout.NORTH, lblObjetos7);
				sl_panel7.putConstraint(SpringLayout.WEST, loo7, 6, SpringLayout.EAST, lblObjetos7);
				sl_panel7.putConstraint(SpringLayout.EAST, loo7, -268, SpringLayout.WEST, btnNewButton_17);
				loo7.setFont(new Font("Segoe UI", Font.PLAIN, 13));
				panel7.add(loo7);
				lblKittlerValue7 = new JLabel("Kittler Value");
				sl_panel7.putConstraint(SpringLayout.NORTH, lblKittlerValue7, 6, SpringLayout.SOUTH, lbImageKittlerResult7);
				sl_panel7.putConstraint(SpringLayout.WEST, lblKittlerValue7, 10, SpringLayout.WEST, panel7);
				lblKittlerValue7.setFont(new Font("Segoe UI", Font.PLAIN, 13));
				panel7.add(lblKittlerValue7);
				lko7 = new JLabel("0");
				sl_panel7.putConstraint(SpringLayout.NORTH, lko7, 6, SpringLayout.SOUTH, lbImageKittlerResult7);
				sl_panel7.putConstraint(SpringLayout.WEST, lko7, 0, SpringLayout.WEST, loo7);
				sl_panel7.putConstraint(SpringLayout.EAST, lko7, -471, SpringLayout.EAST, panel7);
				lko7.setFont(new Font("Segoe UI", Font.PLAIN, 13));
				panel7.add(lko7);
				lkv7 = new JLabel("0");
				sl_panel7.putConstraint(SpringLayout.NORTH, lkv7, 6, SpringLayout.SOUTH, lbImageKittlerResult7);
				sl_panel7.putConstraint(SpringLayout.WEST, lkv7, 1, SpringLayout.EAST, lblKittlerValue7);
				lkv7.setFont(new Font("Segoe UI", Font.PLAIN, 13));
				panel7.add(lkv7);
				lsv7 = new JLabel("0");
				sl_panel7.putConstraint(SpringLayout.NORTH, lsv7, 522, SpringLayout.NORTH, panel7);
				sl_panel7.putConstraint(SpringLayout.SOUTH, lbImageSahooResult7, -6, SpringLayout.NORTH, lsv7);
				lsv7.setFont(new Font("Segoe UI", Font.PLAIN, 13));
				panel7.add(lsv7);
				
				final JLabel lso7_1 = new JLabel("0");
				sl_panel7.putConstraint(SpringLayout.NORTH, lso7_1, 0, SpringLayout.NORTH, lblKittlerValue7);
				sl_panel7.putConstraint(SpringLayout.EAST, lso7_1, 0, SpringLayout.EAST, lbImage7);
				lso7_1.setFont(new Font("Segoe UI", Font.PLAIN, 13));
				panel7.add(lso7_1);
				lblSahooValue7 = new JLabel("Sahoo Value");
				sl_panel7.putConstraint(SpringLayout.WEST, lblSahooValue7, 469, SpringLayout.WEST, panel7);
				sl_panel7.putConstraint(SpringLayout.WEST, lsv7, 6, SpringLayout.EAST, lblSahooValue7);
				sl_panel7.putConstraint(SpringLayout.EAST, lsv7, 39, SpringLayout.EAST, lblSahooValue7);
				sl_panel7.putConstraint(SpringLayout.NORTH, lblSahooValue7, 6, SpringLayout.SOUTH, lbImageSahooResult7);
				lblSahooValue7.setFont(new Font("Segoe UI", Font.PLAIN, 13));
				panel7.add(lblSahooValue7);
				
				final JLabel loo7e = new JLabel("0");
				sl_panel7.putConstraint(SpringLayout.WEST, loo7e, 6, SpringLayout.EAST, lblObjetos7);
				sl_panel7.putConstraint(SpringLayout.SOUTH, loo7e, -6, SpringLayout.NORTH, lbImageKittlerResult7);
				sl_panel7.putConstraint(SpringLayout.EAST, loo7e, 0, SpringLayout.EAST, lbImageOtsuResult7);
				loo7e.setFont(new Font("Segoe UI", Font.PLAIN, 13));
				panel7.add(loo7e);
				
				JLabel label_1 = new JLabel("<html># Objetos Tetrapixel <br> # Objetos Etiquetado</html>");
				sl_panel7.putConstraint(SpringLayout.EAST, lkv7, -22, SpringLayout.WEST, label_1);
				sl_panel7.putConstraint(SpringLayout.NORTH, label_1, 6, SpringLayout.SOUTH, lbImageKittlerResult7);
				sl_panel7.putConstraint(SpringLayout.WEST, label_1, 0, SpringLayout.WEST, lblObjetos7);
				label_1.setFont(new Font("Segoe UI", Font.PLAIN, 13));
				panel7.add(label_1);
				
				final JLabel lko7e = new JLabel("0");
				sl_panel7.putConstraint(SpringLayout.NORTH, lko7e, 4, SpringLayout.SOUTH, lko7);
				sl_panel7.putConstraint(SpringLayout.WEST, lko7e, 0, SpringLayout.WEST, loo7);
				sl_panel7.putConstraint(SpringLayout.EAST, lko7e, 0, SpringLayout.EAST, lbImageOtsuResult7);
				lko7e.setFont(new Font("Segoe UI", Font.PLAIN, 13));
				panel7.add(lko7e);
				
				JLabel label_3 = new JLabel("<html># Objetos Tetrapixel <br> # Objetos Etiquetado</html>");
				sl_panel7.putConstraint(SpringLayout.EAST, label_3, -49, SpringLayout.EAST, panel7);
				sl_panel7.putConstraint(SpringLayout.WEST, lso7_1, 6, SpringLayout.EAST, label_3);
				sl_panel7.putConstraint(SpringLayout.SOUTH, label_3, 0, SpringLayout.SOUTH, label_1);
				label_3.setFont(new Font("Segoe UI", Font.PLAIN, 13));
				panel7.add(label_3);
				
				final JLabel lso7e = new JLabel("0");
				sl_panel7.putConstraint(SpringLayout.WEST, lso7e, 0, SpringLayout.WEST, lso7_1);
				sl_panel7.putConstraint(SpringLayout.SOUTH, lso7e, 0, SpringLayout.SOUTH, label_1);
				sl_panel7.putConstraint(SpringLayout.EAST, lso7e, 0, SpringLayout.EAST, lbImage7);
				lso7e.setFont(new Font("Segoe UI", Font.PLAIN, 13));
				panel7.add(lso7e);
				btnLoadimage7 = new JButton("loadImage");
				sl_panel7.putConstraint(SpringLayout.SOUTH, lov7, 0, SpringLayout.SOUTH, btnLoadimage7);
				sl_panel7.putConstraint(SpringLayout.NORTH, lbOtsu7, -14, SpringLayout.SOUTH, btnLoadimage7);
				sl_panel7.putConstraint(SpringLayout.SOUTH, lbOtsu7, 0, SpringLayout.SOUTH, btnLoadimage7);
				sl_panel7.putConstraint(SpringLayout.EAST, btnNewButton_17, -8, SpringLayout.WEST, btnLoadimage7);
				sl_panel7.putConstraint(SpringLayout.NORTH, btnLoadimage7, 6, SpringLayout.SOUTH, lbImage7);
				sl_panel7.putConstraint(SpringLayout.EAST, btnLoadimage7, 0, SpringLayout.EAST, lbImage7);
				btnLoadimage7.addActionListener(new ActionListener() {
					
					public void actionPerformed(ActionEvent e) {
						String filename = File.separator+"imagenes";
						JFileChooser fc = new JFileChooser(new File(filename));

						// Show open dialog; this method does not return until the dialog is closed
						fc.showOpenDialog(frmTarea);
						File selFile = fc.getSelectedFile();
						
						BufferedImage imageLoad = null;
						try {
							imageLoad = BMPDecoder.read(selFile);
							ImageIcon iconOriginal = new ImageIcon(imageLoad);
							lbImage7.setIcon(iconOriginal);
						} catch (IOException e1) {
							// TODO Auto-generated catch block
							e1.printStackTrace();
						}
						try {
							BufferedImage imageLoadOtsu = BMPDecoder.read(selFile);
							int number = image.otsuMagicMethod(imageLoadOtsu);
							BufferedImage imageOtsuResult = image.umbralIt(imageLoadOtsu, number);//150
							ImageIcon iconOtsu = new ImageIcon(imageOtsuResult);
							lbImageOtsuResult7.setIcon(iconOtsu);
							lov7.setText(Integer.toString(number));
							Pixel [][] matrixOtsu = image.convertBItoPM(imageOtsuResult);
							int otsuObjects = image.cuentaObjetos(matrixOtsu);
							int otsuObjectsEtiq = image.etiquetaYCuenta(matrixOtsu);
							loo7.setText(Integer.toString(otsuObjects));
							loo7e.setText(Integer.toString(otsuObjectsEtiq));
							
						} catch (IOException e1) {
							// TODO Auto-generated catch block
							e1.printStackTrace();
						}
						
						try {
							BufferedImage imageLoadKittler = BMPDecoder.read(selFile);
							int numberKI = image.kittlerIllingworthMethod(imageLoadKittler);
							BufferedImage imageKittlerResult = image.umbralIt(imageLoadKittler, numberKI);//150
							ImageIcon iconKittler = new ImageIcon(imageKittlerResult);
							lbImageKittlerResult7.setIcon(iconKittler);
							lkv7.setText(Integer.toString(numberKI));
							Pixel [][] matrixKittler = image.convertBItoPM(imageKittlerResult);
							int kittlerObjects = image.cuentaObjetos(matrixKittler);
							int kittlerObjectsEtiq = image.etiquetaYCuenta(matrixKittler);
							lko7.setText(Integer.toString(kittlerObjects));
							lko7e.setText(Integer.toString(kittlerObjectsEtiq));
						} catch (IOException e1) {
							// TODO Auto-generated catch block
							e1.printStackTrace();
						}
						try {
							BufferedImage imageLoadSahoo = BMPDecoder.read(selFile);
							int numberS = image.magicianSahooMethod(imageLoadSahoo, 0.15);
							BufferedImage imageSahooResult = image.umbralIt(imageLoadSahoo, numberS);//150
							ImageIcon iconSahoo = new ImageIcon(imageSahooResult);
							lbImageSahooResult7.setIcon(iconSahoo);
							lsv7.setText(Integer.toString(numberS));
							Pixel [][] matrixSahoo = image.convertBItoPM(imageSahooResult);
							int sahooObjects = image.cuentaObjetos(matrixSahoo);
							int sahooObjectsEtiq = image.etiquetaYCuenta(matrixSahoo);
							lso7_1.setText(Integer.toString(sahooObjects));
							lso7e.setText(Integer.toString(sahooObjectsEtiq));
						} catch (IOException e1) {
							// TODO Auto-generated catch block
							e1.printStackTrace();
						}
					}
				});
				
				panel7.add(btnLoadimage7);
				
				btnLoadimage7.addMouseListener(new MouseAdapter() {
					@Override
					public void mouseClicked(MouseEvent arg0) {
						BufferedImage image;
						try {
							image = ImageIO.read(new File("imagenes/IMAG001.BMP"));
							ImageIcon icon = new ImageIcon(image);
							lbImage7.setIcon(icon);
						} catch (IOException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
						
						
					}
				});
				
				btnLoadimage.addMouseListener(new MouseAdapter() {
					@Override
					public void mouseClicked(MouseEvent arg0) {
						BufferedImage image;
						try {
							image = ImageIO.read(new File("imagenes/IMAG001.BMP"));
							ImageIcon icon = new ImageIcon(image);
							lbImage.setIcon(icon);
						} catch (IOException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
						
						
					}
				});
		
		final JLabel lbImage7_1;
		
		final JLabel lbImageOtsuResult7_1;
				
		final JLabel lbImageKittlerResult7_1;
		
		final JLabel lbImageSahooResult7_1;
				
				JButton btnNewButton_17_1;
				
				final JLabel lbOtsu7_1;
				
				final JLabel lov7_1;
				
				final JLabel lblObjetos7_1;
				
				final JLabel loo7_1;
				
				final JLabel lblKittlerValue7_1;
				
				final JLabel lko7_1;
				
				final JLabel lkv7_1;
				
				final JLabel lsv7_1;
				
				final JLabel label_67_1;
				
				final JLabel lblSahooValue7_1;
				
				JButton btnLoadimage7_1;

	
	}
	
	
	public class CustomTableCellRenderer extends DefaultTableCellRenderer {
	    public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus, int row, int column) 
	    {
	        Component cell = super.getTableCellRendererComponent(table, value, isSelected, hasFocus, row, column);
	        if( value instanceof Integer )
	        {
	            Integer amount = (Integer) value;
	            switch( amount.intValue() ){
	            case 0:
	            	cell.setBackground( Color.white );
	            	break;
	            case 1:
	            	cell.setBackground( Color.gray );
	            	break;
	            case 2:
	            	cell.setBackground( Color.pink );
	            	break;
	            case 3:
	            	cell.setBackground( Color.cyan );
	            	break;
	            case 4:
	            	cell.setBackground( Color.yellow );
	            	break;
	            default:
	            	cell.setBackground( Color.orange );
	            	break;
	            
	            }
//	            if( amount.intValue() == 0 )
//	            {
//	                cell.setBackground( Color.white );
//	                // You can also customize the Font and Foreground this way
//	                // cell.setForeground();
//	                // cell.setFont();
//	            }
//	            else
//	            {
//	                cell.setBackground( Color.gray );
//	            }
	        }
	        return cell;
	    }
	}
}

