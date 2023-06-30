package externalMemory;


import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.RandomAccess;


import classes.NodeInfo;
import cu.edu.cujae.ceis.tree.binary.BinaryTreeNode;
import cu.edu.cujae.ceis.tree.general.GeneralTree;
import cu.edu.cujae.ceis.tree.iterators.general.InDepthIterator;

public class WriteGeneralTree<E extends Serializable> {
	private GeneralTree<E> tree;
    private File filePath;

    public WriteGeneralTree(File filePath, GeneralTree<E> tree) {
        this.setFilePath(filePath);
        this.setTree(tree);
        
    }

	public File getFilePath() {
		return filePath;
	}

	public void setFilePath(File filePath) {
		this.filePath = filePath;
	}

	public GeneralTree<E> getTree() {
		return tree;
	}

	public void setTree(GeneralTree<E> tree) {
		this.tree = tree;
	}
	public void WriteDataTree() throws IOException
	{
		RandomAccessFile file_open = new RandomAccessFile(filePath, "rw");
		int cantidad_node = countNodes((BinaryTreeNode<E>)tree.getRoot());
		file_open.writeInt(cantidad_node);
		
		
		InDepthIterator<E> iter = tree.inDepthIterator();
		
		while (iter.hasNext()) {
			BinaryTreeNode<E> node = iter.nextNode();
			byte[] byteNode = Convert.toBytes(node.getInfo());
			int tamNode = byteNode.length;
			file_open.writeInt(tamNode);
			file_open.write(byteNode);
			BinaryTreeNode<E> rigth_node = node.getRight();
			int pos_rigth_bro  = -1;
			if( rigth_node != null)
			{
				pos_rigth_bro  = foundPosInTree(rigth_node);
			}
			file_open.writeInt(pos_rigth_bro);
			if(node.getLeft()==null)
			{
				file_open.writeInt(1); // si es verdadero
			}
			else
			{
				file_open.writeInt(0);
			}
			
		}
		file_open.close();
		
	}
	private int countNodes(BinaryTreeNode root) {
        if (root == null) {
            return 0;
        }   
        return 1 + countNodes(root.getLeft()) + countNodes(root.getRight());
    }
	//este metodo hay que mejorarlo
	private int foundPosInTree(BinaryTreeNode<E> node)
	{
		int pos = -1;
		InDepthIterator<E> iterator = tree.inDepthIterator();
		boolean find = false;
		while (!find && iterator.hasNext()) {
			BinaryTreeNode<E> nodeAux = iterator.nextNode();
			
			if(nodeAux.getInfo().equals(node.getInfo()))
			{
				pos++;
				find = true;
			}
			else {
				pos++;
			}
		}
		
		return pos;
	}
	
	

}
