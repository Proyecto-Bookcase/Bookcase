package classes;

import cu.edu.cujae.ceis.graph.LinkedGraph;
import cu.edu.cujae.ceis.graph.interfaces.ILinkedNotDirectedGraph;
import cu.edu.cujae.ceis.tree.binary.BinaryTreeNode;
import cu.edu.cujae.ceis.tree.general.GeneralTree;
import cu.edu.cujae.ceis.tree.iterators.general.InDepthIterator;

public class Bookcase implements NodeInfo {

	// General Tree
	private GeneralTree<NodeInfo> tree;

	// Not Directed Graph
	private ILinkedNotDirectedGraph graph;

	// Singleton
	private Bookcase instance;

	// Constructors
	private Bookcase() {
		tree = new GeneralTree<NodeInfo>();
		graph = new LinkedGraph();
	}

	public Bookcase getInstance() {
		if (instance == null) {
			instance = new Bookcase();
			instance.tree.setRoot(new BinaryTreeNode<NodeInfo>(instance));
		}
		return instance;
	}

	public GeneralTree<NodeInfo> getTree() {
		return tree;
	}
//
//	public void setTree(GeneralTree<NodeInfo> tree) {
//		this.tree = tree;
//	}

	// test funtion para que naylet vea
	public Carreer getFirstCarreer() {
		InDepthIterator<NodeInfo> iter = tree.inDepthIterator();

		Carreer carrear_esc = null;
		while (carrear_esc == null && iter.hasNext()) {
			NodeInfo aux = iter.next();
			if (aux instanceof Carreer) {
				carrear_esc = (Carreer) aux;
			}

		}

		return carrear_esc;
	}

	public ILinkedNotDirectedGraph getGraph() {
		return graph;
	}

//	public void setGraph(ILinkedNotDirectedGraph graph) {
//		this.graph = graph;
//	}
}
