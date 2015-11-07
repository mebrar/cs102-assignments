package assignment4; /**
 * Created by Muhammed Ebrar Erdem on 27/10/15.
 */

import java.util.Scanner;
import java.util.Random;
import java.util.ArrayList;

public class Game implements Difficulty {

    private Player player;
    private int difficultyLevel;
    private ArrayList<Enemy> enemies;
    Random coordinateGenerator = new Random();
    private static final int ENEMY_RANDOM_COORDINATE_LIMIT = 20;
    private static final int ENEMY_APPLY_NEGATIVE = ENEMY_RANDOM_COORDINATE_LIMIT/2;
    private static final int DUMB_POINT = 30;
    private static final int SMART_POINT = 60;

    public Game(String playerName, int difficultyLevel) {
        player = new Player(playerName);
        this.difficultyLevel = difficultyLevel;
        enemies = new ArrayList<Enemy>();
        if (difficultyLevel == 1){
            DumbEnemy dumbEnemy1 = new DumbEnemy("enemy1",DUMB_POINT,coordinateGenerator.nextInt(ENEMY_RANDOM_COORDINATE_LIMIT)-ENEMY_APPLY_NEGATIVE,coordinateGenerator.nextInt(ENEMY_RANDOM_COORDINATE_LIMIT)-ENEMY_APPLY_NEGATIVE);
            enemies.add(dumbEnemy1);
            DumbEnemy dumbEnemy2 = new DumbEnemy("enemy2",DUMB_POINT,coordinateGenerator.nextInt(ENEMY_RANDOM_COORDINATE_LIMIT)-ENEMY_APPLY_NEGATIVE,coordinateGenerator.nextInt(ENEMY_RANDOM_COORDINATE_LIMIT)-ENEMY_APPLY_NEGATIVE);
            enemies.add(dumbEnemy2);
            DumbEnemy dumbEnemy3 = new DumbEnemy("enemy3",DUMB_POINT,coordinateGenerator.nextInt(ENEMY_RANDOM_COORDINATE_LIMIT)-ENEMY_APPLY_NEGATIVE,coordinateGenerator.nextInt(ENEMY_RANDOM_COORDINATE_LIMIT)-ENEMY_APPLY_NEGATIVE);
            enemies.add(dumbEnemy3);
        }
        else if(difficultyLevel == 2){
            DumbEnemy dumbEnemy1 = new DumbEnemy("enemy1",DUMB_POINT,coordinateGenerator.nextInt(ENEMY_RANDOM_COORDINATE_LIMIT)-ENEMY_APPLY_NEGATIVE,coordinateGenerator.nextInt(ENEMY_RANDOM_COORDINATE_LIMIT)-ENEMY_APPLY_NEGATIVE);
            enemies.add(dumbEnemy1);
            DumbEnemy dumbEnemy2 = new DumbEnemy("enemy2",DUMB_POINT,coordinateGenerator.nextInt(ENEMY_RANDOM_COORDINATE_LIMIT)-ENEMY_APPLY_NEGATIVE,coordinateGenerator.nextInt(ENEMY_RANDOM_COORDINATE_LIMIT)-ENEMY_APPLY_NEGATIVE);
            enemies.add(dumbEnemy2);
            SmartEnemy smartEnemy1 = new SmartEnemy("enemy3",SMART_POINT,coordinateGenerator.nextInt(ENEMY_RANDOM_COORDINATE_LIMIT)-ENEMY_APPLY_NEGATIVE,coordinateGenerator.nextInt(ENEMY_RANDOM_COORDINATE_LIMIT)-ENEMY_APPLY_NEGATIVE, player);
            enemies.add(smartEnemy1);
        }
        else{
            SmartEnemy smartEnemy1 = new SmartEnemy("enemy1",SMART_POINT,coordinateGenerator.nextInt(ENEMY_RANDOM_COORDINATE_LIMIT)-ENEMY_APPLY_NEGATIVE,coordinateGenerator.nextInt(ENEMY_RANDOM_COORDINATE_LIMIT)-ENEMY_APPLY_NEGATIVE, player);
            enemies.add(smartEnemy1);
            SmartEnemy smartEnemy2 = new SmartEnemy("enemy2",SMART_POINT,coordinateGenerator.nextInt(ENEMY_RANDOM_COORDINATE_LIMIT)-ENEMY_APPLY_NEGATIVE,coordinateGenerator.nextInt(ENEMY_RANDOM_COORDINATE_LIMIT)-ENEMY_APPLY_NEGATIVE, player);
            enemies.add(smartEnemy2);
            SmartEnemy smartEnemy3 = new SmartEnemy("enemy3",SMART_POINT,coordinateGenerator.nextInt(ENEMY_RANDOM_COORDINATE_LIMIT)-ENEMY_APPLY_NEGATIVE,coordinateGenerator.nextInt(ENEMY_RANDOM_COORDINATE_LIMIT)-ENEMY_APPLY_NEGATIVE, player);
            enemies.add(smartEnemy3);
        }
    }

    public void play(){
        String prompt;
        boolean validPrompt;
        Scanner keyboardScanner = new Scanner(System.in);
        System.out.println("assignment4.Game just started with difficulty level " + difficultyLevel);
        System.out.println("assignment4.Player is created as:\n" +player);
        printEnemies();
        System.out.print("Enter a prompt('help' for instructions & 'quit' for quit):");
        prompt = keyboardScanner.nextLine();

        while(!prompt.equalsIgnoreCase("quit")){
            if(prompt.equalsIgnoreCase("help")){
            	validPrompt = true;
                printHelpInstructions();
            }
            else if(prompt.equalsIgnoreCase("attack enemy1")){
            	validPrompt = true;
                findAndAttackEnemy("enemy1");
            }
            else if(prompt.equalsIgnoreCase("attack enemy2")){
            	validPrompt = true;
                findAndAttackEnemy("enemy2");
            }
            else if(prompt.equalsIgnoreCase("attack enemy3")){
            	validPrompt = true;
                findAndAttackEnemy("enemy3");
            }
            else if(prompt.equalsIgnoreCase("move north")){
            	validPrompt = true;
                player.move(Direction.north);
            }
            else if(prompt.equalsIgnoreCase("move south")){
            	validPrompt = true;
                player.move(Direction.south);
            }
            else if(prompt.equalsIgnoreCase("move east")){
            	validPrompt = true;
                player.move(Direction.east);
            }
            else if(prompt.equalsIgnoreCase("move west")){
            	validPrompt = true;
                player.move(Direction.west);
            }
            else if(prompt.equalsIgnoreCase("quit")){
            	validPrompt = true;
            	break;
            }
            else{
            	validPrompt = false;
                System.out.println("You've made a typo in the prompt...");
                while(!validPrompt){
                System.out.print("Enter a prompt again('help' for instructions & 'quit' for quit):");
                prompt = keyboardScanner.nextLine();
                continue;
                }
            }
            enemiesAttackPlayer();
            System.out.println(player);
            if(player.isDead()){
                System.out.println("You are dead now...");
                break;
            }
            if(isThereEnemy()){
                printEnemies();
            }
            else{
            	System.out.println("You won! Conguratulations!");
            	break;
            }
            System.out.print("Enter a prompt('help' for instructions & 'quit' for quit):");
            prompt = keyboardScanner.nextLine();
        }
    }

    @Override
    public void setDifficultyLevel(int difficultyLevel) {
        this.difficultyLevel = difficultyLevel;
    }

    @Override
    public int getDifficultyLevel() {
        return difficultyLevel;
    }

    /**
     *
     * @param enemyName
     */

    private void findAndAttackEnemy(String enemyName){
        for (int index = 0; index < enemies.size(); index++){
            if(enemies.get(index).getName().equalsIgnoreCase(enemyName)&&!enemies.get(index).isDead()){
                player.attack(enemies.get(index));
            }
        }
    }

    /**
     *
     */

    private void enemiesAttackPlayer(){
        for (int index = 0; index < enemies.size(); index++){
            enemies.get(index).takeAction();
        }
    }

    private void printEnemies(){
        for (int index = 0; index < enemies.size(); index++){
            System.out.println(enemies.get(index));
        }
    }


    /**
     *
     * @return
     */

    private boolean isThereEnemy(){
        for (int index = 0; index < enemies.size(); index++){
            if(enemies.get(index).isDead()){
                System.out.println(enemies.get(index).getName() + " is dead now...");
                enemies.remove(index);
            }
        }
        return !enemies.isEmpty();
    }

    /**
     *
     * @param direction
     */

    private void movePlayer(String direction){
        if(direction.equalsIgnoreCase("east")){
            player.move(Direction.east);
        }
        else if(direction.equalsIgnoreCase("north")){
            player.move(Direction.north);
        }
        else if(direction.equalsIgnoreCase("south")){
            player.move(Direction.south);
        }
        else if(direction.equalsIgnoreCase("west")){
            player.move(Direction.west);
        }
        else{
            System.out.println("You've entered a wrong direction and player can not be moved.");
        }
    }

    /**
     * Prints the
     */

    private void printHelpInstructions(){
        System.out.println("help: lists every available command the user can enter\nquit: quits the game\nattack 'name': makes the player attack theEnemy with the given name\nmove 'direction': makes the player move towards the given direction.");
    }
}