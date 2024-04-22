import javax.swing.*;
import java.awt.*;

public class Enemy {
    private int x;
    private int y;
    private int dy; // Change in y 
    private int width;
    private int height;
    private ImageIcon image;
    

    public Enemy(int x, int y, int width, int height, String imagePath) {
        this.x = x;
        this.y = y;
        this.width = width;
        this.height = height;
        this.image = new ImageIcon(imagePath);
        this.dy = 3; 
    }

    public void move() {
        
        y += dy;

        if (y <= 0 || y + height >= 600) {
            dy = -dy; // Reverse direction if hitting top or bottom of the screen
        }
    }

    public void draw(Graphics2D g2d) {
        g2d.drawImage(image.getImage(), x, y, width, height, null);
    }
    
}