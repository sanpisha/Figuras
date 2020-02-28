/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.unicundi.figuras;

import java.util.Scanner;

/**
 *
 * @author Santiago Gómez
 */
public class Principal {
    //  Objeto de la clase Scanner
    Scanner leer = new Scanner(System.in);

    //  Objeto de la clase Triangulo
    private Triangulo triangulo;
    
    //  Objeto de la clase Cuadrado
    private Cuadrado cuadrado;
    
   
    
    
    /**
     * Constructor de la clase Principal
     */
    public Principal() {
        menu();
    }
    
    /**
     * Menu para escoger la figura a procesar
     */
    private void menu(){
        byte opcion = 0;
        while(opcion != 3){
            System.out.println("1- Triangulo");
            System.out.println("2- Cuadrado");
            System.out.println("3- Salir");
            System.out.print("Opcion: ");
            opcion = leer.nextByte();
            switch(opcion){
                case 1:
                    iniciarTriangulo();
                    break;
                case 2:
                    iniciarCuadrado();
                    break;
                
            }
        }
    }
    
    /**
     * Metodo que inicia las operaciones con triangulo
     */
    private void iniciarTriangulo(){
        solicitarPuntosTriangulo();
        menuTriangulo();
    }
    
    /**
     * Metodo para Solicitar y validar los Puntos del triangulo
     */
    private void solicitarPuntosTriangulo(){
        boolean validar = false;
        while(validar == false){
            System.out.print("Punto 1 X: ");
        double x = leer.nextDouble();
        System.out.print("Punto 1 Y: ");
        double y = leer.nextDouble();
        Punto punto1 = new Punto(x, y);
        System.out.print("Punto 2 X: ");
        x = leer.nextDouble();
        System.out.print("Punto 2 Y: ");
        y = leer.nextDouble();
        Punto punto2 = new Punto(x, y);
        System.out.print("Punto 3 X: ");
        x = leer.nextDouble();
        System.out.print("Punto 3 Y: ");
        y = leer.nextDouble();
        Punto punto3 = new Punto(x, y);
        triangulo = new Triangulo(punto1, punto2, punto3);  // Le enviamos los puntos al objeto triangulo
        validar = triangulo.validarPuntos();    // valida si los puntos son validos
        if(validar == false)
            System.out.println("Puntos NO validos para un triangulo!");
        }
    }
    
    /**
     * Menu de opciones para un triangulo
     */
    private void menuTriangulo(){
        byte opcion = 0;
        while(opcion != 4){
            System.out.println("Menu de opciones para un Triangulo");
            System.out.println("1- Perimetro");
            System.out.println("2- Area");
            System.out.println("3- Tipo de triangulo por sus lados");
            System.out.println("4- Salir");
            System.out.print("Opcion: ");
            opcion = leer.nextByte();
            imprimirResultadosTriangulo(opcion);
        }
    }
    
    /**
     * Imprime el resultado de la opcion elegida
     * @param opcion 
     */
    private void imprimirResultadosTriangulo(byte opcion){
        switch(opcion){
            case 1:
                triangulo.calcularPerimetro();
                System.out.println("Peimetro Triangulo: "+triangulo.getPerimetro());
                break;
            case 2:
                triangulo.calcularArea();
                System.out.println("Area Triangulo: "+triangulo.getArea());
                break;
            case 3:
                System.out.println("Tipo de Triangulo: "+triangulo.tipoTriangulo());
                break;
        }
    }
    
    /**
     * Inicia las operaciones con un cuadrado o triangulo
     */
    private void iniciarCuadrado(){
        validarPuntosCuadrado();
        menuCuadrado();
    }
    
    /**
     * Metodo que solicita los puntos del cuadrado o rectangulo
     */
    private void validarPuntosCuadrado(){
        boolean validar = false;
        while(validar == false){
            solicitarPuntosCuadrado();
            validar = cuadrado.validarPuntos();    // valida si los puntos son validos
            if(validar == false)
                System.out.println("Puntos NO validos para un cuadrado o rectangulo!");
        }
    }
    
    private void solicitarPuntosCuadrado(){
        System.out.print("Punto 1 X: ");
        double x = leer.nextDouble();
        System.out.print("Punto 1 Y: ");
        double y = leer.nextDouble();
        Punto punto1 = new Punto(x, y);
        System.out.print("Punto 2 X: ");
        x = leer.nextDouble();
        System.out.print("Punto 2 Y: ");
        y = leer.nextDouble();
        Punto punto2 = new Punto(x, y);
        System.out.print("Punto 3 X: ");
        x = leer.nextDouble();
        System.out.print("Punto 3 Y: ");
        y = leer.nextDouble();
        Punto punto3 = new Punto(x, y);
        System.out.print("Punto 4 X: ");
        x = leer.nextDouble();
        System.out.print("Punto 4 Y: ");
        y = leer.nextDouble();
        Punto punto4 = new Punto(x, y);
        cuadrado = new Cuadrado(punto1, punto2, punto3, punto4);
    }
    
    /**
     * Menu de opciones para un cuadrado o rectangulo
     */
    private void menuCuadrado(){
        byte opcion = 0;
        while(opcion != 4){
            System.out.println("Menu de opciones para un Cuadrado o Rectangulo");
            System.out.println("1- Perimetro");
            System.out.println("2- Area");
            System.out.println("3- Tipo, cuadrado o rectangulo");
            System.out.println("4- Salir");
            System.out.print("Opcion: ");
            opcion = leer.nextByte();
            imprimirResultadosCuadrado(opcion);
        }
    }
    
    /**
     * Imprime los resultados de la opcion escojida
     * @param opcion 
     */
    private void imprimirResultadosCuadrado(byte opcion){
        switch(opcion){
            case 1:
                cuadrado.calcularPerimetro();
                System.out.println("Peimetro Cuadrado: "+cuadrado.getPerimetro());
                break;
            case 2:
                cuadrado.calcularArea();
                System.out.println("Area Cuadrado: "+cuadrado.getArea());
                break;
            case 3:
                System.out.println("Tipo : "+cuadrado.tipo());
                break;
        }
    }
    
          
   
    
   
    
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        //FigurasGeometricasHerencia figurasGeometricasHerencia = new FigurasGeometricasHerencia();
    }
       
}
