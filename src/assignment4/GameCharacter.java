/**
 * Created by Muhammed Ebrar Erdem on 27/10/15.
 */
package assignment4;

import java.awt.Point;

public abstract class GameCharacter implements MovableObject{

    protected String name;
    protected int points;
    protected Point position;
    protected final double ATTACK_RANGE = 1500;
    protected final int ATTACK_DAMAGE = 30;

    public GameCharacter(){
    }
    
    public GameCharacter(String name, int points, int xPos, int yPos){
        this.name = name;
        this.points = points;
        position = new Point(xPos, yPos);
    }
    
    /**
     *
     * @param amountToDecrease
     */

    public void decreasePoints(int amountToDecrease){
        points -= amountToDecrease;
    }

    /**
     *
     * @param other
     * @return
     */

    public boolean attack(GameCharacter other){
        if(other.isDead()){
            System.out.println(other.getName() + " is dead and cannot be attacked!");
            return false;
        }
        else if(this.isAtRange(other)){
            System.out.println(this.getName() + " attacked " + other.getName() + " and damaged " + this.ATTACK_DAMAGE +  " points!");
            other.decreasePoints(this.ATTACK_DAMAGE);
            return true;
        }
        else{
            System.out.println(this.getName() + " tried to attack " + other.getName() + " but " + other.getName() + " is out of range!");
            return false;
        }
    }

    /**
     *
     * @param other
     * @return
     */

    public boolean isAtRange(GameCharacter other){
        return this.getPosition().distance(other.getPosition()) <= this.ATTACK_RANGE;
    }

    /**
     *
     * @return
     */


    public boolean isDead(){
        return points <= 0;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getPoints() {
        return points;
    }

    public void setPoints(int points) {
        this.points = points;
    }

    public Point getPosition() {
        return position;
    }

    public void setPosition(Point position) {
        this.position = position;
    }

    public double getAttackRange() {
        return ATTACK_RANGE;
    }

    public int getAttackDamage() {
        return ATTACK_DAMAGE;
    }
}
