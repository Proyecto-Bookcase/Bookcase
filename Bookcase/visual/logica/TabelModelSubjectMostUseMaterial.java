package logica;

import java.lang.reflect.Field;
import java.util.Calendar;
import java.util.List;

import javax.swing.table.DefaultTableModel;

import auxiliary_classes.SubAuxiliary;
import classes.Carreer;
import classes.Document;
import classes.Exercices;
import classes.Material;
import classes.Subject;
import classes.Year;

@SuppressWarnings({ "rawtypes", "unchecked" })
public class TabelModelSubjectMostUseMaterial extends DefaultTableModel{
	private static final long serialVersionUID = 7853621716070275671L;

	Class[] columnTypes = new Class[] { String.class, String.class,String.class, String.class };

	boolean[] columnEditables = new boolean[] { false, false, false, false};

	
	public TabelModelSubjectMostUseMaterial() {
		// TODO Auto-generated constructor stub
	
		super(new Object[][] {}, new String[] { "ID","Nombre","Carrera","Año" });
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
	
	public void actualizar(List<SubAuxiliary>list) {
		limpiar();
		
		for (SubAuxiliary item : list) {

			String id = item.getSubject().getId();
			String name = item.getSubject().getName();
			String carreString = item.getCarrer().getName();
			String yearString = Integer.toString(item.getYear().getNumberYear());
			
			addRow(new Object[] { id, name,carreString,yearString});
		}

	}
}