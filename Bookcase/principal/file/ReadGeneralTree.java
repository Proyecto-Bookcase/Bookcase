package file;

import java.io.File;
import java.io.RandomAccessFile;
import java.util.ArrayList;

import cu.edu.cujae.ceis.tree.binary.BinaryTreeNode;
import cu.edu.cujae.ceis.tree.general.GeneralTree;
import cu.edu.cujae.ceis.tree.iterators.general.InBreadthIterator;

public class ReadGeneralTree<E> {

    private GeneralTree<E> tree;
    private File filePath;

    public ReadGeneralTree(File filePath) {
        this.filePath = filePath;
        generateTree();
    }

    /**
     * Lee un fichero y devuelve una lista con la información en el orden en el que
     * estaba en el fichero.
     * 
     * @param filePath Ruta del fichero que se va a leer
     * @return Lista con la información en el orden en el que estaba en el fichero
     */
    private ArrayList<InfoReaded<E>> readFile() {
        ArrayList<InfoReaded<E>> res = new ArrayList<>();
        try (RandomAccessFile file = new RandomAccessFile(filePath, "r")) {
            // Lee el número total de nodos en el fichero
            int totalNodes = file.readInt();
            // Itera sobre cada nodo en el fichero
            for (int i = 0; i < totalNodes; i++) {
                // Lee el tamaño de la información del nodo
                int tamInfo = file.readInt();
                // Lee los bytes de la información y los convierte a un objeto
                byte[] infoBytes = new byte[tamInfo];
                file.read(infoBytes);
                E info = (E) Convert.toObject(infoBytes);
                // Lee el hijo derecho del nodo y si es una hoja
                int rightSon = file.readInt();
                boolean isLeaf = file.readBoolean();
                // Agrega la información leída a la lista de resultados
                res.add(new InfoReaded<E>(info, rightSon, isLeaf));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return res;
    }

    /**
     * Construye el árbol a partir de la información del archivo que se encuentra en
     * la ruta filePath.
     * 
     * @return El árbol generado.
     */
    public GeneralTree<E> generateTree() {
        tree = new GeneralTree<>();
        ArrayList<InfoReaded<E>> list = readFile();
        BinaryTreeNode<E> padre = null;

        // Itera a través de la lista de objetos InfoReaded
        for (InfoReaded<E> infoReaded : list) {
            E info = infoReaded.getInfo();
            BinaryTreeNode<E> node = getNode(info);

            // Crea un nuevo nodo si no existe
            if (node == null) {
                node = new BinaryTreeNode<E>(info);
            }

            int rightSon = infoReaded.getRightSon();

            // Establece el hijo derecho del nodo actual
            if (rightSon >= 0) {
                node.setRight(new BinaryTreeNode<E>(list.get(rightSon).getInfo()));
            }

            // Verifica si el nodo actual es una hoja
            if (infoReaded.isLeaf()) {
                padre = null;
            } else {
                padre = node;
            }

            // Establece la raíz del árbol si está vacío
            if (tree.isEmpty()) {
                tree.setRoot(node);
            }

            // Inserta el nodo en el árbol si hay un nodo padre
            if (padre != null) {
                tree.insertNode(node, padre);
            }
        }

        return tree;
    }

    /**
     * Devuelve el nodo que contiene la información especificada.
     * 
     * @param info la información a buscar en el árbol
     * @return el nodo que contiene la información especificada, o null si no se
     *         encuentra
     */
    private BinaryTreeNode<E> getNode(E info) {
        BinaryTreeNode<E> res = null;
        InBreadthIterator<E> it = tree.inBreadthIterator();
        // Recorre el árbol hasta encontrar el nodo que contiene la información
        // especificada
        while (res == null && it.hasNext()) {
            BinaryTreeNode<E> node = it.nextNode();
            if (node.getInfo().equals(info)) {
                res = node;
            }
        }
        return res;
    }

    // Método para obtener la ruta del archivo
    public File getFilePath() {
        return filePath;
    }

    // Método para establecer la ruta del archivo
    public void setFilePath(File filePath) {
        this.filePath = filePath;
    }

    // Método para obtener el árbol general
    public GeneralTree<E> getTree() {
        return tree;
    }

}