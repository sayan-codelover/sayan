import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.io.*;

public class MainMenu {
   private JFrame mainFrame;
   private JLabel headerLabel;
   private JLabel statusLabel;
   private JPanel controlPanel;

   public MainMenu(){
      prepareGUI();
   }
   public static void main(String[] args){
      MainMenu swingControlDemo = new MainMenu();  
      swingControlDemo.showEventDemo();       
   }
   private void prepareGUI(){
	   float h=(float)0.2,s=(float)0.2,b=(float)0.9;
      mainFrame = new JFrame("Main Menu");
      mainFrame.setSize(400,400);
      mainFrame.setLayout(new GridLayout(1,1));
      mainFrame.getContentPane().setBackground(Color.getHSBColor(h, s, b));
      mainFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

      statusLabel = new JLabel("",JLabel.CENTER);        
      statusLabel.setSize(200,100);
       
      controlPanel = new JPanel();
      controlPanel.setBackground(Color.getHSBColor(h, s, b));
      controlPanel.setLayout(new FlowLayout(FlowLayout.RIGHT,10,10));

      mainFrame.add(controlPanel);
      mainFrame.add(statusLabel);
      mainFrame.setVisible(true);  
   }
   private void showEventDemo(){
	    
	   float h=(float)0.3,s=(float)0.4,b=(float)0.9;

      JButton player1VsPlayer2 = new JButton("Player1 Vs Player2");
      player1VsPlayer2.setPreferredSize(new Dimension(150,40));
      JButton playerVsComputer = new JButton("Player Vs Computer");
      playerVsComputer.setPreferredSize(new Dimension(150,40));
      JButton exit = new JButton("Exit");
      exit.setPreferredSize(new Dimension(150,40));
      JButton rules = new JButton("Rules");
      rules.setPreferredSize(new Dimension(150,40));
      JButton rateUs = new JButton("Rate us");
      rateUs.setPreferredSize(new Dimension(150,40));
      JButton aboutUs=new JButton("About us");
      aboutUs.setPreferredSize(new Dimension(150,40));
      
      player1VsPlayer2.setBackground(Color.getHSBColor(h, s, b));
      playerVsComputer.setBackground(Color.getHSBColor(h, s, b));
      rules.setBackground(Color.getHSBColor(h, s, b));
      rateUs.setBackground(Color.getHSBColor(h, s, b));
      exit.setBackground(Color.getHSBColor(h, s, b));
      aboutUs.setBackground(Color.getHSBColor(h, s, b));
     
      player1VsPlayer2.setActionCommand("1");
      playerVsComputer.setActionCommand("2");
      exit.setActionCommand("3");
      rules.setActionCommand("4");
      rateUs.setActionCommand("5");
      aboutUs.setActionCommand("6");

      player1VsPlayer2.addActionListener(new ButtonClickListener()); 
      playerVsComputer.addActionListener(new ButtonClickListener()); 
      exit.addActionListener(new ButtonClickListener());
      rules.addActionListener(new ButtonClickListener());
      rateUs.addActionListener(new ButtonClickListener());
      aboutUs.addActionListener(new ButtonClickListener());

      controlPanel.add(player1VsPlayer2);
      controlPanel.add(playerVsComputer);
      controlPanel.add(rules);
      controlPanel.add(rateUs);
      controlPanel.add(aboutUs);
      controlPanel.add(exit);       

      mainFrame.setVisible(true);  
   }
   private class ButtonClickListener implements ActionListener{
	      public void actionPerformed(ActionEvent e) {
	         String command = e.getActionCommand();  
	         
	         if( command.equals( "1" ))  {      	 
	      	 
	        	 String player1=JOptionPane.showInputDialog(null, "Name of Player1");
	             String player2=JOptionPane.showInputDialog(null, "Name of Player2");
	             PlayerVsPlayer t=new PlayerVsPlayer(player1,player2);
	        	 t.playerVsPlayer(player1,player2);
	       
	         } else if( command.equals( "2" ) )  {
	        	 try
	        	 {
		            PlayerVsComputer p=new PlayerVsComputer();
		            p.playerVsComputer();
	        	 }
	        	 catch(IOException e1)
	        	 {
	        		 e1.printStackTrace();
	        	 }
	         }
	         else if(command.equals("4"))
	         {
	        	 Rules rules=new Rules();
	         }
	         else if(command.equals("5"))
	         {
	        	 try {
					RateUs rateUs=new RateUs();
				} catch (IOException e1) {
					e1.printStackTrace();
				}
	         }
	         else if(command.equals("6"))
	         {
	        	 new AboutUs();
	         }
	         else {
	            	 System.exit(0);
	         }  	
	      }		
	   }
	}