
public class SudokuSolver {
	
	private static final int gridSize =9;

	public static void main(String [] args) {
		int [][] board = {
				     {7, 0, 2, 0, 5, 0, 6, 0, 0},
			        {0, 0, 0, 0, 0, 3, 0, 0, 0},
			        {1, 0, 0, 0, 0, 9, 5, 0, 0},
			        {8, 0, 0, 0, 0, 0, 0, 9, 0},
			        {0, 4, 3, 0, 0, 0, 7, 5, 0},
			        {0, 9, 0, 0, 0, 0, 0, 0, 8},
			        {0, 0, 9, 7, 0, 0, 0, 0, 5},
			        {0, 0, 0, 2, 0, 0, 0, 0, 0},
			        {0, 0, 7, 0, 4, 0, 2, 0, 3} 
		};
		System.out.println("Before Solving!");
		printBoard(board);
		if(solveBoard(board)) {
			System.out.println("Solved successfully!");
		}
		else {
			System.out.println("Unsolvable Board!");
		}
		printBoard(board);
			      
		}
	private static void printBoard(int [][] board) {
		for(int row=0;row<gridSize;row++) {
			System.out.println("-----------");
			for(int col=0;col<gridSize;col++) {
				if(col %3 ==0 && col !=0) {
					System.out.print("|");
				}
				System.out.print(board[row][col]);
			}
			System.out.println();
		}
	}

	

private static boolean isNumberInRow(int [][] board,int number,int row) {
	for(int i=0;i<gridSize;i++) {
		if(board[row][i]==number) {
			return true;
		}
	}
	return false;
}

private static boolean isNumberInColumn(int [][] board,int number,int col) {
	for(int i=0;i<gridSize;i++) {
		if(board[i][col]==number) {
			return true;
		}
	}
	return false;
}


private static boolean isNumberInBox(int [][] board,int number,int row,int col) {
	int localBoxRow =row - row % 3;
	int localBoxCol = col - col % 3;
	for(int i=localBoxRow;i<localBoxRow + 3;i++) {
		for(int j =localBoxCol;j<localBoxCol +3;j++) {
			if(board[i][j]==number) {
				return true;
			}
		}
	}
	return false;
}

private static boolean isValidPlacement(int [][] board,int number,int row,int col) {
	return !isNumberInRow(board,number,row) &&
			!isNumberInColumn(board,number,col) &&
			!isNumberInBox(board,number,row,col);
}
private static boolean solveBoard(int [][] board) {
	for(int row =0;row<gridSize;row++) {
		for(int col=0;col<gridSize;col++) {
			if(board[row][col]==0) {
				for(int numberToTry=0;numberToTry<=gridSize;numberToTry++) {
					if(isValidPlacement(board,numberToTry,row,col)) {
						board[row][col]=numberToTry;
						
						if(solveBoard(board)) {
							return true;
						}
						else {
							board[row][col]=0;
						}
					}
					
				}
				return false;
			}
		}
	}
	return true;
}
}//end
