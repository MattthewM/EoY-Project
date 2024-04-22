
import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage; 
import java.awt.event.*; 


public class Game  extends JPanel implements Runnable, KeyListener{

	private ImageIcon background;
	private BufferedImage back; 
	private int key; 
	private Player play;
    private PlayableGuy p;
	
 

	
	public Game() {
		new Thread(this).start();	
		this.addKeyListener(this);
		key =-1; 
		screen='S';
		music=new Sound();
		playSound=true;
		playSound2=true;
		background = new ImageIcon("checker.png");
		p = new PlayableGuy(100, 300, 50, 50, "p.png");
		
	
	}

	
	public void screen(Graphics g2d) {
		switch(screen) {

		case 'S':
			//start screen
			g2d.drawImage(background.getImage(), 0,  0,  getWidth(),  getHeight(), this);
			drawStartScreen(g2d);
			
			break;
		case 'G':
			//game screen
			
			g2d.drawImage(background.getImage(),0, 0, getWidth(), getHeight(), this);
		
            }
            
            }
            
            
            break;
			 
			 
		case 'W':
			g2d.drawImage(background.getImage(),0, 0, getWidth(), getHeight(), this);
			 g2d.setColor(Color.white);
	            g2d.drawString("Congratulations! You won!", 200, 400);
	            
			//win screen
	
			
			break;
		case 'L':
			g2d.drawImage(background.getImage(),0, 0, getWidth(), getHeight(), this);
			g2d.setColor(Color.white);
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
	

	
	
	
	public void paint(Graphics g){
		
		Graphics2D twoDgraph = (Graphics2D) g; 
		if( back ==null)
			back=(BufferedImage)( (createImage(getWidth(), getHeight()))); 
		

		Graphics g2d = back.createGraphics();
	
		g2d.clearRect(0,0,getSize().width, getSize().height);
		
		g2d.setFont( new Font("Broadway", Font.BOLD, 50));
		
		g2d.drawString("key " + key, 340, 100);
		
	
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
		
		key= e.getKeyCode();
		System.out.println(key);
		if (key == 39) { 
	        p.setdx(2);
	    }
		else if (key == 37) { 
	        p.setdx(-2);
	    } 
		else if (key == 40) { 
	        p.setdy(2);
	    } 
		else if (key == 38) { 
	        p.setdy(-2);
	    }
		
	}
		
		
	
	}


	//DO NOT DELETE
	@Override
	public void keyReleased(KeyEvent e) {
		
		
		
		
	}
	
	
	

	
}
