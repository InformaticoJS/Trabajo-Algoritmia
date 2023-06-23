package trabajo_algoritmia;
import java.util.*
public class Trabajo_Algoritmia {

    public static void main(String[] args) {
        
        Scanner scanner = new Scanner(System.in);

        System.out.print("Ingrese el número de filas: ");
        int filas = scanner.nextInt();
        System.out.print("Ingrese el número de columnas: ");
        int columnas = scanner.nextInt();

        int[][] matriz = new int[filas][columnas];

        System.out.println("Ingrese los elementos de la matriz:");

        // Llenar la matriz con los valores ingresados por el usuario
        for (int i = 0; i < filas; i++) {
            for (int j = 0; j < columnas; j++) {
                matriz[i][j] = scanner.nextInt();
            }
        }

        scanner.close();

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
