/*
 * MyConnectFour.
 * The main class that constructs other objects and plays each game.
 * @author sj2259
 */
public class MyConnectFour {
    public static void main(String[] args) {
        Board connect4 = new Board();

        HumanIPlayer human = new HumanIPlayer();
        ComputerIPlayer computer = new ComputerIPlayer();

        Game game = new Game(connect4, human, computer);
        game.playGame();
    }
}


