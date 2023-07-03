package interfaces;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.GregorianCalendar;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JSeparator;
import javax.swing.JTextField;
import javax.swing.Timer;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;
import javax.swing.event.DocumentEvent;

import java.awt.Toolkit;
import javax.swing.JRadioButton;
import javax.swing.ButtonGroup;
import javax.swing.JSpinner;
import javax.swing.SpinnerNumberModel;
import com.toedter.calendar.JCalendar;
import com.toedter.calendar.JDateChooser;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;



public class Formulario extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = -4390428898904257572L;
	private JPanel contentPane;
	private JPanel panel;
	private JLabel lblNewLabelLibro;
	private JButton btnAnnadirMostrar;
	private JButton btnEditarMostrar;
	private JButton btnEliminarMostrar;
	private JPanel panelDeTrabajo;
	private JLabel lblAñadir;
	private JButton btnAnnadirOcultar;
	private JButton btnEditarOcultar;
	private JButton btnCerrar;
	private JSeparator separator_2;
	private JSeparator separator_3;
	private JSeparator separator_3_1;
	private JButton btnAnnadirInterior;
	private JPanel panelEliminar;
	private JButton btnEliminarOcultar;
	private JLabel lblNewLabel_2;
	private JLabel lblFondo;
	private JSeparator sepaNombreCarrera;
	private JPanel panelFormulario;
	private JLabel lblNombreCarrera;
	private JRadioButton rdbtnCarrera;
	private JRadioButton rdbtnAsignatura;
	private JRadioButton rdbtnMaterial;
	private JRadioButton rdbtnAño;
	private final ButtonGroup buttonGroup = new ButtonGroup();
	private JTextField textFieldNombreCarrera;
	private JLabel lblDuracionCarrera;
	private JSpinner spinnerCArrera;
	private JLabel lblAnnoCant;
	private JSpinner spinnerAnnoCant;
	private JLabel lblNombreAsignatura;
	private JTextField textNombreAsignatura;
	private JLabel lblTituloMaterial;
	private JTextField textTituloMaterial;
	private JLabel lblautorMaterial;
	private JTextField textAutorMaterial;
	private JDateChooser dateChooserMaterial;
	private JLabel lblFechaCreacionMaterial;
	private JSeparator separatorNombreAsignatura;
	private JSeparator separatorTituloMaterial;
	private JSeparator separatorAutor;
	private JPanel panelEditar;
	private JScrollPane scrollPane;
	private JLabel lblNewLabel;
	private JScrollPane scrollPane_1;
	
	/** 
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Formulario frame = new Formulario();
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
	public Formulario() {
		setIconImage(Toolkit.getDefaultToolkit().getImage(Formulario.class.getResource("/icons/icons8-book-64 (2).png")));
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 603, 527);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setUndecorated(true);
		setLocationRelativeTo(null);

		setContentPane(contentPane);
		contentPane.setLayout(null);
		contentPane.add(getBtnCerrar());
		contentPane.add(getPanel());
		contentPane.add(getPanelDeTrabajo());
		contentPane.add(getLblNewLabelLibro());
		contentPane.add(getLblFondo());
	}
	private JPanel getPanel() {
		if (panel == null) {
			panel = new JPanel();
			panel.setBorder(new LineBorder(new Color(0, 0, 0)));
			panel.setBackground(new Color(255, 255, 255));
			panel.setBounds(0, 53, 139, 422);
			panel.setLayout(null);
			panel.add(getBtnAnnadirMostrar());
			panel.add(getBtnNewButton_1_1());
			panel.add(getBtnNewButton_2_1());
			panel.add(getBtnAnnadirOcultar());
			panel.add(getBtnEditarOcultar());
			panel.add(getSeparator_2());
			panel.add(getSeparator_3());
			panel.add(getSeparator_3_1());
			panel.add(getBtnEliminarOcultar());
		}
		return panel;
	}
	private JLabel getLblNewLabelLibro() {
		if (lblNewLabelLibro == null) {
			lblNewLabelLibro = new JLabel("");
			lblNewLabelLibro.setBounds(289, 212, 109, 76);
			lblNewLabelLibro.setIcon(new ImageIcon(Formulario.class.getResource("/icons/icons8-literature-64.png")));
		}
		return lblNewLabelLibro;
	}
	private JButton getBtnAnnadirMostrar() {
		if (btnAnnadirMostrar == null) {
			btnAnnadirMostrar = new JButton("Añadir");
			btnAnnadirMostrar.addMouseListener(new MouseAdapter() {
				@Override
				public void mouseEntered(MouseEvent e) {
					btnAnnadirMostrar.setForeground(Color.yellow);
				}
				@Override
				public void mouseExited(MouseEvent e) {
					btnAnnadirMostrar.setForeground(Color.black);
				}
			});
			btnAnnadirMostrar.setFont(new Font("Yu Gothic UI Semibold", Font.BOLD | Font.ITALIC, 19));
			btnAnnadirMostrar.setBounds(22, 105, 89, 41);
			
			btnAnnadirMostrar.setOpaque(false);
			btnAnnadirMostrar.setBorder(null);
			btnAnnadirMostrar.setContentAreaFilled(false);
			btnAnnadirMostrar.setFocusPainted(false);
			
			//aparecer pantalla Annadir
			btnAnnadirMostrar.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {	
					
					int x=438;
					int y=422;
					btnAnnadirOcultar.setVisible(true);
					btnAnnadirMostrar.setVisible(false);
					
					btnEditarMostrar.setVisible(true);
					btnEliminarMostrar.setVisible(true);

					
					scrollPane_1.setVisible(false);

					
					
					

					
					
				     
				        if(x==438){
				        	panelDeTrabajo.show();
				        	scrollPane.getViewport().setVisible(false);
							scrollPane.setVisible(false);
				        	
				        	
								
				            
				         Thread th = new Thread(){
				             @Override
				             public void run(){
				            	 int x=438;
				                 try{
				                   for(int i =0;i<=x;i++){
				                	   
				                       Thread.sleep(1);
				                       panelDeTrabajo.setSize(i,422);
				                       
				                   }  
				                 }catch(Exception e){
				                     JOptionPane.showMessageDialog(null, e);
				                 }
				             }
				         };th.start();
				         x=438;
				        
				     }
				}
			});
			
		}
		return btnAnnadirMostrar;
	}
	private JButton getBtnNewButton_1_1() {
		if (btnEditarMostrar == null) {
			btnEditarMostrar = new JButton("Editar");
			btnEditarMostrar.addMouseListener(new MouseAdapter() {
				@Override
				public void mouseEntered(MouseEvent e) {
					btnEditarMostrar.setForeground(Color.yellow);
				}
				@Override
				public void mouseExited(MouseEvent e) {
					btnEditarMostrar.setForeground(Color.black);
				}
			});
			btnEditarMostrar.setFont(new Font("Yu Gothic UI Semibold", Font.BOLD | Font.ITALIC, 18));
			btnEditarMostrar.setBounds(22, 179, 89, 41);
			
			btnEditarMostrar.setOpaque(false);
			btnEditarMostrar.setBorder(null);
			btnEditarMostrar.setContentAreaFilled(false);
			btnEditarMostrar.setFocusPainted(false);
			
		//	panelFormulario.setVisible(false);
			
			//No tocar aun
			btnEditarMostrar.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {	
					
					int x=438;
					int y=422;
					btnEditarOcultar.setVisible(true);
					btnEditarMostrar.setVisible(false);
					
					btnAnnadirMostrar.setVisible(true);

					
					scrollPane_1.setVisible(false);
									
				     
				        if(x==438){
				        	panelDeTrabajo.show();
				        	scrollPane.getViewport().show();
				        	scrollPane.show();
				        	
								
				            
				         Thread th = new Thread(){
				             @Override
				             public void run(){
				            	 int x=438;
				                 try{
				                   for(int i =0;i<=x;i++){
				                	   
				                       Thread.sleep(1);
				                       panelDeTrabajo.setSize(i,422);
				                       scrollPane.setSize(i,422);
				                      // scrollPane.setSize(i,422);
				                       panelEditar.setSize(i,422);

				                   }  
				                 }catch(Exception e){
				                     JOptionPane.showMessageDialog(null, e);
				                 }
				             }
				         };th.start();
				         x=438;
				        
				     }
				}
			});
		}
		return btnEditarMostrar;
	}
	private JButton getBtnNewButton_2_1() {
		if (btnEliminarMostrar == null) {
			btnEliminarMostrar = new JButton("Eliminar");

			btnEliminarMostrar.addMouseListener(new MouseAdapter() {
				@Override
				public void mouseEntered(MouseEvent e) {
					btnEliminarMostrar.setForeground(Color.yellow);
				}
				@Override
				public void mouseExited(MouseEvent e) {
					btnEliminarMostrar.setForeground(Color.black);
				}
			});
			//btnEliminarMostrar.setBackground(new Color(255, 255, 255));

			btnEliminarMostrar.setFont(new Font("Yu Gothic UI Semibold", Font.BOLD | Font.ITALIC, 18));
			btnEliminarMostrar.setBounds(10, 253, 107, 41);
			
			btnEliminarMostrar.setOpaque(false);
			btnEliminarMostrar.setBorder(null);
			btnEliminarMostrar.setContentAreaFilled(false);
			btnEliminarMostrar.setFocusPainted(false);
			
		btnEliminarMostrar.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {	
					
					int x=438;
					int y=422;
					btnAnnadirOcultar.setVisible(true);
					btnEliminarMostrar.setVisible(false);
					
					btnEditarMostrar.setVisible(true);


					btnEditarMostrar.setVisible(true);
                    btnAnnadirMostrar.setVisible(true);
                   // panelDeTrabajo.setVisible(false);
					
					
				     
				        if(x==438){ 
							scrollPane_1.show();
							 panelDeTrabajo.show();
		   
				         Thread th = new Thread(){
				             @Override
				             public void run(){
				            	 int x=438;
				                 try{
				                   for(int i =0;i<=x;i++){
				                	   
				                       Thread.sleep(1);
										scrollPane_1.setSize(i,422);
										panelEliminar.setSize(i, 422);
										 panelDeTrabajo.setSize(i, 422);
				                   }  
				                 }catch(Exception e){
				                     JOptionPane.showMessageDialog(null, e);
				                 }
				             }
				         };th.start();
				         x=438;
				        
				     }
				}
			});
		
		
		
		}
		return btnEliminarMostrar;
	}
	private JPanel getPanelDeTrabajo() {
		if (panelDeTrabajo == null) {
			panelDeTrabajo = new JPanel();
			panelDeTrabajo.setBorder(new LineBorder(new Color(0, 0, 0)));
			panelDeTrabajo.setBackground(new Color(255, 255, 255));
			panelDeTrabajo.setBounds(137, 53, 438, 422);
			panelDeTrabajo.setLayout(null);
			panelDeTrabajo.add(getScrollPane_1());
			panelDeTrabajo.add(getScrollPane_2());
			panelDeTrabajo.add(getLblAñadir());
			
			panelFormulario = new JPanel();
			panelFormulario.setBackground(new Color(255, 255, 255));
			panelFormulario.setBounds(10, 72, 405, 199);
			panelDeTrabajo.add(panelFormulario);
			panelFormulario.setLayout(null);
			panelFormulario.add(getLblNombreCarrera());
			panelFormulario.add(getRdbtnCarrera());
			panelFormulario.add(getRdbtnAsignatura());
			panelFormulario.add(getRdbtnMaterial());
			panelFormulario.add(getRdbtnAño());
			panelFormulario.add(getTextFieldNombreCarrera());
			panelFormulario.add(getLblDuracionCarrera());
			panelFormulario.add(getSpinnerCArrera());
			panelFormulario.add(getLblAnnoCant());
			panelFormulario.add(getSpinnerAnnoCant());
			panelFormulario.add(getLblNombreAsignatura());
			panelFormulario.add(getTextNombreAsignatura());
			panelFormulario.add(getLblTituloMaterial());
			panelFormulario.add(getTextTituloMaterial());
			panelFormulario.add(getLblautorMaterial());
			panelFormulario.add(getTextAutorMaterial());
			panelFormulario.add(getDateChooserMaterial());
			panelFormulario.add(getLblFechaCreacionMaterial());
			panelFormulario.add(getBtnAnnadirInterior());
			panelFormulario.add(getSepaNombreCarrera());
			panelFormulario.add(getSeparatorNombreAsignatura());
			panelFormulario.add(getSeparatorTituloMaterial());
			panelFormulario.add(getSeparatorAutor());
			panelDeTrabajo.setVisible(false);
		}
		return panelDeTrabajo;
	}
	private JLabel getLblAñadir() {
		if (lblAñadir == null) {
			lblAñadir = new JLabel("Añadir");
			lblAñadir.setFont(new Font("Yu Gothic UI Semibold", Font.BOLD | Font.ITALIC, 28));
			lblAñadir.setBounds(185, 11, 108, 61);
		}
		return lblAñadir;
	}
	private JButton getBtnAnnadirOcultar() {
		if (btnAnnadirOcultar == null) {
			btnAnnadirOcultar = new JButton("Añadir");
			btnAnnadirOcultar.addMouseListener(new MouseAdapter() {
				@Override
				public void mouseEntered(MouseEvent e) {
					btnAnnadirOcultar.setForeground(Color.yellow);
				}
				@Override
				public void mouseExited(MouseEvent e) {
					btnAnnadirOcultar.setForeground(Color.black);
				}
			});
			
			btnAnnadirOcultar.setOpaque(false);
			btnAnnadirOcultar.setFont(new Font("Yu Gothic UI Semibold", Font.BOLD | Font.ITALIC, 19));
			btnAnnadirOcultar.setFocusPainted(false);
			btnAnnadirOcultar.setContentAreaFilled(false);
			btnAnnadirOcultar.setBorder(null);
			btnAnnadirOcultar.setBounds(22, 105, 89, 41);
			
			
			btnAnnadirOcultar.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					int x=438;
					int y=422;
					btnAnnadirMostrar.setVisible(true);
					btnAnnadirOcultar.setVisible(false);
					
					
					
					
				        if(x==438){
				        	
				           Thread th = new Thread(){
				               @Override
				               public void run(){
				                   try{
				                       for(int i=438;i>=0;i--){
				                           Thread.sleep(1);
				                           panelDeTrabajo.setSize(i,422);
				                       }
				                   }catch(Exception e){
				                       JOptionPane.showMessageDialog(null,e);
				                   }
				               }
				               
				       };th.start();
				       }
				}
			});
		}
		return btnAnnadirOcultar;
	}
	private JButton getBtnEditarOcultar() {
		if (btnEditarOcultar == null) {
			btnEditarOcultar = new JButton("Editar");
			btnEditarOcultar.addMouseListener(new MouseAdapter() {
				@Override
				public void mouseEntered(MouseEvent e) {
					btnEditarOcultar.setForeground(Color.yellow);
				}
				@Override
				public void mouseExited(MouseEvent e) {
					btnEditarOcultar.setForeground(Color.black);
				}
			});
			btnEditarOcultar.setOpaque(false);
			btnEditarOcultar.setFont(new Font("Yu Gothic UI Semibold", Font.BOLD | Font.ITALIC, 18));
			btnEditarOcultar.setFocusPainted(false);
			btnEditarOcultar.setContentAreaFilled(false);
			btnEditarOcultar.setBorder(null);
			btnEditarOcultar.setBounds(22, 179, 89, 41);
			
			//no tocar aun
			btnEditarOcultar.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
				
					btnEditarMostrar.setVisible(true);
					btnEditarOcultar.setVisible(false);
					
					btnAnnadirMostrar.setVisible(true);

					panelDeTrabajo.setVisible(false);
					
					
				}
			});
		}
		return btnEditarOcultar;
	}
	private JButton getBtnCerrar() {
		if (btnCerrar == null) {
			btnCerrar = new JButton("");
			btnCerrar.setBounds(555, 0, 48, 35);
			btnCerrar.setIcon(new ImageIcon(Formulario.class.getResource("/icons/icons8-x-24.png")));
			
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
	private JSeparator getSeparator_2() {
		if (separator_2 == null) {
			separator_2 = new JSeparator();
			separator_2.setBounds(22, 144, 89, 2);
		}
		return separator_2;
	}
	private JSeparator getSeparator_3() {
		if (separator_3 == null) {
			separator_3 = new JSeparator();
			separator_3.setBounds(22, 218, 89, 2);
		}
		return separator_3;
	}
	private JSeparator getSeparator_3_1() {
		if (separator_3_1 == null) {
			separator_3_1 = new JSeparator();
			separator_3_1.setBounds(22, 292, 89, 2);
		}
		return separator_3_1;
	}
	private JButton getBtnAnnadirInterior() {
		if (btnAnnadirInterior == null) {
			btnAnnadirInterior = new JButton("");
			btnAnnadirInterior.setVisible(false);
			btnAnnadirInterior.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					if(rdbtnMaterial.isSelected()) {
						 JOptionPane.showMessageDialog(null,"Faltan cosas con el material" );
					}
				}
			});
			btnAnnadirInterior.setBounds(366, 161, 42, 38);
			btnAnnadirInterior.setIcon(new ImageIcon(Formulario.class.getResource("/icons/icons8-add-properties-24.png")));
			
			btnAnnadirInterior.setOpaque(false);
			btnAnnadirInterior.setBorder(null);
			btnAnnadirInterior.setContentAreaFilled(false);
			btnAnnadirInterior.setFocusPainted(false);
		}
		return btnAnnadirInterior;
	}
	private JPanel getPanelEliminar() {
		if (panelEliminar == null) {
			panelEliminar = new JPanel();
			panelEliminar.setBackground(new Color(255, 255, 255));
			
			panelEliminar.setPreferredSize(new Dimension(0, 10000));
			panelEliminar.setLayout(null);
			panelEliminar.add(getLblNewLabel_2());
			

		}
		return panelEliminar;
	}
	private JButton getBtnEliminarOcultar() {
		if (btnEliminarOcultar == null) {
			btnEliminarOcultar = new JButton("Eliminar");
			btnEliminarOcultar.addMouseListener(new MouseAdapter() {
				@Override
				public void mouseEntered(MouseEvent e) {
					btnEliminarOcultar.setForeground(Color.yellow);
				}
				@Override
				public void mouseExited(MouseEvent e) {
					btnEliminarOcultar.setForeground(Color.black);
				}
			});
			

			btnEliminarOcultar.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					scrollPane_1.setVisible(false);
					btnEliminarMostrar.setVisible(true);
					panelDeTrabajo.setVisible(false);

					btnAnnadirMostrar.setVisible(true);
					btnEditarMostrar.setVisible(true);
					

					
				}
			});
			btnEliminarOcultar.setOpaque(false);
			btnEliminarOcultar.setFont(new Font("Yu Gothic UI Semibold", Font.BOLD | Font.ITALIC, 18));
			btnEliminarOcultar.setFocusPainted(false);
			btnEliminarOcultar.setContentAreaFilled(false);
			btnEliminarOcultar.setBorder(null);
			btnEliminarOcultar.setBounds(10, 253, 107, 41);
		}
		return btnEliminarOcultar;
	}
	private JLabel getLblNewLabel_2() {
		if (lblNewLabel_2 == null) {
			lblNewLabel_2 = new JLabel("Eliminar:");
			lblNewLabel_2.setFont(new Font("Yu Gothic UI Semibold", Font.BOLD | Font.ITALIC, 19));
			lblNewLabel_2.setBounds(125, 23, 133, 40);
		}
		return lblNewLabel_2;
	}
	private JLabel getLblFondo() {
		if (lblFondo == null) {
			lblFondo = new JLabel("");
			lblFondo.setIcon(new ImageIcon(Formulario.class.getResource("/icons/export202307021531574067.png")));
			lblFondo.setBounds(0, 0, 603, 527);
		}
		return lblFondo;
	}
	private JSeparator getSepaNombreCarrera() {
		if (sepaNombreCarrera == null) {
			sepaNombreCarrera = new JSeparator();
			sepaNombreCarrera.setBounds(101, 76, 273, 2);
			sepaNombreCarrera.setForeground(Color.BLACK);
			
			sepaNombreCarrera.setVisible(false);
		}
		return sepaNombreCarrera;
	}
	private JLabel getLblNombreCarrera() {
		if (lblNombreCarrera == null) {
			lblNombreCarrera = new JLabel("Nombre:");
			lblNombreCarrera.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 13));
			lblNombreCarrera.setBounds(18, 57, 73, 14);
		}
		return lblNombreCarrera;
	}
	private JRadioButton getRdbtnCarrera() {
		if (rdbtnCarrera == null) {
			rdbtnCarrera = new JRadioButton("Carrera");
			rdbtnCarrera.setSelected(true);
			rdbtnCarrera.setBackground(new Color(255, 255, 255));
			rdbtnCarrera.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					lblDuracionCarrera.setVisible(true);
					lblNombreCarrera.setVisible(true);
					textFieldNombreCarrera.setVisible(true);
					spinnerCArrera.setVisible(true);
					lblAnnoCant.setVisible(false);
					spinnerAnnoCant.setVisible(false);
					lblNombreAsignatura.setVisible(false);
					textNombreAsignatura.setVisible(false);
					lblautorMaterial.setVisible(false);
					lblFechaCreacionMaterial.setVisible(false);
					lblTituloMaterial.setVisible(false);
					textAutorMaterial.setVisible(false);
					textTituloMaterial.setVisible(false);
					dateChooserMaterial.setVisible(false);
					btnAnnadirInterior.setVisible(true);
					sepaNombreCarrera.setVisible(true);
					separatorNombreAsignatura.setVisible(false);
					separatorTituloMaterial.setVisible(false);
					separatorAutor.setVisible(false);





					
				}
			});
			buttonGroup.add(rdbtnCarrera);
			rdbtnCarrera.setBounds(18, 7, 81, 23);
		}
		return rdbtnCarrera;
	}
	private static class __Tmp {
		private static void __tmp() {
			  javax.swing.JPanel __wbp_panel = new javax.swing.JPanel();
		}
	}
	private JRadioButton getRdbtnAsignatura() {
		if (rdbtnAsignatura == null) {
			rdbtnAsignatura = new JRadioButton("Asignatura");
			rdbtnAsignatura.setBackground(new Color(255, 255, 255));
			rdbtnAsignatura.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					lblNombreAsignatura.setVisible(true);
					textNombreAsignatura.setVisible(true);
					lblAnnoCant.setVisible(false);
					spinnerAnnoCant.setVisible(false);
					lblDuracionCarrera.setVisible(false);
					lblNombreCarrera.setVisible(false);
					textFieldNombreCarrera.setVisible(false);
					spinnerCArrera.setVisible(false);
					lblautorMaterial.setVisible(false);
					lblFechaCreacionMaterial.setVisible(false);
					lblTituloMaterial.setVisible(false);
					textAutorMaterial.setVisible(false);
					textTituloMaterial.setVisible(false);
					dateChooserMaterial.setVisible(false);
					btnAnnadirInterior.setVisible(true);
					separatorNombreAsignatura.setVisible(true);
					sepaNombreCarrera.setVisible(false);
					separatorTituloMaterial.setVisible(false);
					separatorAutor.setVisible(false);





				}
			});
			buttonGroup.add(rdbtnAsignatura);
			rdbtnAsignatura.setBounds(200, 7, 91, 23);
		}
		return rdbtnAsignatura;
	}
	private JRadioButton getRdbtnMaterial() {
		if (rdbtnMaterial == null) {
			rdbtnMaterial = new JRadioButton("Material");
			rdbtnMaterial.setBackground(new Color(255, 255, 255));
			rdbtnMaterial.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					lblNombreAsignatura.setVisible(false);
					textNombreAsignatura.setVisible(false);
					lblAnnoCant.setVisible(false);
					spinnerAnnoCant.setVisible(false);
					lblDuracionCarrera.setVisible(false);
					lblNombreCarrera.setVisible(false);
					textFieldNombreCarrera.setVisible(false);
					spinnerCArrera.setVisible(false);
					lblautorMaterial.setVisible(true);
					lblFechaCreacionMaterial.setVisible(true);
					lblTituloMaterial.setVisible(true);
					textAutorMaterial.setVisible(true);
					textTituloMaterial.setVisible(true);
					dateChooserMaterial.setVisible(true);
					btnAnnadirInterior.setVisible(true);
					separatorTituloMaterial.setVisible(true);
					separatorAutor.setVisible(true);
					separatorNombreAsignatura.setVisible(false);
					sepaNombreCarrera.setVisible(false);





					
				}
			});
			buttonGroup.add(rdbtnMaterial);
			rdbtnMaterial.setBounds(315, 7, 81, 23);
		}
		return rdbtnMaterial;
	}
	private JRadioButton getRdbtnAño() {
		if (rdbtnAño == null) {
			rdbtnAño = new JRadioButton("Año");
			rdbtnAño.setBackground(new Color(255, 255, 255));
			rdbtnAño.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					lblAnnoCant.setVisible(true);
					spinnerAnnoCant.setVisible(true);
					lblDuracionCarrera.setVisible(false);
					lblNombreCarrera.setVisible(false);
					textFieldNombreCarrera.setVisible(false);
					spinnerCArrera.setVisible(false);
					lblNombreAsignatura.setVisible(false);
					textNombreAsignatura.setVisible(false);
					lblautorMaterial.setVisible(false);
					lblFechaCreacionMaterial.setVisible(false);
					lblTituloMaterial.setVisible(false);
					textAutorMaterial.setVisible(false);
					textTituloMaterial.setVisible(false);
					dateChooserMaterial.setVisible(false);
					btnAnnadirInterior.setVisible(true);
					separatorTituloMaterial.setVisible(false);
					separatorAutor.setVisible(false);
					separatorNombreAsignatura.setVisible(false);
					sepaNombreCarrera.setVisible(false);





				}
			});
			buttonGroup.add(rdbtnAño);
			rdbtnAño.setBounds(117, 7, 81, 23);
		}
		return rdbtnAño;
	}
	private JTextField getTextFieldNombreCarrera() {
		if (textFieldNombreCarrera == null) {
			textFieldNombreCarrera = new JTextField();
			textFieldNombreCarrera.setBounds(101, 55, 273, 23);
			textFieldNombreCarrera.setColumns(10);
			
			textFieldNombreCarrera.setOpaque(false);
			textFieldNombreCarrera.setBorder(null);
		
		}
		return textFieldNombreCarrera;
	}
	private JLabel getLblDuracionCarrera() {
		if (lblDuracionCarrera == null) {
			lblDuracionCarrera = new JLabel("Duración");
			lblDuracionCarrera.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 13));
			lblDuracionCarrera.setBounds(18, 116, 73, 14);
		}
		return lblDuracionCarrera;
	}
	private JSpinner getSpinnerCArrera() {
		if (spinnerCArrera == null) {
			spinnerCArrera = new JSpinner();
			spinnerCArrera.setFocusable(false);
			spinnerCArrera.setModel(new SpinnerNumberModel(2, 2, 6, 1));
			spinnerCArrera.setBounds(101, 113, 273, 23);

			spinnerCArrera.setOpaque(false);
			spinnerCArrera.setBorder(null);
//			spinner.getT

//			spinnerCArrera.
			

		}
		return spinnerCArrera;
	}
	private JLabel getLblAnnoCant() {
		if (lblAnnoCant == null) {
			lblAnnoCant = new JLabel("Cantidad de años:");
			lblAnnoCant.setVisible(false);
			lblAnnoCant.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 13));
			lblAnnoCant.setBounds(18, 91, 131, 14);
		}
		return lblAnnoCant;
	}
	private JSpinner getSpinnerAnnoCant() {
		if (spinnerAnnoCant == null) {
			spinnerAnnoCant = new JSpinner();
			spinnerAnnoCant.setModel(new SpinnerNumberModel(2, 2, 6, 1));
			spinnerAnnoCant.setVisible(false);
			spinnerAnnoCant.setBounds(144, 87, 229, 23);
			spinnerAnnoCant.setOpaque(false);
			spinnerAnnoCant.setBorder(null);
		}
		return spinnerAnnoCant;
	}
	private JLabel getLblNombreAsignatura() {
		if (lblNombreAsignatura == null) {
			lblNombreAsignatura = new JLabel("Nombre:");
			lblNombreAsignatura.setVisible(false);
			lblNombreAsignatura.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 13));
			lblNombreAsignatura.setBounds(28, 86, 63, 14);
		}
		return lblNombreAsignatura;
	}
	private JTextField getTextNombreAsignatura() {
		if (textNombreAsignatura == null) {
			textNombreAsignatura = new JTextField();
			textNombreAsignatura.setVisible(false);
			textNombreAsignatura.setBounds(101, 82, 273, 23);
			textNombreAsignatura.setColumns(10);
			
			textNombreAsignatura.setOpaque(false);
			textNombreAsignatura.setBorder(null);
		}
		return textNombreAsignatura;
	}
	private JLabel getLblTituloMaterial() {
		if (lblTituloMaterial == null) {
			lblTituloMaterial = new JLabel("Título:");
			lblTituloMaterial.setVisible(false);
			lblTituloMaterial.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 13));
			lblTituloMaterial.setBounds(18, 59, 54, 14);
		}
		return lblTituloMaterial;
	}
	private JTextField getTextTituloMaterial() {
		if (textTituloMaterial == null) {
			textTituloMaterial = new JTextField();
			textTituloMaterial.setVisible(false);
			textTituloMaterial.setBounds(101, 57, 273, 20);
			textTituloMaterial.setColumns(10);
			
			textTituloMaterial.setOpaque(false);
			textTituloMaterial.setBorder(null);
		}
		return textTituloMaterial;
	}
	private JLabel getLblautorMaterial() {
		if (lblautorMaterial == null) {
			lblautorMaterial = new JLabel("Autor:");
			lblautorMaterial.setVisible(false);
			lblautorMaterial.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 13));
			lblautorMaterial.setBounds(18, 91, 54, 14);
		}
		return lblautorMaterial;
	}
	private JTextField getTextAutorMaterial() {
		if (textAutorMaterial == null) {
			textAutorMaterial = new JTextField();
			textAutorMaterial.setVisible(false);
			textAutorMaterial.setBounds(101, 89, 273, 20);
			textAutorMaterial.setColumns(10);
			
			textAutorMaterial.setOpaque(false);
			textAutorMaterial.setBorder(null);
		}
		return textAutorMaterial;
	}
	private JDateChooser getDateChooserMaterial() {
		if (dateChooserMaterial == null) {
			dateChooserMaterial = new JDateChooser();
			dateChooserMaterial.setVisible(false);
			dateChooserMaterial.setBounds(154, 116, 220, 23);
			dateChooserMaterial.setOpaque(false);
			dateChooserMaterial.setBorder(null);
	//		
		}
		return dateChooserMaterial;
	}
	private JLabel getLblFechaCreacionMaterial() {
		if (lblFechaCreacionMaterial == null) {
			lblFechaCreacionMaterial = new JLabel("Fecha de Creación:");
			lblFechaCreacionMaterial.setVisible(false);
			lblFechaCreacionMaterial.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 13));
			lblFechaCreacionMaterial.setBounds(18, 120, 131, 14);
		}
		return lblFechaCreacionMaterial;
	}
	private JSeparator getSeparatorNombreAsignatura() {
		if (separatorNombreAsignatura == null) {
			separatorNombreAsignatura = new JSeparator();
			separatorNombreAsignatura.setForeground(new Color(0, 0, 0));
			separatorNombreAsignatura.setBounds(101, 100, 273, 2);
			
			separatorNombreAsignatura.setVisible(false);
		}
		return separatorNombreAsignatura;
	}
	private JSeparator getSeparatorTituloMaterial() {
		if (separatorTituloMaterial == null) {
			separatorTituloMaterial = new JSeparator();
			separatorTituloMaterial.setForeground(new Color(0, 0, 0));
			separatorTituloMaterial.setBounds(101, 76, 273, 2);
			
			separatorTituloMaterial.setVisible(false);
		}
		return separatorTituloMaterial;
	}
	private JSeparator getSeparatorAutor() {
		if (separatorAutor == null) {
			separatorAutor = new JSeparator();
			separatorAutor.setForeground(new Color(0, 0, 0));
			separatorAutor.setBounds(101, 107, 273, 3);
			separatorAutor.setVisible(false);

		}
		return separatorAutor;
	}
	private JPanel getPanelEditar() {
		if (panelEditar == null) {
			panelEditar = new JPanel();
			panelEditar.setBackground(new Color(255, 255, 255));
			panelEditar.setPreferredSize(new Dimension(0, 10000));
			panelEditar.setLayout(null);
			panelEditar.add(getLblNewLabel());
		}
		return panelEditar;
	}
	private JScrollPane getScrollPane_2() {
		if (scrollPane == null) {
			scrollPane = new JScrollPane();
			scrollPane.setBounds(0, 0, 438, 422);
			scrollPane.setViewportView(getPanelEditar());
		}
		return scrollPane;
	}
	private JLabel getLblNewLabel() {
		if (lblNewLabel == null) {
			lblNewLabel = new JLabel("Editar:");
			lblNewLabel.setFont(new Font("Yu Gothic UI Semibold", Font.BOLD | Font.ITALIC, 28));
			lblNewLabel.setBounds(162, 11, 100, 50);
		}
		return lblNewLabel;
	}
	private JScrollPane getScrollPane_1() {
		if (scrollPane_1 == null) {
			scrollPane_1 = new JScrollPane();
			scrollPane_1.setBackground(new Color(255, 255, 255));
			scrollPane_1.setBounds(0, 0, 438, 10278);
			scrollPane_1.setViewportView(getPanelEliminar());
		}
		return scrollPane_1;
	}
}


