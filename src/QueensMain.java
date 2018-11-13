import java.util.ArrayList;
import java.util.List;

public class QueensMain {

    public static void main(String[] args) {
	// write your code here
        placeAndRemoveQueensFromColumnTest(4, 1);
        placeAndRemoveQueensFromRowTest(4, 1);

        isSafeOnColumnTest(4, 1);
        isSafeOnRowTest(4, 1);

        isSafeOnMainDiagonalTest(4);
        isSafeOnMinorDiagonalTest(4);

        validQueensTest();
        invalidQueensTest();

        solveQueens(4);
        solveQueens(5);
    }

    public static void solveQueens(int n) {
        System.out.println("Solutions for a board of size " + n + " x " + n + ":");
        List<Board> choices = new ArrayList<>();
        explore(new Board(n), 0, choices);

        // Print all solutions
        for (Board brd: choices) {
            brd.print();
        }
        System.out.println();
    }

    private static boolean explore(Board board, int col, List<Board> choices) {
        if (col >= board.size()) {
            return true;
        } else {
            for (int row = 0; row < board.size(); row++) {
                if(board.isSafe(row, col)) {
                    board.place(row, col);
                    if (explore(board, col + 1, choices)) {
                        choices.add(new Board(board));
                    }
                    board.remove(row, col);
                }
            }
            return false;
        }
    }


    private static void invalidQueensTest() {
        System.out.println("Running invalidQueensTest:");
        Board board = new Board(4);

        System.out.println("Placing a queen at (0, 1):");
        board.place(0, 1);
        System.out.println("Placing a queen at (1, 2):");
        board.place(1, 2);
        System.out.println("Placing a queen at (2, 0):");
        board.place(2, 0);
        System.out.println("Placing a queen at (3, 2):");
        board.place(3, 2);

        board.print();
        System.out.println("Queen at (" + 0 + ", " + 1 + ") is safe? " + board.isSafe(0, 1));
        System.out.println("Queen at (" + 1 + ", " + 2 + ") is safe? " + board.isSafe(1, 2));
        System.out.println("Queen at (" + 2 + ", " + 0 + ") is safe (only safe queen)? " + board.isSafe(2, 0));
        System.out.println("Queen at (" + 3 + ", " + 2 + ") is safe? " + board.isSafe(3, 2));

        System.out.println();
    }

    private static void validQueensTest() {
        System.out.println("Running validQueensTest:");
        Board board = new Board(4);

        System.out.println("Placing a queen at (0, 1):");
        board.place(0, 1);
        System.out.println("Placing a queen at (1, 3):");
        board.place(1, 3);
        System.out.println("Placing a queen at (2, 0):");
        board.place(2, 0);
        System.out.println("Placing a queen at (3, 2):");
        board.place(3, 2);

        board.print();
        System.out.println("Queen at (" + 0 + ", " + 1 + ") is safe? " + board.isSafe(0, 1));
        System.out.println("Queen at (" + 1 + ", " + 3 + ") is safe? " + board.isSafe(1, 3));
        System.out.println("Queen at (" + 2 + ", " + 0 + ") is safe? " + board.isSafe(2, 0));
        System.out.println("Queen at (" + 3 + ", " + 2 + ") is safe? " + board.isSafe(3, 2));

        System.out.println();
    }

    private static void isSafeOnRowTest(int n, int row) {
        System.out.println("Running isSafeOnRowTest:");
        Board board = new Board(n);
        board.print();

        System.out.println("Place Queens on row " + row + ":");
        for (int i = 0; i < board.size(); i++) {
            board.place(row, i);
        }

        board.print();

        for (int i = 0; i < board.size(); i++) {
            System.out.println("Queen at (" + row + ", " + i + ") is safe? " + board.isSafe(row, i));
        }

        System.out.println();
    }

    private static void isSafeOnMinorDiagonalTest(int n) {
        System.out.println("Running isSafeOnMinorDiagonalTest:");
        Board board = new Board(n);
        board.print();

        System.out.println("Place Queens on minor diagonal:");
        for (int i = 0; i < board.size(); i++) {
            board.place(i, board.size() - 1 - i);
        }

        board.print();

        for (int i = 0; i < board.size(); i++) {
            System.out.println("Queen at (" + i + ", " + (board.size() - 1 - i) + ") is safe? " + board.isSafe(i, board.size() - 1 - i));
        }

        System.out.println();
    }

    private static void isSafeOnMainDiagonalTest(int n) {
        System.out.println("Running isSafeOnMainDiagonalTest:");
        Board board = new Board(n);
        board.print();

        System.out.println("Place Queens on main diagonal:");
        for (int i = 0; i < board.size(); i++) {
            board.place(i, i);
        }

        board.print();

        for (int i = 0; i < board.size(); i++) {
            System.out.println("Queen at (" + i + ", " + i + ") is safe? " + board.isSafe(i, i));
        }

        System.out.println();
    }

    private static void isSafeOnColumnTest(int n, int column) {
        System.out.println("Running isSafeOnColumnTest:");
        Board board = new Board(n);
        board.print();

        System.out.println("Place Queens on column " + column + ":");
        for (int i = 0; i < board.size(); i++) {
            board.place(i, column);
        }

        board.print();

        for (int i = 0; i < board.size(); i++) {
            System.out.println("Queen at (" + i + ", " + column + ") is safe? " + board.isSafe(i, column));
        }

        System.out.println();
    }

    private static void placeAndRemoveQueensFromColumnTest(int n, int column) {
        System.out.println("Running placeAndRemoveQueensFromColumnTest:");
        Board board = new Board(n);
        board.print();

        System.out.println("Place Queens on column " + column + ":");
        for (int i = 0; i < board.size(); i++) {
            board.place(i, column);
        }

        board.print();
        System.out.println("Remove Queens from column " + column + ":");
        for (int i = 0; i < board.size(); i++) {
            board.remove(i, column);
        }
        board.print();
        System.out.println();
    }

    private static void placeAndRemoveQueensFromRowTest(int n, int row) {
        System.out.println("Running placeAndRemoveQueensFromRowTest:");
        Board board = new Board(n);
        board.print();

        System.out.println("Place Queens on row " + row + ":");
        for (int i = 0; i < board.size(); i++) {
            board.place(row, i);
        }

        board.print();
        System.out.println("Remove Queens from row " + row + ":");
        for (int i = 0; i < board.size(); i++) {
            board.remove(row, i);
        }
        board.print();
        System.out.println();
    }


}
