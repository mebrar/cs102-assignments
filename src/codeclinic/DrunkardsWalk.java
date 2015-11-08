/**
 * Created by Ebrar on 08/11/15.
 */
package codeclinic;

import java.util.Random;

public class DrunkardsWalk {

    public static void main(String[]args){
        int xPosition = 0;
        int yPosition = 0;
        int direction;
        Random randomGenerator = new Random();

        for(int turns = 0; turns < 100; turns++){
            direction = randomGenerator.nextInt(4);
            switch (direction){
                case 0:
                    yPosition++;
                    break;
                case 1:
                    xPosition++;
                    break;
                case 2:
                    yPosition--;
                    break;
                case 3:
                    xPosition--;
                    break;
                default:
                    System.out.println("Something was wrong...");
            }
        }
        System.out.println("Drunkard's place is (" + xPosition + "," + yPosition + ") now...");
    }

}
