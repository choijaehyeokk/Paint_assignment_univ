package figure;

import java.awt.BasicStroke;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.util.ArrayList;

import Frame.Data;
import figure.PenType.trace;


public class Pen extends PenType{
	

	private int strokeSize=1;
	
	public Pen(int firstX, int firstY)
	{
		
		super(firstX,firstY);
		strokeSize=Data.getLineSize();
	}

	@Override
	public void draw(Graphics2D g) {
		// TODO Auto-generated method stub
		
		g.setStroke(new BasicStroke(strokeSize,BasicStroke.CAP_ROUND,BasicStroke.JOIN_ROUND));
		g.setColor(figureColor);
		for(trace current : points)
		{
			g.drawLine(current.prePoints.x, current.prePoints.y, current.LastPoints.x, current.LastPoints.y);
		}
		
	}

	@Override
	public String toString() {
		return "Ææ [Ææ »ö=" + Data.getCurrentColor() + "]";
	}

	@Override
	 public Figure clone() { 
			Pen object = new Pen(0,0);			
			object.preX=preX;
			object.preY=preY;
			object.points=(ArrayList<trace>)points.clone();
			return object;
	    }
}

