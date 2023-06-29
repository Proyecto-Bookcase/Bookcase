package interfaces;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.ImageIcon;
import java.awt.Font;
import javax.swing.JTextField;

public class Principal extends JFrame {

	private static final long serialVersionUID = -7077272486481467310L;
	private JPanel contentPane;
	private JLabel lblNewLabel_2;
	private JLabel lblNewLabel_5;
	private JLabel lblNewLabel_7;
	private JLabel lblNewLabel;
	private JTextField textField;
	private JLabel lblNewLabel_1;
	private JLabel lblNewLabel_9;
	private JLabel lblNewLabel_3;
	private JLabel lblNewLabel_4;
	private JLabel lblNewLabel_6;
	private JLabel lblNewLabel_8;

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
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 443, 368);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		contentPane.add(getLblNewLabel_2());
		contentPane.add(getLblNewLabel_5());
		contentPane.add(getLblNewLabel_7());
		contentPane.add(getLblNewLabel());
		contentPane.add(getTextField());
		contentPane.add(getLblNewLabel_1());
		contentPane.add(getLblNewLabel_9());
		contentPane.add(getLblNewLabel_3());
		contentPane.add(getLblNewLabel_4());
		contentPane.add(getLblNewLabel_6());
		contentPane.add(getLblNewLabel_8());
	}

	private JLabel getLblNewLabel_2() {
		if (lblNewLabel_2 == null) {
			lblNewLabel_2 = new JLabel("");
			lblNewLabel_2.setIcon(new ImageIcon(Principal.class.getResource("/icons/icons8-setting-48.png")));
			lblNewLabel_2.setBounds(328, 11, 54, 56);
		}
		return lblNewLabel_2;
	}
	private JLabel getLblNewLabel_5() {
		if (lblNewLabel_5 == null) {
			lblNewLabel_5 = new JLabel("");
			lblNewLabel_5.setIcon(new ImageIcon(Principal.class.getResource("/icons/icons8-book-64 (2).png")));
			lblNewLabel_5.setBounds(328, 78, 80, 56);
		}
		return lblNewLabel_5;
	}
	private JLabel getLblNewLabel_7() {
		if (lblNewLabel_7 == null) {
			lblNewLabel_7 = new JLabel("");
			lblNewLabel_7.setIcon(new ImageIcon(Principal.class.getResource("/icons/icons8-user-48.png")));
			lblNewLabel_7.setBounds(328, 155, 46, 42);
		}
		return lblNewLabel_7;
	}
	private JLabel getLblNewLabel() {
		if (lblNewLabel == null) {
			lblNewLabel = new JLabel("LIBRERÍA");
			lblNewLabel.setFont(new Font("Yu Gothic UI Semibold", Font.BOLD, 21));
			lblNewLabel.setBounds(44, 35, 101, 31);
		}
		return lblNewLabel;
	}
	private JTextField getTextField() {
		if (textField == null) {
			textField = new JTextField();
			textField.setToolTipText("");
			textField.setColumns(10);
			textField.setBounds(29, 78, 121, 20);
		}
		return textField;
	}
	private JLabel getLblNewLabel_1() {
		if (lblNewLabel_1 == null) {
			lblNewLabel_1 = new JLabel("");
			lblNewLabel_1.setIcon(new ImageIcon(Principal.class.getResource("/icons/icons8-google-web-search-24.png")));
			lblNewLabel_1.setBounds(148, 78, 27, 20);
		}
		return lblNewLabel_1;
	}
	private JLabel getLblNewLabel_9() {
		if (lblNewLabel_9 == null) {
			lblNewLabel_9 = new JLabel("");
			lblNewLabel_9.setIcon(new ImageIcon(Principal.class.getResource("/icons/icons8-filter-24.png")));
			lblNewLabel_9.setBounds(170, 78, 46, 20);
		}
		return lblNewLabel_9;
	}
	private JLabel getLblNewLabel_3() {
		if (lblNewLabel_3 == null) {
			lblNewLabel_3 = new JLabel("");
			lblNewLabel_3.setIcon(new ImageIcon(Principal.class.getResource("/icons/icons8-login-30.png")));
			lblNewLabel_3.setBounds(0, 0, 46, 31);
		}
		return lblNewLabel_3;
	}
	private JLabel getLblNewLabel_4() {
		if (lblNewLabel_4 == null) {
			lblNewLabel_4 = new JLabel("");
			lblNewLabel_4.setIcon(new ImageIcon(Principal.class.getResource("/icons/icons8-instagram-24.png")));
			lblNewLabel_4.setBounds(328, 287, 33, 31);
		}
		return lblNewLabel_4;
	}
	private JLabel getLblNewLabel_6() {
		if (lblNewLabel_6 == null) {
			lblNewLabel_6 = new JLabel("");
			lblNewLabel_6.setIcon(new ImageIcon(Principal.class.getResource("/icons/icons8-facebook-24 (1).png")));
			lblNewLabel_6.setBounds(362, 287, 46, 31);
		}
		return lblNewLabel_6;
	}
	private JLabel getLblNewLabel_8() {
		if (lblNewLabel_8 == null) {
			lblNewLabel_8 = new JLabel("");
			lblNewLabel_8.setIcon(new ImageIcon(Principal.class.getResource("/icons/Torn Paper PNG Image, Torn Paper Illustration, Torn Paper, Ripped Paper, Twibbon PNG Image For Free Download.png")));
			lblNewLabel_8.setBounds(78, 0, 349, 329);
		}
		return lblNewLabel_8;
	}
}
