   import javax.swing.*;
   import java.awt.*;
   import java.awt.event.*;

   import javax.swing.ImageIcon;
   public class Host extends JPanel
   {
      public static JLabel faceLabel = new JLabel("");
      public static ImageIcon face1 = new ImageIcon("Howie1.png");
      public static ImageIcon face2 = new ImageIcon("Howie2.png");
      public static ImageIcon face3 = new ImageIcon("Howie3.png");
      public static ImageIcon face4 = new ImageIcon("Howie4.png");
      public static ImageIcon face5 = new ImageIcon("Howie5.png");
      public static ImageIcon caller1 = new ImageIcon("banker1.png");
      public static ImageIcon caller2 = new ImageIcon("banker2.png");
   // I provide the images and label to be static so that it can be changed through
   // the briefcase action listener
   
   
      public Host()
      {
         setLayout(new FlowLayout());
         
         ImageIcon face1 = new ImageIcon("Howie1.png");
         faceLabel.setIcon(face1);
         add(faceLabel);
      
      }
   }
