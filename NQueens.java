
package DAA;



import java.util.Scanner;

public class NQueens {

    static int N;

    // Check whether the position is safe
    static boolean isSafe(int board[][], int row, int col) {

        // Check same row
        for (int j = 0; j < col; j++) {
            if (board[row][j] == 1)
                return false;
        }

        // Check upper diagonal
        for (int i = row - 1, j = col - 1;
             i >= 0 && j >= 0; i--, j--) {

            if (board[i][j] == 1)
                return false;
        }

        // Check lower diagonal
        for (int i = row + 1, j = col - 1;
             i < N && j >= 0; i++, j--) {

            if (board[i][j] == 1)
                return false;
        }

        return true;
    }

    // Solve using Backtracking
    static boolean solveNQueens(int board[][], int col) {

        if (col >= N)
            return true;

        for (int row = 0; row < N; row++) {

            if (isSafe(board, row, col)) {

                board[row][col] = 1;

                if (solveNQueens(board, col + 1))
                    return true;

                // Backtracking
                board[row][col] = 0;
            }
        }

        return false;
    }

    public static void main(String args[]) {

        Scanner sc = new Scanner(System.in);

        System.out.print("Enter N: ");
        N = sc.nextInt();

        if (N < 1) {
            System.out.println("Enter a valid N");
            sc.close();
            return;
        }

        int board[][] = new int[N][N];

        // Place first Queen at (0,1) for N >= 2
        if (N == 1) {
            board[0][0] = 1;
        } else {
            board[0][1] = 1;
        }

        // Start placing remaining Queens
        if (solveNQueens(board, 0)) {

            System.out.println("N-Queens Solution:");

            for (int i = 0; i < N; i++) {
                for (int j = 0; j < N; j++) {
                    System.out.print(board[i][j] + " ");
                }
                System.out.println();
            }

        } else {
            System.out.println("Solution does not exist");
        }

        sc.close();
    }
}
