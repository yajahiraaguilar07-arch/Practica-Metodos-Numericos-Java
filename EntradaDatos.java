import java.util.Scanner;

public class EntradaDatos {

    public static int leerTamano(Scanner scanner) {
        int n;

        do {
            System.out.print("Ingrese el numero de ecuaciones: ");
            n = scanner.nextInt();

            if (n <= 0) {
                System.out.println("El tamaño debe ser mayor que cero.");
            }
        } while (n <= 0);

        return n;
    }

    public static double[][] leerMatriz(Scanner scanner, int n) {
        double[][] matriz = new double[n][n + 1];

        System.out.println("\nIngrese los coeficientes y el termino independiente:");

        for (int i = 0; i < n; i++) {
            System.out.println("Ecuacion " + (i + 1) + ":");

            for (int j = 0; j <= n; j++) {
                if (j < n) {
                    System.out.print("Coeficiente x" + (j + 1) + ": ");
                } else {
                    System.out.print("Termino independiente: ");
                }

                matriz[i][j] = scanner.nextDouble();
            }
        }

        return matriz;
    }
}
