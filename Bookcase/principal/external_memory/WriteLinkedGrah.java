package external_memory;

import java.io.File;
import java.io.RandomAccessFile;
import java.io.Serializable;
import java.util.List;
import java.util.ListIterator;

import cu.edu.cujae.ceis.graph.LinkedGraph;
import cu.edu.cujae.ceis.graph.edge.Edge;
import cu.edu.cujae.ceis.graph.edge.WeightedEdge;
import cu.edu.cujae.ceis.graph.vertex.Vertex;

/**
 * <h2>WriteLinkedGrah</h2>
 * <p>
 * La clase WriteLinkedGraph se encarga de escribir un grafo enlazado en
 * archivos. El
 * 
 * <p>
 * El método <code>writeGraph()</code> es el encargado de escribir el grafo en
 * los archivos, los cuales quedan estructurados de la siguiente manera:
 * </p>
 * 
 * <p>
 * <b>•Archivo de Índice</b>:
 * int: cantidad de vértices,
 * Luego una lista secuencial de la info de los vértices que están formados cada
 * uno por
 * int: tamaño de Bytes de la info, seguido de los Bytes de la info
 * (El índice de cada info va a ser el orden en que aparezcan en el fichero
 * empezando desde el
 * 0 hasta la cantidad de vertices -1).
 * </p>
 * 
 * <p>
 * <b>•Archivo de Relaciones</b>:
 * int: cantidad de relaciones (aristas),
 * luego tiene las relaciones en forma secuencial donde cada una está conformada
 * por:
 * int: nodo origen, int: nodo destino, int: tamaño de Bytes del Peso, bytes del
 * peso de la arista.
 * </p>
 */
public class WriteLinkedGrah {

    private File filePath;
    private File indexPath;
    private LinkedGraph graph;

    public WriteLinkedGrah(File filePath, File indexPath, LinkedGraph graph) {
        this.filePath = filePath;
        this.indexPath = indexPath;
        this.graph = graph;

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

    // Este método establece el grafo
    public void setGraph(LinkedGraph graph) {
        this.graph = graph;
    }

    public void writeGraph() {
        // Obtener la lista de vértices del grafo
        List<Vertex> list = graph.getVerticesList();
        int listSize = list.size();
        try (RandomAccessFile file = new RandomAccessFile(filePath, "rw");
                RandomAccessFile index = new RandomAccessFile(indexPath, "rw")) {
            // Escribir el tamaño de la lista en el archivo de índice
            index.writeInt(listSize);
            // Escribir un valor inicial en el archivo principal
            file.writeInt(0);
            int relCount = 0;
            // Iterar sobre la lista de vértices
            ListIterator<Vertex> it = list.listIterator();
            while (it.hasNext()) {
                int i = it.nextIndex();
                Vertex vertex = it.next();
                // Convertir la información del vértice a bytes
                byte[] infoBytes = Convert.toBytes(vertex.getInfo());
                // Escribir la longitud de los bytes en el archivo de índice
                index.writeInt(infoBytes.length);
                // Escribir los bytes en el archivo de índice
                index.write(infoBytes);
                // Iterar sobre la lista de aristas del vértice
                for (Edge edge : vertex.getEdgeList()) {
                    int origin = i;
                    // Obtener el índice del vértice de destino en la lista
                    int destination = list.indexOf(edge.getVertex());
                    // Obtener el peso de la arista
                    Object weight = 1;
                    if (edge instanceof WeightedEdge) {
                        Object w = ((WeightedEdge) edge).getWeight();
                        if(w instanceof Serializable)
                            weight = (Serializable)w;
                    }
                    // Convertir el peso a bytes
                    byte[] weightBytes = Convert.toBytes(weight);
                    // Escribir el índice del vértice de origen en el archivo principal
                    file.writeInt(origin);
                    // Escribir el índice del vértice de destino en el archivo principal
                    file.writeInt(destination);
                    // Escribir la longitud de los bytes del peso en el archivo principal
                    file.writeInt(weightBytes.length);
                    // Escribir los bytes del peso en el archivo principal
                    file.write(weightBytes);
                    // Incrementar el contador de relaciones
                    relCount++;
                }
            }
            // Volver al inicio del archivo principal y actualizar el contador de relaciones
            file.seek(0);
            file.writeInt(relCount);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}