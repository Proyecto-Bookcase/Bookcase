package logica;

import java.util.List;

import javax.swing.table.DefaultTableModel;

import auxiliary_classes.Auxiliary;
import classes.Bookcase;
import classes.Carreer;
import classes.Subject;
import classes.Year;

public class DeleteSubjectTableModel extends DefaultTableModel {

	private static final long serialVersionUID = 9125994120166025910L;

	boolean[] columnEditables;

	private Class[] columnTypes;

	public DeleteSubjectTableModel() {
		super(new Object[][] {}, new String[] { "Id", "Nombre", "Año", "Carrera" });

		columnTypes = new Class[] { String.class, String.class, Integer.class, String.class};

		columnEditables = new boolean[] { false, false, false, false, false};

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
		actualizar(Bookcase.getInstance().getAllSubjects());

	}
	
	public void actualizar(List<Subject> subjects) {
		AuxiliaryInterface.limpiar(this);
		for (Subject subject : subjects) {

			String id = subject.getId();
			String name = subject.getName();
			Auxiliary aux =  Bookcase.getInstance().findInfoSubjcetId(id);

			addRow(new Object[] { id, name, ((Year)aux.getYearNode().getInfo()).getNumberYear(),((Carreer)aux.getCarrerNode().getInfo()).getName()});
		}

	}

}
