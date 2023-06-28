package classes;

import java.util.HashMap;
import java.util.HashSet;
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
	private HashMap<String, HashSet<String>> subjectsIds;

	private String id;

	// Singleton
	private static Bookcase instance;

	// Constructors
	private Bookcase() {
		tree = new GeneralTree<NodeInfo>();
		graph = new LinkedGraph();
		carreersIds = new HashMap<String, String>();
		subjectsIds = new HashMap<String, HashSet<String>>();
		this.id = "8431354235413434";
	}

	public static Bookcase getInstance() {
		if (instance == null) {
			instance = new Bookcase();
			instance.tree.setRoot(new BinaryTreeNode<NodeInfo>(new University()));
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

	public Object[] newSubject(String yearId, String name) {
		// Get the first available subject ID
		String id = getFirstAvailableSubjectId(yearId);
		// Get the set of subject IDs for the given year ID
		HashSet<String> set = subjectsIds.get(yearId);
		// If the set is null, create a new set and add it to the subjectsIds map
		if (set == null) {
			set = new HashSet<String>();
			subjectsIds.put(yearId, set);
		}
		// If the ID is already present in the set, throw an exception
		if (!set.add(id)) {
			throw new IllegalArgumentException("Ya existe una asignatura con el id: " + yearId + id);
		}
		// Create a new Subject object with the concatenated year ID and subject ID
		Subject subject = new Subject(yearId + id, name);
		// Return an array containing the result of adding the subject to the tree and
		// graph
		return new Object[] { addSubjectToTree(yearId, subject), addSubjectToGraph(subject) };
	}


	/**
	 * Agrega un tema al árbol.*
	 * 
	 * @param idYear  el identificador del año*
	 * @param subject el tema a agregar*@return el nodo del árbol que se
	 *                agregó*@throws IllegalArgumentException si ya existe un nodo
	 *                con el mismo identificador
	 */

	private BinaryTreeNode<NodeInfo> addSubjectToTree(String idYear, Subject subject) {
		// Obtener un iterador en profundidad del árbol
		InDepthIterator<NodeInfo> it = instance.tree.inDepthIterator();
		// Verificar si ya existe un nodo con el mismo identificador
		while (it.hasNext()) {
			NodeInfo currentNode = it.next();
			if (currentNode.getId().equals(subject.getId())) {
				throw new IllegalArgumentException("Ya existe un nodo con id: " + subject.getId());
			}
		}
		// Crear un nuevo nodo con la información del tema
		BinaryTreeNode<NodeInfo> node = new BinaryTreeNode<NodeInfo>(subject);
		// Obtener el nodo padre correspondiente al año
		BinaryTreeNode<NodeInfo> father = getYearNode(idYear);
		// Insertar el nodo en el árbol
		instance.tree.insertNode(node, father);
		// Devolver el nodo agregado
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

	/**
	 * Obtiene el primer ID de carrera disponible.
	 * @param yearId ID del año*
	 * @returnprimer ID de carrera disponible
	 */

	public String getFirstAvailableSubjectId(String yearId) {
		int i = 0;
		boolean stop = false;
     // Obtiene los hijos del nodo del año
		Iterator<NodeInfo> it = instance.tree.getSonsInfo(getYearNode(yearId)).iterator();
     // Itera sobre los hijos hasta encontrar el primer ID de carrera disponible
		while (!stop && it.hasNext()) {
			Subject subject = (Subject) it.next();
			if (Integer.parseInt(subject.getId().substring(3)) == i) {
				i++;
			} else {
				stop = true;
			}
		}

		return String.format("%02d", i);
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

	private Vertex addSubjectToGraph(Subject subject) {
		Vertex esc = new Vertex(subject);

		LinkedList<Vertex> vertext_list = graph.getVerticesList();
		Iterator<Vertex> iter = vertext_list.iterator();
		boolean find = false;
		while (iter.hasNext() && !find) {
			Vertex help = iter.next();
			Object info = help.getInfo();
			if (info instanceof Subject && ((Subject) info).getId().equals(subject.getId())) {
				find = true;
			}
		}
		if (!find) {
			graph.insertVertex(esc);
		} else {
			esc = null;
		}

		return esc;
	}
}
