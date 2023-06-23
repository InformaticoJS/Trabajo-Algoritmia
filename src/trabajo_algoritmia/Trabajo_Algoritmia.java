package trabajo_algoritmia;
import java.util.*;

//esta es una prueba de edicion con github web editor (4:22pm) añadí una ; en el import :D
//este web editor es como una version web de visual code studio, tiene una funcion para correr el código, lo probaré.
//no disponible en el entorno web, le di al botón verde de continuar trabajando, me abrió una nueva ventada "codespaces" donde estoy instalando un depurador de java
//funciona, tarda un poco pero corre el código :D

public class Trabajo_Algoritmia {

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
            
            if(scanner.hasNextInt()){
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
        int[][] matriz = new int[filas][columnas];

        //entrada de elementos del array
        System.out.println("Ingrese los elementos de la matriz:");

        // Llenar la matriz con los valores ingresados por el usuario
        for (int i = 0; i < filas; i++) {
            for (int j = 0; j < columnas; j++) {
                do {
                    System.out.println("Ingrese el elemento en la posición a(" + (i + 1) + ";" + (j + 1) + "):");

                    if (scanner.hasNextInt()) {
                        matriz[i][j] = scanner.nextInt();
                        break; // Salir del bucle si se ingresó un número entero válido
                    } else {
                        System.out.println("Debe ingresar un número entero.");
                        scanner.next(); // Consumir entrada inválida para evitar un bucle infinito
                    }
                } while (true);
            }
        }
        scanner.close();
        //salida

        if (esMatrizNula(matriz)) {
            System.out.println("La matriz es nula.");
        } else if (esMatrizIdentidad(matriz)) {
            System.out.println("La matriz es identidad.");
        } else if (esMatrizEscalar(matriz)) {
            System.out.println("La matriz es escalar.");
        } else if (esMatrizFila(matriz)) {
            System.out.println("La matriz es una fila.");
        } else if (esMatrizColumna(matriz)) {
            System.out.println("La matriz es una columna.");
        } else {
            System.out.println("La matriz no cumple con ningún tipo específico.");
        }
        //representación gráfica de la matriz (prueba)

         for (int i = 0; i < matriz.length; i++) {
            for (int j = 0; j < matriz[i].length; j++) {
                
                System.out.print(matriz[i][j] + " "); //Impresión de cada elemento y un espacio
                
            }
            System.out.println(); // Salto de línea para crear una nueva fila
        }
    }

    // Verificar si la matriz es nula
    public static boolean esMatrizNula(int[][] matriz) {
        for (int[] fila : matriz) {
            for (int elemento : fila) {
                if (elemento != 0) {
                    return false;
                }
            }
        }
        return true;
    }

    // Verificar si la matriz es identidad
    public static boolean esMatrizIdentidad(int[][] matriz) {
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
    public static boolean esMatrizEscalar(int[][] matriz) {
        int filas = matriz.length;
        int columnas = matriz[0].length;

        if (filas != columnas) {
            return false;
        }

        int elementoPrincipal = matriz[0][0];

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

    // Verificar si la matriz es una fila
    public static boolean esMatrizFila(int[][] matriz) {
        int filas = matriz.length;
        int columnas = matriz[0].length;

        return filas == 1 && columnas > 1;
    }

    // Verificar si la matriz es una columna
    public static boolean esMatrizColumna(int[][] matriz) {
        int filas = matriz.length;
        int columnas = matriz[0].length;

        return filas > 1 && columnas == 1;
    }
}
