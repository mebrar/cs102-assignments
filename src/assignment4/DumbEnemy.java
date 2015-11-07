/**
 * Created by Muhammed Ebrar Erdem on 27/10/15.
 */
package assignment4;

import java.util.Random;

public class DumbEnemy extends Enemy {


    public DumbEnemy(String enemyName, int points, int xPosition, int yPosition) {
        super(enemyName, points, xPosition, yPosition);
    }

    /**
     *
     */

    @Override
    public void takeAction() {
        int randomDirection = new Random().nextInt(4);
        switch (randomDirection){
            case 0:
                move(Direction.east);
                break;
            case 1:
                move(Direction.north);
                break;
            case 2:
                move(Direction.south);
                break;
            case 3:
                move(Direction.west);
                break;
            default:
                System.out.println("There's some error with the random number generator...");
        }

    }

    /**
     *
     * @param direction
     */

    @Override
    public void move(Direction direction) {
        if(direction.equals(Direction.east)){
            //moving to the right
            position.move((int)position.getX()+1,(int)position.getY());
        }
        else if(direction.equals(Direction.north)){
            //moving to the up
            position.move((int)position.getX(),(int)position.getY()+1);
        }
        else if(direction.equals(Direction.south)){
            //moving to the down
            position.move((int)position.getX(),(int)position.getY()-1);
        }
        else{
            //moving to the left
            position.move((int)position.getX()-1,(int)position.getY());
        }
    }
}
