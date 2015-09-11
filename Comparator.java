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
        //Se hace una comparacion letra por letra, hasta que se ecuentre una diferente. Orden alfabetico
        for(int i=0; i<Lenght; i++){
                if(Array1[i]<Array2[i]){
                        return 1;               //se devuelve 1 si la primera paralabra es mayor
                }

                if(Array1[i]>Array2[i]){
                        return -1;              //se devuelve 0 si la segunda palabra es mayor
                }
        }		
        return 2;
    }
}
