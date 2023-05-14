package classes;

import cu.edu.cujae.ceis.tree.binary.BinaryTree;
import cu.edu.cujae.ceis.tree.general.GeneralTree;

public class Bookcase {
	private GeneralTree<NodeInfo> tree;
	public Bookcase(GeneralTree<NodeInfo> tree) {
		this.tree = tree;
	}
	public GeneralTree<NodeInfo> getTree() {
		return tree;
	}

	public void setTree(GeneralTree<NodeInfo> tree) {
		this.tree = tree;
	}
	

	
	
}
