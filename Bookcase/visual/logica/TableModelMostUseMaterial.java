package logica;



import java.util.ArrayList;
import java.util.List;

import javax.swing.table.DefaultTableModel;

import classes.Book;
import classes.Material;


@SuppressWarnings({ "rawtypes", "unchecked" })
public class TableModelMostUseMaterial extends DefaultTableModel {
	

//public class MatSettingTableModel extends DefaultTableModel {

	/**
	 * 
	 */
	private static final long serialVersionUID = 7853621716070275671L;
	Class[] columnTypes = new Class[] { String.class, String.class, Float.class, String.class };
	boolean[] columnEditables = new boolean[] { false, false, false, false };

	public TableModelMostUseMaterial() {
		super(new Object[][] {}, new String[] { "Tipo de Material", "ID ","Titulo", "Autor",
				"Fehca de Creación", " Cantidad de Ejercicios", "tipo de ejercicios", "Tipo de documento" });
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

	public void filtrar(String textFilter, int column) {
		ArrayList<Material> lista = new ArrayList<Material>(
				((FichaTecnica) Frame.getPosicionActual()[1]).getAfect().getListaInmuebles());
		actualizar(lista);
		Auxiliary.filtro(textFilter, this, column, lista.size());

	}

	public void actualizar(List<Material> lista) {
		limpiar();
		for (Material material : lista) {
			if (material instanceof Book) {
//				 new String[] { "Tipo de Material", "ID ","Nombre", "Autor",
//							"Fehca de Creación", " Cantidad de Ejercicios", "tipo de ejercicios", "Tipo de documento" }
				addRow(new Object[] { Book.class,material.getId(),material.getTittle(), material.getAuthor(), material.getDateCreation(),
						"null","null","null"});
			}
		}

	}

}

