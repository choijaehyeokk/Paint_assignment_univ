package Frame;

import java.awt.Color;
import java.awt.Cursor;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.Point;
import java.awt.Toolkit;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.io.Serializable;
import java.util.Stack;
import java.util.Vector;

import javax.swing.JOptionPane;
import javax.swing.JPanel;

import figure.Circle;
import figure.Eraser;
import figure.Figure;
import figure.Line;
import figure.Pen;
import figure.Rectangle;
import figure.Text;
import figure.Triangle;
import figure.FillCircle;
import figure.FillRect;
import figure.FillTriangle;
import figure.Images;

public class DrawPanel extends JPanel implements MouseMotionListener, MouseListener, Serializable{
	
	private Vector<Figure> figureSet = new Vector<Figure>();
	//Vertor는 리스트로 figureSet이라는 Vector에다가 차곡차곡 Figure객체를 넣는다.
	private Stack<Vector<Figure>> figureStack = new Stack<Vector<Figure>>();
	//Figure객체를 담는 벡터인데 이벡터를 Stack이라는 구조로, push pop 을 이용해서 원소를 다룰 수 있다.
	private Stack<Vector<Figure>> figureCancelStack = new Stack<Vector<Figure>>();
	//
	private int dragStartX,dragStartY;
	
	public DrawPanel()
	{
		Data.setCurrentpanel(this);
		this.setBackground(new Color(255,255,255));
		setVisible(true);
		this.addMouseMotionListener(this);
		this.addMouseListener(this);
	}
	public void paintComponent(Graphics g)
	{	
		Graphics2D g2 = (Graphics2D)g;
		super.paintComponent(g2);
	
		for(Figure current:figureSet)
		{
			current.draw(g2);
		}
	}
	//현재 도형까지 figureSet에 있는 도형을 하나하나 그림을 다시그려서 업데이트를 한다.

	public void mouseDragged(MouseEvent e) {
		MainFrame.getInstance().setBottomLabel("X : "+e.getX()+" Y : "+e.getY());	
		
		if(Data.getCurrentMode()==Data.MODE_MOVE)
		{	
			if( Data.getCurrentFigure()!=null)
			{
				int moveX=e.getX()-dragStartX;
				int moveY=e.getY()-dragStartY;
				Data.getCurrentFigure().moveTo(moveX, moveY);
				dragStartX=e.getX();
				dragStartY=e.getY();
				repaint();
			}
		//현재 모드를 받아와서 MOVE라면 dragStartX,Y를 이용하여 얼마만큼 움직였는지를 moveX,Y에 저장하고 이를 moveTo함수에 인자로 전달하여 도형이 이동한 X,Y좌표를 저장한다.	
			
		}
		else if(Data.getCurrentMode()==Data.MODE_PAINT)
		{
		}
		
		else if(Data.getCurrentMode()==Data.MODE_RESIZE)
		{
			if(Data.getCurrentFigure()!=null)
			{
				
				Data.getCurrentFigure().calc(e.getX(), e.getY());
				repaint();
			}
		}
		//현재 모드가 RESIZE라면 Figure클래스의 calcFigure를 호출하여 마우스의 좌표를 통해 도형의 너비와 높이를 조정한다.
		else
		{
			Figure current = figureSet.lastElement();
			drawCurrentFigureFunc(e, current);
		}
		//MOVE,PAINT,RESIZE 가 아닐때는 drawCurrentFigureFunc()를 호출하여 현재 그리고 있는 도형이 드래그 하고 있는 마우스 좌표에 따라 변하는 모습을 보여주게 한다.
	}


	@Override
	public void mouseMoved(MouseEvent e) {
		MainFrame.getInstance().setBottomLabel("X : "+e.getX()+" Y : "+e.getY());	
	}


	@Override
	public void mouseClicked(MouseEvent e) {
		Data.setCurrentpanel(this);
		LayerFrame.getInstance().setListItems(figureSet);
		//마우스가 클릭되는 순간에 현재 figureSet LayerFrame에 전달하여 리스트를 set한다.
		if(Data.getCurrentMode()==Data.MODE_MOVE)
		{	
			if(Data.getCurrentFigure()!=null)
			{	
				dragStartX=e.getX();
				dragStartY=e.getY();
			}
			else
			{
				JOptionPane.showMessageDialog(null,"도형을 찾을 수 없습니다.","ERROR",JOptionPane.ERROR_MESSAGE);
			}
			
		}
		//현재 모드가 MOVE일 때 dragStartX,Y에 움직이기 시작하는 좌표 값을 저장한다.
		else if(Data.getCurrentMode()==Data.MODE_PAINT)
		{
			
			if(Data.getCurrentFigure()!=null)
			{	
				Data.getCurrentFigure().setColor(Data.getCurrentColor());
				repaint();
			}
			else
			{
				JOptionPane.showMessageDialog(null,"도형을 찾을 수 없습니다.","ERROR",JOptionPane.ERROR_MESSAGE);
			}
			
		}
		//현재 모드가 PAINT일 때 Information클래스를 통해 현재 색깔을 불러와서 색깔을 설정 한 후, repaint 한다.
	}


	@Override
	public void mouseEntered(MouseEvent e) {
	}


	@Override
	public void mouseExited(MouseEvent e) {
		MainFrame.getInstance().setBottomLabel("프레임을 벗어났습니다.");
	}
	//마우스가 프레임에 밖에 있다는 것을 표현해준다.


	@Override
	public void mousePressed(MouseEvent e) {
		Data.setCurrentpanel(this);
	
		if(Data.getCurrentMode()==Data.MODE_MOVE)
		{	
			if(Data.getCurrentFigure()!=null)
			{	
				dragStartX=e.getX();
				dragStartY=e.getY();
			}
			else
			{
				JOptionPane.showMessageDialog(null,"도형을 찾을 수 없습니다.","ERROR",JOptionPane.ERROR_MESSAGE);
			}
			
		}
		else if(Data.getCurrentMode()==Data.MODE_PAINT)
		{
			
			if(Data.getCurrentFigure()!=null)
			{	
				Data.getCurrentFigure().setColor(Data.getCurrentColor());
				repaint();
			}
			else
			{
				JOptionPane.showMessageDialog(null,"도형을 찾을 수 없습니다.","ERROR",JOptionPane.ERROR_MESSAGE);
			}			
		}
		else
		{
			drawFigureFunc(e);
		}
		//MOVE와 PAINT가 아닐때는 drawFigureFunc()함수를 호출한다.
	}


	@Override
	public void mouseReleased(MouseEvent e) {
		LayerFrame.getInstance().setListItems(figureSet);
		
		figureStack.push((Vector<Figure>)figureSet.clone());
		//figureStack에 현재 figureSet을 쌓는다.(clone으로 복사체를 똑같이 담는다.)
		
		figureCancelStack.clear();
	}
	//LayerFrame에 새로 도형이 추가된 figureSet으로 업데이트 하여 리스트에 도형이 추가되게 한다.
	//
	
	
	
	private void drawFigureFunc(MouseEvent e)
	{
		int mode=Data.getCurrentMode();
		switch(mode)
		{
		case Data.MODE_PEN: 
			Pen pens = new Pen(e.getX(),e.getY());
			figureSet.addElement(pens);
			break;
		case Data.MODE_DRAW_REC: 
			Rectangle rec = new Rectangle(e.getX(),e.getY(),0,0);
			figureSet.addElement(rec);
			break;
		case Data.MODE_DRAW_CIRCLE:
			Circle circle = new Circle(e.getX(),e.getY(),0,0);
			figureSet.addElement(circle);
			break;
		case Data.MODE_DRAW_FILLREC: 
			FillRect rec2 = new FillRect(e.getX(),e.getY(),0,0);
			figureSet.addElement(rec2);
			break;
		case Data.MODE_DRAW_FILLCIRCLE:
			FillCircle circle2 = new FillCircle(e.getX(),e.getY(),0,0);
			figureSet.addElement(circle2);
			break;
		case Data.MODE_DRAW_LINE:
			Line line = new Line(e.getX(),e.getY(),e.getX(),e.getY());
			figureSet.addElement(line);
			break;
		case Data.MODE_DRAW_TRIANGLE:
			Triangle triangle = new Triangle(e.getX(),e.getY());
			figureSet.addElement(triangle);
			break;
		case Data.MODE_DRAW_FILLTRIANGLE:
			FillTriangle triangle2 = new FillTriangle(e.getX(),e.getY());
			figureSet.addElement(triangle2);
			break;
		case Data.MODE_ERASE:
			Eraser eraser = new Eraser(e.getX(),e.getY());
			figureSet.addElement(eraser);
			break;
		case Data.MODE_IMAGE:
	         Images image = new Images(e.getX(),e.getY(), 0, 0);
	         figureSet.addElement(image);
			break;
		case Data.MODE_TEXT:
			String textData=null;
			if(textData==null || textData.equals("")) textData=JOptionPane.showInputDialog(null,"텍스트를 입력해주세요.",JOptionPane.OK_OPTION);
			if(textData==null || textData.equals("")) return;
			
			Text text = new Text(e.getX(),e.getY(),textData);
			figureSet.addElement(text);
			LayerFrame.getInstance().setListItems(figureSet);
			break;
		default : return;
		}
		repaint();
	}
	//현재 모드가 어떤 모드인지에 따라서 각각클래스의 객체를 선택하여 각 클래스의 객체를 만들어서 figureSet에 Vector의 addElement메서드를 통해서 Vector에 객체를 하나씩 저장한다.
	

	public void drawCurrentFigureFunc(MouseEvent e, Figure temp)
	{
		temp.calc(e.getX(), e.getY());
		repaint();
	}
	//인자로 전달받은 temp객체를 calcFigure를 이용하여 마우스 좌표에 따라 값을 바꾼 후 repaint한다
	//MouseDragged에서 이 매써드를 사용하여 마우스의 좌표에 따라 도형의 모습이 변하는 모습을 표현할 수 있게 한다.

	public void changeVector(Vector<Figure> vector)
	{
		figureSet=vector;
	}
	//인자로 전달 받은 vector를 현재 figureSet에 덮어 씌운다
	public Vector<Figure> getVector()
	{
		return figureSet;
	}
	//figure를 담은 벡터를 get해서 얻을 수 있다.
	public void addVector(Vector<Figure> vector)
	{
		figureSet.addAll(vector);
		LayerFrame.getInstance().setListItems(figureSet);
		
		figureStack.push((Vector<Figure>)figureSet.clone());	
		figureCancelStack.clear();
		repaint();
	}
	//인자로 전달 받은 vector를 현재 figureSet에 덮어 씌운다	
	public void addVector(Figure addData)
	{
		figureSet.add((Figure) addData.clone());
		
		LayerFrame.getInstance().setListItems(figureSet);
		figureStack.push((Vector<Figure>)figureSet.clone());	
		figureCancelStack.clear();
		repaint();
	}
	//figureSet에 인자로 전달받은 객체 하나를 붙여넣고 LayerFrame에 마찬가지로 업데이트 한다.
	public void  clearFigure()
	{
		figureSet.clear();
		figureStack.clear();
		figureCancelStack.clear();
		LayerFrame.getInstance().setListItems(figureSet);
		repaint();
	}
	//figureSet, figureStack, figureCancelStack을 clear메서드를 통해 비우고 LayerFrame에 모두 없어진 상태를 업데이트 한다.
	public void deleteFigure(int index)
	{
		figureCancelStack.clear();
		figureSet.remove(index);
	
		LayerFrame.getInstance().setListItems(figureSet);
		repaint();
	}
	//figureStack에 저장한 후 인덱스의 figureSet값을 지운다.
	public void CopyFigure(Figure figure)
	   {
	      if(figureStack.isEmpty())
	      {
	         JOptionPane.showMessageDialog(null,"도형을 찾을 수 없습니다.","ERROR",JOptionPane.ERROR_MESSAGE);
	         return;
	      }
	      else
	      {   
	    	 figureStack.push((Vector<Figure>)figureSet.clone());
	         figureSet.add(figure.clone());
	         
	         LayerFrame.getInstance().setListItems(figureSet);
	         repaint();
	      }      
	   }
	//인자로받은  figure객체를 통해서 figureSet Stack에 복사체를 push하고, figureSet에 복사체를 add한다. 그래서 복사를 할수 있게 LayerFrame에 업데이트 한다. 
}
