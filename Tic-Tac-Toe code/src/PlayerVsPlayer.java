import java.awt.*;
//import java.awt.GridLayout;
import java.awt.event.*;
//import java.awt.event.ActionListener;
import javax.swing.*;

public class PlayerVsPlayer extends JPanel
{
    JButton buttons[] = new JButton[9];
    String clicked[]=new String[9];
    int cellNo=0;
    int alternate = 0;
    private int player1Score=0;
    private int player2Score=0;
    String player1="",player2="";
    
    public PlayerVsPlayer(String player,String player3)
    {
    	player1=player1+player;
    	player2=player2+player3;
    	setLayout(new GridLayout(3,3));
    	initializebuttons(); 
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
            buttons[i].setBackground(Color.getHSBColor(h, s, b));
            buttons[i].addActionListener(new ButtonListener());
            add(buttons[i]); 
        }
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
	            		player1Score+=1;
	            		System.out.println(player1+player2);
	            		JOptionPane.showMessageDialog(null,"        "+player1+" Won\n"+ "         Scoreboard\n   "+player1+"         "+player2+"\n       "+player1Score+"                   "+player2Score);
	            		input=JOptionPane.showConfirmDialog(null, "Game Over.\nDo you want to continue");
	            	}
	            	else if((alternate%2!=0 && alternate!=8)||(checkForWin()==true))
	            	{
	            		player2Score+=1;
	            		JOptionPane.showMessageDialog(null,"        "+player2+" Won\n"+ "         Scoreboard\n   "+player1+"         "+player2+"\n       "+player1Score+"                    "+player2Score);
	            		input=JOptionPane.showConfirmDialog(null, "Game Over.\nDo you want to continue");
	            	}
	            	else
	            	{
	            		JOptionPane.showMessageDialog(null,"        Match Drawn\n"+ "         Scoreboard\n   "+player1+"         "+player2+"\n       "+player1Score+"                    "+player2Score);
	            		input=JOptionPane.showConfirmDialog(null, "Game Over.\nDo you want to continue");
	            	}
	            		System.out.println(checkForWin()+""+alternate);
	                if(input==0)
	                {
	                	alternate=-1;
	                	resetButtons();
	                	cellNo=0;
	                	for(int i=0;i<9;i++)
	                	{
	                		clicked[i]="";
	                	}
                	}
	                else
	                {
	                     	System.exit(0);
	                }
	            }
	            alternate++;
            }
            else
            	JOptionPane.showMessageDialog(null, "Box is already clicked");
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
    
    public void playerVsPlayer(String player,String player3) 
    {
    	JFrame window = new JFrame("Player1 Vs Player2");
        window.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        window.getContentPane().add(new PlayerVsPlayer(player1,player2));
        window.setBounds(400,300,400,400);
        window.setLocationRelativeTo(null);
        System.out.println(player1+player2);
        window.setVisible(true);
    }
}
