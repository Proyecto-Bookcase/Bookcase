package interfaces;

import javax.swing.JFrame;
import javax.swing.JPanel;

public class Relaciones extends JFrame {

	/**
	 * Create the panel.
	 */
	
	JPanel panle ;
	public Relaciones() {
		panle = new AgregarEliminarRelaciones();
	}
	
	public static void main(String[] args) {
		new Relaciones();
	}

}
