/**
 * Created by Muhammed Ebrar Erdem on 27/10/15.
 */
package assignment4;

public class SmartEnemy extends Enemy {

    private Player player;

    public SmartEnemy(String enemyName, int points, int xPosition, int yPosition, Player player) {
        super(enemyName, points, xPosition, yPosition);
        this.player = player;
    }

    /**
     *
     */

    @Override
    public void takeAction() {
        if(this.isAtRange(player)){
            this.attack(player);
        }
        else {
            if (Math.abs(player.position.getX() - this.position.getX()) > Math.abs(player.position.getY() - this.position.getY())) {
                if (player.position.getX() - this.position.getX() > 0) {
                    this.move(Direction.east);
                } else {
                    this.move(Direction.west);
                }
            } else {
                if (player.position.getY() - this.position.getY() > 0) {
                    this.move(Direction.north);
                } else {
                    this.move(Direction.south);
                }
            }
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
