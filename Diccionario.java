/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
import java.io.FileReader;
import java.io.FileNotFoundException;
import java.io.BufferedReader;
import java.io.IOException;
/**
 *
 * @author Admin
 */
public class Diccionario {
 BinarySearchTree BST = new BinarySearchTree();
    public void leer(){
     try{
			String linea;
			BufferedReader doc = new BufferedReader(new FileReader("diccionario.txt"));
			
			while((linea = doc.readLine()) != null ){
				String ingles=" ";
				String espanol=" ";
				
				System.out.println(linea);
				int contador = 0;
				while(contador<linea.length()){
					if(linea.charAt(contador)=='('){
						while(true){
							contador=contador+1;
							if(linea.charAt(contador)==',')
								break;
							ingles+=linea.charAt(contador);
						}
					}
					if(linea.charAt(contador)==' ')
						while(true){
							contador=contador+1;
							if(linea.charAt(contador)==')')
								break;
							espanol+=linea.charAt(contador);
						}
					contador=contador+1;
				}
				
				Association association = new Association(ingles,espanol);
				
			}
			doc.close();
		}
		catch(IOException io){
			System.out.println("Error, ocurrio un problema en lectura del documento u operacion");
	
		}
 }   
}