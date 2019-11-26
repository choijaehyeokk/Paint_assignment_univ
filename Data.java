package Frame;

import java.awt.Color;
import java.awt.Font;
import java.awt.Toolkit;

import figure.Figure;

public class Data {
	
	public static final String PROGRAM_NAME ="�ڹٷ� ������ �׸���";
	public static final int PROGRAM_WIDTH = 1280;
	public static final int PROGRAM_HEIGHT = 1000;
	
	public static final int MODE_DRAW_REC=1;
	public static final int MODE_DRAW_TRIANGLE=2;
	public static final int MODE_DRAW_CIRCLE=3;
	public static final int MODE_DRAW_LINE=4;
	public static final int MODE_ERASE=5;
	public static final int MODE_TEXT=6;
	public static final int MODE_MOVE=7;
	public static final int MODE_PEN=8;
	public static final int MODE_PAINT=9;
	public static final int MODE_RESIZE=10;
	public static final int MODE_PALETTE = 11;
	public static final int MODE_IMAGE = 12;
	public static final int MODE_DRAW_FILLREC=13;
	public static final int MODE_DRAW_FILLTRIANGLE=14;
	public static final int MODE_DRAW_FILLCIRCLE=15;
	
	
	public static final int IS_EMPTY=-1;
	public static final int IS_ERASER=0;
	public static final int IS_FIGURE=1;
	//int ������ ���� ��带 �����ؼ� setting�� �� �ְ� ���� �������ش�.
	public static String FilePath;
	//������ ��θ� ��� String�� �������ش�.
	private static Toolkit toolkit = Toolkit.getDefaultToolkit();
	//Default������ toolkit������ �������ְ� �ʱ�ȭ���ش�.
	
	public static String getFilePath() {
		return FilePath;
	}
	public static void setFilePath(String filePath) {
		FilePath = filePath;
	}
	//getter��setter�� ������ ��θ� �ٸ�Ŭ�������� set�ϰ� get�� �� �ִ� �޼��带 ������ش�.
	
	public static Toolkit getToolkit()
	{
		return toolkit;
	}
	
	
	private static int textStyle=Font.PLAIN;
	//�ʱ� font�� plain���� �������ش�.
	
	public static void setTextStyle(int font)
	{
		textStyle=font;
	}
	public static int gettextStyle()
	{
		return textStyle;
	}
	//font�� int�� �޾Ƽ� textstyle�� ������ �� �� �ְ� ���ش�.getter�� setter�� font�� �������� set�ϰ� get�� �� �ִ� �޼��带 ������ش�.
	
	private static int textSize=1;
	//�ʱ� ���� size�� 1�� ���ش�.
	public static void setTextSize(int size)
	{
		textSize=size;
	}
	
	public static int getTextSize()
	{
		return textSize;
	}
	//textsize�� int�� �޾Ƽ� ũ�⸦ ��´�. getter�� setter�� Size�� ������ set�ϰ� get�� �� �ִ� �޼��带 ������ش�.
	
	private static int LineSize=1;
	//�ʱ� ���� size�� 1�� ���ش�.
	public static void setLineSize(int size)
	{
		LineSize=size;
	}
	
	public static int getLineSize()
	{
		return LineSize;
	}
	//linesize�� int�� �޾Ƽ� ũ�⸦ ��´�. getter�� setter�� Size�� ������ set�ϰ� get�� �� �ִ� �޼��带 ������ش�.
	
	private static Figure currentFigure =null;
	//���� Figure��ü�� null������ �ʱ�ȭ���ش�.
	
	public static void setCurrentFigure(Figure cur)
	{
		currentFigure = cur;
	}
	//Figure�� ������ currentFigure�� �ٲ��.
	public static Figure getCurrentFigure()
	{
		return currentFigure;
	}
	
	private static DrawPanel currentPanel=null;
	private static MainSubPanel currentMainDesktopPane=null;

	public static void setCurrentpanel(DrawPanel current)
	{
		currentPanel=current;		
	}
	public static DrawPanel getCurrentJPanel()
	{
		return currentPanel;
	}
	public static void setCurrentMainDesktopPane(MainSubPanel current)
	{
		currentMainDesktopPane=current;
		//���� MainDesktopPane ��ü�� ������ �ִ� ������ current������ �̿��ؼ� �����Ѵ�.
	}
	public static MainSubPanel getCurrentMainDesktopPane()
	{
		return currentMainDesktopPane;
	}
	//DrawPanel�� MainSubPanel��ü�� �޾Ƽ� setting���ش�. getter�� setter�� ���г��� ��г����� �ٸ� Ŭ�������� �� �� �ְ� �����ش�.
	
	private static int DrawFrame_Count =1;
	//�׸��� �׸��� count�� �����ϸ鼭 stack�� �ε��� ���� ��������.
	private static int CurrentMode=8;
	//�⺻������ ������� �����ص�.
	private static Color currentColor=new Color(0,0,0);
	//���� ���������� �����ش�.
	
	public static  int getDrawFrame_Count()
	{
		return DrawFrame_Count;
	}
	//���� �׸��׸� �������� count�� ���ش�.
	public static  void addDrawFrame_Count()
	{
		DrawFrame_Count++;
	}
	//�׸��� �ϳ��� �׷��������� addDrawFrame_Count�޼��带 �����ϸ鼭 count�� ������.
	public static String getCurrentModeToString()
	{
		switch(CurrentMode)
		{
		case MODE_DRAW_REC : return "��簢�� �׸���";
		case MODE_DRAW_TRIANGLE : return "��ﰢ�� �׸���";
		case MODE_DRAW_CIRCLE : return "��� �׸���";
		case MODE_DRAW_FILLREC : return "ä��簢�� �׸���";
		case MODE_DRAW_FILLTRIANGLE : return "ä��ﰢ�� �׸���";
		case MODE_DRAW_FILLCIRCLE : return "ä��� �׸���";
		case MODE_DRAW_LINE : return "�� �׸���";
		case MODE_ERASE : return "�����";
		case MODE_TEXT : return "�ؽ�Ʈ ����";
		case MODE_MOVE : return "�̵� ���";
		case MODE_PEN : return " �׸���";
		case MODE_PAINT: return "ä���";
		case MODE_RESIZE : return "�������� ���";
		case MODE_IMAGE : return "�̹��� �ֱ�";
		
		default : return "���õ� ��尡 �����ϴ�.";
		}
		
	}
	//���� ��尡 � ��������� ���� �� ��带 �˷��ִ� String�� ��ȯ���ִ� �޼����̴�.
	
	public static int getCurrentMode()
	{
		return CurrentMode;
	}
	public static void setCurrentMode(int mode)
	{
		CurrentMode=mode;		
	}
	//�����带 ���� ������ ������ ���Ҵ� ���� �����鼭 ��带 get�ϰ� set�� �� �ְ� ���ش�.(int)������
	
	public static int image;
	public static void setCurrentImage(int a)
	{
		image = a;
	}
	public static int getCurrentImage()
	{
		return image;
	}
	//���� �̹����� � �̹��� ���� ���콺�� Ŭ���Ǹ�, Ŭ���ɶ� int�� �־��־ image�� ������ �� �ְ� ���ִ� �޼����̴�.
	
	public static Color getCurrentColor()
	{
		return currentColor;
	}
	
	public static void setCurrentColor(int R, int G, int B)
	{
		Color changeColor = new Color(R,G,B);
		currentColor= changeColor;	
	}
	//���� set�ϰ� get�� �� �ִ� �޼����̴�.
}
