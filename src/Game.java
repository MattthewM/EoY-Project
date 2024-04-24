
import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage; 
import java.awt.event.*; 


public class Game  extends JPanel implements Runnable, KeyListener{

	private ImageIcon background;
	private BufferedImage back; 
	private int key; 
	private Sound music;
    private PlayableGuy player;
	private char screen;
	private boolean playSound, playSound2;
	
	
 


	
	public Game() {
		new Thread(this).start();	
		this.addKeyListener(this);
		key =-1; 
		screen='S';
		music=new Sound();
		playSound=true;
		playSound2=true;
		background = new ImageIcon("CheckerV3.png");
		player = new PlayableGuy(100, 300, 50, 50, "Player.png");
		
		
	
	}

	
public void screen(Graphics g2d) {
	switch(screen) {

		case 'S':
			//start screen
			g2d.drawImage(background.getImage(), 0, 0, getWidth(), getHeight(), this);
            g2d.setColor(Color.red);
            g2d.setFont(new Font("Arial", Font.BOLD, 24));
            g2d.drawString("Press 'B' to begin the game", 200, 300);
			drawStartScreen(g2d);
			
			break;
		case 'G':
			//game screen
			
			g2d.drawImage(background.getImage(),0, 0, getWidth(), getHeight(), this);
			
            
            
            
            
            
            break;
			 
			 
		case 'W':
			g2d.drawImage(background.getImage(),0, 0, getWidth(), getHeight(), this);
			 g2d.setColor(Color.red);
	            g2d.drawString("Congratulations! You won!", 200, 400);
	            
			//win screen
	
			
			break;
		case 'L':
			g2d.drawImage(background.getImage(),0, 0, getWidth(), getHeight(), this);
			g2d.setColor(Color.red);
            g2d.drawString("Congratulations on losing ", 200, 400);
			
			//lose screen
			
			break;
		}
  
	}


	public void run()
	   {
	   	try
	   	{
	   		while(true)
	   		{
	   		   Thread.currentThread().sleep(5);
	            repaint();
	         }
	      }
	   		catch(Exception e)
	      {
	      }
	  	}
	
	public void drawStartScreen(Graphics g2d) {
		//create start screen
		g2d.setFont( new Font("Broadway", Font.BOLD, 50));
		g2d.setColor(Color.red);
		g2d.drawString("Welcome to The Worlds Hardest Game", 200,400);
		g2d.drawString("Press B to Begin", 200, 600);
		g2d.drawString("Use arrow keys to move ", 200, 800);

}
	
	private void drawPlayer(Graphics2D g2d) {
        // Draw the player using its draw method
        player.draw(g2d);
    }
	private void drawGame(Graphics2D g2d) {
        // Clear the screen
        g2d.setColor(Color.BLACK);
        g2d.fillRect(0, 0, getWidth(), getHeight());

        // Draw the player
        drawPlayer(g2d);
    }


	
	public void paint(Graphics g){
		
		Graphics2D twoDgraph = (Graphics2D) g; 
		if( back ==null)
			back=(BufferedImage)( (createImage(getWidth(), getHeight()))); 
		

		Graphics g2d = back.createGraphics();
	
		g2d.clearRect(0,0,getSize().width, getSize().height);
		
		g2d.setFont( new Font("Broadway", Font.BOLD, 50));
		
		g2d.drawString("key " + key, 340, 100);
		screen(g2d);
		twoDgraph.drawImage(back, null, 0, 0);


	}

	



	//DO NOT DELETE
	@Override
	public void keyTyped(KeyEvent e) {
		// TODO Auto-generated method stub
		
		}		
	




//DO NOT DELETE
	@Override
	public void keyPressed(KeyEvent e) {
		// TODO Auto-generated method stub
		key= e.getKeyCode();{
			System.out.println(key);
			if(key==66) {
				screen = 'G';
			}
				 
		key= e.getKeyCode();
		System.out.println(key);
		if (key == 39) { 
	        player.setdx(2);
	    }
		else if (key == 37) { 
	        player.setdx(-2);
	    } 
		else if (key == 40) { 
	        player.setdy(2);
	    } 
		else if (key == 38) { 
	        player.setdy(-2);
	    }
		
		}
		
	}
		
	
	
		
	
	
	
	
	

	//DO NOT DELETE
	@Override
	public void keyReleased(KeyEvent e) {
		
		
		
		
	}
	
	
	

	
}
