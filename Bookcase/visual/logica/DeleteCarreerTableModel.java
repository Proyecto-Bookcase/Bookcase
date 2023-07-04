package logica;

import java.util.List;

import javax.swing.table.DefaultTableModel;

import classes.Bookcase;
import classes.Carreer;

public class DeleteCarreerTableModel extends DefaultTableModel {

	private static final long serialVersionUID = 9125994120166025910L;

	boolean[] columnEditables;

	private Class[] columnTypes;

	public DeleteCarreerTableModel() {
		super(new Object[][] {}, new String[] { "Id", "Nombre", "Duración" });

		columnTypes = new Class[] { String.class, String.class, Integer.class};

		columnEditables = new boolean[] { false, false, false};

	}

	@Override
	public boolean isCellEditable(int row, int column) {
		return columnEditables[column];
	}

	@Override
	public Class getColumnClass(int columnIndex) {
		return columnTypes[columnIndex];
	}
	
	public void actualizar() {
		AuxiliaryInterface.limpiar(this);
		List<Carreer> lista = Bookcase.getInstance().getAllCarrer();
		for (Carreer carreer : lista) {

			String id = carreer.getId();
			String name = carreer.getName();
			int duration = carreer.getDuration();

			addRow(new Object[] { id, name, duration});
		}

	}

}
