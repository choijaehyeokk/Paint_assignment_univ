package Frame;

import java.awt.*;
import java.awt.Color;
import java.awt.GridLayout;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;
import javax.swing.BoxLayout;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JFrame; // 팔레트 선택 ↓
import javax.swing.JLabel;
import javax.swing.JColorChooser;
import javax.swing.colorchooser.ColorSelectionModel;
import javax.swing.event.ChangeListener;
import javax.swing.event.ChangeEvent;

import figure.Figure;

public class ToolPanel extends JPanel implements ActionListener{
	private ImageIcon ic_Choose1, ic_Paint1, ic_Pen1, ic_Line1, ic_era1, ic_Text1, ic_Resize1; // LeftPanel의 이미지 아이콘. (선택 전) ↓
	   private ImageIcon ic_Circle1, ic_Rec1, ic_Triangle1, ic_FillCircle1, ic_FillRec1, ic_FillTriangle1;
	   private ImageIcon ic_Choose2, ic_Paint2, ic_Pen2, ic_Line2, ic_era2, ic_Text2, ic_Resize2; // LeftPanel의 이미지 아이콘. (마우스 올릴때, 선택될 때) ↓
	   private ImageIcon ic_Circle2, ic_Rec2, ic_Triangle2, ic_FillCircle2, ic_FillRec2, ic_FillTriangle2;
	   private JButton button_Choose, button_Paint, button_Pen, button_Circle,  button_FillCircle, button_FillRec, button_FillTriangle; // LeftPanel의 버튼. ↓
	   private JButton button_Line, button_Rec, button_Triangle, button_Eraser, button_Text, button_Resize, button_Palette;
	   private JButton temp;
	   private JPanel choosePanel;
	   
	   public ToolPanel()
	   {
	      Color background = new Color(210,210,210); // background = 연회색 RGB(234, 234, 234)
	      this.setBackground(background); // LeftPanel 배경을 background 색으로 지정.
	      this.setLayout(new GridLayout(1, 15, 5, 5)); // ㅇㅇ.setVgap(숫자) : 격자 사이의 수직 간격을 설정.
	      
	      //this.setLayout(new BoxLayout(this,BoxLayout.Y_AXIS)); // BoxLayout : 행이나 열 방향으로 일렬로 배치하는 layout.
	   
	      
	      // 이미지 아이콘(png) 만들기.
	      ic_Choose1 = new ImageIcon("resource/select(1).png");
	      ic_Choose2 = new ImageIcon("resource/select(2).png");
	      ic_Resize1 = new ImageIcon("resource/resize(1).png");
	      ic_Resize2 = new ImageIcon("resource/resize(2).png");
	      ic_Paint1 = new ImageIcon("resource/Paint(1).png");
	      ic_Paint2 = new ImageIcon("resource/Paint(2).png");
	      ic_Pen1 = new ImageIcon("resource/pen(1).png");
	      ic_Pen2 = new ImageIcon("resource/pen(2).png");
	      ic_Circle1 = new ImageIcon("resource/circle(1).png");
	      ic_Circle2 = new ImageIcon("resource/circle(2).png");
	      ic_Line1 = new ImageIcon("resource/line(1).png");
	      ic_Line2 = new ImageIcon("resource/line(2).png");
	      ic_Rec1 = new ImageIcon("resource/rec(1).png");
	      ic_Rec2 = new ImageIcon("resource/rec(2).png");
	      ic_Triangle1 = new ImageIcon("resource/triangle(1).png");
	      ic_Triangle2 = new ImageIcon("resource/triangle(2).png");
	      ic_era1 = new ImageIcon("resource/Eraser(1).png");
	      ic_era2 = new ImageIcon("resource/Eraser(2).png");
	      ic_Text1 = new ImageIcon("resource/text(1).png");
	      ic_Text2 = new ImageIcon("resource/text(2).png");
	      ic_FillTriangle1 = new ImageIcon("resource/filltriangle(1).png");
	       ic_FillTriangle2 = new ImageIcon("resource/filltriangle(2).png");
	       ic_FillRec1 = new ImageIcon("resource/fillrec(1).png");
	       ic_FillRec2 = new ImageIcon("resource/fillrec(2).png");
	       ic_FillCircle1 = new ImageIcon("resource/fillcircle(1).png");
	       ic_FillCircle2 = new ImageIcon("resource/fillcircle(2).png");
	      
	      
	      // 버튼 만들기   setRolloverIcon(), setToolTipText()사용.
	      button_Choose = new JButton(ic_Choose1); button_Choose.setRolloverIcon(ic_Choose2); button_Choose.setToolTipText("움직이기");
	      button_Resize = new JButton(ic_Resize1); button_Resize.setRolloverIcon(ic_Resize2); button_Resize.setToolTipText("크기 변경하기");
	      button_Paint = new JButton(ic_Paint1); button_Paint.setRolloverIcon(ic_Paint2); button_Paint.setToolTipText("채우기");
	      button_Pen = new JButton(ic_Pen1); button_Pen.setRolloverIcon(ic_Pen2); button_Pen.setToolTipText("그리기");
	      button_Circle = new JButton(ic_Circle1); button_Circle.setRolloverIcon(ic_Circle2); button_Circle.setToolTipText("빈 원 그리기");
	      button_FillCircle = new JButton(ic_FillCircle1); button_FillCircle.setRolloverIcon(ic_FillCircle2); button_FillCircle.setToolTipText("채운 원 그리기");
	      button_Line = new JButton(ic_Line1); button_Line.setRolloverIcon(ic_Line2); button_Line.setToolTipText("선 그리기");
	      button_Rec = new JButton(ic_Rec1); button_Rec.setRolloverIcon(ic_Rec2); button_Rec.setToolTipText("빈 사각형 그리기");
	      button_FillRec = new JButton(ic_FillRec1); button_FillRec.setRolloverIcon(ic_FillRec2); button_FillRec.setToolTipText("채운 사각형 그리기");
	      button_Triangle = new JButton(ic_Triangle1); button_Triangle.setRolloverIcon(ic_Triangle2); button_Triangle.setToolTipText("빈 삼각형 그리기");
	      button_FillTriangle = new JButton(ic_FillTriangle1); button_FillTriangle.setRolloverIcon(ic_FillTriangle2); button_FillTriangle.setToolTipText("채운 삼각형 그리기");
	      button_Eraser = new JButton(ic_era1); button_Eraser.setRolloverIcon(ic_era2); button_Eraser.setToolTipText("지우기");
	      button_Text= new JButton(ic_Text1);   button_Text.setRolloverIcon(ic_Text2); button_Text.setToolTipText("텍스트 입력하기");

	       button_Palette = new JButton();
	        // button_pastecopy = new JButton("복사 붙여넣기");
	      
	      button_Palette = new JButton(); button_Palette.setToolTipText("색 바꾸기");
	      
	      
	      // 버튼 설정하기
	      // ** setSize는 굳이 필요하지 않은것같음!
	      // setBorderPainted(false) : 버튼의 윤곽선을 없애준다.
	      // setFocusPainted(true) : 버튼이 선택되었을 때 테두리를 생기게 한다.
	      button_Choose.setName("choose"); button_Choose.setBackground(background);  button_Choose.setBorderPainted(false); button_Choose.setFocusPainted(true);
	      button_Resize.setName("resize"); button_Resize.setBackground(background);  button_Resize.setBorderPainted(false); button_Resize.setFocusPainted(true);
	      button_Paint.setName("paint"); button_Paint.setBackground(background);  button_Paint.setBorderPainted(false); button_Paint.setFocusPainted(true);
	      button_Pen.setName("pen"); button_Pen.setBackground(background);  button_Pen.setBorderPainted(false); button_Pen.setFocusPainted(true);
	      button_Circle.setName("circle"); button_Circle.setBackground(background);  button_Circle.setBorderPainted(false); button_Circle.setFocusPainted(true);
	      button_Line.setName("line"); button_Line.setBackground(background);  button_Line.setBorderPainted(false); button_Line.setFocusPainted(true);
	      button_Rec.setName("rec"); button_Rec.setBackground(background);  button_Rec.setBorderPainted(false); button_Rec.setFocusPainted(true);
	      button_Triangle.setName("triangle"); button_Triangle.setBackground(background);  button_Triangle.setBorderPainted(false); button_Triangle.setFocusPainted(true);
	      button_Eraser.setName("era"); button_Eraser.setBackground(background);  button_Eraser.setBorderPainted(false); button_Eraser.setFocusPainted(true);
	      button_Text.setName("text"); button_Text.setBackground(background);  button_Text.setBorderPainted(false); button_Text.setFocusPainted(true);
	      button_FillCircle.setName("FillCircle"); button_FillCircle.setBackground(background); button_FillCircle.setBorderPainted(false); button_FillCircle.setFocusPainted(true);
	      button_FillRec.setName("FillRec"); button_FillRec.setBackground(background); button_FillRec.setBorderPainted(false); button_FillRec.setFocusPainted(true);
	      button_FillTriangle.setName("FillTriangle"); button_FillTriangle.setBackground(background); button_FillTriangle.setBorderPainted(false); button_FillTriangle.setFocusPainted(true);
	      button_Palette.setName("palette"); button_Palette.setBackground(Color.BLACK); button_Palette.setBorderPainted(true); button_Palette.setFocusPainted(false);
	      
	      button_Choose.addActionListener(this);
	      button_Resize.addActionListener(this);
	      button_Paint.addActionListener(this);
	      button_Pen.addActionListener(this);
	      button_Circle.addActionListener(this);
	      button_Line.addActionListener(this);
	      button_Rec.addActionListener(this);
	      button_Triangle.addActionListener(this);
	      button_Eraser.addActionListener(this);
	      button_Text.addActionListener(this);
	      
	      button_FillCircle.addActionListener(this);
	      button_FillRec.addActionListener(this);
	      button_FillTriangle.addActionListener(this);      
	      button_Palette.addActionListener(this);

	      
	      // 버튼 추가하기.
	      this.add(button_Choose);
	      this.add(button_Resize);
	      this.add(button_Paint);
	      this.add(button_Pen);
	      this.add(button_Line);
	      this.add(button_Circle);
	      this.add(button_FillCircle);
	      this.add(button_Rec);
	      this.add(button_FillRec);
	      this.add(button_Triangle);
	      this.add(button_FillTriangle);
	      this.add(button_Eraser);
	      this.add(button_Text);
	       //this.add(button_pastecopy);
	      
	      choosePanel = new JPanel();
	      
	      temp = new JButton();
	      button_Palette.setBorderPainted(false);       
	      
	      
	      button_Palette.addActionListener(new ActionListener(){
	         @Override
	         public void actionPerformed(ActionEvent e) {
	         // TODO Auto-generated method stub
	            JButton current = (JButton)e.getSource(); // current == 현재 눌린 버튼.
	            
	            Color selectedColor;
	            JColorChooser chooser = new JColorChooser(); // JColorChooser 클래스객체화
	            
	            GridLayout colorLayout = new GridLayout(4,1); // GridLayout : 각종 UI들을 임의의 열과 행으로 똑같이 나누어 배치하는 layout
	            
	            choosePanel.setLayout(colorLayout);
	            selectedColor = chooser.showDialog(null, "Color", Color.BLACK); // 눌렀을 때 초기값은 BLACK.
	            button_Palette.setBackground(selectedColor);
	            
	            Data.setCurrentColor(selectedColor.getRed(), selectedColor.getGreen(), selectedColor.getBlue()); // Information의 setCurrentColor에 색 값 전달.
	            MainFrame.getInstance().setBottomLabel(selectedColor);
	            temp.setBackground(selectedColor);
	         }
	      
	      });
	      choosePanel.add(button_Palette);
	      this.add(button_Palette);
	}


	   @Override
	   public void actionPerformed(ActionEvent e) {
	      // TODO Auto-generated method stub
	      JButton currentButton = (JButton)e.getSource();
	      
	      switch(currentButton.getName())
	      {
	      case "choose" :
	         Data.setCurrentMode(Data.MODE_MOVE);
	         button_Choose.setIcon(ic_Choose2);   /////
	         button_Resize.setIcon(ic_Resize1);
	         button_Paint.setIcon(ic_Paint1);
	         button_Pen.setIcon(ic_Pen1);
	         button_Eraser.setIcon(ic_era1);
	         button_Text.setIcon(ic_Text1);
	         button_Line.setIcon(ic_Line1);
	         button_Circle.setIcon(ic_Circle1);
	         button_Rec.setIcon(ic_Rec1);
	         button_Triangle.setIcon(ic_Triangle1);
	         button_FillCircle.setIcon(ic_FillCircle1);
	         button_FillRec.setIcon(ic_FillRec1);
	         button_FillTriangle.setIcon(ic_FillTriangle1);
	         break;
	      case "resize" :
	         Data.setCurrentMode(Data.MODE_RESIZE);
	         button_Choose.setIcon(ic_Choose1);
	         button_Resize.setIcon(ic_Resize2);    /////
	         button_Paint.setIcon(ic_Paint1);
	         button_Pen.setIcon(ic_Pen1);
	         button_Eraser.setIcon(ic_era1);
	         button_Text.setIcon(ic_Text1);
	         button_Line.setIcon(ic_Line1);
	         button_Circle.setIcon(ic_Circle1);
	         button_Rec.setIcon(ic_Rec1);
	         button_Triangle.setIcon(ic_Triangle1);
	         button_FillCircle.setIcon(ic_FillCircle1);
	         button_FillRec.setIcon(ic_FillRec1);
	         button_FillTriangle.setIcon(ic_FillTriangle1);
	         break;
	      case "paint" :
	         Data.setCurrentMode(Data.MODE_PAINT);
	         button_Choose.setIcon(ic_Choose1);
	         button_Resize.setIcon(ic_Resize1);
	         button_Paint.setIcon(ic_Paint2);     /////
	         button_Pen.setIcon(ic_Pen1);
	         button_Eraser.setIcon(ic_era1);
	         button_Text.setIcon(ic_Text1);
	         button_Line.setIcon(ic_Line1);
	         button_Circle.setIcon(ic_Circle1);
	         button_Rec.setIcon(ic_Rec1);
	         button_Triangle.setIcon(ic_Triangle1);
	         button_FillCircle.setIcon(ic_FillCircle1);
	         button_FillRec.setIcon(ic_FillRec1);
	         button_FillTriangle.setIcon(ic_FillTriangle1);
	         break;
	      case "pen" :
	         Data.setCurrentMode(Data.MODE_PEN);
	         button_Choose.setIcon(ic_Choose1);
	         button_Resize.setIcon(ic_Resize1);
	         button_Paint.setIcon(ic_Paint1);
	         button_Pen.setIcon(ic_Pen2);     /////
	         button_Eraser.setIcon(ic_era1);
	         button_Text.setIcon(ic_Text1);
	         button_Line.setIcon(ic_Line1);
	         button_Circle.setIcon(ic_Circle1);
	         button_Rec.setIcon(ic_Rec1);
	         button_Triangle.setIcon(ic_Triangle1);
	         button_FillCircle.setIcon(ic_FillCircle1);
	         button_FillRec.setIcon(ic_FillRec1);
	         button_FillTriangle.setIcon(ic_FillTriangle1);
	         break;
	      case "circle" :
	         Data.setCurrentMode(Data.MODE_DRAW_CIRCLE);
	         button_Choose.setIcon(ic_Choose1);
	         button_Resize.setIcon(ic_Resize1);
	         button_Paint.setIcon(ic_Paint1);
	         button_Pen.setIcon(ic_Pen1);
	         button_Eraser.setIcon(ic_era1);
	         button_Text.setIcon(ic_Text1);
	         button_Line.setIcon(ic_Line1);
	         button_Circle.setIcon(ic_Circle2);    /////
	         button_Rec.setIcon(ic_Rec1);
	         button_Triangle.setIcon(ic_Triangle1);
	         button_FillCircle.setIcon(ic_FillCircle1);
	         button_FillRec.setIcon(ic_FillRec1);
	         button_FillTriangle.setIcon(ic_FillTriangle1);
	         break;
	      case "line" :
	         Data.setCurrentMode(Data.MODE_DRAW_LINE);
	         button_Choose.setIcon(ic_Choose1);
	         button_Resize.setIcon(ic_Resize1);
	         button_Paint.setIcon(ic_Paint1);
	         button_Pen.setIcon(ic_Pen1);
	         button_Eraser.setIcon(ic_era1);
	         button_Text.setIcon(ic_Text1);
	         button_Line.setIcon(ic_Line2);   /////
	         button_Circle.setIcon(ic_Circle1);
	         button_Rec.setIcon(ic_Rec1);
	         button_Triangle.setIcon(ic_Triangle1);
	         button_FillCircle.setIcon(ic_FillCircle1);
	         button_FillRec.setIcon(ic_FillRec1);
	         button_FillTriangle.setIcon(ic_FillTriangle1);
	         break;
	      case "rec" :
	         Data.setCurrentMode(Data.MODE_DRAW_REC);
	         button_Choose.setIcon(ic_Choose1);
	         button_Resize.setIcon(ic_Resize1);
	         button_Paint.setIcon(ic_Paint1);
	         button_Pen.setIcon(ic_Pen1);
	         button_Eraser.setIcon(ic_era1);
	         button_Text.setIcon(ic_Text1);
	         button_Line.setIcon(ic_Line1);
	         button_Circle.setIcon(ic_Circle1);
	         button_Rec.setIcon(ic_Rec2);      /////
	         button_Triangle.setIcon(ic_Triangle1);
	         button_FillCircle.setIcon(ic_FillCircle1);
	         button_FillRec.setIcon(ic_FillRec1);
	         button_FillTriangle.setIcon(ic_FillTriangle1);
	         break;
	      case "triangle" :
	         Data.setCurrentMode(Data.MODE_DRAW_TRIANGLE);
	         button_Choose.setIcon(ic_Choose1);
	         button_Resize.setIcon(ic_Resize1);
	         button_Paint.setIcon(ic_Paint1);
	         button_Pen.setIcon(ic_Pen1);
	         button_Eraser.setIcon(ic_era1);
	         button_Text.setIcon(ic_Text1);
	         button_Line.setIcon(ic_Line1);
	         button_Circle.setIcon(ic_Circle1);
	         button_Rec.setIcon(ic_Rec1);
	         button_Triangle.setIcon(ic_Triangle2);   /////
	         button_FillCircle.setIcon(ic_FillCircle1);
	         button_FillRec.setIcon(ic_FillRec1);
	         button_FillTriangle.setIcon(ic_FillTriangle1);
	         break;
	      case "FillCircle" :
	         Data.setCurrentMode(Data.MODE_DRAW_FILLCIRCLE);
	         button_Choose.setIcon(ic_Choose1);
	         button_Resize.setIcon(ic_Resize1);
	         button_Paint.setIcon(ic_Paint1);
	         button_Pen.setIcon(ic_Pen1);
	         button_Eraser.setIcon(ic_era1);
	         button_Text.setIcon(ic_Text1);
	         button_Line.setIcon(ic_Line1);
	         button_Circle.setIcon(ic_Circle1);
	         button_Rec.setIcon(ic_Rec1);
	         button_Triangle.setIcon(ic_Triangle1);
	         button_FillCircle.setIcon(ic_FillCircle2);     /////
	         button_FillRec.setIcon(ic_FillRec1);
	         button_FillTriangle.setIcon(ic_FillTriangle1);
	         break;
	         case "FillRec" :
	            Data.setCurrentMode(Data.MODE_DRAW_FILLREC);
	            button_Choose.setIcon(ic_Choose1);
	         button_Resize.setIcon(ic_Resize1);
	         button_Paint.setIcon(ic_Paint1);
	         button_Pen.setIcon(ic_Pen1);
	         button_Eraser.setIcon(ic_era1);
	         button_Text.setIcon(ic_Text1);
	         button_Line.setIcon(ic_Line1);
	         button_Circle.setIcon(ic_Circle1);
	         button_Rec.setIcon(ic_Rec1);
	         button_Triangle.setIcon(ic_Triangle1);
	         button_FillCircle.setIcon(ic_FillCircle1);
	         button_FillRec.setIcon(ic_FillRec2);   /////
	         button_FillTriangle.setIcon(ic_FillTriangle1);
	            break;
	         case "FillTriangle" :
	            Data.setCurrentMode(Data.MODE_DRAW_FILLTRIANGLE);
	            button_Choose.setIcon(ic_Choose1);
	         button_Resize.setIcon(ic_Resize1);
	         button_Paint.setIcon(ic_Paint1);
	         button_Pen.setIcon(ic_Pen1);
	         button_Eraser.setIcon(ic_era1);
	         button_Text.setIcon(ic_Text1);
	         button_Line.setIcon(ic_Line1);
	         button_Circle.setIcon(ic_Circle1);
	         button_Rec.setIcon(ic_Rec1);
	         button_Triangle.setIcon(ic_Triangle1);
	         button_FillCircle.setIcon(ic_FillCircle1);
	         button_FillRec.setIcon(ic_FillRec1);
	         button_FillTriangle.setIcon(ic_FillTriangle2);   /////
	            break;
	      case "era" :
	         Data.setCurrentMode(Data.MODE_ERASE);
	         button_Choose.setIcon(ic_Choose1);
	         button_Resize.setIcon(ic_Resize1);
	         button_Paint.setIcon(ic_Paint1);
	         button_Pen.setIcon(ic_Pen1);
	         button_Eraser.setIcon(ic_era2);   /////
	         button_Text.setIcon(ic_Text1);
	         button_Line.setIcon(ic_Line1);
	         button_Circle.setIcon(ic_Circle1);
	         button_Rec.setIcon(ic_Rec1);
	         button_Triangle.setIcon(ic_Triangle1);
	         button_FillCircle.setIcon(ic_FillCircle1);
	         button_FillRec.setIcon(ic_FillRec1);
	         button_FillTriangle.setIcon(ic_FillTriangle1);
	         break;
	      case "text" :
	         Data.setCurrentMode(Data.MODE_TEXT);
	         button_Choose.setIcon(ic_Choose1);
	         button_Resize.setIcon(ic_Resize1);
	         button_Paint.setIcon(ic_Paint1);
	         button_Pen.setIcon(ic_Pen1);
	         button_Eraser.setIcon(ic_era1);
	         button_Text.setIcon(ic_Text2);   /////
	         button_Line.setIcon(ic_Line1);
	         button_Circle.setIcon(ic_Circle1);
	         button_Rec.setIcon(ic_Rec1);
	         button_Triangle.setIcon(ic_Triangle1);
	         button_FillCircle.setIcon(ic_FillCircle1);
	         button_FillRec.setIcon(ic_FillRec1);
	         button_FillTriangle.setIcon(ic_FillTriangle1);
	         break;
	      case "palette" :
	         Data.setCurrentMode(Data.MODE_PALETTE);
	         button_Choose.setIcon(ic_Choose1);
	         button_Resize.setIcon(ic_Resize1);
	         button_Paint.setIcon(ic_Paint1);
	         button_Pen.setIcon(ic_Pen1);
	         button_Eraser.setIcon(ic_era1);
	         button_Text.setIcon(ic_Text1);
	         button_Line.setIcon(ic_Line1);
	         button_Circle.setIcon(ic_Circle1);
	         button_Rec.setIcon(ic_Rec1);
	         button_Triangle.setIcon(ic_Triangle1);
	         button_FillCircle.setIcon(ic_FillCircle1);
	         button_FillRec.setIcon(ic_FillRec1);
	         button_FillTriangle.setIcon(ic_FillTriangle1);
	         break;

	      default : break;
	      }
	      
	      
	   }

}
