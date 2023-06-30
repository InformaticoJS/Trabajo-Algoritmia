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
            if(filas!=1){
            if (esMatrizNula(matriz)) {
                System.out.println("La matriz es nula.");
            } else{
                System.out.println("La matriz no es nula.");
            } 
            if (esMatrizIdentidad(matriz)&&!esMatrizNula(matriz)) {
                System.out.println("La matriz es identidad.");
            } else {
                System.out.println("La matriz no es identidad.");
            }
        
            if (esMatrizEscalar(matriz)&&!esMatrizNula(matriz)) {
                System.out.println("La matriz es escalar.");
            } else {
                System.out.println("La matriz no es escalar.");
            }
        //añadí una forma de saber si es simétrica cree un public boolean tambien para ello.
            if(esSimetrica(matriz)){
                System.out.println("La matriz es simétrica");
            } else {
                System.out.println("La matriz no es simétrica");
            }
            if(esMatrizTriangularSuperior(matriz)&&esMatrizTriangularInferior(matriz)&&!esMatrizNula(matriz)){
                System.out.println("La matriz es diagonal");
            }else {
             System.out.println("La matriz no es diagonal");
                }   
                if(esMatrizTriangularSuperior(matriz)&&!esMatrizNula(matriz)&&!esMatrizTriangularInferior(matriz)){
                    System.out.println("La matriz es triangular superior");
                }else {
                    System.out.println("La matriz no es triangular superior");
                }
         
                if(esMatrizTriangularInferior(matriz)&&!esMatrizNula(matriz)&&!esMatrizTriangularSuperior(matriz)){
                    System.out.println("La matriz es triangular inferior");
                }else {
                    System.out.println("La matriz no es triangular inferior");
               }
            
            if (!esMatrizEscalar(matriz)&&!esMatrizIdentidad(matriz)&&!esMatrizNula(matriz)&&!esSimetrica(matriz)&&!esMatrizTriangularSuperior(matriz)&&!esMatrizTriangularInferior(matriz)){
                System.out.println("La matriz no cumple con ningún tipo específico.");
            } }else{
                if (esMatrizNula(matriz)) {
                System.out.println("La matriz es nula.");
            } else{
                System.out.println("La matriz no es nula.");
            }
        if (esMatrizIdentidad(matriz)&&!esMatrizNula(matriz)) {
                System.out.println("La matriz es identidad.");
            } else {
                System.out.println("La matriz no es identidad.");
            }
            if (!esMatrizIdentidad(matriz)&&!esMatrizNula(matriz)){
                System.out.println("La matriz no cumple con ningún tipo específico.");
            }
        }} else {
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
        System.out.println(" ");
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
            System.out.println("Ingresa 'P' para hallar su transpuesta.");
            System.out.println("Ingresa 'D' para hallar su determinante.");
            
        String letra = " ";
        boolean uo=false;
         while (!uo) {
            
            letra = scanner.next();
            letra = letra.toLowerCase();
            
        
            if (letra.length() == 1 && (letra.equals("s") ||letra.equals("m") ||letra.equals("t") ||letra.equals("p")||letra.equals("d")||letra.equals("q") )){
                uo= true; 
            }else{
                System.out.println("Ingrese un caracter indicado.");}
        }
         
    if (letra.equals("q")) {
      System.out.println("FIN DEL PROGRAMA.");  
    }//si
   
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
            }
        }
        
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
            if(letra.equals("p")){
                double[][] matrizTranspuesta = new double[columnas][filas];
                filas = matriz.length;
                columnas = matriz[0].length;
                for (int i = 0; i < filas; i++) {
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
              
            }

            //DETERMINANTE
            if (letra.equals("d")) {
                double det = 0;
                if (filas > 0 && matriz.length == filas && matriz[0].length == filas) {
                    if (filas == 1) {
                        det = matriz[0][0];
                    } else if (filas == 2) {
                        det = matriz[0][0] * matriz[1][1] - matriz[0][1] * matriz[1][0];
                    } else {
                        det = calcularDeterminante(matriz); 
                    }
                    System.out.println("DETERMINANTE DE LA MATRIZ:");
                System.out.println(det);
                } else {
                    System.out.println("La matriz no es cuadrada. No se puede calcular la determinante.");
                    
                }             
                scanner.close();  
            }
            
        } 
    
        //métodos ( encapsula una serie de operaciones y devuelve un resultado específico ) para determinar las propiedades de la matriz ingresada inicialmente
        //la diferencia entre metodo y función es que el metodo esta asociado a una clase, es parte de ella, y se usan modificadores public, private, protected para modificar su acceso; mientras que la funcion no esta asociada a una funcion y no usa modificadores. puede ser llamada desde cualqueir parte del programa.

        //DETERMINANTES
        public static double calcularDeterminante(double[][] matriz) {
            double det = 0;
            int n = matriz.length;
    
            if (n == 1) {
                det = matriz[0][0];
            } else if (n == 2) {
                det = matriz[0][0] * matriz[1][1] - matriz[0][1] * matriz[1][0];
            } else {
                for (int j = 0; j < n; j++) {
                    double[][] submatriz = new double[n - 1][n - 1];
                    for (int fila = 1; fila < n; fila++) {
                        int columnaDestino = 0;
                        for (int columna = 0; columna < n; columna++) {
                            if (columna != j) {
                                submatriz[fila - 1][columnaDestino] = matriz[fila][columna];
                                columnaDestino++;
                            }
                        }
                    }
                    double cofactor = matriz[0][j] * calcularDeterminante(submatriz);
                    det += j % 2 == 0 ? cofactor : -cofactor;
                }
            }
    
            return det;
        }
        
    // Verificar si la matriz es nula
    public static boolean esMatrizNula(double[][] matriz) {
        //explicación: es una función o método (orientado a objetos), si es publica se puede llamar desde cualquier class, Static (devuelve valores), boolean (solo devuelve true o false).
        //(int[][]matriz); parametros int[][](matriz)
        for (double[] fila : matriz) { //bucle for-each o bucle mejorado, recorre "filas" en orden de menor a mayor hasta que ya no haya más filas en la matriz
            for (double elemento : fila) { //igualemnte, bucle for-each pero esta vez con cada elemento dentro de lafila  (los elemento matriz [ i ] [ j ]) y los evalua con el if
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
    }

}

