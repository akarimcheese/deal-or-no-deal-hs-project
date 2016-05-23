   import javax.swing.*;
   import java.awt.*;
   import java.awt.event.*;
   import javax.swing.JOptionPane; 
	
   public class KarimGUIProject extends JPanel
   {
      private Board singleBoard;
      private Host singleHost;
      private Briefcases[] cases = new Briefcases[26];
      private JButton nameButton;
      private JTextField nameEntry;
      private JPanel subpanel2;
      public static JLabel nameLabel;
   
   
   
   
      public KarimGUIProject()
      {
      
      
         setLayout(new BorderLayout());
         // Layout for KarimGUIProject Panel
      
         singleBoard = new Board();
      
         
         
      	// Initializing singleBoard
         add(singleBoard, BorderLayout.LINE_END);
         singleBoard.setColor();
         
      	// Initializing singleBoard to KarimGUIProject Panel
      	      
         JPanel subpanel1 = new JPanel();
         
      	// Initializing and declaring subpanel1
      	
      	
         subpanel1.setLayout(new GridLayout(0, 7, 1, 1));
         
      	// Layout for subpanel1
      	
      	// OHEY LOOK AT THAT WALL OF TEXT
      	
         double[] casevalue = new double[26];
         casevalue[0]= 0.01;
         casevalue[1]= 1.00;
         casevalue[2]= 5.00;
         casevalue[3]= 10.00;
         casevalue[4]= 25.00;
         casevalue[5]= 50.00;
         casevalue[6]= 75.00;
         casevalue[7]= 100.00;
         casevalue[8]= 200.00;
         casevalue[9]= 300.00;
         casevalue[10]= 400.00;
         casevalue[11]= 500.00;
         casevalue[12]= 750.00;
         casevalue[13]= 1000.00;
         casevalue[14]= 5000.00;
         casevalue[15]= 10000.00;
         casevalue[16]= 25000.00;
         casevalue[17]= 50000.00;
         casevalue[18]= 75000.00;
         casevalue[19]= 100000.00;
         casevalue[20]= 200000.00;
         casevalue[21]= 300000.00;
         casevalue[22]= 400000.00;
         casevalue[23]= 500000.00;
         casevalue[24]= 750000.00;
         casevalue[25]= 1000000.00;
       
         for(int x=0; x<26; x++)
         {
            int temp = (int)(Math.random()*26);
            System.out.print(temp);
            while(casevalue[temp] == 0)
            {
               temp = (int)(Math.random()*26);
               System.out.print(temp);
            }
            cases[x] = new Briefcases((x+1), casevalue[temp], temp);
            casevalue[temp] = 0;
         }
         
         for(int x=0; x<26; x++)
         {
            System.out.println(cases[x].eliminate());
         }
      
      	//THARRR SHE BLOWS
         JLabel blank1 =  new JLabel("");
         
         subpanel1.add(blank1);
         
         for(int x=20; x<26; x++)
         {
            subpanel1.add(cases[x]);
         }
         for(int x=13; x<20; x++)
         {
            subpanel1.add(cases[x]);
         }
         for(int x=6; x<13; x++)
         {
            subpanel1.add(cases[x]);
         }
         for(int x=0; x<6; x++)
         {
            subpanel1.add(cases[x]);
         }
         
         JLabel blank2 = new JLabel("");
         
         subpanel1.add(blank2);
         
         add(subpanel1, BorderLayout.CENTER);
      	
      
      	
       
         // Intitializes each briefcase with a number, 1 added to its array number
         
         subpanel2 = new JPanel();
         
      	// Initializing and declaring subpanel2
      	
         subpanel2.setLayout(new FlowLayout());
         
      	// Layout for subpanel2
      	
         singleHost = new Host();
      	
      	// Initializing singleHost
      	
         subpanel2.add(singleHost);
         
      	// Adding singleHost to subpanel2
      	
         singleBoard.setBackground(Color.yellow);
         singleBoard.setForeground(Color.black);
      	
         JButton Exit = new JButton("Exit");
         Exit.addActionListener(new ExitListener());
         subpanel2.add(Exit);
         
         nameEntry = new JTextField("Enter Name");
         subpanel2.add(nameEntry);
      	
         nameButton = new JButton("Name?");
         nameButton.addActionListener(new nameButton());
         subpanel2.add(nameButton);
         
         nameLabel = new JLabel("");
         subpanel2.add(nameLabel);
      
         add(subpanel2, BorderLayout.PAGE_END);
         
      	// Adding subpanel2 to KarimGUIPanel
         
      	 
      	
      
      }
      private class ExitListener implements ActionListener
      {
         public void actionPerformed(ActionEvent e)
         {
            System.exit(0);
         }
      }
      private class nameButton implements ActionListener
      {
         public void actionPerformed(ActionEvent e)
         {
            Global.name = nameEntry.getText();
            subpanel2.remove(nameEntry);
            subpanel2.remove(nameButton);
            nameLabel.setText("Good luck, " + Global.name + "!");
            
         }
      }
   
   
   }