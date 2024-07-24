package hw7;
public class test {
    private int rows;
    private int columns;
    private int mines;
    private char board[][];
    private char visibleBoard[][];
    private char boardcopy[][];
    private char boardcopy2[][];

    public test(int inputRows, int inputColumns, int inputMines) { // Game Constructor
        rows = inputRows;
        columns = inputColumns;
        mines = inputMines;
        boardcopy2 = new char[rows][columns];
        visibleBoard = new char[rows][columns];
        board = new char[rows][columns];
        boardcopy = new char[rows][columns];
        board();
        board = populateBoard(board);
        boardcopy();
        visibleBoard();
        boardcopy2();
    }

    public int playerInteract(int inputRow, int inputColumn) {// change visibleboard
        if(visibleBoard[inputRow][inputColumn] != 'o'&& visibleBoard[inputRow][inputColumn] != 'F') {
        	System.out.println("Cell is already open");
        }
        if(visibleBoard[inputRow][inputColumn] == 'F' && visibleBoard[inputRow][inputColumn] != 'o' ) {
        	System.out.println("Flagged cells cannot be opened");
        }
    	if (board[inputRow][inputColumn] == 'X') {
            return 2;
        }
        else {
            visibleBoard[inputRow][inputColumn] = board[inputRow][inputColumn];
            boardcopy2[inputRow][inputColumn]=visibleBoard[inputRow][inputColumn];
            if(board[inputRow][inputColumn]=='-') {
            	if ((inputColumn - 1) != -1) { //sol
                    visibleBoard[inputRow][inputColumn - 1] =board[inputRow][inputColumn - 1];
                    boardcopy2[inputRow][inputColumn-1]=board[inputRow][inputColumn-1];      
                }
                if ((inputRow - 1) != -1) { //üst
                    visibleBoard[inputRow - 1][inputColumn] =board[inputRow - 1][inputColumn];
                    boardcopy2[inputRow-1][inputColumn]=board[inputRow-1][inputColumn];    
                    
                }
                if ((inputRow - 1) != -1 && (inputColumn - 1) != -1) { //sol üst
                    visibleBoard[inputRow - 1][inputColumn - 1] = board[inputRow - 1][inputColumn - 1];
                    boardcopy2[inputRow-1][inputColumn-1]=board[inputRow-1][inputColumn-1];    
                    
                }
                if ((inputRow - 1) != -1 && (inputColumn + 1) != columns) { //sað üst
                    visibleBoard[inputRow - 1][inputColumn + 1] = board[inputRow - 1][inputColumn + 1];
                    boardcopy2[inputRow-1][inputColumn+1]=board[inputRow-1][inputColumn+1];   
                    
                }
                if ((inputRow + 1) != rows) { // alt
                    visibleBoard[inputRow + 1][inputColumn] = board[inputRow + 1][inputColumn];
                    boardcopy2[inputRow+1][inputColumn]=board[inputRow+1][inputColumn];    
                    
                }
                if ((inputColumn + 1) != columns) { //sað
                    visibleBoard[inputRow][inputColumn + 1] =board[inputRow][inputColumn + 1];
                    boardcopy2[inputRow][inputColumn+1]=board[inputRow][inputColumn+1];  
                    
                }
                if ((inputRow + 1) != rows && (inputColumn + 1) != columns) { //sað alt
                    visibleBoard[inputRow + 1][inputColumn + 1] = board[inputRow + 1][inputColumn + 1];
                    boardcopy2[inputRow+1][inputColumn+1]=board[inputRow+1][inputColumn+1];    
                    
                }
                if ((inputRow + 1) != rows && (inputColumn - 1) != -1) {   //sol alt
                    visibleBoard[inputRow + 1][inputColumn - 1] = board[inputRow + 1][inputColumn - 1];
                    boardcopy2[inputRow+1][inputColumn-1]=board[inputRow+1][inputColumn-1];   
                    
                }	
            }   
        }
    	int t=0;
    	while(t<rows) {
    	for(int i = 0; i < rows; i++) { // This section then assigns each space of number based on the surrounding mines.
            for (int j = 0; j < columns; j++) {
                if (visibleBoard[i][j] == '-') {           
                    if ((j - 1) != -1) { //sol
                        visibleBoard[i][j - 1] =board[i][j-1];
                        boardcopy2[i][j - 1] =board[i][j-1];                           
                    }
                    if ((i - 1) != -1) { //üst
                        visibleBoard[i - 1][j] =board[i-1][j]; 
                        boardcopy2[i - 1][j] =board[i-1][j];                          
                    }
                    if ((i - 1) != -1 && (j - 1) != -1) { //sol üst
                        visibleBoard[i - 1][j - 1] =board[i-1][j-1]; 
                        boardcopy2[i - 1][j - 1] =board[i-1][j-1];                        
                    }
                    if ((i - 1) != -1 && (j + 1) != columns) { //sað üst
                        visibleBoard[i - 1][j + 1] =board[i-1][j+1];
                        boardcopy2[i - 1][j + 1] =board[i-1][j+1];                                                    
                    }
                    if ((i + 1) != rows) { // alt
                        visibleBoard[i + 1][j] =board[i+1][j]; 
                        boardcopy2[i + 1][j] =board[i+1][j];                           
                    }
                    if ((j + 1) != columns) { //sað
                        visibleBoard[i][j + 1] =board[i][j+1];
                        boardcopy2[i][j + 1] =board[i][j+1];                         
                    }
                    if ((i + 1) != rows && (j + 1) != columns) { //sað alt
                        visibleBoard[i + 1][j + 1] =board[i+1][j+1];
                        boardcopy2[i + 1][j + 1] =board[i+1][j+1];                           
                    }
                    if ((i + 1) != rows && (j - 1) != -1) {   //sol alt
                        visibleBoard[i + 1][j - 1] =board[i+1][j-1];
                        boardcopy2[i + 1][j - 1] =board[i+1][j-1];                          
                    }
                }
            }
    	}
    	t++;
    	}
        for (int i = 0; i< rows; i++) { // Checks for a win, if they haven't won yet, then they need to keep playing
            for (int j = 0; j < columns; j++) {
                if (board[i][j] != 'X') {
                    if (visibleBoard[i][j] == board[i][j]) {
                        visibleBoard[i][j] = visibleBoard[i][j];
                    }
                    else {
                        return 0;
                    }
                }
            }
        }
        return 1;
    }
    public int playerInteract(int inputRow, int inputColumn,char move) {
    	if(move!='F' && move!='U') {
    		if(visibleBoard[inputRow][inputColumn] != 'o' && visibleBoard[inputRow][inputColumn] != 'F') {
        	System.out.println("Cell is already open");
    		}
    	}
    	if(move=='U') {
    		if(visibleBoard[inputRow][inputColumn]!='F' ) {
    			System.out.println("Only flagged cells can be unflagged .");
    		}
    		if(board[inputRow][inputColumn]=='F') {
    			visibleBoard[inputRow][inputColumn] = 'o';
    			board[inputRow][inputColumn]=boardcopy[inputRow][inputColumn];
    			boardcopy2[inputRow][inputColumn]='o';
    		}
    	}
    	if(move=='F') {
    		if(visibleBoard[inputRow][inputColumn]!='o') {
    		System.out.println("Open cells cannot be flagged .");
    		}
    		if(visibleBoard[inputRow][inputColumn]=='o') {
            visibleBoard[inputRow][inputColumn] = move;
            board[inputRow][inputColumn]=move;
            boardcopy2[inputRow][inputColumn]=move;
    		}
    	}    
        
        for (int i = 0; i< rows; i++) { // Checks for a win, if they haven't won yet, then they need to keep playing
            for (int j = 0; j < columns; j++) {
                if (board[i][j] != 'X') {
                    if (visibleBoard[i][j] == board[i][j]) {
                        visibleBoard[i][j] = visibleBoard[i][j];
                    }
                    else {
                        return 0;
                    }
                }
            }
        }
        return 1;	
    }
    	
    public void getVisibleBoard() {
        printBoard(visibleBoard);
    } // Calls the "visible" board, i.e. what the player can see
    
    public void getBoard() {
        printBoard(board);
    } // Calls the master board with all of the answers

    private char[][] populateBoard(char inputBoard[][]) { // Helper Method to randomly place mines
        while (mines != 0) {
            int a = (int)(Math.random()*rows);
            int b = (int)(Math.random()*columns);
            if (inputBoard[a][b] == 'o') {
                inputBoard[a][b] = 'X';
                mines -= 1;
            }
        }
        int tempMines;
        for(int i = 0; i < rows; i++) { // This section then assigns each space of number based on the surrounding mines.
            for (int j = 0; j < columns; j++) {
                if (inputBoard[i][j] != 'X') {
                    tempMines = 0;
                    
                    if ((j - 1) != -1) { //sol
                        if (inputBoard[i][j - 1] == 'X') {
                            tempMines += 1;
                        }
                    }
                    if ((i - 1) != -1) { //üst
                        if (inputBoard[i - 1][j] == 'X') {
                            tempMines += 1;
                        }
                    }
                    if ((i - 1) != -1 && (j - 1) != -1) { //sol üst
                        if (inputBoard[i - 1][j - 1] == 'X') {
                            tempMines += 1;
                        }
                    }
                    if ((i - 1) != -1 && (j + 1) != columns) { //sað üst
                        if (inputBoard[i - 1][j + 1] == 'X') {
                            tempMines += 1;
                        }
                    }
                    if ((i + 1) != rows) { // alt
                        if (inputBoard[i + 1][j] == 'X') {
                            tempMines += 1;
                        }
                    }
                    if ((j + 1) != columns) { //sað
                        if (inputBoard[i][j + 1] == 'X') {
                            tempMines += 1;
                        }
                    }
                    if ((i + 1) != rows && (j + 1) != columns) { //sað alt
                        if (inputBoard[i + 1][j + 1] == 'X') {
                            tempMines += 1;
                        }
                    }
                    if ((i + 1) != rows && (j - 1) != -1) {   //sol alt
                        if (inputBoard[i + 1][j - 1] == 'X') {
                            tempMines += 1;
                        }
                    }
                    if(tempMines==0)
                    	inputBoard[i][j] = '-';
                    else if(tempMines==1)
                    	inputBoard[i][j] = '1';
                    else if(tempMines==2)
                    	inputBoard[i][j] = '2';
                    else if(tempMines==3)
                    	inputBoard[i][j] = '3';
                    else if(tempMines==4)
                    	inputBoard[i][j] = '4';
                    else if(tempMines==5)
                    	inputBoard[i][j] = '5';
                    else if(tempMines==6)
                    	inputBoard[i][j] = '6';
                    else if(tempMines==7)
                    	inputBoard[i][j] = '7';
                    else if(tempMines==8)
                    	inputBoard[i][j] = '8';
                    	   
                }
            }
        }
        return (inputBoard);
    }

    private void printBoard(char inputBoard[][]) { // Prints the board in a neat matrix fashion
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < columns; j++) {
            System.out.print(inputBoard[i][j] + "   ");
            }
            System.out.println();
        }
    }
    private void printBoardcopy() { // Prints the board in a neat matrix fashion
        
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < columns; j++) {
            System.out.print(boardcopy2[i][j] + "   ");
            }
            System.out.println();
        }
    }
    public void getBoardcopy() {
        printBoardcopy();
    }

    private void visibleBoard() { // Generates a blank "visible board"
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < columns; j++) {
                visibleBoard[i][j] = 'o';
            }
        }
        printBoard(visibleBoard);
    }
    private void board() { // Generates a blank "visible board"
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < columns; j++) {
                board[i][j] = 'o';
            }
        }
    }
    private void boardcopy() { // Generates a blank "visible board"
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < columns; j++) {
                boardcopy[i][j] = board[i][j];
            }
        }
    }
    private void boardcopy2() { // Generates a blank "visible board"
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < columns; j++) {
            	if(board[i][j]=='X') 
                boardcopy2[i][j] = board[i][j];
            	else
            		boardcopy2[i][j] ='o';
            }
        }
    }
}

