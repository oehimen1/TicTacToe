import java.util.*;
public class TicTac {


	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Scanner input = new Scanner(System.in);
		
        char [][] board = new char[3][3];
		
		for(int i=0; i<3;i++) {
			for(int j=0; j<3;j++) {
				board[i][j]='-';
			}
		}
		
		
		
		System.out.println("Enter name for Player 1");
		String player1 = input.nextLine();
		System.out.println("Enter name for Player 2 ");
		String player2 = input.nextLine();
		
		System.out.println("Welcome to play TicTacToe game! We have the following 3x3 empty board.");
		
		boolean Player1=true;
		boolean gamesEnded=false;
		
		while(!gamesEnded) {
		
			printedBoard(board);
			
			int columnIndex=0;
			int rowIndex=0;
			char player1Symbol;
			
			
			while(true) {
				
				player1Symbol = ' ';
				if(Player1) {
					 player1Symbol = 'X';
				}
				else {
					player1Symbol = 'O';
				}
				
				if(Player1) {
					System.out.println("Player 1 " + player1 + "'s turn");
				}
				else {
					System.out.println("Player 2 " + player2 + "'s turn");
				}
				
				System.out.println("Enter row index");
				 rowIndex = input.nextInt();
				System.out.println("Enter column index");
				 columnIndex = input.nextInt();
				
				if(board[columnIndex][rowIndex] != '-') {
					System.out.println("Sorry this seat's taken try again");
				}
				else {
					break;
				}
			}
		   
			board[rowIndex][columnIndex]=player1Symbol;
		    
		    if(foundWinner(board)== 'X') {
		    	foundWinner(board);
				System.out.println("Player 1 " + player1 + " is the WINNER");
				gamesEnded=true;
		    }
		    else if(foundWinner(board)=='O') {
		    	System.out.println("Player 2 " + player2 + " is the WINNER");
		    	gamesEnded=true;
		    }
		    else {
		    	if(isDraw(board)) {
		    		System.out.println("Draw!");
		    		gamesEnded=true;
		    	}
		    	else {
		    		Player1=!Player1;
		    	}
		    }
		    
	    }
		//Final printed board when winner is found
		printedBoard(board);

	}
	
	public static void printedBoard(char[][]board) {
		System.out.println("-------------");
		System.out.println("| " + board[0][0] + " | " + board[0][1] + " | " + board[0][2] + " |");
		System.out.println("-------------");
		System.out.println("| " + board[1][0] +" | " + board[1][1] + " | " + board[1][2] + " |");
		System.out.println("-------------");
		System.out.println("| " + board[2][0] +" | " + board[2][1] + " | " + board[2][2] + " |");
		System.out.println("-------------");
		
	}
	
	public static char foundWinner(char[][]board) {
		for(int r=0; r<3;r++) {
			if(board[r][0]==board[r][1] && board[r][1]==board[r][2] && board[r][0]!='-') {
				return board[r][0];
			}
		}
		
		for(int c=0; c<3; c++) {
			if(board[0][c]==board[1][c] && board[1][c]==board[2][c] && board[0][c]!= '-') {
				return board[0][c];
			}
		}
		
		if(board[0][0]==board[1][1] && board[1][1]==board[2][2] && board[0][0] != '-') {
			return board[0][0];
		}
		
		if(board[0][2]==board[1][1] && board[1][1]==board[2][0] && board[0][2] != '-') {
			return board[2][0];
		}
	
		
		return '-';
	}
	
	public static boolean isDraw(char[][] board) {
		
		for(int c=0;c<3;c++) {
			for(int r=0; r<3;r++) {
				if(board[c][r]=='-') {
					return false;
				}
			}
		}
		return true;
	}
	
	

}
