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
	//key���� �����ʹ� String�̰�,�����ʹ� CenterPanel�̴�.
	private LayerFrame layerframe;
	//�����ʿ� ���̾ƿ��� ������ �� �ִ� �������� ����.
	private CusorPanel cusorPanel;
	//��� �׸��� �׸� �г��� ����. DrawPanel�� ��ӹ޾ұ� ������ �׸��� �׸��� �г��̴�.
	
	private static MainSubPanel instance;
	
	
	
	public static MainSubPanel getInstance()
	{
		if(instance==null)
			instance = new MainSubPanel();
		//�ѹ��� MainSubPanel��ü�� �����Ѵ�. ���ʿ�
		return instance;
	}//getInsatnc()�޼��带 ���� ������ �Ź� new�� ��ü�� �������� �ʰ�,�ѹ��� ��ü�� �����ϰ� ���Ŀ� ��� Ŭ�������� ������ ��ü�� ���� �ȴ�.
	
	public MainSubPanel()
	{
		Data.setCurrentMainDesktopPane(this);
		//Data������ MainSubPanel��ü�� ��´�.
		this.changeCursor();
		//icon�� ���������� Ŀ���� ����� �ٲ۴�.
		drawFrameSet= new HashMap<String, CusorPanel>();
		//String,CoursorPanel��ü�� �޾Ƽ� listó�� �ϳ��ϳ��� �޴´�. ���ü�����. �迭�̶�� ġ�� drawFrameSet�� ����Ʈ���Ǵ� ����.

		Color background = new Color(255,255,255);
		this.setBackground(background);
		//Background�� ���� ������� setting�Ѵ�.
	
		cusorPanel = new CusorPanel();
		//cusorPanel ��ü�� ����.
		layerframe = LayerFrame.getInstance();
		//�����ʿ� ���̾ƿ��� ��� stackFrame ����
		

		this.add(layerframe);
		this.add(cusorPanel);
	//���̾�� �׸����׸��� �г��� ������.
	}
	
	public static void setBack(Color color){
		instance.setBackground(color);
	}
	//instance�� ��� ���� setting�Ѵ�.
	
	@Override
	public void paintComponent(Graphics g)
	{
		int width = getWidth();
		int height = getHeight();
		layerframe.setLocation(width-300,0);
		//���̾��������� ���Ѵ�.
		cusorPanel.setLocation(0,0);
		//�ٲ�� Ŀ�� ���� �׸��� �׸��� �ְ� ������ ���� DrawPanel�� setting�Ѵ�.
	}

	public void addDrawFrameToSet(String name, CusorPanel newFrame)
	//HashMap�� list�ϳ��ϳ� �޴� �� �̸� �� string,newFrame(CenterPanel)��ü ���·� drawFrameset�� ��´�.
	{
		drawFrameSet.put(name, newFrame);
	}
	
	public CusorPanel getDrawFrame()
	{
		return CusorPanel.getInstance();
	}
	//CusorPanel�� ��ü�� ��� �޼����̴�.
	public void changeCursor()//Ŀ�� ����� toolkit���� �ٲٴ� �޼���
	{	  
		Toolkit toolkit = Toolkit.getDefaultToolkit();
		//Toolkit�� �̿��Ͽ� �̹��������� �� �� �ְ� ���ش�.
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
		//Cusor�� �ٲ𵿾� �̹����� ���� �ٸ��� ���־ ���콺�� ������ �̹����� �ٸ������ش�.
		Cursor c = toolkit.createCustomCursor(image /*�̹���*/, new Point(15,15)/*Ŀ���� �߾���ǥ*/, "Ŀ��"/*Ŀ���� �̸�����*/);
		this.setCursor (c);
		//�ٲ� Cusor�� Set�س��´�.
	}
}
