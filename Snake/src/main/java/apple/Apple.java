package apple;

import positioning.SnakeBody;

import java.util.Random;

import static positioning.Parameters.*;
import static positioning.Parameters.UNIT_SIZE;

public class Apple {

    private int appleX;
    private int appleY;
    private int appleEaten = 0;

    public Apple() {
    }

    public void newApple(SnakeBody snakeBody){
        Random random = new Random();
        appleX = random.nextInt((int)(SCREEN_WIDTH/UNIT_SIZE)) * UNIT_SIZE;
        appleY = random.nextInt((int)(SCREEN_HEIGHT/UNIT_SIZE)) * UNIT_SIZE;

        for(int i = 0; i<snakeBody.getBodyParts(); i++){
            if(appleX == snakeBody.getBody().get(i).getX()
                    && appleY == snakeBody.getBody().get(i).getY())
            {
                newApple(snakeBody);
            }
        }
    }

    public int getAppleX() {
        return appleX;
    }

    public int getAppleY() {
        return appleY;
    }

    public int getAppleEaten() {
        return appleEaten;
    }

    public void addAppleEaten() {
        this.appleEaten++;
    }
}
