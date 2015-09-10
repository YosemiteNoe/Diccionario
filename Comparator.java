/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 * jose corona 
 * @author Admin
 */
public class Comparator {
    public int equal(String word1, String word2){
        char[] Array1 = word1.toCharArray();
        char[] Array2 = word2.toCharArray();

        int Lenght;
        if(word1.length()<word2.length()){
                Lenght = word1.length();
        } else {
                Lenght = word2.length();
        }
        //compara cada letra para ordenarlo en orden alfabético
        for(int i=0; i<Lenght; i++){
                if(Array1[i]<Array2[i]){
                	//Si la palabra 1 es menor, retorna un 1
                        return 1;           
                }

                if(Array1[i]>Array2[i]){
                	//Si la palabra 2 es menor, retorna 0
                        return -1;              
                }
        }		
        //si la palabra ya está, no importa que retorna
        return 2;
    }
}
