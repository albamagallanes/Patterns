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
		frmTarea.setBounds(100, 100, 802, 654);
		frmTarea.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		Border border = LineBorder.createGrayLineBorder();
		
		JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		frmTarea.getContentPane().add(tabbedPane, BorderLayout.CENTER);

		
		
		final JPanel panel6 = new JPanel();
		tabbedPane.add("Excercise6", panel6);
		
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

