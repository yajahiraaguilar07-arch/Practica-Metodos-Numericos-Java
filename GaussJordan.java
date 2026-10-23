public class GaussJordan {

    private static final double EPSILON = 1e-10;

    public static double[] resolver(double[][] matriz, int n) {

        // Convertir la matriz en una matriz identidad.
        for (int columna = 0; columna < n; columna++) {

            int pivote = columna;

            // Buscar el pivote de mayor valor absoluto.
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

            // Intercambiar filas si es necesario.
            double[] temporal = matriz[columna];
            matriz[columna] = matriz[pivote];
            matriz[pivote] = temporal;

            // Normalizar el pivote para que sea igual a uno.
            double divisor = matriz[columna][columna];

            for (int j = 0; j <= n; j++) {
                matriz[columna][j] /= divisor;
            }

            // Hacer cero los demás valores de la columna.
            for (int fila = 0; fila < n; fila++) {
                if (fila != columna) {
                    double factor = matriz[fila][columna];

                    for (int j = 0; j <= n; j++) {
                        matriz[fila][j] -=
                            factor * matriz[columna][j];
                    }
                }
            }
        }

        // Obtener las soluciones.
        double[] soluciones = new double[n];

        for (int i = 0; i < n; i++) {
            soluciones[i] = matriz[i][n];
        }

        return soluciones;
    }
}
