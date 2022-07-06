//import positioning.Direction;
//
//import javax.swing.*;
//import java.awt.*;
//import java.awt.event.*;
//import java.util.Random;
//
//import static positioning.Parameters.*;
//
//public class GamePanel extends JPanel implements ActionListener {
//
//    final int[] x = new int[GAME_UNITS];
//    final int[] y = new int[GAME_UNITS];
//
//    int bodyParts = 6;
//    int applesEaten = 0;
//    int appleX;
//    int appleY;
//
//    Direction direction = Direction.DOWN;
//    boolean running = false;
//
//    Timer timer;
//    Random random;
//
//    public GamePanel() {
//        random = new Random();
//        this.setPreferredSize(new Dimension(SCREEN_WIDTH, SCREEN_HEIGHT));
//        this.setBackground(Color.BLACK);
//        this.setFocusable(true);
//        this.addKeyListener(new MyKeyAdapter());
//        startGame();
//    }
//
//    public void startGame(){
//        newApple();
//        running = true;
//        timer = new Timer(DELAY, this);
//        timer.start();
//    }
//
//    public void paintComponent(Graphics g){
//        super.paintComponent(g);
//        draw(g);
//    }
//
//    public void draw(Graphics g){
//        if(running){
//            for(int i = 1; i < SCREEN_HEIGHT/UNIT_SIZE; i++){
//                g.drawLine(0, i*UNIT_SIZE, SCREEN_WIDTH, i*UNIT_SIZE);
//            }
//
//            for(int i = 1; i < SCREEN_WIDTH/UNIT_SIZE; i++){
//                g.drawLine(i*UNIT_SIZE, 0, i*UNIT_SIZE, SCREEN_HEIGHT);
//            }
//
//            g.setColor(Color.RED);
//            g.fillOval(appleX, appleY, UNIT_SIZE, UNIT_SIZE);
//
//            for(int part = 0; part < bodyParts; part++){
//                if(part == 0){
//                    g.setColor(Color.GREEN);
//                    g.fillRect(x[part], y[part], UNIT_SIZE, UNIT_SIZE);
//                } else {
//                    g.setColor(new Color(45, 180, 0));
////                    g.setColor(new Color(random.nextInt(255), random.nextInt(255), random.nextInt(255)));
//                    g.fillRect(x[part], y[part], UNIT_SIZE, UNIT_SIZE);
//                }
//            }
//            g.setColor(Color.RED);
//            g.setFont(new Font("Ink Free", Font.BOLD, 30));
//            FontMetrics metrics = getFontMetrics(g.getFont());
//            g.drawString("Your score: " + applesEaten,
//                    (SCREEN_WIDTH - metrics.stringWidth("Your score: " + applesEaten))/2,
//                    g.getFont().getSize());
//        } else {
//            gameOver(g);
//        }
//    }
//
//    public void newApple(){
//        appleX = random.nextInt((int)(SCREEN_WIDTH/UNIT_SIZE)) * UNIT_SIZE;
//        appleY = random.nextInt((int)(SCREEN_HEIGHT/UNIT_SIZE)) * UNIT_SIZE;
//
//        for(int i = 0; i<bodyParts; i++){
//            if(appleX == x[i] && appleY == y[i]){
//                newApple();
//            }
//        }
//    }
//
//    public void move(){
//        for(int i = bodyParts; i>0; i--){
//            x[i] = x[i-1];
//            y[i] = y[i-1];
//        }
//
//        switch (direction){
//            case UP: y[0] = y[0] - UNIT_SIZE; break;
//            case DOWN: y[0] = y[0] + UNIT_SIZE; break;
//            case LEFT: x[0] = x[0] - UNIT_SIZE; break;
//            case RIGHT: x[0] = x[0] + UNIT_SIZE; break;
//        }
//    }
//
//    public void checkApple(){
//        if((x[0] == appleX) &&  (y[0] == appleY)){
//            bodyParts++;
//            applesEaten++;
//            newApple();
//        }
//    }
//
//    public void checkCollisions(){
//        //проверяет столкновение головы с телом
//        for (int i = bodyParts; i>0; i--){
//            if((x[0] == x[i]) && (y[0] == y[i])){
//                running = false;
//            }
//        }
//        //проверяет столкновение со стенками
//        if(x[0]<0 || x[0]>=SCREEN_WIDTH || y[0]<0 || y[0]>=SCREEN_HEIGHT){
//            running = false;
//        }
//
//        if(!running){
//            timer.stop();
//        }
//
//    }
//
//    public void gameOver(Graphics g){
//        g.setColor(Color.RED);
//        g.setFont(new Font("Ink Free", Font.BOLD, 75));
//        FontMetrics metrics = getFontMetrics(g.getFont());
//        g.drawString("Game Over", (SCREEN_WIDTH - metrics.stringWidth("Game Over"))/2, SCREEN_HEIGHT/2);
//
//        g.setFont(new Font("Ink Free", Font.BOLD, 40));
//        metrics = getFontMetrics(g.getFont());
//        g.drawString("Your score: " + applesEaten,
//                (SCREEN_WIDTH - metrics.stringWidth("Your score: " + applesEaten))/2,
//                SCREEN_HEIGHT/2 + 75);
//    }
//
//    @Override
//    public void actionPerformed(ActionEvent e) {
//        if(running) {
//            move();
//            checkApple();
//            checkCollisions();
//        }
//        repaint();
//    }
//
//    public class MyKeyAdapter extends KeyAdapter{
//        @Override
//        public void keyPressed(KeyEvent event){
//            switch (event.getKeyCode()){
//                case KeyEvent.VK_LEFT:
//                    if(direction!=Direction.RIGHT){
//                        direction = Direction.LEFT;
//                    }
//                    break;
//                case KeyEvent.VK_RIGHT:
//                    if(direction!=Direction.LEFT){
//                        direction = Direction.RIGHT;
//                    }
//                    break;
//                case KeyEvent.VK_UP:
//                    if(direction!=Direction.DOWN){
//                        direction = Direction.UP;
//                    }
//                    break;
//                case KeyEvent.VK_DOWN:
//                    if(direction!=Direction.UP){
//                        direction = Direction.DOWN;
//                    }
//                    break;
//            }
//        }
//    }
//}
