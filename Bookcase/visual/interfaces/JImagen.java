package interfaces;

import java.awt.Dimension;
import java.awt.Graphics;

import javax.swing.ImageIcon;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

public class JImagen extends JPanel {

	private String path;
	/**
	 * 
	 */
	private static final long serialVersionUID = -1420999087892141348L;

	public JImagen() {
		this.path=null;
		setBorder(new EmptyBorder(5, 5, 5, 5));
		setOpaque(false);
		setLayout(null);
	}
	
	public JImagen(String path) {
		this.path=path;
		setBorder(new EmptyBorder(5, 5, 5, 5));
		setOpaque(false);
		setLayout(null);
	}

	@Override
	public void paint(Graphics g) {
		if (path != null) {
			Dimension dimension = this.getSize();
			ImageIcon image = new ImageIcon(getClass().getResource("/icons/" + path));
			g.drawImage(image.getImage(), 0, 0, dimension.width, dimension.height, null);
			this.setOpaque(true);
			super.paintChildren(g);
		}
	}

	public void setImagePath(String imagePath) {
		path = imagePath;
	}

}
