package classes;

import java.util.Iterator;

import cu.edu.cujae.ceis.tree.binary.BinaryTreeNode;
import cu.edu.cujae.ceis.tree.general.GeneralTree;

public class Carreer implements NodeInfo {
	
	private String name;
	private String id;
	private int duration;
	boolean[] years;
	
	protected Carreer(String id, String name, int duration) {
		setId(id);
		setName(name);
		setDuration(duration);
		years = new boolean[10];
	}
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getDuration() {
		return duration;
	}
	public void setDuration(int duration) {
		this.duration = duration;
	}
	public String getId() {
		return id;
	}
	private void setId(String id) {
		this.id = id;
	}
	
	/**
	 * Método para crear un nuevo año académico
	 * Se agrega automáticamente al árbol
	 * @param numberYear número de año académico
	 * @return el nuevo año creado
	 */
	public BinaryTreeNode<NodeInfo> newYear(int numberYear) {
		// Verificar si ya existe el año
		if (years[numberYear]) {
			throw new IllegalArgumentException("Ya existe el Año: " + numberYear);
		}
		// Crea el Id del año
		//Primeos 2 dígitos son la carrera y Tercer dígito el año
		String id = this.id+numberYear;
		// Crear un nodo con el nuevo objeto objeto Year
		BinaryTreeNode<NodeInfo> node = new BinaryTreeNode<NodeInfo>(new Year(id, numberYear));
		// Insertar el nodo en el árbol
		GeneralTree<NodeInfo> tree = Bookcase.getInstance().getTree();
		tree.insertNode(node, node);
		
		tree.
		
//		instance.tree.insertNode(new BinaryTreeNode<NodeInfo>(carreer),
//				(BinaryTreeNode<NodeInfo>) instance.tree.getRoot());
		// Devolver la carrera creada
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
}
