package Frame;

import java.awt.Color;
import java.awt.Cursor;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Point;
import java.awt.Toolkit;
import java.awt.event.KeyListener;
import java.awt.event.MouseMotionListener;
import java.util.HashMap;
import javax.swing.ImageIcon;
import javax.swing.JDesktopPane;
import javax.swing.JLabel;

public class MainSubPanel extends JDesktopPane{
	private HashMap<String, CusorPanel> drawFrameSet;
	//drawInternalFrameSet = {(String,CenterPanel),(String,CenterPanel),(String,CenterPanel).....}
	//key값의 데이터는 String이고,데이터는 CenterPanel이다.
	private LayerFrame layerframe;
	//오른쪽에 레이아웃을 선택할 수 있는 프레임을 만듬.
	private CusorPanel cusorPanel;
	//가운데 그림을 그릴 패널을 선언. DrawPanel을 상속받았기 때문에 그림을 그리는 패널이다.
	
	private static MainSubPanel instance;
	
	
	
	public static MainSubPanel getInstance()
	{
		if(instance==null)
			instance = new MainSubPanel();
		//한번만 MainSubPanel객체를 생성한다. 최초에
		return instance;
	}//getInsatnc()메서드를 쓰는 이유는 매번 new로 객체를 생성하지 않고,한번만 객체를 생성하고 그후에 모든 클래스들이 동일한 객체를 쓰게 된다.
	
	public MainSubPanel()
	{
		Data.setCurrentMainDesktopPane(this);
		//Data정보에 MainSubPanel객체를 담는다.
		this.changeCursor();
		//icon을 누를때마다 커서의 모양을 바꾼다.
		drawFrameSet= new HashMap<String, CusorPanel>();
		//String,CoursorPanel객체를 받아서 list처럼 하나하나씩 받는다. 스택순서로. 배열이라고 치면 drawFrameSet은 리스트가되는 개념.

		Color background = new Color(255,255,255);
		this.setBackground(background);
		//Background의 색을 흰색으로 setting한다.
	
		cusorPanel = new CusorPanel();
		//cusorPanel 객체를 생성.
		layerframe = LayerFrame.getInstance();
		//오른쪽에 레이아웃을 담는 stackFrame 생성
		

		this.add(layerframe);
		this.add(cusorPanel);
	//레이어와 그림을그리는 패널을 붙힌다.
	}
	
	public static void setBack(Color color){
		instance.setBackground(color);
	}
	//instance의 배경 색을 setting한다.
	
	@Override
	public void paintComponent(Graphics g)
	{
		int width = getWidth();
		int height = getHeight();
		layerframe.setLocation(width-300,0);
		//레이어프레임을 더한다.
		cusorPanel.setLocation(0,0);
		//바뀌는 커서 마다 그림을 그릴수 있게 세팅해 놓은 DrawPanel을 setting한다.
	}

	public void addDrawFrameToSet(String name, CusorPanel newFrame)
	//HashMap에 list하나하나 받는 데 이름 은 string,newFrame(CenterPanel)객체 형태로 drawFrameset에 담는다.
	{
		drawFrameSet.put(name, newFrame);
	}
	
	public CusorPanel getDrawFrame()
	{
		return CusorPanel.getInstance();
	}
	//CusorPanel의 객체를 얻는 메서드이다.
	public void changeCursor()//커서 모양을 toolkit으로 바꾸는 메서드
	{	  
		Toolkit toolkit = Toolkit.getDefaultToolkit();
		//Toolkit을 이용하여 이미지파일을 쓸 수 있게 해준다.
		Image image;
		
		switch(Data.getCurrentMode())
		{
		case Data.MODE_DRAW_REC : 
			image = toolkit.getImage("resource/mouse/draw.png"); 
			break;
		case Data.MODE_DRAW_TRIANGLE :
			image = toolkit.getImage("resource/mouse/draw.png"); 
			break;
		case Data.MODE_DRAW_CIRCLE : 
			image = toolkit.getImage("resource/mouse/draw.png"); 
			break;
		case Data.MODE_DRAW_LINE : 
			image = toolkit.getImage("resource/mouse/draw.png"); 
			break;
		case Data.MODE_ERASE : 
			image = toolkit.getImage("resource/mouse/Eraser.png"); 
			break;
		case Data.MODE_TEXT : 
			image = toolkit.getImage("resource/mouse/text.png"); 
			break;
		case Data.MODE_MOVE : 
			image = toolkit.getImage("resource/mouse/hand.png"); 
			break;
		case Data.MODE_PEN : 
			image = toolkit.getImage("resource/mouse/pen.png"); 
			break;
		case Data.MODE_PAINT: 
			image = toolkit.getImage("resource/mouse/Brush.png"); 
			break;
		case Data.MODE_RESIZE :
			image = toolkit.getImage("resource/mouse/resize.png"); 
			break;
		default : 
			image = toolkit.getImage("resource/mouse/normal.png"); 
			break;
		}
		//Cusor가 바뀔동안 이미지를 각각 다르게 해주어서 마우스의 포인터 이미지를 다르게해준다.
		Cursor c = toolkit.createCustomCursor(image /*이미지*/, new Point(15,15)/*커서의 중앙좌표*/, "커서"/*커서의 이름지정*/);
		this.setCursor (c);
		//바뀐 Cusor로 Set해놓는다.
	}
}
