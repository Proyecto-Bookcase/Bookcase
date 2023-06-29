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

public class Login extends JFrame {

	private static final long serialVersionUID = -8967207235087266361L;
	private JPanel contentPane;
	private JLabel lblLibrera;
	private JLabel lblNewLabel;
	private JTextField textField;
	private JPasswordField passwordField;
	private JLabel lblNewLabel_1;
	private JLabel lblNewLabel_1_1;
	private JLabel lblNewLabel_5;
	private JLabel lblNewLabel_3;

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
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 440, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		contentPane.add(getLblLibrera());
		contentPane.add(getLblNewLabel());
		contentPane.add(getTextField());
		contentPane.add(getPasswordField());
		contentPane.add(getLblNewLabel_1());
		contentPane.add(getLblNewLabel_1_1());
		contentPane.add(getLblNewLabel_5());
		contentPane.add(getLblNewLabel_3());
	}
	private JLabel getLblLibrera() {
		if (lblLibrera == null) {
			lblLibrera = new JLabel("INICIAR SESIÓN");
			lblLibrera.setFont(new Font("Yu Gothic UI", Font.BOLD, 33));
			lblLibrera.setBounds(77, 11, 283, 50);
		}
		return lblLibrera;
	}
	private JLabel getLblNewLabel() {
		if (lblNewLabel == null) {
			lblNewLabel = new JLabel("");
			lblNewLabel.setIcon(new ImageIcon(Login.class.getResource("/icons/icons8-book-64.png")));
			lblNewLabel.setBounds(174, 60, 67, 65);
		}
		return lblNewLabel;
	}
	private JTextField getTextField() {
		if (textField == null) {
			textField = new JTextField();
			textField.setColumns(10);
			textField.setBounds(146, 136, 118, 20);
		}
		return textField;
	}
	private JPasswordField getPasswordField() {
		if (passwordField == null) {
			passwordField = new JPasswordField();
			passwordField.setBounds(146, 184, 118, 20);
		}
		return passwordField;
	}
	private JLabel getLblNewLabel_1() {
		if (lblNewLabel_1 == null) {
			lblNewLabel_1 = new JLabel("");
			lblNewLabel_1.setIcon(new ImageIcon(Login.class.getResource("/icons/icons8-user-16.png")));
			lblNewLabel_1.setFont(new Font("Yu Gothic UI Semibold", Font.PLAIN, 12));
			lblNewLabel_1.setBounds(122, 136, 25, 20);
		}
		return lblNewLabel_1;
	}
	private JLabel getLblNewLabel_1_1() {
		if (lblNewLabel_1_1 == null) {
			lblNewLabel_1_1 = new JLabel("");
			lblNewLabel_1_1.setIcon(new ImageIcon(Login.class.getResource("/icons/icons8-lock-16.png")));
			lblNewLabel_1_1.setFont(new Font("Yu Gothic UI Semibold", Font.PLAIN, 12));
			lblNewLabel_1_1.setBounds(122, 184, 25, 20);
		}
		return lblNewLabel_1_1;
	}
	private JLabel getLblNewLabel_5() {
		if (lblNewLabel_5 == null) {
			lblNewLabel_5 = new JLabel("");
			lblNewLabel_5.setIcon(new ImageIcon(Login.class.getResource("/icons/icons8-login-24 (1).png")));
			lblNewLabel_5.setBounds(392, 224, 32, 26);
		}
		return lblNewLabel_5;
	}
	private JLabel getLblNewLabel_3() {
		if (lblNewLabel_3 == null) {
			lblNewLabel_3 = new JLabel("");
			lblNewLabel_3.setIcon(new ImageIcon(Login.class.getResource("/icons/Fondo de textura de acuarela amarilla brillante _ Vector Gratis.jpg")));
			lblNewLabel_3.setBounds(0, 0, 434, 261);
		}
		return lblNewLabel_3;
	}
}
//jjj