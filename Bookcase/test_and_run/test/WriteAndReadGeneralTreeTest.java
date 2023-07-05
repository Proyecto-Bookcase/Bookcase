package test;

import java.io.File;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import cu.edu.cujae.ceis.tree.binary.BinaryTreeNode;
import cu.edu.cujae.ceis.tree.general.GeneralTree;
import external_memory.ReadGeneralTree;
import external_memory.WriteGeneralTree;

class WriteAndReadGeneralTreeTest {

    private GeneralTree<String> tree;
    private File filePath;

    @BeforeEach
    void setUp() {
        filePath = new File("Tree.DATA");
        tree = new GeneralTree<>();

        BinaryTreeNode<String> a = new BinaryTreeNode<String>("A");
        BinaryTreeNode<String> b = new BinaryTreeNode<String>("B");
        BinaryTreeNode<String> c = new BinaryTreeNode<String>("C");
        BinaryTreeNode<String> d = new BinaryTreeNode<String>("D");
        BinaryTreeNode<String> e = new BinaryTreeNode<String>("E");
        BinaryTreeNode<String> f = new BinaryTreeNode<String>("F");
        BinaryTreeNode<String> g = new BinaryTreeNode<String>("G");
        BinaryTreeNode<String> i = new BinaryTreeNode<String>("I");
        BinaryTreeNode<String> j = new BinaryTreeNode<String>("J");
        BinaryTreeNode<String> k = new BinaryTreeNode<String>("K");

        tree.setRoot(a);

        tree.insertNode(b, a);
        tree.insertNode(c, a);
        tree.insertNode(d, a);

        tree.insertNode(e, b);
        tree.insertNode(f, b);

        tree.insertNode(g, c);

        tree.insertNode(i, d);
        tree.insertNode(j, d);
        tree.insertNode(k, d);
    }

    @Test
    void test() {
        WriteGeneralTree<String> writer = new WriteGeneralTree<>(filePath, tree);
        writer.writeTree();
        new ReadGeneralTree<>(filePath);
    }

}

