                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                              package Frame;

import java.awt.Color;
import java.awt.Cursor;
import java.awt.Image;
import java.awt.Point;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.JPanel;

public class CusorPanel extends DrawPanel {
	private DrawPanel draw;
	private static CusorPanel instance=null;
		public static CusorPanel getInstance()
		{
			if(instance==null)
				instance = new CusorPanel();
			return instance;
		}
		public CusorPanel()
		{
			setSize(2000,1000);
			setBackground(Color.WHITE);
			
			this.addMouseListener(new MouseListener() {
				
				@Override
				public void mouseReleased(MouseEvent e) {
					// TODO Auto-generated method stub
				
				}
				
				@Override
				public void mousePressed(MouseEvent e) {
					// TODO Auto-generated method stub
					
				}
				
				@Override
				public void mouseExited(MouseEvent e) {
					// TODO Auto-generated method stub
					
				}
				
				@Override
				public void mouseEntered(MouseEvent e) {
					// TODO Auto-generated method stub
					changeCursor();//그림판 창안에 들어가면 커서가 바뀌게 설정
				}
				
				@Override
				public void mouseClicked(MouseEvent e) {
					// TODO Auto-generated method stub
					
				}
			});
			
			this.setFocusable(true);
			
			setVisible(true);
		}
		public void  replacePanel(DrawPanel panel)
		{
			draw.changeVector(panel.getVector());
			repaint();
		}
	
		public void changeCursor()
		{	  
			Image image;

			
			switch(Data.getCurrentMode())
			{
			case Data.MODE_DRAW_REC : 
				image = Data.getToolkit().getImage("resource/mouse/draw.png"); break;
			case Data.MODE_DRAW_TRIANGLE : 
				image = Data.getToolkit().getImage("resource/mouse/draw.png"); break;
			case Data.MODE_DRAW_CIRCLE : 
				image = Data.getToolkit().getImage("resource/mouse/draw.png"); break;
			case Data.MODE_DRAW_LINE : 
				image = Data.getToolkit().getImage("resource/mouse/draw.png"); break;
			case Data.MODE_DRAW_FILLREC : 
				image = Data.getToolkit().getImage("resource/mouse/draw.png"); break;
			case Data.MODE_DRAW_FILLTRIANGLE : 
				image = Data.getToolkit().getImage("resource/mouse/draw.png"); break;
			case Data.MODE_DRAW_FILLCIRCLE : 
				image = Data.getToolkit().getImage("resource/mouse/draw.png"); break;
			case Data.MODE_ERASE : 
				image = Data.getToolkit().getImage("resource/mouse/Eraser.png"); break;
			case Data.MODE_TEXT : 
				image = Data.getToolkit().getImage("resource/mouse/text.png"); break;
			case Data.MODE_MOVE : 
				image = Data.getToolkit().getImage("resource/mouse/hand.png"); break;
			case Data.MODE_PEN : 
				image = Data.getToolkit().getImage("resource/mouse/pen.png"); break;
			case Data.MODE_PAINT: 
				image = Data.getToolkit().getImage("resource/mouse/Brush.png"); break;
			case Data.MODE_RESIZE :
				image = Data.getToolkit().getImage("resource/mouse/resize.png"); break;
			default : 
				image = Data.getToolkit().getImage("resource/mouse/normal.png"); break;
			}
			Cursor c = Data.getToolkit().createCustomCursor(image , new Point(15,15), "img");
			this.setCursor (c);
		}
}
