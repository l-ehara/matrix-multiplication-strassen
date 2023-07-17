public class AlgoritmoStrassen {

    // Método principal que realiza a multiplicação de matrizes usando o algoritmo de Strassen
    public int[][] multiplicar(int[][] A, int[][] B) {
        int n = A.length;
        if (n == 1) {
            return new int[][]{{A[0][0] * B[0][0]}};
        }

        // Dividindo as matrizes A e B em 4 submatrizes cada
        int[][] A11 = new int[n / 2][n / 2];
        int[][] A12 = new int[n / 2][n / 2];
        int[][] A21 = new int[n / 2][n / 2];
        int[][] A22 = new int[n / 2][n / 2];
        int[][] B11 = new int[n / 2][n / 2];
        int[][] B12 = new int[n / 2][n / 2];
        int[][] B21 = new int[n / 2][n / 2];
        int[][] B22 = new int[n / 2][n / 2];

        dividir(A, A11, 0, 0);
        dividir(A, A12, 0, n / 2);
        dividir(A, A21, n / 2, 0);
        dividir(A, A22, n / 2, n / 2);
        dividir(B, B11, 0, 0);
        dividir(B, B12, 0, n / 2);
        dividir(B, B21, n / 2, 0);
        dividir(B, B22, n / 2, n / 2);

        // Calculando os produtos P1 a P7
        int[][] P1 = multiplicar(A11, subtrair(B12, B22));
        int[][] P2 = multiplicar(somar(A11, A12), B22);
        int[][] P3 = multiplicar(somar(A21, A22), B11);
        int[][] P4 = multiplicar(A22, subtrair(B21, B11));
        int[][] P5 = multiplicar(somar(A11, A22), somar(B11, B22));
        int[][] P6 = multiplicar(subtrair(A12, A22), somar(B21, B22));
        int[][] P7 = multiplicar(subtrair(A11, A21), somar(B11, B12));

        // Calculando os quadrantes da matriz resultante C
        int[][] C11 = somar(subtrair(somar(P5, P4), P2), P6);
        int[][] C12 = somar(P1, P2);
        int[][] C21 = somar(P3, P4);
        int[][] C22 = subtrair(subtrair(somar(P5, P1), P3), P7);

        // Combinando os quadrantes para obter a matriz resultante completa
        int[][] C = new int[n][n];
        juntar(C11, C, 0, 0);
        juntar(C12, C, 0, n / 2);
        juntar(C21, C, n / 2, 0);
        juntar(C22, C, n / 2, n / 2);
        return C;
    }

    // Método para dividir uma matriz em 4 submatrizes
    private void dividir(int[][] P, int[][] C, int iB, int jB) {
        for (int i1 = 0, i2 = iB; i1 < C.length; i1++, i2++) {
            for (int j1 = 0, j2 = jB; j1 < C.length; j1++, j2++) {
                C[i1][j1] = P[i2][j2];
            }
        }
    }

    // Método para juntar 4 submatrizes em uma matriz completa
    private void juntar(int[][] C, int[][] P, int iB, int jB) {
        for (int i1 = 0, i2 = iB; i1 < C.length; i1++, i2++) {
            for (int j1 = 0, j2 = jB; j1 < C.length; j1++, j2++) {
                P[i2][j2] = C[i1][j1];
            }
        }
    }

    // Método para somar duas matrizes
    private int[][] somar(int[][] A, int[][] B) {
        int n = A.length;
        int[][] C = new int[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                C[i][j] = A[i][j] + B[i][j];
            }
        }
        return C;
    }

    // Método para subtrair duas matrizes
    private int[][] subtrair(int[][] A, int[][] B) {
        int n = A.length;
        int[][] C = new int[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                C[i][j] = A[i][j] - B[i][j];
            }
        }
        return C;
    }

    public void printMatriz(int[][] matriz) {
        for (int[] linha : matriz) {
            for (int elemento : linha) {
                System.out.print(elemento + " ");
            }
            System.out.println();
        }
    }
}
