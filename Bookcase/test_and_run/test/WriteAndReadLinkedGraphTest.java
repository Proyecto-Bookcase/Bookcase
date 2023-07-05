package test;

import java.io.File;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import cu.edu.cujae.ceis.graph.LinkedGraph;
import cu.edu.cujae.ceis.graph.interfaces.ILinkedNotDirectedGraph;
import external_memory.ReadLinkedGraph;
import external_memory.WriteLinkedGrah;

class WriteAndReadLinkedGraphTest {

    private ILinkedNotDirectedGraph graph;
    private File filePath;
    private File indexPath;

    @BeforeEach
    void setUp() throws Exception {
        
        filePath = new File("Graph.DATA");
        indexPath = new File("Index.DATA");
        
        graph = new LinkedGraph();

        graph.insertVertex("A");
        graph.insertVertex("B");
        graph.insertVertex("C");
        graph.insertVertex("D");

        graph.insertEdgeNDG(0, 1);
        graph.insertEdgeNDG(0, 2);

        graph.insertEdgeNDG(1, 2);

        graph.insertEdgeNDG(1, 3);
    }

    @Test
    void test() {
        WriteLinkedGrah writer =  new WriteLinkedGrah(filePath, indexPath, (LinkedGraph)graph);
        writer.writeGraph();
        
        new ReadLinkedGraph(filePath, indexPath);
    }

}
