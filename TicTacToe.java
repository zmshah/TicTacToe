//15-1 Homework Part-1
//Zawaad M Shah
//zmshah16@ole.augie.edu
//TicTacToe.java
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.awt.font.*;
public class TicTacToe extends JFrame implements ActionListener
{
      private int[][] win={{0, 1, 2}, {3, 4, 5}, {6, 7, 8}, 
			   {0, 3, 6}, {1, 4, 7}, {2, 5, 8}, 
			   {0, 4, 8}, {2, 4, 6}};
      private JButton[] btn=new JButton[9];
      private JLabel lblName=new JLabel("Welcome to Zawaad's Tic Tac Toe");
      private JPanel pnlName=new JPanel();
      private JPanel pnlGame=new JPanel();
      private Font f=new Font("Ariel", Font.BOLD, 80);
      private Font n=new Font("Ariel", Font.PLAIN, 30);
      private int turn=0;
      private String letter="";
      public TicTacToe()
      {
            for(int i=0; i<9; ++i)
                btn[i]=new JButton(letter);
            add(pnlName, BorderLayout.NORTH);
            add(pnlGame, BorderLayout.CENTER);
            addButtons();
            addLabel();
            registerListeners();
            setTitle("Tic Tac Toe");
            setSize(600, 600);
            setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            setVisible(true);
      }
      public void addButtons()
      {
            pnlGame.setLayout(new GridLayout(3, 3));
            for(int i=0; i<9; ++i)
                pnlGame.add(btn[i]);
      }
      public void addLabel()
      {
            pnlName.setLayout(new FlowLayout());
            pnlName.add(lblName);
            lblName.setFont(n);
      }
      public void registerListeners()
      {
            for(int i=0; i<9; ++i)
                btn[i].addActionListener(this);
      }
      public void actionPerformed(ActionEvent e)
      {
            for(int i=0; i<9; ++i)
                if((e.getSource()==btn[i]))
                {
                   if((turn%2==0)&&(btn[i].getText().equals("")))
                   {
                      letter="X";
                      btn[i].setText(letter);
                      btn[i].setFont(f);
                      ++turn;
                   }
                   else if((turn%2==1)&&(btn[i].getText().equals("")))
                   {
                      letter="O";
                      btn[i].setText(letter);
                      btn[i].setFont(f);
                      ++turn;
                   }
                }
            whoWin();
      }     
      public void whoWin()
      {
             for(int i=0; i<8; ++i)
             {
                 if((btn[win[i][0]].getText().equals(btn[win[i][1]].getText()))&& 
	            (btn[win[i][1]].getText().equals(btn[win[i][2]].getText()))&&
                    (btn[win[i][0]].getText()!=""))
                    {lblName.setText("Game Over! "+btn[win[i][0]].getText()+" wins!");
                     lblName.setForeground(Color.blue);} 
             }
      }
      public static void main(String[] args)
      {
             TicTacToe t=new TicTacToe();
      }
}
