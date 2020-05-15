import java.awt.*;
import java.applet.*;
import java.io.*;
import java.lang.*;
import java.util.*;

class PolySet
{
	int [][] x = new int [2][];
	int [][] y = new int [2][];
	int [] mx,my;
	int n1,n2;
	int n,l;
	int ms,ml;
	int totaltime;
	int Polysset = 0;

	public PolySet()
	{
		Polysset = 0;
	}
	
	public int GetNo()
	{
		return Polysset;
	}
	
	public void Reset()
	{
		Polysset = 0;
	}
	public int GetVertexno(int no)
	{
		if(no == 0)
		{
			return n1;
		}
		else
		if(no == 1)
		{
			return n2;
		}
		return n;
	}
	public void Settime(int t)
	{
		totaltime = t;
	}
	
	public int Gettime()
	{
		return totaltime;
	}
	public boolean IsReady()
	{
		if(Polysset == 2)
			return true;
		else
			return false;
	}
	public void Init(int x1[],int y1[],int no)
	{
		/* Main Code */
		int which = Polysset;
		Polysset ++;
		x[which] = new int [no];
		y[which] = new int [no];
		for(int i = 0;i < no;i ++)
		{
			x[which][i] = x1[i];
			y[which][i] = y1[i];
		}
		if(which == 0)
		{
			n1 = no;
		}
		else
		{
			n2 = no;
		}
		/*Main Ends here*/
		/* Dummy code 
		x[1] = new int [3];
		y[1] = new int [3];
		x[0] = new int [6];
		y[0] = new int [6];
		x[1][0] = 0;
		y[1][0] = 0;
		x[1][1] = 50;
		y[1][1] = 100;
		x[1][2] = 100;
		y[1][2] = 0;
		x[0][5] = 300 + 50;
		y[0][5] = 100 + 0;
		x[0][4] = 300 + 0;
		y[0][4] = 100 + 33;
		x[0][3] = 300 + 0;
		y[0][3] = 100 + 66;
		x[0][2] = 300 + 50;
		y[0][2] = 100 + 100;
		x[0][1] = 300 + 100;
		y[0][1] = 100 + 66;
		x[0][0] = 300 + 100;
		y[0][0] = 100 + 33;
		n1 = 6;
		n2 = 3;
		/* Dummy ends here */
	}

	public void Setup()	// used to add the vertices
	{
		if(n1 < n2)
		{
			n = n2;
			l = 1;
		}
		else
		{
			n = n1;
			l = 0;
		}
		int nx = (l + 1)%2;
		ml = 0;
		ms = 0;
		int xx = 0,yy = 0;
		for(int i = 0;i < n1;i ++)
		{
			if(i == 0)
			{
				xx = x[0][i];
			}
			else
			{
				if(xx < x[0][i])
				{
					xx = x[0][i];
					if(l == 0)
						ml = i;
					else
						ms = i;
				}
			}
		}
		for(int i = 0;i < n2;i ++)
		{
			if(i == 0)
			{
				yy = x[1][i];
			}
			else
			{
				if(yy < x[1][i])
				{
					yy = x[1][i];
					if(l == 1)
						ml = i;
					else
						ms = i;
				}
			}
		}
		mx = new int [n];
		my = new int [n];
		int diff = n1 - n2;
		int small = n2;
		if(l == 1)
		{
			diff *= -1;
			small = n1;
		}
		int i = 0;
		int j = diff / small;
		if(diff % small != 0)
			j ++;
		int c = 0;
		while(i < n)
		{
			for(int k = 0;k <= j && (i - c) <= diff;k ++)
			{
				mx[i] = x[nx][c];
				my[i ++] = y[nx][c];
			}
			c ++;
		}
	}

	public void Morph(int x1[],int y1[],int timestep)
	{
		int j = ms;
		int k = ml;
		int [] xx1,yy1,xx2,yy2;
		if(l == 1)
		{
			xx1 = mx;
			yy1 = my;
			xx2 = x[l];
			yy2 = y[l];
		}
		else
		{
			xx1 = x[l];
			yy1 = y[l];
			xx2 = mx;
			yy2 = my;
		}
		for(int i = 0;i < n;i ++)
		{
			x1[i] = (xx1[j]) * (totaltime - timestep) + (xx2[k]) * (timestep);
			y1[i] = (yy1[j]) * (totaltime - timestep) + (yy2[k]) * (timestep);
			x1[i] /= totaltime;
			y1[i] /= totaltime;
			j = (j + 1) % n;
			k = (k + 1) % n;
		}
	}
	
	public void Get(int xx[],int yy[],int which)
	{
		int nn = (which == 0)?n1 : n2;
		for(int i = 0;i < nn;i ++)
		{
			xx[i] = x[which][i];
			yy[i] = y[which][i];
		}
	}
}