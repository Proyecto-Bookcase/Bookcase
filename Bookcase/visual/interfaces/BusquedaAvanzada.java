package interfaces;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.Color;
import java.awt.Dimension;

import javax.swing.border.EtchedBorder;
import javax.swing.border.MatteBorder;
import javax.swing.JButton;
import javax.swing.ImageIcon;
import javax.swing.JTextPane;
import javax.swing.border.LineBorder;
import javax.swing.JScrollPane;
import javax.swing.JSeparator;
import javax.swing.JTextField;
import javax.swing.JComboBox;

public class BusquedaAvanzada extends JFrame {

	private JPanel contentPane;
	private JLabel lblNewLabel;
	private JPanel panelOpcionesBusqueda;
	private JButton btnCerrar;
	private JLabel lblNewLabel_1;
	private JButton btn1Mostrar;
	private JButton btn2Mostrar;
	private JButton btn5Mostrar;
	private JPanel panelMasUsado;
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
	private JLabel lblNewLabel_2;
	private JLabel lblNewLabel_3;
	private JLabel lblNewLabel_1_5_1;
	private JComboBox comboBox;
	private JLabel lblNewLabel_1_5_1_1;
	private JComboBox comboBox_1;

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
		setUndecorated(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 625, 464);
		contentPane = new JPanel();
		contentPane.setBorder(new LineBorder(new Color(0, 0, 0)));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		contentPane.add(getScrollPane_3());
		contentPane.add(getPanelMyorCantidadMat());
		contentPane.add(getScrollPane());
		contentPane.add(getPanelOpcionesBusqueda());
		contentPane.add(getLblNewLabel());
		contentPane.add(getBtnCerrar());
		contentPane.add(getLblNewLabel_2());
		contentPane.add(getLblNewLabel_3());
	}
	private JLabel getLblNewLabel() {
		if (lblNewLabel == null) {
			lblNewLabel = new JLabel("Búsqueda Avanzada");
			lblNewLabel.setFont(new Font("Yu Gothic UI Semibold", Font.BOLD | Font.ITALIC, 30));
			lblNewLabel.setBounds(277, 150, 336, 76);
		}
		return lblNewLabel;
	}
	private JPanel getPanelOpcionesBusqueda() {
		if (panelOpcionesBusqueda == null) {
			panelOpcionesBusqueda = new JPanel();
			panelOpcionesBusqueda.setBorder(new MatteBorder(1, 1, 1, 1, (Color) new Color(0, 0, 0)));
			panelOpcionesBusqueda.setBackground(new Color(255, 255, 255));
			panelOpcionesBusqueda.setBounds(0, 56, 218, 365);
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
		}
		return panelOpcionesBusqueda;
	}
	private JButton getBtnCerrar() {
		if (btnCerrar == null) {
			btnCerrar = new JButton("");
			btnCerrar.setIcon(new ImageIcon(BusquedaAvanzada.class.getResource("/icons/icons8-x-24.png")));
			btnCerrar.setBounds(543, 0, 70, 33);
			
			btnCerrar.setOpaque(false);
			btnCerrar.setBorder(null);
			btnCerrar.setContentAreaFilled(false);
			btnCerrar.setFocusPainted(false);
			btnCerrar.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					System.exit(0);
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
					
					int x=371;
					int y=365;
					btn1Ocultar.setVisible(true);
					btn1Mostrar.setVisible(false);
					
					panelMyorCantidadMat.setVisible(false);
					btn2Mostrar.setVisible(true);
					btn5Mostrar.setVisible(true);
					 scrollPane_3.setVisible(false);




				//	btnEditarMostrar.setVisible(true);
                 //   btnAnnadirMostrar.setVisible(true);
                 //   panelAnnadir.setVisible(false);
					
					
				     
				        if(x==371){ 
							scrollPane.show();
		   
				         Thread th = new Thread(){
				             @Override
				             public void run(){
				            	 int x=371;
				                 try{
				                   for(int i =0;i<=x;i++){
				                	   
				                       Thread.sleep(1);
										scrollPane.setSize(i,365);
										panelMasUsado.setSize(i, 365);				                       
				                   }  
				                 }catch(Exception e){
				                     JOptionPane.showMessageDialog(null, e);
				                 }
				             }
				         };th.start();
				         x=419;
				        
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
			btn2Mostrar.setBounds(22, 195, 173, 49);
			
			btn2Mostrar.setOpaque(false);
			btn2Mostrar.setBorder(null);
			btn2Mostrar.setContentAreaFilled(false);
			btn2Mostrar.setFocusPainted(false);
			
			btn2Mostrar.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {	
					
					int x=371;
					int y=365;
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
					
					
				     
				        if(x==371){ 
				        	panelMyorCantidadMat.show();
						//	scrollPane_1.setVisible(true);
		   
				         Thread th = new Thread(){
				             @Override
				             public void run(){
				            	 int x=371;
				                 try{
				                   for(int i =0;i<=x;i++){
				                	   
				                       Thread.sleep(1);
				                       panelMyorCantidadMat.setSize(i,365);
				                    

				                   }  
				                 }catch(Exception e){
				                     JOptionPane.showMessageDialog(null, e);
				                 }
				             }
				         };th.start();
				         x=371;
				        
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
					
					int x=371;
					int y=365;
					btn5Ocultar.setVisible(true);
					btn5Mostrar.setVisible(false);
					
					panelMyorCantidadMat.setVisible(false);
					btn2Mostrar.setVisible(true);
					btn1Mostrar.setVisible(true);

					
					 
				//	 scrollPane_2.setVisible(false);




				//	btnEditarMostrar.setVisible(true);
                 //   btnAnnadirMostrar.setVisible(true);
                 //   panelAnnadir.setVisible(false);
					
					
				     
				        if(x==371){ 
							scrollPane_3.show();
		   
				         Thread th = new Thread(){
				             @Override
				             public void run(){
				            	 int x=371;
				                 try{
				                   for(int i =0;i<=x;i++){
				                	   
				                       Thread.sleep(1);
										scrollPane_3.setSize(i,365);
										panel.setSize(i, 365);				                       
				                   }  
				                 }catch(Exception e){
				                     JOptionPane.showMessageDialog(null, e);
				                 }
				             }
				         };th.start();
				         x=419;
				        
				     }
				}
			});
		
			
			
			
			
		}
		return btn5Mostrar;
	}
	private JPanel getPanelMasUsado() {
		if (panelMasUsado == null) {
			panelMasUsado = new JPanel();
			panelMasUsado.setBorder(new LineBorder(new Color(0, 0, 0)));
			panelMasUsado.setBackground(new Color(255, 255, 255));
			panelMasUsado.setPreferredSize(new Dimension(0, 10000));
			panelMasUsado.setLayout(null);
			panelMasUsado.add(getLblNewLabel_1_1());

		}
		return panelMasUsado;
	}
	private JScrollPane getScrollPane() {
		if (scrollPane == null) {
			scrollPane = new JScrollPane();
			scrollPane.setBounds(217, 56, 371, 365);
			scrollPane.setViewportView(getPanelMasUsado());
			
			scrollPane.setVisible(false);

		}
		return scrollPane;
	}
	private JLabel getLblNewLabel_1_1() {
		if (lblNewLabel_1_1 == null) {
			lblNewLabel_1_1 = new JLabel("Materiales más usados:");
			lblNewLabel_1_1.setBounds(93, 11, 239, 33);
			lblNewLabel_1_1.setFont(new Font("Yu Gothic UI Semibold", Font.ITALIC, 20));
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
			btn2Ocultar.setBounds(22, 195, 173, 49);
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
			separator_1.setBounds(33, 242, 152, 2);
		}
		return separator_1;
	}
	private JPanel getPanelMyorCantidadMat() {
		if (panelMyorCantidadMat == null) {
			panelMyorCantidadMat = new JPanel();
			panelMyorCantidadMat.setBorder(new LineBorder(new Color(0, 0, 0)));
			panelMyorCantidadMat.setBackground(new Color(255, 255, 255));
			panelMyorCantidadMat.setBounds(217, 56, 371, 365);
			panelMyorCantidadMat.setLayout(null);
			panelMyorCantidadMat.add(getLblNewLabel_1_2());
			panelMyorCantidadMat.add(getTxtpnEnEstaPantalla());
			
			panelMyorCantidadMat.setVisible(false);
		}
		return panelMyorCantidadMat;
	}
	private JLabel getLblNewLabel_1_2() {
		if (lblNewLabel_1_2 == null) {
			lblNewLabel_1_2 = new JLabel("Asignaturas con mayor cantidad de materiales:");
			lblNewLabel_1_2.setFont(new Font("Yu Gothic UI Semibold", Font.ITALIC, 16));
			lblNewLabel_1_2.setBounds(21, 11, 364, 33);
		}
		return lblNewLabel_1_2;
	}
	private JTextPane getTxtpnEnEstaPantalla() {
		if (txtpnEnEstaPantalla == null) {
			txtpnEnEstaPantalla = new JTextPane();
			txtpnEnEstaPantalla.setText("En esta pantalla irian :\r\nAsignatura:\r\nCantidad:\r\n.\r\n.\r\n.\r\n.");
			txtpnEnEstaPantalla.setBounds(74, 73, 260, 104);
		}
		return txtpnEnEstaPantalla;
	}
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
			scrollPane_3.setBounds(217, 56, 371, 365);
			scrollPane_3.setViewportView(getPanel());
			scrollPane_3.setVisible(false);
		}
		return scrollPane_3;
	}
	private JLabel getLblNewLabel_1_5() {
		if (lblNewLabel_1_5 == null) {
			lblNewLabel_1_5 = new JLabel("Buscar por carrera y año:");
			lblNewLabel_1_5.setFont(new Font("Yu Gothic UI Semibold", Font.ITALIC, 16));
			lblNewLabel_1_5.setBounds(77, 11, 190, 33);
		}
		return lblNewLabel_1_5;
	}
	private JLabel getLblNewLabel_2() {
		if (lblNewLabel_2 == null) {
			lblNewLabel_2 = new JLabel("New label");
			lblNewLabel_2.setBounds(0, 0, 680, 464);
		}
		return lblNewLabel_2;
	}
	private JLabel getLblNewLabel_3() {
		if (lblNewLabel_3 == null) {
			lblNewLabel_3 = new JLabel("New label");
			lblNewLabel_3.setIcon(new ImageIcon(BusquedaAvanzada.class.getResource("/icons/Fondo de textura de acuarela amarilla brillante _ Vector Gratis.jpg")));
			lblNewLabel_3.setBounds(0, 0, 680, 464);
		}
		return lblNewLabel_3;
	}
	private JLabel getLblNewLabel_1_5_1() {
		if (lblNewLabel_1_5_1 == null) {
			lblNewLabel_1_5_1 = new JLabel("Carrera:");
			lblNewLabel_1_5_1.setFont(new Font("Yu Gothic UI Semibold", Font.ITALIC, 16));
			lblNewLabel_1_5_1.setBounds(10, 87, 70, 33);
		}
		return lblNewLabel_1_5_1;
	}
	private JComboBox getComboBox() {
		if (comboBox == null) {
			comboBox = new JComboBox();
			comboBox.setBounds(77, 87, 190, 38);
		}
		return comboBox;
	}
	private JLabel getLblNewLabel_1_5_1_1() {
		if (lblNewLabel_1_5_1_1 == null) {
			lblNewLabel_1_5_1_1 = new JLabel("Año:");
			lblNewLabel_1_5_1_1.setFont(new Font("Yu Gothic UI Semibold", Font.ITALIC, 16));
			lblNewLabel_1_5_1_1.setBounds(10, 200, 70, 33);
		}
		return lblNewLabel_1_5_1_1;
	}
	private JComboBox getComboBox_1() {
		if (comboBox_1 == null) {
			comboBox_1 = new JComboBox();
			comboBox_1.setBounds(77, 200, 190, 38);
		}
		return comboBox_1;
	}
}
