import static org.junit.Assert.*;
import org.junit.Test;
import junit.framework.TestCase;

public class BinarySearchTreeTest extends TestCase {

	BinarySearchTree bt = new BinarySearchTree();
	Association<String,String> asociacion1 = new Association<String, String>("Hi", "Hola");
	Association<String,String> asociacion2 = new Association<String, String>("Bye", "Adiós");
	
	
	public void testLocate(){
		BinaryTree<Association<String,String>> root = new BinaryTree<Association<String,String>>();	
		
		root.setValue(asociacion1);
		BinaryTree<Association<String, String>> encontrar = bt.locate(root, "Hi");
		
		int valor = 0;
		if(encontrar != root){
			valor = 1;
		} else {
			valor = 2;
		}
		assertEquals(2, valor,0);
			
	}
	
	public void testAdd(){
		
		bt.add(asociacion1);
		bt.add(asociacion2);
		assertEquals(2, bt.getWordsQuantity(),0);
		
	}
	
	

}
