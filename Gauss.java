public class Gauss {

    private static final double EPSILON = 1e-10;

    public static void eliminar(double[][] matriz, int n) {
        for (int columna = 0; columna < n; columna++) {

            int pivote = columna;

            for (int fila = columna + 1; fila < n; fila++) {
                if (Math.abs(matriz[fila][columna]) >
                    Math.abs(matriz[pivote][columna])) {
                    pivote = fila;
                }
            }

            if (Math.abs(matriz[pivote][columna]) < EPSILON) {
                throw new ArithmeticException(
                    "El sistema no tiene una solucion unica."
                );
            }

            double[] temporal = matriz[columna];
            matriz[columna] = matriz[pivote];
            matriz[pivote] = temporal;

            for (int fila = columna + 1; fila < n; fila++) {
                double factor =
                    matriz[fila][columna] / matriz[columna][columna];

                for (int j = columna; j <= n; j++) {
                    matriz[fila][j] -= factor * matriz[columna][j];
                }
            }
        }
    }

    public static void imprimirMatriz(double[][] matriz, int n) {
        for (int i = 0; i < n; i++) {
            for (int j = 0; j <= n; j++) {
                System.out.printf("%10.4f ", matriz[i][j]);
            }
            System.out.println();
        }
    }
}
