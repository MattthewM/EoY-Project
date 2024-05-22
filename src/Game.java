import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.awt.event.*;

public class Game extends JPanel implements Runnable, KeyListener {

    private ImageIcon background;
    private ImageIcon background1;
    private ImageIcon background2;
    private BufferedImage back;
    private int key;
    private Sound music;
    private PlayableGuy player;
    private char screen;
    private boolean playSound, playSound2;
    private Enemy enemy1;
    private Enemy enemy2;
    private Enemy enemy3;
    private Enemy enemy4;
    private Enemy enemy5; // Additional enemy for level 2
    private Enemy enemy6; // Additional enemy for level 2
    private Enemy enemy7;
    private Enemy enemy8;

    public Game() {
        new Thread(this).start();
        this.setFocusable(true); 
        this.addKeyListener(this);
        key = -1;
        screen = 'S';
        music = new Sound();
        playSound = true;
        playSound2 = true;
        background = new ImageIcon("Skibidi.jpg");
        player = new PlayableGuy(100, 300, 100, 150, new ImageIcon("Player.png")); // Adjust width and height as needed
        ImageIcon enemyImage1 = new ImageIcon("Normal.png");
        ImageIcon enemyImage2 = new ImageIcon("Normal.png");
        ImageIcon enemyImage3 = new ImageIcon("Normal.png");
        ImageIcon enemyImage4 = new ImageIcon("Normal.png");

        enemy1 = new Enemy(500, 200, 50, 50, enemyImage1);
        enemy2 = new Enemy(700, 400, 50, 50, enemyImage2);
        enemy3 = new Enemy(900, 100, 50, 50, enemyImage3);
        enemy4 = new Enemy(1100, 300, 50, 50, enemyImage4);
        // Initialize additional enemies for level 2
        ImageIcon enemyImage5 = new ImageIcon("Normal.png");
        ImageIcon enemyImage6 = new ImageIcon("Normal.png");
        ImageIcon enemyImage7 = new ImageIcon("Normal.png");
        ImageIcon enemyImage8 = new ImageIcon("Mega.png");
        enemy8 = new Enemy(1000, 100, 300, 300, enemyImage5);
        enemy7 = new Enemy(800, 200, 50, 50, enemyImage6);
        enemy5 = new Enemy(300, 100, 50, 50, enemyImage5);
        enemy6 = new Enemy(100, 0, 50, 50, enemyImage6);
    }

    public void screen(Graphics g2d) {
        switch (screen) {
            case 'S':
            	// start screen
            	g2d.drawImage(background.getImage(),0,0,getWidth(), getHeight(), this);
            	g2d.setColor(Color.red);
                g2d.setFont(new Font("Arial", Font.BOLD, 24));
                g2d.drawString("Press 'B' to begin the game", 200, 300);
                drawStartScreen(g2d);
                break;
            case 'G':
                // game screen
                g2d.drawImage(background.getImage(), 0, 0, getWidth(), getHeight(), this);
                drawPlayableGuy(g2d); // Draw the player
                drawEnemies(g2d);
                enemy1.move();
                bounceEnemy(enemy1);

                enemy2.move();
                bounceEnemy(enemy2);

                enemy3.move();
                bounceEnemy(enemy3);

                enemy4.move();
                bounceEnemy(enemy4);
                checkLose();
                checkWin();
                break;
            case 'H': // Level 2 screen
                g2d.drawImage(background.getImage(), 0, 0, getWidth(), getHeight(), this);
                drawPlayableGuy(g2d); // Draw the player
                drawEnemiesLevel2(g2d); // Draw level 2 enemies
                enemy1.move();
                bounceEnemy(enemy1);

                enemy2.move();
                bounceEnemy(enemy2);

                enemy3.move();
                bounceEnemy(enemy3);

                enemy4.move();
                bounceEnemy(enemy4);

                enemy5.move();
                bounceEnemy(enemy5);

                enemy6.move();
                bounceEnemy(enemy6);
                checkLose();
                checkWin();
                break;
            case 'J':
            	enemy1.move();
                bounceEnemy(enemy1);

                enemy2.move();
                bounceEnemy(enemy2);

                enemy3.move();
                bounceEnemy(enemy3);

                enemy4.move();
                bounceEnemy(enemy4);

                enemy5.move();
                bounceEnemy(enemy5);

                enemy6.move();
                bounceEnemy(enemy6);
                
                enemy8.move();
                bounceEnemy(enemy8);
                
                checkLose();
                checkWin();
            	break;
            case 'W':
                g2d.drawImage(background.getImage(), 0, 0, getWidth(), getHeight(), this);
                g2d.setColor(Color.red);
                g2d.drawString("Congratulations! You won!", 200, 400);
                break;
            case 'L':
                g2d.drawImage(background.getImage(), 0, 0, getWidth(), getHeight(), this);
                g2d.setColor(Color.red);
                g2d.drawString("Congratulations on losing ", 200, 400);
                break;
        }
    }

    public void drawPlayableGuy(Graphics g2d) {
        g2d.drawImage(player.getPic().getImage(), player.getX(), player.getY(), player.getWidth(), player.getHeight(), this);
    }

    public void drawEnemies(Graphics g2d) {
        g2d.drawImage(enemy1.getPic().getImage(), enemy1.getX(), enemy1.getY(), enemy1.getWidth(), enemy1.getHeight(), this);
        g2d.drawImage(enemy2.getPic().getImage(), enemy2.getX(), enemy2.getY(), enemy2.getWidth(), enemy2.getHeight(), this);
        g2d.drawImage(enemy3.getPic().getImage(), enemy3.getX(), enemy3.getY(), enemy3.getWidth(), enemy3.getHeight(), this);
        g2d.drawImage(enemy4.getPic().getImage(), enemy4.getX(), enemy4.getY(), enemy4.getWidth(), enemy4.getHeight(), this);
    }

    public void drawEnemiesLevel2(Graphics g2d) {
        // Draw level 2 enemies
        g2d.drawImage(enemy1.getPic().getImage(), enemy1.getX(), enemy1.getY(), enemy1.getWidth(), enemy1.getHeight(), this);
        g2d.drawImage(enemy2.getPic().getImage(), enemy2.getX(), enemy2.getY(), enemy2.getWidth(), enemy2.getHeight(), this);
        g2d.drawImage(enemy3.getPic().getImage(), enemy3.getX(), enemy3.getY(), enemy3.getWidth(), enemy3.getHeight(), this);
        g2d.drawImage(enemy4.getPic().getImage(), enemy4.getX(), enemy4.getY(), enemy4.getWidth(), enemy4.getHeight(), this);
        g2d.drawImage(enemy5.getPic().getImage(), enemy5.getX(), enemy5.getY(), enemy5.getWidth(), enemy5.getHeight(), this);
        g2d.drawImage(enemy6.getPic().getImage(), enemy6.getX(), enemy6.getY(), enemy6.getWidth(), enemy6.getHeight(), this);
    }
    public void drawEnemiesLevel3(Graphics g2d) {
        // Draw level 2 enemies
        g2d.drawImage(enemy1.getPic().getImage(), enemy1.getX(), enemy1.getY(), enemy1.getWidth(), enemy1.getHeight(), this);
        g2d.drawImage(enemy2.getPic().getImage(), enemy2.getX(), enemy2.getY(), enemy2.getWidth(), enemy2.getHeight(), this);
        g2d.drawImage(enemy3.getPic().getImage(), enemy3.getX(), enemy3.getY(), enemy3.getWidth(), enemy3.getHeight(), this);
        g2d.drawImage(enemy4.getPic().getImage(), enemy4.getX(), enemy4.getY(), enemy4.getWidth(), enemy4.getHeight(), this);
        g2d.drawImage(enemy5.getPic().getImage(), enemy5.getX(), enemy5.getY(), enemy5.getWidth(), enemy5.getHeight(), this);
        g2d.drawImage(enemy6.getPic().getImage(), enemy6.getX(), enemy6.getY(), enemy6.getWidth(), enemy6.getHeight(), this);
        g2d.drawImage(enemy8.getPic().getImage(), enemy8.getX(), enemy8.getY(), enemy8.getWidth(), enemy8.getHeight(), this);
    }
    public void checkWin() {
        if (player.getX() >= 1150) {
            if (screen == 'G') { // If on level 1, move to level 2
                screen = 'H';
                player.x= 100;
                
            } else if (screen == 'H') { // If on level 2, win the game
                screen = 'J';
                player.x= 100;
            }
            else if (screen == 'J') { // If on level 2, win the game
                screen = 'W';
                player.x=100;
 }
        }
    }

    public void run() {
        try {
            while (true) {
                Thread.currentThread().sleep(5);
                repaint();
            }
        } catch (Exception e) {
        }
 }

    public void drawStartScreen(Graphics g2d) {
        g2d.setFont(new Font("Broadway", Font.BOLD, 50));
        g2d.setColor(Color.red);
        g2d.drawString("Welcome to The Worlds Hardest Game", 200, 400);
        g2d.drawString("Use arrow keys to move and avoidSKIBIDIS", 200, 600);
        g2d.drawString("Use arrow keys to move and avoid the SKIBIDIS ", 200, 800);

    }

    private void bounceEnemy(Enemy enemy) {
        if (enemy.getY() + enemy.getHeight() >= getHeight()) {
            enemy.setDy(-enemy.getDy()); // Reverse dy
        }
        if (enemy.getY() <= 0) {
            enemy.setDy(enemy.getDy());
        }

    }

    public void checkLose() {
        if (player.checkCollision(enemy1) || player.checkCollision(enemy2) ||
                player.checkCollision(enemy3) || player.checkCollision(enemy4) ||
                (screen == 'H' && (player.checkCollision(enemy5) || player.checkCollision(enemy6)))) {
            screen = 'L'; 
        }
    }

    public void keyPressed(KeyEvent e) {
        int key = e.getKeyCode();
        if (screen == 'S') { // Check if the start screen is active
            if (key == 66) { // Check if 'B' key is pressed
                screen = 'G'; // Switch to the game screen when 'B' is pressed
            }
        } else if (screen == 'G' || screen == 'H') { // Check if the game screen is active
            if (key == 39) { // Right arrow key
                player.setdx(10);
            } else if (key == 37) { // Left arrow key
                player.setdx(-10);
            } else if (key == 40) { // Down arrow key
                player.setdy(10);
            } else if (key == 38) { // Up arrow key
                player.setdy(-10);
            }
        }
    }

    public void keyReleased(KeyEvent e) {
        int key = e.getKeyCode();
        if (screen == 'G' || screen == 'H') { // Check if the game screen is active
            if (key == 39 || key == 37) { // Right or left arrow key
                player.setdx(0);
            } else if (key == 40 || key == 38) { // Down or up arrow key
                player.setdy(0);
            }
        }
    }

    public void paint(Graphics g) {
        Graphics2D twoDgraph = (Graphics2D) g;
        if (back == null)
            back = (BufferedImage) ((createImage(getWidth(), getHeight())));
        Graphics g2d = back.createGraphics();
        g2d.clearRect(0, 0, getSize().width, getSize().height);
        g2d.setFont(new Font("Broadway", Font.BOLD, 50));
        g2d.drawString("key " + key, 340, 100);
        screen(g2d);
        twoDgraph.drawImage(back, null, 0, 0);


    }

    //DO NOT DELETE
    @Override
    public void keyTyped(KeyEvent e) {
        // TODO Auto-generated method stub

    }


}

//used ai for enemy movment -only-