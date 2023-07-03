package interfaces;

//import javafx.scene.layout.Background;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.border.EmptyBorder;
import javax.swing.JTextArea;
import javax.swing.JTextPane;
import javax.swing.border.LineBorder;
import javax.swing.border.EtchedBorder;
import javax.swing.UIManager;

public class Principal extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 4588383233881937941L;
	private JPanel contentPane;
	private JPanel panel;
	private JButton btnEsconder;
	private JButton btnMostrar;
	private JButton btnCerrar;
	private JLabel lblCarreras;
	private JLabel lblBookcase;
	private JLabel lblFotoLibro;
	private JButton btnArq;
	private JButton btnCivil;
	private JButton btnInfo;
	private JButton btnElectrica;
	private JButton btnQuimica;
	private JButton BtnIndustrial;
	private JButton btnMec;
	private JButton btnBiomedica;
	private JButton btnAut;
	private JButton btnHidraulica;
	private JPanel panelAnnos;
	private JLabel lblAnnos;
	private JButton btnAnno1;
	private JButton btnAnno2;
	private JButton btnAnno3;
	private JButton btnAnno4;
	private JPanel panelAsignatura;
	private JLabel lblAsignatura;
	private JButton btnTele;
	private JLabel labelPanelMenu;
	private JButton btnMinimizar;
	private JButton btnOpciones;
	private JPanel paneLarriba;
	private JLabel lblPAnelArriba;
	private JScrollPane scrollPaneMenu;
	private JButton btnBusquedaAvanzada;
	private JLabel lblImagenRaton;
	private JLabel lblFondoRaton;
	private JLabel lblFondoMenuAnno;
	private JTextArea textArea;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Principal frame = new Principal();
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
	public Principal() {
		setUndecorated(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1053, 600);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setLocationRelativeTo(null);
		setIconImage(Toolkit.getDefaultToolkit()
				.getImage(Principal.class.getResource("/icons/icons8-book-64 (2).png")));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		contentPane.add(getPanel());
		contentPane.add(getBtnCerrar());
		contentPane.add(getBtnMostrar());
		contentPane.add(getLblBookcase());
		contentPane.add(getLblFotoLibro());
		contentPane.add(getPanelAnnos());
		contentPane.add(getPanelAsignatura());
		contentPane.add(getBtnMinimizar());
		contentPane.add(getBtnOpciones());
		contentPane.add(getPaneLarriba());

		contentPane.add(getBtnBusquedaAvanzada());
		contentPane.add(getLblImagenRaton());
		contentPane.add(getLblFondoRaton());
		contentPane.add(getTextArea());
		
	}

	private JPanel getPanel() {
		if (panel == null) {
			panel = new JPanel();
			panel.setBounds(0, 0, 213, 600);
			panel.setBackground(new Color(255, 255, 255));
			panel.setLayout(null);
			panel.add(getBtnEsconder());
			panel.add(getLblCarreras());
			panel.add(getBtnArq());
			panel.add(getBtnCivil());
			panel.add(getBtnInfo());
			panel.add(getBtnElectrica());
			panel.add(getBtnQuimica());
			panel.add(getBtnIndustrial());
			panel.add(getBtnMec());
			panel.add(getBtnBiomedica());
			panel.add(getBtnAut());
			panel.add(getBtnHidraulica());
			panel.add(getBtnTele());
			panel.add(getLabelPanelMenu());
			panel.add(getScrollPaneMenu());

			panel.setVisible(false);
		}
		return panel;
	}

	private JButton getBtnEsconder() {
		if (btnEsconder == null) {
			btnEsconder = new JButton("");
			btnEsconder.setBounds(0, 0, 43, 35);
			btnEsconder.setBorder(null);
			btnEsconder.setContentAreaFilled(false);
			btnEsconder.setFocusPainted(false);
			btnEsconder
					.setIcon(new ImageIcon(Principal.class.getResource("/icons/icons8-menu-24.png")));

			btnEsconder.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					lblBookcase.setVisible(true);
					lblFotoLibro.setVisible(true);
					lblImagenRaton.setVisible(true);
					lblFondoRaton.setVisible(true);
					int x = 213;
					int y = 600;
					btnMostrar.setVisible(true);
					btnEsconder.setVisible(false);
					if (x == 213) {

						Thread th = new Thread() {
							@Override
							public void run() {
								try {
									for (int i = 213; i >= 0; i--) {
										Thread.sleep(1);
										panel.setSize(i, 600);
									}
								} catch (Exception e) {
									JOptionPane.showMessageDialog(null, e);
								}
							}

						};
						th.start();
					}
				}
			});

			btnEsconder.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					panelAnnos.setVisible(false);

				}
			});

			btnEsconder.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					panelAsignatura.setVisible(false);

				}
			});
		}
		return btnEsconder;
	}

	private JButton getBtnMostrar() {
		if (btnMostrar == null) {
			btnMostrar = new JButton("");
			btnMostrar.setBounds(0, 0, 43, 35);
			btnMostrar.setBorder(null);
			btnMostrar.setContentAreaFilled(false);
			btnMostrar.setFocusPainted(false);
			btnMostrar.setIcon(new ImageIcon(Principal.class.getResource("/icons/icons8-menu-24.png")));	
			btnMostrar.addActionListener(new ActionListener() {

				public void actionPerformed(ActionEvent e) {
					lblBookcase.setVisible(false);
					lblFotoLibro.setVisible(false);
					lblImagenRaton.setVisible(false);
					lblFondoRaton.setVisible(false);
					int x = 213;
					int y = 600;

					btnEsconder.setVisible(true);
					btnMostrar.setVisible(false);
					if (x == 213) {
						panel.show();
						// panel.setSize(360,y);
						Thread th = new Thread() {
							@Override
							public void run() {
								int x = 213;
								try {
									for (int i = 0; i <= x; i++) {

										Thread.sleep(1);
										panel.setSize(i, 600);
									}
								} catch (Exception e) {
									JOptionPane.showMessageDialog(null, e);
								}
							}
						};
						th.start();
						x = 0;
					}
				}
			});
		}
		return btnMostrar;
	}

	private JButton getBtnCerrar() {
		if (btnCerrar == null) {
			btnCerrar = new JButton("");
			btnCerrar.setBounds(1013, 0, 40, 33);
			btnCerrar.setOpaque(false);
			btnCerrar.setBorder(null);
			btnCerrar.setContentAreaFilled(false);
			btnCerrar.setFocusPainted(false);
			btnCerrar.setToolTipText("Cerrar");
			btnCerrar.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					dispose();
				}
			});
			btnCerrar
					.setIcon(new ImageIcon(Principal.class.getResource("/icons/icons8-x-32 (1).png")));
		}
		return btnCerrar;
	}

	private JLabel getLblCarreras() {
		if (lblCarreras == null) {
			lblCarreras = new JLabel("Carreras");
			lblCarreras.setFont(new Font("Tahoma", Font.PLAIN, 20));
			lblCarreras.setBounds(63, 42, 87, 23);
		}
		return lblCarreras;
	}

	private JLabel getLblBookcase() {
		if (lblBookcase == null) {
			lblBookcase = new JLabel("Bookcase");
			lblBookcase.setBounds(123, 88, 224, 89);
			lblBookcase.setFont(new Font("Yu Gothic UI Semibold", Font.BOLD | Font.ITALIC, 45));
		}
		return lblBookcase;
	}

	private JLabel getLblFotoLibro() {
		if (lblFotoLibro == null) {
			lblFotoLibro = new JLabel("");
			lblFotoLibro.setBounds(357, 88, 77, 89);
			lblFotoLibro.setIcon(
					new ImageIcon(Principal.class.getResource("/icons/icons8-book-64 (2).png")));
		}
		return lblFotoLibro;
	}

	private JButton getBtnArq() {
		if (btnArq == null) {
			btnArq = new JButton("Arquitectura");

			btnArq.setBounds(21, 99, 164, 23);
			btnArq.setOpaque(false);
			btnArq.setBorder(null);
			btnArq.setContentAreaFilled(false);
			btnArq.setFocusPainted(false);
			btnArq.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					panelAnnos.setVisible(true);
				}
			});
		}
		return btnArq;
	}

	private JButton getBtnCivil() {
		if (btnCivil == null) {
			btnCivil = new JButton("Civil");
			btnCivil.setBounds(21, 222, 164, 23);
			btnCivil.setOpaque(false);
			btnCivil.setBorder(null);
			btnCivil.setContentAreaFilled(false);
			btnCivil.setFocusPainted(false);
		}
		return btnCivil;
	}

	private JButton getBtnInfo() {
		if (btnInfo == null) {
			btnInfo = new JButton("Informática");
			btnInfo.setBounds(21, 386, 164, 23);
			btnInfo.setOpaque(false);
			btnInfo.setBorder(null);
			btnInfo.setContentAreaFilled(false);
			btnInfo.setFocusPainted(false);
		}
		return btnInfo;
	}

	private JButton getBtnElectrica() {
		if (btnElectrica == null) {
			btnElectrica = new JButton("Eléctrica");
			btnElectrica.setBounds(21, 263, 164, 23);
			btnElectrica.setOpaque(false);
			btnElectrica.setBorder(null);
			btnElectrica.setContentAreaFilled(false);
			btnElectrica.setFocusPainted(false);
		}
		return btnElectrica;
	}

	private JButton getBtnQuimica() {
		if (btnQuimica == null) {
			btnQuimica = new JButton("Química");
			btnQuimica.setBounds(21, 468, 164, 23);
			btnQuimica.setOpaque(false);
			btnQuimica.setBorder(null);
			btnQuimica.setContentAreaFilled(false);
			btnQuimica.setFocusPainted(false);
		}
		return btnQuimica;
	}

	private JButton getBtnIndustrial() {
		if (BtnIndustrial == null) {
			BtnIndustrial = new JButton("Industrial");
			BtnIndustrial.setBounds(21, 345, 164, 23);
			BtnIndustrial.setOpaque(false);
			BtnIndustrial.setBorder(null);
			BtnIndustrial.setContentAreaFilled(false);
			BtnIndustrial.setFocusPainted(false);
		}
		return BtnIndustrial;
	}

	private JButton getBtnMec() {
		if (btnMec == null) {
			btnMec = new JButton("Mecánica");
			btnMec.setBounds(21, 427, 164, 23);
			btnMec.setOpaque(false);
			btnMec.setBorder(null);
			btnMec.setContentAreaFilled(false);
			btnMec.setFocusPainted(false);
		}
		return btnMec;
	}

	private JButton getBtnBiomedica() {
		if (btnBiomedica == null) {
			btnBiomedica = new JButton("Biomédica");
			btnBiomedica.setBounds(21, 181, 164, 23);
			btnBiomedica.setOpaque(false);
			btnBiomedica.setBorder(null);
			btnBiomedica.setContentAreaFilled(false);
			btnBiomedica.setFocusPainted(false);
		}
		return btnBiomedica;
	}

	private JButton getBtnAut() {
		if (btnAut == null) {
			btnAut = new JButton("Automática");
			btnAut.setBounds(21, 140, 164, 23);
			btnAut.setOpaque(false);
			btnAut.setBorder(null);
			btnAut.setContentAreaFilled(false);
			btnAut.setFocusPainted(false);
		}
		return btnAut;
	}

	private JButton getBtnHidraulica() {
		if (btnHidraulica == null) {
			btnHidraulica = new JButton("Hidráulica");
			btnHidraulica.setBounds(21, 304, 164, 23);
			btnHidraulica.setOpaque(false);
			btnHidraulica.setBorder(null);
			btnHidraulica.setContentAreaFilled(false);
			btnHidraulica.setFocusPainted(false);
			btnHidraulica.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
				}
			});
		}
		return btnHidraulica;
	}

	private JPanel getPanelAnnos() {
		if (panelAnnos == null) {
			panelAnnos = new JPanel();
			panelAnnos.setBounds(213, 0, 115, 600);
			panelAnnos.setBackground(new Color(255, 255, 255));
			panelAnnos.setLayout(null);
			panelAnnos.add(getLblAnnos());
			panelAnnos.add(getBtnAnno1());
			panelAnnos.add(getBtnAnno2());
			panelAnnos.add(getBtnAnno3());
			panelAnnos.add(getBtnAnno4());
			panelAnnos.add(getLblFondoMenuAnno());
			panelAnnos.setVisible(false);
		}
		return panelAnnos;
	}

	private JLabel getLblAnnos() {
		if (lblAnnos == null) {
			lblAnnos = new JLabel("Años");
			lblAnnos.setFont(new Font("Tahoma", Font.PLAIN, 20));

			lblAnnos.setBounds(27, 42, 57, 23);
		}
		return lblAnnos;
	}

	private JButton getBtnAnno1() {
		if (btnAnno1 == null) {
			btnAnno1 = new JButton("1");
			btnAnno1.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					panelAsignatura.setVisible(true);
				}
			});
			btnAnno1.setOpaque(false);
			btnAnno1.setBorder(null);
			btnAnno1.setContentAreaFilled(false);
			btnAnno1.setFocusPainted(false);
			btnAnno1.setIcon(null);
			btnAnno1.setBounds(10, 98, 89, 80);
		}
		return btnAnno1;
	}

	private JButton getBtnAnno2() {
		if (btnAnno2 == null) {
			btnAnno2 = new JButton("2");
			btnAnno2.setOpaque(false);
			btnAnno2.setBorder(null);
			btnAnno2.setContentAreaFilled(false);
			btnAnno2.setFocusPainted(false);
			btnAnno2.setBounds(10, 219, 89, 80);
			btnAnno2.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					panelAsignatura.setVisible(true);
				}
			});
		}
		return btnAnno2;
	}

	private JButton getBtnAnno3() {
		if (btnAnno3 == null) {
			btnAnno3 = new JButton("3");
			btnAnno3.setOpaque(false);
			btnAnno3.setBorder(null);
			btnAnno3.setContentAreaFilled(false);
			btnAnno3.setFocusPainted(false);
			btnAnno3.setBounds(10, 340, 89, 80);
			btnAnno3.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					panelAsignatura.setVisible(true);
				}
			});
		}
		return btnAnno3;
	}

	private JButton getBtnAnno4() {
		if (btnAnno4 == null) {
			btnAnno4 = new JButton("4");
			btnAnno4.setOpaque(false);
			btnAnno4.setBorder(null);
			btnAnno4.setContentAreaFilled(false);
			btnAnno4.setFocusPainted(false);
			btnAnno4.setBounds(10, 461, 89, 80);
			btnAnno4.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					panelAsignatura.setVisible(true);
				}
			});
		}
		return btnAnno4;
	}

	private JPanel getPanelAsignatura() {
		if (panelAsignatura == null) {
			panelAsignatura = new JPanel();
			panelAsignatura.setBounds(328, 0, 175, 600);
			panelAsignatura.setLayout(null);
			panelAsignatura.add(getLblAsignatura());

			panelAsignatura.setVisible(false);
		}
		return panelAsignatura;
	}

	private JLabel getLblAsignatura() {
		if (lblAsignatura == null) {
			lblAsignatura = new JLabel("Asignatura");
			lblAsignatura.setBounds(34, 42, 131, 25);
			lblAsignatura.setFont(new Font("Tahoma", Font.PLAIN, 20));
		}
		return lblAsignatura;
	}

	private JButton getBtnTele() {
		if (btnTele == null) {
			btnTele = new JButton("Telecomunicaciones");
			btnTele.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
				}
			});
			btnTele.setBounds(21, 509, 164, 23);
			btnTele.setOpaque(false);
			btnTele.setBorder(null);
			btnTele.setContentAreaFilled(false);
			btnTele.setFocusPainted(false);
		}
		return btnTele;
	}

	private JLabel getLabelPanelMenu() {
		if (labelPanelMenu == null) {
			labelPanelMenu = new JLabel("");
			labelPanelMenu.setIcon(new ImageIcon(Principal.class.getResource("/icons/Fondo de textura de acuarela amarilla brillante _ Vector Gratis.jpg")));
			labelPanelMenu.setBounds(0, 0, 213, 600);
		}
		return labelPanelMenu;
	}

	private JButton getBtnMinimizar() {
		if (btnMinimizar == null) {
			btnMinimizar = new JButton("");
			btnMinimizar.setBounds(968, 0, 40, 33);
			btnMinimizar.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
				}
			});
			btnMinimizar.addMouseListener(new MouseAdapter() {
				@Override
				public void mouseClicked(MouseEvent e) {
//					setExtendedState(contentP);
					setExtendedState(JFrame.CROSSHAIR_CURSOR);

				}
			});
			btnMinimizar.setIcon(
					new ImageIcon(Principal.class.getResource("/icons/icons8_subtract_32px.png")));
			btnMinimizar.setOpaque(false);
			btnMinimizar.setFocusPainted(false);
			btnMinimizar.setContentAreaFilled(false);
			btnMinimizar.setBorder(null);
			btnMinimizar.setToolTipText("Minimizar");

		}
		return btnMinimizar;
	}

	public JButton getBtnOpciones() {
		if (btnOpciones == null) {
			btnOpciones = new JButton("");
			btnOpciones.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					Formulario f = new Formulario();
					f.setVisible(true);
				}
			});
			btnOpciones.setVisible(false);
			btnOpciones.setBounds(991, 489, 56, 50);
			btnOpciones.setIcon(
					new ImageIcon(Principal.class.getResource("/icons/icons8-setting-48.png")));
						
			btnOpciones.setToolTipText("Opciones");
			btnOpciones.setOpaque(false);
			btnOpciones.setFont(new Font("Tahoma", Font.PLAIN, 18));
			btnOpciones.setFocusPainted(false);
			btnOpciones.setContentAreaFilled(false);
			btnOpciones.setBorder(null);
		}
		return btnOpciones;
	}

	private JPanel getPaneLarriba() {
		if (paneLarriba == null) {
			paneLarriba = new JPanel();
			paneLarriba.setBounds(0, 0, 1053, 38);
			paneLarriba.setBackground(new Color(240, 240, 240));
			paneLarriba.setLayout(null);
			paneLarriba.add(getLblPAnelArriba());
		}
		return paneLarriba;
	}

	private JLabel getLblPAnelArriba() {
		if (lblPAnelArriba == null) {
			lblPAnelArriba = new JLabel("");
			lblPAnelArriba.setIcon(new ImageIcon(Principal.class.getResource("/icons/Fondo de textura de acuarela amarilla brillante _ Vector Gratis - copia.jpg")));
			lblPAnelArriba.setBounds(0, 0, 1053, 38);
		}
		return lblPAnelArriba;
	}
	private JScrollPane getScrollPaneMenu() {
		if (scrollPaneMenu == null) {
			scrollPaneMenu = new JScrollPane();
			scrollPaneMenu.setBounds(0, 0, 213, 600);
		}
		return scrollPaneMenu;
	}
	private JButton getBtnBusquedaAvanzada() {
		if (btnBusquedaAvanzada == null) {
			btnBusquedaAvanzada = new JButton("");
			btnBusquedaAvanzada.setToolTipText("Búsqueda Avanzadas");
			btnBusquedaAvanzada.setIcon(new ImageIcon(Principal.class.getResource("/icons/icons8_slider_45px_1.png")));
			btnBusquedaAvanzada.setBounds(991, 550, 56, 50);
			btnBusquedaAvanzada.setOpaque(false);
			btnBusquedaAvanzada.setFocusPainted(false);
			btnBusquedaAvanzada.setContentAreaFilled(false);
			btnBusquedaAvanzada.setBorder(null);
		}
		return btnBusquedaAvanzada;
	}
	private JLabel getLblImagenRaton() {
		if (lblImagenRaton == null) {
			lblImagenRaton = new JLabel("");
			lblImagenRaton.setIcon(new ImageIcon(Principal.class.getResource("/icons/ratonCHico.png")));
			lblImagenRaton.setBounds(705, 140, 213, 338);
		}
		return lblImagenRaton;
	}
	private JLabel getLblFondoRaton() {
		if (lblFondoRaton == null) {
			lblFondoRaton = new JLabel("");
			lblFondoRaton.setIcon(new ImageIcon(Principal.class.getResource("/icons/FondoPrincipal.png")));
			lblFondoRaton.setBounds(0, 34, 1053, 566);
		}
		return lblFondoRaton;
	}
	private JLabel getLblFondoMenuAnno() {
		if (lblFondoMenuAnno == null) {
			lblFondoMenuAnno = new JLabel("");
			lblFondoMenuAnno.setBounds(0, 0, 115, 600);
		}
		return lblFondoMenuAnno;
	}
	private JTextArea getTextArea() {
		if (textArea == null) {
			textArea = new JTextArea();
			textArea.setBounds(223, 88, 144, 128);
		}
		return textArea;
	}
}
