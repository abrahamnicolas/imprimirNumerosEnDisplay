/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pantalla;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Scanner;


/**
 *
 * @author abraham
 */
public class Pantalla {
    
    

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Scanner numero = new Scanner(System.in);
        List<String> listaNumero = new ArrayList<>();
        ImprimirDatos imprimir = new ImprimirDatos();
        
        String numeros;
        
        do{
            System.out.print("digite numero: ");
            numeros=numero.next();
            if(!numeros.equals("0,0")){
                listaNumero.add(numeros);
            }
        
        }while(!numeros.equals("0,0"));
        
        Iterator<String> iterador = listaNumero.iterator();
        while(iterador.hasNext()){
            imprimir.tomarDigitos(iterador.next());
            
        }
    }
    
}
