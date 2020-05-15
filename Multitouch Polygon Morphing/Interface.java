import java.awt.*;
import java.applet.*;
import java.io.*;
import java.lang.*;
import java.util.*;
import java.awt.image.*;
import java.awt.event.*;
import java.net.*;

public class Interface
 {
	int begY = 25;
	
	Image wall;
	
	FunctionHandler fnhd = new FunctionHandler();
	
	public int slider1Value = 50, slider2Value = 50;
	
	Button play = new Button("imgs/PlayC.jpg","imgs/PlayH.jpg","imgs/PlayN.jpg",1019,79+begY-2,"Start Morphing");
	
	Button pause = new Button("imgs/PauseC.jpg","imgs/PauseH.jpg","imgs/PauseN.jpg",519+400,79+begY-2,"Pause Morphing");
	
	Button slider1Left = new Button("imgs/Slider1LeftC.jpg","imgs/Slider1LeftH.jpg","imgs/Slider1LeftN.jpg",236+400-15,103+begY-1,"Decrease Delay between steps");
	
	Button slider1Right = new Button("imgs/Slider1RightC.jpg","imgs/Slider1RightH.jpg","imgs/Slider1RightN.jpg",311-17+400,103+begY-1,"Increase Delay between steps");
	
	Button slider2Left = new Button("imgs/Slider2LeftC.jpg","imgs/Slider2LeftH.jpg","imgs/Slider2LeftN.jpg",378+400,103+begY-1,"Decrease number of time steps");
	
	Button slider2Right = new Button("imgs/Slider2RightC.jpg","imgs/Slider2RightH.jpg","imgs/Slider2RightN.jpg",463-12+400,103+begY-1,"Increase number of time steps");
	
	Button slider1 = new Button("imgs/Slider1.jpg","imgs/Slider1.jpg","imgs/Slider1.jpg",477+400,103+begY-1," ");
	
	Button slider2 = new Button("imgs/Slider2.jpg","imgs/Slider2.jpg","imgs/Slider2.jpg",477+400,103+begY-1," ");
	
	Button btnLogo = new Button("imgs/LogoH.jpg","imgs/LogoH.jpg","imgs/LogoN.jpg",0,begY," ");
	
	Button fire_app = new Button("imgs/fireC.png","imgs/fireH.png","imgs/fireN.png",1115,225,"Fire Application");
	
	Button multikey_app = new Button("imgs/multikeyC.png","imgs/multikeyH.png","imgs/multikeyN.png",1275,225,"Multikey Application");
	
	Button photo_app = new Button("imgs/photoC.png","imgs/photoH.png","imgs/photoN.png",1115,335,"Photo Application");

	Button physics_app = new Button("imgs/physicsC.png","imgs/physicsH.png","imgs/physicsN.png",1275,335,"Physics Application");

	Button puzzle_app = new Button("imgs/puzzleC.png","imgs/puzzleH.png","imgs/puzzleN.png",1115,435,"Puzzle Application");
	
	Button ripples_app = new Button("imgs/ripplesC.png","imgs/ripplesH.png","imgs/ripplesN.png",1275,435,"Ripples Application");
	
	Button tangram_app = new Button("imgs/tangramC.png","imgs/tangramH.png","imgs/tangramN.png",1115,535,"Tangram Application");

	Button wallpong_app = new Button("imgs/wallpongC.png","imgs/wallpongH.png","imgs/wallpongN.png",1275,535,"Wall Pong Application");

	Button config= new Button("imgs/creditC.png","imgs/creditH.png","imgs/creditN.png",35,45,"Credits");
	
	public Interface() 
	{
		wall = Toolkit.getDefaultToolkit().createImage("imgs/wall.jpg");
	}

	public void delay(long ms) 
	{ 
		try 
		{
			Thread.sleep(ms);
		} 
		catch(InterruptedException e) { } 
	}
	
	public void draw(Graphics g) 
	{	
		int x, y;
		x = 0;
		y = begY;
		g.drawImage(wall,x,y,null);
		
		btnLogo.drawNorm(g);
		btnLogo.drawHigh(g);
		
		config.drawNorm(g);
		fire_app.drawNorm(g);
		multikey_app.drawNorm(g);
		photo_app.drawNorm(g);
		physics_app.drawNorm(g);
		puzzle_app.drawNorm(g);
		ripples_app.drawNorm(g);
		tangram_app.drawNorm(g);
		wallpong_app.drawNorm(g);
		g.setColor(new Color(c1,c2,c3));
		g.fillRect(x1,y1,x2,y2);
		if(play.getState() == Button.norm || play.getState() == Button.hilite )
		{
			play.drawNorm(g);
		}
		else
		{
			play.drawClicked(g);
		}
		if(pause.getState() == Button.norm || pause.getState() == Button.hilite )
		{
			pause.drawNorm(g);
		}
		else 
		{
			pause.drawClicked(g);
		}
		slider1Left.drawNorm(g);
		slider1Right.drawNorm(g);
		slider2Left.drawNorm(g);
		slider2Right.drawNorm(g);
	
		drawSliderValues(g);	
	
		fnhd.Draw(g);
		fnhd.ClearScreen(g);
	}
	
	void drawSliderValues(Graphics g)
	 {
		Point stPt = slider1Left.getPos();
		Point pWdHt = slider1Left.getWdHt();
		
		slider1.setPos(stPt.x + pWdHt.x - 2, stPt.y );
		slider1.drawNorm(g);
		
		float percent1 = (float)(slider1Value-sliderMin)/(float)(sliderMax-sliderMin) ;
		float percent2 = (float)(slider2Value-sliderMin)/(float)(sliderMax-sliderMin) ;
		
		float r1 = 100 + (percent1 ) * 155;
		float g1 = 100 + (1.0F - percent1) * 155 ;
		
		float r2 = 100 + percent2 * 125;
		float g2 = 100 + (1.0F - percent2) * 155;
		
		Color c1 = new Color ((int)r1,(int)g1,255);
		Color c2 = new Color ((int)r2,(int)g2,255);
			
		
		Point stPt2 = slider2Left.getPos();
		Point pWdHt2 = slider2Left.getWdHt();
		
		slider2.setPos(stPt2.x + pWdHt2.x - 2, stPt2.y );
		slider2.drawNorm(g);
		
		Color back = g.getColor();
		Color c = new Color(255,255,255);
		g.setColor(c);
		g.drawString(new Integer(slider1Value).toString(),301+370,153);
		g.drawString(new Integer(slider2Value).toString(),448+380,153);
	}
	
	int x1 = 0;	int y1 = 845; int x2 = 1440; int y2 = 900;
	int c1 = 44; int c2 = 108; int c3 = 170;
	int pMx =  -1, pMy = -1;
	String pHelp;
	int helpX = 10,helpY = 860;
	
	void btnMOHnd(Button btn, int mx,int my, Graphics g) 
	{
		if(btn.isInRange(mx, my))
		{
			if(btn.getState() != Button.clicked) 
			{
				btn.drawHigh(g);
			}
			
			if(pMx != -1) 
			{
				g.setColor(new Color(c1,c2,c3));
				g.fillRect(x1,y1,x2,y2);
				g.setColor(new Color(255,255,255));
				g.drawString(pHelp,helpX,helpY);
				g.setPaintMode();
				pMx = -1;
				pMy = -1;
			}

			if( mx != pMx || my != pMy ) 
			{
				g.setColor(new Color(255,255,255));
				if(pHelp != null) 
				{
					if(!pHelp.equals(btn.getHelp()) && pMx != -1) 
					{
						g.setColor(new Color(c1,c2,c3));
						g.fillRect(x1,y1,x2,y2);
						g.drawString(pHelp,helpX,helpY);
					}
				}
								
				g.setPaintMode();
				pHelp = btn.getHelp();
			
				pMx = mx;
				pMy = my;
			}
		}
		else 
		{
			if(btn.getState() == Button.hilite) 
			{
				if(btn.getPrevState() == Button.norm) 
				{
					btn.drawNorm(g);		
				}
				else 
				{
					btn.drawClicked(g);
				}		
			}
			
		
		}
	}
	
	
	static boolean cursorHand = false;
	public void handleMouseOver(MouseEvent me, Graphics g) 
	{
		int mx = me.getX();
		int my = me.getY();
		
		if(pMx != -1) 
		{
			g.setColor(new Color(c1,c2,c3));
			g.fillRect(x1,y1,x2,y2);
			g.setColor(new Color(255,255,255));
			g.drawString(pHelp,helpX,helpY);
			g.setPaintMode();
			pMx = -1;
			pMy = -1;
		}

		if(play.getState() != Button.clicked)
		{
			if(fnhd.polyReady())
			{	
				btnMOHnd(play,mx,my,g);	
			}
			
			if(!cursorHand)
			{
				Cursor hand = new Cursor(Cursor.HAND_CURSOR);
			
				Morph.morph.setCursor(hand);
				cursorHand = true;
			}
		}
		else 
		{
			play.drawClicked(g);
			if(cursorHand) 
			{
				Cursor def = new Cursor(Cursor.DEFAULT_CURSOR);
				Morph.morph.setCursor(def);
				cursorHand = false;
			}
		}

		if(pause.getState() != Button.clicked) 
		{
			if(fnhd.polyReady())
			{
				btnMOHnd(pause,mx,my,g);
			}
			if(!cursorHand)
			{
				Cursor hand = new Cursor(Cursor.HAND_CURSOR);
			
				Morph.morph.setCursor(hand);
				cursorHand = true;
			}	
		}
		else 
		{
			pause.drawClicked(g);
			if(cursorHand) 
			{
				Cursor def = new Cursor(Cursor.DEFAULT_CURSOR);
				Morph.morph.setCursor(def);
				cursorHand = false;
			}
		}
		
		btnMOHnd(config,mx,my,g);
		btnMOHnd(fire_app,mx,my,g);
		btnMOHnd(multikey_app,mx,my,g);
		btnMOHnd(photo_app,mx,my,g);
		btnMOHnd(physics_app,mx,my,g);
		btnMOHnd(puzzle_app,mx,my,g);
		btnMOHnd(ripples_app,mx,my,g);
		btnMOHnd(tangram_app,mx,my,g);
		btnMOHnd(wallpong_app,mx,my,g);
		btnMOHnd(slider1Left,mx,my,g); 
		btnMOHnd(slider1Right,mx,my,g); 				
						
		if(fnhd.report() == 0) 
		{
			btnMOHnd(slider2Left,mx,my,g);
			btnMOHnd(slider2Right,mx,my,g);
		}
		
		
			
		if(play.getState() == Button.clicked && fnhd.report() == 0)
		{
			play.drawNorm(g);
		}
			
	}
	
	void normBtnHnd(Button btn, int mx, int my, Graphics g,String sa)
	{
		if(btn.isInRange(mx, my)) 
		{
			Runtime r=Runtime.getRuntime();
    			Process p=null;
			 try
			{
      				String s="mtmp/" + sa;
				p=r.exec(s);
   			}
   				catch(Exception e)
			{
      				System.out.println("error==="+e.getMessage());
      				e.printStackTrace();
   			}
		}
	}
	
	void btnClkHnd(Button btn, int mx, int my, Graphics g, Button release) 
	{
		if(btn.isInRange(mx, my)) 
		{
			btn.drawClicked(g);
			if(release != null) 
			{
				if(release.getState() == Button.clicked) 
				{
					release.drawNorm(g);
				}
			}
		}
	}
	
	int sliderMax = 99, sliderMin = 1;
	void decSlider(int sliderNo) 
	{
		if(sliderNo == 1) 
		{
			if(slider1Value > sliderMin)
				slider1Value --;
		}
		else 
		{
			if(slider2Value > sliderMin)
				slider2Value --;
		}
	}
	
	void incSlider(int sliderNo) 
	{
		if(sliderNo == 1) 
		{
			if(slider1Value < sliderMax)
				slider1Value ++;
		}
		else 
		{
			if(slider2Value < sliderMax)
				slider2Value ++;
		}
	}
	
	void sliderHnd(Button slider, int mx, int my, Graphics g,
	int SliderNo, int leftRight)
	{
		if(slider.isInRange(mx, my)) 
		{
			if(leftRight == 0) 	
			{
				decSlider(SliderNo);
				drawSliderValues(g);
			}
			else 
			{
				incSlider(SliderNo);
				drawSliderValues(g);
			}
		}
	}
	
	public void handleMouseClick(MouseEvent me, Graphics g) 
	{
		int mx = me.getX();
		int my = me.getY();

		if(fnhd.polyReady()) 
		{
			btnClkHnd(play,mx,my,g,pause);
			btnClkHnd(pause,mx,my,g,play);
		}
		
		if(me.getModifiers() == me.BUTTON1_MASK)
		{
			fnhd.handleMouseClick(mx,my,g);	
		}
		else if(me.getModifiers() == me.BUTTON3_MASK)
		{
			fnhd.handleRightClick(g);
		}
		
		normBtnHnd(config,mx,my,g,"Demos/Flash Demos/fire.exe");
		normBtnHnd(fire_app,mx,my,g,"Demos/Flash Demos/fire.exe");
		normBtnHnd(multikey_app,mx,my,g,"Demos/Flash Demos/MultiKey.exe");
		normBtnHnd(photo_app,mx,my,g,"Demos/Flash Demos/Photo.exe");
		normBtnHnd(physics_app,mx,my,g,"Demos/Flash Demos/Physics.exe");
		normBtnHnd(puzzle_app,mx,my,g,"Demos/Flash Demos/Puzzle.exe");
		normBtnHnd(ripples_app,mx,my,g,"Demos/Flash Demos/Ripples.exe");
		normBtnHnd(tangram_app,mx,my,g,"Demos/Flash Demos/Tangram.exe");
		normBtnHnd(wallpong_app,mx,my,g,"Demos/Flash Demos/Wall Pong.exe");
		
		if(play.getState() == Button.clicked)
		{
			if(fnhd.report() == 0) 
			{
				fnhd.setup(slider1Value,slider2Value,g);
				fnhd.start();
				play.drawClicked(g);
			}
			else if(fnhd.report() == 1) 
			{
				fnhd.restart();
				play.drawClicked(g);
				pause.drawNorm(g);
			}
		}
		
		if(pause.getState() == Button.clicked) 
		{
			if(pause.isInRange(mx,my)) 
			{
				if(fnhd.report() == 2) 
				{
					fnhd.pause();
					play.drawNorm(g);
					pause.drawClicked(g);
				}
				else if(fnhd.report() == 1) 
				{
					fnhd.restart();
					play.drawClicked(g);
					pause.drawNorm(g);
				}
				else 
				{
					pause.drawNorm(g);
				}
			}
		}
		
		
		
			
		if(fnhd.report() == 0)
		{	
			sliderHnd(slider1Left,mx,my,g,1,0);
			sliderHnd(slider1Right,mx,my,g,1,1);
			sliderHnd(slider2Left,mx,my,g,2,0);
			sliderHnd(slider2Right,mx,my,g,2,1);
		}
	}
	
	public void setNorm(Graphics g)
	 {
		play.drawNorm(g);
		pause.drawNorm(g);
	}
}
