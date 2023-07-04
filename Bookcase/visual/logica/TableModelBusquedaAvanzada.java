package logica;

import java.lang.reflect.Field;
import java.util.Calendar;
import java.util.List;

import javax.swing.table.DefaultTableModel;

import classes.Document;
import classes.Exercices;
import classes.Material;

@SuppressWarnings({ "rawtypes", "unchecked" })
public class TableModelBusquedaAvanzada extends DefaultTableModel{

	private static final long serialVersionUID = 7853621716070275671L;

	Class[] columnTypes = new Class[] { String.class, String.class, String.class, String.class, String.class,
			String.class, String.class, Integer.class, Integer.class, String.class, String.class };

	boolean[] columnEditables = new boolean[] { false, false, false, false, false, false, false, false, false, false,
			false };

	public TableModelBusquedaAvanzada() {
		super(new Object[][] {}, new String[] { "ID", "Tipo de Material", "Titulo", "Autor", "Fehca de Creación",
				"Editorial", "Edición", "Año de Publicación",
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

	// public void filtrar(String textFilter, int column) {
	// ArrayList<Material> lista = new ArrayList<Material>(
	// ((FichaTecnica)
	// Frame.getPosicionActual()[1]).getAfect().getListaInmuebles());
	// actualizar(lista);
	// Auxiliary.filtro(textFilter, this, column, lista.size());
	//
	// }

	public void actualizar(List<Material> lista) {
		limpiar();
		for (Material material : lista) {

			String id = material.getId();
			String materialType = material.getClass().getSimpleName();
			String tittle = material.getTittle();
			String author = material.getAuthor();
			Calendar date = material.getDateCreation();
			String creationDate = date.get(Calendar.DATE) + "/" + date.get(Calendar.MONTH) + "/"
					+ date.get(Calendar.YEAR);

			String editorial = "-";
			try {
				Field field = material.getClass().getField("editorial");
				editorial = (String) field.get(material);
			} catch (Exception e) {
			}

			String edition = "-";
			try {
				Field field = material.getClass().getField("edition");
				edition = (String) field.get(material);
			} catch (Exception e) {
			}

			Integer publicationYear = null;
			try {
				Field field = material.getClass().getField("publicationYear");
				publicationYear = (Integer) field.get(material);
			} catch (Exception e) {
			}

			Integer exercisesCount = material instanceof Exercices ex ? ex.getTotal() : null;

			String exerciseType = material instanceof Exercices ex ? ex.getTipe() : "-";

			String docType = material instanceof Document doc ? doc.getTypeDoc() : "-";

			addRow(new Object[] { id, materialType, tittle, author, creationDate,
					editorial, edition,
					publicationYear,
					exercisesCount, exerciseType,
					docType });
		}

	}
	
}
