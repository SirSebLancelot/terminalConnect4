/*
 * Game.
 * Contains the logic for two players to take turns playing Connect4.
 * @author sj2259
 */

public class Game {
    private final Board board;
    private char counter = 'X';
    HumanIPlayer human;
    ComputerIPlayer computer;

    public Game(Board board, HumanIPlayer human, ComputerIPlayer computer) {
        this.board = board;
        this.human = human;
        this.computer = computer;
    }

    /*
    * Play Connect4 between a human player and a computer until a player wins.
    */
    public void playGame() {


        while (!board.isBoardFull()) {
            board.printBoard(board);

            System.out.println("Player " + counter + ", choose a column: ");

            // human player uses counter X
            if (counter == 'X') {
                String userInput = human.getUserInput();
                int move = Integer.parseInt(userInput);

                // check if column is full
                if (board.isColumnFull(move)){
                    System.out.println("Invalid column");
                    continue;
                } else {
                    board.placeCounter(counter, move);
                }

            } else {
                String userInput = computer.getUserInput();
                int move = Integer.parseInt(userInput);

                if (board.isColumnFull(move)){
                    System.out.println("Invalid column");
                    continue;
                } else {
                    board.placeCounter(counter, move);
                }
            }

            boolean win = board.fourInaRow(counter);

            if (win) {
                if (counter == 'X'){
                    System.out.println("You have Won!!!");
                } else {
                    System.out.println("You lost - pathetic!!!");
                }
                board.printBoard(board);
                break;
            }

            // switch players
            if (counter == 'X'){
                counter = 'O';
            } else {
                counter = 'X';
            }
        }
    }
}



