package logica;

import javax.swing.table.DefaultTableModel;

public class DeleteTableModel extends DefaultTableModel {

	private static final long serialVersionUID = 9125994120166025910L;

	boolean[] columnEditables;

	private Class[] columnTypes;

	public DeleteTableModel() {
		super(new Object[][] {}, new String[] { "Id", "T\u00EDtulo", "Asignatura", "A\u00F1o", "Carrera" });

		columnTypes = new Class[] { String.class, String.class, String.class, Integer.class, String.class };

		columnEditables = new boolean[] { false, false, false, false, false };

	}

	@Override
	public boolean isCellEditable(int row, int column) {
		return columnEditables[column];
	}

	@Override
	public Class getColumnClass(int columnIndex) {
		return columnTypes[columnIndex];
	}

}
