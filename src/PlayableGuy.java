import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import javax.swing.ImageIcon;

public class PlayableGuy {
    public int x, y, width, height;
    public ImageIcon pic;
    public int dx, dy;
    
    
    public PlayableGuy()
    {
    	x=0;
    	y=0;
    	width=100;
    	height=100;
    	pic = new ImageIcon("Player.png");
    	dx=0;
    	dy=0;
    }

    

    public PlayableGuy(int x, int y, int width, int height, ImageIcon p) {
        this.x = x;
        this.y = y;
        this.width = width;
        this.height = height;
        pic=p;
    }

    // Other methods...
    public void setX(int x) {
        this.x = x;
    }

    public void setY(int y) {
        this.y = y;
    }
    public void move() {
        x+= dx;
        y+= dy;
    }

    public void setdx(int dx) {
        x+= dx;
    }

    public void setdy(int dy) {
        y+= dy;
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
    public boolean checkCollision(Enemy enemy) {
        // AABB collision detection with a single Enemy
        return (this.x + this.width >= enemy.getX() &&
                enemy.getX() + enemy.getWidth() >= this.x &&
                this.y + this.height >= enemy.getY() &&
                enemy.getY() + enemy.getHeight() >= this.y);
    }
}
   

    