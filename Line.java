package figure;

import java.awt.BasicStroke;
import java.awt.Graphics;
import java.awt.Graphics2D;

import Frame.Data;

public class Line extends Figure{

	
	private int endX,endY;
	private int startX,startY;
	private int strokeSize=1;
	
	
	public Line(int startX, int startY,int endX,int endY)
	{
		super();
		this.startX=startX;
		this.startY=startY;
		this.endX=endX;
		this.endY=endY;
		strokeSize=Data.getLineSize();
	}
	
	
	@Override
	public void setFigureSize(int endX, int endY) {
		// TODO Auto-generated method stub
		this.endX=endX;
		this.endY=endY;
	}

	@Override
	public void draw(Graphics2D g) {
		// TODO Auto-generated method stub
		g.setStroke(new BasicStroke(strokeSize,BasicStroke.CAP_ROUND,BasicStroke.JOIN_ROUND));
		g.setColor(figureColor);
		g.drawLine(startX, startY, endX, endY);
	}

	@Override
	public void calc(int currentX, int currentY) {
		// TODO Auto-generated method stub
		setFigureSize(currentX,currentY);
	}
	
	public void moveTo(int curX,int curY)
	{
		startX+=curX;
		startY+=curY;
		endX+=curX;
		endY+=curY;
	}




	@Override
	public String toString() {
		return  "선"
				+ "[시작점X=" + startX + ", 시작점Y=" + startY+" 끝점X=" + endX + ", 끝점Y=" + endY + "]";
	}
	
	@Override
	 public Figure clone() { 
			Line object = new Line(0,0,0,0);			
			object.endX=endY;
			object.endY=endY;
			object.startX=startX;
			object.startY=startY;
			object.strokeSize=strokeSize;
			return object;
	    }
}
