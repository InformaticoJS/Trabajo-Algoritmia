package trabajo_algoritmia;

import java.util.*;

public class Copia_de_seguridad_2 {
    //edición
    //en esta versión si acepta decimales

    public static void main(String[] args) {
        //variables
        int filas, columnas;
        Scanner scanner = new Scanner(System.in);
        //entrada

        //filas
        do {
            System.out.print("Ingrese el número de filas: ");

            if (scanner.hasNextInt()) {
                filas = scanner.nextInt();

                if (filas <= 0) {
                    System.out.println("El número de filas debe ser mayor que 0");
                }
            } else {
                System.out.println("Debe ingresar un número entero.");
                scanner.next(); // Consumir entrada inválida para evitar un bucle infinito
                filas = -1; // Asignar un valor inválido para que se repita el bucle
            }
        } while (filas <= 0);

        //columnas
        do{
            System.out.print("Ingrese el número de columnas: ");
            
            if(scanner.hasNextDouble()){
                columnas = scanner.nextInt();

                if(columnas <= 0){
                    System.out.println("El número de filas debe ser mayor que 0");
                }
            }else{
                System.out.println("Debe ingresar un número entero.");
                scanner.next(); //consumir entrada inválida para evitar un bucle infinito
                columnas=-1; // asignar un valor inválido para que se repita el bucle
            }
        }while(columnas <= 0);

         //creación del array
        double[][] matriz = new double[filas][columnas];

        //entrada de elementos del array
        System.out.println("Ingrese los elementos de la matriz:");

        // Llenar la matriz con los valores ingresados por el usuario
        for (int i = 0; i < filas; i++) {
            for (int j = 0; j < columnas; j++) {
                do {
                    System.out.println("Ingrese el elemento en la posición a(" + (i + 1) + ";" + (j + 1) + "):");

                    if (scanner.hasNextDouble()) {
                        matriz[i][j] = scanner.nextDouble();
                        break; // Salir del bucle si se ingresó un número real válido
                    } else {
                        System.out.println("Debe ingresar un número real.");
                        scanner.next(); // Consumir entrada inválida para evitar un bucle infinito
                    }
                } while (true);
            }
        }
        
       
        //salida
        System.out.println("|||||||| ANÁLISIS DE LA MATRIZ  ||||||||");
        System.out.println(" ");
        //rectangular o cuadrada
        if(filas==columnas){
            System.out.println("La matriz es una matriz cuadrada.");
            if (esMatrizNula(matriz)) {
                System.out.println("La matriz es nula.");
            } else{
                System.out.println("La matriz no es nula.");
            } 
            if (esMatrizIdentidad(matriz)) {
                System.out.println("La matriz es identidad.");
            } else {
                System.out.println("La matriz no es identidad.");
            }
        
            if (esMatrizEscalar(matriz)) {
                System.out.println("La matriz es escalar.");
            } else {
                System.out.println("La matriz no es escalar.");
            }
        //añadí una forma de saber si es simétrica cree un public boolean tambien para ello.
            if(esSimetrica(matriz)){
                System.out.println("la matriz es simétrica");
            } else {
                System.out.println("la matriz no es simétrica");
            }
            if(esMatrizTriangularSuperior(matriz)&&esMatrizTriangularInferior(matriz)){
                System.out.println("La matriz es diagonal");
            }else {
                if(esMatrizTriangularSuperior(matriz)){
                    System.out.println("La matriz es triangular superior");
                }else {
                    System.out.println("la matriz no es triangular superior");
                }
         
                if(esMatrizTriangularInferior(matriz)){
                    System.out.println("La matriz es triangular inferior");
                }else {
                    System.out.println("la matriz no es triangular inferior");
               }
            }

            if (!esMatrizEscalar(matriz)&&!esMatrizIdentidad(matriz)&&!esMatrizNula(matriz)&&!esSimetrica(matriz)&&!esMatrizTriangularSuperior(matriz)&&!esMatrizTriangularInferior(matriz)){
                System.out.println("La matriz no cumple con ningún tipo específico.");
            }
        } else {
            System.out.println("La matriz es rectangular.");
            if (esMatrizColumna(matriz)) {
                System.out.println("La matriz es una matriz columna.");
            }else{
                System.out.println("La matriz no es una matriz columna.");
            }
            if (esMatrizFila(matriz)) {
                System.out.println("La matriz es una fila.");
            } else {
                System.out.println("La matriz no es matriz una fila.");
            }     
            if (esMatrizNula(matriz)) {
                System.out.println("La matriz es nula.");
            } else{
                System.out.println("La matriz no es nula.");
            } 
            if (!esMatrizColumna(matriz)&&!esMatrizFila(matriz)&&!esMatrizNula(matriz)){
                System.out.println("La matriz no cumple con ningún tipo específico.");
            }
        }
        
        //representación gráfica de la matriz (prueba)
        System.out.println("|||||||| REPRESENTACIÓN DE LA MATRÍZ  ||||||||");
        System.out.println(" ");
        for (int i = 0; i < matriz.length; i++) {
            System.out.print("[ ");
            for (int j = 0; j < matriz[i].length; j++) {
                
                System.out.print(matriz[i][j] + "  "); //Impresión de cada elemento y un espacio
                
            }
            System.out.print("] ");
            System.out.println(); // Salto de línea para crear una nueva fila
            
        }


         System.out.println("Ingresa una operación a realizar, o ingrese 'q' para finalizar el programa :");
            System.out.println("Ingresa 'S' para sumar con otra matriz.");
            System.out.println("Ingresa 'M' para restar con otra matriz.");
            System.out.println("Ingresa 'T' para hallar su traza.");
            System.out.println("Ingresa 'D' para hallar su transpuesta.");
            
        String letra = " ";
        boolean uo=false;
         while (!uo) {
            
            letra = scanner.nextLine();
            letra = letra.toLowerCase();
            
        
        if (letra.length() == 1 && (letra.equals("s") ||letra.equals("m") ||letra.equals("x") ||letra.equals("t") ||letra.equals("d")||letra.equals("q") )){
          uo= true; 
        }else{
            System.out.println("Ingrese un caracter indicado.");}
    }
         
    if (letra.equals("q")) {
      System.out.println("FIN DEL PROGRAMA.");  
    }
   
        //SUMA DE 2 MATRICES
        if (letra.equals("s")) {
          double[][] matriz2 = new double[filas][columnas];

        //entrada de elementos del array
        System.out.println("Ingrese los elementos de la segunda matriz:");

        // Llenar la matriz con los valores ingresados por el usuario
        for (int i = 0; i < filas; i++) {
            for (int j = 0; j < columnas; j++) {
                do {
                    System.out.println("Ingrese el elemento en la posición a(" + (i + 1) + ";" + (j + 1) + "):");

                    if (scanner.hasNextDouble()) {
                        matriz2[i][j] = scanner.nextDouble();
                        break; // Salir del bucle si se ingresó un número entero válido
                    } else {
                        System.out.println("Debe ingresar un número real.");
                        scanner.next(); // Consumir entrada inválida para evitar un bucle infinito
                    }
                } while (true);
            }}
        
        double[][] matrizsum = new double[filas][columnas];
        for(int i=0;i<filas;i++){
           for(int j=0;j<columnas;j++){
             matrizsum[i][j]=matriz[i][j]+matriz2[i][j];
           } 
        }
        System.out.println("|||||||| REPRESENTACIÓN DE LA SUMA  ||||||||");
        System.out.println(" ");
         for (int i = 0; i < matrizsum.length; i++) {
            System.out.print("[ ");
            for (int j = 0; j < matrizsum[i].length; j++) {
                
                System.out.print(matrizsum[i][j] + "  "); //Impresión de cada elemento y un espacio
                
            }
            System.out.print("] ");
            System.out.println(); // Salto de línea para crear una nueva fila
            
        }


            }
            
        //RESTA DE 2 MATRICES    
        if (letra.equals("m")){
            double[][] matriz2 = new double[filas][columnas];

        //entrada de elementos del array
        System.out.println("Ingrese los elementos de la segunda matriz:");

        // Llenar la matriz con los valores ingresados por el usuario
        for (int i = 0; i < filas; i++) {
            for (int j = 0; j < columnas; j++) {
                do {
                    System.out.println("Ingrese el elemento en la posición a(" + (i + 1) + ";" + (j + 1) + "):");

                    if (scanner.hasNextDouble()) {
                        matriz2[i][j] = scanner.nextDouble();
                        break; // Salir del bucle si se ingresó un número entero válido
                    } else {
                        System.out.println("Debe ingresar un número real.");
                        scanner.next(); // Consumir entrada inválida para evitar un bucle infinito
                    }
                } while (true);
            }}
        
        double[][] matrizsum = new double[filas][columnas];
        for(int i=0;i<filas;i++){
           for(int j=0;j<columnas;j++){
             matrizsum[i][j]=matriz[i][j]-matriz2[i][j];  
           } 
        }
        System.out.println("|||||||| REPRESENTACIÓN DE LA RESTA  ||||||||");
        System.out.println(" ");
         for (int i = 0; i < matrizsum.length; i++) {
            System.out.print("[ ");
            for (int j = 0; j < matrizsum[i].length; j++) {
                
                System.out.print(matrizsum[i][j] + "  "); //Impresión de cada elemento y un espacio
                
            }
            System.out.print("] ");
            System.out.println(); // Salto de línea para crear una nueva fila
        }
            }
        
        
            
        //TRAZA DE LA MATRIZ
        if(letra.equals("t")){
            if (filas==columnas) {
            
                double traz = 0;
                for(int i=0;i<filas;i++){
                    for(int j=0;j<columnas;j++){
                        if(i==j){
                       traz=matriz[i][j]+traz;}
                    } 
                }
                System.out.println("TRAZA DE LA MATRIZ");
                System.out.println(traz);
            }else {
                System.out.println("No se puede hallar una traza para matrices rectangulares. ");    
            }
        
        }
            
        //TRANSPUESTA DE UNA MATRIZ
            if(letra.equals("d")){
                double[][] matrizTranspuesta = new double[columnas][filas];
                filas = matriz.length;
                columnas = matriz[0].length;
                for (int i = 0; i < filas; i++) {
                    System.out.print("[ ");
                    for (int j = 0; j < columnas; j++) {
                        matrizTranspuesta[j][i] = matriz[i][j];
                 
                    }
                }
                
              // Obtener las dimensiones de la matriz transpuesta
              int filasTranspuesta = matrizTranspuesta.length;
              int columnasTranspuesta = matrizTranspuesta[0].length;

              // Imprimir la matriz transpuesta
               System.out.println("|||||||| REPRESENTACIÓN DE LA TRANSPUESTA  ||||||||");
              System.out.println(" ");
              for (int i = 0; i < filasTranspuesta; i++) {
                System.out.print("[ ");
                for (int j = 0; j < columnasTranspuesta; j++) {
                System.out.print(matrizTranspuesta[i][j] + "  ");
              }
              System.out.print("] ");
               System.out.println(); 
              }
              scanner.close();  
            }
        } 
    
        //funciones para determinar las propiedades de la matriz ingresada inicialmente
    
    public static boolean esRectangular(double[][]matriz){
        if(matriz.length!=matriz[0].length){
            return true;
        } else{
            return false;
        }
        
    }

    // Verificar si la matriz es nula
    public static boolean esMatrizNula(double[][] matriz) {
        //explicación: es una función o método (orientado a objetos), si es publica se puede llamar desde cualquier class, Static (devuelve valores), boolean (solo devuelve true o false).
        //(int[][]matriz); parametros int[][](matriz)
        for (double[] fila : matriz) {
            for (double elemento : fila) {
                if (elemento != 0) {
                    return false; //return (true o false) es como un break que asigna a "esMatrizNula" el valor de false o true para luego ser evaluado, al ejecutar el return se detiene esta funciona y devuelve el valor booleano
                }
            }
        }
        return true;
    }
    //Verificar si la matriz es simétrica
    //añadido recientemente
    public static boolean esSimetrica(double[][]matriz){
        boolean aux=true;
        for (int i = 0; i < matriz.length; i++){
            if(matriz.length!=matriz[0].length){
                aux=false;
                break;
            }
            for (int j = 0; j < matriz[0].length;j=j+1) {
                if (matriz[i][j] != matriz[j][i]) {
                       aux=false;
                       break; 
                    }
            }
        }
        return aux;
        
    }

    // Verificar si la matriz es identidad
    public static boolean esMatrizIdentidad(double[][] matriz) {
        int filas = matriz.length;
        int columnas = matriz[0].length;

        if (filas != columnas) {
            return false;
        }

        for (int i = 0; i < filas; i++) {
            for (int j = 0; j < columnas; j++) {
                if (i == j && matriz[i][j] != 1) {
                    return false;
                } else if (i != j && matriz[i][j] != 0) {
                    return false;
                }
            }
        }

        return true;
    }

    // Verificar si la matriz es escalar
    public static boolean esMatrizEscalar(double[][] matriz) {
        int filas = matriz.length;
        int columnas = matriz[0].length;

        if (filas != columnas) {
            return false;
        }

        double elementoPrincipal = matriz[0][0];

        for (int i = 0; i < filas; i++) {
            for (int j = 0; j < columnas; j++) {
                if (i == j && matriz[i][j] != elementoPrincipal) {
                    return false;
                } else if (i != j && matriz[i][j] != 0) {
                    return false;
                }
            }
        }

        return true;
    }
    
    // Verificar si la matriz es triangular superior
    public static boolean esMatrizTriangularSuperior(double[][] matriz) {
        int filas = matriz.length;

        for (int i = 1; i < filas; i++) {
            for (int j = 0; j < i; j++) {
                if (matriz[i][j] != 0) {
                    return false;
                }
            }
        }

        return true;
    }
    // Verificar si la matriz es triangular inferior
    public static boolean esMatrizTriangularInferior(double[][] matriz) {
        int filas = matriz.length;
        int columnas = matriz[0].length;

        for (int i = 0; i < filas - 1; i++) {
            for (int j = i + 1; j < columnas; j++) {
                if (matriz[i][j] != 0) {
                    return false;
                }
            }
        }

        return true;
    }

    // Verificar si la matriz es una fila
    public static boolean esMatrizFila(double[][] matriz) {
        int filas = matriz.length;
        int columnas = matriz[0].length;

        return filas == 1 && columnas > 1;
    }

    // Verificar si la matriz es una columna
    public static boolean esMatrizColumna(double[][] matriz) {
        int filas = matriz.length;
        int columnas = matriz[0].length;

        return filas > 1 && columnas == 1;
    }//equide
    //prueba de escritorio2
//MMMA

}

