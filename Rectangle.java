package figure;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;

import Frame.Data;

public class Rectangle extends FigureType{
	
	public Rectangle(int startX, int startY,int width,int height)
	{
		super(startX,startY,width,height);		
	}
	@Override
	public void draw(Graphics2D g) 
	{	
			g.setColor(figureColor);
			g.drawRect(X, Y, width, height);		
	}
	@Override
	public String toString() 
	{
		return "빈 사각형 [너비=" + width + ", 높이=" + height + "]";
	}
	@Override
	 public Figure clone() 
	{ 
			Rectangle object = new Rectangle(0,0,0,0);
			object.startX=startX;
			object.startY=startY;
			object.width=width;
			object.height=height;
			object.figureColor=figureColor;
			object.X=X;
			object.Y=Y;			
			return object;
	 }
}
