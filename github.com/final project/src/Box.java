
public class Box {
	private int x;
	private int y;
	private int dx;
	private int dy;
	private int width;
	private int height;
	private boolean movert;
	private boolean movelt;
	private boolean moveup;
	private boolean movedn;

	public Box() {
		y=40;
		y=40;
		width=25;
		height=35;
		dx=0;
		dy=0;
		movert=false;
		movelt=false;
	}

public Box( int x1, int y1, int w, int h, int dx1, int dy1) {
	x=x1;
	y=y1;
	dx=dx1;
	dy=dy1;
	width=w;
	height=h;
	movert=false;
	movelt=false;
	
}
public int getX() {
	return x;
}
public void setdx(int d) {
	dx=d;}
public void setdy(int r) {
	dy=r;}

public int getY() {
return y;
}
public int getWidth() {
return width;
}
public int getHeight() {
return height;
}
public void move() {
    y += dy; // Only uses the y coordinate
    if (y < 0) {
        y = 0; 
    } else if (y + height > 600) {
        y = 600 - height; 
    }
}



public boolean collision(Box b) {
	return this.getX()+getWidth()>=b.getX()&&
			getX()<=b.getX()+b.getWidth()&&
			getY()+getHeight()>=b.getY()&&
			getY()<=b.getY()+b.getHeight();
			
}

}

