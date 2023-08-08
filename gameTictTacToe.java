package ActivityTicTacToe;

//Program by: Chelsea Kate M. Lipnica
//Activity 5.1 -TicTacToe
//BSIT 2 - 1

import java.awt.*;
import java.awt.event.*;
import java.util.*;
import javax.swing.*;

public class gameTicTacToe implements ActionListener{

	boolean playerGame;
	JFrame frame = new JFrame();
	JButton[] box = new JButton[9];
	JPanel panel = new JPanel();
	Random random = new Random();
	JLabel text = new JLabel();
	JPanel header = new JPanel();
	

	gameTicTacToe(){
		
		header.setLayout(new BorderLayout());
		header.setBounds(500,500,500,500);
		
		
		text.setBackground(Color.LIGHT_GRAY);
		text.setForeground(Color.WHITE);
		text.setFont(new Font("Arial",Font.BOLD,30));
		text.setHorizontalAlignment(JLabel.CENTER);
		text.setText("TicTacToe Game");
		text.setOpaque(true);
		
		panel.setLayout(new GridLayout(3,3));
		
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setSize(400,400);
		frame.setLayout(new BorderLayout());
		frame.setVisible(true);
				
		for(int a = 0; a < 9; a++) {
			box[a] = new JButton();
			panel.add(box[a]);
			box[a].setFont(new Font("Verdana",Font.BOLD,50));
			box[a].setFocusable(false);
			box[a].addActionListener(this);
		}
		
		header.add(text);
		frame.add(header,BorderLayout.NORTH);
		frame.add(panel);
		
		algoGame(); //class
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		
		for(int b = 0; b < 9; b++) {
			if(e.getSource()==box[b]) {
				if(playerGame) {
					if(box[b].getText()=="") {
						box[b].setForeground(Color.CYAN);
						box[b].setBackground(Color.DARK_GRAY);
						box[b].setText("X");
						text.setText("O turn");
						
						playerGame = false;
						isTrue();
					}
				}
				else {
					if(box[b].getText()=="") {
						box[b].setForeground(Color.YELLOW);
						box[b].setBackground(Color.DARK_GRAY);
						box[b].setText("O");
						text.setText("X turn");
						
						playerGame = true;
						isTrue(); // methods
					}
				}
			}			
		}
	}
	
	
	public void algoGame() {
		
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			
			e.printStackTrace();
		}
		
		if(random.nextInt(2)==0) {
			playerGame = true;
			text.setText("X turn");
			
		}
		else {
			playerGame = false;
			text.setText("O turn");
		}
	}
		
	
	public void isTrue() { // methods
		
		//checking X
		if((box[0].getText()=="X") && (box[1].getText()=="X") && (box[2].getText()=="X")) {
			winnerX(0,1,2);
		}
		if((box[3].getText()=="X") && (box[4].getText()=="X") && (box[5].getText()=="X")) {
			winnerX(3,4,5);
		}
		if((box[6].getText()=="X") && (box[7].getText()=="X") && (box[8].getText()=="X")) {
			winnerX(6,7,8);
		}
		if((box[0].getText()=="X") && (box[3].getText()=="X") && (box[6].getText()=="X")) {
			winnerX(0,3,6);
		}
		if((box[1].getText()=="X") && (box[4].getText()=="X") && (box[7].getText()=="X")) {
			winnerX(1,4,7);
		}
		if((box[2].getText()=="X") && (box[5].getText()=="X") && (box[8].getText()=="X")) {
			winnerX(2,5,8);
		}
		if((box[0].getText()=="X") && (box[4].getText()=="X") && (box[8].getText()=="X")) {
			winnerX(0,4,8);
		}
		if((box[2].getText()=="X") && (box[4].getText()=="X") && (box[6].getText()=="X")) {
			winnerX(2,4,6);
		}
		
		//checking O
		if((box[0].getText()=="O") && (box[1].getText()=="O") && (box[2].getText()=="O")) {
			winnerO(0,1,2);
		}
		if((box[3].getText()=="O") && (box[4].getText()=="O") && (box[5].getText()=="O")) {
			winnerO(3,4,5);
		}
		if((box[6].getText()=="O") && (box[7].getText()=="O") && (box[8].getText()=="O")) {
			winnerO(6,7,8);
		}
		if((box[0].getText()=="O") && (box[3].getText()=="O") && (box[6].getText()=="O")
				) {
			winnerO(0,3,6);
		}
		if((box[1].getText()=="O") && (box[4].getText()=="O") && (box[7].getText()=="O")) {
			winnerO(1,4,7);
		}
		if((box[2].getText()=="O") && (box[5].getText()=="O") && (box[8].getText()=="O")) {
			winnerO(2,5,8);
		}
		if((box[0].getText()=="O") && (box[4].getText()=="O") && (box[8].getText()=="O")) {
			winnerO(0,4,8);
		}
		if((box[2].getText()=="O") && (box[4].getText()=="O") && (box[6].getText()=="O")) {
			winnerO(2,4,6);
		}
	}
		
	public void winnerX(int b1,int b2,int b3) {
		box[b1].setBackground(Color.PINK);
		box[b2].setBackground(Color.PINK);
		box[b3].setBackground(Color.PINK);
		
		for(int c = 0; c < 9; c++) {
			box[c].setEnabled(false);
		}
		text.setText("X wins!");
		JOptionPane.showMessageDialog(null,"X Wins!", "WINNER", JOptionPane.INFORMATION_MESSAGE);
	}
	
	public void winnerO(int b4,int b5,int b6) {
		box[b4].setBackground(Color.PINK);
		box[b5].setBackground(Color.PINK);
		box[b6].setBackground(Color.PINK);
		
		for(int d = 0; d < 9; d++) {
			box[d].setEnabled(false);
		}
		text.setText("O wins!");
		JOptionPane.showMessageDialog(null,"O Wins!", "WINNER", JOptionPane.INFORMATION_MESSAGE);
	} 
}