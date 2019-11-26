package figure;

import java.awt.BasicStroke;
import java.awt.Graphics;
import java.awt.Graphics2D;

import javax.swing.JOptionPane;

import Frame.Data;

public class Circle extends FigureType{
	
	
	public Circle(int startX, int startY,int width,int height)
	{
		super(startX,startY,width,height);
	}
	
	@Override
	public void draw(Graphics2D g) {
		g.setColor(figureColor);
		
		g.drawOval(X, Y, width, height);
		
	}

	@Override
	public String toString() {
		return "빈 원 [너비=" + width + ", 높이=" + height + "]";
	}

	@Override
	 public Figure clone() { 
		FillCircle object = new FillCircle(0,0,0,0);
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
