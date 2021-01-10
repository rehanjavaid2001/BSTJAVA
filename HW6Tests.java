import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import java.util.ArrayList;

import org.junit.Before;
import org.junit.Test;

public class HW6Tests {
	BinarySearchTree tree1 = new BinarySearchTree();
	BinarySearchTree tree2 = new BinarySearchTree(); 
	@Test
	public void testSize1() {
		buildTree1(); 
		assertEquals(9, tree1.size()); 
	}
	
	@Test
	public void testSize2() {
		assertEquals(0, tree1.size());
	}
	
	@Test 
	public void testHeight1() {
		buildTree1(); 
		assertEquals(4, tree1.height(tree1.getRoot()));
	}
	
	@Test 
	public void testHeight2() {
		buildTree2();
		assertEquals(1, tree2.height(tree2.getRoot())); 
		
	}
	
	@Test
	public void testFind1() {
		buildTree1(); 
		assertTrue(tree1.find(7)); 
	}
	
	@Test
	public void testFind2() {
		buildTree2(); 
		assertFalse(tree2.find(2));
	}
	
	@Test
	public void insertTest1() {
		assertTrue(tree1.insert(11)); 
	}
	
	@Test
	public void insertTest2() {
		buildTree2();
		assertTrue(tree2.insert(3)); 
	}
	
	@Test
	public void testInOrder1() {
		buildTree1(); 
		assertEquals("(1)(3)(4)(6)(7)(8)(10)(13)(14)", tree1.inOrder());
	}
	
	@Test
	public void testInOrder2() {
		buildTree2(); 
		assertEquals("(1)", tree2.inOrder());
	}
	
	@Test
	public void testPostOrder1() {
		buildTree1();
		assertEquals("(1)(4)(7)(6)(3)(13)(14)(10)(8)", tree1.postOrder());
	}
	
	
	@Test
	public void testPostOrder2() {
		buildTree2();
		assertEquals("(1)", tree2.postOrder());
	}
	
	@Test
	public void testToString1() {
		buildTree1();
		assertEquals("(1)(3)(4)(6)(7)(8)(10)(13)(14)", tree1.toString());
	}
	
	@Test
	public void testToString2() {
		buildTree2(); 
		assertEquals("(1)", tree2.toString());
	}
	
	@Test
	public void testbuildFromList1() {
		ArrayList list = new ArrayList<>(); 
		list.add(1);
		list.add(2);
		list.add(3);
		list.add(4); 
		assertTrue(tree1.buildFromList(list));
	}
	
	@Test
	public void testbuildFromList2() {
		ArrayList list = new ArrayList<>();
		list.add(7);
		list.add(3);
		list.add(9);
		list.add(2);
		list.add(5);
		assertTrue(tree1.buildFromList(list)); 
	}
	
	public void buildTree1() {
		BinaryTreeNode root = new BinaryTreeNode(8); 
		tree1.setRoot(root);
		
		BinaryTreeNode node1 = new BinaryTreeNode(1);
		BinaryTreeNode node3 = new BinaryTreeNode(3);
		BinaryTreeNode node4 = new BinaryTreeNode(4);
		BinaryTreeNode node6 = new BinaryTreeNode(6);
		BinaryTreeNode node7 = new BinaryTreeNode(7);
		BinaryTreeNode node10 = new BinaryTreeNode(10);
		BinaryTreeNode node13 = new BinaryTreeNode(13);
		BinaryTreeNode node14 = new BinaryTreeNode(14);
		BinaryTreeNode node15 = new BinaryTreeNode(15);
		BinaryTreeNode node16 = new BinaryTreeNode(16);
		
		node6.setLeft(node4);
		node6.setRight(node7);
		node14.setLeft(node13);
		node10.setRight(node14);
		node3.setLeft(node1);
		node3.setRight(node6);
		node14.setRight(node15);
		node15.setRight(node16);
		
		root.setLeft(node3);
		root.setRight(node10);
	}
	
	public void buildTree2() {
		BinaryTreeNode root1 = new BinaryTreeNode(1); 
		tree2.setRoot(root1); 
	}
	
	@Test
	public void testCountRight() {
		buildTree1();
		assertEquals(2, tree1.countRight());
	}
}
