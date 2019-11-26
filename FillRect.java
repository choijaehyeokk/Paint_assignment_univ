package figure;

import java.awt.Graphics;
import java.awt.Graphics2D;

import Frame.Data;

public class FillRect extends FigureType{

	
	public FillRect(int startX, int startY,int width,int height)
	{
		super(startX,startY,width,height);		
	}
	@Override
	public void draw(Graphics2D g) 
	{	
			g.setColor(figureColor);
			g.fillRect(X, Y, width, height);		
	}
	@Override
	public String toString() 
	{
		return "ä�� �簢�� [�ʺ�=" + width + ", ����=" + height + "]";
	}
	@Override
	 public Figure clone() 
	{ 
			FillRect object = new FillRect(0,0,0,0);
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
