import java.awt.*;
import java.applet.*;
import java.io.*;
import java.lang.*;
import java.util.*;
import java.awt.image.*;
import java.awt.event.*;

public class FunctionHandler
{
	PolySet P = new PolySet();
	boolean active = false;
	int morphing = 0;
	int n;
	int [] x = new int [100];
	int [] y = new int [100];
	int minx = 18;
	int miny = 210;
	int maxx = 80 + 1000;
	int maxy = 253 + 550;
			
	Color srcColor = new Color(255,0,0);
	Color destColor = new Color(0,0,255);
			
	public void FunctionHandler()
	{
		n = 0;
	}
	
	public void handleMouseClick(int mx,int my,Graphics g)
	{
		if(mx > minx && mx < maxx && my > miny && my < maxy)
		{
			if(morphing != 2)
			{
				morphing = 0;
				
				if(thread != null)
					thread.stopMe();
				
				if(P.IsReady())
				{
					P.Reset();
					ClearScreen(g);
				}
				if(active == false)
				{
					active = true;
				}
				x[n] = mx;
				y[n] = my;
				n ++;
				if(n > 1)
				{
					int ym = y[n-2];
					int xm = x[n-2];
					
					Color back = g.getColor();
					Color drawCol;
					
					if(P.GetNo() == 0) drawCol = srcColor;
					else drawCol = destColor;
					
					g.setColor(drawCol);
					g.drawLine(mx,my,xm,ym);
					
					g.setColor(back);
				}
				else
				{
					Color back = g.getColor();
					Color drawCol;
					
					if(P.GetNo() == 0) drawCol = srcColor;
					else drawCol = destColor;
					
					g.setColor(drawCol);
					g.drawLine(mx,my,mx,my);
					g.setColor(back);
				}
			}
		}
	}
	
	public void handleRightClick(Graphics g)
	{
		if(active == true)
		{
			active = false;

			Color back = g.getColor();
			Color drawCol;
					
			if(P.GetNo() == 0) drawCol = srcColor;
			else drawCol = destColor;
					
			g.setColor(drawCol);
			g.drawLine(x[0],y[0],x[n-1],y[n-1]);
			g.setColor(back);
			
			P.Init(x,y,n);
			n = 0;
		}
	}
	
	public void Draw(Graphics g)
	{
		if(P.GetNo() != 0)
		{
			int no = P.GetVertexno(0);
			int [] xx = new int [no];
			int [] yy = new int [no];
			P.Get(xx,yy,0);
			
			Color back = g.getColor();
			g.setColor(srcColor);
			
			Draw(xx,yy,no,g);
			
			g.setColor(back);
		}
		if(P.GetNo() == 2)	
		{
			int no = P.GetVertexno(1);
			int [] xx = new int [no];
			int [] yy = new int [no];
			P.Get(xx,yy,1);
			
			Color back = g.getColor();
			g.setColor(destColor);
			
			Draw(xx,yy,no,g);
			
			g.setColor(back);
		}
		if(active == true)
		{
			for(int i = 0;i < n-1;i ++)
			{
				Color back = g.getColor();	
				Color drawColor = (P.GetNo() == 1) ? destColor : srcColor;
				
				g.setColor(drawColor);
				g.drawLine(x[i],y[i],x[i+1],y[i+1]);
				g.setColor(back);
			}
		}
		if(morphing == 1) 
		{
			if(thread != null) 
			{
				thread.interDraw(g);
			}
		}
	}
	
	
	int delay,timesteps;
	Graphics graphics;
	
	public void setup(int del, int t,Graphics g) 
	{
		delay = del;
		timesteps = t;
		graphics = g;
	}
	
	Thr thread;
	public void start() 
	{
		
		thread = new Thr();
		thread.start();
	}
	
	public synchronized void pause() 
	{
		if(morphing == 2) 
		{
			morphing = 1;
		}
	}
	
	public synchronized void restart() 
	{
		if(morphing == 1) 
		{
			morphing = 2;
		}
	}
	
	public int report() 
	{
		return morphing;
	}
	
	public class Thr extends Thread 
	{
		
		boolean running = true;
		int i = 0;
		int no;
		int [] x1;
		int [] y1;
		
		void stopMe() 
		{
			running = false;
		}
		
		public synchronized void run() 
		{
			if(P.IsReady()) 
			{
				
				sMorph(delay,timesteps,graphics);
			}
		}
		
		public void sMorph(int del,int t,Graphics g)
		{
			morphing = 2;
			P.Settime(t);
			P.Setup();
			
			no = P.GetVertexno(2);
			x1 = new int [no];
			y1 = new int [no];
			

			for( i = 0;i <= t && running;)
			{
				if(morphing == 2) 
				{
					
					if(!P.IsReady()) 
					{
						break;
					}
					
					Color back = g.getColor();
					
					if(i != 1)
					{
						
						Color white = new Color(0,0,0);
						g.setColor(white);
						Draw(x1,y1,no,g);
						
						g.setColor(srcColor);
						P.Morph(x1,y1,0);
						Draw(x1,y1,no,g);
						
						g.setColor(destColor);
						P.Morph(x1,y1,P.Gettime());
						Draw(x1,y1,no,g);
					}
					
					int dColor = 255 / t;
					int cRed = (t - i) * dColor;
					int cBlue = i * dColor;
					
					g.setColor(new Color(cRed,0,cBlue));
					P.Morph(x1,y1,i);
					Draw(x1,y1,no,g);
					
					g.setColor(back);
					
					delay(del);
					i ++;
					
					
				}
				else if(morphing == 1) { delay(10);}
				else if(morphing == 0) { i = t + 1;}
			}
			morphing = 0;
			
			Morph.morph.setNorm();
			
		}
		
		public void interDraw(Graphics g) 
		{
			
			int t = timesteps;
			
			Color back = g.getColor();
			
			int dColor = 255 / t;
			int cRed = (t - i) * dColor;
			int cBlue = i * dColor;
			
			g.setColor(new Color(cRed,0,cBlue));
			P.Morph(x1,y1,i);
			Draw(x1,y1,no,g);
					
			g.setColor(back);
		}
	}
	
	
	public void ClearScreen(Graphics g)
	{
		Color c = g.getColor();
		Color c1 = new Color(0,0,0);
		g.setColor(c1);
		g.fillRect(minx,miny+10,maxx-minx,maxy-miny);
		g.setColor(c);
		Color c2 = new Color(255,255,255);
		g.setColor(c2);
		g.drawRect(minx,miny+10,maxx-minx,maxy-miny);
	}
	
	public void Draw(int x[],int y[],int n,Graphics g)
	{
		int offx = 0,offy = 0;
		for(int i = 0;i < n-1;i ++)
		{
			g.drawLine(offx + x[i],offy + y[i],offx + x[i+1],offy + y[i+1]);
		}
		g.drawLine(offx + x[0],offy + y[0],offx + x[n-1],offy + y[n-1]);
		Color c2 = new Color(255,255,255);
		g.setColor(c2);
		g.drawRect(minx,miny+10,maxx-minx,maxy-miny);
	}
	
	public void delay(long ms) 
	{ 
		try 
		{
			Thread.sleep(ms);
		} 
		catch(InterruptedException e) { } 
	}
	
	public boolean polyReady() 
	{
		return P.IsReady();
	}
}