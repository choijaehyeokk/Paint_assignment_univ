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
	//MainFrame ��ü instance ����.
	
	
	public static MainFrame getInstance()
	{
		if(instance==null)
			instance = new MainFrame(Data.PROGRAM_NAME);
		//Information�� Program_Name�� MainFrame�� Parameter�� �Ѱ��־� JFrame()�� �̸��� ����.
		return instance;
		//MainFrame�� ��ü instance�� ��ȯ.
	}//�ٸ� Ŭ�������� �� Ŭ������ �ν��Ͻ��� new�� �̿��� �������� ���ϰ��ϰ�, �׻� getInstance()�� ����ؼ� �ν��Ͻ��� ������ �����Ѵ�.

	public MainFrame(String name)
	{
		super(name);
		//Information.PROGRAM_NAME(Sting��)�� �θ� Ŭ������ JFrame�� �����ڷ� ����.
		toolPanel = new ToolPanel();
		//leftPanel�� �׸����� ���ʿ� �ִ� �гην� �������� �׸� �� �ִ� ����� �����Ѵ�.
		bottomLabel = new Coordinates("Start");
		//bottomLabel �� �׸����� �Ʒ����� �ִ� �гην� ���콺 �����Ͱ� �����ϰ� �ִ� X,Y��ǥ�� ���õ� ���� �����Ѵ�.
		setupPanel = new SetupPanel();
		//topPanel�� �׸����� ���ʿ� �ִ� �гην� �ؽ�Ʈ�� ũ��,���� ũ��,���� font�� �������ش�.	
		add(toolPanel, BorderLayout.NORTH);
		add(bottomLabel, BorderLayout.SOUTH);
		add(setupPanel,BorderLayout.WEST);
		//�� �г��� ��ġ�� ��������.
		
		menuBar = new TopMenu();
		//File �� Images�� ��� �ִ� �г���JMenuBar�� �߰��Ѵ�.
		setJMenuBar(menuBar);
		//menuBar�� Frame�� set��.
		
		add(MainSubPanel.getInstance());
		//stackâ�� �׸��׸��� centerPanel�� Frame�� ��´�.
		
	}
	public void addDrawFrame(String name){
		CusorPanel newFrame = new CusorPanel();
		newFrame.setLocation(0,0);
		newFrame.setSize(1200,1000);

		//�׸��� �׸��� CoursorPanel�� setting��.
		MainSubPanel.getInstance().addDrawFrameToSet(name, newFrame);
		//String �� CoursorPanel ��ü�� �޾Ƽ� Frame�� ��´�.
		//getInstance()�޼��带 �̿��ؼ� CenterPanel��ü�� �̸�(name)�� ���� MainDesktopPane�� �����Ѵ�.
		MainSubPanel.getInstance().add(newFrame);
		//MainSubPanel�� CoursorPanel��ü�� ��´�.
	}
	

	public void setBottomLabel(String text)
	//text����(String)�� �޴´�.
	//DrawPanel���� mouse�� Drag�ϰų� move�Ҷ��� setting��.
	{
		Color color =Data.getCurrentColor();
		String mode = Data.getCurrentModeToString();
		//mode�� Information���� ��ư�� Ŭ���Ǹ� Current��尡 Set��.
		bottomLabel.setText("���� ��� : "+ mode+"   ���� ��ǥ : "+ text);
	}
	
	public void setBottomLabel(Color color)
	{
		String mode = Data.getCurrentModeToString();
		bottomLabel.setText("���� ��� : "+ mode+"   ���� ��ǥ : Out of frame");
	}

	
}
