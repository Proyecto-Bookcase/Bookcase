package classes;

import cu.edu.cujae.ceis.graph.LinkedGraph;
import cu.edu.cujae.ceis.graph.interfaces.ILinkedNotDirectedGraph;
import cu.edu.cujae.ceis.tree.general.GeneralTree;
import cu.edu.cujae.ceis.tree.iterators.general.InDepthIterator;

public class Bookcase {
	
	private GeneralTree<NodeInfo> tree;
	private ILinkedNotDirectedGraph graph;
	
	public Bookcase(GeneralTree<NodeInfo> tree, LinkedGraph graph) {
		this.tree = tree;
		this.graph = graph;
	}
	public GeneralTree<NodeInfo> getTree() {
		return tree;
	}

	public void setTree(GeneralTree<NodeInfo> tree) {
		this.tree = tree;
	}
	
	//test funtion para que naylet vea 
	public Carreer getFirstCarreer()
	{
		InDepthIterator<NodeInfo> iter= tree.inDepthIterator();
		
		Carreer carrear_esc = new Carreer();
		boolean esc = true;
		while (esc && iter.hasNext()) {
			NodeInfo aux = iter.next();
			if (aux instanceof Carreer) {
				esc = false;
				carrear_esc = (Carreer)aux;
			}
			
		}
		
		return carrear_esc;
	}
		
	public ILinkedNotDirectedGraph getGraph() {
		return graph;
	}
	public void setGraph(ILinkedNotDirectedGraph graph) {
		this.graph = graph;
	}
}
