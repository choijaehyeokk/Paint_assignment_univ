package Frame;

import java.awt.Color;
import java.awt.Font;
import java.awt.Toolkit;

import figure.Figure;

public class Data {
	
	public static final String PROGRAM_NAME ="자바로 구현한 그림판";
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
	//int 값으로 각각 모드를 선택해서 setting할 수 있게 값을 지정해준다.
	public static String FilePath;
	//파일의 경로를 담는 String을 선언해준다.
	private static Toolkit toolkit = Toolkit.getDefaultToolkit();
	//Default값으로 toolkit도구를 선언해주고 초기화해준다.
	
	public static String getFilePath() {
		return FilePath;
	}
	public static void setFilePath(String filePath) {
		FilePath = filePath;
	}
	//getter와setter로 파일의 경로를 다른클래스에서 set하고 get할 수 있는 메서드를 만들어준다.
	
	public static Toolkit getToolkit()
	{
		return toolkit;
	}
	
	
	private static int textStyle=Font.PLAIN;
	//초기 font를 plain으로 설정해준다.
	
	public static void setTextStyle(int font)
	{
		textStyle=font;
	}
	public static int gettextStyle()
	{
		return textStyle;
	}
	//font를 int로 받아서 textstyle을 구분해 줄 수 있게 해준다.getter와 setter로 font가 무엇인지 set하고 get할 수 있는 메서드를 만들어준다.
	
	private static int textSize=1;
	//초기 문자 size는 1로 해준다.
	public static void setTextSize(int size)
	{
		textSize=size;
	}
	
	public static int getTextSize()
	{
		return textSize;
	}
	//textsize도 int로 받아서 크기를 얻는다. getter와 setter로 Size가 얼마인지 set하고 get할 수 있는 메서드를 만들어준다.
	
	private static int LineSize=1;
	//초기 선의 size는 1로 해준다.
	public static void setLineSize(int size)
	{
		LineSize=size;
	}
	
	public static int getLineSize()
	{
		return LineSize;
	}
	//linesize도 int로 받아서 크기를 얻는다. getter와 setter로 Size가 얼마인지 set하고 get할 수 있는 메서드를 만들어준다.
	
	private static Figure currentFigure =null;
	//현재 Figure객체는 null값으로 초기화해준다.
	
	public static void setCurrentFigure(Figure cur)
	{
		currentFigure = cur;
	}
	//Figure가 들어오면 currentFigure가 바뀐다.
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
		//현재 MainDesktopPane 객체가 가지고 있는 정보인 current변수를 이용해서 세팅한다.
	}
	public static MainSubPanel getCurrentMainDesktopPane()
	{
		return currentMainDesktopPane;
	}
	//DrawPanel과 MainSubPanel객체를 받아서 setting해준다. getter와 setter로 이패널이 어떤패널인지 다른 클래스에서 알 수 있게 도와준다.
	
	private static int DrawFrame_Count =1;
	//그림을 그릴때 count를 증가하면서 stack에 인덱스 값을 지정해줌.
	private static int CurrentMode=8;
	//기본적으로 쓰기모드로 저장해둠.
	private static Color currentColor=new Color(0,0,0);
	//색은 검정색으로 정해준다.
	
	public static  int getDrawFrame_Count()
	{
		return DrawFrame_Count;
	}
	//현재 그림그린 프레임의 count를 해준다.
	public static  void addDrawFrame_Count()
	{
		DrawFrame_Count++;
	}
	//그림이 하나씩 그려질때마다 addDrawFrame_Count메서드를 실행하면서 count를 증가함.
	public static String getCurrentModeToString()
	{
		switch(CurrentMode)
		{
		case MODE_DRAW_REC : return "빈사각형 그리기";
		case MODE_DRAW_TRIANGLE : return "빈삼각형 그리기";
		case MODE_DRAW_CIRCLE : return "빈원 그리기";
		case MODE_DRAW_FILLREC : return "채운사각형 그리기";
		case MODE_DRAW_FILLTRIANGLE : return "채운삼각형 그리기";
		case MODE_DRAW_FILLCIRCLE : return "채운원 그리기";
		case MODE_DRAW_LINE : return "선 그리기";
		case MODE_ERASE : return "지우기";
		case MODE_TEXT : return "텍스트 편집";
		case MODE_MOVE : return "이동 모드";
		case MODE_PEN : return " 그리기";
		case MODE_PAINT: return "채우기";
		case MODE_RESIZE : return "리사이즈 모드";
		case MODE_IMAGE : return "이미지 넣기";
		
		default : return "선택된 모드가 없습니다.";
		}
		
	}
	//현재 모드가 어떤 모드인지에 따라서 그 모드를 알려주는 String을 반환해주는 메서드이다.
	
	public static int getCurrentMode()
	{
		return CurrentMode;
	}
	public static void setCurrentMode(int mode)
	{
		CurrentMode=mode;		
	}
	//현재모드를 위에 변수로 지정해 놓았던 것을 넣으면서 모드를 get하고 set할 수 있게 해준다.(int)값으로
	
	public static int image;
	public static void setCurrentImage(int a)
	{
		image = a;
	}
	public static int getCurrentImage()
	{
		return image;
	}
	//현재 이미지가 어떤 이미지 인지 마우스가 클릭되면, 클릭될때 int를 넣어주어서 image를 구분할 수 있게 해주는 메서드이다.
	
	public static Color getCurrentColor()
	{
		return currentColor;
	}
	
	public static void setCurrentColor(int R, int G, int B)
	{
		Color changeColor = new Color(R,G,B);
		currentColor= changeColor;	
	}
	//색을 set하고 get할 수 있는 메서드이다.
}
