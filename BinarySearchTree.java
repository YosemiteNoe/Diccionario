/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *  Jose Ramon Corona Boch 14417
 *  Yosemite Noe melendez  
 *  Julio Octavio
 * @author Admin
 */

public class BinarySearchTree<E>{
	private BinaryTree root;
        private String translation;
	
        Comparator cmp = new Comparator();	
        int counter = 0;
	
	/**
	 * add.
	 *
	 * @param root the root
	 * @param value the value
	 * @return the binary tree
	 */
	//add method
	
	public void add(BinaryTree parent, String wordIng, String wordEsp){
		//Add value to binary search tree
		//if there's no root, create value at root
		if(root==null){	
			counter++;
                        System.out.println("Agregando RAIZ "+wordIng+", "+wordEsp);
			root= new BinaryTree(null,null, wordIng, wordEsp);
		} else {
			if (cmp.equal(parent.getWordEsp(), wordEsp)==1 ){
                            if(parent.getLeft()==null){
				System.out.println("Agregando "+wordIng+ " a la izquierda de "+parent.getWordIng());
                                parent.setLeft(new BinaryTree(null,null, wordIng, wordEsp));
				counter++;
                            }else{
                                add(parent.getLeft(), wordIng, wordEsp);
                            }
                        }else {
                            if(parent.getRight()==null){
                                System.out.println("Agregando "+wordIng +" a la derecha de "+parent.getWordIng());
                                parent.setRight(new BinaryTree(null,null, wordIng, wordEsp));
				counter++;                            
                            }else{
                                add(parent.getRight(), wordIng, wordEsp);
                            }
                        }
		}
	}

        public BinaryTree getRoot(){
            return root;
        }
        public void setRoot(BinaryTree newRoot){
            root = newRoot;
        }
        
        public void search(BinaryTree parent, String wordIng){
            if(parent == null)return;
            search(parent.getLeft(), wordIng);
            if(parent.getWordIng().equalsIgnoreCase(wordIng)){
                translation=parent.getWordEsp();
            }
            search(parent.getRight(), wordIng);
        }
        
        public String getTraduccion() {
		return  translation;
	}
	
	//Get words quantity method
	public int getWordsQuantity(){
		return counter;
	}	

}
