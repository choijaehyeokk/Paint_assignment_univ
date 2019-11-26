package figure;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.util.ArrayList;

import Frame.Data;
import figure.PenType.trace;


public class Eraser extends PenType{



	 private int strokeSize = 1;

	   public Eraser(int firstX, int firstY)
	   {
	      super(firstX,firstY);
	      strokeSize = Data.getLineSize();
	   }

	   
	   @Override
	   public void draw(Graphics2D g) {
	      g.setStroke(new BasicStroke(strokeSize,BasicStroke.CAP_ROUND,BasicStroke.JOIN_ROUND));
	      g.setColor(new Color(255,255,255));
	      for(trace current : points)
	      {
	         g.drawLine(current.prePoints.x, current.prePoints.y, current.LastPoints.x, current.LastPoints.y);
	      }
	   }


	@Override
	public String toString() {
		return "Eraser";
	}

	@Override
	 public Figure clone() { 
			Eraser object = new Eraser(0,0);			
			object.preX=preX;
			object.preY=preY;
			object.points=(ArrayList<trace>)points.clone();
			return object;
	    }

}
