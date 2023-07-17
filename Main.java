public class Main {

    public static void main(String[] args) {
        int[][] A = {
            {1, 2, 3, 4},
            {5, 6, 7, 8},
            {9, 10, 11, 12},
            {13, 14, 15, 16}
        };

        int[][] B = {
            {17, 18, 19, 20},
            {21, 22, 23, 24},
            {25, 26, 27, 28},
            {29, 30, 31, 32}
        };

        AlgoritmoStrassen strassen = new AlgoritmoStrassen();
        
        // Iniciar a contagem do tempo
        long tempoInicio = System.nanoTime();

        int[][] C = strassen.multiplicar(A, B);

        // Parar a contagem do tempo
        long tempoFim = System.nanoTime();

        // Calcular o tempo total em segundos
        double tempoTotal = (tempoFim - tempoInicio) / 1_000_000_000.0;

        System.out.println("Matriz A:");
        strassen.printMatriz(A);

        System.out.println("\nMatriz B:");
        strassen.printMatriz(B);

        System.out.println("\nMatriz C (A * B):");
        strassen.printMatriz(C);

        System.out.printf("\nTempo total de execução: %.9f segundos%n", tempoTotal);
    }

}