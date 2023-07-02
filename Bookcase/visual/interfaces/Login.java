package interfaces;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.ImageIcon;
import javax.swing.JTextField;
import javax.swing.JPasswordField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Component;
import javax.swing.border.LineBorder;
import java.awt.Color;
import javax.swing.border.SoftBevelBorder;

import logica.Validacion;

import javax.swing.border.BevelBorder;
import javax.swing.border.MatteBorder;
import java.awt.Toolkit;
import javax.swing.JSeparator;

public class Login extends JFrame {

	private JPanel contentPane;
	private JLabel lblLibrera;
	private JLabel lblImagenUsuario;
	private JTextField txNombreUsuario;
	private JPasswordField passwordField;
	private JLabel lbl;
	private JLabel lblNewLabel_1_1;
	private JButton btnCerrar;
	private JButton btnAcceder;
	private JSeparator separator;
	private JSeparator separator_1;
	private Validacion validaciones;
	private JLabel lblErrorUserPasword;
	private JLabel lblNewLabel_1;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Login frame = new Login();
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
	public Login() {
//		setIconImage(Toolkit.getDefaultToolkit().getImage(Login.class.getResource("/icons/icons8-book-50.png")));
		setUndecorated(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(0, 0, 314, 365);
		setLocationRelativeTo(null);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setTitle("Login");
		setIconImage(Toolkit.getDefaultToolkit().getImage(Principal.class.getResource("/icons/icons8-book-64 (2).png")));	
		setContentPane(contentPane);
		contentPane.setLayout(null);
		contentPane.add(getLblLibrera());
		contentPane.add(getLblImagenUsuario());
		contentPane.add(getTxNombreUsuario());
		contentPane.add(getPasswordField());
		contentPane.add(getLbl());
		contentPane.add(getLblNewLabel_1_1());
		contentPane.add(getBtnCerrar());
		contentPane.add(getBtnAcceder());
		contentPane.add(getSeparator());
		contentPane.add(getSeparator_1());
		contentPane.add(getLblErrorUserPasword());
		contentPane.add(getLblNewLabel_1());
		validaciones = new Validacion();
	}
	private JLabel getLblLibrera() {
		if (lblLibrera == null) {
			lblLibrera = new JLabel(" INICIAR SESIÓN");
			lblLibrera.setFont(new Font("Yu Gothic UI Semilight", Font.PLAIN, 33));
			lblLibrera.setBounds(43, 89, 279, 50);
		}
		return lblLibrera;
	}
	private JLabel getLblImagenUsuario() {
		if (lblImagenUsuario == null) {
			lblImagenUsuario = new JLabel("");
			lblImagenUsuario.setIcon(new ImageIcon(Login.class.getResource("/icons/icons8-login-64.png")));
			lblImagenUsuario.setBounds(129, 31, 64, 58);
		}
		return lblImagenUsuario;
	}
	private JTextField getTxNombreUsuario() {
		if (txNombreUsuario == null) {
			txNombreUsuario = new JTextField();
			txNombreUsuario.setAlignmentY(Component.BOTTOM_ALIGNMENT);
			txNombreUsuario.setBorder(new EmptyBorder(0, 0, 0, 0));
			txNombreUsuario.setOpaque(false);
			txNombreUsuario.setColumns(10);
			txNombreUsuario.setBounds(78, 160, 210, 29);
		}
		return txNombreUsuario;
	}
	private JPasswordField getPasswordField() {
		if (passwordField == null) {
			passwordField = new JPasswordField();
			passwordField.setOpaque(false);
			passwordField.setBorder(new EmptyBorder(0, 0, 0, 0));
			passwordField.setBounds(78, 215, 210, 20);
		}
		return passwordField;
	}
	private JLabel getLbl() {
		if (lbl == null) {
			lbl = new JLabel("");
			lbl.setIcon(new ImageIcon(Login.class.getResource("/icons/icons8-user-16.png")));
			lbl.setFont(new Font("Yu Gothic UI Semibold", Font.PLAIN, 12));
			lbl.setBounds(43, 160, 26, 39);
		}
		return lbl;
	}
	private JLabel getLblNewLabel_1_1() {
		if (lblNewLabel_1_1 == null) {
			lblNewLabel_1_1 = new JLabel("");
			lblNewLabel_1_1.setIcon(new ImageIcon(Login.class.getResource("/icons/icons8_hide_20px.png")));
			lblNewLabel_1_1.setFont(new Font("Yu Gothic UI Semibold", Font.PLAIN, 12));
			lblNewLabel_1_1.setBounds(43, 221, 25, 20);
		}
		return lblNewLabel_1_1;
	}
	private JButton getBtnCerrar() {
		if (btnCerrar == null) {
			btnCerrar = new JButton("");
			btnCerrar.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					dispose();
				}
			});
			btnCerrar.setIcon(new ImageIcon(Login.class.getResource("/icons/icons8-x-32 (1).png")));
			btnCerrar.setBounds(274, 6, 40, 29);
			btnCerrar.setToolTipText("Cerrar seccion");

			btnCerrar.setBorder(null);
			btnCerrar.setContentAreaFilled(false);
			btnCerrar.setFocusPainted(false);
			btnCerrar.setFocusTraversalKeysEnabled(false);
			btnCerrar.setFocusable(false);
		}
		return btnCerrar;
	}
	private JButton getBtnAcceder() {
		if (btnAcceder == null) {
			btnAcceder = new JButton("");
			btnAcceder.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					String usuario = txNombreUsuario.getText();
					String contrasena = passwordField.getText();
					boolean validoU = validaciones.isCorrectUsernamePasword(usuario,contrasena) ;
					if(validoU) {
						boolean isProfesor = validaciones.isProfesor(usuario);
						Principal p = new Principal();
						p.setVisible(true);
						if(isProfesor) {
							p.getBtnOpciones().setVisible(true);
							p.setTitle("Perfil del Profesor");
						}else {
							p.setTitle("Perfil del Estudiante");
						}
					}
					
				}
			});
				
			btnAcceder.setIcon(new ImageIcon(Login.class.getResource("/icons/icons8-login-50.png")));
			btnAcceder.setBorder(null);
			btnAcceder.setContentAreaFilled(false);

			btnAcceder.setOpaque(false);
			btnAcceder.setFont(new Font("Yu Gothic UI Semilight", Font.BOLD | Font.ITALIC, 14));
			btnAcceder.setBounds(89, 296, 138, 58);
		}
		return btnAcceder;
	}
	
	private JSeparator getSeparator() {
		if (separator == null) {
			separator = new JSeparator();
			separator.setForeground(new Color(0, 0, 0));
			separator.setBorder(null);
			separator.setBounds(78, 187, 200, 2);
		}
		return separator;
	}
	private JSeparator getSeparator_1() {
		if (separator_1 == null) {
			separator_1 = new JSeparator();
			separator_1.setForeground(new Color(0, 0, 0));
			separator_1.setBounds(78, 239, 200, 2);
		}
		return separator_1;
	}
	private JLabel getLblErrorUserPasword() {
		if (lblErrorUserPasword == null) {
			lblErrorUserPasword = new JLabel("Usuario o contraseña incorrecta");
			lblErrorUserPasword.setVisible(false);
			lblErrorUserPasword.setForeground(new Color(255, 0, 0));
			lblErrorUserPasword.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 13));
			lblErrorUserPasword.setBounds(53, 264, 221, 14);
		}
		return lblErrorUserPasword;
	}
	private JLabel getLblNewLabel_1() {
		if (lblNewLabel_1 == null) {
			lblNewLabel_1 = new JLabel("");
			lblNewLabel_1.setIcon(new ImageIcon(Login.class.getResource("/icons/Fondo de textura de acuarela amarilla brillante _ Vector Gratis.jpg")));
			lblNewLabel_1.setBounds(0, 0, 314, 365);
		}
		return lblNewLabel_1;
	}
}
//jjj