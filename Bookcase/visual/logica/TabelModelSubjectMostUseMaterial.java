package logica;

import java.lang.reflect.Field;
import java.util.Calendar;
import java.util.List;

import javax.swing.table.DefaultTableModel;

import classes.Document;
import classes.Exercices;
import classes.Material;
import classes.Subject;

@SuppressWarnings({ "rawtypes", "unchecked" })
public class TabelModelSubjectMostUseMaterial extends DefaultTableModel{
	private static final long serialVersionUID = 7853621716070275671L;

	Class[] columnTypes = new Class[] { String.class, String.class, };

	boolean[] columnEditables = new boolean[] { false, false};

	
	public TabelModelSubjectMostUseMaterial() {
		// TODO Auto-generated constructor stub
	
		super(new Object[][] {}, new String[] { "ID","Nombre" });
	}

	@Override
	public Class getColumnClass(int columnIndex) {
		return columnTypes[columnIndex];
	}

	@Override
	public boolean isCellEditable(int row, int column) {
		return columnEditables[column];
	}

	public void limpiar() {
		AuxiliaryInterface.limpiar(this);
	}
	
	public void actualizar(List<Subject> lista) {
		limpiar();
		for (Subject subject : lista) {

			String id = subject.getId();
			String name = subject.getName();
			addRow(new Object[] { id, name});
		}

	}
}
