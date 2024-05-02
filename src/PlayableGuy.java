import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import javax.swing.ImageIcon;

public class PlayableGuy {
    private int x, y, width, height;
    public ImageIcon pic;
    private int dx, dy;
    
    public PlayableGuy()
    {
    	x=0;
    	y=0;
    	width=100;
    	height=100;
    	pic = new ImageIcon("Player.png");
    }

    

    public PlayableGuy(int x, int y, int width, int height, ImageIcon p) {
        this.x = x;
        this.y = y;
        this.width = width;
        this.height = height;
        pic=p;
    }

    // Other methods...

    public void move() {
        x += dx;
        y += dy;
    }

    public void setdx(int dx) {
        this.dx = dx;
    }

    public void setdy(int dy) {
        this.dy = dy;
    }

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
   
}
