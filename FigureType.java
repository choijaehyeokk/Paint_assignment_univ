package figure;

import java.awt.Graphics2D;
import java.util.ArrayList;

import figure.PenType.trace;

public abstract class FigureType extends Figure{
	protected int width,height;
	protected int startX,startY;//���״�� ������ �������� �ϱ����� �ϴ� �ʱⰪ�� ���?�ϴ� �뵵�� �����
	protected int X,Y;//ex fillRect(����, ����, , )�� ������ ������?����  moveTo�Լ����� �� ���� �ٲ����μ� ������ ũ��� ������ä�� �̵��ϴ°�ó�� ���ϼ� �ִ°�

	
	
	public FigureType(int startX, int startY,int width,int height)
	{
		super();
		this.startX=startX;
		this.startY=startY;
		this.width=width;
		this.height=height;
		X = startX;
		Y = startY;
	}
	
	
	@Override
	public void setFigureSize(int width, int height) {
		// TODO Auto-generated method stub
		this.width=width;
		this.height=height;
		
	}

	@Override
	public abstract void draw(Graphics2D g);

	@Override
	public void calc(int currentX, int currentY) {//������ �׸����� resize�Ҷ� �ż��� '�ʺ�','����'�� �ٲ�°��� �����ϱ����� �Լ�
		// TODO Auto-generated method stub


		int wantWidth = currentX-startX;
		int wantHeight = currentY-startY;
		
		setFigureSize(Math.abs(wantWidth),Math.abs(wantHeight));
		
		if(wantWidth<0 && wantHeight <0)
		{
				X=startX+wantWidth;
				Y=startY+wantHeight;
		}
		else if(wantWidth<0 && wantHeight >=0)
		{
			
			X=startX+wantWidth;
		}
		else if(wantWidth>=0 && wantHeight <0)
		{
			Y=startY+wantHeight;
		
		}
		else if(wantWidth>=0 && wantHeight >=0)
		{
			X=startX; Y=startY;
		}
	}
	
	public void moveTo(int curX,int curY)
	{
		X+=curX;
		Y+=curY;
	}
	
	public abstract Figure clone();
}
