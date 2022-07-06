package model;

import positioning.SnakeBody;

import javax.swing.*;

import static positioning.Parameters.*;

public class CheckCollisions {

    public CheckCollisions() {
    }

    public static boolean checkCollisions(SnakeBody snakeBody, Timer timer, boolean running){
        //проверяет столкновение головы с телом
        for (int i = snakeBody.getBodyParts()-1; i>0; i--){
            if((snakeBody.getBody().get(0).getX() == snakeBody.getBody().get(i).getX())
                    && (snakeBody.getBody().get(0).getY() == snakeBody.getBody().get(i).getY())){
                running = false;
                break;
            }
        }
        //проверяет столкновение со стенками
        if(snakeBody.getBody().get(0).getX()<0
                || snakeBody.getBody().get(0).getX()>=SCREEN_WIDTH - SCREEN_WIDTH % UNIT_SIZE
                || snakeBody.getBody().get(0).getY()<0
                || snakeBody.getBody().get(0).getY()>=SCREEN_HEIGHT - SCREEN_HEIGHT % UNIT_SIZE){
            running = false;
        }

        if(!running){
            timer.stop();
        }

        return running;
    }
}
