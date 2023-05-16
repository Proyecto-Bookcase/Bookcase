package classes;

import cu.edu.cujae.ceis.tree.binary.BinaryTree;
import cu.edu.cujae.ceis.tree.general.GeneralTree;
import cu.edu.cujae.ceis.tree.iterators.general.InDepthIterator;

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
	
	//test funtion para que naylet vea 
	public Carreer get_first_carreer()
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
	//comentario para hacer una prueba con la rama en github
	
}
