package test;

import java.io.File;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import classes.*;
import classes.Carreer;
import classes.University;
import classes.Year;
import cu.edu.cujae.ceis.tree.binary.BinaryTreeNode;
import cu.edu.cujae.ceis.tree.general.GeneralTree;
import cu.edu.cujae.ceis.tree.iterators.general.InDepthIterator;
import external_memory.ReadGeneralTree;
import external_memory.WriteGeneralTree;
import interfaces.NodeInfo;

public class BookcaseTests {

	 private GeneralTree<NodeInfo> tree;
	    private File filePath;
	    private Bookcase bookcase;
	    

	    @BeforeEach
	    void setUp() {
	        filePath = new File("Tree4.DATA");
	        tree = new GeneralTree<NodeInfo>();
	        bookcase = Bookcase.getInstance();
	        bookcase.newCarreer( "Informatica", 3);
	        bookcase.newCarreer("Tele", 3);
	        bookcase.newSubject("001", "mat1");
	        bookcase.newSubject("002", "mat2");
	        bookcase.newSubject("003", "mat3");
	        
	        bookcase.newSubject("011", "mat1");
	        bookcase.newSubject("012", "mat2");
	        bookcase.newSubject("013", "mat3");
	        
	        bookcase.newSubject("011", "mat1");
	        bookcase.newSubject("011", "mat1");
	        bookcase.newSubject("011", "mat1");
	        
	        bookcase.newSubject("001", "MD");
	        bookcase.newSubject("002", "MC");
	        bookcase.newSubject("003", "ED");
	        
	        bookcase.newSubject("011", "F");
	        bookcase.newSubject("012", "BD");
	        bookcase.newSubject("013", "D");
	        
	        
	        
	        
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

	        tree.insertNode(d, b);
	        tree.insertNode(e, b);
	        tree.insertNode(f, b);

	        tree.insertNode(g, c);
	        tree.insertNode(i, c);
	        tree.insertNode(j, c);
	        //tree.insertNode(k, d);
	        InDepthIterator<NodeInfo> iter = bookcase.getTree().inDepthIterator();
	        while (iter.hasNext()) {
	            System.out.print(iter.next().getId()+" ");
	        }
	        System.out.println();
	    }

	    @Test
	    void test() {
	        WriteGeneralTree<NodeInfo> writer = new WriteGeneralTree<NodeInfo>(filePath, bookcase.getTree());
	        writer.writeTreeNew();
	        ReadGeneralTree<NodeInfo> reader = new ReadGeneralTree<NodeInfo>(filePath);
	        GeneralTree<NodeInfo> new_tree= reader.generateTree();
	        InDepthIterator<NodeInfo> iterator = new_tree.inDepthIterator();
	        while (iterator.hasNext()) {
	        	NodeInfo a = iterator.next();
	            System.out.print(a.getId()+" ");
//	            if (a instanceof Carreer) {
//					System.out.print(((Carreer)a).getName()+" ");
//				}
	        }
	    }
}
