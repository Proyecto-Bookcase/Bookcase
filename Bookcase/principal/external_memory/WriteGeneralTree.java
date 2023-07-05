package external_memory;

import java.io.File;
import java.io.RandomAccessFile;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;

import cu.edu.cujae.ceis.tree.binary.BinaryTreeNode;
import cu.edu.cujae.ceis.tree.general.GeneralTree;
import cu.edu.cujae.ceis.tree.iterators.general.InDepthIterator;

/**
 * La clase WriteGeneralTree es responsable de escribir un objeto GeneralTree en
 * un archivo.
 */
public class WriteGeneralTree<E extends Serializable> {

	private GeneralTree<E> tree;
	private File filePath;

	public WriteGeneralTree(File filePath, GeneralTree<E> tree) {
		this.setFilePath(filePath);
		this.setTree(tree);

	}

	/**
	 * La función devuelve la ruta del archivo.
	 * 
	 * @return El método devuelve un objeto File, que representa la ruta a un
	 *         archivo.
	 */
	public File getFilePath() {
		return filePath;
	}

	/**
	 * La función establece la ruta del archivo para un archivo dado.
	 * 
	 * @param filePath El parámetro filePath es de tipo File, que representa una
	 *                 ruta de archivo en el
	 *                 sistema de archivos.
	 */
	public void setFilePath(File filePath) {
		this.filePath = filePath;
	}

	/**
	 * La función devuelve un objeto GeneralTree.
	 * 
	 * @return El método devuelve un objeto GeneralTree.
	 */
	public GeneralTree<E> getTree() {
		return tree;
	}

	/**
	 * La función establece el valor de la variable "árbol" en el objeto GeneralTree
	 * proporcionado.
	 * 
	 * @param tree El parámetro "árbol" es de tipo GeneralTree<E>, que es una clase
	 *             genérica que
	 *             representa una estructura de datos de árbol general. Se utiliza
	 *             para establecer el valor de la
	 *             variable de instancia "árbol" en la clase actual.
	 */
	public void setTree(GeneralTree<E> tree) {
		this.tree = tree;
	}

	/**
	 * La función writeTree() escribe el árbol binario en un archivo, incluido el
	 * número de nodos, el
	 * valor de cada nodo, el tamaño de cada nodo, la posición del primer hijo y si
	 * el nodo es hoja
	 * izquierdo.
	 */
	public void writeTree() {
		try (RandomAccessFile file = new RandomAccessFile(filePath, "rw")) {
			// Obtener la cantidad de nodos en el árbol
			int cantNodes = tree.totalNodes();
			// Escribir la cantidad de nodos en el archivo
			file.writeInt(cantNodes);
			// Obtener un iterador en profundidad del árbol
			InDepthIterator<E> it = tree.inDepthIterator();
			// Crear una lista para almacenar los nodos en orden de recorrido en profundidad
			List<BinaryTreeNode<E>> list = new ArrayList<>();
			// Agregar cada nodo del iterador a la lista
			while (it.hasNext()) {
				list.add(it.nextNode());
			}
			// Reinicializar el iterador
			it = tree.inDepthIterator();
			// Escribir cada nodo en el archivo

			
			while (it.hasNext()) {
				// Obtener el siguiente nodo del iterador
				BinaryTreeNode<E> node = it.nextNode();
				// Convertir el valor del nodo a bytes
				byte[] byteNode = Convert.toBytes(node.getInfo());
				// Obtener el tamaño en bytes del nodo
				int tamNode = byteNode.length;
				// Escribir el tamaño del nodo en el archivo
				file.writeInt(tamNode);
				// Escribir el valor del nodo en el archivo
				file.write(byteNode);
				// Obtener el nodo derecho del nodo actual
				BinaryTreeNode<E> rightNode = node.getRight();
				// Obtener la posición del primer hijo
				int posFirstChild = -1;
				if (rightNode != null) {
					posFirstChild = list.indexOf(rightNode);
				}
				// Escribir la posición del primer hijo en el archivo
				file.writeInt(posFirstChild);
				// Escribir un booleano indicando si el nodo es hoja
				file.writeBoolean(node.getLeft() == null);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void writeTreeNew() {
		try (RandomAccessFile file = new RandomAccessFile(filePath, "rw")) {
			// Obtener la cantidad de nodos en el árbol
			int cantNodes = tree.totalNodes();
			// Escribir la cantidad de nodos en el archivo
			file.writeInt(cantNodes);
			// Obtener un iterador en profundidad del árbol
			InDepthIterator<E> it = tree.inDepthIterator();
			// Crear una lista para almacenar los nodos en orden de recorrido en profundidad
			List<BinaryTreeNode<E>> list = new ArrayList<>();
			// Agregar cada nodo del iterador a la lista
			while (it.hasNext()) {
				list.add(it.nextNode());
			}
			// Reinicializar el iterador
			it = tree.inDepthIterator();
			// Escribir cada nodo en el archivo

			Iterator<BinaryTreeNode<E>> iter = list.iterator();
			int cont =0;
			while (iter.hasNext()) {
				// Obtener el siguiente nodo del iterador
				BinaryTreeNode<E> node = iter.next();
				// Convertir el valor del nodo a bytes
				byte[] byteNode = Convert.toBytes(node.getInfo());
				// Obtener el tamaño en bytes del nodo
				int tamNode = byteNode.length;
				// Escribir el tamaño del nodo en el archivo
				file.writeInt(tamNode);
				// Escribir el valor del nodo en el archivo
				file.write(byteNode);
				// Obtener el nodo derecho del nodo actual
				BinaryTreeNode<E> rightNode = node.getRight();
				// Obtener la posición del primer hijo
				int posFirstChild = -1;
				if (rightNode != null) {
					posFirstChild = indexRigthBro(list, rightNode, cont);
				}
				// Escribir la posición del primer hijo en el archivo
				file.writeInt(posFirstChild);
				// Escribir un booleano indicando si el nodo es hoja
				file.writeBoolean(node.getLeft() == null);

				cont++;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	//nuevo metodo para buscar el hermano derecho
	//este metod comienza a buscar el nodo a partir de in indice determinado
	private int indexRigthBro(List<BinaryTreeNode<E>> list , BinaryTreeNode<E> search, int start)
	{
		int index = start+1;
		//abrir el iterador en una pos determinada,
		//al recorrer el arbol en preorden siempre el primer hermano derecho estara luedo del indoce del nodo analizado
		//search es el hermano derecho del nodo analizado
		ListIterator<BinaryTreeNode<E>> iter = list.listIterator(index);
		boolean found = false;
		while(!found && iter.hasNext())
		{
			BinaryTreeNode<E> help = iter.next();
			if(help.equals(search))
			{
				found = true;
			}
			else
			{
				index++;
			}

		}
		return index;
	}

}
