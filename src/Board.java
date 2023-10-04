/*
* Board.
* Contains the logic for handling the Connect4 board.
* @author sj2259
*/

public class Board {

    private final char[][] board;
    private final int[] columnHeight;

    public Board(){
        this(6, 7);
    }

    public Board(int boardWidth, int boardHeight){
        this.board = new char[boardWidth][boardHeight];
        this.columnHeight = new int[boardHeight];

        emptyBoard();
    }

    /*
     * Initialise the board with empty placeholder symbols.
     */
    public void emptyBoard(){

        for(int row = 0; row < board.length; row++){
            for(int column = 0; column < board[0].length; column++){
                board[row][column] = '.';
            }
        }
        setColumnHeight();
    }

    /*
    * Display the game board and the column heights.
    */
    public void printBoard(Board board){
        StringBuilder s = new StringBuilder();

        for (int row = 0; row < this.board.length; row++) {
            System.out.print("| ");
            for (int column = 0; column < this.board[0].length; column++) {
                System.out.print(this.board[row][column] + " | ");
            }
            System.out.println();
        }
        System.out.println("  0   1   2   3   4   5   6");

        s.append("Heights: [");

        for(int i = 0; i < this.board[0].length; i++){
            s.append(columnHeight[i]).append(" ");
        }
        s.append("]\n");

        System.out.println(s);
    }

    /*
    * Places a counter in the given column.
    *
    * @param counter The counter being dropped into place.
    * @param column  The column to drop the counter into. Start at 0.
    */
    public void placeCounter(char counter, int column) {
        if (column < 0 || column > board[0].length)
            throw new Error("Invalid column position.");

        // add counter to the bottom of a column
        for (int row = board.length - 1; row >= 0; row--) {
            // just check if space is empty
            if (board[row][column] == '.') {
                board[row][column] = counter;
                columnHeight[column]++;
                return;
            }
        }
    }

    /*
    * Determines if the placed counter makes four counters in a straight line.
    *
    * @param  counter The counter being dropped into place.
    * @return boolean Whether the placed counter makes four counters in a
    *                 straight line.
    */
    public boolean fourInaRow(char counter) {
        // check horizontal
        for (int column = 0; column < board[0].length - 3; column++) {
            for (int row = 0; row < board.length; row++) {
                if (this.board[row][column] == counter &&
                        this.board[row][column + 1] == counter &&
                        this.board[row][column + 2] == counter &&
                        this.board[row][column + 3] == counter) {
                    return true;
                }
            }
        }
        // check vertical
        for (int row = 0; row < board.length - 3; row++) {
            for (int column = 0; column < board[0].length; column++) {
                if (this.board[row][column] == counter &&
                        this.board[row + 1][column] == counter &&
                        this.board[row + 2][column] == counter &&
                        this.board[row + 3][column] == counter) {
                    return true;
                }
            }
        }
        // check diagonal bottom left to top right: /
        for (int row = 3; row < board.length; row++) {
            for (int column = 0; column < board[0].length - 3; column++) {
                if (this.board[row][column] == counter &&
                        this.board[row - 1][column + 1] == counter &&
                        this.board[row - 2][column + 2] == counter &&
                        this.board[row - 3][column + 3] == counter) {
                    return true;
                }
            }
        }
        // check diagonal top left to bottom right: \
        for (int row = 3; row < board.length; row++) {
            for (int column = 3; column < board[0].length; column++) {
                if (this.board[row][column] == counter &&
                        this.board[row - 1][column - 1] == counter &&
                        this.board[row - 2][column - 2] == counter &&
                        this.board[row - 3][column - 3] == counter) {
                    return true;
                }
            }
        }
        return false;
    }

    /*
    * @return returns true if a column is full.
    */
    public boolean isColumnFull(int column) {
        return columnHeight[column] == board[0].length - 1;
    }

    /*
    * @return returns true if the board is full.
    */
    public boolean isBoardFull() {
        boolean full = false;

        for (int row = 0; row < board[0].length; row++) {
            if (isColumnFull(row)){
                full = true;
                break;
            }
        }
        return full;
    }

    public void setColumnHeight(){
        for (int column = 0; column < board[0].length; column++){
            columnHeight[column] = 0;
        }
    }

}
