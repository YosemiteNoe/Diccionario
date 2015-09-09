/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Admin
 */

    public class BinaryTree<E> {
	protected E val; // value associated with node
	protected BinaryTree<E> parent; // parent of node
	protected BinaryTree<E> left, right; // children of node

	public BinaryTree(){
	// post: constructor that generates an empty node
	val = null;
	parent = null; left = right = this;
	}
	public BinaryTree(E value){
	// post: returns a tree referencing value and two empty subtrees
		Assert.pre(value != null, "Tree values must be non-null.");
		val = value;
		right = left = new BinaryTree<E>();
		setLeft(left);
		setRight(right);
	}
	public BinaryTree(E value, BinaryTree<E> left, BinaryTree<E> right) {
	// post: returns a tree referencing value and two subtrees
		Assert.pre(value != null, "Tree values must be non-null.");
		val = value;
		if (left == null) { left = new BinaryTree<E>(); }
		setLeft(left);
		if (right == null) { right = new BinaryTree<E>(); }
		setRight(right);
	}
	public BinaryTree<E> left(){
	// post: returns reference to (possibly empty) left subtree
	
	}
	public BinaryTree<E> parent(){
	// post: returns reference to parent node, or null
	
	}
	public void setLeft(BinaryTree<E> newLeft){
	// post: sets left subtree to newLeft
	// re-parents newLeft if not null
	
	}
	protected void setParent(BinaryTree<E> newParent){
	// post: re-parents this node to parent reference, or null
	
	}
	public Iterator<E> iterator()
	// post: returns an in-order iterator of the elements
	public boolean isLeftChild()
	// post: returns true if this is a left child of parent
	public E value()
	// post: returns value associated with this node
	public void setValue(E value)
	// post: sets the value associated with this node
}

