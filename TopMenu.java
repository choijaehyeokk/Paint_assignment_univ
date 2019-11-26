package Frame;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FileDialog;
import java.awt.FlowLayout;
import java.awt.Frame;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.ScrollPane;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import javax.imageio.ImageIO;
import javax.swing.JDialog;

import javax.swing.JFileChooser;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.KeyStroke;

import Frame.CusorPanel;

import javax.swing.ImageIcon;

import figure.Images;

public class TopMenu extends JMenuBar{
   
   private JMenu fileMenu;
   private JMenuItem open,save,close;
   private JMenu menu2;
   private JMenuItem image1, image2, image3, image4, image5, image6, image7, image8, image9, image10, image11, image12;
   private DrawPanel pane;
   private JScrollPane scrollPane;
   private Images a;
   private Toolkit winTool;
   public Images getA() {
      return a;
   }

   public void setA(Images a) {
      this.a = a;
   }

   public TopMenu()
   {
      this.setBackground(Color.WHITE);
      
      fileMenu = new JMenu("파일");
      
         
       ImageIcon openfile = new ImageIcon("resource/openfile.png");
       open = new JMenuItem("Open File", openfile); // open 메뉴?��?��?�� ?��?�� �? ?��미�? ?���?.
       open.setMnemonic('O');
       open.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_O, ActionEvent.CTRL_MASK)); // ?��축기 ?��?��. Ctrl + O ?��르면 ?��?��.
         
       ImageIcon savefile = new ImageIcon("resource/savefile.png");
       save = new JMenuItem("Save File", savefile); // save 메뉴?��?��?�� ?��?�� �? ?��미�? ?���?.
       save.setMnemonic('S');
       save.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_S, ActionEvent.CTRL_MASK)); // ?��축기 ?��?��. Ctrl + S ?��르면 ?��?��.

      open.addActionListener(new ActionListener(){

         @Override
         public void actionPerformed(ActionEvent e) {
            JFileChooser jfilechooser = new JFileChooser();
            jfilechooser.setFileSelectionMode(JFileChooser.FILES_ONLY);
            int judge = jfilechooser.showOpenDialog(null);
            jfilechooser.setFileFilter(new javax.swing.filechooser.FileNameExtensionFilter("JPG & PNG Images", "jpg", "png"));
            
            switch(judge)
            {
               case JFileChooser.APPROVE_OPTION : 
                  Data.setFilePath(jfilechooser.getSelectedFile().getPath());
                  Data.setCurrentMode(Data.MODE_PEN);
                  Data.setCurrentImage(20);
                  Data.setCurrentMode(12);
                  //System.out.println(jfilechooser.getSelectedFile().getPath());
                  //System.out.println(Information.getFilePath());
                  break;
               case JFileChooser.CANCEL_OPTION :    
                  break;
            }
         }
      });
   

      
      save.addActionListener(new ActionListener(){
         @Override
         public void actionPerformed(ActionEvent e) {
                  JFileChooser jfilechooser = new JFileChooser();
                  int judge = jfilechooser.showSaveDialog(null);
               
                  switch(judge)
                  {
                     case JFileChooser.APPROVE_OPTION : 
                        String path =jfilechooser.getSelectedFile().getPath();
                        BufferedImage img = new BufferedImage(Data.getCurrentJPanel().getWidth(), Data.getCurrentJPanel().getHeight(), BufferedImage.TYPE_INT_RGB);
                        Graphics g = img.createGraphics();
                        Data.getCurrentJPanel().printAll(g);
                        g.dispose();
                        try {
                            ImageIO.write(img, "png", new File(path+".png"));
                        } catch (IOException ex) {
                            ex.printStackTrace();
                        }
                        
                        break;
                     case JFileChooser.CANCEL_OPTION : 
                        return;   
                  }
            }
               
            
         });
               
      
      ImageIcon closefile = new ImageIcon("resource/closefile.png");
       close = new JMenuItem("Close File", closefile);
       close.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_C, ActionEvent.CTRL_MASK)); 

      close.addActionListener(new ActionListener(){
         @Override
         public void actionPerformed(ActionEvent e) {
            // TODO Auto-generated method stub
            System.exit(0);
         }
         
      });
      
      fileMenu.add(open);
      fileMenu.add(save);
      fileMenu.add(close);
      this.add(fileMenu);
      //=================================================================================//
      menu2 = new JMenu("동물 이미지");
      
      ImageIcon icon1 = new ImageIcon("resource/이미지아이콘/쥐.png");
       image1 = new JMenuItem("쥐", icon1); 
       ImageIcon icon2 = new ImageIcon("resource/이미지아이콘/소.png");
       image2 = new JMenuItem("소", icon2);
       ImageIcon icon3 = new ImageIcon("resource/이미지아이콘/호랑이.png");
       image3 = new JMenuItem("호랑이", icon3); 
       ImageIcon icon4 = new ImageIcon("resource/이미지아이콘/토끼.png");
       image4 = new JMenuItem("토끼", icon4);
       ImageIcon icon5 = new ImageIcon("resource/이미지아이콘/용.png");
       image5 = new JMenuItem("용", icon5); 
       ImageIcon icon6 = new ImageIcon("resource/이미지아이콘/뱀.png");
       image6 = new JMenuItem("뱀", icon6);
       ImageIcon icon7 = new ImageIcon("resource/이미지아이콘/말.png");
       image7 = new JMenuItem("말", icon7);
       ImageIcon icon8 = new ImageIcon("resource/이미지아이콘/양.png");
       image8 = new JMenuItem("양", icon8);
       ImageIcon icon9 = new ImageIcon("resource/이미지아이콘/원숭이.png");
       image9 = new JMenuItem("원숭이", icon9);
       ImageIcon icon10 = new ImageIcon("resource/이미지아이콘/닭.png");
       image10 = new JMenuItem("닭", icon10);
       ImageIcon icon11 = new ImageIcon("resource/이미지아이콘/개.png");
       image11 = new JMenuItem("개", icon11);
       ImageIcon icon12 = new ImageIcon("resource/이미지아이콘/돼지.png");
       image12 = new JMenuItem("돼지", icon12);
      
      menu2.add(image1);
      menu2.add(image2);
      menu2.add(image3);
      menu2.add(image4);
      menu2.add(image5);
      menu2.add(image6);
      menu2.add(image7);
      menu2.add(image8);
      menu2.add(image9);
      menu2.add(image10);
      menu2.add(image11);
      menu2.add(image12);
      
      image1.addActionListener(new ActionListener()
      {         
         @Override
         public void actionPerformed(ActionEvent e)
         {
            
            Data.setCurrentImage(1);
            Data.setCurrentMode(12);
            
         }
      });
      image2.addActionListener(new ActionListener()
      {         
         @Override
         public void actionPerformed(ActionEvent e)
         {
         
            Data.setCurrentImage(2);
            Data.setCurrentMode(12);
            
         }
      });
      image3.addActionListener(new ActionListener()
      {         
         @Override
         public void actionPerformed(ActionEvent e)
         {
         
            Data.setCurrentImage(3);
            Data.setCurrentMode(12);
            
         }
      });
      image4.addActionListener(new ActionListener()
      {         
         @Override
         public void actionPerformed(ActionEvent e)
         {
            Data.setCurrentImage(4);
            Data.setCurrentMode(12);
         }
      });
      image5.addActionListener(new ActionListener()
      {         
         @Override
         public void actionPerformed(ActionEvent e)
         {
            Data.setCurrentImage(5);
            Data.setCurrentMode(12);
         }
      });
      image6.addActionListener(new ActionListener()
      {         
         @Override
         public void actionPerformed(ActionEvent e)
         {
            Data.setCurrentImage(6);
            Data.setCurrentMode(12);
         }
      });
      image7.addActionListener(new ActionListener()
      {         
         @Override
         public void actionPerformed(ActionEvent e)
         {
            Data.setCurrentImage(7);
            Data.setCurrentMode(12);
         }
      });
      image8.addActionListener(new ActionListener()
      {         
         @Override
         public void actionPerformed(ActionEvent e)
         {
            Data.setCurrentImage(8);
            Data.setCurrentMode(12);
            repaint();
         }
      });
      image9.addActionListener(new ActionListener()
         {      
            @Override
            public void actionPerformed(ActionEvent e)
            {
               Data.setCurrentMode(12);
               Data.setCurrentImage(9);
               
            }
         });
         
         image10.addActionListener(new ActionListener()
         {      
            @Override
            public void actionPerformed(ActionEvent e)
            {
               Data.setCurrentMode(12);
               Data.setCurrentImage(10);
               
            }
         });
         
         image11.addActionListener(new ActionListener()
         {      
            @Override
            public void actionPerformed(ActionEvent e)
            {
               Data.setCurrentMode(12);
               Data.setCurrentImage(11);
               
            }
         });
         
         image12.addActionListener(new ActionListener()
         {      
            @Override
            public void actionPerformed(ActionEvent e)
            {
               Data.setCurrentMode(12);
               Data.setCurrentImage(12);
               
            }
         });
      
      this.add(menu2);
   }
}