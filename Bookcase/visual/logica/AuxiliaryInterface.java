package logica;

import javax.swing.table.DefaultTableModel;

public class AuxiliaryInterface {

	
	
	public static void limpiar(DefaultTableModel tableModel) {
		int count = tableModel.getRowCount();
		for (int i = 0; i < count; i++) {
			tableModel.removeRow(0);
		}
	}
}
