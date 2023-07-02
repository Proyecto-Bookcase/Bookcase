package classes;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Calendar;
import java.util.Collections;
import java.util.GregorianCalendar;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.ListIterator;
import java.util.Random;

import auxiliary_classes.AuxiliarInfo;
import auxiliary_classes.Auxiliary;
import cu.edu.cujae.ceis.graph.LinkedGraph;
import cu.edu.cujae.ceis.graph.edge.Edge;
import cu.edu.cujae.ceis.graph.interfaces.ILinkedNotDirectedGraph;
import cu.edu.cujae.ceis.graph.vertex.Vertex;
import cu.edu.cujae.ceis.tree.binary.BinaryTreeNode;
import cu.edu.cujae.ceis.tree.general.GeneralTree;
import cu.edu.cujae.ceis.tree.iterators.general.InBreadthIterator;
import cu.edu.cujae.ceis.tree.iterators.general.InDepthIterator;
import interfaces.NodeInfo;

public class Bookcase {

	// General Tree
	private GeneralTree<NodeInfo> tree;

	// Not Directed Graph
	private ILinkedNotDirectedGraph graph;

	private HashMap<String, String> carreersIds;
	private HashMap<String, HashSet<String>> subjectsIds;

	// Singleton
	private static Bookcase instance;

	// Constructors
	private Bookcase() {
		tree = new GeneralTree<>();
		graph = new LinkedGraph();
		carreersIds = new HashMap<>();
		subjectsIds = new HashMap<>();
	}

	public static Bookcase getInstance() {
		if (instance == null) {
			instance = new Bookcase();
			instance.tree.setRoot(new BinaryTreeNode<>(new University("", "")));
		}
		return instance;
	}

	public GeneralTree<NodeInfo> getTree() {
		return tree;
	}

	public ILinkedNotDirectedGraph getGraph() {
		return graph;
	}

	/**
	 * Crea una nueva carrera con el nombre y la duración especificada.
	 * 
	 * @param name     el nombre de la carrera
	 * @param duration la duración de la carrera
	 * @return un arreglo de objetos que contiene el nodo de la carrera
	 *         <code> BinaryTreeNode </code> y los nodos de los años
	 *         <code> ArrayList </code>
	 * @throws IllegalArgumentException si la carrera ya existe
	 */
	public Object[] newCarreer(String name, int duration) {
		// Verificar si la carrera ya existe en el mapa de ids de carreras
		if (carreersIds.containsKey(name)) {
			throw new IllegalArgumentException("Ya existe la Carrera: " + name);
		}
		// Obtener el primer id de carrera disponible
		String id = getFirstAvailableCarreerId();
		// Agregar la carrera al mapa de ids de carreras
		carreersIds.put(name, id);
		// Crear un nuevo nodo de árbol binario con la información de la carrera
		BinaryTreeNode<NodeInfo> node = new BinaryTreeNode<>(new Carreer(id, name, duration));
		// Insertar el nodo en el árbol
		instance.tree.insertNode(node, (BinaryTreeNode<NodeInfo>) instance.tree.getRoot());
		// Crear una lista de nodos de árbol para representar los años de duración de la
		// carrera
		ArrayList<BinaryTreeNode<NodeInfo>> years = new ArrayList<>();
		for (int i = 1; i <= duration; i++) {
			years.add(newYear(id, i));
		}
		// Devolver un arreglo de objetos que contiene el nodo de la carrera y la lista
		// de años
		return new Object[] { node, years };
	}

	/**
	 * Crea un nuevo año para una carrera específica.
	 * 
	 * @param idCarrera  el id de la carrera
	 * @param numberYear el número de año a crear
	 * @return el nodo de año creado
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
		BinaryTreeNode<NodeInfo> yearNode = new BinaryTreeNode<>(year);
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
			set = new HashSet<>();
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

	public <E extends Material> Vertex newMaterial(Class<E> typeMaterial, List<String> idList, Object... args) {

		Vertex res = null;
		String id = randomMaterialId();
		List<Object> arg = new ArrayList<>();
		arg.add(id);
		arg.addAll(Arrays.asList(args));
		args = arg.toArray();

		Class[] parameterTypes = new Class[args.length];
		for (int i = 0; i < args.length; i++) {
			parameterTypes[i] = args[i].getClass();
		}

		Constructor<E> constructor = null;
		E info = null;
		try {

			constructor = typeMaterial.getConstructor(parameterTypes);
			info = constructor.newInstance(args);

		} catch (NoSuchMethodException e) {
			e.printStackTrace();
		} catch (SecurityException e) {
			e.printStackTrace();
		} catch (InstantiationException e) {
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			e.printStackTrace();
		} catch (IllegalArgumentException e) {
			e.printStackTrace();
		} catch (InvocationTargetException e) {
			e.printStackTrace();
		}

		graph.insertVertex(info);
		int posHead = getVertexIndexById(info.getId());
		for (String ids : idList) {
			int posTail = getVertexIndexById(ids);
			graph.insertEdgeNDG(posTail, posHead);
		}

		return res;
	}

	private boolean checkId(String id) {

		boolean check = true;

		InDepthIterator<NodeInfo> iterTree = instance.tree.inDepthIterator();
		LinkedList<Vertex> list = instance.graph.getVerticesList();
		Iterator<Vertex> iterGraph = list.iterator();

		while (check && (iterTree.hasNext() || iterGraph.hasNext())) {

			if (iterTree.hasNext() && iterTree.next().getId().equals(id))
				check = false;

			if (check && iterGraph.hasNext()) {
				Object info = iterGraph.next().getInfo();
				if (!(info instanceof Subject) && ((Material) info).getId().equals(id))
					check = false;

			}
		}
		return check;
	}

	private String randomMaterialId() {

		Random random = new Random();
		StringBuilder strBuilder = new StringBuilder(8);
		boolean check = false;
		while (!check) {
			random.setSeed((new GregorianCalendar()).getTimeInMillis());
			for (int i : random.ints(8, 0, 10).toArray()) {
				strBuilder.append(i);
			}
			check = instance.checkId(strBuilder.toString());
		}

		return strBuilder.toString();
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
		BinaryTreeNode<NodeInfo> node = new BinaryTreeNode<>(subject);
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
	 * 
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
		List<BinaryTreeNode<NodeInfo>> carreerList = tree.getSons((BinaryTreeNode<NodeInfo>) tree.getRoot());
		Iterator<BinaryTreeNode<NodeInfo>> iter = carreerList.iterator();
		boolean find = false;
		while (iter.hasNext() && !find) {
			esc = iter.next();
			Carreer carreerHelp = (Carreer) (esc.getInfo());
			if (carreerHelp.getId().equals(id)) {
				find = true;

			}
		}
		if (!find) {
			esc = null;
		}
		return esc;
	}

	public BinaryTreeNode<NodeInfo> getYearNode(String id) {
		BinaryTreeNode<NodeInfo> salida = new BinaryTreeNode<>();
		salida = null;
		int esc = 0;

		InBreadthIterator<NodeInfo> iter = tree.inBreadthIterator();

		while (esc == 0 && iter.hasNext()) {
			BinaryTreeNode<NodeInfo> help = new BinaryTreeNode<>();
			help = iter.nextNode();
			NodeInfo info = help.getInfo();

			if (info instanceof Year && ((Year) info).getId().equals(id)) {

				salida = help;
				esc = 1;

			}
			if (info instanceof Subject) {
				esc = 2;
			}
		}
		if (esc != 1) {
			salida = null;
		}

		return salida;
	}

	public BinaryTreeNode<NodeInfo> getSubjectNode(String id) {
		BinaryTreeNode<NodeInfo> salida = new BinaryTreeNode<>();
		salida = null;
		boolean esc = false;

		InBreadthIterator<NodeInfo> iter = tree.inBreadthIterator();

		while (!esc && iter.hasNext()) {
			BinaryTreeNode<NodeInfo> help = new BinaryTreeNode<>();
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

	private Vertex addSubjectToGraph(Subject subject) {
		Vertex esc = new Vertex(subject);

		LinkedList<Vertex> vertexList = graph.getVerticesList();
		Iterator<Vertex> iter = vertexList.iterator();
		boolean find = false;
		while (iter.hasNext() && !find) {
			Vertex help = iter.next();
			Object info = help.getInfo();
			if (info instanceof Subject && ((Subject) info).getId().equals(subject.getId())) {
				find = true;
			}
		}
		if (!find) {
			graph.insertVertex(esc.getInfo());
		} else {
			esc = null;
		}

		return esc;
	}

	// este metodo devuekve las asignaturas que usan mayor cantidad de materiales
	public List<Subject> subjectsMostMaterialUse() {
		// aqui se crea la lista de salida
		List<Subject> escLits = new LinkedList<>();
		// se obtiene la lisat de vertices del ggrafo
		LinkedList<Vertex> vertList = graph.getVerticesList();
		// se inicializa el iterador
		Iterator<Vertex> iter = vertList.iterator();

		// se inicializa la cantidad de materiales
		int max = 0;
		// se lleva un contador para ver el indice del vertice recorrido
		int cont = 0;
		while (iter.hasNext()) {
			Vertex vert = iter.next();
			Object help = vert.getInfo();
			// se comprueba si la info del vertice es instancia de subject
			if (help instanceof Subject) {
				// se obtiene el grado del vertice
				int grade = graph.degreeND(cont);
				// se revisa si es mayor que la cantidad de materiales
				if (grade > max) {
					// si es mayor se reinicia la lista se añade el subject
					// y se actualiza la cantidad de materiales
					max = grade;
					escLits.clear();
					escLits.add((Subject) help);
				} else if (grade == max) {
					// si es igual se añade el subject a la lista
					escLits.add((Subject) help);
				}

			}

			cont++;
		}
		return escLits;
	}

	// metodo para encontrara los materiales mas utilizados
	public List<Material> mostUseMaterial() {
		// aqui se crea la lista de salida
		List<Material> escList = new LinkedList<>();

		// se obtiene la lisat de vertices del ggrafo
		LinkedList<Vertex> vertList = graph.getVerticesList();
		// se inicializa el iterador
		Iterator<Vertex> iter = vertList.iterator();

		// se inicializa la cantidad de asignaturas que usan un material determinadoS
		int max = 0;
		// se lleva un contador para ver el indice del vertice recorrido
		int cont = 0;
		while (iter.hasNext()) {
			Vertex vert = iter.next();
			Object help = vert.getInfo();
			// se comprueba si la info del vertice es instancia de subject
			if (help instanceof Material) {
				// se obtiene el grado del vertice
				int grade = graph.degreeND(cont);
				// se revisa si es mayor que la cantidad de materiales
				if (grade > max) {
					// si es mayor se reinicia la lista se añade el subject
					// y se actualiza la cantidad de materiales
					max = grade;
					escList.clear();
					escList.add((Material) help);
				} else if (grade == max) {
					// si es igual se añade el subject a la lista
					escList.add((Material) help);
				}

			}

			cont++;
		}
		return escList;
	}

	// para una carrera los materiales mas usados
	// asumo que materiales mas usados se tomara como los materiales que mas
	// asignaturas los usan
	public List<Material> mostUsedMaterialOfCarrer(Carreer carreer) {

		List<Material> escList = new LinkedList<>();

		LinkedList<Vertex> vertList = graph.getVerticesList();
		Iterator<Vertex> iter = vertList.iterator();
		int max = 0;
		while (iter.hasNext()) {
			Vertex vert = iter.next();
			NodeInfo vertInfo = (NodeInfo) vert.getInfo();
			if (vertInfo instanceof Material) {
				int useMaterial = 0;

				LinkedList<Edge> subjectsList = vert.getEdgeList();
				Iterator<Edge> iterEdge = subjectsList.iterator();

				while (iterEdge.hasNext()) {
					Edge edge = iterEdge.next();

					Auxiliary auxiliary = findInfoSubjcetId(((Subject) edge.getVertex().getInfo()).getId());
					if (auxiliary.getCarrerNode().getInfo().getId().equals(carreer.getId())) {
						useMaterial++;
					}
				}
				if (max < useMaterial) {
					escList.clear();
					escList.add((Material) vert.getInfo());
					max = useMaterial;

				} else if (max == useMaterial) {
					escList.add((Material) vert.getInfo());
				}
			}
		}

		return escList;
	}

	// metodo que tiene que hacer altro
	public Auxiliary findInfoSubjcetId(String id) {
		Auxiliary aux = new Auxiliary();
		String carreer = id.substring(2);
		int year = Integer.parseInt(id.substring(2, 3));

		List<BinaryTreeNode<NodeInfo>> list = instance.tree.getSons((BinaryTreeNode<NodeInfo>) instance.tree.getRoot());
		ListIterator<BinaryTreeNode<NodeInfo>> it = list.listIterator();
		boolean found = false;
		while (!found && it.hasNext()) {
			BinaryTreeNode<NodeInfo> node = it.next();
			if (node.getInfo().getId().equals(carreer)) {
				aux.setCarrerNode(node);
				List<BinaryTreeNode<NodeInfo>> years = instance.tree.getSons(node);
				ListIterator<BinaryTreeNode<NodeInfo>> iter = years.listIterator();
				while (!found && iter.hasNext()) {
					node = it.next();
					int number = ((Year) node.getInfo()).getNumberYear();
					if (number == year) {
						aux.setYearNode(node);
						found = true;
					}
				}

			}

		}

		return aux;
	}

	// este metodo no creo que haga falta xq hice otro anteriormente igual
	private BinaryTreeNode<NodeInfo> findNodeCarrer(Carreer carreer) {
		BinaryTreeNode<NodeInfo> escNode = new BinaryTreeNode<NodeInfo>();

		InBreadthIterator<NodeInfo> iter = tree.inBreadthIterator();

		int found = 0;
		while (found == 0 && iter.hasNext()) {
			BinaryTreeNode<NodeInfo> nodeIter = iter.nextNode();
			NodeInfo nodeInfo = nodeIter.getInfo();
			if (nodeInfo instanceof Carreer && ((Carreer) nodeInfo).getId().equals(carreer.getId())) {
				escNode = nodeIter;
			}

		}

		return escNode;
	}

	// este metodo devuelve toda la informacion de los materiales de una carrera
	// es decir devuelve cada material la cantidad de veces que se utiliza en la
	// carrera
	// para cada subject diferente
	public List<AuxiliarInfo> getAllMaterialOfCarrer1(Carreer carreer) {
		List<AuxiliarInfo> escList = new LinkedList<AuxiliarInfo>();

		LinkedList<Vertex> vertList = graph.getVerticesList();
		Iterator<Vertex> iter = vertList.iterator();
		int max = 0;
		while (iter.hasNext()) {
			Vertex vert = iter.next();
			NodeInfo vertInfo = (NodeInfo) vert.getInfo();
			if (vertInfo instanceof Material) {

				LinkedList<Edge> subjectsList = vert.getEdgeList();
				Iterator<Edge> iterEdge = subjectsList.iterator();

				while (iterEdge.hasNext()) {
					Edge edge = iterEdge.next();

					Auxiliary auxiliary = findInfoSubjcetId(((Subject) edge.getVertex().getInfo()).getId());
					if (auxiliary.getCarrerNode().getInfo().getId().equals(carreer.getId())) {
						AuxiliarInfo auxAdd = new AuxiliarInfo(carreer, (Subject) edge.getVertex().getInfo(),
								(Year) auxiliary.getYearNode().getInfo(), (Material) vertInfo);
						escList.add(auxAdd);

					}
				}
			}
		}

		return escList;
	}

	// este metodo solo devuelve los materiales de una carrera en especifico
	public List<Material> getAllMaterialOfCarrer2(Carreer carreer) {
		List<Material> escList = new LinkedList<Material>();

		LinkedList<Vertex> vertList = graph.getVerticesList();
		Iterator<Vertex> iter = vertList.iterator();
		int max = 0;
		while (iter.hasNext()) {
			Vertex vert = iter.next();
			NodeInfo vertInfo = (NodeInfo) vert.getInfo();
			if (vertInfo instanceof Material) {

				LinkedList<Edge> subjectsList = vert.getEdgeList();
				Iterator<Edge> iterEdge = subjectsList.iterator();
				boolean inCarrer = false;
				while (!inCarrer && iterEdge.hasNext()) {
					Edge edge = iterEdge.next();

					Auxiliary auxiliary = findInfoSubjcetId(((Subject) edge.getVertex().getInfo()).getId());
					if (auxiliary.getCarrerNode().getInfo().getId().equals(carreer.getId())) {
						inCarrer = true;
						escList.add((Material) vertInfo);
					}
				}
			}
		}

		return escList;
	}

	// este metodo devuelve la lista de materiales que estan en la carrera y el year
	// especificado
	// tengo que modificar este metodo
	public List<Material> getAllMaterialOfCarrerAndYear(Carreer carreer, Year year) {
		List<Material> escList = new LinkedList<>();

		LinkedList<Vertex> vertList = graph.getVerticesList();
		Iterator<Vertex> iter = vertList.iterator();
		int max = 0;
		while (iter.hasNext()) {
			Vertex vert = iter.next();
			NodeInfo vertInfo = (NodeInfo) vert.getInfo();
			if (vertInfo instanceof Material) {

				LinkedList<Edge> subjectsList = vert.getEdgeList();
				Iterator<Edge> iterEdge = subjectsList.iterator();
				boolean inCarrerAndYear = false;
				while (!inCarrerAndYear && iterEdge.hasNext()) {
					Edge edge = iterEdge.next();

					Auxiliary auxiliary = findInfoSubjcetId(((Subject) edge.getVertex().getInfo()).getId());
					if (auxiliary.getCarrerNode().getInfo().getId().equals(carreer.getId())
							&& auxiliary.getYearNode().getInfo().getId().equals(year.getId())) {
						inCarrerAndYear = true;
						escList.add((Material) vertInfo);
					}
				}
			}
		}

		return escList;
	}

	// devuelve todos los materiales de un subject
	public List<Material> getAllMaterialOfSubject(Subject subject) {
		List<Material> escList = new LinkedList<>();

		LinkedList<Vertex> vertList = graph.getVerticesList();
		Iterator<Vertex> iter = vertList.iterator();

		boolean find = false;
		while (!find && iter.hasNext()) {
			Vertex vertIter = iter.next();
			Object vertInfo = vertIter.getInfo();
			if (vertInfo instanceof Subject && ((Subject) vertInfo).getId().equals(subject.getId())) {
				LinkedList<Edge> edgeList = vertIter.getEdgeList();
				Iterator<Edge> iterEdge = edgeList.iterator();
				while (iterEdge.hasNext()) {
					Vertex vertEdge = iterEdge.next().getVertex();
					escList.add((Material) vertEdge.getInfo());
				}

				find = true;
			}
		}
		return escList;
	}

	// este metodo devuelve todos los subjects que utilizan un material
	public List<Subject> getAllSubjectOfMaterial(Material material) {
		List<Subject> escList = new LinkedList<Subject>();
		LinkedList<Vertex> vertList = graph.getVerticesList();
		Iterator<Vertex> iter = vertList.iterator();

		boolean find = false;
		while (!find && iter.hasNext()) {
			Vertex vertIter = iter.next();
			Object vertInfo = vertIter.getInfo();
			if (vertInfo instanceof Material) {
				LinkedList<Edge> edgeList = vertIter.getEdgeList();
				Iterator<Edge> iterEdge = edgeList.iterator();
				while (iterEdge.hasNext()) {
					Vertex vertEdge = iterEdge.next().getVertex();
					escList.add((Subject) vertEdge.getInfo());
				}
			}
		}
		return escList;
	}

	// eliminar material
	public void deleteMaterial(Material materialDlete) {

		int materialIndex = Integer.parseInt(materialDlete.getId());
		int indexMaterialDelete = getVertexIndexById(materialDlete.getId());
		LinkedList<Vertex> vertList = graph.getVerticesList();
		Vertex vertMaterialDelete = vertList.get(indexMaterialDelete);
		LinkedList<Vertex> adjacentsList = vertMaterialDelete.getAdjacents();
		Iterator<Vertex> iterAdjacents = adjacentsList.iterator();
		while (iterAdjacents.hasNext()) {
			Vertex vertIter = iterAdjacents.next();
			int indexVert = vertList.indexOf(vertIter);
			graph.deleteEdgeND(materialIndex, indexVert);
		}
		graph.deleteVertex(indexMaterialDelete);
	}

	private int getVertexIndexById(String id) {

		int index = 0;
		LinkedList<Vertex> vertList = graph.getVerticesList();

		Iterator<Vertex> iterVert = vertList.iterator();
		boolean found = false;
		while (iterVert.hasNext() && !found) {
			Vertex vert = iterVert.next();
			Object vertInfo = vert.getInfo();
			if ((vertInfo instanceof Subject && ((Subject) vertInfo).getId().equals(id))
					|| (vertInfo instanceof Material && ((Material) vertInfo).getId().equals(id))) {
				found = true;

			} else {
				index++;

			}

		}

		return index;
	}

	public void deleteSubject(Subject subjectDelete) {

		deleteSubjectGraph(subjectDelete);
		deleteSubjectTree(subjectDelete);

	}

	public void deleteSubjectTree(Subject subjectDelete) {
		BinaryTreeNode<NodeInfo> vertSubjetc = getSubjectNode(subjectDelete.getId());
		tree.deleteNode(vertSubjetc);
	}

	public void deleteSubjectGraph(Subject subjectDelete) {
		int subjcetIndex = Integer.parseInt(subjectDelete.getId());
		int indexMaterialDelete = getVertexIndexById(subjectDelete.getId());
		LinkedList<Vertex> vertList = graph.getVerticesList();
		Vertex vertSubjectDelete = vertList.get(indexMaterialDelete);
		LinkedList<Vertex> adjacentsList = vertSubjectDelete.getAdjacents();
		Iterator<Vertex> iterAdjacents = adjacentsList.iterator();

		while (iterAdjacents.hasNext()) {

			Vertex vertIter = iterAdjacents.next();
			int indexVert = vertList.indexOf(vertIter);
			graph.deleteEdgeND(subjcetIndex, indexVert);

		}
		graph.deleteVertex(indexMaterialDelete);

	}

}
