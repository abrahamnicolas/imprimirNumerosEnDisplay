/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pantalla;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;


/**
 *
 * @author abraham
 */
public class ImprimirDatos {
    
    private int puntoFijo_1[];
    private int puntoFijo_2[];
    private int puntoFijo_3[];
    private int puntoFijo_4[];
    private int puntoFijo_5[];
    private String matriz[][];
    private int tamaño;
    private int filaDigito;
    private int columnaDigito;
    private int totalFilas;
    private int totalColumnas;
    static String caracterHorizontal="-";
    static String caracterVertical="|";
    static String posicionX="X";
    static String posicionY="Y";
    
    public ImprimirDatos(){
        this.puntoFijo_1=new int[2];
        this.puntoFijo_2=new int[2];
        this.puntoFijo_3=new int[2];
        this.puntoFijo_4=new int[2];
        this.puntoFijo_5=new int[2];
    }
    
    public void tomarDigitos(String numeros){
        String digitos[];
        int tam;
        
        digitos=numeros.split(",");
        
        if (esNumerico(digitos[0])){
            tam=Integer.parseInt(digitos[0]);
            
            if(tam<1 || tam >10){
                throw new IllegalArgumentException("El numero antes de la , ["+tam+ "] debe estar entre 1 y 10");
            }
            tomarTamañoImprimirNum(tam, digitos[1]);
        }
        
    }
    
    static boolean esNumerico(String digito) {
        try {
            Integer.parseInt(digito);
            return true;
        } catch (NumberFormatException ex) {
            return false;
        }
    }
    
    public void tomarTamañoImprimirNum(int tam, String digito){
        int X=0;
        char imprimirDigito[];
        this.tamaño=tam;
        
        this.filaDigito = (2 * this.tamaño)+ 3;
        
        this.columnaDigito = this.tamaño+2;
        
        this.totalFilas=this.filaDigito;
        
        this.totalColumnas= (this.columnaDigito * digito.length());
        
        this.matriz = new String [this.totalFilas][this.totalColumnas];
        
        imprimirDigito=digito.toCharArray();
        
        for(int i=0; i<this.totalFilas; i++){
            for(int j=0; j<this.totalColumnas; j++){
                this.matriz[i][j]=" ";
            }
        }
        
        
        for(char Digitos : imprimirDigito ){
            
            if(!Character.isDigit(Digitos)){
                throw new IllegalArgumentException("Caracter " + digito+ " no es un digito");
              
            }
            int digit = Integer.parseInt(String.valueOf(Digitos));
            
            
            this.puntoFijo_1[0]=0;
            this.puntoFijo_1[1]=0+X;
            
            this.puntoFijo_2[0]=(this.filaDigito/2);
            this.puntoFijo_2[1]=0+X;
            
            this.puntoFijo_3[0]=(this.filaDigito-1);
            this.puntoFijo_3[1]=0+X;
            
            this.puntoFijo_4[0]=(this.columnaDigito-1);
            this.puntoFijo_4[1]=(this.filaDigito/2)+ X;
            
            this.puntoFijo_5[0]=0;
            this.puntoFijo_5[1]=(this.columnaDigito-1)+X;
            
            X = X + this.columnaDigito;
            representacionDigito(digit);
            
        }
        
        for(int i=0; i< this.totalFilas; i++){
                for (int j = 0; j < this.totalColumnas; j++) {
                    System.out.print(this.matriz[i][j]);
                }
                System.out.println();
        }
        
    }
    
    private void representacionDigito(int numero){
    
        List<Integer> segList=new ArrayList<>();
        
            switch (numero) {
            case 1:
                segList.add(3);
                segList.add(4);
                break;
            case 2:
                segList.add(5);
                segList.add(3);
                segList.add(6);
                segList.add(2);
                segList.add(7);
                break;
            case 3:
                segList.add(5);
                segList.add(3);
                segList.add(6);
                segList.add(4);
                segList.add(7);
                break;
            case 4:
                segList.add(1);
                segList.add(6);
                segList.add(3);
                segList.add(4);
                break;
            case 5:
                segList.add(5);
                segList.add(1);
                segList.add(6);
                segList.add(4);
                segList.add(7);
                break;
            case 6:
                segList.add(5);
                segList.add(1);
                segList.add(6);
                segList.add(2);
                segList.add(7);
                segList.add(4);
                break;
            case 7:
                segList.add(5);
                segList.add(3);
                segList.add(4);
                break;
            case 8:
                segList.add(1);
                segList.add(2);
                segList.add(3);
                segList.add(4);
                segList.add(5);
                segList.add(6);
                segList.add(7);
                break;
            case 9:
                segList.add(1);
                segList.add(3);
                segList.add(4);
                segList.add(5);
                segList.add(6);
                segList.add(7);
                break;
            case 0:
                segList.add(1);
                segList.add(2);
                segList.add(3);
                segList.add(4);
                segList.add(5);
                segList.add(7);
                break;
            default:
                break;
        }

        Iterator<Integer> iterador = segList.iterator();

        while (iterador.hasNext()) {
            matrizDeImprecionPorSegmento(iterador.next());
        }
    }
    
    private void coordenadas(String matriz[][] , int puntoFijo[], String posFija,
            int tamañoSegmento, String caracter_X_o_Y) {

        if (posFija.equalsIgnoreCase(posicionX)) 
        {
            for (int i = 1; i <= tamañoSegmento; i++) 
            {
                int valor = puntoFijo[1] + i;
                matriz[puntoFijo[0]][valor] = caracter_X_o_Y;
            }
        } 
        else 
        {
            for (int i = 1; i <= tamañoSegmento; i++) 
            {
                int valor = puntoFijo[0] + i;
                matriz[valor][puntoFijo[1]] = caracter_X_o_Y;
            }
        }
    }
    
    private void matrizDeImprecionPorSegmento(int digitoSegmento){
     
        switch(digitoSegmento){
            case 1:
                coordenadas(this.matriz, this.puntoFijo_1, this.posicionY,
                        this.tamaño, caracterVertical);
                break;
            case 2:
                coordenadas(this.matriz, this.puntoFijo_2, this.posicionY,
                        this.tamaño, caracterVertical);
                break;
            case 3:
                coordenadas(this.matriz, this.puntoFijo_5, this.posicionY,
                        this.tamaño, caracterVertical);
                break;
            case 4:
                coordenadas(this.matriz, this.puntoFijo_4, this.posicionY,
                        this.tamaño, caracterVertical);
                break;
            case 5:
                coordenadas(this.matriz, this.puntoFijo_1, this.posicionX,
                        this.tamaño, caracterHorizontal);
                break;
            case 6:
                coordenadas(this.matriz, this.puntoFijo_2, this.posicionX,
                        this.tamaño, caracterHorizontal);
                break;
            case 7:
                coordenadas(this.matriz, this.puntoFijo_3, this.posicionX,
                        this.tamaño, caracterHorizontal);
                break;
        }
    }
}
