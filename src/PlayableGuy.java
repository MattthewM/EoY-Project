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
    public ImageIcon getPic() {
        return image;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public int getW() {
        return width;
    }

    public int getH() {
        return height;
    }

    

    public void setdx(int dx) {
        this.dx = dx;
    }

    public void setdy(int dy) {
        this.dy = dy;
    }

   
}