package logica;

import java.util.LinkedList;
import java.util.List;

import javax.swing.DefaultComboBoxModel;

import classes.Bookcase;
import classes.Carreer;
import classes.Subject;
import classes.Year;
import cu.edu.cujae.ceis.tree.binary.BinaryTreeNode;
import cu.edu.cujae.ceis.tree.general.GeneralTree;
import cu.edu.cujae.ceis.tree.iterators.general.InBreadthIterator;
import interfaces.Formulario;
import interfaces.NodeInfo;

public class SubjectsComboBoxModel extends DefaultComboBoxModel<String> {

	private static final long serialVersionUID = -4071827807302183490L;

	public SubjectsComboBoxModel() {
		super(getList());
	}
	
	private static String[] getList() {
		List<String> list = new LinkedList<>();
		list.add("Todas las asignaturas");

		GeneralTree<NodeInfo> tree = Bookcase.getInstance().getTree();
		InBreadthIterator<NodeInfo> it = tree.inBreadthIterator();
		BinaryTreeNode<NodeInfo> nodeCarreer = null;
		while (nodeCarreer == null && it.hasNext()) {
			BinaryTreeNode<NodeInfo> node = it.nextNode();
			if (node.getInfo() instanceof Year year) {
				Carreer carreer = (Carreer) tree.getFather(node).getInfo();
				if (Formulario.getComboBoxEliminarAnnoCarrera().getSelectedItem().equalsIgnoreCase(carreer.getName())) {
					
				}
			}
		}

		for(Subject subject : subjects) {
			list.add(subject.getName());
		}
		return list.toArray(new String[0]);
	}
}
