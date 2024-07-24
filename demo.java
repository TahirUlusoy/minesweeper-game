import java.util.Scanner;
public class demo {
	public static void main(String[] args) {
	        int inputRow,inputColumn,t,y,x=0,mines=0,rows,columns;
	        String size;
	        char difficulty;
	    	System.out.println("::WELCOME::");
	        Scanner scan = new Scanner(System.in);
	        System.out.print("Please enter the sizes of the board (m x n ) :");
	        size=scan.next();
	        rows = Integer.parseInt(size.substring(0,size.indexOf("x")));
	        columns = Integer.parseInt(size.substring(size.indexOf("x")+1));
	        System.out.print("Please select the difficulty (E,M, H) :");
	        difficulty=scan.next().charAt(0);
	        
	        if(difficulty=='E' || difficulty=='e')
	        mines = (rows*columns)*15/100;
	        else if(difficulty=='M' || difficulty=='m')
	        mines = (rows*columns)*25/100;
	        else if(difficulty=='H' || difficulty=='h')
	        mines = (rows*columns)*40/100;  
	        
	        System.out.println("");
	        test game = new test(rows, columns, mines); // Creates the game
	        System.out.println("");
	        
	        while (x != -1) { 
	            System.out.println("");
	            System.out.print("Please make a move: ");
	            String s=scan.next();
	            
	            if(s.indexOf("U")!=-1) { //move contains U
	            	 inputRow = Integer.parseInt(s.substring(0,s.indexOf(",")))-1;
	                 inputColumn = Integer.parseInt(s.substring(s.indexOf(",")+1,s.indexOf("U")))-1;
	                 char move1='U';
	                 t=columns-inputRow-1;
	                 y = game.playerInteract(t,inputColumn,move1);
	                 System.out.println("");
	                 System.out.println("");
	                 System.out.println("");
	                 game.getVisibleBoard();
	            }
	            if(s.indexOf("F")!=-1) { //move contains F
		            inputRow = Integer.parseInt(s.substring(0,s.indexOf(",")))-1;
		            inputColumn = Integer.parseInt(s.substring(s.indexOf(",")+1,s.indexOf("F")))-1;
		            char move1='F';
		            t=columns-inputRow-1;
		            y = game.playerInteract(t,inputColumn,move1);	           
		            if (y == 2) { // Response System: Win, Hit or Miss
		                System.out.println("");
		                System.out.println("");	                
		                game.getBoardcopy();
		                System.out.println("You lost,better luck next time.");
		                System.exit(0); // Exits game
		            }
		            if (y == 1) {
		                System.out.println("");
		                System.out.println("");
		                game.getVisibleBoard();
		                System.out.println("Congratulations, you won.");
		                System.exit(0); // Exits game
		            }
		            if (y == 0) {
		                System.out.println("");
		                System.out.println("");
		                System.out.println("");
		                game.getVisibleBoard(); // Continues game 
		            }
	            }
	            if(s.indexOf("F")==-1 && s.indexOf("U")==-1){ // move dont contain U-F
	            	 inputRow = Integer.parseInt(s.substring(0,s.indexOf(",")))-1;
	                 inputColumn = Integer.parseInt(s.substring(s.indexOf(",")+1,s.length()))-1;
	                 t=columns-inputRow-1;
	                 y = game.playerInteract(t,inputColumn);
	                 if (y == 2) { // Response System: Win, Hit or Miss
	                     System.out.println("");
	                     System.out.println("");
	                     game.getBoardcopy();
	                     System.out.println("You lost,better luck next time.");
	                     System.exit(0); // Exits game
	                 }
	                 if (y == 1) {
	                     System.out.println("");
	                     System.out.println("");
	                     game.getVisibleBoard();
	                     System.out.println("Congratulations, you won.");
	                     System.exit(0); // Exits game
	                 }
	                 if (y == 0) {
	                     System.out.println("");
	                     System.out.println("");
	                     System.out.println("");
	                     game.getVisibleBoard(); // Continues game
	                 }
	            }
	        }
    }
}
