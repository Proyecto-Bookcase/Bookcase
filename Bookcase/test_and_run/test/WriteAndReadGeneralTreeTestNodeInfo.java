package test;

import java.io.File;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import classes.*;
import cu.edu.cujae.ceis.tree.binary.BinaryTreeNode;
import cu.edu.cujae.ceis.tree.general.GeneralTree;
import cu.edu.cujae.ceis.tree.iterators.general.InDepthIterator;
import externalMemory.ReadGeneralTree;
import externalMemory.WriteGeneralTree;
import interfaces.NodeInfo;

public class WriteAndReadGeneralTreeTestNodeInfo {


    private GeneralTree<NodeInfo> tree;
    private File filePath;
    

    @BeforeEach
    void setUp() {
        filePath = new File("Tree3.DATA");
        tree = new GeneralTree<NodeInfo>();

        BinaryTreeNode<NodeInfo> a = new BinaryTreeNode<NodeInfo>(new University("1", "Cujae"));
        BinaryTreeNode<NodeInfo> b = new BinaryTreeNode<NodeInfo>(new Carreer("00", "Informatica", 3));
        BinaryTreeNode<NodeInfo> c = new BinaryTreeNode<NodeInfo>(new Carreer("01", "Tele", 3));
        BinaryTreeNode<NodeInfo> d = new BinaryTreeNode<NodeInfo>(new Year("000", 1));
        BinaryTreeNode<NodeInfo> e = new BinaryTreeNode<NodeInfo>(new Year("001", 2));
        BinaryTreeNode<NodeInfo> f = new BinaryTreeNode<NodeInfo>(new Year("002", 3));
        BinaryTreeNode<NodeInfo> g = new BinaryTreeNode<NodeInfo>(new Year("010", 1));
        BinaryTreeNode<NodeInfo> i = new BinaryTreeNode<NodeInfo>(new Year("011", 2));
        BinaryTreeNode<NodeInfo> j = new BinaryTreeNode<NodeInfo>(new Year("012", 3));
        
        //BinaryTreeNode<NodeInfo> k = new BinaryTreeNode<NodeInfo>("K");

        tree.setRoot(a);

        tree.insertNode(b, a);
        tree.insertNode(c, a);
        tree.insertNode(d, a);

        tree.insertNode(e, b);
        tree.insertNode(f, b);

        tree.insertNode(g, c);

        tree.insertNode(i, d);
        tree.insertNode(j, d);
        //tree.insertNode(k, d);
        InDepthIterator<NodeInfo> iter = tree.inDepthIterator();
        while (iter.hasNext()) {
            System.out.print(iter.next().getId()+" ");
        }
        System.out.println();
    }

    @Test
    void test() {
        WriteGeneralTree<NodeInfo> writer = new WriteGeneralTree<NodeInfo>(filePath, tree);
        writer.writeTreeNew();
        ReadGeneralTree<NodeInfo> reader = new ReadGeneralTree<NodeInfo>(filePath);
        GeneralTree<NodeInfo> new_tree= reader.generateTree();
        InDepthIterator<NodeInfo> iterator = new_tree.inDepthIterator();
        while (iterator.hasNext()) {
            System.out.print(iterator.next().getId()+" ");
        }
    }
}
