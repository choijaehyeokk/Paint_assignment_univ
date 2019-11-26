package figure;

import java.awt.Graphics2D;
import java.awt.Point;
import java.io.Serializable;
import java.util.ArrayList;

import Frame.Data;


public abstract class PenType extends Figure{

	protected ArrayList<trace> points = new ArrayList<trace>();
	protected int preX,preY;
	
	class trace implements Serializable
	{
		Point prePoints;
		Point LastPoints;
		
		trace(int x1, int y1, int x2, int y2)
		{
			prePoints = new Point(x1,y1);
			LastPoints = new Point(x2,y2);
		}
	}
	
	public PenType(int firstX, int firstY)
	{
		
		preX=firstX;
		preY=firstY;
		
		points.add(new trace(firstX,firstY,firstX,firstY));
	}
	
	
	@Override
	public void setFigureSize(int currentX, int currentY) {
		// TODO Auto-generated method stub
		
		points.add(new trace(preX,preY,currentX,currentY));
		preX=currentX;
		preY=currentY;
	}
	@Override
	public abstract void draw(Graphics2D g) ;

	@Override
	public void calc(int currentX, int currentY) {
		// TODO Auto-generated method stub
		if(Data.getCurrentMode()!=Data.MODE_RESIZE)
		{
			setFigureSize(currentX,currentY);
		}	
	}
	
	public  void moveTo(int curX,int curY)
	{
		for(trace curPoints : points)
		{
			curPoints.prePoints.x+=curX;
			curPoints.prePoints.y+=curY;
			curPoints.LastPoints.x+=curX;
			curPoints.LastPoints.y+=curY;
		}
	}

	public abstract Figure clone();
}

	

