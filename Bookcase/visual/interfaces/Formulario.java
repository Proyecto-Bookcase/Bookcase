package interfaces;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

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
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;



public class Formulario extends JFrame {

	private JPanel contentPane;
	private JPanel panel;
	private JLabel lblNewLabel;
	private JButton btnAnnadirMostrar;
	private JButton btnEditarMostrar;
	private JButton btnEliminar;
	private JPanel panelAnnadir;
	private JLabel lblNewLabel_1;
	private JLabel lblNewLabel_3;
	private JLabel lblNewLabel_3_1;
	private JLabel lblNewLabel_3_2;
	private JLabel lblNewLabel_3_3;
	private JTextField textFieldNombre;
	private JComboBox comboBoxTipo;
	private JComboBox<String> comboBoxCarreras;
	private JTextField textFieldAnno;
	private JSeparator separator;
	private JSeparator separator_1;
	private JButton btnAnnadirEliminar;
	private JPanel panel_1;
	private JLabel lblNewLabel_2_1;
	private JScrollPane scrollPane;
	private JButton btnEditarEliminar;
	private JLabel lblNewLabel_4;
	private JLabel lblNewLabel_5;
	private JButton btnCerrar;
	private JLabel panelPantalla;
	private JSeparator separator_2;
	private JSeparator separator_3;
	private JSeparator separator_3_1;
	private JButton btnAtras;

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
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 603, 527);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setUndecorated(true);

		setContentPane(contentPane);
		contentPane.setLayout(null);
		contentPane.add(getBtnAtras());
		contentPane.add(getBtnCerrar());
		contentPane.add(getPanel());
		contentPane.add(getPanelAnnadir());
		contentPane.add(getLblNewLabel());
		contentPane.add(getPanelPantalla());
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
					
					
					//panel_1.setVisible(false);
					
					
				     
				        if(x==438){
				        	panelAnnadir.show();
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
			/*btnEditarMostrar.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {	
					
					int x=438;
					int y=422;
					btnEditarEliminar.setVisible(true);
					btnEditarMostrar.setVisible(false);
					
					panelAnnadir.setVisible(false);
					
					
					scrollPane.setPreferredSize(new Dimension(438, 422));
				     
				        if(x==438){
				        	panelAnnadir.show();
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
			});*/
		}
		return btnEditarMostrar;
	}
	private JButton getBtnNewButton_2_1() {
		if (btnEliminar == null) {
			btnEliminar = new JButton("Eliminar");
			btnEliminar.setFont(new Font("Yu Gothic UI Semibold", Font.BOLD | Font.ITALIC, 18));
			btnEliminar.setBounds(10, 253, 107, 41);
			
			btnEliminar.setOpaque(false);
			btnEliminar.setBorder(null);
			btnEliminar.setContentAreaFilled(false);
			btnEliminar.setFocusPainted(false);
		}
		return btnEliminar;
	}
	private JPanel getPanelAnnadir() {
		if (panelAnnadir == null) {
			panelAnnadir = new JPanel();
			panelAnnadir.setBackground(new Color(255, 255, 255));
			panelAnnadir.setBounds(137, 53, 438, 422);
			panelAnnadir.setLayout(null);
		//	panelAnnadir.add(getScrollPane());
			panelAnnadir.add(getLblNewLabel_1());
			panelAnnadir.add(getLblNewLabel_3());
			panelAnnadir.add(getLblNewLabel_3_1());
			panelAnnadir.add(getLblNewLabel_3_2());
			panelAnnadir.add(getLblNewLabel_3_3());
			panelAnnadir.add(getTextFieldNombre());
			panelAnnadir.add(getComboBoxTipo());
			panelAnnadir.add(getComboBoxCarreras());
			panelAnnadir.add(getTextFieldAnno());
			panelAnnadir.add(getSeparator());
			panelAnnadir.add(getSeparator_1());
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
	private JLabel getLblNewLabel_3() {
		if (lblNewLabel_3 == null) {
			lblNewLabel_3 = new JLabel("Nombre:");
			lblNewLabel_3.setFont(new Font("Yu Gothic UI Semibold", Font.BOLD | Font.ITALIC, 17));
			lblNewLabel_3.setBounds(31, 96, 95, 38);
		}
		return lblNewLabel_3;
	}
	private JLabel getLblNewLabel_3_1() {
		if (lblNewLabel_3_1 == null) {
			lblNewLabel_3_1 = new JLabel("Tipo:");
			lblNewLabel_3_1.setFont(new Font("Yu Gothic UI Semibold", Font.BOLD | Font.ITALIC, 17));
			lblNewLabel_3_1.setBounds(31, 157, 85, 38);
		}
		return lblNewLabel_3_1;
	}
	private JLabel getLblNewLabel_3_2() {
		if (lblNewLabel_3_2 == null) {
			lblNewLabel_3_2 = new JLabel("Año:");
			lblNewLabel_3_2.setFont(new Font("Yu Gothic UI Semibold", Font.BOLD | Font.ITALIC, 17));
			lblNewLabel_3_2.setBounds(31, 216, 123, 38);
		}
		return lblNewLabel_3_2;
	}
	private JLabel getLblNewLabel_3_3() {
		if (lblNewLabel_3_3 == null) {
			lblNewLabel_3_3 = new JLabel("Carrera:");
			lblNewLabel_3_3.setFont(new Font("Yu Gothic UI Semibold", Font.BOLD | Font.ITALIC, 17));
			lblNewLabel_3_3.setBounds(31, 282, 123, 38);
		}
		return lblNewLabel_3_3;
	}
	private JTextField getTextFieldNombre() {
		if (textFieldNombre == null) {
			textFieldNombre = new JTextField();
			textFieldNombre.setBounds(129, 96, 341, 32);
			textFieldNombre.setColumns(10);
			
			textFieldNombre.setOpaque(false);
			textFieldNombre.setBorder(new EmptyBorder(0, 0, 0, 0));
			textFieldNombre.setOpaque(false);
		}
		return textFieldNombre;
	}
	private JComboBox getComboBoxTipo() {
		if (comboBoxTipo == null) {
			comboBoxTipo = new JComboBox();
			comboBoxTipo.setBackground(new Color(255, 255, 255));
			comboBoxTipo.setOpaque(false);
			comboBoxTipo.setBorder(null);
			comboBoxTipo.setBounds(129, 155, 292, 32);
			
			
		}
		return comboBoxTipo;
	}
	private JComboBox<String> getComboBoxCarreras() {
		if (comboBoxCarreras == null) {
			comboBoxCarreras = new JComboBox<String>();
			comboBoxCarreras.setBackground(new Color(255, 255, 255));
			comboBoxCarreras.setOpaque(false);
			comboBoxCarreras.setBounds(129, 282, 292, 32);
			
			comboBoxCarreras.addItem("  ");
			comboBoxCarreras.addItem("elemento 1");
			comboBoxCarreras.addItem("elemento 1");
			
			
		}
		return comboBoxCarreras;
	}
	private JTextField getTextFieldAnno() {
		if (textFieldAnno == null) {
			textFieldAnno = new JTextField();
			textFieldAnno.setBounds(131, 228, 192, 32);
			textFieldAnno.setColumns(10);
			
			textFieldAnno.setOpaque(false);
			textFieldAnno.setBorder(new EmptyBorder(0, 0, 0, 0));
			textFieldAnno.setOpaque(false);
		}
		return textFieldAnno;
	}
	private JSeparator getSeparator() {
		if (separator == null) {
			separator = new JSeparator();
			separator.setBounds(128, 125, 293, 2);
		}
		return separator;
	}
	private JSeparator getSeparator_1() {
		if (separator_1 == null) {
			separator_1 = new JSeparator();
			separator_1.setBounds(135, 253, 286, 2);
		}
		return separator_1;
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
	/*private JPanel getPanel_1_1() {
		if (panel_1 == null) {
			panel_1 = new JPanel();
			panel_1.setLayout(null);
			panel_1.add(getLblNewLabel_2_1());
			panel_1.setPreferredSize(new Dimension(0, 10000));
			panel_1.add(getLblNewLabel_4());
			panel_1.add(getLblNewLabel_5());
			
			panel_1.setVisible(true);
			
		}
		return panel_1;
	}*/
	private JLabel getLblNewLabel_2_1() {
		if (lblNewLabel_2_1 == null) {
			lblNewLabel_2_1 = new JLabel("Editar:");
			lblNewLabel_2_1.setBounds(139, 11, 89, 41);
			lblNewLabel_2_1.setFont(new Font("Yu Gothic UI Semibold", Font.BOLD | Font.ITALIC, 22));
		}
		return lblNewLabel_2_1;
	}
	/*private JScrollPane getScrollPane() {
		if (scrollPane == null) {
			scrollPane = new JScrollPane();
			scrollPane.setBounds(0, 0, 438, 422);
			scrollPane.setViewportView(getPanel_1_1());
			scrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
			scrollPane.setPreferredSize(new Dimension(438, 422)); 
		}
		return scrollPane;
	}*/
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
		/*	btnEditarEliminar.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					int x=438;
					int y=422;
					btnEditarMostrar.setVisible(true);
					btnEditarEliminar.setVisible(false);
					
					
				        if(x==438){
				        	
				           Thread th = new Thread(){
				               @Override
				               public void run(){
				                   try{
				                       for(int i=438;i>=0;i--){
				                           Thread.sleep(1);
				                           panel_1.setSize(i,422);
				                       }
				                   }catch(Exception e){
				                       JOptionPane.showMessageDialog(null,e);
				                   }
				               }
				               
				       };th.start();
				       }
				}
			});*/
		}
		return btnEditarEliminar;
	}
	private JLabel getLblNewLabel_4() {
		if (lblNewLabel_4 == null) {
			lblNewLabel_4 = new JLabel("Algo");
			lblNewLabel_4.setFont(new Font("Tahoma", Font.PLAIN, 23));
			lblNewLabel_4.setBounds(10, 102, 137, 29);
		}
		return lblNewLabel_4;
	}
	private JLabel getLblNewLabel_5() {
		if (lblNewLabel_5 == null) {
			lblNewLabel_5 = new JLabel("");
			lblNewLabel_5.setIcon(new ImageIcon("C:\\Users\\Dashiell\\Downloads\\Telegram Desktop\\icons8-empty-trash-48.png"));
			lblNewLabel_5.setBounds(125, 83, 59, 56);
		}
		return lblNewLabel_5;
	}
	private JButton getBtnCerrar() {
		if (btnCerrar == null) {
			btnCerrar = new JButton("");
			btnCerrar.setBounds(500, 11, 75, 23);
			btnCerrar.setIcon(new ImageIcon(Formulario.class.getResource("/icons/icons8-x-24.png")));
			
			btnCerrar.setOpaque(false);
			btnCerrar.setBorder(null);
			btnCerrar.setContentAreaFilled(false);
			btnCerrar.setFocusPainted(false);
			btnCerrar.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					System.exit(0);
				}
			});
			//btnCerrar.setIcon(new ImageIcon(Formulario.class.getResource("/Visual/icons/icons8-x-24.png")));
		}
		return btnCerrar;
	}
	private JLabel getPanelPantalla() {
		if (panelPantalla == null) {
			panelPantalla = new JLabel("");
			panelPantalla.setIcon(new ImageIcon(Formulario.class.getResource("/icons/Fondo de textura de acuarela amarilla brillante _ Vector Gratis.jpg")));
			panelPantalla.setBounds(-19, 0, 632, 527);
		}
		return panelPantalla;
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
	private JButton getBtnAtras() {
		if (btnAtras == null) {
			btnAtras = new JButton("");
			btnAtras.setIcon(new ImageIcon(Formulario.class.getResource("/icons/icons8-login-30.png")));
			btnAtras.setOpaque(false);
			btnAtras.setFocusPainted(false);
			btnAtras.setContentAreaFilled(false);
			btnAtras.setBorder(null);
			btnAtras.setBounds(0, 11, 64, 31);
		}
		return btnAtras;
	}
}
