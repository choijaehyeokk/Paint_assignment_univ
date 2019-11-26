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
			icon = new ImageIcon("resource/이미지/쥐.png");
			img1 = icon.getImage();
			g.drawImage(img1, X,Y,width,height,null);
		}
		else if(Data.getCurrentImage() == 2)
		{
			icon = new ImageIcon("resource/이미지/소.png");
			img2 = icon.getImage();
			g.drawImage(img2, X,Y,width,height, null);
		}
		else if(Data.getCurrentImage() == 3)
		{
			icon = new ImageIcon("resource/이미지/호랑이.png");
			img3 = icon.getImage();
			g.drawImage(img3, X,Y,width,height, null);
		}
		else if(Data.getCurrentImage() == 4)
		{
			icon = new ImageIcon("resource/이미지/토끼.png");
			img4 = icon.getImage();
			g.drawImage(img4, X,Y,width,height, null);
		}
		else if(Data.getCurrentImage() == 5)
		{
			icon = new ImageIcon("resource/이미지/용.png");
			img5 = icon.getImage();
			g.drawImage(img5, X,Y,width,height, null);
		}
		else if(Data.getCurrentImage() == 6)
		{
			icon = new ImageIcon("resource/이미지/뱀.png");
			img6 = icon.getImage();
			g.drawImage(img6, X,Y,width,height, null);
		}
		else if(Data.getCurrentImage() == 7)
		{
			icon = new ImageIcon("resource/이미지/말.png");
			img7 = icon.getImage();
			g.drawImage(img7, X,Y,width,height, null);
		}
		else if(Data.getCurrentImage() == 8)
		{
			icon = new ImageIcon("resource/이미지/양.png");
			img8 = icon.getImage();
			g.drawImage(img8, X,Y,width,height, null);
		}
		else if(Data.getCurrentImage() == 9)
		{
			icon = new ImageIcon("resource/이미지/원숭이.png");
			img9 = icon.getImage();
			g.drawImage(img9, X,Y,width,height, null);
		}
		else if(Data.getCurrentImage() == 10)
		{
			icon = new ImageIcon("resource/이미지/닭.png");
			img10 = icon.getImage();
			g.drawImage(img10, X,Y,width,height, null);
		}
		else if(Data.getCurrentImage() == 11)
		{
			icon = new ImageIcon("resource/이미지/개.png");
			img11 = icon.getImage();
			g.drawImage(img11, X,Y,width,height, null);
		}
		else if(Data.getCurrentImage() == 12)
		{
			icon = new ImageIcon("resource/이미지/돼지.png");
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
	//각 아이콘들의 int값을 받아서 그 아이콘이 해당하는 경로에 있는 그림을 그린다. 
	public String toString() 
	{
		return "ImageIcon [너비=" + width + ", 높이=" + height + "]";
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
	//복사체를 생성하는 메서드 clone()이다.
}
