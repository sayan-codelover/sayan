import java.awt.*;
//import java.awt.GridLayout;
import java.awt.event.*;
//import java.awt.event.ActionListener;
import javax.swing.*;
import java.io.*;
import java.util.*;


public class PlayerVsComputer extends JPanel
{
    JButton buttons[] = new JButton[9];
    String clicked[]=new String[9];
    int cellNo=0,count=0,sent=0;
    int alternate = 0;
    private int player=0;
    private int computer=0;
    public PlayerVsComputer() throws IOException
    {
      setLayout(new GridLayout(3,3));
      updateForRead();
      initializebuttons(); 
    }
    
    public void updateForRead()throws IOException
    {
    	Scanner sc=new Scanner(new FileReader("PlayerVsComputer.txt"));
    	while(sc.hasNext())
    	{
    		player=Integer.parseInt(sc.next());
    		computer=Integer.parseInt(sc.next());
    	}
    	sc.close();
    }
    
    public void updateForWrite()throws IOException
    {
    	FileWriter fw=new FileWriter("PlayerVsComputer.txt");
    	String pl="";
    	pl=pl+player;
    	fw.write(pl);
    	fw.write("\t");
    	pl="";
    	pl=pl+computer;
    	fw.write(pl);
    	fw.close();
    }
    
    public void initializebuttons()
    {
    	float h=(float)0.5,s=(float)0.5,b=(float)0.9;
    	for(int i = 0; i <= 8; i++)
        {
            buttons[i] = new JButton();
            String a="";
            a=a+i;
            buttons[i].setActionCommand(a);
            buttons[i].setText("");
            buttons[i].addActionListener(new ButtonListener());
            buttons[i].setBackground(Color.getHSBColor(h, s, b));
            add(buttons[i]);  
        }
          
    }
    
    public void control()
    {
    	buttons[1].doClick();
    }
    public void resetButtons()
    {
    	
        for(int i = 0; i <= 8; i++)
        {
            buttons[i].setText("");
        }
    }
    

    private class ButtonListener implements ActionListener
    {
       
        public void actionPerformed(ActionEvent e)
        {
            int f=0;
                        
        	System.out.println("Entered Action");
        	String a=e.getActionCommand();
            JButton buttonClicked = (JButton)e.getSource();
            for(int i=0;i<cellNo;i++)
            {
            	if(a.equals(clicked[i]))
            	{
            		f=1;
            		break;
            	}
            }
            if(f==0)
            {
            	clicked[cellNo]=a;
            	cellNo++;
            	if(alternate%2 == 0)
            		buttonClicked.setText("X");
	            else
	                buttonClicked.setText("O");
	            
	            if(checkForWin() == true || alternate==8)
	            {
	            	int input;
	            	if((alternate%2==0 && alternate!=8) || (alternate==8 && checkForWin()==true))
	            	{
	            		player+=1;
	            		JOptionPane.showMessageDialog(null,"           You Won\n"+ "         Scoreboard\n   Player         Computer\n       "+player+"                      "+computer);
	            		input=JOptionPane.showConfirmDialog(null, "Game Over.\nDo you want to continue");
	            	}
	            	else if((alternate%2!=0 && alternate!=8)||(checkForWin()==true))
	            	{
	            		computer+=1;
	            		JOptionPane.showMessageDialog(null,"        Computer Won\n"+ "         Scoreboard\n   Player         Computer\n       "+player+"                      "+computer);
	            		input=JOptionPane.showConfirmDialog(null, "Game Over.\nDo you want to continue");
	            	}
	            	else
	            	{
	            		JOptionPane.showMessageDialog(null,"        Match Drawn\n"+ "         Scoreboard\n   Player         Computer\n       "+player+"                      "+computer);
	            		input=JOptionPane.showConfirmDialog(null, "Game Over.\nDo you want to continue");
	            	}
	            		System.out.println(checkForWin()+""+alternate);
	                if(input==0)
	                {
	                	alternate=-1;
	                	resetButtons();
	                	cellNo=0;
	                	count=0;
	                	sent=-1;
	                	for(int i=0;i<9;i++)
	                	{
	                		clicked[i]="";
	                	}
                	 }
	                else
	                {
	                	
	                	try 
	                	{
							updateForWrite();
						} 
	                	catch (IOException e1) 
	                	{
							e1.printStackTrace();
						}
	                	System.exit(0);
	                }
	            }
	            alternate+=1;
            }
            else
            	JOptionPane.showMessageDialog(null, "Box is already clicked");
            sent+=1;
            System.out.println("Sent="+sent);
            if(sent%2!=0)
            {
            	System.out.println("Entered"+sent);
            	//sent+=1;
            	computerMove();
            }
        }
        
        
        public boolean checkForWin()
        {
            if( checkAdjacent(0,1) && checkAdjacent(1,2) ) 
                return true;
            else if( checkAdjacent(3,4) && checkAdjacent(4,5) )
                return true;
            else if ( checkAdjacent(6,7) && checkAdjacent(7,8))
                return true;
            
            
            else if ( checkAdjacent(0,3) && checkAdjacent(3,6))
                return true;  
            else if ( checkAdjacent(1,4) && checkAdjacent(4,7))
                return true;
            else if ( checkAdjacent(2,5) && checkAdjacent(5,8))
                return true;
            
            
            else if ( checkAdjacent(0,4) && checkAdjacent(4,8))
                return true;  
            else if ( checkAdjacent(2,4) && checkAdjacent(4,6))
                return true;
            else 
                return false;
            
            
        }
        
        public boolean checkAdjacent(int a, int b)
        {
            if ( buttons[a].getText().equals(buttons[b].getText()) && !buttons[a].getText().equals("") )
                return true;
            else
                return false;
        }
        
    }
    
    public void computerMove()
    {
    	int possibleMoveCell[]=new int[9-cellNo];
    	int position=0;
    	for(int i=0;i<9;i++)
    	{
    		int f=0;
    		for(int j=0;j<cellNo;j++)
    		{
	    		if(i==Integer.parseInt(clicked[j]))
	    		{
	    			f=1;
	    			break;
	    		}
    		}
    		if(f==0)
    		{
    			possibleMoveCell[position++]=i;
    		}
    	}
    	int n =possibleMoveCell.length;
    	int hight=logBaseTwo(n);
    	int optimalValue=minimax(0, 0, true, possibleMoveCell, hight);
    	System.out.println("Optimal Value"+optimalValue);
	    buttons[optimalValue].doClick();
	    		return;
    }
    
    public int logBaseTwo(int n)
    {
    	return (n==1)? 0 : 1 + logBaseTwo(n/2);
    }
    
    public int minimax(int depth, int nodeIndex, boolean isMax,int scores[], int h)
    {
    	if (depth == h)
    		return scores[nodeIndex];
    	if (isMax==true)
    		return Math.max(minimax(depth+1, nodeIndex*2, false, scores, h),minimax(depth+1, nodeIndex*2 + 1, false, scores, h));
    	else
    		return Math.min(minimax(depth+1, nodeIndex*2, true, scores, h),minimax(depth+1, nodeIndex*2 + 1, true, scores, h));
    }

    
    public void playerVsComputer() throws IOException 
    {
        JFrame window = new JFrame("Tic-Tac-Toe");
        window.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        window.getContentPane().add(new PlayerVsComputer());
        window.setBounds(400,300,400,400);
        window.setLocationRelativeTo(null);
        window.setVisible(true);
    }
}
