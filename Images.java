package figure;

import java.awt.Graphics;
import java.awt.Graphics2D;

import javax.swing.ImageIcon;

import Frame.Data;

import java.awt.Image;
import java.awt.image.ImageObserver;

public class Images extends FigureType{

	public  Image img1,img2,img3,img4,img5,img6,img7,img8,img9,img10,img11,img12;
	public static ImageIcon icon;
	public Images(int startX,int startY,int width,int height)
	{
		super(startX,startY,width,height);
	}
	
	@Override
	public void draw(Graphics2D g) {
		
		if(Data.getCurrentImage() == 1)
		{
			icon = new ImageIcon("resource/�̹���/��.png");
			img1 = icon.getImage();
			g.drawImage(img1, X,Y,width,height,null);
		}
		else if(Data.getCurrentImage() == 2)
		{
			icon = new ImageIcon("resource/�̹���/��.png");
			img2 = icon.getImage();
			g.drawImage(img2, X,Y,width,height, null);
		}
		else if(Data.getCurrentImage() == 3)
		{
			icon = new ImageIcon("resource/�̹���/ȣ����.png");
			img3 = icon.getImage();
			g.drawImage(img3, X,Y,width,height, null);
		}
		else if(Data.getCurrentImage() == 4)
		{
			icon = new ImageIcon("resource/�̹���/�䳢.png");
			img4 = icon.getImage();
			g.drawImage(img4, X,Y,width,height, null);
		}
		else if(Data.getCurrentImage() == 5)
		{
			icon = new ImageIcon("resource/�̹���/��.png");
			img5 = icon.getImage();
			g.drawImage(img5, X,Y,width,height, null);
		}
		else if(Data.getCurrentImage() == 6)
		{
			icon = new ImageIcon("resource/�̹���/��.png");
			img6 = icon.getImage();
			g.drawImage(img6, X,Y,width,height, null);
		}
		else if(Data.getCurrentImage() == 7)
		{
			icon = new ImageIcon("resource/�̹���/��.png");
			img7 = icon.getImage();
			g.drawImage(img7, X,Y,width,height, null);
		}
		else if(Data.getCurrentImage() == 8)
		{
			icon = new ImageIcon("resource/�̹���/��.png");
			img8 = icon.getImage();
			g.drawImage(img8, X,Y,width,height, null);
		}
		else if(Data.getCurrentImage() == 9)
		{
			icon = new ImageIcon("resource/�̹���/������.png");
			img9 = icon.getImage();
			g.drawImage(img9, X,Y,width,height, null);
		}
		else if(Data.getCurrentImage() == 10)
		{
			icon = new ImageIcon("resource/�̹���/��.png");
			img10 = icon.getImage();
			g.drawImage(img10, X,Y,width,height, null);
		}
		else if(Data.getCurrentImage() == 11)
		{
			icon = new ImageIcon("resource/�̹���/��.png");
			img11 = icon.getImage();
			g.drawImage(img11, X,Y,width,height, null);
		}
		else if(Data.getCurrentImage() == 12)
		{
			icon = new ImageIcon("resource/�̹���/����.png");
			img12 = icon.getImage();
			g.drawImage(img12, X,Y,width,height, null);
		}
		else if(Data.getCurrentImage() == 20)
		{
			icon = new ImageIcon(Data.getFilePath());
			img2 = icon.getImage();
			g.drawImage(img2, X,Y,width,height, null);
		}
	}
	//�� �����ܵ��� int���� �޾Ƽ� �� �������� �ش��ϴ� ��ο� �ִ� �׸��� �׸���. 
	public String toString() 
	{
		return "ImageIcon [�ʺ�=" + width + ", ����=" + height + "]";
	}
	@Override
	public Figure clone() {
		Images object = new Images(0,0,0,0);
		object.startX=startX;
		object.startY=startY;
		object.width=width;
		object.height=height;
		object.figureColor=figureColor;
		object.X=X;
		object.Y=Y;			
		return object;
	}
	//����ü�� �����ϴ� �޼��� clone()�̴�.
}
