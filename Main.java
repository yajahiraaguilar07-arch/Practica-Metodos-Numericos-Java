import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("==================================");
        System.out.println(" METODO DE GAUSS-JORDAN EN JAVA");
        System.out.println(" Estudiante: Yajahira Aguilar");
        System.out.println("==================================");

        try {
            int n = EntradaDatos.leerTamano(scanner);
            double[][] matriz = EntradaDatos.leerMatriz(scanner, n);

            System.out.println("\nMatriz aumentada original:");
            Gauss.imprimirMatriz(matriz, n);

            double[] soluciones = GaussJordan.resolver(matriz, n);

            System.out.println("\nMatriz reducida:");
            Gauss.imprimirMatriz(matriz, n);

            System.out.println("\nSoluciones del sistema:");

            for (int i = 0; i < n; i++) {
                System.out.printf("x%d = %.4f%n", i + 1, soluciones[i]);
            }

        } catch (ArithmeticException e) {
            System.out.println("\nNo se pudo obtener una solucion unica.");
            System.out.println(e.getMessage());
        } catch (Exception e) {
            System.out.println("\nError al leer los datos.");
            System.out.println("Verifica que hayas ingresado numeros validos.");
        } finally {
            scanner.close();
        }
    }
}
