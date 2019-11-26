package Frame;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;


public class SetupPanel extends JPanel{
	
	private String[] pointSize= new String[100];
	private JComboBox textSizeList;
	
	private String[] LineSize= new String[20];
	private JComboBox LineSizeList;
	
	private String[] fontStyeSize= {"PLAIN","BOLD","ITALIC","ROMAN_BASELINE","CENTER_BASELINE","HANGING_BASELINE"};
	private int[] fontStyeSizeContant= {Font.PLAIN,Font.BOLD,Font.ITALIC,Font.ROMAN_BASELINE,Font.CENTER_BASELINE,Font.HANGING_BASELINE};
	private JComboBox fontStyeList;
	
	public SetupPanel()
	{
		Color background = new Color(210,210,210);
		this.setLayout(new GridLayout(50, 1, 1, 1));
		this.setBackground(background);
		
		add(new JLabel(""));
		
		for(int i=0;i<100;i++)
		{
			pointSize[i]=""+(i+1);
		}
		textSizeList=new JComboBox<String>(pointSize);
		textSizeList.setEditable(false);
		textSizeList.setBackground(Color.WHITE);
		textSizeList.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				int setSize=textSizeList.getSelectedIndex()+1;
				Data.setTextSize(setSize);
			}
		});
		add(new JLabel("글자 크기"));
		add(new JLabel("  "));
		add(textSizeList);

		
		add(new JLabel("             "));
		
		for(int i=0;i<20;i++)
		{
			LineSize[i]=""+(i+1);
		}
		LineSizeList=new JComboBox<String>(pointSize);
		LineSizeList.setEditable(false);
		LineSizeList.setBackground(Color.WHITE);
		LineSizeList.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				int setSize=LineSizeList.getSelectedIndex()+1;
				Data.setLineSize(setSize);
			}
		});
		add(new JLabel("선/지우개 크기"));
		add(new JLabel("  "));
		add(LineSizeList);
		
		
		

		add(new JLabel("             "));
		fontStyeList=new JComboBox<String>(fontStyeSize);
		fontStyeList.setEditable(false);
		fontStyeList.setBackground(Color.WHITE);
		fontStyeList.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				int setFont=fontStyeSizeContant[fontStyeList.getSelectedIndex()];
				Data.setTextStyle(setFont);
			}
		});
		add(new JLabel("Font Style"));
		add(new JLabel("  "));
		add(fontStyeList);
		
		setVisible(true);
		
	}
	


}
