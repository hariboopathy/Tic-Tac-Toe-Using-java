//import java.util.Random;
package myPackage;

import java.util.Scanner;
class TicTacToe
{
	static char [][] board;
	 
	public TicTacToe()
	 {
		board = new char [3][3];
		initBoard();
	 }
	
	 void initBoard()
	 {
		 for(int i=0;i<board.length;i++)
		 {
			 for(int j=0;j<board[i].length;j++)
			 {
				 board[i][j]= ' ';
			 }
		 }
	 }
	 static void dispBoard()
	 {
		 System.out.println("-------------");
		 for(int i=0;i<board.length;i++)
		 {
			 System.out.print("| ");
			 for(int j=0;j<board[i].length;j++)
			 {
				 System.out.print(board[i][j]+ " | ");
			 }
			 System.out.println();
			 System.out.println("-------------");
		 }
	 }
	 static void Placemark(int row ,int col,char mark)
	 {
		 if(row>=0 && row<=2 && col >=0 && col<=2 )
		 {
		 board[row][col]=mark;
		 }
		 else
		 {
			 System.out.println("Invalid position");
		 }
	 }
	static  boolean CheckcolWin()
	 {
		for(int j=0;j<=2;j++)
		{
			if(board[0][j] != ' ' && board[0][j]== board[1][j] && board[1][j]== board[2][j] )
			{
				return true;
			}
		}
		return false;
	 }
	 static boolean CheckrowWin()
	 {
		for(int i=0;i<=2;i++)
		{
			if(board[i][0] != ' ' && board[i][0]== board[i][1] && board[i][1]== board[i][2] )
			{
				return true;
			}
		}
		return false;
	 }
	static  boolean CheckdiaWin()
	 {
		if(board[0][0] != ' '&& board[0][0]== board[1][1] && board[1][1]== board[2][2] || board [0][2]!=' ' && board[0][2]==board[1][1] && board[1][1]==board[2][0] )
			{
				return true;
			}
		return false;
	 }
	static boolean ischeckDraw()
	{
		for(int i=0;i<=2;i++)
		{
			for(int j=0;j<=2;j++)
			{
				if(board[i][j]==' ')
				{
					return false;
				}
				
			}
		}
		return true;
	}
	 
}
class HumanPlayer
{
	String name;
	char mark;
	HumanPlayer (String name,char mark)
	{
		this.name=name;
		this.mark=mark;
	}
	void makeMove()
	{
		Scanner sc = new Scanner(System.in);
		int row;
		int col;
		do {
			System.out.println("Please Enter the row & col no : ");
			row = sc.nextInt();
			col = sc.nextInt(); 
		} while (!isValidmove(row,col));
		
		TicTacToe.Placemark(row,col,mark);
	   	
	}
	boolean isValidmove(int row,int col)
	{
		if(row>=0 && row<=2 && col >=0 && col<=2)
		{
			if(TicTacToe.board[row][col]==' ');
			{
				return true;
			}
		}
		return false;
		
	}
}
/*	class AIPlayer
	{
		String name;
		char mark;
		AIPlayer(String name,char mark)
		{
			this.name=name;
			this.mark=mark;
		}
		void makeMove()
		{
			Scanner sc = new Scanner(System.in);
			int row;
			int col;
			do {
				Random r = new Random();
				row =r.nextInt(3);
				col = r.nextInt(3);
			} 
		while (!isValidmove(row,col));
			
			TicTacToe.Placemark(row,col,mark);
		   	
		}
		boolean isValidmove(int row,int col)
		{
			if(row>=0 && row<=2 && col >=0 && col<=2)
			{
				if(TicTacToe.board[row][col]==' ');
				{
					return true;
				}
			}
			return false;
			
		}
		*/
	
	
public class LaunchGame {
	
	
      public static void main(String[] args)
      {
	      TicTacToe t = new TicTacToe();
	      HumanPlayer p1 = new HumanPlayer("Adam",'X');
	      HumanPlayer p2 = new HumanPlayer("Eve",'O');
	      //AIPlayer p2 = new AIPlayer("TAI",'O');//
	     
	      HumanPlayer cp;
	      cp=p1;
	      
	      while(true)
	      {
	      
	      System.out.println(cp.name +" turns ");
	      cp.makeMove();
	      TicTacToe.dispBoard();
	   
	      
	      if(TicTacToe.CheckcolWin()||TicTacToe.CheckrowWin() || TicTacToe.CheckdiaWin())
	      {
	    	  System.out.println(cp.name +" has won the game ");
	    	  break;
	      }
	      else if(TicTacToe.ischeckDraw())
	      {
	    	  System.out.println("The Game Between Two Players is Drawn");
	    	  break;
	      }
	      else
	      {
	    	  if(cp==p1)
	    	  {
	    		  cp=p2;
	    		  
	    	  }
	    	  else
	    	  {
	    		  cp=p1;
	    	  }
	      }
	      }       
	       
}	
}
