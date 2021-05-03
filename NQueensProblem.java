package javaMiniProject;
public class NQueensProblem 
{ 
    final int N = 8; 
    //method for printing the N Queens solution 
    void displaySolution(int board[][]) 
    { 
        for(int i=0;i<N;i++) 
        { 
            for(int j=0;j<N;j++) 
            	if(board[i][j]==1)
            		System.out.print(" " +"Q"+ " "); 
            		//print Q if Queen is placed at (i,j) index of the chess board
            	else 
            		System.out.print(" " +"-"+ " ");
            		//print '-' if (i,j) index of the board is empty
            System.out.println(); 
            //print a line line after each successive row completion
        } 
    } 

    //method for checkinng next move 
    boolean isSafe(int board[][],int row,int col) 
    { 
        int i,j; 
        for(i=0;i<col;i++) 
            if (board[row][i]==1) 
                return false; 
        		//check the row on thee left

        for(i=row,j=col;i>=0 && j>=0;i--,j--) 
            if (board[i][j]==1) 
                return false; 
        		//check upper diagonal on the left side

        for(i=row,j=col;j>=0 && i<N;i++,j--) 
            if (board[i][j]==1) 
                return false;
        		//check lower diagonal on the left side
                
        return true; 
       
    } 

    boolean solveNQueen(int board[][],int col) 
    { 
        if(col>=N) 
            return true; 
        	//return true if all the queens are placed and also the base condition for recurssivre calls
        for(int i=0;i<N;i++)
        { 
        	//method call to isSafe to check the move
            if(isSafe(board,i,col))
            { 	
            	
                board[i][col]=1; 
                //if the move is safe initialize the board[i][col] to 1
                
                if(solveNQueen(board,col + 1)==true) 
                	//recurssive call to method solveNQueen
                    return true; 

                board[i][col]=0; 
                /* If placing queen in board[i][col] 
                doesn't lead to a solution then 
                remove queen from board[i][col] */
            } 
        } 
        return false; 
    } 
    boolean solveNQ() 
    { 
    	//Deceleration and Initializatiion of 8x8 2D array to 0 
        int board[][] = {{0,0,0,0,0,0,0,0},{0,0,0,0,0,0,0,0},{0,0,0,0,0,0,0,0},{0,0,0,0,0,0,0,0},{0,0,0,0,0,0,0,0},{0,0,0,0,0,0,0,0},{0,0,0,0,0,0,0,0},{0,0,0,0,0,0,0,0}}; 

        //method call to solve N queen problem i.e 8 queeens in our case
        if (solveNQueen(board,0)==false) 
        { 
            System.out.print("Solution does not exist"); 
            return false; 
        } 
        displaySolution(board); 
        return true; 

    } 

    public static void main(String args[]) 
    { 
        NQueensProblem Queen = new NQueensProblem();
        //creating a object of class NQueen with a name Queen
        Queen.solveNQ(); 
        //invoking the method  solveNQ using dot operator
    } 
}