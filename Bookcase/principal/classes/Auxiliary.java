package classes;

import cu.edu.cujae.ceis.tree.binary.BinaryTreeNode;

public class Auxiliary {
	private BinaryTreeNode<NodeInfo> carrerNode;
	private BinaryTreeNode<NodeInfo> yearNode;

	public BinaryTreeNode<NodeInfo> getCarrerNode() {
		return carrerNode;
	}

	public void setCarrerNode(BinaryTreeNode<NodeInfo> carrerNode) {
		this.carrerNode = carrerNode;
	}

	public BinaryTreeNode<NodeInfo> getYearNode() {
		return yearNode;
	}

	public void setYearNode(BinaryTreeNode<NodeInfo> yearNode) {
		this.yearNode = yearNode;
	}

}
