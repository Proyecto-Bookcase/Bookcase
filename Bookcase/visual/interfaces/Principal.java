package interfaces;

import static org.hamcrest.CoreMatchers.instanceOf;

import java.awt.CardLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.List;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollBar;
import javax.swing.JScrollPane;
import javax.swing.SwingConstants;
import javax.swing.WindowConstants;
import javax.swing.border.Border;
import javax.swing.border.CompoundBorder;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;

import com.jgoodies.forms.layout.ColumnSpec;
import com.jgoodies.forms.layout.FormLayout;
import com.jgoodies.forms.layout.FormSpecs;
import com.jgoodies.forms.layout.RowSpec;

import classes.Bookcase;
import classes.Carreer;
import classes.Subject;
import classes.Year;
import cu.edu.cujae.ceis.tree.binary.BinaryTreeNode;
import cu.edu.cujae.ceis.tree.general.GeneralTree;
import custom_components.Auxiliary;
import external_memory.Manager;

public class Principal extends JFrame {
	
	public static ActionListener update = null;

	private static final long serialVersionUID = 4588383233881937941L;
	private final String SPECS_ROW_CARREER = "max(28dlu;default)";
	private final String SPECS_ROW_YEAR = "max(36dlu;default)";
	private final String SPECS_ROW_SUBJECT = "max(36dlu;default)";
	private JPanel contentPane;
	private JPanel panel;
	private JButton btnMostrar;
	private JButton btnCerrar;
	private JLabel lblCarreras;
	private JLabel lblBookcase;
	private JLabel lblFotoLibro;
	private JPanel panelAnnos;
	private JLabel lblAnnos;
	private JPanel panelAsignatura;
	private JLabel lblAsignatura;
	private JLabel labelPanelMenu;
	private JButton btnMinimizar;
	private JButton btnOpciones;
	private JPanel paneLarriba;
	private JLabel lblPAnelArriba;
	private JButton btnBusquedaAvanzada;
	private JLabel lblImagenRaton;
	private JLabel lblFondoRaton;
	private JPanel panelCarreers;
	private JScrollPane scrollPane;
	private static Bookcase instance;
	private GeneralTree<NodeInfo> tree;
	private JPanel panelYears;
	private CardLayout yearsLayout;
	private JPanel subjectPanel;
	private JScrollPane scrollPane_1;
	private CardLayout subjectLayout;
	private boolean showned = false;

	/**
	 * Create the frame.
	 */
	public Principal() {
		
		update = new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				
				System.out.println(this.getClass().getSimpleName());
				
				actualizarFiltrado();
				
			}
		};
		
		instance = Bookcase.getInstance();
		tree = instance.getTree();
		setUndecorated(true);
		setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
		setBounds(100, 100, 1053, 600);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setLocationRelativeTo(null);
		setIconImage(
				Toolkit.getDefaultToolkit().getImage(Principal.class.getResource("/icons/icons8-book-64 (2).png")));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		contentPane.add(getBtnMinimizar());
		contentPane.add(getBtnMostrar());
		contentPane.add(getBtnCerrar());
		contentPane.add(getPaneLarriba());
		contentPane.add(getPanelAsignatura());
		contentPane.add(getPanel());
		contentPane.add(getLblFotoLibro());
		contentPane.add(getPanelAnnos());
		contentPane.add(getBtnOpciones());

		contentPane.add(getBtnBusquedaAvanzada());
		contentPane.add(getLblImagenRaton());
		contentPane.add(getLblBookcase());
		contentPane.add(getLblFondoRaton());

		Auxiliary.dragEffect(this, lblPAnelArriba);

		insertCarreers();

	}

	public void actualizarFiltrado() {

		panelCarreers.removeAll();
		FormLayout fl_panelCarreers = new FormLayout();
		fl_panelCarreers.appendColumn(FormSpecs.RELATED_GAP_COLSPEC);
		fl_panelCarreers.appendColumn(FormSpecs.DEFAULT_COLSPEC);
		fl_panelCarreers.appendColumn(FormSpecs.RELATED_GAP_COLSPEC);
		fl_panelCarreers.appendColumn(ColumnSpec.decode("max(101dlu;default)"));
		panelCarreers.setLayout(fl_panelCarreers);
		
		
		
		panelYears.removeAll();
	
		
		panelAsignatura.removeAll();
		
		insertCarreers();
	}

	private void insertCarreers() {

		List<BinaryTreeNode<NodeInfo>> carreers = tree.getSons((BinaryTreeNode<NodeInfo>) tree.getRoot());
		for (BinaryTreeNode<NodeInfo> binaryTreeNode : carreers) {
			insertCarreerComponent(binaryTreeNode);
		}

	}

	private void insertCarreerComponent(BinaryTreeNode<NodeInfo> node) {

		Carreer info = (Carreer) node.getInfo();
		FormLayout layout = (FormLayout) getPanelCarreers().getLayout();
		layout.appendRow(FormSpecs.RELATED_GAP_ROWSPEC);
		layout.appendRow(RowSpec.decode(SPECS_ROW_CARREER));
		JLabel label = new JLabel(info.getName());
		label.setBorder(new LineBorder(new Color(0, 0, 0)));
		label.setHorizontalAlignment(SwingConstants.CENTER);
		label.setFont(new Font(Font.SANS_SERIF, Font.PLAIN, 16));
		int count = layout.getRowCount();
		panelCarreers.add(label, "4, " + count);
		insertYearPanel(node);
		label.addMouseListener(new MouseAdapter() {

			@Override
			public void mouseClicked(MouseEvent e) {
				yearsLayout.show(panelYears, info.getId());
				panelAnnos.setVisible(true);
				panelAsignatura.setVisible(false);
			}
		});
	}

	private void insertYearPanel(BinaryTreeNode<NodeInfo> carreer) {
		Carreer info = (Carreer) carreer.getInfo();
		JPanel panel = new JPanel();
		FormLayout layout = new FormLayout(new ColumnSpec[] { FormSpecs.RELATED_GAP_COLSPEC,
				ColumnSpec.decode("max(4dlu;default)"), FormSpecs.RELATED_GAP_COLSPEC, ColumnSpec.decode("40dlu"), },
				new RowSpec[] {});
		panel.setLayout(layout);
		for (BinaryTreeNode<NodeInfo> year : tree.getSons(carreer)) {
			insertYearComponent(year, panel);
		}
		panelYears.add(panel, info.getId());
	}

	private void insertYearComponent(BinaryTreeNode<NodeInfo> year, JPanel panel) {

		Year info = (Year) year.getInfo();
		FormLayout layout = (FormLayout) panel.getLayout();
		layout.appendRow(FormSpecs.RELATED_GAP_ROWSPEC);
		layout.appendRow(RowSpec.decode(SPECS_ROW_YEAR));
		JLabel label = new JLabel(info.getNumberYear() + "");
		label.setBorder(new LineBorder(new Color(0, 0, 0)));
		label.setHorizontalAlignment(SwingConstants.CENTER);
		label.setFont(new Font(Font.SANS_SERIF, Font.PLAIN, 16));
		int count = layout.getRowCount();
		panel.add(label, "4, " + count);
		insertSubjectPanel(year);
		label.addMouseListener(new MouseAdapter() {

			@Override
			public void mouseClicked(MouseEvent e) {
				subjectLayout.show(subjectPanel, info.getId());
				panelAsignatura.setVisible(true);
			}
		});

	}

	private void insertSubjectPanel(BinaryTreeNode<NodeInfo> year) {
		Year info = (Year) year.getInfo();
		JPanel panel = new JPanel();
		FormLayout layout = new FormLayout(
				new ColumnSpec[] { FormSpecs.RELATED_GAP_COLSPEC, ColumnSpec.decode("max(1dlu;default)"),
						FormSpecs.RELATED_GAP_COLSPEC, ColumnSpec.decode("max(80dlu;default)"), },
				new RowSpec[] {});
		panel.setLayout(layout);
		for (BinaryTreeNode<NodeInfo> subject : tree.getSons(year)) {
			insertSubjectComponent(subject, panel);
		}
		subjectPanel.add(panel, info.getId());

	}

	private void insertSubjectComponent(BinaryTreeNode<NodeInfo> subject, JPanel panel) {

		Subject info = (Subject) subject.getInfo();
		FormLayout layout = (FormLayout) panel.getLayout();
		layout.appendRow(FormSpecs.RELATED_GAP_ROWSPEC);
		layout.appendRow(RowSpec.decode(SPECS_ROW_SUBJECT));
		JLabel label = new JLabel(info.getName());
		label.setBorder(new LineBorder(new Color(0, 0, 0)));
		label.setHorizontalAlignment(SwingConstants.CENTER);
		label.setFont(new Font(Font.SANS_SERIF, Font.PLAIN, 16));
		int count = layout.getRowCount();
		panel.add(label, "4, " + count);
		label.addMouseListener(new MouseAdapter() {

			@Override
			public void mouseClicked(MouseEvent e) {
				btnMostrar.doClick();
			}
		});

	}

	private JPanel getPanel() {
		if (panel == null) {
			panel = new JPanel();
			panel.setBounds(0, 0, 213, 600);
			panel.setBackground(new Color(255, 255, 255));
			panel.setLayout(null);
			panel.add(getScrollPane_1());
			panel.add(getLblCarreras());
			panel.add(getLabelPanelMenu());

			panel.setVisible(false);
		}
		return panel;
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
					
					panelCarreers.updateUI();
					if (!showned) {
						showned = true;
						int x = 213;
						int y = 600;
						if (x == 213) {
							panel.show();
							Thread th = new Thread() {
								@Override
								public void run() {
									int x = 213;
									try {
										for (int i = 0; i <= x; i += 2) {

											Thread.sleep(1);
											panel.setSize(i, 600);
										}
									} catch (Exception e) {
										e.printStackTrace();
									}
								}
							};
							th.start();
							x = 0;
						}
					} else {
						showned = false;
						panelAnnos.setVisible(false);
						panelAsignatura.setVisible(false);
						int x = 213;
						int y = 600;
						if (x == 213) {

							Thread th = new Thread() {
								@Override
								public void run() {
									try {
										for (int i = 213; i >= 0; i -= 2) {
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
					Manager.guardarDatos();
					dispose();
				}
			});
			btnCerrar.setIcon(new ImageIcon(Principal.class.getResource("/icons/icons8-x-32 (1).png")));
		}
		return btnCerrar;
	}

	private JLabel getLblCarreras() {
		if (lblCarreras == null) {
			lblCarreras = new JLabel("Carreras");
			lblCarreras.setHorizontalAlignment(SwingConstants.CENTER);
			lblCarreras.setFont(new Font("Tahoma", Font.PLAIN, 20));
			lblCarreras.setBounds(62, 53, 87, 23);
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
			lblFotoLibro.setIcon(new ImageIcon(Principal.class.getResource("/icons/icons8-book-64 (2).png")));
		}
		return lblFotoLibro;
	}

	private JPanel getPanelAnnos() {
		if (panelAnnos == null) {
			panelAnnos = new JPanel();
			panelAnnos.setBounds(212, 0, 115, 600);
			panelAnnos.setBackground(new Color(192, 192, 192));
			panelAnnos.setLayout(null);
			panelAnnos.add(getLblAnnos());
			panelAnnos.add(getPanelYears());
			panelAnnos.setVisible(false);
		}
		return panelAnnos;
	}

	private JLabel getLblAnnos() {
		if (lblAnnos == null) {
			lblAnnos = new JLabel("Años");
			lblAnnos.setHorizontalAlignment(SwingConstants.CENTER);
			lblAnnos.setFont(new Font("Tahoma", Font.PLAIN, 20));

			lblAnnos.setBounds(24, 55, 57, 23);
		}
		return lblAnnos;
	}

	private JPanel getPanelAsignatura() {
		if (panelAsignatura == null) {
			panelAsignatura = new JPanel();
			panelAsignatura.setBackground(new Color(128, 128, 128));
			panelAsignatura.setBounds(327, 0, 224, 600);
			panelAsignatura.setLayout(null);
			panelAsignatura.add(getLblAsignatura());
			panelAsignatura.add(getScrollPane_1_1());

			panelAsignatura.setVisible(false);
		}
		return panelAsignatura;
	}

	private JLabel getLblAsignatura() {
		if (lblAsignatura == null) {
			lblAsignatura = new JLabel("Asignatura");
			lblAsignatura.setHorizontalAlignment(SwingConstants.CENTER);
			lblAsignatura.setBounds(34, 53, 131, 25);
			lblAsignatura.setFont(new Font("Tahoma", Font.PLAIN, 20));
		}
		return lblAsignatura;
	}

	private JLabel getLabelPanelMenu() {
		if (labelPanelMenu == null) {
			labelPanelMenu = new JLabel("");
			labelPanelMenu.setIcon(new ImageIcon(Principal.class
					.getResource("/icons/Fondo de textura de acuarela amarilla brillante _ Vector Gratis.jpg")));
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
					setExtendedState(JFrame.CROSSHAIR_CURSOR);
				}
			});
			btnMinimizar.setIcon(new ImageIcon(Principal.class.getResource("/icons/icons8_subtract_32px.png")));
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
					Formulario f = new Formulario(Principal.this);
					f.setVisible(true);
				}
			});
			btnOpciones.setVisible(false);
			btnOpciones.setBounds(991, 489, 56, 50);
			btnOpciones.setIcon(new ImageIcon(Principal.class.getResource("/icons/icons8-setting-48.png")));

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
			lblPAnelArriba.setIcon(new ImageIcon(Principal.class.getResource(
					"/icons/Fondo de textura de acuarela amarilla brillante _ Vector Gratis - copia.jpg")));
			lblPAnelArriba.setBounds(0, 0, 1053, 38);
		}
		return lblPAnelArriba;
	}

	private JButton getBtnBusquedaAvanzada() {
		if (btnBusquedaAvanzada == null) {
			btnBusquedaAvanzada = new JButton("");
			btnBusquedaAvanzada.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					BusquedaAvanzada ba = new BusquedaAvanzada();
					ba.setVisible(true);
				}
			});
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
			lblImagenRaton.setBounds(795, 163, 213, 338);
		}
		return lblImagenRaton;
	}

	private JLabel getLblFondoRaton() {
		if (lblFondoRaton == null) {
			lblFondoRaton = new JLabel("");
			lblFondoRaton.setIcon(new ImageIcon(Principal.class.getResource("/icons/FondoPrincipal.png")));
			lblFondoRaton.setBounds(0, 0, 1134, 705);
		}
		return lblFondoRaton;
	}

	private JPanel getPanelCarreers() {
		if (panelCarreers == null) {
			panelCarreers = new JPanel();
			panelCarreers.setBorder(null);
			panelCarreers.setOpaque(false);
			FormLayout fl_panelCarreers = new FormLayout();
			fl_panelCarreers.appendColumn(FormSpecs.RELATED_GAP_COLSPEC);
			fl_panelCarreers.appendColumn(FormSpecs.DEFAULT_COLSPEC);
			fl_panelCarreers.appendColumn(FormSpecs.RELATED_GAP_COLSPEC);
			fl_panelCarreers.appendColumn(ColumnSpec.decode("max(101dlu;default)"));
			panelCarreers.setLayout(fl_panelCarreers);
		}
		return panelCarreers;
	}

	private JScrollPane getScrollPane_1() {
		if (scrollPane == null) {
			scrollPane = new JScrollPane();
			scrollPane.setBorder(null);
			scrollPane.setOpaque(false);
			scrollPane.setBounds(0, 102, 213, 498);
			scrollPane.setViewportView(getPanelCarreers());
			scrollPane.getViewport().setOpaque(false);
			JScrollBar scrollBar = scrollPane.getVerticalScrollBar();
			scrollBar.setPreferredSize(new Dimension(20, 0));
			Border margin = new EmptyBorder(4, 4, 4, 4); // crear un margen vacío
			Border compound = new CompoundBorder(null, margin);
			scrollBar.setBorder(compound);
			scrollBar.setOpaque(false);
			scrollBar.setUI(new ScrollBarWithoutArrows());

		}
		return scrollPane;
	}

	private JPanel getPanelYears() {
		if (panelYears == null) {
			panelYears = new JPanel();
			panelYears.setBorder(new LineBorder(new Color(192, 192, 192)));
			panelYears.setBackground(new Color(192, 192, 192));
			panelYears.setBounds(0, 103, 115, 497);
			yearsLayout = new CardLayout(0, 0);
			panelYears.setLayout(yearsLayout);
		}
		return panelYears;
	}

	private JPanel getSubjectPanel() {
		if (subjectPanel == null) {
			subjectPanel = new JPanel();
			subjectPanel.setBorder(new LineBorder(new Color(128, 128, 128)));
			subjectLayout = new CardLayout(0, 0);
			subjectPanel.setLayout(subjectLayout);
		}
		return subjectPanel;
	}

	private JScrollPane getScrollPane_1_1() {
		if (scrollPane_1 == null) {
			scrollPane_1 = new JScrollPane();
			scrollPane_1.setBorder(null);
			scrollPane_1.setBounds(0, 103, 224, 497);
			scrollPane_1.setViewportView(getSubjectPanel());
		}
		return scrollPane_1;
	}
}
