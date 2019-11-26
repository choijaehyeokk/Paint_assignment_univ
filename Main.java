package Frame;

import java.awt.Color;
import java.awt.event.KeyEvent;
import javax.swing.JFrame;

public class Main {
	public static void main(String[] args) {
		MainFrame.getInstance().setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		//MainFrame이 JVM에서 실행을 마무리 할 수 있도록 해준다.
		MainFrame.getInstance().setSize(Data.PROGRAM_WIDTH,Data.PROGRAM_HEIGHT);
		//Data에서 지정해놓은 프레임 사이즈에 맞게 크기를 정해준다.
		MainFrame.getInstance().setVisible(true);	
		//MainFrame을 보여준다.	
	}
}
