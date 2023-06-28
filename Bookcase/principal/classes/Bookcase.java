package classes;

import java.util.HashMap;
import java.util.Iterator;

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

	private HashMap<String, String> carreersIds;

	// Singleton
	private static Bookcase instance;

	// Constructors
	private Bookcase() {
		tree = new GeneralTree<NodeInfo>();
		graph = new LinkedGraph();
		carreersIds = new HashMap<String, String>();
	}

	public static Bookcase getInstance() {
		if (instance == null) {
			instance = new Bookcase();
			instance.tree.setRoot(new BinaryTreeNode<NodeInfo>(instance));
		}
		return instance;
	}

	public GeneralTree<NodeInfo> getTree() {
		return tree;
	}

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

	/**
	 * Método para crear una nueva carrera. Se agrega automáticamente al árbol
	 * 
	 * @param name     Nombre de la nueva carrera
	 * @param duration Duración en horas de la nueva carrera
	 * @return nodo con la carrera creada
	 */
	public BinaryTreeNode<NodeInfo> newCarreer(String name, int duration) {
		// Verificar si ya existe una carrera con el mismo nombre
		if (carreersIds.containsKey(name)) {
			throw new IllegalArgumentException("Ya existe la Carrera: " + name);
		}
		// Obtener un nuevo ID para la carrera
		String id = getFirstAvailableCarreerId();
		// Agregar la carrera al mapa de IDs
		carreersIds.put(name, id);
		// Crear un nodo con el nuevo objeto Carreer
		BinaryTreeNode<NodeInfo> node = new BinaryTreeNode<NodeInfo>(new Carreer(id, name, duration));
		// Insertar el nodo en el árbol
		instance.tree.insertNode(node, (BinaryTreeNode<NodeInfo>) instance.tree.getRoot());
		// Devolver el nodo
		return node;
	}

	/**
	 * 
	 * @return primer ID de carrera disponible
	 */
	public String getFirstAvailableCarreerId() {
		int i = 0; // Inicializar contador en 0
		boolean stop = false; // Variable de control para detener el bucle
		// Obtener un iterador de la lista de Infos de los hijos del nodo raíz
		// (Carreras)
		Iterator<NodeInfo> it = instance.tree.getSonsInfo((BinaryTreeNode<NodeInfo>) instance.tree.getRoot())
				.iterator();
		while (!stop && it.hasNext()) {
			Carreer carreer = (Carreer) it.next(); // Obtener la siguiente carrera
			if (Integer.parseInt(carreer.getId()) == i) { // Si el ID de la carrera es igual a i
				i++; // Incrementar i
			} else {
				stop = true; // Detener el bucle
			}
		}
		return String.format("%02d", i); // Formatear i como un número de dos dígitos y devolverlo
	}
	
	
	//TODO método que devuelve el nodo dado el id
	public BinaryTreeNode<NodeInfo> getCarreerNode(String id){
		return null;
	}

}