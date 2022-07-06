import apple.Apple;
import model.CheckCollisions;
import model.DelayParameters;
import positioning.Direction;
import positioning.Movement;
import positioning.SnakeBody;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

import static positioning.Parameters.*;

public class GamePanelChanged  extends JPanel implements ActionListener {

    SnakeBody snakeBody;
    Apple apple = new Apple();
    DelayParameters delay;


    Direction direction;
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
        repaint();
        delay = new DelayParameters();
        direction = Direction.RIGHT;
        snakeBody = new SnakeBody();
        apple.refreshApple();
        apple.newApple(snakeBody);
        running = true;
        timer = new Timer(delay.getDelay(), this);
        timer.start();
    }

    public void paintComponent(Graphics g){
        super.paintComponent(g);
        draw(g);
    }

    public void draw(Graphics g){
        if(running){
            for(int i = 1; i <= SCREEN_HEIGHT/UNIT_SIZE; i++){
                g.drawLine(0, i*UNIT_SIZE,
                        SCREEN_WIDTH- SCREEN_WIDTH % UNIT_SIZE, i*UNIT_SIZE);
            }

            for(int i = 1; i <= SCREEN_WIDTH/UNIT_SIZE; i++){
                g.drawLine(i*UNIT_SIZE, 0,
                        i*UNIT_SIZE, SCREEN_HEIGHT - SCREEN_HEIGHT % UNIT_SIZE);
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


    public void gameOver(Graphics g){
        g.setColor(Color.RED);
        g.setFont(new Font("Ink Free", Font.BOLD, 75));
        FontMetrics metrics = getFontMetrics(g.getFont());
        g.drawString("Game Over",
                (SCREEN_WIDTH - metrics.stringWidth("Game Over"))/2, SCREEN_HEIGHT/2);

        g.setFont(new Font("Ink Free", Font.BOLD, 40));
        metrics = getFontMetrics(g.getFont());
        g.drawString("Your score: " + apple.getAppleEaten(),
                (SCREEN_WIDTH - metrics.stringWidth("Your score: " + apple.getAppleEaten()))/2,
                g.getFont().getSize());

        g.setFont(new Font("Ink Free", Font.BOLD, 20));
        metrics = getFontMetrics(g.getFont());
        g.drawString("Press 'Enter' to restart or 'ESC' to exit",
                (SCREEN_WIDTH - metrics.stringWidth("Press 'Enter' to restart or 'ESC' to exit"))/2,
                SCREEN_HEIGHT - 30);

    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(running) {
            Movement.move(snakeBody, direction);
            apple.checkApple(snakeBody, timer, delay);
            running = CheckCollisions.checkCollisions(snakeBody, timer, running);
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
                        GamePanelChanged.super.removeAll();
                        GamePanelChanged.super.repaint();
                        GamePanelChanged.super.revalidate();
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
