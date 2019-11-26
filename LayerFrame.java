package Frame;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Vector;

import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JInternalFrame;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

import figure.Figure;

public class LayerFrame extends JInternalFrame implements ListSelectionListener{
	
	private JList<String> stackList;
	//String을 담고있는 list를 선언한다.
	private DefaultListModel<String> listModel;
	private int selectedIndex=0;
	static LayerFrame instance;
	int currentFigureCnt=0;
	//현재 도형의 번호를 선언해준다.
	
	public LayerFrame()
	{
		super("",true,false,false,true);
		
		listModel = new DefaultListModel<>();
		//listModel 객체를 생성한다.
        stackList = new JList<>(listModel);
        stackList.addListSelectionListener(this);
        //stackList를 선택할시 어떤걸 선택했는지 Listener를 발생한다.
        JScrollPane listScrollPane = new JScrollPane(stackList);
        //scrollPane을 만든다.
        this.getContentPane().add(listScrollPane,BorderLayout.NORTH);

        JButton frontButton = new JButton("복사");
        //복사버튼을 만든다.
        frontButton.addActionListener(new ActionListener(){

         @Override
         public void actionPerformed(ActionEvent arg0) {
            // TODO Auto-generated method stub
            if(Data.getCurrentJPanel()!=null)
            {
                Data.getCurrentJPanel().CopyFigure(Data.getCurrentFigure());
            }
         }
           
        });
        //현재 패널이 어떤패널인지 Data를 통해서 알려주고 그패널의 도형인 Figure를 복사할 수 있게해준다.
        
        //삭제 버튼을 만든다.
        JButton DelButton = new JButton("삭제");
        DelButton.addActionListener(new ActionListener(){

			@Override
			public void actionPerformed(ActionEvent arg0) {
				// TODO Auto-generated method stub
				DrawPanel current = Data.getCurrentJPanel();
			
				if(current==null)
				{
					JOptionPane.showMessageDialog(null,"Error : Can't find current Jpanel","ERROR",JOptionPane.ERROR_MESSAGE);
				}
				else if(selectedIndex>Data.getCurrentJPanel().getVector().size()-1 || selectedIndex<0)
				{
					JOptionPane.showMessageDialog(null,"Error : Cant' find figure","ERROR",JOptionPane.ERROR_MESSAGE);
				}
				else
				{	
					current.deleteFigure(selectedIndex--);
				}
			}
        	
        });
        //deleteFigure를 통해서 선택된 index의 Figure를 삭제하고 index를 줄여준다.
      
        JButton clearButton = new JButton("새로그리기");
        //새로그릴 버튼을 만들어준다.
        clearButton.addActionListener(new ActionListener(){

			@Override
			public void actionPerformed(ActionEvent arg0) {
				DrawPanel current = Data.getCurrentJPanel();
				if(current!=null)
				{	
					current.clearFigure();
				}
				else
				{
					JOptionPane.showMessageDialog(null,"Error to find current Jpanel","ERROR",JOptionPane.ERROR_MESSAGE);
				}
			}
        	
        });
        //현재 패널을 clearFigure()메서드를 통해서 전부 지워준다.
        
        JPanel bottomPanel = new JPanel();

        bottomPanel.add(DelButton);
        bottomPanel.add(frontButton);
        bottomPanel.add(clearButton);
        
        this.getContentPane().add(bottomPanel, BorderLayout.SOUTH);
        
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setTitle("<레이어>");      
        this.setVisible(true);
		//버튼들을 달아주고 이름과 보여줄 수 있게 해준다. 
		
		setSize(300,250);
		setBackground(Color.DARK_GRAY);
		setVisible(true);	
	}

	@Override
	public void valueChanged(ListSelectionEvent e) {
		 for(int i=0;i<=e.getLastIndex();i++)
		 {
			 if(stackList.isSelectedIndex(i))
			 {
				 selectedIndex = currentFigureCnt-i-1;
				 Data.setCurrentFigure(Data.getCurrentJPanel().getVector().get(selectedIndex));
				 break;
			 }
			 
		 }	 
	}
	//리스트를 선택할 때마다 어떤 도형인지 index를 바꿔주면서 선택 할 수 있게 해준다.
	
	public void setListItems(Vector<Figure> dataSet)
	{
		listModel.clear();	
		for(int i= dataSet.size()-1;i>=0;i--)
		{
			listModel.addElement(dataSet.get(i).toString());			
		}
		
		currentFigureCnt=dataSet.size();
	}
	//리스트에 추가하는 형식이라기 보다 매번 추가된 figureset을 가져와서 통째로 바꿔치기해 화면에 출력하는 방식이다.
	
	public int getCurrentFigureIndex()
	{
		return selectedIndex;
	}

	public static LayerFrame getInstance()
	{
		if(instance==null) 
		{
			instance = new LayerFrame();
		}
		
		return instance;
	}
}
