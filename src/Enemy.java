import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import javax.swing.ImageIcon;

public class Enemy {
    private int x, y, width, height;
    public ImageIcon pic;
    private int dx, dy;
    
    public Enemy()
    {
    	x=0;
    	y=0;
    	width=100;
    	height=100;
    	pic = new ImageIcon("Player.png");
    	dy=3;
    }

    

    public Enemy(int x, int y, int width, int height, ImageIcon p) {
        this.x = x;
        this.y = y;
        this.width = width;
        this.height = height;
        pic=p;
        this.dy = 4;
    }

    public void move() {
        y += dy;

        // Reverse direction if hitting top or bottom of the screen
        if (y <= 0 || y + height >= 800) {
            dy = -dy; // Reverse direction
        }
    }
   

    // Getters and setters (if needed) can be added here
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

    public ImageIcon getPic()
	{
	return pic;
	}
    public int getDy() {
        return dy;
    }

    public void setDy(int dy) {
        this.dy = dy;
    }
}
   
    
    
    
   