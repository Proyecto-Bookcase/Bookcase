package logica;



import java.util.ArrayList;
import java.util.List;

import javax.swing.table.DefaultTableModel;

import classes.Book;
import classes.Document;
import classes.Exercices;
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
		super(new Object[][] {}, new String[] { "Tipo de Material", "ID ","Titulo", "Autor","Fehca de Creación", 
				"Editorial","Edición","Año de Publicación",
				" Cantidad de Ejercicios", "tipo de ejercicios",
				"Tipo de documento" });
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

//	public void filtrar(String textFilter, int column) {
//		ArrayList<Material> lista = new ArrayList<Material>(
//				((FichaTecnica) Frame.getPosicionActual()[1]).getAfect().getListaInmuebles());
//		actualizar(lista);
//		Auxiliary.filtro(textFilter, this, column, lista.size());
//
//	}

	public void actualizar(List<Material> lista) {
		limpiar();
		for (Material material : lista) {
			if (material instanceof Book) {
				addRow(new Object[] { Book.class,material.getId(),material.getTittle(), material.getAuthor(), (material.getDateCreation()).toString(),
						((Book)material).getEditorial(),((Book)material).getEdition(),((Book)material).getPublicationYear(),
						"null","null",
						"null"});
			}
			else if (material instanceof Exercices) {
				addRow(new Object[] { Exercices.class,material.getId(),material.getTittle(), material.getAuthor(), (material.getDateCreation()).toString(),
						"null","null","null",
						Integer.toString( ((Exercices)material).getTotal() ),((Exercices)material).getTipe(),
						"null"});
			}
			else if(material instanceof Document)
			{
				addRow(new Object[] { Document.class,material.getId(),material.getTittle(), material.getAuthor(), (material.getDateCreation()).toString(),
						"null","null","null",
						"null","null",
						((Document)material).getTypeDoc()});
			}
			else
			{
				addRow(new Object[] { "null","null","null","null","null"
										,"null","null","null"
										,"null","null"
										,"null"});
				
			}
		}

	}

}

