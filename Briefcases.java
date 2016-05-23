   import javax.swing.*;
   import java.awt.*;
   import java.awt.event.*;
   import javax.swing.JOptionPane; 
   public class Briefcases extends JPanel
   {
      private double Value;
      //Value of the case
      private int briefnumber;
   	//Number of the case
   	
      private int reference;
   	//For purpose of crossing out values in the Board component
   	
      private JButton briefcase;
   
      public Briefcases(int y, double z, int f)
      {
         briefnumber = y;
         
      	// Numer of the briefcase
         Value = z;
         
      	// Amount of money in briefcase
         reference = f;
       
        // Reference integer to correlate with values in Board class  
      	
         setLayout(new FlowLayout());
         
         briefcase = new JButton ("" + y);
         briefcase.addActionListener(new BriefcaseListener());
         add(briefcase);
         
      	// Single briefcase in one instance of this class
      
      }
      private class BriefcaseListener implements ActionListener
      {
         public void actionPerformed(ActionEvent e)
         {
            String check1 = "**";
            String check2 = "XX";
            
         	// String checks will make sure suitcases do not get chosen more than once
         	
            if(Global.clickcount == 0)
            {
            // If there has been no clicks, it goes to this
               briefcase.setText("**");
               
            	// Once clicked, the first briefcase shows **
               Global.playerValue = Value;
               
            	// The value of the player's first briefcase is stored as Global.playerValue
               Global.clickcount++;
               
            	// The amount of cases chosen increases by 1
               
               Global.round++;
               
            	// Round 1 begins
            	
               JOptionPane.showMessageDialog ( null, "Now that you've chosen \n your case, choose \n 5 to unveil!" );
            
            }
            else if(briefcase.getText() != check1 && briefcase.getText() != check2)
            {
               
               // If there is a case not chosen that is clicked, it goes to this
               
               Global.clickcount++;
               
               // The amount of cases chosen increased by 1
               
               Global.remainingTotal = Global.remainingTotal - Value;
               
               // The remaining amount of total money is kept track of for the Banker's formula
               
               briefcase.setText("XX");
               
               // The label changes to identify as XX
               
               Board.boardValue[reference].setText("---------");
            	
            	// This will set the corresponding value in the Board class to be crossed out
               
               if(Global.clickcount == 6)
               {
                  Global.round++;
                  
               	// After 6 cases are chosen, Round 2 begins
                  
                  int faceNumber = (int)(Math.random()*2+1);
                  
               	// 1 of 2 faces are chosen
                  
                  if(faceNumber == 1)
                  {
                     Host.faceLabel.setIcon(Host.caller1);
                  }
                  else
                  {
                     Host.faceLabel.setIcon(Host.caller2);
                  }
               
                  
                  double bankOffer = (Global.remainingTotal/21.0)*(Global.round/10.0);
                  bankOffer = (((int)(bankOffer*100))/100.00);
                  
               	// banker's offer = average value * turn number / 10
               	
               	
                  int reply = JOptionPane.showConfirmDialog(null, "The banker offers $" + bankOffer + "\n Do you accept?", "Banker's offer", JOptionPane.YES_NO_OPTION);
                  // The offer is given, yes is Deal, no is No Deal
                  if (reply == JOptionPane.YES_OPTION) {
                     JOptionPane.showMessageDialog(null, "Congratulations! You have won $" + bankOffer + "\n There was $" + Global.playerValue + " in your case. \n The difference between the offer and your case is $" + ((int)(100*(bankOffer-Global.playerValue)))/100.00);
                     System.exit(0);
                     // If yes, then it shows how much you won and what was in your case, and the GUI exits
                  }
                  else
                  {
                     JOptionPane.showMessageDialog(null, "Time to choose 5 more cases!");
                     // If no, the show goes on
                     
                  }
               
            
               }
               else if(Global.clickcount == 11)
               {
                  Global.round++;
                  // Once you have a total of 11 (1+5+5) clicks, round 3 starts.
                  
                  int faceNumber = (int)(Math.random()*2+1);
                  if(faceNumber == 1)
                  {
                     Host.faceLabel.setIcon(Host.caller1);
                  }
                  else
                  {
                     Host.faceLabel.setIcon(Host.caller2);
                  }
                  double bankOffer = (Global.remainingTotal/16.0)*(Global.round/10.0);
                  bankOffer = (((int)(bankOffer*100))/100.00);
                  int reply = JOptionPane.showConfirmDialog(null, "The banker offers $" + bankOffer + "\n Do you accept?", "Banker's offer", JOptionPane.YES_NO_OPTION);
                  if (reply == JOptionPane.YES_OPTION) {
                     JOptionPane.showMessageDialog(null, "Congratulations! You have won $" + bankOffer + "\n There was $" + Global.playerValue + " in your case. \n The difference between the offer and your case is $" + ((int)(100*(bankOffer-Global.playerValue)))/100.00);
                     System.exit(0);
                  }
                  else
                  {
                     JOptionPane.showMessageDialog(null, "Time to choose 4 more cases!");
                  }
               }
               else if(Global.clickcount == 15)
               {
                  Global.round++;
                    // Once you have a total of 15 (1+5+5+4) clicks, round 4 starts.
                  
                  int faceNumber = (int)(Math.random()*2+1);
                  if(faceNumber == 1)
                  {
                     Host.faceLabel.setIcon(Host.caller1);
                  }
                  else
                  {
                     Host.faceLabel.setIcon(Host.caller2);
                  }
                  double bankOffer = (Global.remainingTotal/12.0)*(Global.round/10.0);
                  bankOffer = (((int)(bankOffer*100))/100.00);
                  int reply = JOptionPane.showConfirmDialog(null, "The banker offers $" + bankOffer + "\n Do you accept?", "Banker's offer", JOptionPane.YES_NO_OPTION);
                  if (reply == JOptionPane.YES_OPTION) {
                     JOptionPane.showMessageDialog(null, "Congratulations! You have won $" + bankOffer + "\n There was $" + Global.playerValue + " in your case. \n The difference between the offer and your case is $" + ((int)(100*(bankOffer-Global.playerValue)))/100.00);
                     System.exit(0);
                  }
                  else
                  {
                     JOptionPane.showMessageDialog(null, "Time to choose 3 more cases!");
                  }
             
               }
               else if(Global.clickcount == 18)
               {
                  Global.round++;
                    // Once you have a total of 18 (1+5+5+4+3) clicks, round 5 starts.
                  
                  int faceNumber = (int)(Math.random()*2+1);
                  if(faceNumber == 1)
                  {
                     Host.faceLabel.setIcon(Host.caller1);
                  }
                  else
                  {
                     Host.faceLabel.setIcon(Host.caller2);
                  }
                  double bankOffer = (Global.remainingTotal/9.0)*(Global.round/10.0);
                  bankOffer = (((int)(bankOffer*100))/100.00);
                  int reply = JOptionPane.showConfirmDialog(null, "The banker offers $" + bankOffer + "\n Do you accept?", "Banker's offer", JOptionPane.YES_NO_OPTION);
                  if (reply == JOptionPane.YES_OPTION) {
                     JOptionPane.showMessageDialog(null, "Congratulations! You have won $" + bankOffer + "\n There was $" + Global.playerValue + " in your case. \n The difference between the offer and your case is $" + ((int)(100*(bankOffer-Global.playerValue)))/100.00);
                     System.exit(0);
                  }
                  else
                  {
                     JOptionPane.showMessageDialog(null, "Time to choose 2 more cases!");
                  }
             
               }
               else if(Global.clickcount == 20)
               {
                  Global.round++;
                   // Once you have a total of 20 (1+5+5+4+3+2) clicks, round 6 starts
                  int faceNumber = (int)(Math.random()*2+1);
                  if(faceNumber == 1)
                  {
                     Host.faceLabel.setIcon(Host.caller1);
                  }
                  else
                  {
                     Host.faceLabel.setIcon(Host.caller2);
                  }
                  double bankOffer = (Global.remainingTotal/7.0)*(Global.round/10.0);
                  bankOffer = (((int)(bankOffer*100))/100.00);
                  int reply = JOptionPane.showConfirmDialog(null, "The banker offers $" + bankOffer + "\n Do you accept?", "Banker's offer", JOptionPane.YES_NO_OPTION);
                  if (reply == JOptionPane.YES_OPTION) {
                     JOptionPane.showMessageDialog(null, "Congratulations! You have won $" + bankOffer + "\n There was $" + Global.playerValue + " in your case. \n The difference between the offer and your case is $" + ((int)(100*(bankOffer-Global.playerValue)))/100.00);
                     System.exit(0);
                  }
                  else
                  {
                     JOptionPane.showMessageDialog(null, "Time to choose 1 more case!");
                  }
              
               }
               else if(Global.clickcount == 21)
               {
                  Global.round++;
                  // Once you have a total of 21(1+5+5+4+3+2+1) clicks, round 7 starts
                  int faceNumber = (int)(Math.random()*2+1);
                  if(faceNumber == 1)
                  {
                     Host.faceLabel.setIcon(Host.caller1);
                  }
                  else
                  {
                     Host.faceLabel.setIcon(Host.caller2);
                  }
                  double bankOffer = (Global.remainingTotal/6.0)*(Global.round/10.0);
                  bankOffer = (((int)(bankOffer*100))/100.00);
                  int reply = JOptionPane.showConfirmDialog(null, "The banker offers $" + bankOffer + "\n Do you accept?", "Banker's offer", JOptionPane.YES_NO_OPTION);
                  if (reply == JOptionPane.YES_OPTION) {
                     JOptionPane.showMessageDialog(null, "Congratulations! You have won $" + bankOffer + "\n There was $" + Global.playerValue + " in your case. \n The difference between the offer and your case is $" + ((int)(100*(bankOffer-Global.playerValue)))/100.00);
                     System.exit(0);
                  }
                  else
                  {
                     JOptionPane.showMessageDialog(null, "Time to choose 1 more case!");
                  }
               
               }
               else if(Global.clickcount == 22)
               {
                  Global.round++;
                  // Once you have a totla of 24(1+5+5+4+3+2+1+1) clicks, round 8 starts
                  int faceNumber = (int)(Math.random()*2+1);
                  if(faceNumber == 1)
                  {
                     Host.faceLabel.setIcon(Host.caller1);
                  }
                  else
                  {
                     Host.faceLabel.setIcon(Host.caller2);
                  }
                  double bankOffer = (Global.remainingTotal/5.0)*(Global.round/10.0);
                  bankOffer = (((int)(bankOffer*100))/100.00);
                  int reply = JOptionPane.showConfirmDialog(null, "The banker offers $" + bankOffer + "\n Do you accept?", "Banker's offer", JOptionPane.YES_NO_OPTION);
                  if (reply == JOptionPane.YES_OPTION) {
                     JOptionPane.showMessageDialog(null, "Congratulations! You have won $" + bankOffer + "\n There was $" + Global.playerValue + " in your case. \n The difference between the offer and your case is $" + ((int)(100*(bankOffer-Global.playerValue)))/100.00);
                     System.exit(0);
                  }
                  else
                  {
                     JOptionPane.showMessageDialog(null, "Time to choose 1 more case!");
                  }
               
               }
               else if(Global.clickcount == 23)
               {
                  Global.round++;
                  // Once you have a totla of 24(1+5+5+4+3+2+1+1+1) clicks, round 9 starts
                  int faceNumber = (int)(Math.random()*2+1);
                  if(faceNumber == 1)
                  {
                     Host.faceLabel.setIcon(Host.caller1);
                  }
                  else
                  {
                     Host.faceLabel.setIcon(Host.caller2);
                  }
                  double bankOffer = (Global.remainingTotal/4.0)*(Global.round/10.0);
                  bankOffer = (((int)(bankOffer*100))/100.00);
                  int reply = JOptionPane.showConfirmDialog(null, "The banker offers $" + bankOffer + "\n Do you accept?", "Banker's offer", JOptionPane.YES_NO_OPTION);
                  if (reply == JOptionPane.YES_OPTION) {
                     JOptionPane.showMessageDialog(null, "Congratulations! You have won $" + bankOffer + "\n There was $" + Global.playerValue + " in your case. \n The difference between the offer and your case is $" + ((int)(100*(bankOffer-Global.playerValue)))/100.00);
                     System.exit(0);
                  }
                  else
                  {
                     JOptionPane.showMessageDialog(null, "Time to choose 1 more case!");
                  }
               }
               else if(Global.clickcount == 24)
               {
                  Global.round++;
                   // Once you have a totla of 24(1+5+5+4+3+2+1+1+1+1) clicks, round 10 starts
                  int faceNumber = (int)(Math.random()*2+1);
                  if(faceNumber == 1)
                  {
                     Host.faceLabel.setIcon(Host.caller1);
                  }
                  else
                  {
                     Host.faceLabel.setIcon(Host.caller2);
                  }
                  double bankOffer = (Global.remainingTotal/3.0)*(Global.round/10.0);
                  bankOffer = (((int)(bankOffer*100))/100.00);
                  int reply = JOptionPane.showConfirmDialog(null, "The banker offers $" + bankOffer + "\n Do you accept?", "Banker's offer", JOptionPane.YES_NO_OPTION);
                  if (reply == JOptionPane.YES_OPTION) {
                     JOptionPane.showMessageDialog(null, "Congratulations! You have won $" + bankOffer + "\n There was $" + Global.playerValue + " in your case. \n The difference between the offer and your case is $" + ((int)(100*(bankOffer-Global.playerValue)))/100.00);
                     System.exit(0);
                  }
                  else
                  {
                     JOptionPane.showMessageDialog(null, "Time to choose 1 more case!");
                  }
               }
               else if(Global.clickcount == 25)
               {
                  Global.round++;
                  // Once you have a totla of 25(1+5+5+4+3+2+1+1+1+1+1) clicks, final offer
                  int faceNumber = (int)(Math.random()*2+1);
                  if(faceNumber == 1)
                  {
                     Host.faceLabel.setIcon(Host.caller1);
                  }
                  else
                  {
                     Host.faceLabel.setIcon(Host.caller2);
                  }
                  double bankOffer = (Global.remainingTotal/2.0)*(Global.round/10.0);
                  bankOffer = (((int)(bankOffer*100))/100.00);
                  int reply = JOptionPane.showConfirmDialog(null, "The banker offers $" + bankOffer + " as a final offer. \n Do you accept?", "Banker's offer", JOptionPane.YES_NO_OPTION);
                  if (reply == JOptionPane.YES_OPTION) {
                     JOptionPane.showMessageDialog(null, "Congratulations! You have won $" + bankOffer + "\n There was $" + Global.playerValue + " in your case. \n The difference between the offer and your case is $" + ((int)(100*(bankOffer-Global.playerValue)))/100.00);
                     System.exit(0);
                  }
                  else
                  {
                     JOptionPane.showMessageDialog(null, "You walk away with $" + Global.playerValue + "\n Play again soon!");
                     System.exit(0);
                  }
               
               }
            
               
            }
            else
            {
               System.out.println("ERROR!");
               
               // If a case that has already been chosen is chosen again, it will do nothing
            }
            
                     	
         	// After each button click, a new face is chosen along with a new quote
         	// 1 of 5 faces are randomly chosen, and each face has 5 different quotes chosen randomly
            int faceNumber = (int)(Math.random()*5+1);
            int quoteNumber = (int)(Math.random()*5+1);
            if(faceNumber == 1)
            {
               Host.faceLabel.setIcon(Host.face1);
               
               if(quoteNumber == 1)
               {
                  ProjectPanel.nameLabel.setText("Looking sharp, " + Global.name + "!");
               }
               else if(quoteNumber == 2)
               {
                  ProjectPanel.nameLabel.setText("You're a natural, " + Global.name + "!");
               }
               else if(quoteNumber == 3)
               {
                  ProjectPanel.nameLabel.setText("Don't sweat it, " + Global.name + "!");
               }
               else if(quoteNumber == 4)
               {
                  ProjectPanel.nameLabel.setText("You've got this, " + Global.name + "!");
               }
               else
               {
                  ProjectPanel.nameLabel.setText("Nice pick, " + Global.name + "!");
               }
            }
            else if(faceNumber == 2)
            {
               Host.faceLabel.setIcon(Host.face2);
               if(quoteNumber == 1)
               {
                  ProjectPanel.nameLabel.setText("Today could be your lucky day, " + Global.name + "!");
               }
               else if(quoteNumber == 2)
               {
                  ProjectPanel.nameLabel.setText("Keep calm and carry on, " + Global.name + "!");
               }
               else if(quoteNumber == 3)
               {
                  ProjectPanel.nameLabel.setText("My forehead is pretty shiny, " + Global.name + "!");
               }
               else if(quoteNumber == 4)
               {
                  ProjectPanel.nameLabel.setText("Be one with the briefcase, " + Global.name + "!");
               }
               else
               {
                  ProjectPanel.nameLabel.setText("Keep your composure, " + Global.name + "!");
               }
            }
            else if(faceNumber == 3)
            {
               Host.faceLabel.setIcon(Host.face3);
               if(quoteNumber == 1)
               {
                  ProjectPanel.nameLabel.setText("Don't get too comfortable, " + Global.name + "!");
               }
               else if(quoteNumber == 2)
               {
                  ProjectPanel.nameLabel.setText("Be careful, " + Global.name + "!");
               }
               else if(quoteNumber == 3)
               {
                  ProjectPanel.nameLabel.setText("Think twice, " + Global.name + "!");
               }
               else if(quoteNumber == 4)
               {
                  ProjectPanel.nameLabel.setText("Don't let me down, " + Global.name + "!");
               }
               else
               {
                  ProjectPanel.nameLabel.setText("I am your father, " + Global.name + "!");
               }
            }
            else if(faceNumber == 4)
            {
               Host.faceLabel.setIcon(Host.face4);
               if(quoteNumber == 1)
               {
                  ProjectPanel.nameLabel.setText("You've got to be kidding me, " + Global.name + "!");
               }
               else if(quoteNumber == 2)
               {
                  ProjectPanel.nameLabel.setText("Are you serious, " + Global.name + "!");
               }
               else if(quoteNumber == 3)
               {
                  ProjectPanel.nameLabel.setText("You could've done better, " + Global.name + "!");
               }
               else if(quoteNumber == 4)
               {
                  ProjectPanel.nameLabel.setText("¡¿Por qué, " + Global.name + "!?");
               }
               else
               {
                  ProjectPanel.nameLabel.setText("Whaaaa, " + Global.name + "!");
               }
            }
            else
            {
               Host.faceLabel.setIcon(Host.face5);
               if(quoteNumber == 1)
               {
                  ProjectPanel.nameLabel.setText("Stellar choice, " + Global.name + "!");
               }
               else if(quoteNumber == 2)
               {
                  ProjectPanel.nameLabel.setText("You're dashing, " + Global.name + "!");
               }
               else if(quoteNumber == 3)
               {
                  ProjectPanel.nameLabel.setText("Maybe we can get some coffee after this, " + Global.name + "!");
               }
               else if(quoteNumber == 4)
               {
                  ProjectPanel.nameLabel.setText("There's something in my eye, " + Global.name + "!?");
               }
               else
               {
                  ProjectPanel.nameLabel.setText("You're doing great, " + Global.name + "!");
               }
            
            }
         
         	
         
         }
      }
      public double eliminate()
      {
         // This method returns the value of this briefcase 
      	// (only used for SOP to check work and isolate logic problems)
         return Value;
      }
      public int crossOut()
      {
         return reference;
         // This method returns the reference integer of this briefcase 
      	// (only used for SOP to check work and isolate logic problems)
      }
   
   }

