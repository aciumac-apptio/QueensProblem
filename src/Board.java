import java.util.Arrays;

public class Board {
    private String[] board;

    public Board(int size) {
        this.board = new String[size];
        for (int i = 0; i < size; i++) {
            board[i] = new String(new char[size]).replace("\0", ".");
        }
    }

    public Board(Board board) {
        this.board = new String[board.size()];
        for (int i = 0; i < board.size(); i++) {
            this.board[i] = board.board[i];
        }
    }

    public boolean isSafe(int row, int column) {
        checkRowAndCol(row, column);
        return checkRow(row,column) && checkCol(row, column) && checkDiagonals(row, column);
    }

    public int size() {
        return board.length;
    }

    private boolean checkRow(int row, int column) {
        String r = board[row];
        r = r.substring(0, column) + r.substring(column + 1);
        return r.indexOf("Q") == -1;
    }

    private boolean checkCol(int row, int column) {
        // Just check characters as we walk
        for (int i = 0; i < board.length; i++) {
            if (i == row) {
                continue;
            }

            if(board[i].charAt(column) == 'Q') {
                return false;
            }
        }

        return true;
    }

    private boolean checkDiagonals(int row, int column) {
        // Walk to nw
        int curRow = row - 1;
        int curCol = column - 1;

        while (curRow >= 0 && curCol >= 0) {
            if (board[curRow].charAt(curCol) == 'Q') {
                return false;
            }
            curRow--;
            curCol--;
        }

        //Walk to ne
        curRow = row - 1;
        curCol = column + 1;
        while (curRow >= 0 && curCol < board.length) {
            if (board[curRow].charAt(curCol) == 'Q') {
                return false;
            }
            curRow--;
            curCol++;
        }

        //Walk to sw
        curRow = row + 1;
        curCol = column - 1;
        while (curRow < board.length && curCol >= 0) {
            if (board[curRow].charAt(curCol) == 'Q') {
                return false;
            }
            curRow++;
            curCol--;
        }

        //Walk to se
        curRow = row + 1;
        curCol = column + 1;
        while (curRow < board.length && curCol < board.length) {
            if (board[curRow].charAt(curCol) == 'Q') {
                return false;
            }
            curRow++;
            curCol++;
        }

        return true;
    }


    public void place(int row, int column) {
        checkRowAndCol(row, column);

        String r = board[row];
        r = r.substring(0, column) + 'Q' + r.substring(column + 1);
        board[row] = r;
    }

    private void checkRowAndCol(int row, int column) {
        if (row < 0 || row >= board.length) {
            throw new IllegalArgumentException("Row has to be between 0 and board size");
        }

        if (column < 0 || column >= board.length) {
            throw new IllegalArgumentException("Column has to be between 0 and board size");
        }
    }

    public void remove(int row, int column) {
        checkRowAndCol(row, column);
        String r = board[row];
        r = r.substring(0, column) + '.' + r.substring(column + 1);
        board[row] = r;
    }

    public void print() {
        System.out.println(Arrays.asList(board));
    }
}
