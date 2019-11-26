package figure;

import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;

import javax.swing.JOptionPane;

import Frame.Data;

public class Text extends Figure{
	

	private String text;
	private int startX,startY;
	private int textSize=10;
	private int fontStyle = Font.PLAIN;
	
	public Text(int StartX, int StartY, String str)
	{
		super();
		textSize=Data.getTextSize();
		fontStyle=Data.gettextStyle();
		this.startX=StartX;
		this.startY=StartY;
		text=str;
	}
	

	@Override
	public void setFigureSize(int width, int height) {
		
	}

	@Override
	public void draw(Graphics2D g) {
		
		g.setColor(figureColor);
		
		g.setFont(new Font(null,fontStyle,textSize));
		g.drawString(text, startX, startY);
		
	}

	@Override
	public void calc(int currentX, int currentY) {
		
		if(Data.getCurrentMode()==Data.MODE_RESIZE)
		{	
			int deltax=Math.abs(startX-currentX);
			int deltay=Math.abs(startX-currentX);
			textSize=(deltax+deltay/100);
			
		}
		
		
	}
	public void moveTo(int curX,int curY)
	{
		startX+=curX;
		startY+=curY;
	}


	@Override
	public String toString() {
		return "Text [text=" + text + ", textSize=" + textSize + "]";
	}

	@Override
	 public Figure clone() { 
			Text object = new Text(0,0,this.text);
			
			object.text=text;
			object.startX=startX;
			object.startY=startY;
			object.textSize=textSize;
			object.fontStyle=fontStyle;
			return object;
	    }
}
