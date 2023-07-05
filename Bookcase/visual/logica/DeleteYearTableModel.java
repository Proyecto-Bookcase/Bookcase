package logica;

import java.util.List;

import javax.swing.table.DefaultTableModel;

import classes.Bookcase;
import classes.Carreer;
import classes.Year;
import cu.edu.cujae.ceis.tree.binary.BinaryTreeNode;
import cu.edu.cujae.ceis.tree.general.GeneralTree;
import cu.edu.cujae.ceis.tree.iterators.general.BreadthNode;
import cu.edu.cujae.ceis.tree.iterators.general.InBreadthIteratorWithLevels;
import interfaces.NodeInfo;

public class DeleteYearTableModel extends DefaultTableModel {

	private static final long serialVersionUID = 9125994120166025910L;

	boolean[] columnEditables;

	private Class[] columnTypes;

	public DeleteYearTableModel() {
		super(new Object[][] {}, new String[] { "Id", "Año Académico", "Carrera" });

		columnTypes = new Class[] { String.class, Integer.class, String.class };

		columnEditables = new boolean[] { false, false, false };

	}

	@Override
	public boolean isCellEditable(int row, int column) {
		return columnEditables[column];
	}

	@Override
	public Class getColumnClass(int columnIndex) {
		return columnTypes[columnIndex];
	}

	public void actualizar(List<Year> lista, String carreer) {
		AuxiliaryInterface.limpiar(this);

		for (Year year : lista) {

			String id = year.getId();
			int number = year.getNumberYear();

			addRow(new Object[] { id, number, carreer });
		}

	}

	public void actualizarAllYears() {
		AuxiliaryInterface.limpiar(this);

		GeneralTree<NodeInfo> tree = Bookcase.getInstance().getTree();
		InBreadthIteratorWithLevels<NodeInfo> it = tree.inBreadthIteratorWithLevels();
		boolean stop = false;
		while (!stop && it.hasNext()) {
			BreadthNode<NodeInfo> breathNode = it.nextNodeWithLevel();
			int level = breathNode.getLevel();
			if (level > 2)
				stop = true;
			else if (level == 2) {
				BinaryTreeNode<NodeInfo> node = breathNode.getNode();
				Year year = (Year) node.getInfo();
				Carreer carreer = (Carreer) tree.getFather(node).getInfo();

				String id = year.getId();
				int number = year.getNumberYear();

				addRow(new Object[] { id, number, carreer.getName() });
			}
		}

	}

}
