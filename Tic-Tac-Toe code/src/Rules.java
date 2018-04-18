
import javax.swing.*; 
import java.awt.*;
public class Rules {
	 Rules() { 
		 JFrame j = new JFrame("Rules"); 
		 j.getContentPane().setBackground(Color.PINK);
		    j.setSize(600,300);
		    j.getContentPane().setLayout(null);
		    j.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		    j.setLocationRelativeTo(null);
		       
		    JLabel jp = new JLabel("Rules and Regulations");
		    jp.setLocation(140,10);
		    jp.setSize(325,40);
		    Font f=new Font("",Font.ITALIC,30);
		    jp.setFont(f);   
		    j.getContentPane().add(jp);
		   
		    JLabel jp1 = new JLabel("1.The object of Tic Tac Toe is to get three in a row.");
		    jp1.setLocation(10,60);
		    jp1.setSize(500,20);
		    j.getContentPane().add(jp1);
		    
		    JLabel jp2 = new JLabel("2.We play on a three by three game board.The first player is known as X and the");
		    jp2.setLocation(10,90);
		    jp2.setSize(500,20);
		    j.getContentPane().add(jp2);
		    
		    JLabel jp21 = new JLabel("second is 0.");
		    jp21.setLocation(10,120);
		    jp21.setSize(500,20);
		    j.getContentPane().add(jp21);
		    
		    JLabel jp3 = new JLabel("3.Players alternate placing Xs and 0s on the game board until either oppent has");
		    jp3.setLocation(10,150);
		    jp3.setSize(500,20);
		    j.getContentPane().add(jp3);
		    
		    JLabel jp31 = new JLabel("three in a row or all nine squares are filled.");
		    jp31.setLocation(10,180);
		    jp31.setSize(500,20);
		    j.getContentPane().add(jp31);

		    JLabel jp4 = new JLabel("4.X always goes first,and in the event that no one has three in a row,then it is a draw.");
		    jp4.setLocation(10,210);
		    jp4.setSize(500,20);
		    j.getContentPane().add(jp4);     
		    j.setVisible(true);  
	    } 
}