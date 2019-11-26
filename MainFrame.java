package Frame;

import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.Color;
import java.awt.Cursor;
import java.awt.Image;
import java.awt.Point;
import java.awt.Toolkit;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;

public class MainFrame extends JFrame{
	
	private ToolPanel toolPanel;
	private Coordinates bottomLabel;
	private SetupPanel setupPanel;
	private TopMenu menuBar;
	private static MainFrame instance;
	//MainFrame 객체 instance 선언.
	
	
	public static MainFrame getInstance()
	{
		if(instance==null)
			instance = new MainFrame(Data.PROGRAM_NAME);
		//Information의 Program_Name을 MainFrame의 Parameter로 넘겨주어 JFrame()의 이름을 설정.
		return instance;
		//MainFrame의 객체 instance를 반환.
	}//다른 클래스에서 이 클래스의 인스턴스를 new를 이용해 생성하지 못하게하고, 항상 getInstance()를 사용해서 인스턴스를 갖도록 제한한다.

	public MainFrame(String name)
	{
		super(name);
		//Information.PROGRAM_NAME(Sting값)을 부모 클래스인 JFrame의 생성자로 담음.
		toolPanel = new ToolPanel();
		//leftPanel은 그림판의 왼쪽에 있는 패널로써 여러가지 그릴 수 있는 기능을 제공한다.
		bottomLabel = new Coordinates("Start");
		//bottomLabel 은 그림판의 아래쪽의 있는 패널로써 마우스 포인터가 지정하고 있는 X,Y좌표와 선택된 색을 지정한다.
		setupPanel = new SetupPanel();
		//topPanel은 그림판의 위쪽에 있는 패널로써 텍스트의 크기,선의 크기,선의 font를 지정해준다.	
		add(toolPanel, BorderLayout.NORTH);
		add(bottomLabel, BorderLayout.SOUTH);
		add(setupPanel,BorderLayout.WEST);
		//각 패널의 위치를 지정해줌.
		
		menuBar = new TopMenu();
		//File 과 Images를 담고 있는 패널을JMenuBar를 추가한다.
		setJMenuBar(menuBar);
		//menuBar를 Frame에 set함.
		
		add(MainSubPanel.getInstance());
		//stack창과 그림그리는 centerPanel을 Frame에 담는다.
		
	}
	public void addDrawFrame(String name){
		CusorPanel newFrame = new CusorPanel();
		newFrame.setLocation(0,0);
		newFrame.setSize(1200,1000);

		//그림을 그리는 CoursorPanel을 setting함.
		MainSubPanel.getInstance().addDrawFrameToSet(name, newFrame);
		//String 과 CoursorPanel 객체를 받아서 Frame에 담는다.
		//getInstance()메서드를 이용해서 CenterPanel객체와 이름(name)을 담은 MainDesktopPane을 생성한다.
		MainSubPanel.getInstance().add(newFrame);
		//MainSubPanel에 CoursorPanel객체를 찍는다.
	}
	

	public void setBottomLabel(String text)
	//text인자(String)을 받는다.
	//DrawPanel에서 mouse를 Drag하거나 move할때만 setting됨.
	{
		Color color =Data.getCurrentColor();
		String mode = Data.getCurrentModeToString();
		//mode는 Information에서 버튼이 클릭되면 Current모드가 Set됨.
		bottomLabel.setText("현재 모드 : "+ mode+"   현재 좌표 : "+ text);
	}
	
	public void setBottomLabel(Color color)
	{
		String mode = Data.getCurrentModeToString();
		bottomLabel.setText("현재 모드 : "+ mode+"   현재 좌표 : Out of frame");
	}

	
}
