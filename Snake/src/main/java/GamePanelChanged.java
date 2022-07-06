import apple.Apple;
import model.CheckCollisions;
import positioning.Direction;
import positioning.SnakeBody;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

import static positioning.Parameters.*;
import static positioning.Parameters.SCREEN_HEIGHT;

public class GamePanelChanged  extends JPanel implements ActionListener {

    SnakeBody snakeBody;
    Apple apple = new Apple();
    CheckCollisions checkCollisions = new CheckCollisions();

    int delay;
    int timerAccelerator = 0;

    Direction direction = Direction.RIGHT;
    boolean running = false;

    Timer timer;

    public GamePanelChanged() {
        this.setPreferredSize(new Dimension(SCREEN_WIDTH, SCREEN_HEIGHT));
        this.setBackground(Color.BLACK);
        this.setFocusable(true);
        this.addKeyListener(new GamePanelChanged.MyKeyAdapter());
        startGame();
    }

    public void startGame(){
        delay = DELAY;
        snakeBody = new SnakeBody();
        apple.newApple(snakeBody);
        running = true;
        timer = new Timer(delay, this);
        timer.start();
    }

    public void paintComponent(Graphics g){
        super.paintComponent(g);
        draw(g);
    }

    public void draw(Graphics g){
        if(running){
            for(int i = 1; i < SCREEN_HEIGHT/UNIT_SIZE; i++){
                g.drawLine(0, i*UNIT_SIZE, SCREEN_WIDTH, i*UNIT_SIZE);
            }

            for(int i = 1; i < SCREEN_WIDTH/UNIT_SIZE; i++){
                g.drawLine(i*UNIT_SIZE, 0, i*UNIT_SIZE, SCREEN_HEIGHT);
            }

            g.setColor(Color.RED);
            g.fillOval(apple.getAppleX(), apple.getAppleY(), UNIT_SIZE, UNIT_SIZE);

            for(int part = 0; part < snakeBody.getBodyParts(); part++){
                if(part == 0){
                    g.setColor(Color.GREEN);
                    g.fillRect(snakeBody.getBody().get(0).getX(),
                            snakeBody.getBody().get(0).getY(),
                            UNIT_SIZE, UNIT_SIZE);
                } else {
                    g.setColor(new Color(45, 180, 0));
                    g.fillRect(snakeBody.getBody().get(part).getX(),
                            snakeBody.getBody().get(part).getY(),
                            UNIT_SIZE, UNIT_SIZE);
                }
            }
            g.setColor(Color.RED);
            g.setFont(new Font("Ink Free", Font.BOLD, 30));
            FontMetrics metrics = getFontMetrics(g.getFont());
            g.drawString("Your score: " + apple.getAppleEaten(),
                    (SCREEN_WIDTH - metrics.stringWidth("Your score: " + apple.getAppleEaten()))/2,
                    g.getFont().getSize());
        } else {
            gameOver(g);
        }
    }


    public void move(){
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

    public void checkApple(){
        if((snakeBody.getBody().get(0).getX() == apple.getAppleX())
                && (snakeBody.getBody().get(0).getY() == apple.getAppleY())){
            snakeBody.addBodyParts();
            apple.addAppleEaten();
            apple.newApple(snakeBody);
            timerAccelerator++;
        }

        if(timerAccelerator%5 == 0 && timerAccelerator != 0){
            timerAccelerator = 0;
            delay = delay*9/10;
            timer.setDelay(delay);
        }
    }


    public void gameOver(Graphics g){
        g.setColor(Color.RED);
        g.setFont(new Font("Ink Free", Font.BOLD, 75));
        FontMetrics metrics = getFontMetrics(g.getFont());
        g.drawString("Game Over", (SCREEN_WIDTH - metrics.stringWidth("Game Over"))/2, SCREEN_HEIGHT/2);

        g.setFont(new Font("Ink Free", Font.BOLD, 40));
        metrics = getFontMetrics(g.getFont());
        g.drawString("Your score: " + apple.getAppleEaten(),
                (SCREEN_WIDTH - metrics.stringWidth("Your score: " + apple.getAppleEaten()))/2,
                g.getFont().getSize());
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(running) {
            move();
            checkApple();
            running = checkCollisions.checkCollisions(snakeBody, timer, running);
        }
        repaint();
    }

    public class MyKeyAdapter extends KeyAdapter {
        @Override
        public void keyPressed(KeyEvent event){

            if(running){
                switch (event.getKeyCode()){
                    case KeyEvent.VK_LEFT:
                        if(direction!=Direction.RIGHT){
                            direction = Direction.LEFT;
                        }
                        break;
                    case KeyEvent.VK_RIGHT:
                        if(direction!=Direction.LEFT){
                            direction = Direction.RIGHT;
                        }
                        break;
                    case KeyEvent.VK_UP:
                        if(direction!=Direction.DOWN){
                            direction = Direction.UP;
                        }
                        break;
                    case KeyEvent.VK_DOWN:
                        if(direction!=Direction.UP){
                            direction = Direction.DOWN;
                        }
                        break;
                }
            } else {
                switch (event.getKeyCode()){
                    case KeyEvent.VK_ENTER:
                        startGame();
                        break;
                    case KeyEvent.VK_ESCAPE:
                        System.exit(1);
                        break;
                }
            }

        }
    }
}
