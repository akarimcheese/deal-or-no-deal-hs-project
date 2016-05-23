   import javax.swing.JFrame;
   public class Driver00
   {
      public static void main(String[] args)
      {
         JFrame frame = new JFrame();
         frame.setSize(650,400);
         frame.setLocation(100,100);
         frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
         frame.setContentPane(new KarimGUIProject());
         frame.setVisible(true);
      }
   }