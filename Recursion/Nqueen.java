package nqueen;
import java.io.*;
import java.util.*;

public class Nqueen {
    private static int board[][];
    private int numQueens;
    public Nqueen(){
        numQueens = 0;
        board = new int[8][8];
        for(int i=0;i<8;i++){
            for(int j=0;j<8;j++){
                board[i][j]=0;
            }
        }
    }
    public boolean solve(int numQueens){
        System.out.println();
        if(numQueens == 8){
            printBoard();
            
            return true;
        } else {
            for(int i=0;i<8;i++){
                for(int j=0;j<8;j++){
                    if(validMove(i,j)){
                        numQueens++;
                        placeQueen(i,j,true);
                        if(solve(numQueens)){//each time it calls for loop both and check valid an invalid location
                            return true;
                        } else {//this is backtacking code
                            numQueens--;
                            placeQueen(i,j,false);
                        }
                    }
                }
            }
        }
        return false;//this will triger back tracking
    }
    //it will check diagonal, horizontal and vertical line wheather the line placed or not
    public boolean validMove(int x,int y) {
        for(int k=0;k<8;k++){
            if(get(x,k)||get(k,y)||get(x-1,y-1)||get(x+1,y+1)||get(x-1,y+1)||get(x+1,y-1)){
                return false;
            }
        }
        return true;
       }
    //it will just place the queen
    public void placeQueen(int x,int y, boolean validMove){
        if(validMove){
            board[x][y] = 1;
        } else {
            board[x][y] = 0;
        }
       }
    //it check value are int the bound and return true if queen present at that location
    public boolean get(int x, int y){
        if(x<0||x>7||y<0||y>7){
        return false;
        }
        if(board[x][y]==1){
            return true;
        } 
        return false;
       }
    public void printBoard(){
        for(int i=0;i<8;i++){
            for(int j=0;j<8;j++){
                System.out.print(board[i][j]+" ");
            }
            System.out.println();
        }
       }
    
    public static void main(String[] args) {
        Nqueen board = new Nqueen();
        board.solve(0);
    }
    
}
