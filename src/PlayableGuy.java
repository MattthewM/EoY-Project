import javax.swing.*;
import java.awt.*;

public class PlayableGuy {
    private int x;
    private int y;
    private int dx; 
    private int dy; 
    private int width;
    private int height;
    private ImageIcon image;

    public PlayableGuy(int x, int y, int width, int height, String imagePath) {
        this.x = x;
        this.y = y;
        this.width = width;
        this.height = height;
        this.image = new ImageIcon(imagePath);
    }

    public void moveUp() {
        y -= 5; 
    }

    public void moveDown() {
        y += 5; 
    }

    public void moveLeft() {
        x -= 5; 
    }

    public void moveRight() {
        x += 5; 
    }

    public void draw(Graphics2D g2d) {
        g2d.drawImage(image.getImage(), x, y, width, height, null);
    }

    // Add getters and setters if needed
}