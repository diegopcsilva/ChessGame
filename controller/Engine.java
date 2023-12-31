package controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import model.AI;
import model.AIeasy;
import model.AIhard;
import model.AImedium;


public class Engine {
	
	Random gerador = new Random();
		
	int[][] board;
	private static int center;
	private static int corner;
	
	private static int row1;
	private static int row2;
	private static int row3;
	
	private static int column1;
	private static int column2;
	private static int column3;
	
	private static int inclined1;
	private static int inclined2;
	
	private List<AI> aiLevel = new ArrayList<AI>();
	AI ai;
	
	//public Random gerador;
	private boolean oneTime = false;
	private final int EMPTY		=0;
	private final int ROW_1		=0;
	private final int COLUMN_1	=0;
	private final int PC = 1;
	private final int ROW_2 = 1;
	private final int COLUMN_2 = 1;
	private final int ROW_3 = 2;
	private final int COLUMN_3 = 2;
	

	public Engine(int level, int[][] board){
		this.board = board;
		aiLevel.add(new AIeasy());
		aiLevel.add(new AImedium());
		aiLevel.add(new AIhard());
		ai = aiLevel.get(level);
		ai.updateScore(this.board);
	}
	
	public void update(){
		ai.updateScore(board);
		getAiData();
	}
	public int[][] moviment() {
		update();
		
		/*if (board[ROW_2][COLUMN_2]==EMPTY){
			board[ROW_2][COLUMN_2]=PC;
			return board;
		}
		if (round==1 && board[ROW_2][COLUMN_2]!=EMPTY){
			int mem = gerador.nextInt(4);
				if (mem == 0) board[ROW_1][COLUMN_1]=PC;
				if (mem == 1) board[ROW_3][COLUMN_1]=PC;
				if (mem == 2) board[ROW_1][COLUMN_3]=PC;
				if (mem == 3) board[ROW_3][COLUMN_3]=PC;
			return board;
		}*/
		
		List<Integer> scores = new ArrayList<Integer>();
			
		scores.add(center);
		if (!oneTime) scores.add(corner);
		else scores.add(0);
		scores.add(row1);
		scores.add(row2);
		scores.add(row3);
		scores.add(column1);
		scores.add(column2);
		scores.add(column3);
		scores.add(inclined1);
		scores.add(inclined2);
		
		int bigger = scores.get(gerador.nextInt(10));
		//System.out.printf("size %d\n",scores.size());
		//System.out.printf("bigger %d\n",bigger);
		
		for(int i = 0; i < scores.size();i++) {
			//System.out.println(bigger);
			if (bigger<scores.get(i)){
				//System.out.println("bingo");
					bigger = scores.get(i);
			}		
		}
		while(true){
			int random = gerador.nextInt(10);
			if (random == 0) {	
				if (center==bigger){
						board[ROW_2][COLUMN_2]=1;
						return board;
				}
			}
			if (random == 1) {
				
				if (corner==bigger){
					oneTime=true;//força que essa jogada aconteça uma vez só
					if(board[ROW_1][COLUMN_1]==EMPTY){
						board[ROW_1][COLUMN_1]=PC;
						return board;
					}
					if(board[ROW_1][COLUMN_3]==EMPTY){
						board[ROW_1][COLUMN_3]=PC;
						return board;
					}
					if(board[ROW_3][COLUMN_1]==EMPTY){
						board[ROW_3][COLUMN_1]=PC;
						return board;
					}
					if(board[ROW_3][COLUMN_3]==EMPTY){
						board[ROW_3][COLUMN_3]=PC;
						return board;
					}
				}
			}
			if (random == 2) {
				if (row1==bigger){
					if(board[ROW_1][COLUMN_1]==EMPTY){
						board[ROW_1][COLUMN_1]=PC;
						return board;
					}
					if(board[ROW_1][COLUMN_2]==EMPTY){
						board[ROW_1][COLUMN_2]=PC;
						return board;
					}
					if(board[ROW_1][COLUMN_3]==EMPTY){//invertido pra sair do fork
						board[ROW_1][COLUMN_3]=PC;
						return board;
					}				
				}
			}
			if (random == 3) {
				if (row2==bigger){
					if(board[ROW_2][COLUMN_1]==EMPTY){
						board[ROW_2][COLUMN_1]=PC;
						return board;
					}
					if(board[ROW_2][COLUMN_2]==EMPTY){
						board[ROW_2][COLUMN_2]=PC;
						return board;
					}
					if(board[ROW_2][COLUMN_3]==EMPTY){
						board[ROW_2][COLUMN_3]=PC;
						return board;
					}
				}
			}
			if (random == 4) {
				if (row3==bigger){
					if(board[ROW_3][COLUMN_1]==EMPTY){
						board[ROW_3][COLUMN_1]=PC;
						return board;
					}
					if(board[ROW_3][COLUMN_2]==EMPTY){
						board[ROW_3][COLUMN_2]=PC;
						return board;
					}
					if(board[ROW_3][COLUMN_3]==EMPTY){
						board[ROW_3][COLUMN_3]=PC;
						return board;
					}
				}
			}
			if (random == 5) {
				if (column1==bigger){
					if(board[ROW_1][COLUMN_1]==EMPTY){
						board[ROW_1][COLUMN_1]=PC;
						return board;
					}
					if(board[ROW_2][COLUMN_1]==EMPTY){
						board[ROW_2][COLUMN_1]=PC;
						return board;
					}
					if(board[ROW_3][COLUMN_1]==EMPTY){//invertido pra sair do fork
						board[ROW_3][COLUMN_1]=PC;
						return board;
					}
				}
			}
			if (random == 6) {
				if (column2==bigger){
					if(board[ROW_1][COLUMN_2]==EMPTY){
						board[ROW_1][COLUMN_2]=PC;
						return board;
					}
					if(board[ROW_2][COLUMN_2]==EMPTY){
						board[ROW_2][COLUMN_2]=PC;
						return board;
					}
					if(board[ROW_3][COLUMN_2]==EMPTY){
						board[ROW_3][COLUMN_2]=PC;
						return board;
					}
				}
			}
			if (random == 7) {
				if (column3==bigger){
					if(board[ROW_1][COLUMN_3]==EMPTY){
						board[ROW_1][COLUMN_3]=PC;
						return board;
					}
								
					if(board[ROW_3][COLUMN_3]==EMPTY){
						board[ROW_3][COLUMN_3]=PC;
						return board;
					}
					if(board[ROW_2][COLUMN_3]==EMPTY){
						board[ROW_2][COLUMN_3]=PC;
						return board;
					}	
				}
			}
			if (random == 8) {
				if (inclined1==bigger){
					if(board[ROW_1][COLUMN_1]==EMPTY){
						board[ROW_1][COLUMN_1]=PC;
						return board;
					}
					if(board[ROW_2][COLUMN_2]==EMPTY){
						board[ROW_2][COLUMN_2]=PC;
						return board;
					}
					if(board[ROW_3][COLUMN_3]==EMPTY){
						board[ROW_3][COLUMN_3]=PC;
						return board;
					}
				}
			}
			if (random == 9) {
				if (inclined2==bigger){
					if(board[ROW_1][COLUMN_3]==EMPTY){
						board[ROW_1][COLUMN_3]=PC;
						System.out.println("inclined2");
						return board;
					}
					if(board[ROW_2][COLUMN_2]==EMPTY){
						board[ROW_2][COLUMN_2]=PC;
						System.out.println("inclined2");
						return board;
					}
					if(board[ROW_3][COLUMN_1]==EMPTY){
						board[ROW_3][COLUMN_1]=PC;
						System.out.println("inclined2");
						return board;
					}
				}
			}
		}
	}
/*	public static void print(){//DEBUG//DEBUG//DEBUG//DEBUG
		System.out.println(center);
		System.out.println(corner);
		System.out.println(row1);
		System.out.println(row2);
		System.out.println(row3);
		System.out.println(column1);
		System.out.println(column2);
		System.out.println(column3);
		System.out.println(inclined1);
		System.out.println(inclined2);
	}
public void view(){//DEBUG//DEBUG//DEBUG
		
		for(int i=0;i<3;i++){
			
			System.out.printf("\n");
			
			for(int j=0;j<3;j++){
				
				System.out.printf("%d ",board[i][j]);	
			}
		}
		System.out.println();
	}*/

	public void getAiData(){
		center = ai.getCenter();
		corner = ai.getCorner();
		row1 = ai.getRow1();
		row2 = ai.getRow2();
		row3 = ai.getRow3();
		column1 = ai.getColumn1();
		column2 = ai.getColumn2();
		column3 = ai.getColumn3();
		inclined1 = ai.getInclined1();
		inclined2 = ai.getInclined2();
	}
	public static boolean velha(){
		if(row1==0 & row2==0 & row3==0 & column1==0 & column2==0 & column3==0 & inclined1==0 & inclined2==0){
			return true;
		}
		return false;
	}
	public static boolean aiWin(){
		if(row1==1000 || row2==1000 || row3==1000 || column1==1000 || column2==1000 || column3==1000 || inclined1==1000 || inclined2==1000){
			return true;
		}
		return false;
	}
	public static boolean playerWin(){
		if(row1==1001 || row2==1001 || row3==1001 || column1==1001 || column2==1001 || column3==1001 || inclined1==1001 || inclined2==1001){
			return true;
		}
		return false;
	}
}