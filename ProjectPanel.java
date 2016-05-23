   import javax.swing.*;
   import java.awt.*;
   import java.awt.event.*;
   import javax.swing.JOptionPane; 
	
   public class ProjectPanel extends JPanel
   {
      private Board singleBoard;
      
   	//singleBoard changes
      private Host singleHost;
      
   	// singleHost changes
      private Briefcases[] cases = new Briefcases[26];
      
   	// I wanted to declare the briefcase instances beforehand
      private JButton nameButton;
      
   	// nameButton changes
      private JTextField nameEntry;
      
   	// nameEntry changes
      private JPanel subpanel2;
      
   	// subpanel2 changes
      
      public static JLabel nameLabel;
      // nameLabel is static so that I can provide motivational/miscellaneous phrases for every briefcase
   	// actionlistener
   
   
   
   
      public ProjectPanel()
      {
      
      
         setLayout(new BorderLayout());
         // Layout for KarimGUIProject Panel
      
         singleBoard = new Board();
      
         
         
      	// Initializing singleBoard
         add(singleBoard, BorderLayout.LINE_END);
         singleBoard.setColor();
         
      	      
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
      	//THARRR SHE BLOWS
      	// So basically what I just did was have all the values listed out that also corresponded with array values
      	// in the Board class
       
         for(int x=0; x<26; x++)
         {
         	// Need to assign 1 value to each briefcase
            int temp = (int)(Math.random()*26);
            // temp would serve to provide a number 1-26 so I could assign a casevalue to a briefcase
            while(casevalue[temp] == 0)
            {
            // If a value was used, I changed it to 0 so that we could assign a new and unused value to each briefcase
               temp = (int)(Math.random()*26);
            }
            cases[x] = new Briefcases((x+1), casevalue[temp], temp);
            casevalue[temp] = 0;
            // Once a casevalue number is used, I set it to go through the while loop to get different values
         	// for each case
         }
         
      
      
         JLabel blank1 =  new JLabel("");
         
      	// Empty placeholder
         
         subpanel1.add(blank1);
         
         for(int x=20; x<26; x++)
         {
            subpanel1.add(cases[x]);
         }
         
      	// The way briefcases are ordered on the show is kinda backwards, so I accomodated 
      	
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
         
      	// Placeholder
         
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
         
      	// Setting up colors for singleBoard
      	
         JButton Exit = new JButton("Exit");
         Exit.addActionListener(new ExitListener());
         subpanel2.add(Exit);
         
      	
      	//Exit button
      	
         nameEntry = new JTextField("Enter Name");
         subpanel2.add(nameEntry);
         
      	//Name text field
      	
         nameButton = new JButton("Name?");
         nameButton.addActionListener(new nameButton());
         subpanel2.add(nameButton);
         
      	//Name button
         
         nameLabel = new JLabel("");
         subpanel2.add(nameLabel);
         
      	//Label displaying name
      
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
            
         	// gets rid of the textfield and button after name is submittied
         	
            nameLabel.setText("Choose your briefcase, " + Global.name + "!");
            
         }
      }
   
   
   }