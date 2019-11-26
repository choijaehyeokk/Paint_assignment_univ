package figure;

import java.awt.Color;
import java.awt.Graphics2D;
import java.io.Serializable;

import Frame.Data;

public abstract class Figure implements Serializable ,Cloneable{	
	protected Color figureColor;

	public Figure()
	{
		figureColor=Data.getCurrentColor();
	}
	public void setColor(Color color)
	{
		this.figureColor=color;
	}
	public Color getColor()
	{
		return figureColor;
	}
	
	public abstract void moveTo(int curX,int curY);
	// 현재 도형의 X와 Y좌표를 이동시켜주면 좌표의 이동이 된다.
	public abstract void setFigureSize(int width, int height);
	//도형의 너비와 높이를 지정해준다.
	public abstract void draw(Graphics2D g);
	//Graphics2D 를 이용해서 도형을 그리게 될 메서드이다.
	public abstract void calc(int currentX, int currentY);
	//도형을 그리게 될 때 X와 Y좌표를 계산하는 메서드이다.
	public abstract Figure clone();
	//도형의 복사체를 만드는 clone()메서드이다. 이 메서드를 사용하면 만들어진 도형과 같은 유형,좌표,색상을 가진 object객체를 만들어낸다
}
