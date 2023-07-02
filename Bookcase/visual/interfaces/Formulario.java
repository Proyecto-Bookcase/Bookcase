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



public class Formulario extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = -4390428898904257572L;
	private JPanel contentPane;
	private JPanel panel;
	private JLabel lblNewLabel;
	private JButton btnAnnadirMostrar;
	private JButton btnEditarMostrar;
	private JButton btnEliminarMostrar;
	private JPanel panelAnnadir;
	private JLabel lblNewLabel_1;
	private JLabel lblNewLabel_3_2;
	private JLabel lblNewLabel_3_3;
	private JComboBox<String> comboBoxNombreCarrera;
	private JButton btnAnnadirEliminar;
	private JPanel panel_1;
	private JLabel lblNewLabel_2_1;
	private JScrollPane scrollPane;
	private JButton btnEditarEliminar;
	private JButton btnCerrar;
	private JSeparator separator_2;
	private JSeparator separator_3;
	private JSeparator separator_3_1;
	private JButton btnAnnadirInterior;
	private JPanel panelEliminar;
	private JScrollPane scrollPane_1;
	private JButton btnEliminarOcultar;
	private JLabel lblNewLabel_2;
	private JLabel lblNewLabel_4;
	private JLabel lbAsignatura;
	private JLabel lbNombreCarrera;
	private JLabel lbIDCarrera;
	private JLabel lbAnnosCarrera;
	private JTextField textFieldID;
	private JSeparator separator_4_2;
	private JComboBox<String> cBoxAnnosCarrera;
	private JLabel lbIDCarrera_1;
	private JTextField textField_2;
	private JSeparator separator_4_2_1;
	private JLabel lbNombreCarrera_1;
	private JTextField textField_3;
	private JSeparator separator_4_2_1_1;
	private JLabel lblAo;
	private JComboBox<String> cBoxAnnosCarrera_1;
	private JLabel lbIDCarrera_1_1;
	private JTextField textField;
	private JSeparator separator_4_2_2;
	private JLabel lblNewLabel_3_2_1;
	private JLabel lbNombreCarrera_1_1;
	private JLabel lbNombreCarrera_1_2;
	private JLabel lbNombreCarrera_1_3;
	private JTextField textField_1;
	private JTextField textField_4;
	private JSeparator separator_4_2_2_1;
	private JSeparator separator_4_2_2_2;
	
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
		contentPane.add(getScrollPane_1());
		contentPane.add(getBtnCerrar());
		contentPane.add(getPanel());
		contentPane.add(getPanelAnnadir());
		contentPane.add(getLblNewLabel());
		contentPane.add(getLblNewLabel_4());
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
			panel.add(getBtnAnnadirEliminar());
			panel.add(getBtnEditarEliminar());
			panel.add(getSeparator_2());
			panel.add(getSeparator_3());
			panel.add(getSeparator_3_1());
			panel.add(getBtnEliminarOcultar());
		}
		return panel;
	}
	private JLabel getLblNewLabel() {
		if (lblNewLabel == null) {
			lblNewLabel = new JLabel("");
			lblNewLabel.setBounds(289, 212, 109, 76);
			lblNewLabel.setIcon(new ImageIcon(Formulario.class.getResource("/icons/icons8-literature-64.png")));
		}
		return lblNewLabel;
	}
	private JButton getBtnAnnadirMostrar() {
		if (btnAnnadirMostrar == null) {
			btnAnnadirMostrar = new JButton("Añadir");
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
					btnAnnadirEliminar.setVisible(true);
					btnAnnadirMostrar.setVisible(false);
					
					btnEditarMostrar.setVisible(true);
					
					scrollPane_1.setVisible(false);

					
					
					
					//btnEditarMostrar.setVisible(true);

					
					
				     
				        if(x==438){
				        	panelAnnadir.show();
				        	scrollPane.getViewport().setVisible(false);
							scrollPane.setVisible(false);
				     //    panel.setSize(360,y);
				        	
				        	
								
				            
				         Thread th = new Thread(){
				             @Override
				             public void run(){
				            	 int x=438;
				                 try{
				                   for(int i =0;i<=x;i++){
				                	   
				                       Thread.sleep(1);
				                       panelAnnadir.setSize(i,422);
				                       
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
			btnEditarMostrar.setFont(new Font("Yu Gothic UI Semibold", Font.BOLD | Font.ITALIC, 18));
			btnEditarMostrar.setBounds(22, 179, 89, 41);
			
			btnEditarMostrar.setOpaque(false);
			btnEditarMostrar.setBorder(null);
			btnEditarMostrar.setContentAreaFilled(false);
			btnEditarMostrar.setFocusPainted(false);
			
			//No tocar aun
			btnEditarMostrar.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {	
					
					int x=438;
					int y=422;
					btnEditarEliminar.setVisible(true);
					btnEditarMostrar.setVisible(false);
					
					btnAnnadirMostrar.setVisible(true);
					scrollPane_1.setVisible(false);
					
					//panelAnnadir.setVisible(false);
					 scrollPane.getViewport().setVisible(true);
				     scrollPane.setVisible(true);
				        panelAnnadir.setVisible(false);
				       
				        scrollPane.getViewport().setVisible(true);
				        scrollPane.setVisible(true);
					
					//scrollPane.setPreferredSize(new Dimension(438, 422));
				     
				        if(x==438){
				        	panelAnnadir.show();
				        	scrollPane.getViewport().show();
				     //    panel.setSize(360,y);
				        	
				        	
								
				            
				         Thread th = new Thread(){
				             @Override
				             public void run(){
				            	 int x=438;
				                 try{
				                   for(int i =0;i<=x;i++){
				                	   
				                       Thread.sleep(1);
				                       panelAnnadir.setSize(i,422);
				                      // scrollPane.setSize(i,422);

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
					btnAnnadirEliminar.setVisible(true);
					btnEliminarMostrar.setVisible(false);
					
					btnEditarMostrar.setVisible(true);


					btnEditarMostrar.setVisible(true);
                    btnAnnadirMostrar.setVisible(true);
                    panelAnnadir.setVisible(false);
					
					
				     
				        if(x==438){ 
							scrollPane_1.show();
		   
				         Thread th = new Thread(){
				             @Override
				             public void run(){
				            	 int x=438;
				                 try{
				                   for(int i =0;i<=x;i++){
				                	   
				                       Thread.sleep(1);
										scrollPane_1.setSize(i,422);
										panelEliminar.setSize(i, 422);				                       
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
	private JPanel getPanelAnnadir() {
		if (panelAnnadir == null) {
			panelAnnadir = new JPanel();
			panelAnnadir.setBorder(new LineBorder(new Color(0, 0, 0)));
			panelAnnadir.setBackground(new Color(255, 255, 255));
			panelAnnadir.setBounds(137, 53, 438, 422);
			panelAnnadir.setLayout(null);
			panelAnnadir.add(getScrollPane());
			panelAnnadir.add(getLblNewLabel_1());
			panelAnnadir.add(getLblNewLabel_3_2());
			panelAnnadir.add(getLblNewLabel_3_3());
			panelAnnadir.add(getComboBoxNombreCarrera());
			panelAnnadir.add(getBtnAnnadirInterior());
			panelAnnadir.add(getLbAsignatura());
			panelAnnadir.add(getLbNombreCarrera());
			panelAnnadir.add(getLbIDCarrera());
			panelAnnadir.add(getLbAnnosCarrera());
			panelAnnadir.add(getTextFieldID());
			panelAnnadir.add(getSeparator_4_2());
			panelAnnadir.add(getCBoxAnnosCarrera());
			panelAnnadir.add(getLbIDCarrera_1());
			panelAnnadir.add(getTextField_2());
			panelAnnadir.add(getSeparator_4_2_1());
			panelAnnadir.add(getLbNombreCarrera_1());
			panelAnnadir.add(getTextField_3());
			panelAnnadir.add(getSeparator_4_2_1_1());
			panelAnnadir.add(getLblAo());
			panelAnnadir.add(getCBoxAnnosCarrera_1());
			panelAnnadir.add(getLbIDCarrera_1_1());
			panelAnnadir.add(getTextField_4());
			panelAnnadir.add(getSeparator_4_2_2());
			panelAnnadir.add(getLblNewLabel_3_2_1());
			panelAnnadir.add(getLbNombreCarrera_1_1());
			panelAnnadir.add(getLbNombreCarrera_1_2());
			panelAnnadir.add(getLbNombreCarrera_1_3());
			panelAnnadir.add(getTextField_1());
			panelAnnadir.add(getTextField_4_1());
			panelAnnadir.add(getSeparator_4_2_2_1());
			panelAnnadir.add(getSeparator_4_2_2_2());
			panelAnnadir.setVisible(false);
		}
		return panelAnnadir;
	}
	private JLabel getLblNewLabel_1() {
		if (lblNewLabel_1 == null) {
			lblNewLabel_1 = new JLabel("Añadir");
			lblNewLabel_1.setFont(new Font("Yu Gothic UI Semibold", Font.BOLD | Font.ITALIC, 28));
			lblNewLabel_1.setBounds(185, 11, 108, 61);
		}
		return lblNewLabel_1;
	}
	private JLabel getLblNewLabel_3_2() {
		if (lblNewLabel_3_2 == null) {
			lblNewLabel_3_2 = new JLabel("Año:");
			lblNewLabel_3_2.setFont(new Font("Yu Gothic UI Semibold", Font.BOLD | Font.ITALIC, 17));
			lblNewLabel_3_2.setBounds(15, 226, 69, 38);
		}
		return lblNewLabel_3_2;
	}
	private JLabel getLblNewLabel_3_3() {
		if (lblNewLabel_3_3 == null) {
			lblNewLabel_3_3 = new JLabel("Carrera:");
			lblNewLabel_3_3.setFont(new Font("Yu Gothic UI Semibold", Font.BOLD | Font.ITALIC, 17));
			lblNewLabel_3_3.setBounds(10, 59, 93, 32);
		}
		return lblNewLabel_3_3;
	}
	private JComboBox<String> getComboBoxNombreCarrera() {
		if (comboBoxNombreCarrera == null) {
			comboBoxNombreCarrera = new JComboBox<String>();
			comboBoxNombreCarrera.setBackground(new Color(255, 255, 255));
			comboBoxNombreCarrera.setOpaque(false);
			comboBoxNombreCarrera.setBounds(125, 87, 253, 20);
			
			comboBoxNombreCarrera.addItem("  ");
			comboBoxNombreCarrera.addItem("elemento 1");
			comboBoxNombreCarrera.addItem("elemento 1");
			
			
		}
		return comboBoxNombreCarrera;
	}
	private JButton getBtnAnnadirEliminar() {
		if (btnAnnadirEliminar == null) {
			btnAnnadirEliminar = new JButton("Añadir");
			btnAnnadirEliminar.setOpaque(false);
			btnAnnadirEliminar.setFont(new Font("Yu Gothic UI Semibold", Font.BOLD | Font.ITALIC, 19));
			btnAnnadirEliminar.setFocusPainted(false);
			btnAnnadirEliminar.setContentAreaFilled(false);
			btnAnnadirEliminar.setBorder(null);
			btnAnnadirEliminar.setBounds(22, 105, 89, 41);
			
			
			btnAnnadirEliminar.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					int x=438;
					int y=422;
					btnAnnadirMostrar.setVisible(true);
					btnAnnadirEliminar.setVisible(false);
					
					
					
					
				        if(x==438){
				        	
				           Thread th = new Thread(){
				               @Override
				               public void run(){
				                   try{
				                       for(int i=438;i>=0;i--){
				                           Thread.sleep(1);
				                           panelAnnadir.setSize(i,422);
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
		return btnAnnadirEliminar;
	}
	  private JPanel getPanel_1_1() {
		if (panel_1 == null) {
			panel_1 = new JPanel();
			panel_1.setBorder(new LineBorder(new Color(0, 0, 0)));
			panel_1.setBackground(new Color(255, 255, 255));
			panel_1.setLayout(null);
			panel_1.add(getLblNewLabel_2_1());
			panel_1.setPreferredSize(new Dimension(0, 10000));
			
			panel_1.setVisible(true);
			
		}
		return panel_1;
	}
	private JLabel getLblNewLabel_2_1() {
		if (lblNewLabel_2_1 == null) {
			lblNewLabel_2_1 = new JLabel("Editar:");
			lblNewLabel_2_1.setBounds(139, 11, 89, 41);
			lblNewLabel_2_1.setFont(new Font("Yu Gothic UI Semibold", Font.BOLD | Font.ITALIC, 22));
		}
		return lblNewLabel_2_1;
	}
	private JScrollPane getScrollPane() {
		if (scrollPane == null) {
			scrollPane = new JScrollPane();
			scrollPane.setBounds(0, 0, 438, 422);
			scrollPane.setViewportView(getPanel_1_1());
			scrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
			scrollPane.setPreferredSize(new Dimension(438, 422)); 
		}
		return scrollPane;
	}
	private JButton getBtnEditarEliminar() {
		if (btnEditarEliminar == null) {
			btnEditarEliminar = new JButton("Editar");
			btnEditarEliminar.setOpaque(false);
			btnEditarEliminar.setFont(new Font("Yu Gothic UI Semibold", Font.BOLD | Font.ITALIC, 18));
			btnEditarEliminar.setFocusPainted(false);
			btnEditarEliminar.setContentAreaFilled(false);
			btnEditarEliminar.setBorder(null);
			btnEditarEliminar.setBounds(22, 179, 89, 41);
			
			//no tocar aun
			btnEditarEliminar.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					int x=438;
					int y=422;
					btnEditarMostrar.setVisible(true);
					btnEditarEliminar.setVisible(false);
					
				//	scrollPane.getViewport().setVisible(false);
				//	scrollPane.setVisible(false);
					panelAnnadir.setVisible(false);
					
					
				        if(x==438){
				        	
				           Thread th = new Thread(){
				               @Override
				               public void run(){
				                   try{
				                       for(int i=438;i>=0;i--){
				                           Thread.sleep(1);
				                          // scrollPane.setSize(i,422);
				                        //   panelAnnadir.setSize(i,422);
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
		return btnEditarEliminar;
	}
	private JButton getBtnCerrar() {
		if (btnCerrar == null) {
			btnCerrar = new JButton("");
			btnCerrar.setBounds(538, 11, 75, 23);
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
			btnAnnadirInterior.setIcon(new ImageIcon(Formulario.class.getResource("/icons/icons8-add-properties-24.png")));
			btnAnnadirInterior.setBounds(379, 11, 42, 38);
			
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
	private JScrollPane getScrollPane_1() {
		if (scrollPane_1 == null) {
			scrollPane_1 = new JScrollPane();
			scrollPane_1.setBounds(137, 53, 438, 422);
			scrollPane_1.setViewportView(getPanelEliminar());
			scrollPane_1.setVisible(false);
		}
		return scrollPane_1;
	}
	private JButton getBtnEliminarOcultar() {
		if (btnEliminarOcultar == null) {
			btnEliminarOcultar = new JButton("Eliminar");
			
			btnAnnadirMostrar.setVisible(true);
			btnEditarMostrar.setVisible(true);

			btnEliminarOcultar.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					scrollPane_1.setVisible(false);
					btnEliminarMostrar.setVisible(true);
					

					
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
	private JLabel getLblNewLabel_4() {
		if (lblNewLabel_4 == null) {
			lblNewLabel_4 = new JLabel("");
			lblNewLabel_4.setToolTipText("Formularios");
			lblNewLabel_4.setIcon(new ImageIcon(Formulario.class.getResource("/icons/Fondo de textura de acuarela amarilla brillante _ Vector Gratis.jpg")));
			lblNewLabel_4.setBounds(0, 0, 613, 527);
		}
		return lblNewLabel_4;
	}
	private JLabel getLbAsignatura() {
		if (lbAsignatura == null) {
			lbAsignatura = new JLabel("Asignatura:");
			lbAsignatura.setFont(new Font("Yu Gothic UI Semibold", Font.BOLD | Font.ITALIC, 17));
			lbAsignatura.setBounds(12, 152, 91, 38);
		}
		return lbAsignatura;
	}
	private JLabel getLbNombreCarrera() {
		if (lbNombreCarrera == null) {
			lbNombreCarrera = new JLabel("Nombre:");
			lbNombreCarrera.setFont(new Font("Yu Gothic UI Semibold", Font.BOLD | Font.ITALIC, 12));
			lbNombreCarrera.setBounds(23, 86, 61, 20);
		}
		return lbNombreCarrera;
	}
	private JLabel getLbIDCarrera() {
		if (lbIDCarrera == null) {
			lbIDCarrera = new JLabel("ID:");
			lbIDCarrera.setFont(new Font("Yu Gothic UI Semibold", Font.BOLD | Font.ITALIC, 12));
			lbIDCarrera.setBounds(23, 133, 61, 20);
		}
		return lbIDCarrera;
	}
	private JLabel getLbAnnosCarrera() {
		if (lbAnnosCarrera == null) {
			lbAnnosCarrera = new JLabel("Años:");
			lbAnnosCarrera.setFont(new Font("Yu Gothic UI Semibold", Font.BOLD | Font.ITALIC, 12));
			lbAnnosCarrera.setBounds(23, 110, 61, 20);
		}
		return lbAnnosCarrera;
	}
	private JTextField getTextFieldID() {
		if (textFieldID == null) {
			textFieldID = new JTextField();
			textFieldID.setOpaque(false);
			textFieldID.setColumns(10);
			textFieldID.setBorder(new EmptyBorder(0, 0, 0, 0));
			textFieldID.setBounds(125, 133, 253, 20);
		}
		return textFieldID;
	}
	private JSeparator getSeparator_4_2() {
		if (separator_4_2 == null) {
			separator_4_2 = new JSeparator();
			separator_4_2.setForeground(Color.BLACK);
			separator_4_2.setBounds(125, 151, 253, 2);
		}
		return separator_4_2;
	}
	private JComboBox<String> getCBoxAnnosCarrera() {
		if (cBoxAnnosCarrera == null) {
			cBoxAnnosCarrera = new JComboBox<String>();
			cBoxAnnosCarrera.setOpaque(false);
			cBoxAnnosCarrera.setBackground(Color.WHITE);
			cBoxAnnosCarrera.setBounds(125, 110, 253, 20);
		}
		return cBoxAnnosCarrera;
	}
	private JLabel getLbIDCarrera_1() {
		if (lbIDCarrera_1 == null) {
			lbIDCarrera_1 = new JLabel("ID:");
			lbIDCarrera_1.setFont(new Font("Yu Gothic UI Semibold", Font.BOLD | Font.ITALIC, 12));
			lbIDCarrera_1.setBounds(25, 207, 61, 20);
		}
		return lbIDCarrera_1;
	}
	private JTextField getTextField_2() {
		if (textField_2 == null) {
			textField_2 = new JTextField();
			textField_2.setOpaque(false);
			textField_2.setColumns(10);
			textField_2.setBorder(new EmptyBorder(0, 0, 0, 0));
			textField_2.setBounds(125, 186, 253, 20);
		}
		return textField_2;
	}
	private JSeparator getSeparator_4_2_1() {
		if (separator_4_2_1 == null) {
			separator_4_2_1 = new JSeparator();
			separator_4_2_1.setForeground(Color.BLACK);
			separator_4_2_1.setBounds(125, 207, 253, 2);
		}
		return separator_4_2_1;
	}
	private JLabel getLbNombreCarrera_1() {
		if (lbNombreCarrera_1 == null) {
			lbNombreCarrera_1 = new JLabel("Nombre:");
			lbNombreCarrera_1.setFont(new Font("Yu Gothic UI Semibold", Font.BOLD | Font.ITALIC, 12));
			lbNombreCarrera_1.setBounds(25, 186, 61, 20);
		}
		return lbNombreCarrera_1;
	}
	private JTextField getTextField_3() {
		if (textField_3 == null) {
			textField_3 = new JTextField();
			textField_3.setOpaque(false);
			textField_3.setColumns(10);
			textField_3.setBorder(new EmptyBorder(0, 0, 0, 0));
			textField_3.setBounds(125, 208, 253, 20);
		}
		return textField_3;
	}
	private JSeparator getSeparator_4_2_1_1() {
		if (separator_4_2_1_1 == null) {
			separator_4_2_1_1 = new JSeparator();
			separator_4_2_1_1.setForeground(Color.BLACK);
			separator_4_2_1_1.setBounds(125, 226, 253, 2);
		}
		return separator_4_2_1_1;
	}
	private JLabel getLblAo() {
		if (lblAo == null) {
			lblAo = new JLabel("Cantidad:");
			lblAo.setFont(new Font("Yu Gothic UI Semibold", Font.BOLD | Font.ITALIC, 12));
			lblAo.setBounds(25, 262, 61, 20);
		}
		return lblAo;
	}
	private JComboBox<String> getCBoxAnnosCarrera_1() {
		if (cBoxAnnosCarrera_1 == null) {
			cBoxAnnosCarrera_1 = new JComboBox<String>();
			cBoxAnnosCarrera_1.setOpaque(false);
			cBoxAnnosCarrera_1.setBackground(Color.WHITE);
			cBoxAnnosCarrera_1.setBounds(125, 263, 253, 20);
		}
		return cBoxAnnosCarrera_1;
	}
	private JLabel getLbIDCarrera_1_1() {
		if (lbIDCarrera_1_1 == null) {
			lbIDCarrera_1_1 = new JLabel("ID:");
			lbIDCarrera_1_1.setFont(new Font("Yu Gothic UI Semibold", Font.BOLD | Font.ITALIC, 12));
			lbIDCarrera_1_1.setBounds(23, 293, 61, 20);
		}
		return lbIDCarrera_1_1;
	}
	private JTextField getTextField_4() {
		if (textField == null) {
			textField = new JTextField();
			textField.setOpaque(false);
			textField.setColumns(10);
			textField.setBorder(new EmptyBorder(0, 0, 0, 0));
			textField.setBounds(123, 294, 255, 20);
		}
		return textField;
	}
	private JSeparator getSeparator_4_2_2() {
		if (separator_4_2_2 == null) {
			separator_4_2_2 = new JSeparator();
			separator_4_2_2.setForeground(Color.BLACK);
			separator_4_2_2.setBounds(125, 313, 253, 0);
		}
		return separator_4_2_2;
	}
	private JLabel getLblNewLabel_3_2_1() {
		if (lblNewLabel_3_2_1 == null) {
			lblNewLabel_3_2_1 = new JLabel("Material:");
			lblNewLabel_3_2_1.setFont(new Font("Yu Gothic UI Semibold", Font.BOLD | Font.ITALIC, 17));
			lblNewLabel_3_2_1.setBounds(15, 313, 88, 38);
		}
		return lblNewLabel_3_2_1;
	}
	private JLabel getLbNombreCarrera_1_1() {
		if (lbNombreCarrera_1_1 == null) {
			lbNombreCarrera_1_1 = new JLabel("Título:");
			lbNombreCarrera_1_1.setFont(new Font("Yu Gothic UI Semibold", Font.BOLD | Font.ITALIC, 12));
			lbNombreCarrera_1_1.setBounds(23, 344, 61, 20);
		}
		return lbNombreCarrera_1_1;
	}
	private JLabel getLbNombreCarrera_1_2() {
		if (lbNombreCarrera_1_2 == null) {
			lbNombreCarrera_1_2 = new JLabel("Autor:");
			lbNombreCarrera_1_2.setFont(new Font("Yu Gothic UI Semibold", Font.BOLD | Font.ITALIC, 12));
			lbNombreCarrera_1_2.setBounds(23, 368, 61, 20);
		}
		return lbNombreCarrera_1_2;
	}
	private JLabel getLbNombreCarrera_1_3() {
		if (lbNombreCarrera_1_3 == null) {
			lbNombreCarrera_1_3 = new JLabel("Fecha:");
			lbNombreCarrera_1_3.setFont(new Font("Yu Gothic UI Semibold", Font.BOLD | Font.ITALIC, 12));
			lbNombreCarrera_1_3.setBounds(23, 391, 61, 20);
		}
		return lbNombreCarrera_1_3;
	}
	

	private JTextField getTextField_1() {
		if (textField_1 == null) {
			textField_1 = new JTextField();
			textField_1.setOpaque(false);
			textField_1.setColumns(10);
			textField_1.setBorder(new EmptyBorder(0, 0, 0, 0));
			textField_1.setBounds(125, 345, 253, 20);
		}
		return textField_1;
	}
	private JTextField getTextField_4_1() {
		if (textField_4 == null) {
			textField_4 = new JTextField();
			textField_4.setOpaque(false);
			textField_4.setColumns(10);
			textField_4.setBorder(new EmptyBorder(0, 0, 0, 0));
			textField_4.setBounds(125, 369, 253, 20);
		}
		return textField_4;
	}
	private JSeparator getSeparator_4_2_2_1() {
		if (separator_4_2_2_1 == null) {
			separator_4_2_2_1 = new JSeparator();
			separator_4_2_2_1.setForeground(Color.BLACK);
			separator_4_2_2_1.setBounds(125, 364, 253, 2);
		}
		return separator_4_2_2_1;
	}
	private JSeparator getSeparator_4_2_2_2() {
		if (separator_4_2_2_2 == null) {
			separator_4_2_2_2 = new JSeparator();
			separator_4_2_2_2.setForeground(Color.BLACK);
			separator_4_2_2_2.setBounds(125, 388, 253, 1);
		}
		return separator_4_2_2_2;
	}
}


