/*
 * HumanPlayer.
 * Takes in input from the user.
 * @author sj2259
 */

import java.util.Scanner;

public class HumanIPlayer implements IPlayer {
    Scanner input = new Scanner(System.in);

    @Override
    public String getUserInput(){
        try {
            return input.nextLine();
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }
        // if not exception or read anything point to null
        return null;
    }

}
