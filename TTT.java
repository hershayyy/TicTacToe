/**
*  Joshua Yurche
*  CS202
*  Tic Tac Toe
*  This is a Tic Tac Toe game that uses the enum values "X, O, _"
*  for the board and game pieces.  The program asks the users for their 
*  names, then uses a random number generator to decide who will go first.
*  After each turn, the program will check for a winner.  If there has not
*  been a winner yet, the users will continue playing until a win or until
*  the board spaces have been used up resulting in a tie.
*  The after each players entry the program verifies that the entry has not
*  already been made, if so, the program asks the user to make a different entry.
**/

import java.util.Scanner;
import java.util.Random;


public class TTT 
{
	private enum Cell {_, X, O};
	private int row, col;
	private static Cell [][] board;
	private String playerX;
	private String playerO;
	Scanner keyboard = new Scanner(System.in);
	private static int turnCount = 0;
	private char turn = 'X';
	
	
	
	//Set up board
	public TTT()
	{
		board = new Cell[3][3];
		for(row = 0; row < board.length; row++)
		{
			for(col = 0; col < board.length; col++)
			{
				board[row][col] = Cell._;
			}
		}
	}



	//Output the game board
	public String toString()
	{
		String result = "\t";
		for (Cell [] row :board)
		{
			for (Cell col: row)
			{
				result += col + "|";
			}
			result +="\n\t\n\t";
		}
		return result;
	}
	
	
	//Random Number method to decide which player goes first
	public void decideTurn()
	{
		System.out.println("\nPlease enter player X's name : ");
		playerX = keyboard.nextLine();
		
		System.out.println("\nPlease enter player O's name : ");
		playerO = keyboard.nextLine();
		
		//produce random number, either 0 or 1, to decide who goes first.
		Random rand = new Random();
		int result = rand.nextInt(2);
		
		if (result == 0)
		{
			System.out.println("\nPlayer X will go first");
			turn = 'X';
		}
		else
		{
			System.out.println("\nPlayer O will go first");
			turn = 'O';
		}
	}
	
	//Check Cell availability Method
	public static boolean cellOpen(int row, int col)
	{
		if(board[row][col] == Cell._)
			return false;
		else
		{
			return true;
		}
	}
	
	//Boolean Method to check for game winner
	public static boolean GameOver(int row, int col)
	{
		//Check for a win going across and down
		if (board[0][col] == board[1][col] &&
			board[0][col] == board [2][col])
		return true;
		if (board[row][0] == board[row][1] &&
			board[row][0] == board [row][2])
		return true;
		//Check for a win diagonally
		if (board[0][0] == board[1][1] &&
			board[0][0] == board [2][2])
		return true;
		if (board[0][2] == board[1][1] &&
			board[0][2] == board [2][0] && board[1][1] != Cell._)
		return true;
	
		return false;
	}
	
	public void playerX()
	{
		System.out.println("\nPlease enter an open row and column number : ");
		System.out.println("\nRow: ");
		row = keyboard.nextInt() -1;
		System.out.println("\nColumn: ");
		col = keyboard.nextInt() -1;
	
	
		while(cellOpen(row, col))
		{
			System.out.println("\nYou have entered a location that is already Occupied.");
			System.out.println("\nPlease enter an open row and column number: ");
			System.out.println("\nRow: ");
			row = keyboard.nextInt() -1;
			System.out.println("\nColumn: ");
			col = keyboard.nextInt() -1;
		}
		
		board[row][col] = Cell.X;
	}
	
	public void playerO()
	{
		System.out.println("\nPlease enter an open row and column number : ");
		System.out.println("\nRow: ");
		row = keyboard.nextInt() -1;
		System.out.println("\nColumn: ");
		col = keyboard.nextInt() -1;
	
	
		while(cellOpen(row, col))
		{
			System.out.println("\nYou have entered a location that is already Occupied.");
			System.out.println("\nPlease enter an open row and column number: ");
			System.out.println("\nRow: ");
			row = keyboard.nextInt() -1;
			System.out.println("\nColumn: ");
			col = keyboard.nextInt() -1;
		}
		
		board[row][col] = Cell.O;
	}
	
	//Play Method
	public void play()
	{
		
		boolean inPlay = true;
		System.out.println(this);
		decideTurn();
		while (inPlay)
		{
			if(turnCount == 9)
			{
				inPlay = false;
				System.out.println("Game over! " + playerX + " & " + playerO + " have tied!");
			}
			else
			{
			
				if(turn == 'X')
				{
					playerX();
				}
				else
				{
					playerO();
				}
					
				
					if(GameOver(row, col))
					{
						inPlay = false;
						if(turn == 'X')
						{
							System.out.println("Game over! " + playerX + " wins!");
						}
						else
						{
							System.out.println("Game over! " + playerO + " wins!");
						}
						
					}
			}
			
			if (turn == 'X')
				turn = 'O';
			else
				turn = 'X';
			System.out.println(this);
			turnCount++;
		}
	}
	
	
	
	//Main method
	public static void main(String[] args)
	{
		System.out.println();
		System.out.println("***************************************************");
		System.out.println("** This is a two- player game.  The object is to **");
		System.out.println("** be the first person to get three X's or O's   **");
		System.out.println("** in a row, either horizontally, diagonally, or **");
		System.out.println("** vertically. To choose your spot on the board, **");
		System.out.println("** when prompted, you will first type the row    **");
		System.out.println("** number (1-3) then hit enter, followed by the  **");
		System.out.println("** column number (1-3) then enter.               **");
		System.out.println("***************************************************");
	
		TTT DDD = new TTT();
		System.out.println();

		DDD.play();
	}
}
