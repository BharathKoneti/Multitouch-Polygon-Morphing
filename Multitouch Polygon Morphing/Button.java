import java.awt.*;
import java.applet.*;
import java.io.*;
import java.lang.*;
import java.util.*;

public class Button 
{
	String strPathC,strPathH,strPathN;
	int isx, isy;
	int sizex, sizey;
	Image picN, picH, picC;
	
	public static final int norm = 0, hilite = 1, clicked = 2;
	public int state = 0; 
	public int prevState = 0; 
	
	String strHelp;
	
	public String getHelp() 
	{
		return strHelp;
	}
	
	public Button(String _pathC, String _pathH, String _pathN, int _isx, int _isy,String help) 
	{
		strPathC = _pathC;
		strPathH = _pathH;
		strPathN = _pathN;
		
		isx = _isx;
		isy = _isy;
		
		picN = null;
		picC = null;
		picH = null;
		
		strHelp = help;
		
	}
	
	public void initAll() 
	{
		picN = Toolkit.getDefaultToolkit().createImage(strPathN);
		picH = Toolkit.getDefaultToolkit().createImage(strPathH);
		picC = Toolkit.getDefaultToolkit().createImage(strPathC);
	}
	
	public void drawNorm(Graphics g) 
	{
		if(picN == null) 
		{
			picN = Toolkit.getDefaultToolkit().createImage(strPathN);
		}
		g.drawImage( picN,isx,isy,null);
		if(state != norm) 
		{
			prevState = state;
		}
		state = norm;
	}
	
	public void drawHigh(Graphics g) 
	{
		if(picH == null) 
		{
			picH = Toolkit.getDefaultToolkit().createImage(strPathH);
		}
		g.drawImage( picH,isx,isy,null);
		if(state != hilite) 
		{
			prevState = state;
		}
		state = hilite;
	}
	
	public void drawClicked(Graphics g) 
	{
		if(picC == null) 
		{
			picC = Toolkit.getDefaultToolkit().createImage(strPathC);
		}
		g.drawImage( picC,isx,isy,null);
		if(state != clicked) 
		{
			prevState = state;
		}
		state = clicked;
	}
	
	public boolean isInRange(int x, int y) 
	{
		if( (x >= isx && x <= isx + picN.getHeight(null)) && (y >= isy && y <= isy + picN.getWidth(null)) )
		{
			return true;
		}
		else 
		{
			return false;
		}
	}
	
	public int getState() {	return state; } 
	
	public int getPrevState() { return prevState; }
	
	public Point getPos() { return new Point(isx,isy);}
	
	public void setPos(int x, int y) 
	{
		isx = x;
		isy = y;
	}
	
	public Point getWdHt() 
	{
		return new Point(picN.getWidth(null),picN.getHeight(null));
	}
}