import static org.junit.Assert.assertArrayEquals;

import java.util.ArrayList;

/**
 * Binary Tree Node
 * 
 * Tree node that has two children: left and right
 * 
 * @author YOURID
 * @param <Comparable> The type of data this tree node stores
 */
public class BinaryTreeNode<T extends Comparable<T>> {
	
	/**
	 * Reference pointer to the left subtree
	 */
	private BinaryTreeNode<T> left;
	
	private int countRight = 0; 
	/**
	 * Reference pointer to the right subtree
	 */
	private BinaryTreeNode<T> right;
	
	/**
	 * Data stored at this node
	 */
	private T data;
	
	/**
	 * Default Constructor
	 * 
	 * Creates a binary tree node with null data and null children
	 */
	public BinaryTreeNode(){
		this(null,null,null);
	}
	
	/**
	 * Data-only Constructor
	 * 
	 * Creates a binary tree node with the given data and null children
	 * 
	 * @param theData The data to store at this node
	 */
	public BinaryTreeNode(T theData){
		this(theData,null,null);
	}
	
	
	/**
	 * Full Constructor
	 * 
	 * Creates a binary tree node with the given data and child reference pointers
	 * 
	 * @param theData The data to store at this node
	 * @param leftChild A reference pointer to the left subtree
	 * @param rightChild A reference pointer to the right subtree
	 */
	public BinaryTreeNode(T theData, BinaryTreeNode<T> leftChild, BinaryTreeNode<T> rightChild){
		data = theData;
		left = leftChild;
		right = rightChild;
	}


	/**
	 * Left Child/Subtree getter
	 * 
	 * @return A reference pointer to the root of the left subtree
	 */
	public BinaryTreeNode<T> getLeft() {
		return left;
	}

	/**
	 * Left Child/Subtree Setter
	 * 
	 * @param left A reference pointer to the new left subtree's root node
	 */
	public void setLeft(BinaryTreeNode<T> left) {
		this.left = left;
	}

    /**
     * Right Child/Subtree getter
     * 
     * @return A reference pointer to the root of the right subtree
     */
	public BinaryTreeNode<T> getRight() {
		return right;
	}

    /**
     * Right Child/Subtree Setter
     * 
     * @param left A reference pointer to the new right subtree's root node
     */
	public void setRight(BinaryTreeNode<T> right) {
		this.right = right;
	}

	/**
	 * Get the data at this node
	 * 
	 * @return The data stored at this node
	 */
	public T getData() {
		return data;
	}

	/**
	 * Set the data at this node
	 * 
	 * @param data The data to be stored at this node
	 */
	public void setData(T data) {
		this.data = data;
	}
	
	/**
	 * Node-level size method, counts the size of its children
	 * and adds 1 for itself 
	 */
	public int size() {
		int sizeOfSubtree = 0; 
		if (left != null) {
			sizeOfSubtree += left.size(); 
		}
		if (right != null) {
			sizeOfSubtree += right.size(); 
		}
		sizeOfSubtree++; 
		return sizeOfSubtree; 
	}
	 public int countRight() {
         //Write your solution HERE:
        if (right != null && left == null) {
            countRight += right.countRight();
        }
        if (left != null) {
            countRight += left.countRight();
        }
        countRight++;
        return countRight; 
     } 
	/**
	 * Node level find method 
	 */
	public boolean find(T val) {
		boolean found = false;
		
		if (val.compareTo(data) < 0) {
			if (left != null) {
				return left.find(val); 
			}
		}
		if (val.compareTo(data) > 0) {
			if (right != null) {
				return right.find(val);
			}
		}
		if (val.compareTo(data) == 0) {
			found = true; 
		}
		return found; 
	}
	
	/**
	 * Node level insert method 
	 */
	public boolean insert(T val) {
		boolean inserted = false;
		if (val.compareTo(data) < 0) {
			if (left != null) {
				return left.insert(val); 
			}
			else {
				BinaryTreeNode newLeft = new BinaryTreeNode(val);
				setLeft(newLeft);
				inserted = true; 
			}
		}
		if (val.compareTo(data) > 0) {
			if (right != null) {
				return right.insert(val);
			}
			else {
				BinaryTreeNode newRight = new BinaryTreeNode(val);
				setRight(newRight);
				inserted = true; 
			}
		}
		return inserted; 	
	}
	
	/**
	 * Node level inOrder method
	 */
	public String inOrder() {
		String inOrderString = toString(); 
		if (left != null) {
			inOrderString = left.inOrder() + inOrderString;
		}
		if (right != null) {
			inOrderString = inOrderString + right.inOrder(); 
		}
		return inOrderString; 
	}
	
	/**
	 * Node level postOrder method
	 */
	public String postOrder() {
		String postOrderString = "";
		if (left != null) {
			postOrderString = left.postOrder();
		}
		if (right != null) {
			postOrderString = postOrderString + right.postOrder(); 
		}
		return postOrderString + toString(); 
	}
	
	/**
	 * toString method
	 */
	@Override
	public String toString() {
	    String a = "(" + String.valueOf(data) + ")";
	    return a; 
	}
	
	
	/**
	 * Main method
	 * 
	 * For main method testing, etc
	 * 
	 * @param args Command-line arguments
	 */
	public static void main(String[] args) {
	    
	}

}