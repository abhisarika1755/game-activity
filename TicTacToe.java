import java.util.Scanner;
public class TicTacToe {
    private static final int SIZE = 3;
    private static String[][] board = new String[SIZE][SIZE];
    private static final String PLAYER_ABHI = "Abhi";
    private static final String PLAYER_ROSHAN = "Roshan";
    private static String currentPlayer = PLAYER_ABHI;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Welcome to Tic Tac Toe!");
        System.out.println("Players take turns entering row and column numbers (e.g., 0 1).");

        boolean playAgain;
        do {
            initializeBoard();
            boolean gameEnded = false;

            while (!gameEnded) {
                printBoard();
                System.out.println("Player " + currentPlayer + ", enter your move (row and column): ");
                int row = scanner.nextInt();
                int col = scanner.nextInt();

                if (isValidMove(row, col)) {
                    board[row][col] = currentPlayer;
                    if (checkWin()) {
                        printBoard();
                        System.out.println("Player " + currentPlayer + " wins!");
                        gameEnded = true;
                    } else if (checkDraw()) {
                        printBoard();
                        System.out.println("It's a draw!");
                        gameEnded = true;
                    } else {
                        switchPlayer();
                    }
                } else {
                    System.out.println("Invalid move. Try again.");
                }
            }

            System.out.println("Do you want to play again? (yes/no): ");
            playAgain = scanner.next().equalsIgnoreCase("yes");
        } while (playAgain);

        System.out.println("Thanks for playing!");
        scanner.close();
    }

  
    private static void initializeBoard() {
        for (int i = 0; i < SIZE; i++)
            for (int j = 0; j < SIZE; j++)
                board[i][j] = " ";
        currentPlayer = PLAYER_ABHI;
    }

   
    private static void printBoard() {
        System.out.println("Current board:");
     
        System.out.print("    ");
        for (int c = 0; c < SIZE; c++) {
            System.out.printf("   %d   ", c);
        }
        System.out.println();

        
        for (int r = 0; r < SIZE; r++) {
        
            System.out.print("   ");
            for (int c = 0; c < SIZE; c++) {
                System.out.print("+-------");
            }
            System.out.println("+");

            
            System.out.print(" " + r + " ");
            for (int c = 0; c < SIZE; c++) {
                System.out.printf("| %6s", board[r][c]);
            }
            System.out.println("|");
        }

     
        System.out.print("   ");
        for (int c = 0; c < SIZE; c++) {
            System.out.print("+-------");
        }
        System.out.println("+");
    }

    
    private static boolean isValidMove(int row, int col) {
        return row >= 0 && row < SIZE && col >= 0 && col < SIZE && board[row][col].equals(" ");
    }

   
    private static void switchPlayer() {
        currentPlayer = currentPlayer.equals(PLAYER_ABHI) ? PLAYER_ROSHAN : PLAYER_ABHI;
    }

    
    private static boolean checkWin() {
        
        for (int i = 0; i < SIZE; i++) {
            if ((board[i][0].equals(currentPlayer) &&
                 board[i][1].equals(currentPlayer) &&
                 board[i][2].equals(currentPlayer)) ||
                (board[0][i].equals(currentPlayer) &&
                 board[1][i].equals(currentPlayer) &&
                 board[2][i].equals(currentPlayer))) {
                return true;
            }
        }

        // Check diagonals
        return (board[0][0].equals(currentPlayer) &&
                board[1][1].equals(currentPlayer) &&
                board[2][2].equals(currentPlayer)) ||
               (board[0][2].equals(currentPlayer) &&
                board[1][1].equals(currentPlayer) &&
                board[2][0].equals(currentPlayer));
    }

    // Checks for a draw condition
    private static boolean checkDraw() {
        for (int i = 0; i < SIZE; i++)
            for (int j = 0; j < SIZE; j++)
                if (board[i][j].equals(" "))
                    return false;
        return true;
    }
}
