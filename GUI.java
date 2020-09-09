//View of the program
import java.awt.*;
import java.awt.event.*;
import java.io.*;
import java.util.*;
import javax.swing.*;
import javax.imageio.ImageIO;

public class GUI extends JFrame
{
    JPanel topPanel = new JPanel(new FlowLayout());
    JPanel p = new JPanel(new GridLayout(8,5));
    JButton save = new JButton("Save Game"); //board for save game   
    JButton load = new JButton("Load Game"); //board for save game
    JButton[][] board = new JButton[8][5];
    JButton[][] temp = new JButton[8][5];

    public GUI()
    {        
        //Set up windows panel
        super("Herzig Chess");
        
        save.setBackground(Color.GRAY);
        save.setForeground(Color.WHITE);
        load.setBackground(Color.GRAY);
        load.setForeground(Color.WHITE);

        board(p);

        topPanel.add(save);
        topPanel.add(load);
        
        setLayout(new BorderLayout()); // set layout manager for JFrame
        this.add(topPanel, BorderLayout.NORTH);
        this.add(p, BorderLayout.CENTER);
            
        setSize(500,700);
        setVisible(true);
        setResizable(true);

        setDefaultCloseOperation(EXIT_ON_CLOSE);   
    }
    
    public void board(JPanel p)
    {
        //board for pieces
        for(int i=0; i<8; i++){
            for(int j=0; j<5; j++)
            {
                board[i][j] = new JButton();
                board[i][j].setBackground(Color.WHITE);
                p.add(board[i][j]);  

            }
        }
    }
    
    public JButton[][] getBoard(){
        return board;
    }
    
    public void menuListener(ActionListener listenForMenuButton)
    {
        save.addActionListener(listenForMenuButton);
        load.addActionListener(listenForMenuButton);

    }
    
    public void boardListener(ActionListener listenForBoardButton)
    {
        for(int i=0; i<8; i++){
            for(int j=0; j<5; j++){
                board[i][j].addActionListener(listenForBoardButton);
            }
        }
    }
}
