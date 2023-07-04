package interfaces;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.LinkedList;
import java.util.List;

import javax.swing.DefaultComboBoxModel;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JSeparator;
import javax.swing.JTable;
import javax.swing.JTextPane;
import javax.swing.border.LineBorder;
import javax.swing.border.MatteBorder;

import auxiliary_classes.AuxiliarySubjectMostMaterialUse;
import classes.Book;
import classes.Bookcase;
import classes.Carreer;
import classes.Document;
import classes.Exercices;
import classes.Material;
import logica.ComboboxModelCarrer;
import logica.TabelModelSubjectMostUseMaterial;
import logica.TableModelMostUseMaterial;


public class BusquedaAvanzada extends JFrame {

	private JPanel contentPane;
	private JLabel lblNewLabel;
	private JPanel panelOpcionesBusqueda;
	private JButton btnCerrar;
	private JLabel lblNewLabel_1;
	private JButton btn1Mostrar;
	private JButton btn2Mostrar;
	private JButton btn5Mostrar;
	private JPanel panelMaterialesMasUsado;
	private JScrollPane scrollPane;
	private JLabel lblNewLabel_1_1;
	private JButton btn1Ocultar;
	private JButton btn2Ocultar;
	private JButton btn5Ocultar;
	private JSeparator separator;
	private JSeparator separator_1;
	private JPanel panelMyorCantidadMat;
	private JLabel lblNewLabel_1_2;
	private JTextPane txtpnEnEstaPantalla;
	private JPanel panel;
	private JScrollPane scrollPane_3;
	private JLabel lblNewLabel_1_5;

	private JLabel lblFondo;

  private JLabel lblNewLabel_1_5_1;
	private JComboBox comboBox;
	private JLabel lblNewLabel_1_5_1_1;
	private JComboBox comboBox_1;
	//private TableModel model;
	private TableModelMostUseMaterial tableModel;

	private JTable tablePaneMayorCantidadMateriales;
	private JScrollPane scrollPaneMayorCantidadMateriales;
	private JLabel CantidadMateriales;

  
	//instancia de bookcase
	Bookcase bookcase;
	private JTable tablaMaterialesMasUsados;
	private JScrollPane scrollPaneMaterialesMasUsados;


	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					BusquedaAvanzada frame = new BusquedaAvanzada();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public BusquedaAvanzada() {
		this.bookcase = Bookcase.getInstance();
		setUndecorated(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(400, 300, 1015, 554);
		contentPane = new JPanel();
		contentPane.setBorder(new LineBorder(new Color(0, 0, 0)));
		setLocationRelativeTo(null);
		//model = new 
		
		tableModel = new TableModelMostUseMaterial();
		
		setContentPane(contentPane);
		contentPane.setLayout(null);
		contentPane.add(getScrollPane_3());
		contentPane.add(getPanelMyorCantidadMat());
		contentPane.add(getScrollPane());
		contentPane.add(getPanelOpcionesBusqueda());
		contentPane.add(getLblNewLabel());
		contentPane.add(getBtnCerrar());

		contentPane.add(getLblFondo());
		setIconImage(
				Toolkit.getDefaultToolkit().getImage(Principal.class.getResource("/icons/icons8-book-64 (2).png")));
		
		//agregado por diefo hoy 3/7/23 11:09 am
		//agregado el contrusctor 
		this.bookcase = Bookcase.getInstance();
		

	}
	private JLabel getLblNewLabel() {
		if (lblNewLabel == null) {
			lblNewLabel = new JLabel("Búsqueda Avanzada");
			lblNewLabel.setFont(new Font("Yu Gothic UI Semibold", Font.BOLD | Font.ITALIC, 30));
			lblNewLabel.setBounds(316, 214, 336, 76);
		}
		return lblNewLabel;
	}
	private JPanel getPanelOpcionesBusqueda() {
		if (panelOpcionesBusqueda == null) {
			panelOpcionesBusqueda = new JPanel();
			panelOpcionesBusqueda.setBorder(new MatteBorder(1, 1, 1, 1, (Color) new Color(0, 0, 0)));
			panelOpcionesBusqueda.setBackground(new Color(255, 255, 255));
			panelOpcionesBusqueda.setBounds(0, 56, 218, 442);
			panelOpcionesBusqueda.setLayout(null);
			panelOpcionesBusqueda.add(getLblNewLabel_1());
			panelOpcionesBusqueda.add(getBtn1Mostrar());
			panelOpcionesBusqueda.add(getBtn2Mostrar());
			panelOpcionesBusqueda.add(getBtn5Mostrar());
			panelOpcionesBusqueda.add(getBtn1Ocultar());
			panelOpcionesBusqueda.add(getBtn2Ocultar());
			panelOpcionesBusqueda.add(getBtn5Ocultar());
			panelOpcionesBusqueda.add(getSeparator());
			panelOpcionesBusqueda.add(getSeparator_1());
			
			JSeparator separator_2 = new JSeparator();
			separator_2.setBounds(33, 345, 152, 2);
			panelOpcionesBusqueda.add(separator_2);
		}
		return panelOpcionesBusqueda;
	}
	private JButton getBtnCerrar() {
		if (btnCerrar == null) {
			btnCerrar = new JButton("");
			btnCerrar.setIcon(new ImageIcon(BusquedaAvanzada.class.getResource("/icons/icons8-x-32 (1).png")));
			btnCerrar.setBounds(975, 0, 40, 32);
			
			btnCerrar.setOpaque(false);
			btnCerrar.setBorder(null);
			btnCerrar.setContentAreaFilled(false);
			btnCerrar.setFocusPainted(false);
			btnCerrar.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					dispose();
				}
			});
		}
		return btnCerrar;
	}
	private JLabel getLblNewLabel_1() {
		if (lblNewLabel_1 == null) {
			lblNewLabel_1 = new JLabel("Opciones de búsqueda:\r\n");
			lblNewLabel_1.setFont(new Font("Yu Gothic UI Semibold", Font.ITALIC, 16));
			lblNewLabel_1.setBounds(22, 11, 173, 33);
		}
		return lblNewLabel_1;
	}
	private JButton getBtn1Mostrar() {
		if (btn1Mostrar == null) {
			btn1Mostrar = new JButton("Materiales más usados:");
			btn1Mostrar.setFont(new Font("Yu Gothic UI Semibold", Font.BOLD | Font.ITALIC, 11));
			btn1Mostrar.setBounds(22, 70, 163, 40);
			
			btn1Mostrar.setOpaque(false);
			btn1Mostrar.setBorder(null);
			btn1Mostrar.setContentAreaFilled(false);
			btn1Mostrar.setFocusPainted(false);
			
			btn1Mostrar.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {	
					
					int x=788; 
					int y=443;

					btn1Ocultar.setVisible(true);
					btn1Mostrar.setVisible(false);
					
					panelMyorCantidadMat.setVisible(false);
					btn2Mostrar.setVisible(true);
					btn5Mostrar.setVisible(true);
					scrollPane_3.setVisible(false);

					
					


				//	btnEditarMostrar.setVisible(true);
                 //   btnAnnadirMostrar.setVisible(true);
                 //   panelAnnadir.setVisible(false);
					List<Material> a = bookcase.mostUseMaterial();
					
					
				     
				        if(x==788){ 
							scrollPane.show();
		   
				         Thread th = new Thread(){
				             @Override
				             public void run(){
				            	 int x=788;
				                 try{
				                   for(int i =0;i<=x;i+=2){
				                	   
				                       Thread.sleep(1);
										scrollPane.setSize(i,443);
										panelMaterialesMasUsado.setSize(i, 443);				                       
				                   }  
				                 }catch(Exception e){
				                     JOptionPane.showMessageDialog(null, e);
				                 }
				             }
				         };th.start();
				         x=788;
				        
				     }
				}
			});
		}
		return btn1Mostrar;
	}
	private JButton getBtn2Mostrar() {
		if (btn2Mostrar == null) {
			btn2Mostrar = new JButton("Mayor Cantidad de material:");
			btn2Mostrar.setFont(new Font("Yu Gothic UI Semibold", Font.BOLD | Font.ITALIC, 11));
			btn2Mostrar.setOpaque(false);
			btn2Mostrar.setBounds(22, 180, 173, 49);
			
			btn2Mostrar.setOpaque(false);
			btn2Mostrar.setBorder(null);
			btn2Mostrar.setContentAreaFilled(false);
			btn2Mostrar.setFocusPainted(false);
			
			btn2Mostrar.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {	
					
					int x=788;
					int y=443;
					btn2Ocultar.setVisible(true);
					btn2Mostrar.setVisible(false);
					btn1Mostrar.setVisible(true);
					btn5Mostrar.setVisible(true);
					 scrollPane_3.setVisible(false);
					 scrollPane.setVisible(false);

				//	btnEditarMostrar.setVisible(true);


				//	btnEditarMostrar.setVisible(true);
                 //   btnAnnadirMostrar.setVisible(true);
                 //   panelAnnadir.setVisible(false);
					
					
				     
				        if(x==788){ 
				        	panelMyorCantidadMat.show();
						//	scrollPane_1.setVisible(true);
		   
				         Thread th = new Thread(){
				             @Override
				             public void run(){
				            	 int x=788;
				                 try{
				                   for(int i =0;i<=x;i+=2){
				                	   
				                       Thread.sleep(1);
				                       panelMyorCantidadMat.setSize(i,443);
				                    

				                   }  
				                 }catch(Exception e){
				                     JOptionPane.showMessageDialog(null, e);
				                 }
				             }
				         };th.start();
				         x=788;
				        
				     }
				}
			});
		}
		return btn2Mostrar;
	}
	private JButton getBtn5Mostrar() {
		if (btn5Mostrar == null) {
			btn5Mostrar = new JButton("Buscar por carrera y año:");
			btn5Mostrar.setFont(new Font("Yu Gothic UI Semibold", Font.BOLD | Font.ITALIC, 11));
			btn5Mostrar.setBounds(22, 307, 163, 40);
			
			btn5Mostrar.setOpaque(false);
			btn5Mostrar.setBorder(null);
			btn5Mostrar.setContentAreaFilled(false);
			btn5Mostrar.setFocusPainted(false);
			
			btn5Mostrar.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {	
					
					int x=788;
					int y=443;
					btn5Ocultar.setVisible(true);
					btn5Mostrar.setVisible(false);
					
					panelMyorCantidadMat.setVisible(false);
					btn2Mostrar.setVisible(true);
					btn1Mostrar.setVisible(true);

					
					 
				//	 scrollPane_2.setVisible(false);




				//	btnEditarMostrar.setVisible(true);
                 //   btnAnnadirMostrar.setVisible(true);
                 //   panelAnnadir.setVisible(false);
					
					
				     
				        if(x==788){ 
							scrollPane_3.show();
		   
				         Thread th = new Thread(){
				             @Override
				             public void run(){
				            	 int x=788;
				                 try{
				                   for(int i =0;i<=x;i+=2){
				                	   
				                       Thread.sleep(1);
										scrollPane_3.setSize(i,443);
										panel.setSize(i, 443);				                       
				                   }  
				                 }catch(Exception e){
				                     JOptionPane.showMessageDialog(null, e);
				                 }
				             }
				         };th.start();
				         x=788;
				        
				     }
				}
			});
		
			
			
			
			
		}
		return btn5Mostrar;
	}
	private JPanel getPanelMaterialesMasUsado() {
		if (panelMaterialesMasUsado == null) {
			panelMaterialesMasUsado = new JPanel();
			panelMaterialesMasUsado.setBorder(new LineBorder(new Color(0, 0, 0)));
			panelMaterialesMasUsado.setBackground(new Color(255, 255, 255));
			panelMaterialesMasUsado.setPreferredSize(new Dimension(0, 10000));
			panelMaterialesMasUsado.setLayout(null);
			panelMaterialesMasUsado.add(getLblNewLabel_1_1());
			panelMaterialesMasUsado.add(getScrollPaneMaterialesMasUsados());

		}
		return panelMaterialesMasUsado;
	}
	private JScrollPane getScrollPane() {
		if (scrollPane == null) {
			scrollPane = new JScrollPane();
			scrollPane.setBounds(217, 56, 788, 433);
			scrollPane.setViewportView(getPanelMaterialesMasUsado());
			
			scrollPane.setVisible(false);

		}
		return scrollPane;
	}
	private JLabel getLblNewLabel_1_1() {
		if (lblNewLabel_1_1 == null) {
			lblNewLabel_1_1 = new JLabel("Materiales más usados:");
			lblNewLabel_1_1.setBounds(247, 11, 239, 33);
			lblNewLabel_1_1.setFont(new Font("Yu Gothic UI Semibold", Font.ITALIC, 16));
		}
		return lblNewLabel_1_1;
	}
	private JButton getBtn1Ocultar() {
		if (btn1Ocultar == null) {
			btn1Ocultar = new JButton("Materiales más usados:");
			btn1Ocultar.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					
					btn1Ocultar.setVisible(false);
					btn1Mostrar.setVisible(true);
					scrollPane.setVisible(false);

				}
			});
			btn1Ocultar.setOpaque(false);
			btn1Ocultar.setFont(new Font("Yu Gothic UI Semibold", Font.BOLD | Font.ITALIC, 11));
			btn1Ocultar.setFocusPainted(false);
			btn1Ocultar.setContentAreaFilled(false);
			btn1Ocultar.setBorder(null);
			btn1Ocultar.setBounds(22, 70, 163, 40);
		}
		return btn1Ocultar;
	}
	private JButton getBtn2Ocultar() {
		if (btn2Ocultar == null) {
			btn2Ocultar = new JButton("Mayor Cantidad de material:");
			btn2Ocultar.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					btn2Ocultar.setVisible(false);
					btn2Mostrar.setVisible(true);
					panelMyorCantidadMat.setVisible(false);
					
				}
			});
			btn2Ocultar.setOpaque(false);
			btn2Ocultar.setFont(new Font("Yu Gothic UI Semibold", Font.BOLD | Font.ITALIC, 11));
			btn2Ocultar.setFocusPainted(false);
			btn2Ocultar.setContentAreaFilled(false);
			btn2Ocultar.setBorder(null);
			btn2Ocultar.setBounds(22, 180, 173, 49);
		}
		return btn2Ocultar;
	}
	private JButton getBtn5Ocultar() {
		if (btn5Ocultar == null) {
			btn5Ocultar = new JButton("Buscar por carrera y año:");
			btn5Ocultar.setOpaque(false);
			btn5Ocultar.setFont(new Font("Yu Gothic UI Semibold", Font.BOLD | Font.ITALIC, 11));
			btn5Ocultar.setFocusPainted(false);
			btn5Ocultar.setContentAreaFilled(false);
			btn5Ocultar.setBorder(null);
			btn5Ocultar.setBounds(22, 307, 163, 40);
			
			btn5Ocultar.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					btn5Ocultar.setVisible(false);
					btn5Mostrar.setVisible(true);
					panelMyorCantidadMat.setVisible(false);
					scrollPane_3.setVisible(false);


					
				}
			});
		}
		return btn5Ocultar;
	}
	private JSeparator getSeparator() {
		if (separator == null) {
			separator = new JSeparator();
			separator.setBounds(33, 108, 152, 2);
		}
		return separator;
	}
	private JSeparator getSeparator_1() {
		if (separator_1 == null) {
			separator_1 = new JSeparator();
			separator_1.setBounds(33, 224, 152, 2);
		}
		return separator_1;
	}
	private JPanel getPanelMyorCantidadMat() {
		if (panelMyorCantidadMat == null) {
			panelMyorCantidadMat = new JPanel();
			panelMyorCantidadMat.setBorder(new LineBorder(new Color(0, 0, 0)));
			panelMyorCantidadMat.setBackground(new Color(255, 255, 255));
			panelMyorCantidadMat.setBounds(217, 56, 770, 433);
			panelMyorCantidadMat.setLayout(null);
			panelMyorCantidadMat.add(getLblNewLabel_1_2());

			
			AuxiliarySubjectMostMaterialUse subjectsMostMaterialUse = bookcase.subjectsMostMaterialUse();
			//panelMyorCantidadMat.add(getTxtpnEnEstaPantalla(subjectsMostMaterialUse.getCantdida()));
			panelMyorCantidadMat.add(getScrollPaneMayorCantidadMateriales());
			panelMyorCantidadMat.add(getLblNewLabel_2_1(subjectsMostMaterialUse.getCantdida()));


			panelMyorCantidadMat.setVisible(false);
		}
		return panelMyorCantidadMat;
	}
	private JLabel getLblNewLabel_1_2() {
		if (lblNewLabel_1_2 == null) {
			lblNewLabel_1_2 = new JLabel("Asignaturas con mayor cantidad de materiales:");
			lblNewLabel_1_2.setFont(new Font("Yu Gothic UI Semibold", Font.ITALIC, 16));
			lblNewLabel_1_2.setBounds(203, 11, 364, 33);
		}
		return lblNewLabel_1_2;
	}


//	private JTextPane getTxtpnEnEstaPantalla(int cantidadMaxima) {
//		if (txtpnEnEstaPantalla == null) {
//			txtpnEnEstaPantalla = new JTextPane();
//			//txtpnEnEstaPantalla.setText("En esta pantalla irian :\r\nAsignatura:\r\nCantidad:\r\n.\r\n.\r\n.\r\n.");
//			txtpnEnEstaPantalla.setText("La mayor cantidad de materiales usado por una asignatura es : " + cantidadMaxima);
//			txtpnEnEstaPantalla.setBounds(74, 73, 260, 104);
//		}
//		return txtpnEnEstaPantalla;
//	}


	private JPanel getPanel() {
		if (panel == null) {
			panel = new JPanel();
			panel.setBackground(new Color(255, 255, 255));
			
			panel.setPreferredSize(new Dimension(0, 10000));
			panel.setLayout(null);
			panel.add(getLblNewLabel_1_5());
			panel.add(getLblNewLabel_1_5_1());
			panel.add(getComboBox());
			panel.add(getLblNewLabel_1_5_1_1());
			panel.add(getComboBox_1());

		}
		return panel;
	}
	private JScrollPane getScrollPane_3() {
		if (scrollPane_3 == null) {
			scrollPane_3 = new JScrollPane();
			scrollPane_3.setBackground(new Color(255, 255, 255));
			scrollPane_3.setBorder(new LineBorder(new Color(130, 135, 144)));
			scrollPane_3.setBounds(217, 56, 788, 433);
			scrollPane_3.setViewportView(getPanel());
			scrollPane_3.setVisible(false);
		}
		return scrollPane_3;
	}
	private JLabel getLblNewLabel_1_5() {
		if (lblNewLabel_1_5 == null) {
			lblNewLabel_1_5 = new JLabel("Buscar por carrera y año:");
			lblNewLabel_1_5.setFont(new Font("Yu Gothic UI Semibold", Font.ITALIC, 16));
			lblNewLabel_1_5.setBounds(259, 11, 190, 33);
		}
		return lblNewLabel_1_5;
	}

	private JLabel getLblFondo() {
		if (lblFondo == null) {
			lblFondo = new JLabel("");
			lblFondo.setIcon(new ImageIcon(BusquedaAvanzada.class.getResource("/icons/FondoBusquedaAvanzada.jpg")));
			lblFondo.setBounds(0, 0, 1015, 554);
		}
		return lblFondo;
	}

	private JLabel getLblNewLabel_1_5_1() {
		if (lblNewLabel_1_5_1 == null) {
			lblNewLabel_1_5_1 = new JLabel("Carrera:");
			lblNewLabel_1_5_1.setFont(new Font("Yu Gothic UI Semibold", Font.ITALIC, 14));
			lblNewLabel_1_5_1.setBounds(10, 60, 70, 26);
		}
		return lblNewLabel_1_5_1;
	}
	private JComboBox getComboBox() {
		if (comboBox == null) {
			comboBox = new JComboBox();

			//comboBox.setModel(new DefaultComboBoxModel(new String[] {"algo"}));
			LinkedList<Carreer> a = (LinkedList<Carreer>) bookcase.getAllCarrer();
			LinkedList<String> b = new LinkedList<String>();
			for (Carreer val : a) {
				b.add(val.getName());
			}
			comboBox.setModel(new ComboboxModelCarrer(b.toArray( new String[b.size()])));
			comboBox.setBounds(77, 87, 190, 38);

		}
		return comboBox;
	}
	private JLabel getLblNewLabel_1_5_1_1() {
		if (lblNewLabel_1_5_1_1 == null) {
			lblNewLabel_1_5_1_1 = new JLabel("Año:");
			lblNewLabel_1_5_1_1.setFont(new Font("Yu Gothic UI Semibold", Font.ITALIC, 14));
			lblNewLabel_1_5_1_1.setBounds(372, 60, 70, 26);
		}
		return lblNewLabel_1_5_1_1;
	}
	private JComboBox getComboBox_1() {
		if (comboBox_1 == null) {
			comboBox_1 = new JComboBox();

			comboBox_1.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					
				}
			});
			comboBox_1.setModel(new DefaultComboBoxModel(new String[] {"algo"}));
			
			comboBox_1.setBounds(77, 200, 190, 38);
		}
		return comboBox_1;
	}

	private JTable getTablaMaterialesMasUsados() {
		if (tablaMaterialesMasUsados == null) {
			tablaMaterialesMasUsados = new JTable(new TableModelMostUseMaterial());
			
			ArrayList<Material> a_test = new ArrayList<Material>();
			Calendar cal = Calendar.getInstance();
			
			a_test.add(new Book("1","1ro", "1ro", (GregorianCalendar) cal, "1ra", "1ra", "2001"));
			a_test.add(new Book("2","2do", "2do", (GregorianCalendar) cal, "2do", "2do", "2002"));
			a_test.add(new Book("3","3ra", "3ra", (GregorianCalendar) cal, "3ra", "3ra", "2003"));
			a_test.add(new Book("4","4ta", "4ta", (GregorianCalendar) cal, "4ta", "4ta", "2004"));
			a_test.add(new Book("5","5ta", "5ta", (GregorianCalendar) cal, "5ta", "5ta", "2005"));
			
			a_test.add(new Exercices("11", "exercices 1", "11",(GregorianCalendar) cal ,11,"alegra1" ));
			a_test.add(new Exercices("12", "exercices 2", "12",(GregorianCalendar) cal ,12,"alegra2" ));
			a_test.add(new Exercices("13", "exercices 3", "11",(GregorianCalendar) cal ,13,"alegra3" ));
			a_test.add(new Exercices("14", "exercices 3", "11",(GregorianCalendar) cal ,14,"alegra4" ));
			
			a_test.add(new Document("21", "doc 1", "21", (GregorianCalendar) cal, "conferencia"));
			a_test.add(new Document("22", "doc 2", "22", (GregorianCalendar) cal, "cp"));
			a_test.add(new Document("23", "doc 3", "23", (GregorianCalendar) cal, "conferencia"));
			a_test.add(new Document("24", "doc 4", "24", (GregorianCalendar) cal, "cp"));
			

			((TableModelMostUseMaterial)tablaMaterialesMasUsados.getModel()).actualizar(a_test);
		}
		return tablaMaterialesMasUsados;
	}

	/*private JScrollPane getScrollPane_() {
		if (scrollPane_1 == null) {
			scrollPane_1 = new JScrollPane();
			scrollPane_1.setBounds(0, 56, 352, 253);
			scrollPane_1.setViewportView(getTablaMaterialesMasUsados());

		}
		return tablaMaterialesMasUsados;
	}*/
	private JTable getTablePaneMayorCantidadMateriales() {
		if (tablePaneMayorCantidadMateriales == null) {
			tablePaneMayorCantidadMateriales = new JTable(new TabelModelSubjectMostUseMaterial());
			AuxiliarySubjectMostMaterialUse subjectsMostMaterialUse = bookcase.subjectsMostMaterialUse();
			((TabelModelSubjectMostUseMaterial)tablePaneMayorCantidadMateriales.getModel()).actualizar(subjectsMostMaterialUse.getSub());
			
		}
		return tablePaneMayorCantidadMateriales;
	}
	private JScrollPane getScrollPaneMayorCantidadMateriales( ) {
		if (scrollPaneMayorCantidadMateriales == null) {
			scrollPaneMayorCantidadMateriales = new JScrollPane();
			scrollPaneMayorCantidadMateriales.setBounds(0, 56, 352, 253);
			scrollPaneMayorCantidadMateriales.setViewportView(getTablePaneMayorCantidadMateriales());
		}
		return scrollPaneMayorCantidadMateriales;
	}
	private JLabel getLblNewLabel_2_1(int cantidadMateriales) {
		if (CantidadMateriales == null) {
			CantidadMateriales = new JLabel("La cantidad de materiales es: "+cantidadMateriales );
			CantidadMateriales.setBounds(31, 27, 364, 33);
		}
		return CantidadMateriales;
	}
	private JScrollPane getScrollPaneMaterialesMasUsados() {
		if (scrollPaneMaterialesMasUsados == null) {
			scrollPaneMaterialesMasUsados = new JScrollPane();
			scrollPaneMaterialesMasUsados.setBounds(0, 56, 742, 253);
			scrollPaneMaterialesMasUsados.setViewportView(getTablaMaterialesMasUsados());
		}
		return scrollPaneMaterialesMasUsados;
	}
}
