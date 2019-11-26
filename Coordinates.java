package Frame;

import java.awt.Color;

import javax.swing.JLabel;

public class Coordinates extends JLabel{
   
   public Coordinates(String name)
   {
      super(name);
      setBackground(Color.WHITE); // 배경을 흰색으로 설정한다.
      setVisible(true); // 보여라.
   }

}