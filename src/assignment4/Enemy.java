/**
 * Created by Muhammed Ebrar Erdem on 27/10/15.
 */
package assignment4;

public abstract class Enemy extends GameCharacter{

    public Enemy(String name, int points, int xPos, int yPos) {
        super(name, points, xPos, yPos);
    }


    public abstract void takeAction();

    /**
     *
     * @return
     */

    @Override
    public String toString() {
        return "assignment4.Enemy's name: " + name + " Current position: (" + (int)position.getX() + "," + (int)position.getY() + ") and has " + points + " points...";
    }

}
