import java.util.Scanner;

import java.io.*;

public class suduko{
    public static final int GRIDE_SIZE = 9;
    
    static Scanner scan= new Scanner(System.in);
    public static void main(String[] args) {
        String RESET = "\u001B[0m";
        String RED = "\u001B[31m";
        String[][] board = {
            {"_","_","_","_","_","_","_","_","_"},
            {"_","_","_","_","_","_","_","_","_"},
            {"_","_","_","_","_","_","_","_","_"},
            {"_","_","_","_","_","_","_","_","_"},
            {"_","_","_","_","_","_","_","_","_"},
            {"_","_","_","_","_","_","_","_","_"},
            {"_","_","_","_","_","_","_","_","_"},
            {"_","_","_","_","_","_","_","_","_"},
            {"_","_","_","_","_","_","_","_","_"},
        };
    System.out.println("\n\t\t<------------------- Welcome To Suduko ----------------------->");
    System.out.println("\t\t<-----DEVELOPED BY----->");
    System.out.println("\t\t<----AFNAN & JAY---->\n");
    System.out.println("press enter  to cointinue");
    scan.nextLine();
    System.out.println("\n\t\t<------------------- RULES----------------------->");
    System.out.println(
    "1) Grid: Sudoku is played on a 9x9 grid, divided into nine 3x3 subgrids or regions."+"\n\n"+
    "2) Numbers: Fill the grid with digits from 1 to 9. Each row, each column, and each of the nine 3x3 subgrids that compose the grid should contain all of the digits from 1 to 9 without repetition."+"\n\n"+
    "3) Initial Setup: At the beginning of the game, some of the cells in the grid will already be filled with numbers. These are the given clues to help you start solving the puzzle."+"\n\n"+
    "4) No Repetition: No row, column, or 3x3 subgrid can have repeated numbers. Each number must appear exactly once in each row, each column, and each subgrid."+"\n\n"+
    "5) Logical Deduction: Sudoku is a game of logic and deduction. It can be solved using reasoning rather than guesswork. You should be able to fill in each cell through logical deduction based on the given clues and the numbers already filled in");  
     System.out.println("press enter  to cointinue");   
     scan.nextLine();

    int[][] store = new int[9][9];
     
        for(int i =0;i<38;i++){

            int row=randomnumber();
            int coloumn=randomnumber();
            int number=randomnumber();
            /**
             * logic for 
             * same number cannot be a 3x3 gride
             * same number cannot be in the same row or coloumn
             */
            String num = Integer.toString(number);
            board[row][coloumn]=(RED+num+RESET);
            store[row][coloumn]=1;

        }
        System.out.println();
        printBoard(board);
        System.out.println();
        while(true){
            int[] spot =askuser(board,store);
            board[spot[1]][spot[2]]= Integer.toString(spot[0]);
            printBoard(board);
            System.out.println();
            if(CheckUserWin()){
                /**for timebeing */
                break;
            }
        }
     
    }
    public static void printBoard(String[][] board){
        for (int i = 0; i < board.length; i++) {
            System.out.println();
            System.out.print("\t\t\t\t");
            if(i==0||i==3||i==6||i==9){
                System.out.println("-------------------------");
                System.out.print("\t\t\t\t");
            }
            for(int j=0;j<GRIDE_SIZE;j++){
               System.out.print( board[i][j]+" ");
               if(j==2||j==5){
                   System.out.print(" | ");
               }
            }
            
        }

    }
    /**
     * takes in user input and also check if that space is taken or not
     * @param board
     * @return array
     */
    public static int[] askuser(String[][] board,int[][] store){
       // Scanner scanner = new Scanner(System.in);
        System.out.println("enter the number");
        int number = scan.nextInt();
        while(true){
            if(number<0||number>9){
            System.out.println("number cannot be greater than 9 or less than 0");
            System.out.println("enter the number");
            number = scan.nextInt();
            }else{break;}

        }
        System.out.println("enter the row and coloum");
        int row = scan.nextInt()-1;
        int coloumn= scan.nextInt()-1;
        while(true){
            if( row>9 ||coloumn>9|| row<0||coloumn<0){
                System.out.println("row,coloumn cannot be greater than 9 or less than 0");
                System.out.println("enter the row and coloum");
                row = scan.nextInt()-1;
                coloumn= scan.nextInt();
            }else{break;}
            }
        
        
        while(true){
            if(store[row][coloumn]==1){
                System.out.println("\nTHAT ROW AND COLOUMN CANNOT BE CHANGED");
                System.out.println("enter the row and coloum");
                row = scan.nextInt();
                coloumn= scan.nextInt();
                
            }else{
                break;
            }
        }
      
        int[] array = {number,row,coloumn};
        return array;

    }
    public static int randomnumber() {
        return(int)(Math.random()*8+1);
        
    }
    public static boolean CheckUserWin(){
        //logic
        return false;
    }
   
}