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
import javax.swing.border.BevelBorder;
import javax.swing.border.MatteBorder;
import java.awt.Toolkit;
import javax.swing.JSeparator;

public class Login extends JFrame {

	private JPanel contentPane;
	private JLabel lblLibrera;
	private JLabel lblNewLabel;
	private JTextField txNombreUsuario;
	private JPasswordField passwordField;
	private JLabel lblNewLabel_1;
	private JLabel lblNewLabel_1_1;
	private JButton btnCerrar;
	private JButton btnAcceder;
	private JSeparator separator;
	private JSeparator separator_1;
	private JLabel lbFondo;

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
		setIconImage(Toolkit.getDefaultToolkit().getImage(Login.class.getResource("/icons/icons8-book-50.png")));
		setUndecorated(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(0, 0, 314, 365);
		setLocationRelativeTo(null);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		contentPane.add(getLblLibrera());
		contentPane.add(getLblNewLabel());
		contentPane.add(getTxNombreUsuario());
		contentPane.add(getPasswordField());
		contentPane.add(getLblNewLabel_1());
		contentPane.add(getLblNewLabel_1_1());
		contentPane.add(getBtnCerrar());
		contentPane.add(getBtnAcceder());
		contentPane.add(getSeparator());
		contentPane.add(getSeparator_1());
		contentPane.add(getLblNewLabel_3_1());
	}
	private JLabel getLblLibrera() {
		if (lblLibrera == null) {
			lblLibrera = new JLabel(" INICIAR SESIÓN");
			lblLibrera.setFont(new Font("Yu Gothic UI Semilight", Font.BOLD | Font.ITALIC, 33));
			lblLibrera.setBounds(29, 46, 264, 50);
		}
		return lblLibrera;
	}
	private JLabel getLblNewLabel() {
		if (lblNewLabel == null) {
			lblNewLabel = new JLabel("");
			lblNewLabel.setIcon(new ImageIcon(Login.class.getResource("/icons/icons8-login-64.png")));
			lblNewLabel.setBounds(128, 91, 67, 58);
		}
		return lblNewLabel;
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
			passwordField.setBounds(78, 221, 210, 14);
		}
		return passwordField;
	}
	private JLabel getLblNewLabel_1() {
		if (lblNewLabel_1 == null) {
			lblNewLabel_1 = new JLabel("");
			lblNewLabel_1.setIcon(new ImageIcon(Login.class.getResource("/icons/icons8-user-16.png")));
			lblNewLabel_1.setFont(new Font("Yu Gothic UI Semibold", Font.PLAIN, 12));
			lblNewLabel_1.setBounds(42, 171, 25, 29);
		}
		return lblNewLabel_1;
	}
	private JLabel getLblNewLabel_1_1() {
		if (lblNewLabel_1_1 == null) {
			lblNewLabel_1_1 = new JLabel("");
			lblNewLabel_1_1.setIcon(new ImageIcon(Login.class.getResource("/icons/icons8-lock-16.png")));
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
					System.exit(0);
				}
			});
			btnCerrar.setIcon(new ImageIcon(Login.class.getResource("/icons/icons8-x-24.png")));
			btnCerrar.setBounds(274, 0, 51, 33);
			
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
			btnAcceder.setIcon(new ImageIcon(Login.class.getResource("/icons/icons8-login-50.png")));
			btnAcceder.setBorder(null);
			btnAcceder.setContentAreaFilled(false);

			btnAcceder.setOpaque(false);
			btnAcceder.setFont(new Font("Yu Gothic UI Semilight", Font.BOLD | Font.ITALIC, 14));
			btnAcceder.setBounds(88, 262, 138, 58);
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
	private JLabel getLblNewLabel_3_1() {
		if (lbFondo == null) {
			lbFondo = new JLabel("");
			lbFondo.setIcon(new ImageIcon(Login.class.getResource("/icons/2af7417d-4385-4ab9-b1af-15a9938358b3.jpg")));
			lbFondo.setBorder(new MatteBorder(1, 1, 1, 1, (Color) new Color(0, 0, 0)));
			lbFondo.setBounds(0, 0, 314, 365);
		}
		return lbFondo;
	}
}
//jjj