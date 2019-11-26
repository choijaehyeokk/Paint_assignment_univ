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
	//String�� ����ִ� list�� �����Ѵ�.
	private DefaultListModel<String> listModel;
	private int selectedIndex=0;
	static LayerFrame instance;
	int currentFigureCnt=0;
	//���� ������ ��ȣ�� �������ش�.
	
	public LayerFrame()
	{
		super("",true,false,false,true);
		
		listModel = new DefaultListModel<>();
		//listModel ��ü�� �����Ѵ�.
        stackList = new JList<>(listModel);
        stackList.addListSelectionListener(this);
        //stackList�� �����ҽ� ��� �����ߴ��� Listener�� �߻��Ѵ�.
        JScrollPane listScrollPane = new JScrollPane(stackList);
        //scrollPane�� �����.
        this.getContentPane().add(listScrollPane,BorderLayout.NORTH);

        JButton frontButton = new JButton("����");
        //�����ư�� �����.
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
        //���� �г��� ��г����� Data�� ���ؼ� �˷��ְ� ���г��� ������ Figure�� ������ �� �ְ����ش�.
        
        //���� ��ư�� �����.
        JButton DelButton = new JButton("����");
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
        //deleteFigure�� ���ؼ� ���õ� index�� Figure�� �����ϰ� index�� �ٿ��ش�.
      
        JButton clearButton = new JButton("���α׸���");
        //���α׸� ��ư�� ������ش�.
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
        //���� �г��� clearFigure()�޼��带 ���ؼ� ���� �����ش�.
        
        JPanel bottomPanel = new JPanel();

        bottomPanel.add(DelButton);
        bottomPanel.add(frontButton);
        bottomPanel.add(clearButton);
        
        this.getContentPane().add(bottomPanel, BorderLayout.SOUTH);
        
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setTitle("<���̾�>");      
        this.setVisible(true);
		//��ư���� �޾��ְ� �̸��� ������ �� �ְ� ���ش�. 
		
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
	//����Ʈ�� ������ ������ � �������� index�� �ٲ��ָ鼭 ���� �� �� �ְ� ���ش�.
	
	public void setListItems(Vector<Figure> dataSet)
	{
		listModel.clear();	
		for(int i= dataSet.size()-1;i>=0;i--)
		{
			listModel.addElement(dataSet.get(i).toString());			
		}
		
		currentFigureCnt=dataSet.size();
	}
	//����Ʈ�� �߰��ϴ� �����̶�� ���� �Ź� �߰��� figureset�� �����ͼ� ��°�� �ٲ�ġ���� ȭ�鿡 ����ϴ� ����̴�.
	
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
