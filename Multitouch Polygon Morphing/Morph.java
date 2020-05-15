import java.awt.*;
import java.awt.event.*;
import java.applet.*;
import java.io.*;
import java.lang.*;
import java.util.*;

class Morph extends Frame implements MouseListener, MouseMotionListener 
{
	
	Interface inf = new Interface();

	int mouseX, mouseY;
 	boolean initialised = false;
	public void init() 
	{
		addMouseListener(this);
		addMouseMotionListener(this);
		inf.draw(this.getGraphics());
	}
	
	// Handle mouse clicked.
	public void mouseClicked(MouseEvent me) 
	{
		inf.handleMouseClick(me,this.getGraphics());
	}
	
	// Handle mouse entered.
	public void mouseEntered(MouseEvent me) 
	{
		inf.draw(this.getGraphics());
		
	}
	
	// Handle mouse exited.
	public void mouseExited(MouseEvent me) 
	{
		
	}
	
	boolean mouseRel = true;
	  
	// Handle button pressed.
	public void mousePressed(MouseEvent me) 
	{
		  
	}
	
	// Handle button released.
	public void mouseReleased(MouseEvent me) 
	{
		// save coordinates
		mouseX = me.getX();
		mouseY = me.getY();
		mouseRel = true;
	}
	
	// Handle mouse dragged.
	public void mouseDragged(MouseEvent me) 
	{
		// save coordinates
		mouseX = me.getX();
		mouseY = me.getY();
	}
	
	// Handle mouse moved.
	public void mouseMoved(MouseEvent me) 
	{
		inf.handleMouseOver(me,this.getGraphics());
	}
	
	public void delay(long ms) 
	{ 
		try 
		{ 
			Thread.sleep(ms);
		} 
		catch(InterruptedException e) { } 
	}
	
	public void initialise(Graphics g)
	{
		inf.draw(g);
	}
	
	public static Morph morph;
	public void setNorm() 
	{
		inf.setNorm(getGraphics());
	}

	public void paint(Graphics g)
	{
		if(initialised == false) { initialise(g);initialised=true; }
		inf.draw(g);
	}
	
	public Morph() 
	{
		morph = this;
		this.addMouseListener(this);
		this.addMouseMotionListener(this);
	}
	
	public static void main(String args[]) 
	{
		Morph mainFrame = new Morph();
		mainFrame.setTitle("Multitouch  Polygon  Morphing");
		WindowListener l = new WindowAdapter() 
			{
				public void windowClosing(WindowEvent e) {System.exit(0);}
			};
      		mainFrame.addWindowListener(l);
		mainFrame.setBackground(Color.black);
		mainFrame.setSize(1440,870);
		mainFrame.setVisible(true);
		mainFrame.delay(300);
		mainFrame.inf.draw(mainFrame.getGraphics());
	}
	
}
