package positioning;

import static positioning.Parameters.UNIT_SIZE;

public class Movement {
    public static void move(SnakeBody snakeBody, Direction direction){
        for(int i = snakeBody.getBodyParts()-1; i>0; i--){
            snakeBody.getBody().get(i).setX(snakeBody.getBody().get(i-1).getX());
            snakeBody.getBody().get(i).setY(snakeBody.getBody().get(i-1).getY());
        }

        switch (direction){
            case UP: snakeBody.getBody().get(0)
                    .setY(snakeBody.getBody().get(0).getY() - UNIT_SIZE);
                break;
            case DOWN: snakeBody.getBody().get(0)
                    .setY(snakeBody.getBody().get(0).getY() + UNIT_SIZE);
                break;
            case LEFT: snakeBody.getBody().get(0)
                    .setX(snakeBody.getBody().get(0).getX() - UNIT_SIZE);
                break;
            case RIGHT: snakeBody.getBody().get(0)
                    .setX(snakeBody.getBody().get(0).getX() + UNIT_SIZE);
                break;
        }
    }
}
