package classes;

import java.lang.reflect.Constructor;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.GregorianCalendar;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Random;

import auxiliary_classes.AuxiliarInfo;
import auxiliary_classes.Auxiliary;
import auxiliary_classes.AuxiliarySubjectMostMaterialUse;
import auxiliary_classes.SubAuxiliary;
import cu.edu.cujae.ceis.graph.LinkedGraph;
import cu.edu.cujae.ceis.graph.edge.Edge;
import cu.edu.cujae.ceis.graph.interfaces.ILinkedNotDirectedGraph;
import cu.edu.cujae.ceis.graph.vertex.Vertex;
import cu.edu.cujae.ceis.tree.binary.BinaryTreeNode;
import cu.edu.cujae.ceis.tree.general.GeneralTree;
import cu.edu.cujae.ceis.tree.iterators.general.BreadthNode;
import cu.edu.cujae.ceis.tree.iterators.general.InBreadthIteratorWithLevels;
import cu.edu.cujae.ceis.tree.iterators.general.InDepthIterator;
import exceptions.ExistingElementException;
import interfaces.NodeInfo;

public class Bookcase {

	// General Tree
	private GeneralTree<NodeInfo> tree;

	// Not Directed Graph
	private ILinkedNotDirectedGraph graph;

	private HashMap<String, String> carreersIds;
	private HashMap<String, HashSet<String>> subjectsIds;

	private Random random;

	// Singleton
	private static Bookcase instance;

	// Constructors
	private Bookcase() {
		tree = new GeneralTree<>();
		graph = new LinkedGraph();
		carreersIds = new HashMap<>();
		subjectsIds = new HashMap<>();
		random = new Random();
	}

	public static Bookcase getInstance() {
		if (instance == null) {
			instance = new Bookcase();

			inicializacion();

			/* instance.tree.setRoot(new BinaryTreeNode<>(new University("0", "Cujae")));


			//instance.newCarreer("Informática", 4);
			//instance.newSubject("001", "Matemática");
			//instance.newSubject("002", "Matemáticb");
			//instance.newSubject("003", "Matemáticc");
			//instance.newSubject("004", "Matemáticd");

		
			//instance.newMaterial(Document.class, Arrays.asList("00100"), "A", "", new GregorianCalendar(), "");
			//instance.newMaterial(Document.class, Arrays.asList("00100"), "B", "", new GregorianCalendar(), "");
			


			//instance.newCarreer("Ciencias Médicas", 6);
			//instance.newSubject("011", "asdsd");
			//instance.newSubject("011", "asdadasd");
			//instance.newSubject("011", "asdsdad");
			//instance.newSubject("021", "asdasdasd");
			
			instance.newMaterial(Document.class, Arrays.asList("00100"), "C", "", new GregorianCalendar(), "");
 */
			
		}
		return instance;
	}

	public void setTree(GeneralTree<NodeInfo> tree) {
		this.tree = tree;
	}

	public void setGraph(ILinkedNotDirectedGraph graph) {
		this.graph = graph;
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

	public <E extends Material> E newMaterial(Class<E> typeMaterial, List<String> idList, Object... args) {

		String id = randomMaterialId();
		List<Object> arg = new ArrayList<>();
		arg.add(id);
		arg.addAll(Arrays.asList(args));
		args = arg.toArray();

		@SuppressWarnings("rawtypes")
		Class[] parameterTypes = new Class[args.length];
		for (int i = 0; i < args.length; i++) {
			parameterTypes[i] = args[i].getClass();
		}

		Constructor<E> constructor = null;
		E info = null;
		try {

			constructor = typeMaterial.getConstructor(parameterTypes);
			info = constructor.newInstance(args);

		} catch (Exception e) {
			e.printStackTrace();
		}

		for (Vertex vertex : graph.getVerticesList()) {
			Object vertexInfo = vertex.getInfo();
			if (vertexInfo instanceof Material material && material.getAuthor().equalsIgnoreCase(info.getAuthor())
					&& material.getTittle().equalsIgnoreCase(info.getTittle())
					&& material.getDateCreation().equals(info.getDateCreation()))
				throw new ExistingElementException("Ya existe el Material: " + info.getTittle());
		}

		graph.insertVertex(info);
		int posHead = getVertexIndexById(info.getId());
		for (String ids : idList) {
			int posTail = getVertexIndexById(ids);
			graph.insertEdgeNDG(posTail, posHead);
		}

		return info;
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
		boolean check = false;
		while (i < 100 && !check) {
			String id = String.format("%02d", i);
			boolean stop = false;
			Iterator<NodeInfo> it = instance.tree.getSonsInfo(getYearNode(yearId)).iterator();
			// Itera sobre los hijos hasta encontrar el primer ID de carrera disponible
			while (!stop && it.hasNext()) {
				Subject subject = (Subject) it.next();
				if (Integer.parseInt(subject.getId().substring(3, 5)) == i) {
					stop = true;
					i++;
				}
			}

			if (!stop) {
				check = true;
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

		BinaryTreeNode<NodeInfo> res = null;
		InBreadthIteratorWithLevels<NodeInfo> it = tree.inBreadthIteratorWithLevels();
		while (res == null && it.hasNext()) {
			BreadthNode<NodeInfo> node = it.nextNodeWithLevel();
			NodeInfo info = node.getNode().getInfo();
			if (node.getLevel() == 2 && ((Year) info).getId().equals(id)) {
				res = node.getNode();
			}
		}

		return res;
	}

	public BinaryTreeNode<NodeInfo> getSubjectNode(String id) {

		BinaryTreeNode<NodeInfo> res = null;
		InBreadthIteratorWithLevels<NodeInfo> it = tree.inBreadthIteratorWithLevels();
		while (res == null && it.hasNext()) {
			BreadthNode<NodeInfo> node = it.nextNodeWithLevel();
			NodeInfo info = node.getNode().getInfo();
			if (node.getLevel() == 3 && ((Subject) info).getId().equals(id)) {
				res = node.getNode();
			}
		}

		return res;
	}

	public Vertex getMaterialVertex(String id) {

		Vertex res = null;
		for (Vertex vertex : graph.getVerticesList()) {
			if (vertex.getInfo() instanceof Material material && material.getId().equals(id))
				res = vertex;
		}

		return res;
	}

	private Vertex addSubjectToGraph(Subject subject) {
		Vertex esc = new Vertex(subject);

		LinkedList<Vertex> vertexList = graph.getVerticesList();
		Iterator<Vertex> iter = vertexList.iterator();
		boolean find = false;
		while (iter.hasNext() && !find) {
			Vertex help = iter.next();
			Object info = help.getInfo();
			if (info instanceof Subject subj && subj.getId().equals(subject.getId())) {
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
	public AuxiliarySubjectMostMaterialUse subjectsMostMaterialUse() {
		// aqui se crea la lista de salida
		List<SubAuxiliary> escLits = new LinkedList<SubAuxiliary>();
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
			if (help instanceof Subject subject) {
				// se obtiene el grado del vertice
				int grade = graph.degreeND(cont);
				// se revisa si es mayor que la cantidad de materiales
				if (grade > max) {
					// si es mayor se reinicia la lista se añade el subject
					// y se actualiza la cantidad de materiales
					max = grade;
					Auxiliary aux = findInfoSubjcetId(((Subject) help).getId());
					escLits.clear();
					escLits.add(new SubAuxiliary(subject, (Carreer) aux.getCarrerNode().getInfo(),
							(Year) aux.getYearNode().getInfo()));

				} else if (grade == max) {
					// si es igual se añade el subject a la lista

					Auxiliary aux = findInfoSubjcetId(((Subject) help).getId());
					escLits.add(new SubAuxiliary(subject, (Carreer) aux.getCarrerNode().getInfo(),
							(Year) aux.getYearNode().getInfo()));
				}

			}

			cont++;
		}
		return new AuxiliarySubjectMostMaterialUse(escLits, max);
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
			if (help instanceof Material material) {
				// se obtiene el grado del vertice
				int grade = graph.degreeND(cont);
				// se revisa si es mayor que la cantidad de materiales
				if (grade > max) {
					// si es mayor se reinicia la lista se añade el subject
					// y se actualiza la cantidad de materiales
					max = grade;
					escList.clear();
					escList.add(material);
				} else if (grade == max) {
					// si es igual se añade el subject a la lista
					escList.add(material);
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

					String test2 = ((Subject) edge.getVertex().getInfo()).getId();
					Auxiliary auxiliary = findInfoSubjcetId(test2);
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

	/*
	 * public Auxiliary findInfoSubjcetId(String id) { Auxiliary aux = new
	 * Auxiliary(); // cambie aqui String carreer = id.substring(0, 2); int year =
	 * Integer.parseInt(id.substring(2, 3));
	 * 
	 * List<BinaryTreeNode<NodeInfo>> list =
	 * instance.tree.getSons((BinaryTreeNode<NodeInfo>) instance.tree.getRoot());
	 * ListIterator<BinaryTreeNode<NodeInfo>> it = list.listIterator(); boolean
	 * found = false; while (!found && it.hasNext()) { BinaryTreeNode<NodeInfo> node
	 * = it.next(); if (node.getInfo().getId().equals(carreer)) {
	 * aux.setCarrerNode(node); List<BinaryTreeNode<NodeInfo>> years =
	 * instance.tree.getSons(node); ListIterator<BinaryTreeNode<NodeInfo>> iter =
	 * years.listIterator(); while (!found && iter.hasNext()) { node = iter.next();
	 * int number = ((Year) node.getInfo()).getNumberYear(); if (number == year) {
	 * aux.setYearNode(node); found = true; } }
	 * 
	 * }
	 * 
	 * }
	 * 
	 * return aux; }
	 */

	public Auxiliary findInfoSubjcetId(String id) {
		Auxiliary auxEsc = new Auxiliary();
		// BinaryTreeNode<NodeInfo> carrerNode =
		// ((BinaryTreeNode<NodeInfo>)tree.getRoot()).getLeft();
		BinaryTreeNode<NodeInfo> carrerNode = new BinaryTreeNode<NodeInfo>();
		BinaryTreeNode<NodeInfo> yearNode = new BinaryTreeNode<NodeInfo>();

		boolean found = false;
		InDepthIterator<NodeInfo> iter = tree.inDepthIterator();
		while (!found && iter.hasNext()) {
			BinaryTreeNode<NodeInfo> nodeiter = iter.nextNode();
			NodeInfo info = nodeiter.getInfo();
			if (info instanceof Carreer) {
				carrerNode = nodeiter;
			} else if (info instanceof Year) {
				yearNode = nodeiter;
			} else if (info instanceof Subject && info.getId().equals(id)) {
				found = true;
				auxEsc.setCarrerNode(carrerNode);
				auxEsc.setYearNode(yearNode);
			}
		}
		return auxEsc;
	}

	// este metodo devuelve toda la informacion de los materiales de una carrera
	// es decir devuelve cada material la cantidad de veces que se utiliza en la
	// carrera
	// para cada subject diferente
	public List<AuxiliarInfo> getAllMaterialAndUseCountOfOneCarrer(Carreer carreer) {
		List<AuxiliarInfo> escList = new LinkedList<>();

		LinkedList<Vertex> vertList = graph.getVerticesList();
		Iterator<Vertex> iter = vertList.iterator();
		while (iter.hasNext()) {
			Vertex vert = iter.next();
			NodeInfo vertInfo = (NodeInfo) vert.getInfo();
			if (vertInfo instanceof Material material) {

				LinkedList<Edge> subjectsList = vert.getEdgeList();
				Iterator<Edge> iterEdge = subjectsList.iterator();

				while (iterEdge.hasNext()) {
					Edge edge = iterEdge.next();

					Auxiliary auxiliary = findInfoSubjcetId(((Subject) edge.getVertex().getInfo()).getId());
					if (auxiliary.getCarrerNode().getInfo().getId().equals(carreer.getId())) {
						AuxiliarInfo auxAdd = new AuxiliarInfo(carreer, (Subject) edge.getVertex().getInfo(),
								(Year) auxiliary.getYearNode().getInfo(), material);
						escList.add(auxAdd);

					}
				}
			}
		}

		return escList;
	}

	// este metodo solo devuelve los materiales de una carrera en especifico
	public List<Material> getAllMaterialOfOneCarreer(Carreer carreer) {
		List<Material> escList = new LinkedList<>();

		LinkedList<Vertex> vertList = graph.getVerticesList();
		Iterator<Vertex> iter = vertList.iterator();
		while (iter.hasNext()) {
			Vertex vert = iter.next();
			NodeInfo vertInfo = (NodeInfo) vert.getInfo();
			if (vertInfo instanceof Material material) {

				LinkedList<Edge> subjectsList = vert.getEdgeList();
				Iterator<Edge> iterEdge = subjectsList.iterator();
				boolean inCarrer = false;
				while (!inCarrer && iterEdge.hasNext()) {
					Edge edge = iterEdge.next();

					Auxiliary auxiliary = findInfoSubjcetId(((Subject) edge.getVertex().getInfo()).getId());
					if (auxiliary.getCarrerNode().getInfo().getId().equals(carreer.getId())) {
						inCarrer = true;
						escList.add(material);
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
		while (iter.hasNext()) {
			Vertex vert = iter.next();

			if (vert.getInfo() instanceof Material material) {

				LinkedList<Edge> subjectsList = vert.getEdgeList();
				Iterator<Edge> iterEdge = subjectsList.iterator();
				boolean inCarrerAndYear = false;
				while (!inCarrerAndYear && iterEdge.hasNext()) {
					Edge edge = iterEdge.next();

					Auxiliary auxiliary = findInfoSubjcetId(((Subject) edge.getVertex().getInfo()).getId());
					if (auxiliary.getCarrerNode().getInfo().getId().equals(carreer.getId())
							&& auxiliary.getYearNode().getInfo().getId().equals(year.getId())) {
						inCarrerAndYear = true;
						escList.add(material);
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
			if (vertInfo instanceof Subject subj && subj.getId().equals(subject.getId())) {
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
	// devuelve todos los materiales que no usa un subject
	public List<Material> getAllMaterialOfNotUseSubject(Subject subject) {
		List<Material> escList = new LinkedList<>();

		
		LinkedList<Vertex> vertList = graph.getVerticesList();
		Iterator<Vertex> iter = vertList.iterator();

		LinkedList<Vertex> help = new LinkedList<Vertex>();
		Vertex subjectVert = new Vertex(null);
		boolean find = false;
		while (!find && iter.hasNext()) {
			Vertex vertIter = iter.next();
			Object vertInfo = vertIter.getInfo();
			if (vertInfo instanceof Subject  && ((Subject)vertInfo).getId().equals(subject.getId())) {
					subjectVert = vertIter;
					help = vertIter.getAdjacents();
				}

				find = true;
			
		}
		Iterator<Vertex> iter2 = vertList.iterator();
		while ( iter2.hasNext()) {
			Vertex vertIter = iter2.next();
			Object vertInfo = vertIter.getInfo();
			if (vertInfo instanceof Material subj && !help.contains(vertIter)) {
				escList.add(subj);
			}
			
		}
		return escList;
	}
	

	// este metodo devuelve todos los subjects que utilizan un material
	public List<Subject> getAllSubjectOfMaterial(Material material) {
		List<Subject> escList = new LinkedList<>();
		LinkedList<Vertex> vertList = graph.getVerticesList();
		Iterator<Vertex> iter = vertList.iterator();

		boolean find = false;
		while (!find && iter.hasNext()) {
			Vertex vertIter = iter.next();
			Object vertInfo = vertIter.getInfo();
			if (vertInfo instanceof Material mater && mater.getId().equals(material.getId())) {
				find = true;
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

		int indexMaterialDelete = getVertexIndexById(materialDlete.getId());
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
			if ((vertInfo instanceof Subject subject && subject.getId().equals(id))
					|| (vertInfo instanceof Material material && material.getId().equals(id))) {
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

	// este metodo elimina un subject del grafo
	// asume que si existe un material que solo se use en dicha asignatura entonces
	// elimina el material tambien

	public void deleteSubjectGraph(Subject subjectDelete) {

		int indexMaterialDelete = getVertexIndexById(subjectDelete.getId());
		LinkedList<Vertex> vertList = graph.getVerticesList();
		Vertex vertSubjectDelete = vertList.get(indexMaterialDelete);
		LinkedList<Vertex> adjacentsList = vertSubjectDelete.getAdjacents();
		Iterator<Vertex> iterAdjacents = adjacentsList.iterator();

		while (iterAdjacents.hasNext()) {

			Vertex vertIter = iterAdjacents.next();
			int indexVert = vertList.indexOf(vertIter);

			if (graph.degreeND(indexVert) == 1) {
				graph.deleteVertex(indexVert);
			}

		}
		graph.deleteVertex(indexMaterialDelete);

	}

	// este metodo para eliminar un año determinado para una carrera determinada
	// tengo dudas de como implementaro
	public void deleteYearCarrear(Year year) {
		BinaryTreeNode<NodeInfo> carrerNode = ((BinaryTreeNode<NodeInfo>) tree.getRoot()).getLeft();
		boolean found = false;
		BinaryTreeNode<NodeInfo> yearNode = new BinaryTreeNode<NodeInfo>();
		while (!found && carrerNode != null) {
			BinaryTreeNode<NodeInfo> yearNodeIter = carrerNode.getLeft();
			while (!found && yearNodeIter != null) {
				if (yearNodeIter.getInfo().getId().equals(year.getId())) {
					found = true;
					yearNode = yearNodeIter;
					yearNodeIter = yearNodeIter.getRight();

					while (yearNodeIter != null) {
						((Year) yearNodeIter.getInfo())
								.setNumberYear(((Year) yearNodeIter.getInfo()).getNumberYear() - 1);

						yearNodeIter = yearNodeIter.getRight();
					}

					BinaryTreeNode<NodeInfo> subject = yearNode.getLeft();
					while (subject != null) {
						deleteSubjectGraph((Subject) subject.getInfo());
						subject = subject.getRight();
					}

				} else {
					yearNodeIter = yearNodeIter.getRight();

				}
			}

			if (found) {
				((Carreer) carrerNode.getInfo()).setDuration(((Carreer) carrerNode.getInfo()).getDuration() - 1);
			}
			carrerNode = carrerNode.getRight();

		}

		tree.deleteNode(yearNode);
	}

	// para eliminar toda una carrera promero hay que eliminar todas las asignaturas
	// y
	// materiales que tiene esa carrera
	public void deleteCarrer(Carreer carrer) {

		BinaryTreeNode<NodeInfo> carrerNode = getCarreerNode(carrer.getId());

		BinaryTreeNode<NodeInfo> year = carrerNode.getLeft();

		while (year != null) {
			BinaryTreeNode<NodeInfo> subject = year.getLeft();
			deleteYearCarrear((Year) year.getInfo());
			year = year.getRight();
		}
		tree.deleteNode(carrerNode);

	}

	public List<Carreer> getAllCarrer() {
		BinaryTreeNode<NodeInfo> node = (BinaryTreeNode<NodeInfo>) tree.getRoot();
		List<Carreer> escList = new LinkedList<Carreer>();
		node = node.getLeft();

		while (node != null) {
			escList.add((Carreer) node.getInfo());
			node = node.getRight();

		}

		return escList;
	}

	public List<Year> getAllYearOfCarrer(Carreer carreer) {
		List<Year> escList = new LinkedList<>();
		BinaryTreeNode<NodeInfo> node = getCarreerNode(carreer.getId());

		node = node.getLeft();

		while (node != null) {
			escList.add((Year) node.getInfo());

			node = node.getRight();

		}

		return escList;

	}

	public List<Subject> getAllSubjectsFromYear(String id) {
		List<Subject> res = new ArrayList<>();
		BinaryTreeNode<NodeInfo> yearNode = getYearNode(id);
		for (BinaryTreeNode<NodeInfo> node : tree.getSons(yearNode)) {
			res.add((Subject) node.getInfo());
		}
		return res;
	}

	public List<Material> getAllMaterials() {

		List<Material> res = new ArrayList<>();
		for (Vertex vertex : graph.getVerticesList()) {
			if (vertex.getInfo() instanceof Material material)
				res.add(material);

		}
		return res;
	}

	public List<Subject> getAllSubjects() {

		List<Subject> res = new LinkedList<Subject>();
		InBreadthIteratorWithLevels<NodeInfo> it = tree.inBreadthIteratorWithLevels();
		boolean stop = false;
		while (!stop && it.hasNext()) {
			BreadthNode<NodeInfo> breathNode = it.nextNodeWithLevel();
			int level = breathNode.getLevel();
			if (level > 3)
				stop = true;

			if (level == 3) {
				res.add((Subject) breathNode.getInfo());
			}
		}

		return res;
	}

	public void addRelation(String subjectId, String materialId) {
		List<Vertex> vertList = graph.getVerticesList();
		Iterator<Vertex> iter = vertList.iterator();

		int index = 0;
		int subject = -1;
		int material = -1;
		while ((subject == -1 && material == -1) && iter.hasNext()) {
			Vertex vertIter = iter.next();
			Object info = vertIter.getInfo();
			if (info instanceof Material mat && mat.getId().equals(materialId)) {
				material = index;
			} else if (info instanceof Subject subj && subj.getId().equals(subjectId)) {
				subject = index;
			}
			index++;
		}
		graph.insertEdgeNDG(subject, material);
	}

	public void deleteRelation(String subjectId, String materialId) {
		List<Vertex> vertList = graph.getVerticesList();
		Iterator<Vertex> iter = vertList.iterator();

		int index = 0;
		int subject = -1;
		int material = -1;
		while ((subject == -1 && material == -1) && iter.hasNext()) {
			Vertex vertIter = iter.next();
			Object info = vertIter.getInfo();
			if (info instanceof Material mat && mat.getId().equals(materialId)) {
				if (vertIter.getAdjacents().size() == 1) {
					material = -2;
				} else {
					material = index;

				}
			} else if (info instanceof Subject subj && subj.getId().equals(subjectId)) {
				subject = index;
			}
			index++;
		}
		if (material != -2) {
			graph.deleteEdgeND(subject, material);
		}

	}

	public static void inicializacion(){
		Bookcase bookcase = Bookcase.getInstance();  //en bookcase ya hay una carrera por eso empiezo en "01"

		bookcase.getTree().setRoot(new BinaryTreeNode<NodeInfo>(new University("00000000000000000","CUJAE")));

	// Carrera 1
		bookcase.newCarreer("Informatica", 4);  //Cogigo de carrera "00" Codigo de los años de la carrera es "011","012"."013"."014"

    // Asignaturas 1erAnno
	    bookcase.newSubject("001", "Calculo1");
		bookcase.newSubject("001", "Filosofia");		
		bookcase.newSubject("001", "Matematica Computacional");

		//2do anno
		bookcase.newSubject("002", "Historia");
		bookcase.newSubject("002", "Calculo2");
		bookcase.newSubject("002", "Fisica");
		//3ro anno
		bookcase.newSubject("003", "BD");
		bookcase.newSubject("003", "RA");
		bookcase.newSubject("003", "TP");
		//4to anno
		bookcase.newSubject("004", "Calculo3");
		bookcase.newSubject("004", "Economia Politica");
		bookcase.newSubject("004", "Economia Empresarial");
		
		
	// Materiales 1er Anno Calculo1
	bookcase.newMaterial(Book.class, Arrays.asList("00100"),"Stewart","Anonimo",new GregorianCalendar(2014,2,12),"Felix Varela","1ra","2001");
	bookcase.newMaterial(Document.class, Arrays.asList("00100"),"Resumenes de Calculo1","Anonimo",new GregorianCalendar(2014,2,12), ".doc");
	bookcase.newMaterial(Book.class, Arrays.asList("00100"),"Algebra Lineal","Anonimo",new GregorianCalendar(2014,2,12),"Felix Varela","3ra","2001");
	// Materiales 1er Anno Filosofia
	bookcase.newMaterial(Book.class, Arrays.asList("00101"),"Marxismo","Anonimo",new GregorianCalendar(2014,2,12),"Carlos Varela","2da","2002");
	bookcase.newMaterial(Document.class, Arrays.asList("00101"),"Guias para Parciales ?","Titulo2",new GregorianCalendar(2014,2,12), ".pdf");
	bookcase.newMaterial(Book.class, Arrays.asList("00101"),"Socialismo","Anonimo",new GregorianCalendar(2014,2,12),"Carlos Varela","2da","2004");
	// Materiales 1er Anno MC
	bookcase.newMaterial(Book.class, Arrays.asList("00102"),"Matematica Computacional 1","Mark Allen Weiss",new GregorianCalendar(2014,2,12),"Felix Varela","3ra","2001");
	bookcase.newMaterial(Document.class, Arrays.asList("00102"),"Compendio de resumenes","Profesor Eresto",new GregorianCalendar(2014,2,12), ".pdf");
	bookcase.newMaterial(Book.class, Arrays.asList("00102"),"Matematica Computacional 2","William Stallings",new GregorianCalendar(2014,2,12),"Felix Varela","3ra","2001");
	// Materiales 2do Anno Historia
	bookcase.newMaterial(Exercices.class, Arrays.asList("00200"),"Folleto","William S",new GregorianCalendar(2014,2,12), 12 ,"Tipe1" );
    bookcase.newMaterial(Document.class, Arrays.asList("00200"),"Documentales por ver","Carlos Antonio",new GregorianCalendar(2014,2,12), ".mp4");
	bookcase.newMaterial(Book.class, Arrays.asList("00200"),"Hisoria de Cuba ","James Monte",new GregorianCalendar(2014,2,12),"Felix Varela","1ra","2001");
	// Materiales 2do Anno Calculo2
	bookcase.newMaterial(Book.class, Arrays.asList("00201"),"Trascendentes Tempranas de James Stewart","James Stewart",new GregorianCalendar(2014,2,12),"Felix Varela","1ra","2001");
	bookcase.newMaterial(Document.class, Arrays.asList("00201"),"Resumenes de Calculo1","Profesor Ester",new GregorianCalendar(2014,2,12), ".ppt");
	bookcase.newMaterial(Book.class, Arrays.asList("00201"),"Ecuaciones Diferenciales con Aplicaciones Parte I","Zill",new GregorianCalendar(2014,2,12),"Felix Varela","1ra","2001");
	// Materiales 2do Anno Fisica
	bookcase.newMaterial(Exercices.class, Arrays.asList("00202"),"Ejercicios de Fisica","Profesor Antonio",new GregorianCalendar(2014,2,12), 4 ,".doc" );
    bookcase.newMaterial(Document.class, Arrays.asList("00202"),"Documnetos Utiles","Profesor Manuel",new GregorianCalendar(2014,2,12), "pdf");
	bookcase.newMaterial(Book.class, Arrays.asList("00202"),"Fisica","Johnsonbaugh",new GregorianCalendar(2014,2,12),"Felix Varela","3ra","2001");
	// Materiales 3er Anno BD
	bookcase.newMaterial(Book.class, Arrays.asList("00300"),"C/C++ Tomo I","Anonimo",new GregorianCalendar(2014,2,12),"Felix Varela","1ra","2002");
	bookcase.newMaterial(Document.class, Arrays.asList("0130"),"Listas de libros","Profesor Maria",new GregorianCalendar(2014,2,12), ".excel");
	bookcase.newMaterial(Book.class, Arrays.asList("00300"),"C/C++ Tomo II","Anonimo",new GregorianCalendar(2014,2,12),"Felix Varela","1ra","2002");
	// Materiales 3er Anno RA
	bookcase.newMaterial(Book.class, Arrays.asList("00301"),"Estructura de Datos en Java Volumen I","Mark Allen Weiss",new GregorianCalendar(2014,2,12),"Felix Varela","3ra","2001");
	bookcase.newMaterial(Document.class, Arrays.asList("01301"),"Conferncias","Profesor Leonardo",new GregorianCalendar(2014,2,12), ".ppt");
	bookcase.newMaterial(Book.class, Arrays.asList("00301"),"Estructura de Datos en Java Volumen II","Mark Allen Weiss",new GregorianCalendar(2014,2,12),"Felix Varela","2ra","2001");
	// Materiales 3er Anno TP
	bookcase.newMaterial(Book.class, Arrays.asList("00302"),"Quimica General","Anonimo",new GregorianCalendar(2014,2,12),"Felix Varela","2ra","2001");
	bookcase.newMaterial(Document.class, Arrays.asList("01302"),"Conferncias","Lpru.orp Alberto",new GregorianCalendar(2014,2,12), ".ppt");
	bookcase.newMaterial(Book.class, Arrays.asList("00302"),"Quimica General tomo II","Anonimo",new GregorianCalendar(2014,2,12),"Felix Varela","2ra","2001");
	// Materiales 4to Anno Calculo3
	bookcase.newMaterial(Exercices.class, Arrays.asList("00400"),"Folleto","Profesor Manuel",new GregorianCalendar(2014,2,12), 15 ,".doc" );
    bookcase.newMaterial(Document.class, Arrays.asList("00400"),"Conferncias","Manuel",new GregorianCalendar(2014,2,12), "ppt");
	// Materiales 4to Anno Economia Politica
	bookcase.newMaterial(Exercices.class, Arrays.asList("00401"),"Folleto","Manuel Carlos",new GregorianCalendar(2014,2,12), 16 ,".excel" );
    bookcase.newMaterial(Document.class, Arrays.asList("00401"),"Conferncias","Fuanito",new GregorianCalendar(2014,2,12), ".ppt");
	bookcase.newMaterial(Book.class, Arrays.asList("00401"),"Marxismo","Zell Sack",new GregorianCalendar(2014,2,12),"Felix Varela","2da","2001");
	// Materiales 4to Anno Economia Empresarial
	bookcase.newMaterial(Exercices.class, Arrays.asList("00402"),"Ejecicios de clase","Pedro M",new GregorianCalendar(2014,2,12), 17 ,".doc" );
    bookcase.newMaterial(Document.class, Arrays.asList("00402"),"Conferencias","Pedro C",new GregorianCalendar(2014,2,12), ".ppt");
	bookcase.newMaterial(Book.class, Arrays.asList("00402"),"Economia","Anonimo",new GregorianCalendar(2014,2,12),"Felix Varela","2ra","2001");
	
	// Carrera 2
	bookcase.newCarreer("Mecanica", 4);  //Cogigo de carrera "01" Codigo de los años de la carrera es "021","022"."023"."024"

    // Asignaturas 1erAnno
	    bookcase.newSubject("011", "ResistenciaM");
		bookcase.newSubject("011", "Calculo1");
		bookcase.newSubject("011", "Seguridad Nacional");
		//2do anno
		bookcase.newSubject("012", "MaquinasA");
		bookcase.newSubject("012", "Calculo2");
		bookcase.newSubject("012", "Economia Empresarial");
		//3ro anno
		bookcase.newSubject("013", "Termodinamica");
		bookcase.newSubject("013", "Fisica");
		bookcase.newSubject("013", "Calculo3");

	// Materiales 1er Anno ResistenciaM	
	bookcase.newMaterial(Book.class, Arrays.asList("01100"),"Resistencia I","Anonimo",new GregorianCalendar(2014,2,12),"Felix Varela","1ra","2001");
	bookcase.newMaterial(Document.class, Arrays.asList("01100"),"Conferencias","Pedro C",new GregorianCalendar(2014,5,12), ".ppt");
	bookcase.newMaterial(Book.class, Arrays.asList("01100"),"Resistencia I","Anonimo",new GregorianCalendar(2014,5,12),"Felix Varela","1ra","2001");
	// Materiales 1er Anno Calculo1
	bookcase.newMaterial(Book.class, Arrays.asList("01101"),"Stewart","Anonimo",new GregorianCalendar(2014,5,12),"Felix Varela","1ra","2001");
	bookcase.newMaterial(Document.class, Arrays.asList("01101"),"Resumenes de Calculo1","Anonimo",new GregorianCalendar(2014,5,12), ".doc");
	bookcase.newMaterial(Book.class, Arrays.asList("01101"),"Algebra Lineal","Anonimo",new GregorianCalendar(2014,5,12),"Felix Varela","3ra","2001");
	// Materiales 1er Anno Seguridad Nacional
	bookcase.newMaterial(Book.class, Arrays.asList("01102"),"Seguridad y Defensa Nacional","Anonimo",new GregorianCalendar(2014,5,12),"Felix Varela","1ra","2001");
	bookcase.newMaterial(Document.class, Arrays.asList("01102"),"Conferencias","Anonimo",new GregorianCalendar(2014,5,12), "ppt");
	// Materiales 2do Anno MaquinasA
	bookcase.newMaterial(Exercices.class, Arrays.asList("01200"),"Ejercicios","Antonio",new GregorianCalendar(2014,5,12), 6 ,".doc" );
    bookcase.newMaterial(Document.class, Arrays.asList("01200"),"Conferncias","Xavier M",new GregorianCalendar(2014,5,12), "ppt");
	bookcase.newMaterial(Book.class, Arrays.asList("01200"),"Maquinas Automotris ","Anonimo",new GregorianCalendar(2014,5,12),"Felix Varela","3ra","2001");
	// Materiales 2do Anno Calculo2
	bookcase.newMaterial(Book.class, Arrays.asList("01201"),"Trascendentes Tempranas de James Stewart","James Stewart",new GregorianCalendar(2014,5,12),"Felix Varela","1ra","2001");
	bookcase.newMaterial(Document.class, Arrays.asList("01201"),"Resumenes de Calculo1","Profe Ester",new GregorianCalendar(2014,5,12), ".ppt");
	bookcase.newMaterial(Book.class, Arrays.asList("01201"),"Ecuaciones Diferenciales con Aplicaciones Parte I","Zill",new GregorianCalendar(2014,5,12),"Felix Varela","1ra","2001");
	// Materiales 2do Anno Economia Empresarial
	bookcase.newMaterial(Exercices.class, Arrays.asList("01202"),"Ejecicios de clase","Pedro M",new GregorianCalendar(2014,5,12), 17 ,".doc" );
	bookcase.newMaterial(Book.class, Arrays.asList("01202"),"Economia","Anonimo",new GregorianCalendar(2014,5,12),"Felix Varela","2ra","2001");
	// Materiales 3er Anno Termodinamica
	bookcase.newMaterial(Book.class, Arrays.asList("01300"),"Termodinamica I","Anonimo",new GregorianCalendar(2014,5,12),"Felix Varela","2ra","2001");
	bookcase.newMaterial(Document.class, Arrays.asList("01300"),"id7 ?","Guia Estudio",new GregorianCalendar(2014,5,12), ".doc");
	bookcase.newMaterial(Book.class, Arrays.asList("01300"),"Termodinamica II","Anonimo",new GregorianCalendar(2014,5,12),"Felix Varela","2ra","2001");
	// Materiales 3er Anno Fisica
	bookcase.newMaterial(Exercices.class, Arrays.asList("01301"),"Ejercicios de Fisica","Profesor Antonio",new GregorianCalendar(2014,5,12), 4 ,".doc" );
    bookcase.newMaterial(Document.class, Arrays.asList("01301"),"Documnetos Utiles","Profesor Manuel",new GregorianCalendar(2014,5,12), "pdf");
	bookcase.newMaterial(Book.class, Arrays.asList("01301"),"Fisica","Johnsonbaugh",new GregorianCalendar(2014,5,12),"Felix Varela","3ra","2001");
	// Materiales 3er Anno Calculo3
	bookcase.newMaterial(Book.class, Arrays.asList("01302"),"Algebra Lineal I","Anonimo",new GregorianCalendar(2014,5,12),"Felix Varela","3ra","2001");
	bookcase.newMaterial(Document.class, Arrays.asList("01302"),"Conferencias","Roberto C",new GregorianCalendar(2014,5,12), "ppt");
	bookcase.newMaterial(Book.class, Arrays.asList("01302"),"Algebra Lineal II","Anonimo",new GregorianCalendar(2014,5,12),"Felix Varela","3ra","2001");
	
	
	// Carrera 3
	bookcase.newCarreer("Industrial", 3);  //Cogigo de carrera "02" Codigo de los años de la carrera es "031","032"."033".

    // Asignaturas 1erAnno
	    bookcase.newSubject("021", "Ingeniería industrial");
		bookcase.newSubject("021", "Modelacion Organizacional");
		bookcase.newSubject("021", "Calculo1");
		//2do anno
		bookcase.newSubject("022", "Procesos tecnológicos");
		bookcase.newSubject("022", "Calculo2");
		bookcase.newSubject("022", "Fisica");
		//3ro anno
		bookcase.newSubject("023", "Desarrollo de Sistemas Informáticos");
		bookcase.newSubject("023", "Calculo3");
		
	// Materiales 1er Anno Ingeniería industrial
	bookcase.newMaterial(Book.class, Arrays.asList("02100"),"Quimica General","Anonimo",new GregorianCalendar(2014,5,12),"Felix Varela","3ra","2001");
	// Materiales 1er Anno Modelacion Organizacional
	bookcase.newMaterial(Document.class, Arrays.asList("02101"),"Conferencias","Garcias",new GregorianCalendar(2014,5,12), "ppt");
	// Materiales 1er Anno Calculo1
	bookcase.newMaterial(Document.class, Arrays.asList("02102"),"id1 ?","Resumenes de Calculo1",new GregorianCalendar(2014,5,12), ".doc");
	// Materiales 2do Anno Procesos tecnológicos
	bookcase.newMaterial(Exercices.class, Arrays.asList("02200"),"Guia de Ejercicios","Anonimo",new GregorianCalendar(2014,5,12), 12 ,".doc" );
	// Materiales 2do Anno Calculo2
	// Materiales 2do Anno Fisica
	// Materiales 3er Anno Desarrollo de Sistemas Informáticos
	bookcase.newMaterial(Book.class, Arrays.asList("02300"),"C/C++ Tomo I","Anonimo",new GregorianCalendar(2014,5,12),"Felix Varela","1ra","2002");
	bookcase.newMaterial(Document.class, Arrays.asList("02300"),"Conferncias","Anonimo",new GregorianCalendar(2014,5,12), ".ppt");
	// Materiales 3er Anno Calculo3
	


	}
	
	
}
