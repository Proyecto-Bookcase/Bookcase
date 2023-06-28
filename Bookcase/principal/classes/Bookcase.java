package classes;

import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;

import cu.edu.cujae.ceis.graph.LinkedGraph;
import cu.edu.cujae.ceis.graph.interfaces.ILinkedNotDirectedGraph;
import cu.edu.cujae.ceis.graph.vertex.Vertex;
import cu.edu.cujae.ceis.tree.binary.BinaryTreeNode;
import cu.edu.cujae.ceis.tree.general.GeneralTree;
import cu.edu.cujae.ceis.tree.iterators.general.InBreadthIterator;
import cu.edu.cujae.ceis.tree.iterators.general.InDepthIterator;

public class Bookcase implements NodeInfo {

	// General Tree
	private GeneralTree<NodeInfo> tree;

	// Not Directed Graph
	private ILinkedNotDirectedGraph graph;

	private HashMap<String, String> carreersIds;
	
	private String id;

	// Singleton
	private static Bookcase instance;

	// Constructors
	private Bookcase() {
		tree = new GeneralTree<NodeInfo>();
		graph = new LinkedGraph();
		carreersIds = new HashMap<String, String>();
		this.id = "8431354235413434";
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
	 * @param duration Duración en años de la nueva carrera
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
		for (int i = 1; i <= duration; i++) {
			newYear(id, i);
		}
		// Devolver el nodo
		return node;
	}

	/**
	 * Crea un nuevo año para una carrera específica.
	 * 
	 * @param idCarrera  el id de la carrera
	 * @param numberYear el número de año a crear
	 * @return el nodo de la carrera
	 * @throws IllegalArgumentException si no existe una carrera con el id
	 *                                  proporcionado o si el año ya existe en la
	 *                                  carrera
	 */
	public BinaryTreeNode<NodeInfo> newYear(String idCarrera, int numberYear) {
		// Obtener el nodo de la carrera
		BinaryTreeNode<NodeInfo> node = getCarreerNode(idCarrera);
		// Verificar si el nodo de la carrera existe
		if (node == null) {
			throw new IllegalArgumentException("No existe una carrera con este id: " + idCarrera);
		}
		// Verificar si el año ya existe en la carrera
		for (NodeInfo year : instance.tree.getSonsInfo(node)) {
			if (Integer.parseInt(year.getId().substring(2)) == numberYear) {
				throw new IllegalArgumentException(
						"Ya existe el año " + numberYear + " en la Carrera " + ((Carreer) node.getInfo()).getName());
			}
		}
		// Crear el nuevo año
		Year year = new Year(idCarrera + numberYear, numberYear);
		BinaryTreeNode<NodeInfo> yearNode = new BinaryTreeNode<NodeInfo>(year);
		// Insertar el nuevo año en la carrera
		instance.tree.insertNode(yearNode, node);
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

	public BinaryTreeNode<NodeInfo> getCarreerNode(String id) {
		// aqui cambie para probar
		BinaryTreeNode<NodeInfo> esc = null;
		LinkedList<BinaryTreeNode<NodeInfo>> carrer_list = (LinkedList<BinaryTreeNode<NodeInfo>>) tree
				.getSons((BinaryTreeNode<NodeInfo>) tree.getRoot());
		Iterator<BinaryTreeNode<NodeInfo>> iter = carrer_list.iterator();
		boolean find = false;
		while (iter.hasNext() && !find) {
			esc = iter.next();
			Carreer carrer_help = (Carreer) (esc.getInfo());
			if (carrer_help.getId().equals(id)) {
				find = true;

			}
		}
		if (!find) {
			esc = null;
		}
		return esc;
	}

	public BinaryTreeNode<NodeInfo> getYearNode(String id) {
		BinaryTreeNode<NodeInfo> salida = new BinaryTreeNode<NodeInfo>();
		salida = null;
		int esc = 0;

		InBreadthIterator<NodeInfo> iter = tree.inBreadthIterator();

		while (esc == 0 && iter.hasNext()) {
			BinaryTreeNode<NodeInfo> help = new BinaryTreeNode<NodeInfo>();
			help = iter.nextNode();
			NodeInfo info = help.getInfo();

			if (info instanceof Carreer && ((Carreer) info).getId().equals(id)) {
				
					salida = help;
					esc = 1;
				

			}
			if (info instanceof Year) {
				esc = 2;
			}
		}
		if (esc != 1) {
			salida = null;
		}

		return salida;
	}

	public BinaryTreeNode<NodeInfo> getSubjectNode(String id) {
		BinaryTreeNode<NodeInfo> salida = new BinaryTreeNode<NodeInfo>();
		salida = null;
		boolean esc = false;

		InBreadthIterator<NodeInfo> iter = tree.inBreadthIterator();

		while (!esc && iter.hasNext()) {
			BinaryTreeNode<NodeInfo> help = new BinaryTreeNode<NodeInfo>();
			help = iter.nextNode();
			NodeInfo info = help.getInfo();

			if (info instanceof Subject && ((Subject) info).getId().equals(id)) {
				salida = help;
				esc = true;
			}
			if (info instanceof Year) {
				esc = true;
			}
		}

		return salida;
	}

	// esto no se si funciona xq no se que tipo es la raiz
	// es otra vercion del getCarreerNode
	public BinaryTreeNode<NodeInfo> fin_carrer(String id) {
		BinaryTreeNode<NodeInfo> salida = new BinaryTreeNode<NodeInfo>();
		salida = null;
		int esc = 0;

		InBreadthIterator<NodeInfo> iter = tree.inBreadthIterator();

		while (esc == 0 && iter.hasNext()) {
			BinaryTreeNode<NodeInfo> help = new BinaryTreeNode<NodeInfo>();
			help = iter.nextNode();
			NodeInfo info = help.getInfo();

			if (info instanceof Carreer && ((Carreer) info).getId().equals(id)) {
				
					salida = help;
					esc = 1;
				

			}
			if (info instanceof Year) {
				esc = 2;
			}
		}
		if (esc != 1) {
			salida = null;
		}

		return salida;
	}

	// este metodo creo que hay que eliminarlo
	public String getId() {
		return id;
	}
	
	public Vertex newsubject(Subject subject)
	{
		Vertex esc = new Vertex(subject);
		
		LinkedList<Vertex> vertext_list = graph.getVerticesList();
		Iterator<Vertex> iter = vertext_list.iterator();
		boolean find = false;
		while (iter.hasNext() && !find) {
			Vertex help = iter.next();
			Object info = help.getInfo();
			if(info instanceof Subject && ((Subject)info).getId().equals(subject.getId()))
			{
				find = true;
			}
		}
		if(!find)
		{
			graph.insertVertex(esc);
		}
		else 
		{
			esc = null;
		}
		
		
		
		return null;
	}
}