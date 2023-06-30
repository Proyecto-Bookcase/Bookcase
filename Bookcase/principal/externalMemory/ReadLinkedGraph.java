package externalMemory;

import java.io.File;
import java.io.RandomAccessFile;
import java.util.ArrayList;

import cu.edu.cujae.ceis.graph.LinkedGraph;

/**
 * The ReadLinkedGraph class is used to read a graph from a file and store it in
 * a LinkedGraph object.
 */
public class ReadLinkedGraph {

    private File filePath;
    private File indexPath;
    private LinkedGraph graph;

    public ReadLinkedGraph(File filePath, File indexPath) {
        this.filePath = filePath;
        this.indexPath = indexPath;
        readGraph();

    }

    // Este método devuelve la ruta del archivo
    public File getFilePath() {
        return filePath;
    }

    // Este método establece la ruta del archivo
    public void setFilePath(File filePath) {
        this.filePath = filePath;
    }

    // Este método devuelve el archivo de índice
    public File getIndexPath() {
        return indexPath;
    }

    // Este método establece el archivo de índice
    public void setIndexPath(File indexFile) {
        this.indexPath = indexFile;
    }

    // Este método devuelve el grafo
    public LinkedGraph getGraph() {
        return graph;
    }

    /**
     * Esta función lee un grafo desde un archivo y devuelve un objeto LinkedGraph.
     * 
     * @return La función devuelve un objeto LinkedGraph.
     */
    public LinkedGraph readGraph() {
        // Crear un nuevo objeto LinkedGraph
        graph = new LinkedGraph();
        // Leer el índice del archivo
        ArrayList<Object> index = readIndex();
        try (RandomAccessFile file = new RandomAccessFile(filePath, "r")) {
            // Insertar los vértices en el grafo
            for (Object object : index) {
                graph.insertVertex(object);
            }
            // Leer el número de aristas
            int edgeCount = file.readInt();
            // Insertar las aristas en el grafo
            for (int i = 0; i < edgeCount; i++) {
                // Leer el origen de la arista
                int origin = file.readInt();
                // Leer el destino de la arista
                int destination = file.readInt();
                // Leer el tamaño del peso de la arista
                int weightSize = file.readInt();
                // Leer los bytes del peso de la arista
                byte[] weightBytes = new byte[weightSize];
                file.read(weightBytes);
                // Convertir los bytes del peso en un objeto
                Object weight = Convert.toObject(weightBytes);
                // Insertar la arista con el origen, destino y peso en el grafo
                graph.insertWEdgeDG(origin, destination, weight);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        // Devolver el grafo
        return graph;
    }

    /**
     * La función lee un archivo de índice, convierte la información almacenada en
     * objetos y devuelve
     * un ArrayList de esos objetos.
     * 
     * @return El método devuelve un ArrayList de Objetos.
     */
    private ArrayList<Object> readIndex() {
        ArrayList<Object> res = new ArrayList<>();
        try (RandomAccessFile index = new RandomAccessFile(indexPath, "r")) {
            int infoCount = index.readInt();
            for (int i = 0; i < infoCount; i++) {
                int infoSize = index.readInt();
                byte[] infoBytes = new byte[infoSize];
                index.read(infoBytes);
                Object info = Convert.toObject(infoBytes);
                res.add(info);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return res;
    }

}