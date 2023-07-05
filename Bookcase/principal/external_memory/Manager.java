package external_memory;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.ObjectInputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardCopyOption;

import classes.Bookcase;
import cu.edu.cujae.ceis.graph.LinkedGraph;
import interfaces.NodeInfo;

// Modificador final para que no se pueda heredar de la clase
public final class Manager {

	private static final String TREE_PATH = "Tree.DATA";
	private static final String GRAPH_PATH = "Graph.DATA";
	private static final String INDEX_PATH = "Index.DATA";
	
	
	private static final Bookcase bookcase = Bookcase.getInstance();

	// Constructor privado para que no se pueda instanciar la clase
	private Manager() {
	}

	/**
	 * Carga los datos desde los Ficheros que se encuentran junto al ejecutable. De
	 * no sencontrarse algunos de esos Ficheros o de estar corrompidos, se crearán
	 * Temporales con datos predetermindaos para cargar dichos datos en el programa.
	 */
	@SuppressWarnings("unchecked")
	public static void loadData() {
		
		ReadGeneralTree<NodeInfo> treeReader = new ReadGeneralTree<>(new File(TREE_PATH));
		bookcase.setTree(treeReader.getTree());
		
		ReadLinkedGraph graphReader = new ReadLinkedGraph(new File(GRAPH_PATH), new File(INDEX_PATH));
		bookcase.setGraph(graphReader.getGraph());
		
	}
	
	/**
	 * Guarda los datos del programa en los ficheros que se encuentran junto al
	 * ejecutable. De no existir estos ficheros, se crean automáticamente.
	 */
	public static void guardarDatos() {
		
		
		WriteGeneralTree<NodeInfo> treeWriter = new WriteGeneralTree<>(new File(TREE_PATH), bookcase.getTree());
		WriteLinkedGrah graphWriter = new WriteLinkedGrah(new File(GRAPH_PATH), new File(INDEX_PATH), (LinkedGraph) bookcase.getGraph());
		
		treeWriter.writeTree();
		graphWriter.writeGraph();
		
	}

	/**
	 * Carga la clase que se encuentra dentro de un fichero
	 * 
	 * @param path          Ruta del Fichero que se va a leer
	 * @param alternatePath Ruta del Fichero que se lee en caso de que path no
	 *                      apunte a ningún Fichero
	 * @param extension     Extensión del Fichero que se va a leer
	 * @return Devuelve un Object con la clase leída en el Fichero
	 */
	private static Object loadClass(String path, String alternatePath, String extension) {

		// Contenedor para la clase cargada
		Object object = null;

		FileInputStream fichero = null;
		ObjectInputStream flujo = null;

		// Carga el fichero y un flujo de datos a dicho fichero
		try {

			fichero = new FileInputStream(path);
			flujo = new ObjectInputStream(fichero);

			// Guarda la clase leída en el contenedor
			object = flujo.readObject();

		} catch (IOException e) {
			object = loadClass(alternatePath, extension);
		} catch (ClassNotFoundException e) {
			object = loadClass(alternatePath, extension);
		} finally {

			if (fichero != null && flujo != null) {
				try {
					fichero.close();
					flujo.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}

		}
		return object;
	}

	private static Object loadClass(String alternatePath, String extension) {
		Object object;
		// Entra en caso de que no se encuentre el archivo o éste esté corrupto

		// Ruta del fichero temporal en un String
		String newPath = null;

		// Ruta del fichero temporal
		Path tmpFile = null;

		try {

			// Guarda el Objeto Path
			tmpFile = extractTempFilePath(alternatePath, "temp", extension);

			// Guarda la ruta correspondiente a Path
			newPath = tmpFile.toAbsolutePath().toString();

		} catch (IOException e1) {
			e1.printStackTrace();
		}

		// Guarda la clase leída en el contenedor, pero ahora apuntando a una nueva ruta
		object = loadClass(newPath, alternatePath, extension);

		// Elimina el archivo temporal
		try {
			Files.delete(tmpFile);
		} catch (IOException e2) {
			e2.printStackTrace();
		}
		return object;
	}

	/**
	 * @param resourcepath Ruta del fichero dentro del Programa el cual se va a
	 *                     sacar como un Fichero Temporal
	 * @param filename     Nombre del Fichero temporal
	 * @param extension    Extensión del fichero temporal
	 * @return Devuelve un Objecto Ruta correspondiente a la ruta del Fichero
	 *         Temporal
	 * @throws IOException if an I/O error occurs when reading or writing
	 */
	private static Path extractTempFilePath(String resourcepath, String filename, String extension) throws IOException {

		// Busca el fichero dentro del Programa
		InputStream resourceStream = Manager.class.getResourceAsStream(resourcepath);

		// Crea un archivo temporal
		Path tempFile = Files.createTempFile(filename, extension);

		// Copia el contenido del archivo del Programa dentro del archivo Temporal
		Files.copy(resourceStream, tempFile, StandardCopyOption.REPLACE_EXISTING);

		return tempFile;
	}
}
