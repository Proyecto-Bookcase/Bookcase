package custom_components;

import javax.swing.JButton;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

public class CustomTable extends JScrollPane {

	private static final long serialVersionUID = -4940171855655079445L;
	private JTable table;
	private DefaultTableModel tableModel;
	private JButton btnBorrar;
	private JButton btnEditar;
	private int[] columnCenter;

	/**
	 * @deprecated Solo para uso del WindowBuilder
	 */
	@Deprecated
	public CustomTable() {
		super();
		tableModel = new DefaultTableModel();

		btnBorrar = new JButton();
		btnEditar = new JButton();
		columnCenter = new int[] {};
		setViewportView(getTable());
	}
	
	public CustomTable(DefaultTableModel tableModel, int[] columnCenter) {
		this.tableModel = tableModel;
		btnBorrar = new JButton();
		btnEditar = new JButton();
		this.columnCenter = columnCenter;
		setViewportView(getTable());
	}

	public CustomTable(DefaultTableModel tableModel, JButton btnBorrar, JButton btnEditar, int[] columnCenter) {
		this(tableModel, columnCenter);
		this.btnBorrar = btnBorrar;
		this.btnEditar = btnEditar;
		setViewportView(getTable());
	}

	public JTable getTable() {
		if (table == null) {
			table = new JTable(tableModel);
			Auxiliary.centrarColumnas(table, columnCenter);
			Auxiliary.quitarReordenamientoTabla(table);
			Auxiliary.activarBotonBorrar(btnBorrar, table);
			Auxiliary.activarBotonEditar(btnEditar, table);
		}
		return table;
	}
	
	public void setTableModel(DefaultTableModel tableModel, int[] columnsToCenter) {
		table.setModel(tableModel);
		Auxiliary.centrarColumnas(table, columnsToCenter);
		Auxiliary.quitarReordenamientoTabla(table);
	}
}
