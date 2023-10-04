/*
 * ComputerPlayer.
 * A computer player that chooses a column at random.
 * @author sj2259
 */

import java.util.Random;
public class ComputerIPlayer implements IPlayer {

    Random r = new Random();

    @Override
    public String getUserInput() {
        // Draws a number in the range [0, 7).
        int input = r.nextInt(7);
        return String.valueOf(input);
    }
}
