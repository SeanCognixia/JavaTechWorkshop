package com.cognixia.jump;

import java.awt.*;
import java.awt.event.*;
import java.util.*;
import javax.swing.*;


public class TicTacToe implements ActionListener {

	JFrame frame = new JFrame();
	JPanel titlePanel = new JPanel();
	JPanel buttonPanel = new JPanel();
	JPanel resetPanel = new JPanel(); // panel added for our reset button
	JLabel textField = new JLabel();
	JButton[] buttons = new JButton[9];
	JButton resetButton = new JButton(); // button added to reset board
	
	// Need something to randomly select the first player
	Random random = new Random();
	
	// don't need a boolean for each player, because false will tell us it's player 2's turn
	boolean player1turn;
	
	TicTacToe() {
		
		// Setting values for our GUI display
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setSize(800, 800);
		frame.getContentPane().setBackground(new Color(50, 50, 50));
		//frame.getContentPane().setBackground(Color.BLACK);
		frame.setLayout(new BorderLayout());
		frame.setVisible(true);
		
		// textField will be contained within titlePanel
		textField.setBackground(new Color(25, 25, 25));
		textField.setForeground(new Color(25,255,0));
		textField.setFont(new Font("Tahoma", Font.BOLD, 80));
		textField.setHorizontalAlignment(JLabel.CENTER);
		textField.setText("Tic-Tac-Toe");
		textField.setOpaque(true);
		
		// titlePanel will be contained within frame
		titlePanel.setLayout(new BorderLayout());
		// 					x value, y value, width, height
		//					this will begin at the top left and fill the panel width (800)
		titlePanel.setBounds(0, 0, 800, 100);
		
		titlePanel.add(textField);
		frame.add(titlePanel, BorderLayout.NORTH);
		
		// buttonPanel will be contained within frame
		buttonPanel.setLayout(new GridLayout(3,3));
		buttonPanel.setBackground(new Color(150,150,150));
		
		for(int i=0; i<9; i++) {
			buttons[i] = new JButton();
			buttonPanel.add(buttons[i]);
			buttons[i].setFont(new Font("Tahoma", Font.BOLD, 120));
			buttons[i].setFocusable(false); // can't select it by pressing tab to move the focus
			//buttons[i].addActionListener(this);
		}
		
		frame.add(buttonPanel);
		
		// resetPanel will be contained within frame
		resetPanel.setLayout(new BorderLayout());
		//            		 x value, y value, width, height
		//					 -> this will begin in the bottom right and fill the panel height (800)
		resetPanel.setBounds(800,800,100,800);
		resetPanel.setBackground(new Color(150,150,150));
		resetPanel.add(resetButton);
		resetButton.setFont(new Font("Tahoma",Font.BOLD,60));
		resetButton.setText("Reset");
		frame.add(resetPanel, BorderLayout.EAST);
		
		firstTurn();
		
	}
	
	
	
	private void firstTurn() {
		
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		if(random.nextInt(2)==0) {
			player1turn = true;
			textField.setText("X turn");  	// the nextInt method of the random class accepts an integer value
		} else {							// which is the exclusive upper bound, in this case our range is 0 to 2, not including 2
			player1turn = false;			// In other words, 1 or 0
			textField.setText("O turn");
		}
		
		for(int i=0; i<9; i++) {					
			buttons[i].addActionListener(this);
		}
		resetButton.addActionListener(this);
		
	}


	@Override
	public void actionPerformed(ActionEvent e) {
		
		for(int i=0; i<9; i++) {
			if(e.getSource()==buttons[i]) {
				if(player1turn) {
					if(buttons[i].getText()=="") {
						buttons[i].setForeground(new Color(255,0,0));
						buttons[i].setText("X");
						player1turn=false;
						textField.setText("O turn");
						check();
					}
				} else {
					if(buttons[i].getText()=="") {
						buttons[i].setForeground(new Color(0,0,255));
						buttons[i].setText("O");
						player1turn=true;
						textField.setText("X turn");
						check();
					}
				}
			}
		}
		if(e.getSource()==resetButton) {
			for(int i=0;i<9;i++) {
				buttons[i].setText("");
				buttons[i].setEnabled(true);
				buttons[i].setBackground(new JButton().getBackground()); // sets the color to the default of a new button
			}
			firstTurn();
		} 
		
	}



	private void check() {
		
		int tile1;
		int tile2;
		int tile3;
		
		// check X win conditions;
		tile1 = 0;
		tile2 = 1;
		tile3 = 2;
		if(
				(buttons[tile1].getText()=="X") &&
				(buttons[tile2].getText()=="X") &&
				(buttons[tile3].getText()=="X")
			)
		{ 
			xWins(tile1,tile2,tile3);
		}	
		tile1 = 3;
		tile2 = 4;
		tile3 = 5;
		if(
				(buttons[tile1].getText()=="X") &&
				(buttons[tile2].getText()=="X") &&
				(buttons[tile3].getText()=="X")
			)
		{ 
			xWins(tile1,tile2,tile3);
		}	
		tile1 = 6;
		tile2 = 7;
		tile3 = 8;
		if(
				(buttons[tile1].getText()=="X") &&
				(buttons[tile2].getText()=="X") &&
				(buttons[tile3].getText()=="X")
			)
		{ 
			xWins(tile1,tile2,tile3);
		}	
		tile1 = 0;
		tile2 = 3;
		tile3 = 6;
		if(
				(buttons[tile1].getText()=="X") &&
				(buttons[tile2].getText()=="X") &&
				(buttons[tile3].getText()=="X")
			)
		{ 
			xWins(tile1,tile2,tile3);
		}	
		tile1 = 1;
		tile2 = 4;
		tile3 = 7;
		if(
				(buttons[tile1].getText()=="X") &&
				(buttons[tile2].getText()=="X") &&
				(buttons[tile3].getText()=="X")
			)
		{ 
			xWins(tile1,tile2,tile3);
		}	
		tile1 = 2;
		tile2 = 5;
		tile3 = 8;
		if(
				(buttons[tile1].getText()=="X") &&
				(buttons[tile2].getText()=="X") &&
				(buttons[tile3].getText()=="X")
			)
		{ 
			xWins(tile1,tile2,tile3);
		}	
		tile1 = 2;
		tile2 = 4;
		tile3 = 6;
		if(
				(buttons[tile1].getText()=="X") &&
				(buttons[tile2].getText()=="X") &&
				(buttons[tile3].getText()=="X")
			)
		{ 
			xWins(tile1,tile2,tile3);
		}
		
		// check O win conditions
		tile1 = 0;
		tile2 = 1;
		tile3 = 2;
		if(
				(buttons[tile1].getText()=="O") &&
				(buttons[tile2].getText()=="O") &&
				(buttons[tile3].getText()=="O")
			)
		{ 
			oWins(tile1,tile2,tile3);
		}	
		tile1 = 3;
		tile2 = 4;
		tile3 = 5;
		if(
				(buttons[tile1].getText()=="O") &&
				(buttons[tile2].getText()=="O") &&
				(buttons[tile3].getText()=="O")
			)
		{ 
			oWins(tile1,tile2,tile3);
		}	
		tile1 = 6;
		tile2 = 7;
		tile3 = 8;
		if(
				(buttons[tile1].getText()=="O") &&
				(buttons[tile2].getText()=="O") &&
				(buttons[tile3].getText()=="O")
			)
		{ 
			oWins(tile1,tile2,tile3);
		}	
		tile1 = 0;
		tile2 = 3;
		tile3 = 6;
		if(
				(buttons[tile1].getText()=="O") &&
				(buttons[tile2].getText()=="O") &&
				(buttons[tile3].getText()=="O")
			)
		{ 
			oWins(tile1,tile2,tile3);
		}	
		tile1 = 1;
		tile2 = 4;
		tile3 = 7;
		if(
				(buttons[tile1].getText()=="O") &&
				(buttons[tile2].getText()=="O") &&
				(buttons[tile3].getText()=="O")
			)
		{ 
			oWins(tile1,tile2,tile3);
		}	
		tile1 = 2;
		tile2 = 5;
		tile3 = 8;
		if(
				(buttons[tile1].getText()=="O") &&
				(buttons[tile2].getText()=="O") &&
				(buttons[tile3].getText()=="O")
			)
		{ 
			oWins(tile1,tile2,tile3);
		}	
		tile1 = 2;
		tile2 = 4;
		tile3 = 6;
		if(
				(buttons[tile1].getText()=="O") &&
				(buttons[tile2].getText()=="O") &&
				(buttons[tile3].getText()=="O")
			)
		{ 
			oWins(tile1,tile2,tile3);
		}
		
	}



	private void oWins(int a, int b, int c) {
		
		buttons[a].setBackground(Color.GREEN);
		buttons[b].setBackground(Color.GREEN);
		buttons[c].setBackground(Color.GREEN);
		for(int i=0; i<9; i++) {
			buttons[i].setEnabled(false);
		}
		
		textField.setText("O wins");
		
	}



	private void xWins(int a, int b, int c) {
	
		buttons[a].setBackground(Color.GREEN);
		buttons[b].setBackground(Color.GREEN);
		buttons[c].setBackground(Color.GREEN);
		for(int i=0; i<9; i++) {
			buttons[i].setEnabled(false);
		}
		
		textField.setText("X wins");
		
	}
	
}
