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
	BinaryTree<Association<String,String>> root = null;
	
        Comparator cmp = new Comparator();	
        protected Stack<BinaryTree<Association<String,String>>> todo = new Stack<BinaryTree<Association<String,String>>>();
	int counter = 0;
	
	/**
	 * Locate.
	 *
	 * @param root the root
	 * @param value the value
	 * @return the binary tree
	 */
	//Locate method
	public BinaryTree<Association<String,String>> locate(BinaryTree<Association<String,String>> root, String value){
		String rootValue = root.getValue().getKey();
		BinaryTree<Association<String,String>> child = null;
		
		//found at root: done
		if(rootValue.equals(value)) return root;
		//look left if less-than, right if greater-than
		if(cmp.equal(rootValue, value)==1){
			child = root.right();
		}else {
                      child = root.left();
                }
		
		//no child there: not in tree, return this node, else keep searching
		if(child.isEmpty() ){
			return root;
		} else {
			return locate(child, value);
		}
	}
	
	public void add(Association<String,String> asociacion){
		BinaryTree<Association<String,String>> newNode = new BinaryTree<Association<String,String>>(asociacion);
		
		//Add value to binary search tree
		//if there's no root, create value at root
		if(root==null){
			root = newNode;
			counter++;
		} else {
			BinaryTree<Association<String,String>> insertLocation = locate(root, asociacion.getKey());
			String nodeValue = insertLocation.getValue().getKey();
			//If the newNode is greater than insertLocation, set it to the right.
			if(cmp.equal(asociacion.getKey(), nodeValue)==1){
				insertLocation.setLeft(newNode);
				counter++;
			} 
			//If the newNode is lower than insertLocation, set it to the left.
			if(cmp.equal(asociacion.getKey(), nodeValue)==-1){
				insertLocation.setRight(newNode);
				counter++;
			} 
			//If the newNode is equal to insertLocation the newNode isn't added to the tree.
			
		}
	}
	
	//Add translation method
	public void addTranslation(String english, String spanish){
		add(new Association<String,String>(english,spanish));
	}
	
	//Get translation method
	public String getTranslation(String english){
		if(root==null){
			return null;
		}
		
		BinaryTree<Association<String,String>> possibleLocation = locate(root, english);
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
		BinaryTree<Association<String,String>> current = root;
		while(current!=null){
			todo.push(current);
			current = current.left();
		}
	}
	
	//Next method
	public Association<String,String> next(){
		BinaryTree<Association<String,String>> old = todo.pop();
		Association<String,String> result = old.getValue();
		//We know this node has no unconsidered left children; if this node has right child,
		//we push the right child and its leftmost descendants:
		//else
		//	top element of stack is next node to be visited
		if(old.right()!=null){
			BinaryTree<Association<String,String>> current = old.right();
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
