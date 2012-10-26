import java.awt.Color;
import java.awt.Component;
import java.awt.Cursor;
import java.awt.Dimension;
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
import javax.swing.JTextArea;
import javax.swing.JScrollPane;
import javax.swing.SwingConstants;




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
		frmTarea.setBounds(100, 100, 940, 654);
		frmTarea.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		Border border = LineBorder.createGrayLineBorder();
		
		JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		frmTarea.getContentPane().add(tabbedPane, BorderLayout.CENTER);

		JPanel panel1 = new JPanel();
		
		tabbedPane.add("Excercise1", panel1);
		SpringLayout sl_panel1 = new SpringLayout();
		panel1.setLayout(sl_panel1);
		
		JLabel lbl1 = new JLabel("Img1");
		sl_panel1.putConstraint(SpringLayout.NORTH, lbl1, 10, SpringLayout.NORTH, panel1);
		sl_panel1.putConstraint(SpringLayout.WEST, lbl1, 10, SpringLayout.WEST, panel1);
		sl_panel1.putConstraint(SpringLayout.SOUTH, lbl1, 234, SpringLayout.NORTH, panel1);
		sl_panel1.putConstraint(SpringLayout.EAST, lbl1, 311, SpringLayout.WEST, panel1);
		panel1.add(lbl1);
		
		JLabel lbl2 = new JLabel("Img2");
		sl_panel1.putConstraint(SpringLayout.NORTH, lbl2, 10, SpringLayout.NORTH, panel1);
		sl_panel1.putConstraint(SpringLayout.WEST, lbl2, 6, SpringLayout.EAST, lbl1);
		sl_panel1.putConstraint(SpringLayout.SOUTH, lbl2, 234, SpringLayout.NORTH, panel1);
		sl_panel1.putConstraint(SpringLayout.EAST, lbl2, 307, SpringLayout.EAST, lbl1);
		panel1.add(lbl2);
		
		JLabel lbl3 = new JLabel("Img3");
		sl_panel1.putConstraint(SpringLayout.NORTH, lbl3, 6, SpringLayout.SOUTH, lbl1);
		sl_panel1.putConstraint(SpringLayout.WEST, lbl3, 10, SpringLayout.WEST, panel1);
		sl_panel1.putConstraint(SpringLayout.SOUTH, lbl3, 230, SpringLayout.SOUTH, lbl1);
		sl_panel1.putConstraint(SpringLayout.EAST, lbl3, 0, SpringLayout.EAST, lbl1);
		panel1.add(lbl3);
		
		JLabel lbl4 = new JLabel("Img4");
		sl_panel1.putConstraint(SpringLayout.NORTH, lbl4, 31, SpringLayout.SOUTH, lbl2);
		sl_panel1.putConstraint(SpringLayout.WEST, lbl4, 6, SpringLayout.EAST, lbl3);
		sl_panel1.putConstraint(SpringLayout.SOUTH, lbl4, -112, SpringLayout.SOUTH, panel1);
		sl_panel1.putConstraint(SpringLayout.EAST, lbl4, 0, SpringLayout.EAST, lbl2);
		panel1.add(lbl4);
		
		JLabel lbl5 = new JLabel("Img5");
		sl_panel1.putConstraint(SpringLayout.NORTH, lbl5, 131, SpringLayout.NORTH, panel1);
		sl_panel1.putConstraint(SpringLayout.WEST, lbl5, 9, SpringLayout.EAST, lbl2);
		sl_panel1.putConstraint(SpringLayout.SOUTH, lbl5, -246, SpringLayout.SOUTH, panel1);
		sl_panel1.putConstraint(SpringLayout.EAST, lbl5, 305, SpringLayout.EAST, lbl4);
		panel1.add(lbl5);
		
		
		try {
			BufferedImage imageLoad1 = BMPDecoder.read(new File("imagenes/IMAG0101.BMP"));
			BufferedImage imageLoad2 = BMPDecoder.read(new File("imagenes/IMAG0201.BMP"));
			BufferedImage imageLoad3 = BMPDecoder.read(new File("imagenes/IMAG0301.BMP"));
			BufferedImage imageLoad4 = BMPDecoder.read(new File("imagenes/IMAG0401.BMP"));
			BufferedImage imageLoad5 = BMPDecoder.read(new File("imagenes/IMAG0501.BMP"));
			
			int number1 = image.kittlerIllingworthMethod(imageLoad1);
			BufferedImage imageResult1 = image.umbralIt(imageLoad1, number1);//150
			Pixel [][] matrix1 = image.convertBItoPM(imageResult1);
			int objectsEtiq1 = image.etiquetaYCuenta(matrix1);
			
			int regionToBeCalculated=0;
			int tempRegion=0;
			
			for(int w=2; w<objectsEtiq1+2; w++){
				int temp = image.calculaMomento(0, 0, w);
				if(temp>tempRegion){
					tempRegion = temp;
					regionToBeCalculated = w;
				}
			}
	
			Point temp= image.getCentroide(regionToBeCalculated);
			imageResult1 = image.pintaCruz((int)temp.x, (int)temp.y, imageResult1);
		
			
			int number2 = image.kittlerIllingworthMethod(imageLoad2);
			BufferedImage imageResult2 = image.umbralIt(imageLoad2, number2);//150
			Pixel [][] matrix2 = image.convertBItoPM(imageResult2);
			int objectsEtiq2 = image.etiquetaYCuenta(matrix2);
			for(int i=2; i<objectsEtiq2+2; i++){
				Point temp1= image.getCentroide(i);
				imageResult2 = image.pintaCruz((int)temp1.x, (int)temp1.y, imageResult2);
			}
			
			int number3 = image.kittlerIllingworthMethod(imageLoad3);
			BufferedImage imageResult3 = image.umbralIt(imageLoad3, number3);//150
			Pixel [][] matrix3 = image.convertBItoPM(imageResult3);
			int objectsEtiq3 = image.etiquetaYCuenta(matrix3);
			for(int i=2; i<objectsEtiq3+2; i++){
				Point temp1= image.getCentroide(i);
				imageResult3 = image.pintaCruz((int)temp1.x, (int)temp1.y, imageResult3);
			}
			
			int number4 = image.kittlerIllingworthMethod(imageLoad4);
			BufferedImage imageResult4 = image.umbralIt(imageLoad4, number4);//150
			Pixel [][] matrix4 = image.convertBItoPM(imageResult4);
			int objectsEtiq4 = image.etiquetaYCuenta(matrix4);
			for(int i=2; i<objectsEtiq4+2; i++){
				Point temp1= image.getCentroide(i);
				imageResult4 = image.pintaCruz((int)temp1.x, (int)temp1.y, imageResult4);
			}
			
			int number5 = image.kittlerIllingworthMethod(imageLoad5);
			BufferedImage imageResult5 = image.umbralIt(imageLoad5, number5);//150
			Pixel [][] matrix5 = image.convertBItoPM(imageResult5);
			int objectsEtiq5 = image.etiquetaYCuenta(matrix5);
			for(int i=2; i<objectsEtiq5+2; i++){
				Point temp1= image.getCentroide(i);
				imageResult5 = image.pintaCruz((int)temp1.x, (int)temp1.y, imageResult5);
			}
			
			
			ImageIcon iconO1 = new ImageIcon(imageResult1);
			lbl1.setIcon(iconO1);
			ImageIcon iconO2 = new ImageIcon(imageResult2);
			lbl2.setIcon(iconO2);
			ImageIcon iconO3 = new ImageIcon(imageResult3);
			lbl3.setIcon(iconO3);
			ImageIcon iconO4 = new ImageIcon(imageResult4);
			lbl4.setIcon(iconO4);
			ImageIcon iconO5 = new ImageIcon(imageResult5);
			lbl5.setIcon(iconO5);
			
			
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		
		
		
		final JPanel panel6 = new JPanel();
		tabbedPane.add("Excercise2", panel6);
		
		
		
		SpringLayout sl_panel6 = new SpringLayout();
		panel6.setLayout(sl_panel6);
		
		final JTextArea consoleArea = new JTextArea();
		sl_panel6.putConstraint(SpringLayout.NORTH, consoleArea, 71, SpringLayout.NORTH, panel6);
		sl_panel6.putConstraint(SpringLayout.WEST, consoleArea, 52, SpringLayout.WEST, panel6);
		sl_panel6.putConstraint(SpringLayout.SOUTH, consoleArea, 180, SpringLayout.NORTH, panel6);
		sl_panel6.putConstraint(SpringLayout.EAST, consoleArea, 357, SpringLayout.WEST, panel6);
		consoleArea.setEditable(false);
		consoleArea.setText("Image Name		 Hu1	Hu2	F1	F2	F3	F4 \n");
		panel6.add(consoleArea);
		
		JScrollPane scrollPane = new JScrollPane(consoleArea);
		scrollPane.setPreferredSize(new Dimension(700, 600));
		panel6.add(scrollPane);
		
				
				JButton btnGetcentroide = new JButton("RUN");
				sl_panel6.putConstraint(SpringLayout.NORTH, btnGetcentroide, 10, SpringLayout.NORTH, panel6);
				sl_panel6.putConstraint(SpringLayout.WEST, btnGetcentroide, 6, SpringLayout.EAST, scrollPane);
				sl_panel6.putConstraint(SpringLayout.SOUTH, btnGetcentroide, 40, SpringLayout.NORTH, panel6);
				sl_panel6.putConstraint(SpringLayout.EAST, btnGetcentroide, -10, SpringLayout.EAST, panel6);
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
							imageLoad = BMPDecoder.read(new File("imagenes/IMAG0101.BMP"));
							ImageIcon iconOriginal = new ImageIcon(imageLoad);
							
						} catch (IOException e1) {
							// TODO Auto-generated catch block
							e1.printStackTrace();
						}
						try {
							BufferedImage imageLoadOtsu = BMPDecoder.read(new File("imagenes/IMAG0101.BMP"));
							int number = image.kittlerIllingworthMethod(imageLoadOtsu);
							//int number = image.magicianSahooMethod(imageLoadOtsu,0.1);
							BufferedImage imageOtsuResult = image.umbralIt(imageLoadOtsu, number);//150
							
							//ImageIcon iconOtsu = new ImageIcon(imageOtsuResult);
							//lbImageOtsuResult.setIcon(iconOtsu);
							
							Pixel [][] matrixOtsu = image.convertBItoPM(imageOtsuResult);

							int otsuObjectsEtiq = image.etiquetaYCuenta(matrixOtsu);
							
							for(int i=2; i<otsuObjectsEtiq+2; i++){
								Point temp1= image.getCentroide(i);
								imageOtsuResult = image.pintaCruz((int)temp1.x, (int)temp1.y, imageOtsuResult);

								System.out.printf("Objeto %d: %f \n",i,image.getHu1(i));
								System.out.printf("Objeto %d: %f \n",i,image.getHu2(i));
								
								System.out.printf("Objeto %d: %f \n",i,image.getFS1(i));
								System.out.printf("Objeto %d: %f \n",i,image.getFS2(i));
								System.out.printf("Objeto %d: %f \n",i,image.getFS3(i));
								System.out.printf("Objeto %d: %f \n",i,image.getFS4(i));
								
							}
							ImageIcon iconOtsu = new ImageIcon(imageOtsuResult);
							
							panel6.setCursor(Cursor.getPredefinedCursor(Cursor.WAIT_CURSOR));
							image.treat100Images(consoleArea);
							panel6.setCursor(Cursor.getPredefinedCursor(Cursor.DEFAULT_CURSOR ));
							
						} catch (IOException e1) {
							// TODO Auto-generated catch block
							e1.printStackTrace();
						}
						
						
					}
				});
				
				panel6.add(btnGetcentroide);
				
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

