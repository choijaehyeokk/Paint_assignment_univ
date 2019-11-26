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
	// ���� ������ X�� Y��ǥ�� �̵������ָ� ��ǥ�� �̵��� �ȴ�.
	public abstract void setFigureSize(int width, int height);
	//������ �ʺ�� ���̸� �������ش�.
	public abstract void draw(Graphics2D g);
	//Graphics2D �� �̿��ؼ� ������ �׸��� �� �޼����̴�.
	public abstract void calc(int currentX, int currentY);
	//������ �׸��� �� �� X�� Y��ǥ�� ����ϴ� �޼����̴�.
	public abstract Figure clone();
	//������ ����ü�� ����� clone()�޼����̴�. �� �޼��带 ����ϸ� ������� ������ ���� ����,��ǥ,������ ���� object��ü�� ������
}
