import java.awt.Color;
import java.awt.Font;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.SwingConstants;

public class AboutUs {
	
	public AboutUs()
	{
			float h=(float)0.1,s=(float)0.1,b=(float)0.9;
			JFrame j = new JFrame("About us"); 
			j.getContentPane().setBackground(Color.getHSBColor(h, s, b));
			j.setSize(850,600);
		    j.getContentPane().setLayout(null);
		    j.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		    j.setLocationRelativeTo(null);
		   
		    JLabel jp1 = new JLabel("We are the under-graduate student of Visva Bharati designing a game TIC TAC TOE in the supervision of our respected Sir Debaditya Barman.");
		    jp1.setLocation(10,10);
		    jp1.setSize(850,20);
		    j.getContentPane().add(jp1);
		    
		    JLabel jp21 = new JLabel("The group members are-");
		    jp21.setLocation(10,50);
		    jp21.setSize(800,20);
		    j.getContentPane().add(jp21);
		    
		    JLabel jp3 ;
		    jp3= new JLabel("1. Sayan Das");
		    jp3.setLocation(10,100);
		    jp3.setSize(800,30);
		    Font f=new Font("",Font.ITALIC,20);
		    jp3.setFont(f);
		    j.getContentPane().add(jp3);
		    
		    JLabel jp31 ;
		    jp31= new JLabel("BSc. Computer Science, 2nd Year, Department Of Computer and System Sciences, Siksha Bhavana, Visva Bharati");
		    jp31.setLocation(30,130);
		    jp31.setSize(800,20);
		    j.getContentPane().add(jp31);

		    jp3= new JLabel("2. Satarupa Das");
		    jp3.setLocation(10,170);
		    jp3.setSize(800,30);
		    Font f1=new Font("",Font.ITALIC,20);
		    jp3.setFont(f1);
		    j.getContentPane().add(jp3);
		    
		    jp31= new JLabel("BSc. Computer Science, 2nd Year, Department Of Computer and System Sciences, Siksha Bhavana, Visva Bharati");
		    jp31.setLocation(30,200);
		    jp31.setSize(800,20);
		    j.getContentPane().add(jp31);
		    
		    jp3= new JLabel("3. Debojyoti Goswami");
		    jp3.setLocation(10,240);
		    jp3.setSize(800,30);
		    Font f2=new Font("",Font.ITALIC,20);
		    jp3.setFont(f2);
		    j.getContentPane().add(jp3);
		    
		    jp31= new JLabel("BSc. Computer Science, 2nd Year, Department Of Computer and System Sciences, Siksha Bhavana, Visva Bharati");
		    jp31.setLocation(30,270);
		    jp31.setSize(800,20);
		    j.getContentPane().add(jp31);

		    j.setVisible(true);  
	}

}
