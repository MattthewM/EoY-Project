import javax.swing.*;
import java.awt.*;

public class PlayableGuy {
    private int x;
    private int y;
    private int dx;
    private int dy;
    private int width;
    private int height;
    private ImageIcon imageIcon;

    public PlayableGuy(int x, int y, int width, int height, String imagePath) {
        this.x = x;
        this.y = y;
        this.width = width;
        this.height = height;
        this.imageIcon = new ImageIcon(imagePath);
    }

    // Getters for dimensions and position
    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public int getWidth() {
        return width;
    }

    public int getHeight() {
        return height;
    }

    // Method to draw the playable guy
    public void draw(Graphics2D g2d) {
        g2d.drawImage(imageIcon.getImage(), x, y, width, height, null);
    }

    // Method to move the playable guy by a specified amount
    public void setdx(int dx) {
        this.dx = dx;
    }

    public void setdy(int dy) {
        this.dy = dy;
    }

    public void move() {
        x += dx;
        y += dy;
    }
}