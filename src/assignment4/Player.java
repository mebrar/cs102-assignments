/**
 * Created by Muhammed Ebrar Erdem on 27/10/15.
 */
package assignment4;

public class Player extends GameCharacter {


    public Player(String playerName){
        super(playerName, 120, 0,0);
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

    /**
     *
     * @return
     */

    @Override
    public String toString() {
        return "assignment4.Player's name: " + name + " Current position: (" + (int)position.getX() + "," + (int)position.getY()  + ") and has " + points + " points...";
    }
}
