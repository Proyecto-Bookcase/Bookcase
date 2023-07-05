package interfaces;

import java.awt.Color;
import java.awt.Component;
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
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JSeparator;
import javax.swing.JTextField;
import javax.swing.WindowConstants;
import javax.swing.border.EmptyBorder;

import logica.Validacion;

public class Login extends JFrame {

	private JPanel contentPane;
	private JLabel lblIniciarSesion;
	private JLabel lblImagenUsuario;
	private JTextField txNombreUsuario;
	private JPasswordField passwordField;
	private JLabel lblIconUSuarioNombre;
	private JLabel lblLogoCOntrasennaOculta;
	private JButton btnCerrar;
	private JButton btnAcceder;
	private JSeparator separator;
	private JSeparator separator_1;
	private Validacion validaciones;
	private JLabel lblErrorUserPasword;
	private JLabel lblLogoContrasennaVer;
	private JLabel lblFondo;

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
		setUndecorated(true);
		setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
		setBounds(0, 0, 314, 365);
		setLocationRelativeTo(null);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setTitle("Login");
		setIconImage(Toolkit.getDefaultToolkit().getImage(Principal.class.getResource("/icons/icons8-book-64 (2).png")));	
		setContentPane(contentPane);
		contentPane.setLayout(null);
		contentPane.add(getLblIniciarSesion());
		contentPane.add(getLblImagenUsuario());
		contentPane.add(getTxNombreUsuario());
		contentPane.add(getPasswordField());
		contentPane.add(getLblIconUSuarioNombre());
		contentPane.add(getLblLogoCOntrasennaOculta());
		contentPane.add(getBtnCerrar());
		contentPane.add(getBtnAcceder());
		contentPane.add(getSeparator());
		contentPane.add(getSeparator_1());
		contentPane.add(getLblErrorUserPasword());
		contentPane.add(getLabel_1());
		contentPane.add(getLblFondo_1());
		validaciones = new Validacion();
	}
	private JLabel getLblIniciarSesion() {
		if (lblIniciarSesion == null) {
			lblIniciarSesion = new JLabel(" INICIAR SESIÓN");
			lblIniciarSesion.setFont(new Font("Yu Gothic UI Semilight", Font.PLAIN, 33));
			lblIniciarSesion.setBounds(43, 100, 245, 50);
		}
		return lblIniciarSesion;
	}
	private JLabel getLblImagenUsuario() {
		if (lblImagenUsuario == null) {
			lblImagenUsuario = new JLabel("");
			lblImagenUsuario.setIcon(new ImageIcon(Login.class.getResource("/icons/icons8-login-64.png")));
			lblImagenUsuario.setBounds(123, 31, 79, 58);
		}
		return lblImagenUsuario;
	}
	private JTextField getTxNombreUsuario() {
		if (txNombreUsuario == null) {
			txNombreUsuario = new JTextField();
			txNombreUsuario.setFont(new Font("Tahoma", Font.PLAIN, 12));
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
			passwordField.setFont(new Font("Tahoma", Font.PLAIN, 12));
			passwordField.setOpaque(false);
			passwordField.setBorder(new EmptyBorder(0, 0, 0, 0));
			passwordField.setBounds(78, 215, 210, 20);
		}
		return passwordField;
	}
	private JLabel getLblIconUSuarioNombre() {
		if (lblIconUSuarioNombre == null) {
			lblIconUSuarioNombre = new JLabel("");
			lblIconUSuarioNombre.setIcon(new ImageIcon(Login.class.getResource("/icons/icons8-user-16.png")));
			lblIconUSuarioNombre.setFont(new Font("Yu Gothic UI Semibold", Font.PLAIN, 12));
			lblIconUSuarioNombre.setBounds(43, 160, 26, 39);
		}
		return lblIconUSuarioNombre;
	}
	private JLabel getLblLogoCOntrasennaOculta() {
		if (lblLogoCOntrasennaOculta == null) {
			lblLogoCOntrasennaOculta = new JLabel("");
			lblLogoCOntrasennaOculta.addMouseListener(new MouseAdapter() {
				@Override
				public void mouseClicked(MouseEvent e) {
					lblLogoContrasennaVer.setVisible(true);
					lblLogoCOntrasennaOculta.setVisible(false);
					passwordField.setEchoChar((char)0);
				
				}
			});
			
			lblLogoCOntrasennaOculta.setIcon(new ImageIcon(Login.class.getResource("/icons/icons8_hide_20px.png")));
			lblLogoCOntrasennaOculta.setFont(new Font("Yu Gothic UI Semibold", Font.PLAIN, 12));
			lblLogoCOntrasennaOculta.setBounds(43, 221, 25, 20);
		}
		return lblLogoCOntrasennaOculta;
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
					boolean validoUser = validaciones.isCorrectUsername(usuario) ;
					boolean validoPasword = validaciones.isCorrectPasword(usuario, contrasena);
					if(validoUser && validoPasword) {
						lblErrorUserPasword.setVisible(false);
						boolean isProfesor = validaciones.isProfesor(usuario);
						Principal p = new Principal();
						p.setVisible(true);
						if(isProfesor) {
							p.getBtnOpciones().setVisible(true);
							p.setTitle("Perfil del Profesor");
						}else {
							p.setTitle("Perfil del Estudiante");
						}
						dispose();	
					}else {
						lblErrorUserPasword.setVisible(true);
						txNombreUsuario.setText(null);
						passwordField.setText(null);
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
	private JLabel getLabel_1() {
		if (lblLogoContrasennaVer == null) {
			lblLogoContrasennaVer = new JLabel("");
			lblLogoContrasennaVer.addMouseListener(new MouseAdapter() {
				@Override
				public void mouseClicked(MouseEvent e) {
					passwordField.setEchoChar('●');
					lblLogoCOntrasennaOculta.setVisible(true);
					lblLogoContrasennaVer.setVisible(false);
				}
			});
			lblLogoContrasennaVer.setVisible(false);
			lblLogoContrasennaVer.setIcon(new ImageIcon(Login.class.getResource("/icons/icons8_eye_20px.png")));
			lblLogoContrasennaVer.setBounds(43, 221, 25, 20);
		}
		return lblLogoContrasennaVer;
	}
	private JLabel getLblFondo_1() {
		if (lblFondo == null) {
			lblFondo = new JLabel("");
			lblFondo.setIcon(new ImageIcon(Login.class.getResource("/icons/Fondo de textura de acuarela amarilla brillante _ Vector Gratis.jpg")));
			lblFondo.setBounds(0, 0, 314, 365);
		}
		return lblFondo;
	}
}
//jjj