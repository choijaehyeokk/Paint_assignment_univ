package figure;

import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Point;
import java.util.Arrays;

import Frame.Data;

public class Triangle extends Figure{
	
	private int[] xPoints ={0,0,0};
	private int[] yPoints ={0,0,0};
	
	
	public Triangle(int startX, int startY)
	{
		super();
		this.xPoints[0]=this.xPoints[1]=this.xPoints[2]=startX;
		this.yPoints[0]=this.yPoints[2]=this.yPoints[2]=startY;
	}
	
	
	
	
	@Override
	public void setFigureSize(int xPoint, int yPoint) {
		
		xPoints[2]=xPoint;
		yPoints[2]=yPoint;
		
		xPoints[1] = xPoints[2]-(xPoint-xPoints[0])*2;
		yPoints[1]=yPoint;
	}

	@Override
	public void draw(Graphics2D g) {
		g.setColor(figureColor);
		g.drawPolygon(xPoints, yPoints, 3);
	}

	@Override
	public void calc(int currentX, int currentY) {
		setFigureSize(currentX,currentY);
	}
	
	public void moveTo(int curX,int curY)
	{
		xPoints[0]+=curX;
		xPoints[1]+=curX;
		xPoints[2]+=curX;
		
		yPoints[0]+=curY;
		yPoints[1]+=curY;
		yPoints[2]+=curY;		
	}


	@Override
	public String toString() {
		return "∫Û ªÔ∞¢«¸ [Ω√¿€¡°X=" + Arrays.toString(xPoints) + ", Ω√¿€¡°Y=" + Arrays.toString(yPoints) + "]";
	}
	
	
	@Override
	 public Figure clone() { 
			Triangle object = new Triangle(0,0);
			object.xPoints=xPoints.clone();
			object.yPoints=yPoints.clone();
			return object;
	    }
}
