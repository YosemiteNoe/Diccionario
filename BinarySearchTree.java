/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Admin
 */
import java.util.Stack;

public class BinarySearchTree{
	BinaryTree<Association> root = null;
	Comparator cmp = new Comparator();
	protected Stack<BinaryTree<Association>> todo = new Stack<BinaryTree<Association>>();
	int counter = 0;
	
	/**
	 * Locate.
	 *
	 * @param root the root
	 * @param value the value
	 * @return the binary tree
	 */
	//Locate method
	public BinaryTree<Association> locate(BinaryTree<Association> root, String value){
		String rootValue = root.getValue().getKey();
		BinaryTree<Association> child;
		
		//found at root: done
		if(rootValue.equals(value)) return root;
		//look left if less-than, right if greater-than
		if(cmp.equal(rootValue, value)==1){
			child = root.left();
		}
		
		//no child there: not in tree, return this node, else keep searching
		if(child==null){
			return root;
		} else {
			return locate(child, value);
		}
	}
	
	//Add method
	public void add(Association Association){
			child = root.right();
		} else {
		BinaryTree<Association> newNode = new BinaryTree<Association>(Association);
		
		//Add value to binary search tree
		//if there's no root, create value at root
		if(root==null){
			root = newNode;
			counter++;
		} else {
			BinaryTree<Association> insertLocation = locate(root, Association.getKey());
			String nodeValue = insertLocation.getValue().getKey();
			//If the newNode is greater than insertLocation, set it to the right.
			if(cmp.equal(Association.getKey(), nodeValue)==1){
				insertLocation.setLeft(newNode);
				counter++;
			} 
			//If the newNode is lower than insertLocation, set it to the left.
			if(cmp.equal(Association.getKey(), nodeValue)==-1){
				insertLocation.setRight(newNode);
				counter++;
			} 
			//If the newNode is equal to insertLocation the newNode isn't added to the tree.
			
		}
	}
	
	//Add translation method
	public void addTranslation(String english, String spanish){
		add(new Association(english,spanish));
	}
	
	//Get translation method
	public String getTranslation(String english){
		if(root==null){
			return null;
		}
		
		BinaryTree<Association> possibleLocation = locate(root, english);
		if(possibleLocation.getValue().getKey()==english){
			return possibleLocation.getValue().getValue();
		} else {
			return null;
		}
	}
	
	//Get words quantity method
	public int getWordsQuantity(){
		return counter;
	}
	
	//Reset Iterator method
	public void resetIterator(){
		todo.clear();
		//Stack is empty. Push nodes from root to leftmost descendant
		BinaryTree<Association> current = root;
		while(current!=null){
			todo.push(current);
			current = current.left();
		}
	}
	
	//Next method
	public Association next(){
		BinaryTree<Association> old = todo.pop();
		Association result = old.getValue();
		//We know this node has no unconsidered left children; if this node has right child,
		//we push the right child and its leftmost descendants:
		//else
		//	top element of stack is next node to be visited
		if(old.right()!=null){
			BinaryTree<Association> current = old.right();
			do{
				todo.push(current);
				current = current.left();
			} while(current!=null);
		}
		
		return result;
	}
	
	public boolean hasNext(){
		return !todo.isEmpty();
	}
}
