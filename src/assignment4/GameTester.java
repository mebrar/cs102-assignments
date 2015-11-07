/**
 * Created by Muhammed Ebrar Erdem on 27/10/15.
 */
package assignment4;

import java.util.Scanner;

public class GameTester {

    public static void main(String[]args){

        Scanner stringScan = new Scanner(System.in);
        Scanner integerScan = new Scanner(System.in);
        String playerName;
        int difficulty;

        System.out.print("Enter player name: ");
        playerName = stringScan.nextLine();
        System.out.print("Enter difficulty level(1 to 3):");
        difficulty = integerScan.nextInt();
        Game newGame = new Game(playerName, difficulty);
        newGame.play();
    }
}