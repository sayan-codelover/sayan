import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.io.*;
import java.util.*;
public class RateUs {
	
	JTextField jf,jf1;
	String name="";
	String rate="";
	String fileName="Rating.txt";
	int f=0;
	
	public RateUs()throws IOException
	{
		guiDesign();
	}
	public void guiDesign()throws IOException
	{
		int yValue=130;
		
		FileReader fr=new FileReader(fileName);
		Scanner sc=new Scanner(fr);
		
		JFrame jfrm=new JFrame("Rating");
		jfrm.setDefaultCloseOperation(jfrm.DISPOSE_ON_CLOSE);
		jfrm.setSize(600, 600);
		jfrm.setLocationRelativeTo(null);
		jfrm.getContentPane().setLayout(null);
		
		JLabel label=new JLabel();
		label.setText("Name");
		label.setLocation(200, 10);
		label.setSize(50, 25);
		jfrm.getContentPane().add(label);
		
		jf=new JTextField();
		jf.setText("Enter your full name");
		jf.setLocation(250, 10);
		jf.setSize(150, 25);
		jfrm.getContentPane().add(jf);
		
		JLabel labelRate=new JLabel();
		labelRate.setText("Rate");
		labelRate.setLocation(200, 40);
		labelRate.setSize(50, 25);
		jfrm.getContentPane().add(labelRate);
		
		jf1=new JTextField();
		jf1.setText("Rate us out of 5");
		jf1.setLocation(250, 40);
		jf1.setSize(150, 25);
		jfrm.getContentPane().add(jf1);
		
		JLabel labelRate1=new JLabel();
		labelRate1.setText("Ratings Given by others");
		labelRate1.setLocation(50, 100);
		labelRate1.setSize(300, 25);
		jfrm.getContentPane().add(labelRate1);
		
		JButton jb=new JButton("Submit");
		jb.addActionListener(new ButtonClickListener());
		jb.setLocation(200, 70);
		jb.setSize(200, 25);
		jb.setBackground(Color.blue);
		jb.setForeground(Color.WHITE);
		jfrm.getContentPane().add(jb);
		
		while(sc.hasNext())
		{
			String data="";
			data=sc.nextLine();
			JLabel rateList=new JLabel();
			rateList.setText(data);
			rateList.setLocation(20, yValue);
			rateList.setSize(150, 25);
			jfrm.getContentPane().add(rateList);
			
			data=sc.nextLine();
			JLabel rateList1=new JLabel();
			rateList1.setText(data);
			rateList1.setLocation(200, yValue);
			rateList1.setSize(150, 25);
			jfrm.getContentPane().add(rateList1);
			
			yValue+=30;
		}
		
		System.out.println("ok");
		jfrm.setVisible(true);
		sc.close();
	}
	
	

	private class ButtonClickListener implements ActionListener{
	      public void actionPerformed(ActionEvent e) {
	    	  
	         JButton command = (JButton)(e.getSource()); 
	         f=f+1; 
	         {
	        	 name=jf.getText();
	        	 rate=jf1.getText();
	        	 try
	        	 {
	        	 	write();
	        	 }
	        	 catch(Exception e1)
	        	 {
	        		 e1.getStackTrace();
	        	 }
	        	 System.out.println(name+rate);
	         }
	      }
	}
	
	
	
	public void write()throws IOException
	{
		try{    
	           FileWriter fw=new FileWriter(fileName,true);
	           BufferedWriter r=new BufferedWriter(fw);
	           r.write(name);
	           r.newLine();
	           int a;
	           a=rate.charAt(0);
	           a=a%6;
	           rate="";
	           rate=rate+a;
	           r.write(rate);
	           r.newLine();
	           r.close();
	          }catch(Exception e){System.out.println(e);}    
	          System.out.println("Success...");    
	     }
}