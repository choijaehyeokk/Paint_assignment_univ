package Frame;

import java.awt.Color;
import java.awt.event.KeyEvent;
import javax.swing.JFrame;

public class Main {
	public static void main(String[] args) {
		MainFrame.getInstance().setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		//MainFrame�� JVM���� ������ ������ �� �� �ֵ��� ���ش�.
		MainFrame.getInstance().setSize(Data.PROGRAM_WIDTH,Data.PROGRAM_HEIGHT);
		//Data���� �����س��� ������ ����� �°� ũ�⸦ �����ش�.
		MainFrame.getInstance().setVisible(true);	
		//MainFrame�� �����ش�.	
	}
}
