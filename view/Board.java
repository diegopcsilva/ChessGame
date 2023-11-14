package view;


public class Board {
	//private static final int PC = 0;

	//private static final int HUMAN = 0;

	private final int EMPTY		 = 0;

	private final int BLACKTOWER = 7;
	private final int BLACKKNIGHT= 3;
	private final int BLACKBISHOP= 5;
	private final int BLACKQUEEN = 9;
	private final int BLACKKING  = 11;
	private final int BLACKPAWN  = 1;
	
	private final int WHITETOWER = 8;
	private final int WHITEKNIGHT= 4;
	private final int WHITEBISHOP= 6;
	private final int WHITEQUEEN = 10;
	private final int WHITEKING  = 12;
	private final int WHITEPAWN  = 2;
	
	private final int ROW_1 	= 0;	
	private final int COLUMN_1  = 0;
	private final int ROW_2     = 1;
	private final int COLUMN_2  = 1;
	private final int ROW_3     = 2;
	private final int COLUMN_3  = 2;
	private final int ROW_4     = 3;
	private final int COLUMN_4  = 3;
	private final int ROW_5     = 4;
	private final int COLUMN_5  = 4;
	private final int ROW_6     = 5;
	private final int COLUMN_6  = 5;
	private final int ROW_7     = 6;
	private final int COLUMN_7  = 6;
	private final int ROW_8     = 7;
	private final int COLUMN_8  = 7;
	
	int board[][] = new int[8][8];
	
	public Board() {
		
		for(int i=0;i<8;i++){
			
			for(int j=0;j<8;j++){
				board[i][j]=0;	
			}
		}	
	}
	public int translatorCollum(char letter) {
		switch(letter) {
		case 'a':
			return 0;
		case 'b':
			return 1;
		case 'c':
			return 2;
		case 'd':
			return 3;
		case 'e':
			return 4;
		case 'f':
			return 5;
		case 'g':
			return 6;
		case 'h':
			return 7;
		}
		return letter;

	}
	public int translatorLine(int num) {
		switch(num) {
		case 1:
			return 7;
		case 2:
			return 6;
		case 3:
			return 5;
		case 4:
			return 4;
		case 5:
			return 3;
		case 6:
			return 2;
		case 7:
			return 1;
		case 8:
			return 0;
		}
		return num;

	}
	public void playerMove(char origemA,int origemB,char origemC,int origemD){
		//D 2 D 4 - 3(COLUM4) 6(ROW_7) - 
		while(canMove(translatorLine(origemB),translatorCollum(origemA),translatorLine(origemD),translatorCollum(origemC))) {
			System.out.printf("Moveu! Coluna origem:%d Linha Origem:%d Coluna Destino:%d Linha Destino:%d ",translatorCollum(origemA),translatorLine(origemB),translatorCollum(origemC),translatorLine(origemD));
		
			//linha anterior estava comentada

			board[translatorLine(origemD)][translatorCollum(origemC)]=board[translatorLine(origemB)][translatorCollum(origemA)];
			//aqui que de fato move a peça da origem pro destino somente se o canMove deixar
			//canMove(b);
			//apaga a peça da posição de origem
			board[translatorLine(origemB)][translatorCollum(origemA)]=EMPTY;
		break;
		}
	}
		
	public void viewDecimal(){
		//setupInicial();
		//System.out.printf("a \n");
		for(int i=0;i<8;i++){
			
			System.out.printf("\n");
			
			for(int j=0;j<8;j++){
				
				System.out.printf("%d ",board[i][j]);	
			}
		}
		System.out.println();
	}
		public int[][] getBoard() {
		return board;
	}
	public void setBoard(int[][] board) {
		this.board = board;
	}
	public void viewtest() {
		for(int i=0;i<8;i++){
			System.out.printf("\n");
			System.out.printf("_______________________\n");

			for(int j=0;j<8;j++){
				print(board[i][j]);
			}
		}
	}
	public void setupInicial() {
		board[0][0]=BLACKTOWER;
		board[0][1]=BLACKKNIGHT;
		board[0][2]=BLACKBISHOP;
		board[0][3]=BLACKQUEEN;
		board[0][4]=BLACKKING;
		board[0][5]=BLACKBISHOP;
		board[0][6]=BLACKKNIGHT;// VALOR ORIGINAL 3
		board[0][7]=BLACKTOWER;

		board[1][0]=BLACKPAWN;
		board[1][1]=BLACKPAWN;
		board[1][2]=BLACKPAWN;
		board[1][3]=BLACKPAWN;
		board[1][4]=BLACKPAWN;
		board[1][5]=BLACKPAWN;
		board[1][6]=BLACKPAWN;
		board[1][7]=BLACKPAWN;

		board[2][0]=EMPTY;
		board[2][1]=EMPTY;
		board[2][2]=EMPTY;
		board[2][3]=WHITEBISHOP;
		board[2][4]=EMPTY;
		board[2][5]=EMPTY;
		board[2][6]=EMPTY;
		board[2][7]=EMPTY;

		board[3][0]=EMPTY;
		board[3][1]=EMPTY;
		board[3][2]=WHITEPAWN;
		board[3][3]=EMPTY;
		board[3][4]=BLACKKNIGHT;
		board[3][5]=EMPTY;
		board[3][6]=EMPTY;
		board[3][7]=EMPTY;

		board[4][0]=EMPTY;
		board[4][1]=EMPTY;
		board[4][2]=EMPTY;
		board[4][3]=EMPTY;
		board[4][4]=WHITEBISHOP;
		board[4][5]=EMPTY;
		board[4][6]=EMPTY;
		board[4][7]=EMPTY;

		board[5][0]=EMPTY;
		board[5][1]=EMPTY;
		board[5][2]=EMPTY;
		board[5][3]=EMPTY;
		board[5][4]=EMPTY;
		board[5][5]=EMPTY;
		board[5][6]=EMPTY;
		board[5][7]=EMPTY;

		board[6][0]=EMPTY;//VALOR ORIGINAL 2
		board[6][1]=WHITEPAWN;
		board[6][2]=WHITEPAWN;
		board[6][3]=EMPTY;//VALOR ORIGINAL 2
		board[6][4]=WHITEPAWN;
		board[6][5]=WHITEPAWN;
		board[6][6]=WHITEPAWN;
		board[6][7]=WHITEPAWN;

		board[7][0]=WHITETOWER;
		board[7][1]=WHITEKNIGHT;
		board[7][2]=WHITEBISHOP;
		board[7][3]=WHITEQUEEN;
		board[7][4]=WHITEKING;
		board[7][5]=WHITEBISHOP;
		board[7][6]=WHITEKNIGHT;
		board[7][7]=WHITETOWER;
		
	}
	// IMPRIMINDO O TABULEIRO
	public void playerView(boolean change){
		
		if(change){//impressão do tabuleiro
			System.out.printf("  _______________________\n");
			System.out.print("8 ");
			if(board[ROW_1][COLUMN_1] == EMPTY)         System.out.print("  |");
			if(board[ROW_1][COLUMN_1] == BLACKTOWER)    System.out.print("BT|");
			if(board[ROW_1][COLUMN_1] == BLACKKNIGHT)   System.out.print("BN|");
			if(board[ROW_1][COLUMN_1] == BLACKBISHOP)   System.out.print("BB|");
			if(board[ROW_1][COLUMN_1] == BLACKQUEEN)    System.out.print("BQ|");
			if(board[ROW_1][COLUMN_1] == BLACKKING)     System.out.print("BK|");
			if(board[ROW_1][COLUMN_1] == BLACKPAWN)     System.out.print("BP|");
			if(board[ROW_1][COLUMN_1] == WHITETOWER)    System.out.print("WT|");
			if(board[ROW_1][COLUMN_1] == WHITEKNIGHT)   System.out.print("WN|");
			if(board[ROW_1][COLUMN_1] == WHITEBISHOP)   System.out.print("WB|");
			if(board[ROW_1][COLUMN_1] == WHITEQUEEN)    System.out.print("WQ|");
			if(board[ROW_1][COLUMN_1] == WHITEKING)     System.out.print("WK|");
			if(board[ROW_1][COLUMN_1] == WHITEPAWN)     System.out.print("WP|");
			if(board[ROW_1][COLUMN_2] == EMPTY)         System.out.print("  |");
			if(board[ROW_1][COLUMN_2] == BLACKTOWER)    System.out.print("BT|");
			if(board[ROW_1][COLUMN_2] == BLACKKNIGHT)   System.out.print("BN|");
			if(board[ROW_1][COLUMN_2] == BLACKBISHOP)   System.out.print("BB|");
			if(board[ROW_1][COLUMN_2] == BLACKQUEEN)    System.out.print("BQ|");
			if(board[ROW_1][COLUMN_2] == BLACKKING)     System.out.print("BK|");
			if(board[ROW_1][COLUMN_2] == BLACKPAWN)     System.out.print("BP|");
			if(board[ROW_1][COLUMN_2] == WHITETOWER)    System.out.print("WT|");
			if(board[ROW_1][COLUMN_2] == WHITEKNIGHT)   System.out.print("WN|");
			if(board[ROW_1][COLUMN_2] == WHITEBISHOP)   System.out.print("WB|");
			if(board[ROW_1][COLUMN_2] == WHITEQUEEN)    System.out.print("WQ|");
			if(board[ROW_1][COLUMN_2] == WHITEKING)     System.out.print("WK|");
			if(board[ROW_1][COLUMN_2] == WHITEPAWN)     System.out.print("WP|");
			if(board[ROW_1][COLUMN_3] == EMPTY)         System.out.print("  |");
			if(board[ROW_1][COLUMN_3] == BLACKTOWER)    System.out.print("BT|");
			if(board[ROW_1][COLUMN_3] == BLACKKNIGHT)   System.out.print("BN|");
			if(board[ROW_1][COLUMN_3] == BLACKBISHOP)   System.out.print("BB|");
			if(board[ROW_1][COLUMN_3] == BLACKQUEEN)    System.out.print("BQ|");
			if(board[ROW_1][COLUMN_3] == BLACKKING)     System.out.print("BK|");
			if(board[ROW_1][COLUMN_3] == BLACKPAWN)     System.out.print("BP|");
			if(board[ROW_1][COLUMN_3] == WHITETOWER)    System.out.print("WT|");
			if(board[ROW_1][COLUMN_3] == WHITEKNIGHT)   System.out.print("WN|");
			if(board[ROW_1][COLUMN_3] == WHITEBISHOP)   System.out.print("WB|");
			if(board[ROW_1][COLUMN_3] == WHITEQUEEN)    System.out.print("WQ|");
			if(board[ROW_1][COLUMN_3] == WHITEKING)     System.out.print("WK|");
			if(board[ROW_1][COLUMN_3] == WHITEPAWN)     System.out.print("WP|");
			if(board[ROW_1][COLUMN_4] == EMPTY)         System.out.print("  |");
			if(board[ROW_1][COLUMN_4] == BLACKTOWER)    System.out.print("BT|");
			if(board[ROW_1][COLUMN_4] == BLACKKNIGHT)   System.out.print("BN|");
			if(board[ROW_1][COLUMN_4] == BLACKBISHOP)   System.out.print("BB|");
			if(board[ROW_1][COLUMN_4] == BLACKQUEEN)    System.out.print("BQ|");
			if(board[ROW_1][COLUMN_4] == BLACKKING)     System.out.print("BK|");
			if(board[ROW_1][COLUMN_4] == BLACKPAWN)     System.out.print("BP|");
			if(board[ROW_1][COLUMN_4] == WHITETOWER)    System.out.print("WT|");
			if(board[ROW_1][COLUMN_4] == WHITEKNIGHT)   System.out.print("WN|");
			if(board[ROW_1][COLUMN_4] == WHITEBISHOP)   System.out.print("WB|");
			if(board[ROW_1][COLUMN_4] == WHITEQUEEN)    System.out.print("WQ|");
			if(board[ROW_1][COLUMN_4] == WHITEKING)     System.out.print("WK|");
			if(board[ROW_1][COLUMN_4] == WHITEPAWN)     System.out.print("WP|");
			if(board[ROW_1][COLUMN_5] == EMPTY)         System.out.print("  |");
			if(board[ROW_1][COLUMN_5] == BLACKTOWER)    System.out.print("BT|");
			if(board[ROW_1][COLUMN_5] == BLACKKNIGHT)   System.out.print("BN|");
			if(board[ROW_1][COLUMN_5] == BLACKBISHOP)   System.out.print("BB|");
			if(board[ROW_1][COLUMN_5] == BLACKQUEEN)    System.out.print("BQ|");
			if(board[ROW_1][COLUMN_5] == BLACKKING)     System.out.print("BK|");
			if(board[ROW_1][COLUMN_5] == BLACKPAWN)     System.out.print("BP|");
			if(board[ROW_1][COLUMN_5] == WHITETOWER)    System.out.print("WT|");
			if(board[ROW_1][COLUMN_5] == WHITEKNIGHT)   System.out.print("WN|");
			if(board[ROW_1][COLUMN_5] == WHITEBISHOP)   System.out.print("WB|");
			if(board[ROW_1][COLUMN_5] == WHITEQUEEN)    System.out.print("WQ|");
			if(board[ROW_1][COLUMN_5] == WHITEKING)     System.out.print("WK|");
			if(board[ROW_1][COLUMN_5] == WHITEPAWN)     System.out.print("WP|");
			if(board[ROW_1][COLUMN_6] == EMPTY)         System.out.print("  |");
			if(board[ROW_1][COLUMN_6] == BLACKTOWER)    System.out.print("BT|");
			if(board[ROW_1][COLUMN_6] == BLACKKNIGHT)   System.out.print("BN|");
			if(board[ROW_1][COLUMN_6] == BLACKBISHOP)   System.out.print("BB|");
			if(board[ROW_1][COLUMN_6] == BLACKQUEEN)    System.out.print("BQ|");
			if(board[ROW_1][COLUMN_6] == BLACKKING)     System.out.print("BK|");
			if(board[ROW_1][COLUMN_6] == BLACKPAWN)     System.out.print("BP|");
			if(board[ROW_1][COLUMN_6] == WHITETOWER)    System.out.print("WT|");
			if(board[ROW_1][COLUMN_6] == WHITEKNIGHT)   System.out.print("WN|");
			if(board[ROW_1][COLUMN_6] == WHITEBISHOP)   System.out.print("WB|");
			if(board[ROW_1][COLUMN_6] == WHITEQUEEN)    System.out.print("WQ|");
			if(board[ROW_1][COLUMN_6] == WHITEKING)     System.out.print("WK|");
			if(board[ROW_1][COLUMN_6] == WHITEPAWN)     System.out.print("WP|");
			if(board[ROW_1][COLUMN_7] == EMPTY)         System.out.print("  |");
			if(board[ROW_1][COLUMN_7] == BLACKTOWER)    System.out.print("BT|");
			if(board[ROW_1][COLUMN_7] == BLACKKNIGHT)   System.out.print("BN|");
			if(board[ROW_1][COLUMN_7] == BLACKBISHOP)   System.out.print("BB|");
			if(board[ROW_1][COLUMN_7] == BLACKQUEEN)    System.out.print("BQ|");
			if(board[ROW_1][COLUMN_7] == BLACKKING)     System.out.print("BK|");
			if(board[ROW_1][COLUMN_7] == BLACKPAWN)     System.out.print("BP|");
			if(board[ROW_1][COLUMN_7] == WHITETOWER)    System.out.print("WT|");
			if(board[ROW_1][COLUMN_7] == WHITEKNIGHT)   System.out.print("WN|");
			if(board[ROW_1][COLUMN_7] == WHITEBISHOP)   System.out.print("WB|");
			if(board[ROW_1][COLUMN_7] == WHITEQUEEN)    System.out.print("WQ|");
			if(board[ROW_1][COLUMN_7] == WHITEKING)     System.out.print("WK|");
			if(board[ROW_1][COLUMN_7] == WHITEPAWN)     System.out.print("WP|");
			if(board[ROW_1][COLUMN_8] == EMPTY)         System.out.print("  |\n");
			if(board[ROW_1][COLUMN_8] == BLACKTOWER)    System.out.print("BT|\n");
			if(board[ROW_1][COLUMN_8] == BLACKKNIGHT)   System.out.print("BN|\n");
			if(board[ROW_1][COLUMN_8] == BLACKBISHOP)   System.out.print("BB|\n");
			if(board[ROW_1][COLUMN_8] == BLACKQUEEN)    System.out.print("BQ|\n");
			if(board[ROW_1][COLUMN_8] == BLACKKING)     System.out.print("BK|\n");
			if(board[ROW_1][COLUMN_8] == BLACKPAWN)     System.out.print("BP|\n");
			if(board[ROW_1][COLUMN_8] == WHITETOWER)    System.out.print("WT|\n");
			if(board[ROW_1][COLUMN_8] == WHITEKNIGHT)   System.out.print("WN|\n");
			if(board[ROW_1][COLUMN_8] == WHITEBISHOP)   System.out.print("WB|\n");
			if(board[ROW_1][COLUMN_8] == WHITEQUEEN)    System.out.print("WQ|\n");
			if(board[ROW_1][COLUMN_8] == WHITEKING)     System.out.print("WK|\n");
			if(board[ROW_1][COLUMN_8] == WHITEPAWN)     System.out.print("WP|\n");
			System.out.printf("  _______________________\n");
			System.out.print("7 ");
			if(board[ROW_2][COLUMN_1] == EMPTY)         System.out.print("  |");
			if(board[ROW_2][COLUMN_1] == BLACKTOWER)    System.out.print("BT|");
			if(board[ROW_2][COLUMN_1] == BLACKKNIGHT)   System.out.print("BN|");
			if(board[ROW_2][COLUMN_1] == BLACKBISHOP)   System.out.print("BB|");
			if(board[ROW_2][COLUMN_1] == BLACKQUEEN)    System.out.print("BQ|");
			if(board[ROW_2][COLUMN_1] == BLACKKING)     System.out.print("BK|");
			if(board[ROW_2][COLUMN_1] == BLACKPAWN)     System.out.print("BP|");
			if(board[ROW_2][COLUMN_1] == WHITETOWER)    System.out.print("WT|");
			if(board[ROW_2][COLUMN_1] == WHITEKNIGHT)   System.out.print("WN|");
			if(board[ROW_2][COLUMN_1] == WHITEBISHOP)   System.out.print("WB|");
			if(board[ROW_2][COLUMN_1] == WHITEQUEEN)    System.out.print("WQ|");
			if(board[ROW_2][COLUMN_1] == WHITEKING)     System.out.print("WK|");
			if(board[ROW_2][COLUMN_1] == WHITEPAWN)     System.out.print("WP|");
			if(board[ROW_2][COLUMN_2] == EMPTY)         System.out.print("  |");
			if(board[ROW_2][COLUMN_2] == BLACKTOWER)    System.out.print("BT|");
			if(board[ROW_2][COLUMN_2] == BLACKKNIGHT)   System.out.print("BN|");
			if(board[ROW_2][COLUMN_2] == BLACKBISHOP)   System.out.print("BB|");
			if(board[ROW_2][COLUMN_2] == BLACKQUEEN)    System.out.print("BQ|");
			if(board[ROW_2][COLUMN_2] == BLACKKING)     System.out.print("BK|");
			if(board[ROW_2][COLUMN_2] == BLACKPAWN)     System.out.print("BP|");
			if(board[ROW_2][COLUMN_2] == WHITETOWER)    System.out.print("WT|");
			if(board[ROW_2][COLUMN_2] == WHITEKNIGHT)   System.out.print("WN|");
			if(board[ROW_2][COLUMN_2] == WHITEBISHOP)   System.out.print("WB|");
			if(board[ROW_2][COLUMN_2] == WHITEQUEEN)    System.out.print("WQ|");
			if(board[ROW_2][COLUMN_2] == WHITEKING)     System.out.print("WK|");
			if(board[ROW_2][COLUMN_2] == WHITEPAWN)     System.out.print("WP|");
			if(board[ROW_2][COLUMN_3] == EMPTY)         System.out.print("  |");
			if(board[ROW_2][COLUMN_3] == BLACKTOWER)    System.out.print("BT|");
			if(board[ROW_2][COLUMN_3] == BLACKKNIGHT)   System.out.print("BN|");
			if(board[ROW_2][COLUMN_3] == BLACKBISHOP)   System.out.print("BB|");
			if(board[ROW_2][COLUMN_3] == BLACKQUEEN)    System.out.print("BQ|");
			if(board[ROW_2][COLUMN_3] == BLACKKING)     System.out.print("BK|");
			if(board[ROW_2][COLUMN_3] == BLACKPAWN)     System.out.print("BP|");
			if(board[ROW_2][COLUMN_3] == WHITETOWER)    System.out.print("WT|");
			if(board[ROW_2][COLUMN_3] == WHITEKNIGHT)   System.out.print("WN|");
			if(board[ROW_2][COLUMN_3] == WHITEBISHOP)   System.out.print("WB|");
			if(board[ROW_2][COLUMN_3] == WHITEQUEEN)    System.out.print("WQ|");
			if(board[ROW_2][COLUMN_3] == WHITEKING)     System.out.print("WK|");
			if(board[ROW_2][COLUMN_3] == WHITEPAWN)     System.out.print("WP|");
			if(board[ROW_2][COLUMN_4] == EMPTY)         System.out.print("  |");
			if(board[ROW_2][COLUMN_4] == BLACKTOWER)    System.out.print("BT|");
			if(board[ROW_2][COLUMN_4] == BLACKKNIGHT)   System.out.print("BN|");
			if(board[ROW_2][COLUMN_4] == BLACKBISHOP)   System.out.print("BB|");
			if(board[ROW_2][COLUMN_4] == BLACKQUEEN)    System.out.print("BQ|");
			if(board[ROW_2][COLUMN_4] == BLACKKING)     System.out.print("BK|");
			if(board[ROW_2][COLUMN_4] == BLACKPAWN)     System.out.print("BP|");
			if(board[ROW_2][COLUMN_4] == WHITETOWER)    System.out.print("WT|");
			if(board[ROW_2][COLUMN_4] == WHITEKNIGHT)   System.out.print("WN|");
			if(board[ROW_2][COLUMN_4] == WHITEBISHOP)   System.out.print("WB|");
			if(board[ROW_2][COLUMN_4] == WHITEQUEEN)    System.out.print("WQ|");
			if(board[ROW_2][COLUMN_4] == WHITEKING)     System.out.print("WK|");
			if(board[ROW_2][COLUMN_4] == WHITEPAWN)     System.out.print("WP|");
			if(board[ROW_2][COLUMN_5] == EMPTY)         System.out.print("  |");
			if(board[ROW_2][COLUMN_5] == BLACKTOWER)    System.out.print("BT|");
			if(board[ROW_2][COLUMN_5] == BLACKKNIGHT)   System.out.print("BN|");
			if(board[ROW_2][COLUMN_5] == BLACKBISHOP)   System.out.print("BB|");
			if(board[ROW_2][COLUMN_5] == BLACKQUEEN)    System.out.print("BQ|");
			if(board[ROW_2][COLUMN_5] == BLACKKING)     System.out.print("BK|");
			if(board[ROW_2][COLUMN_5] == BLACKPAWN)     System.out.print("BP|");
			if(board[ROW_2][COLUMN_5] == WHITETOWER)    System.out.print("WT|");
			if(board[ROW_2][COLUMN_5] == WHITEKNIGHT)   System.out.print("WN|");
			if(board[ROW_2][COLUMN_5] == WHITEBISHOP)   System.out.print("WB|");
			if(board[ROW_2][COLUMN_5] == WHITEQUEEN)    System.out.print("WQ|");
			if(board[ROW_2][COLUMN_5] == WHITEKING)     System.out.print("WK|");
			if(board[ROW_2][COLUMN_5] == WHITEPAWN)     System.out.print("WP|");
			if(board[ROW_2][COLUMN_6] == EMPTY)         System.out.print("  |");
			if(board[ROW_2][COLUMN_6] == BLACKTOWER)    System.out.print("BT|");
			if(board[ROW_2][COLUMN_6] == BLACKKNIGHT)   System.out.print("BN|");
			if(board[ROW_2][COLUMN_6] == BLACKBISHOP)   System.out.print("BB|");
			if(board[ROW_2][COLUMN_6] == BLACKQUEEN)    System.out.print("BQ|");
			if(board[ROW_2][COLUMN_6] == BLACKKING)     System.out.print("BK|");
			if(board[ROW_2][COLUMN_6] == BLACKPAWN)     System.out.print("BP|");
			if(board[ROW_2][COLUMN_6] == WHITETOWER)    System.out.print("WT|");
			if(board[ROW_2][COLUMN_6] == WHITEKNIGHT)   System.out.print("WN|");
			if(board[ROW_2][COLUMN_6] == WHITEBISHOP)   System.out.print("WB|");
			if(board[ROW_2][COLUMN_6] == WHITEQUEEN)    System.out.print("WQ|");
			if(board[ROW_2][COLUMN_6] == WHITEKING)     System.out.print("WK|");
			if(board[ROW_2][COLUMN_6] == WHITEPAWN)     System.out.print("WP|");
			if(board[ROW_2][COLUMN_7] == EMPTY)         System.out.print("  |");
			if(board[ROW_2][COLUMN_7] == BLACKTOWER)    System.out.print("BT|");
			if(board[ROW_2][COLUMN_7] == BLACKKNIGHT)   System.out.print("BN|");
			if(board[ROW_2][COLUMN_7] == BLACKBISHOP)   System.out.print("BB|");
			if(board[ROW_2][COLUMN_7] == BLACKQUEEN)    System.out.print("BQ|");
			if(board[ROW_2][COLUMN_7] == BLACKKING)     System.out.print("BK|");
			if(board[ROW_2][COLUMN_7] == BLACKPAWN)     System.out.print("BP|");
			if(board[ROW_2][COLUMN_7] == WHITETOWER)    System.out.print("WT|");
			if(board[ROW_2][COLUMN_7] == WHITEKNIGHT)   System.out.print("WN|");
			if(board[ROW_2][COLUMN_7] == WHITEBISHOP)   System.out.print("WB|");
			if(board[ROW_2][COLUMN_7] == WHITEQUEEN)    System.out.print("WQ|");
			if(board[ROW_2][COLUMN_7] == WHITEKING)     System.out.print("WK|");
			if(board[ROW_2][COLUMN_7] == WHITEPAWN)     System.out.print("WP|");
			if(board[ROW_2][COLUMN_8] == EMPTY)         System.out.print("  |\n");
			if(board[ROW_2][COLUMN_8] == BLACKTOWER)    System.out.print("BT|\n");
			if(board[ROW_2][COLUMN_8] == BLACKKNIGHT)   System.out.print("BN|\n");
			if(board[ROW_2][COLUMN_8] == BLACKBISHOP)   System.out.print("BB|\n");
			if(board[ROW_2][COLUMN_8] == BLACKQUEEN)    System.out.print("BQ|\n");
			if(board[ROW_2][COLUMN_8] == BLACKKING)     System.out.print("BK|\n");
			if(board[ROW_2][COLUMN_8] == BLACKPAWN)     System.out.print("BP|\n");
			if(board[ROW_2][COLUMN_8] == WHITETOWER)    System.out.print("WT|\n");
			if(board[ROW_2][COLUMN_8] == WHITEKNIGHT)   System.out.print("WN|\n");
			if(board[ROW_2][COLUMN_8] == WHITEBISHOP)   System.out.print("WB|\n");
			if(board[ROW_2][COLUMN_8] == WHITEQUEEN)    System.out.print("WQ|\n");
			if(board[ROW_2][COLUMN_8] == WHITEKING)     System.out.print("WK|\n");
			if(board[ROW_2][COLUMN_8] == WHITEPAWN)     System.out.print("WP|\n");
			System.out.printf("  _______________________\n");
			System.out.print("6 ");
			if(board[ROW_3][COLUMN_1] == EMPTY)         System.out.print("  |");
			if(board[ROW_3][COLUMN_1] == BLACKTOWER)    System.out.print("BT|");
			if(board[ROW_3][COLUMN_1] == BLACKKNIGHT)   System.out.print("BN|");
			if(board[ROW_3][COLUMN_1] == BLACKBISHOP)   System.out.print("BB|");
			if(board[ROW_3][COLUMN_1] == BLACKQUEEN)    System.out.print("BQ|");
			if(board[ROW_3][COLUMN_1] == BLACKKING)     System.out.print("BK|");
			if(board[ROW_3][COLUMN_1] == BLACKPAWN)     System.out.print("BP|");
			if(board[ROW_3][COLUMN_1] == WHITETOWER)    System.out.print("WT|");
			if(board[ROW_3][COLUMN_1] == WHITEKNIGHT)   System.out.print("WN|");
			if(board[ROW_3][COLUMN_1] == WHITEBISHOP)   System.out.print("WB|");
			if(board[ROW_3][COLUMN_1] == WHITEQUEEN)    System.out.print("WQ|");
			if(board[ROW_3][COLUMN_1] == WHITEKING)     System.out.print("WK|");
			if(board[ROW_3][COLUMN_1] == WHITEPAWN)     System.out.print("WP|");
			if(board[ROW_3][COLUMN_2] == EMPTY)         System.out.print("  |");
			if(board[ROW_3][COLUMN_2] == BLACKTOWER)    System.out.print("BT|");
			if(board[ROW_3][COLUMN_2] == BLACKKNIGHT)   System.out.print("BN|");
			if(board[ROW_3][COLUMN_2] == BLACKBISHOP)   System.out.print("BB|");
			if(board[ROW_3][COLUMN_2] == BLACKQUEEN)    System.out.print("BQ|");
			if(board[ROW_3][COLUMN_2] == BLACKKING)     System.out.print("BK|");
			if(board[ROW_3][COLUMN_2] == BLACKPAWN)     System.out.print("BP|");
			if(board[ROW_3][COLUMN_2] == WHITETOWER)    System.out.print("WT|");
			if(board[ROW_3][COLUMN_2] == WHITEKNIGHT)   System.out.print("WN|");
			if(board[ROW_3][COLUMN_2] == WHITEBISHOP)   System.out.print("WB|");
			if(board[ROW_3][COLUMN_2] == WHITEQUEEN)    System.out.print("WQ|");
			if(board[ROW_3][COLUMN_2] == WHITEKING)     System.out.print("WK|");
			if(board[ROW_3][COLUMN_2] == WHITEPAWN)     System.out.print("WP|");
			if(board[ROW_3][COLUMN_3] == EMPTY)         System.out.print("  |");
			if(board[ROW_3][COLUMN_3] == BLACKTOWER)    System.out.print("BT|");
			if(board[ROW_3][COLUMN_3] == BLACKKNIGHT)   System.out.print("BN|");
			if(board[ROW_3][COLUMN_3] == BLACKBISHOP)   System.out.print("BB|");
			if(board[ROW_3][COLUMN_3] == BLACKQUEEN)    System.out.print("BQ|");
			if(board[ROW_3][COLUMN_3] == BLACKKING)     System.out.print("BK|");
			if(board[ROW_3][COLUMN_3] == BLACKPAWN)     System.out.print("BP|");
			if(board[ROW_3][COLUMN_3] == WHITETOWER)    System.out.print("WT|");
			if(board[ROW_3][COLUMN_3] == WHITEKNIGHT)   System.out.print("WN|");
			if(board[ROW_3][COLUMN_3] == WHITEBISHOP)   System.out.print("WB|");
			if(board[ROW_3][COLUMN_3] == WHITEQUEEN)    System.out.print("WQ|");
			if(board[ROW_3][COLUMN_3] == WHITEKING)     System.out.print("WK|");
			if(board[ROW_3][COLUMN_3] == WHITEPAWN)     System.out.print("WP|");
			if(board[ROW_3][COLUMN_4] == EMPTY)         System.out.print("  |");
			if(board[ROW_3][COLUMN_4] == BLACKTOWER)    System.out.print("BT|");
			if(board[ROW_3][COLUMN_4] == BLACKKNIGHT)   System.out.print("BN|");
			if(board[ROW_3][COLUMN_4] == BLACKBISHOP)   System.out.print("BB|");
			if(board[ROW_3][COLUMN_4] == BLACKQUEEN)    System.out.print("BQ|");
			if(board[ROW_3][COLUMN_4] == BLACKKING)     System.out.print("BK|");
			if(board[ROW_3][COLUMN_4] == BLACKPAWN)     System.out.print("BP|");
			if(board[ROW_3][COLUMN_4] == WHITETOWER)    System.out.print("WT|");
			if(board[ROW_3][COLUMN_4] == WHITEKNIGHT)   System.out.print("WN|");
			if(board[ROW_3][COLUMN_4] == WHITEBISHOP)   System.out.print("WB|");
			if(board[ROW_3][COLUMN_4] == WHITEQUEEN)    System.out.print("WQ|");
			if(board[ROW_3][COLUMN_4] == WHITEKING)     System.out.print("WK|");
			if(board[ROW_3][COLUMN_4] == WHITEPAWN)     System.out.print("WP|");
			if(board[ROW_3][COLUMN_5] == EMPTY)         System.out.print("  |");
			if(board[ROW_3][COLUMN_5] == BLACKTOWER)    System.out.print("BT|");
			if(board[ROW_3][COLUMN_5] == BLACKKNIGHT)   System.out.print("BN|");
			if(board[ROW_3][COLUMN_5] == BLACKBISHOP)   System.out.print("BB|");
			if(board[ROW_3][COLUMN_5] == BLACKQUEEN)    System.out.print("BQ|");
			if(board[ROW_3][COLUMN_5] == BLACKKING)     System.out.print("BK|");
			if(board[ROW_3][COLUMN_5] == BLACKPAWN)     System.out.print("BP|");
			if(board[ROW_3][COLUMN_5] == WHITETOWER)    System.out.print("WT|");
			if(board[ROW_3][COLUMN_5] == WHITEKNIGHT)   System.out.print("WN|");
			if(board[ROW_3][COLUMN_5] == WHITEBISHOP)   System.out.print("WB|");
			if(board[ROW_3][COLUMN_5] == WHITEQUEEN)    System.out.print("WQ|");
			if(board[ROW_3][COLUMN_5] == WHITEKING)     System.out.print("WK|");
			if(board[ROW_3][COLUMN_5] == WHITEPAWN)     System.out.print("WP|");
			if(board[ROW_3][COLUMN_6] == EMPTY)         System.out.print("  |");
			if(board[ROW_3][COLUMN_6] == BLACKTOWER)    System.out.print("BT|");
			if(board[ROW_3][COLUMN_6] == BLACKKNIGHT)   System.out.print("BN|");
			if(board[ROW_3][COLUMN_6] == BLACKBISHOP)   System.out.print("BB|");
			if(board[ROW_3][COLUMN_6] == BLACKQUEEN)    System.out.print("BQ|");
			if(board[ROW_3][COLUMN_6] == BLACKKING)     System.out.print("BK|");
			if(board[ROW_3][COLUMN_6] == BLACKPAWN)     System.out.print("BP|");
			if(board[ROW_3][COLUMN_6] == WHITETOWER)    System.out.print("WT|");
			if(board[ROW_3][COLUMN_6] == WHITEKNIGHT)   System.out.print("WN|");
			if(board[ROW_3][COLUMN_6] == WHITEBISHOP)   System.out.print("WB|");
			if(board[ROW_3][COLUMN_6] == WHITEQUEEN)    System.out.print("WQ|");
			if(board[ROW_3][COLUMN_6] == WHITEKING)     System.out.print("WK|");
			if(board[ROW_3][COLUMN_6] == WHITEPAWN)     System.out.print("WP|");
			if(board[ROW_3][COLUMN_7] == EMPTY)         System.out.print("  |");
			if(board[ROW_3][COLUMN_7] == BLACKTOWER)    System.out.print("BT|");
			if(board[ROW_3][COLUMN_7] == BLACKKNIGHT)   System.out.print("BN|");
			if(board[ROW_3][COLUMN_7] == BLACKBISHOP)   System.out.print("BB|");
			if(board[ROW_3][COLUMN_7] == BLACKQUEEN)    System.out.print("BQ|");
			if(board[ROW_3][COLUMN_7] == BLACKKING)     System.out.print("BK|");
			if(board[ROW_3][COLUMN_7] == BLACKPAWN)     System.out.print("BP|");
			if(board[ROW_3][COLUMN_7] == WHITETOWER)    System.out.print("WT|");
			if(board[ROW_3][COLUMN_7] == WHITEKNIGHT)   System.out.print("WN|");
			if(board[ROW_3][COLUMN_7] == WHITEBISHOP)   System.out.print("WB|");
			if(board[ROW_3][COLUMN_7] == WHITEQUEEN)    System.out.print("WQ|");
			if(board[ROW_3][COLUMN_7] == WHITEKING)     System.out.print("WK|");
			if(board[ROW_3][COLUMN_7] == WHITEPAWN)     System.out.print("WP|");
			if(board[ROW_3][COLUMN_8] == EMPTY)         System.out.print("  |\n");
			if(board[ROW_3][COLUMN_8] == BLACKTOWER)    System.out.print("BT|\n");
			if(board[ROW_3][COLUMN_8] == BLACKKNIGHT)   System.out.print("BN|\n");
			if(board[ROW_3][COLUMN_8] == BLACKBISHOP)   System.out.print("BB|\n");
			if(board[ROW_3][COLUMN_8] == BLACKQUEEN)    System.out.print("BQ|\n");
			if(board[ROW_3][COLUMN_8] == BLACKKING)     System.out.print("BK|\n");
			if(board[ROW_3][COLUMN_8] == BLACKPAWN)     System.out.print("BP|\n");
			if(board[ROW_3][COLUMN_8] == WHITETOWER)    System.out.print("WT|\n");
			if(board[ROW_3][COLUMN_8] == WHITEKNIGHT)   System.out.print("WN|\n");
			if(board[ROW_3][COLUMN_8] == WHITEBISHOP)   System.out.print("WB|\n");
			if(board[ROW_3][COLUMN_8] == WHITEQUEEN)    System.out.print("WQ|\n");
			if(board[ROW_3][COLUMN_8] == WHITEKING)     System.out.print("WK|\n");
			if(board[ROW_3][COLUMN_8] == WHITEPAWN)     System.out.print("WP|\n");
			System.out.printf("  _______________________\n");
			System.out.print("5 ");
			if(board[ROW_4][COLUMN_1] == EMPTY)         System.out.print("  |");
			if(board[ROW_4][COLUMN_1] == BLACKTOWER)    System.out.print("BT|");
			if(board[ROW_4][COLUMN_1] == BLACKKNIGHT)   System.out.print("BN|");
			if(board[ROW_4][COLUMN_1] == BLACKBISHOP)   System.out.print("BB|");
			if(board[ROW_4][COLUMN_1] == BLACKQUEEN)    System.out.print("BQ|");
			if(board[ROW_4][COLUMN_1] == BLACKKING)     System.out.print("BK|");
			if(board[ROW_4][COLUMN_1] == BLACKPAWN)     System.out.print("BP|");
			if(board[ROW_4][COLUMN_1] == WHITETOWER)    System.out.print("WT|");
			if(board[ROW_4][COLUMN_1] == WHITEKNIGHT)   System.out.print("WN|");
			if(board[ROW_4][COLUMN_1] == WHITEBISHOP)   System.out.print("WB|");
			if(board[ROW_4][COLUMN_1] == WHITEQUEEN)    System.out.print("WQ|");
			if(board[ROW_4][COLUMN_1] == WHITEKING)     System.out.print("WK|");
			if(board[ROW_4][COLUMN_1] == WHITEPAWN)     System.out.print("WP|");
			if(board[ROW_4][COLUMN_2] == EMPTY)         System.out.print("  |");
			if(board[ROW_4][COLUMN_2] == BLACKTOWER)    System.out.print("BT|");
			if(board[ROW_4][COLUMN_2] == BLACKKNIGHT)   System.out.print("BN|");
			if(board[ROW_4][COLUMN_2] == BLACKBISHOP)   System.out.print("BB|");
			if(board[ROW_4][COLUMN_2] == BLACKQUEEN)    System.out.print("BQ|");
			if(board[ROW_4][COLUMN_2] == BLACKKING)     System.out.print("BK|");
			if(board[ROW_4][COLUMN_2] == BLACKPAWN)     System.out.print("BP|");
			if(board[ROW_4][COLUMN_2] == WHITETOWER)    System.out.print("WT|");
			if(board[ROW_4][COLUMN_2] == WHITEKNIGHT)   System.out.print("WN|");
			if(board[ROW_4][COLUMN_2] == WHITEBISHOP)   System.out.print("WB|");
			if(board[ROW_4][COLUMN_2] == WHITEQUEEN)    System.out.print("WQ|");
			if(board[ROW_4][COLUMN_2] == WHITEKING)     System.out.print("WK|");
			if(board[ROW_4][COLUMN_2] == WHITEPAWN)     System.out.print("WP|");
			if(board[ROW_4][COLUMN_3] == EMPTY)         System.out.print("  |");
			if(board[ROW_4][COLUMN_3] == BLACKTOWER)    System.out.print("BT|");
			if(board[ROW_4][COLUMN_3] == BLACKKNIGHT)   System.out.print("BN|");
			if(board[ROW_4][COLUMN_3] == BLACKBISHOP)   System.out.print("BB|");
			if(board[ROW_4][COLUMN_3] == BLACKQUEEN)    System.out.print("BQ|");
			if(board[ROW_4][COLUMN_3] == BLACKKING)     System.out.print("BK|");
			if(board[ROW_4][COLUMN_3] == BLACKPAWN)     System.out.print("BP|");
			if(board[ROW_4][COLUMN_3] == WHITETOWER)    System.out.print("WT|");
			if(board[ROW_4][COLUMN_3] == WHITEKNIGHT)   System.out.print("WN|");
			if(board[ROW_4][COLUMN_3] == WHITEBISHOP)   System.out.print("WB|");
			if(board[ROW_4][COLUMN_3] == WHITEQUEEN)    System.out.print("WQ|");
			if(board[ROW_4][COLUMN_3] == WHITEKING)     System.out.print("WK|");
			if(board[ROW_4][COLUMN_3] == WHITEPAWN)     System.out.print("WP|");
			if(board[ROW_4][COLUMN_4] == EMPTY)         System.out.print("  |");
			if(board[ROW_4][COLUMN_4] == BLACKTOWER)    System.out.print("BT|");
			if(board[ROW_4][COLUMN_4] == BLACKKNIGHT)   System.out.print("BN|");
			if(board[ROW_4][COLUMN_4] == BLACKBISHOP)   System.out.print("BB|");
			if(board[ROW_4][COLUMN_4] == BLACKQUEEN)    System.out.print("BQ|");
			if(board[ROW_4][COLUMN_4] == BLACKKING)     System.out.print("BK|");
			if(board[ROW_4][COLUMN_4] == BLACKPAWN)     System.out.print("BP|");
			if(board[ROW_4][COLUMN_4] == WHITETOWER)    System.out.print("WT|");
			if(board[ROW_4][COLUMN_4] == WHITEKNIGHT)   System.out.print("WN|");
			if(board[ROW_4][COLUMN_4] == WHITEBISHOP)   System.out.print("WB|");
			if(board[ROW_4][COLUMN_4] == WHITEQUEEN)    System.out.print("WQ|");
			if(board[ROW_4][COLUMN_4] == WHITEKING)     System.out.print("WK|");
			if(board[ROW_4][COLUMN_4] == WHITEPAWN)     System.out.print("WP|");
			if(board[ROW_4][COLUMN_5] == EMPTY)         System.out.print("  |");
			if(board[ROW_4][COLUMN_5] == BLACKTOWER)    System.out.print("BT|");
			if(board[ROW_4][COLUMN_5] == BLACKKNIGHT)   System.out.print("BN|");
			if(board[ROW_4][COLUMN_5] == BLACKBISHOP)   System.out.print("BB|");
			if(board[ROW_4][COLUMN_5] == BLACKQUEEN)    System.out.print("BQ|");
			if(board[ROW_4][COLUMN_5] == BLACKKING)     System.out.print("BK|");
			if(board[ROW_4][COLUMN_5] == BLACKPAWN)     System.out.print("BP|");
			if(board[ROW_4][COLUMN_5] == WHITETOWER)    System.out.print("WT|");
			if(board[ROW_4][COLUMN_5] == WHITEKNIGHT)   System.out.print("WN|");
			if(board[ROW_4][COLUMN_5] == WHITEBISHOP)   System.out.print("WB|");
			if(board[ROW_4][COLUMN_5] == WHITEQUEEN)    System.out.print("WQ|");
			if(board[ROW_4][COLUMN_5] == WHITEKING)     System.out.print("WK|");
			if(board[ROW_4][COLUMN_5] == WHITEPAWN)     System.out.print("WP|");
			if(board[ROW_4][COLUMN_6] == EMPTY)         System.out.print("  |");
			if(board[ROW_4][COLUMN_6] == BLACKTOWER)    System.out.print("BT|");
			if(board[ROW_4][COLUMN_6] == BLACKKNIGHT)   System.out.print("BN|");
			if(board[ROW_4][COLUMN_6] == BLACKBISHOP)   System.out.print("BB|");
			if(board[ROW_4][COLUMN_6] == BLACKQUEEN)    System.out.print("BQ|");
			if(board[ROW_4][COLUMN_6] == BLACKKING)     System.out.print("BK|");
			if(board[ROW_4][COLUMN_6] == BLACKPAWN)     System.out.print("BP|");
			if(board[ROW_4][COLUMN_6] == WHITETOWER)    System.out.print("WT|");
			if(board[ROW_4][COLUMN_6] == WHITEKNIGHT)   System.out.print("WN|");
			if(board[ROW_4][COLUMN_6] == WHITEBISHOP)   System.out.print("WB|");
			if(board[ROW_4][COLUMN_6] == WHITEQUEEN)    System.out.print("WQ|");
			if(board[ROW_4][COLUMN_6] == WHITEKING)     System.out.print("WK|");
			if(board[ROW_4][COLUMN_6] == WHITEPAWN)     System.out.print("WP|");
			if(board[ROW_4][COLUMN_7] == EMPTY)         System.out.print("  |");
			if(board[ROW_4][COLUMN_7] == BLACKTOWER)    System.out.print("BT|");
			if(board[ROW_4][COLUMN_7] == BLACKKNIGHT)   System.out.print("BN|");
			if(board[ROW_4][COLUMN_7] == BLACKBISHOP)   System.out.print("BB|");
			if(board[ROW_4][COLUMN_7] == BLACKQUEEN)    System.out.print("BQ|");
			if(board[ROW_4][COLUMN_7] == BLACKKING)     System.out.print("BK|");
			if(board[ROW_4][COLUMN_7] == BLACKPAWN)     System.out.print("BP|");
			if(board[ROW_4][COLUMN_7] == WHITETOWER)    System.out.print("WT|");
			if(board[ROW_4][COLUMN_7] == WHITEKNIGHT)   System.out.print("WN|");
			if(board[ROW_4][COLUMN_7] == WHITEBISHOP)   System.out.print("WB|");
			if(board[ROW_4][COLUMN_7] == WHITEQUEEN)    System.out.print("WQ|");
			if(board[ROW_4][COLUMN_7] == WHITEKING)     System.out.print("WK|");
			if(board[ROW_4][COLUMN_7] == WHITEPAWN)     System.out.print("WP|");
			if(board[ROW_4][COLUMN_8] == EMPTY)         System.out.print("  |\n");
			if(board[ROW_4][COLUMN_8] == BLACKTOWER)    System.out.print("BT|\n");
			if(board[ROW_4][COLUMN_8] == BLACKKNIGHT)   System.out.print("BN|\n");
			if(board[ROW_4][COLUMN_8] == BLACKBISHOP)   System.out.print("BB|\n");
			if(board[ROW_4][COLUMN_8] == BLACKQUEEN)    System.out.print("BQ|\n");
			if(board[ROW_4][COLUMN_8] == BLACKKING)     System.out.print("BK|\n");
			if(board[ROW_4][COLUMN_8] == BLACKPAWN)     System.out.print("BP|\n");
			if(board[ROW_4][COLUMN_8] == WHITETOWER)    System.out.print("WT|\n");
			if(board[ROW_4][COLUMN_8] == WHITEKNIGHT)   System.out.print("WN|\n");
			if(board[ROW_4][COLUMN_8] == WHITEBISHOP)   System.out.print("WB|\n");
			if(board[ROW_4][COLUMN_8] == WHITEQUEEN)    System.out.print("WQ|\n");
			if(board[ROW_4][COLUMN_8] == WHITEKING)     System.out.print("WK|\n");
			if(board[ROW_4][COLUMN_8] == WHITEPAWN)     System.out.print("WP|\n");
			System.out.printf("  _______________________\n");
			System.out.print("4 ");
			if(board[ROW_5][COLUMN_1] == EMPTY)         System.out.print("  |");
			if(board[ROW_5][COLUMN_1] == BLACKTOWER)    System.out.print("BT|");
			if(board[ROW_5][COLUMN_1] == BLACKKNIGHT)   System.out.print("BN|");
			if(board[ROW_5][COLUMN_1] == BLACKBISHOP)   System.out.print("BB|");
			if(board[ROW_5][COLUMN_1] == BLACKQUEEN)    System.out.print("BQ|");
			if(board[ROW_5][COLUMN_1] == BLACKKING)     System.out.print("BK|");
			if(board[ROW_5][COLUMN_1] == BLACKPAWN)     System.out.print("BP|");
			if(board[ROW_5][COLUMN_1] == WHITETOWER)    System.out.print("WT|");
			if(board[ROW_5][COLUMN_1] == WHITEKNIGHT)   System.out.print("WN|");
			if(board[ROW_5][COLUMN_1] == WHITEBISHOP)   System.out.print("WB|");
			if(board[ROW_5][COLUMN_1] == WHITEQUEEN)    System.out.print("WQ|");
			if(board[ROW_5][COLUMN_1] == WHITEKING)     System.out.print("WK|");
			if(board[ROW_5][COLUMN_1] == WHITEPAWN)     System.out.print("WP|");
			if(board[ROW_5][COLUMN_2] == EMPTY)         System.out.print("  |");
			if(board[ROW_5][COLUMN_2] == BLACKTOWER)    System.out.print("BT|");
			if(board[ROW_5][COLUMN_2] == BLACKKNIGHT)   System.out.print("BN|");
			if(board[ROW_5][COLUMN_2] == BLACKBISHOP)   System.out.print("BB|");
			if(board[ROW_5][COLUMN_2] == BLACKQUEEN)    System.out.print("BQ|");
			if(board[ROW_5][COLUMN_2] == BLACKKING)     System.out.print("BK|");
			if(board[ROW_5][COLUMN_2] == BLACKPAWN)     System.out.print("BP|");
			if(board[ROW_5][COLUMN_2] == WHITETOWER)    System.out.print("WT|");
			if(board[ROW_5][COLUMN_2] == WHITEKNIGHT)   System.out.print("WN|");
			if(board[ROW_5][COLUMN_2] == WHITEBISHOP)   System.out.print("WB|");
			if(board[ROW_5][COLUMN_2] == WHITEQUEEN)    System.out.print("WQ|");
			if(board[ROW_5][COLUMN_2] == WHITEKING)     System.out.print("WK|");
			if(board[ROW_5][COLUMN_2] == WHITEPAWN)     System.out.print("WP|");
			if(board[ROW_5][COLUMN_3] == EMPTY)         System.out.print("  |");
			if(board[ROW_5][COLUMN_3] == BLACKTOWER)    System.out.print("BT|");
			if(board[ROW_5][COLUMN_3] == BLACKKNIGHT)   System.out.print("BN|");
			if(board[ROW_5][COLUMN_3] == BLACKBISHOP)   System.out.print("BB|");
			if(board[ROW_5][COLUMN_3] == BLACKQUEEN)    System.out.print("BQ|");
			if(board[ROW_5][COLUMN_3] == BLACKKING)     System.out.print("BK|");
			if(board[ROW_5][COLUMN_3] == BLACKPAWN)     System.out.print("BP|");
			if(board[ROW_5][COLUMN_3] == WHITETOWER)    System.out.print("WT|");
			if(board[ROW_5][COLUMN_3] == WHITEKNIGHT)   System.out.print("WN|");
			if(board[ROW_5][COLUMN_3] == WHITEBISHOP)   System.out.print("WB|");
			if(board[ROW_5][COLUMN_3] == WHITEQUEEN)    System.out.print("WQ|");
			if(board[ROW_5][COLUMN_3] == WHITEKING)     System.out.print("WK|");
			if(board[ROW_5][COLUMN_3] == WHITEPAWN)     System.out.print("WP|");
			if(board[ROW_5][COLUMN_4] == EMPTY)         System.out.print("  |");
			if(board[ROW_5][COLUMN_4] == BLACKTOWER)    System.out.print("BT|");
			if(board[ROW_5][COLUMN_4] == BLACKKNIGHT)   System.out.print("BN|");
			if(board[ROW_5][COLUMN_4] == BLACKBISHOP)   System.out.print("BB|");
			if(board[ROW_5][COLUMN_4] == BLACKQUEEN)    System.out.print("BQ|");
			if(board[ROW_5][COLUMN_4] == BLACKKING)     System.out.print("BK|");
			if(board[ROW_5][COLUMN_4] == BLACKPAWN)     System.out.print("BP|");
			if(board[ROW_5][COLUMN_4] == WHITETOWER)    System.out.print("WT|");
			if(board[ROW_5][COLUMN_4] == WHITEKNIGHT)   System.out.print("WN|");
			if(board[ROW_5][COLUMN_4] == WHITEBISHOP)   System.out.print("WB|");
			if(board[ROW_5][COLUMN_4] == WHITEQUEEN)    System.out.print("WQ|");
			if(board[ROW_5][COLUMN_4] == WHITEKING)     System.out.print("WK|");
			if(board[ROW_5][COLUMN_4] == WHITEPAWN)     System.out.print("WP|");
			if(board[ROW_5][COLUMN_5] == EMPTY)         System.out.print("  |");
			if(board[ROW_5][COLUMN_5] == BLACKTOWER)    System.out.print("BT|");
			if(board[ROW_5][COLUMN_5] == BLACKKNIGHT)   System.out.print("BN|");
			if(board[ROW_5][COLUMN_5] == BLACKBISHOP)   System.out.print("BB|");
			if(board[ROW_5][COLUMN_5] == BLACKQUEEN)    System.out.print("BQ|");
			if(board[ROW_5][COLUMN_5] == BLACKKING)     System.out.print("BK|");
			if(board[ROW_5][COLUMN_5] == BLACKPAWN)     System.out.print("BP|");
			if(board[ROW_5][COLUMN_5] == WHITETOWER)    System.out.print("WT|");
			if(board[ROW_5][COLUMN_5] == WHITEKNIGHT)   System.out.print("WN|");
			if(board[ROW_5][COLUMN_5] == WHITEBISHOP)   System.out.print("WB|");
			if(board[ROW_5][COLUMN_5] == WHITEQUEEN)    System.out.print("WQ|");
			if(board[ROW_5][COLUMN_5] == WHITEKING)     System.out.print("WK|");
			if(board[ROW_5][COLUMN_5] == WHITEPAWN)     System.out.print("WP|");
			if(board[ROW_5][COLUMN_6] == EMPTY)         System.out.print("  |");
			if(board[ROW_5][COLUMN_6] == BLACKTOWER)    System.out.print("BT|");
			if(board[ROW_5][COLUMN_6] == BLACKKNIGHT)   System.out.print("BN|");
			if(board[ROW_5][COLUMN_6] == BLACKBISHOP)   System.out.print("BB|");
			if(board[ROW_5][COLUMN_6] == BLACKQUEEN)    System.out.print("BQ|");
			if(board[ROW_5][COLUMN_6] == BLACKKING)     System.out.print("BK|");
			if(board[ROW_5][COLUMN_6] == BLACKPAWN)     System.out.print("BP|");
			if(board[ROW_5][COLUMN_6] == WHITETOWER)    System.out.print("WT|");
			if(board[ROW_5][COLUMN_6] == WHITEKNIGHT)   System.out.print("WN|");
			if(board[ROW_5][COLUMN_6] == WHITEBISHOP)   System.out.print("WB|");
			if(board[ROW_5][COLUMN_6] == WHITEQUEEN)    System.out.print("WQ|");
			if(board[ROW_5][COLUMN_6] == WHITEKING)     System.out.print("WK|");
			if(board[ROW_5][COLUMN_6] == WHITEPAWN)     System.out.print("WP|");
			if(board[ROW_5][COLUMN_7] == EMPTY)         System.out.print("  |");
			if(board[ROW_5][COLUMN_7] == BLACKTOWER)    System.out.print("BT|");
			if(board[ROW_5][COLUMN_7] == BLACKKNIGHT)   System.out.print("BN|");
			if(board[ROW_5][COLUMN_7] == BLACKBISHOP)   System.out.print("BB|");
			if(board[ROW_5][COLUMN_7] == BLACKQUEEN)    System.out.print("BQ|");
			if(board[ROW_5][COLUMN_7] == BLACKKING)     System.out.print("BK|");
			if(board[ROW_5][COLUMN_7] == BLACKPAWN)     System.out.print("BP|");
			if(board[ROW_5][COLUMN_7] == WHITETOWER)    System.out.print("WT|");
			if(board[ROW_5][COLUMN_7] == WHITEKNIGHT)   System.out.print("WN|");
			if(board[ROW_5][COLUMN_7] == WHITEBISHOP)   System.out.print("WB|");
			if(board[ROW_5][COLUMN_7] == WHITEQUEEN)    System.out.print("WQ|");
			if(board[ROW_5][COLUMN_7] == WHITEKING)     System.out.print("WK|");
			if(board[ROW_5][COLUMN_7] == WHITEPAWN)     System.out.print("WP|");
			if(board[ROW_5][COLUMN_8] == EMPTY)         System.out.print("  |\n");
			if(board[ROW_5][COLUMN_8] == BLACKTOWER)    System.out.print("BT|\n");
			if(board[ROW_5][COLUMN_8] == BLACKKNIGHT)   System.out.print("BN|\n");
			if(board[ROW_5][COLUMN_8] == BLACKBISHOP)   System.out.print("BB|\n");
			if(board[ROW_5][COLUMN_8] == BLACKQUEEN)    System.out.print("BQ|\n");
			if(board[ROW_5][COLUMN_8] == BLACKKING)     System.out.print("BK|\n");
			if(board[ROW_5][COLUMN_8] == BLACKPAWN)     System.out.print("BP|\n");
			if(board[ROW_5][COLUMN_8] == WHITETOWER)    System.out.print("WT|\n");
			if(board[ROW_5][COLUMN_8] == WHITEKNIGHT)   System.out.print("WN|\n");
			if(board[ROW_5][COLUMN_8] == WHITEBISHOP)   System.out.print("WB|\n");
			if(board[ROW_5][COLUMN_8] == WHITEQUEEN)    System.out.print("WQ|\n");
			if(board[ROW_5][COLUMN_8] == WHITEKING)     System.out.print("WK|\n");
			if(board[ROW_5][COLUMN_8] == WHITEPAWN)     System.out.print("WP|\n");
			System.out.printf("  _______________________\n");
			System.out.print("3 ");
			if(board[ROW_6][COLUMN_1] == EMPTY)         System.out.print("  |");
			if(board[ROW_6][COLUMN_1] == BLACKTOWER)    System.out.print("BT|");
			if(board[ROW_6][COLUMN_1] == BLACKKNIGHT)   System.out.print("BN|");
			if(board[ROW_6][COLUMN_1] == BLACKBISHOP)   System.out.print("BB|");
			if(board[ROW_6][COLUMN_1] == BLACKQUEEN)    System.out.print("BQ|");
			if(board[ROW_6][COLUMN_1] == BLACKKING)     System.out.print("BK|");
			if(board[ROW_6][COLUMN_1] == BLACKPAWN)     System.out.print("BP|");
			if(board[ROW_6][COLUMN_1] == WHITETOWER)    System.out.print("WT|");
			if(board[ROW_6][COLUMN_1] == WHITEKNIGHT)   System.out.print("WN|");
			if(board[ROW_6][COLUMN_1] == WHITEBISHOP)   System.out.print("WB|");
			if(board[ROW_6][COLUMN_1] == WHITEQUEEN)    System.out.print("WQ|");
			if(board[ROW_6][COLUMN_1] == WHITEKING)     System.out.print("WK|");
			if(board[ROW_6][COLUMN_1] == WHITEPAWN)     System.out.print("WP|");
			if(board[ROW_6][COLUMN_2] == EMPTY)         System.out.print("  |");
			if(board[ROW_6][COLUMN_2] == BLACKTOWER)    System.out.print("BT|");
			if(board[ROW_6][COLUMN_2] == BLACKKNIGHT)   System.out.print("BN|");
			if(board[ROW_6][COLUMN_2] == BLACKBISHOP)   System.out.print("BB|");
			if(board[ROW_6][COLUMN_2] == BLACKQUEEN)    System.out.print("BQ|");
			if(board[ROW_6][COLUMN_2] == BLACKKING)     System.out.print("BK|");
			if(board[ROW_6][COLUMN_2] == BLACKPAWN)     System.out.print("BP|");
			if(board[ROW_6][COLUMN_2] == WHITETOWER)    System.out.print("WT|");
			if(board[ROW_6][COLUMN_2] == WHITEKNIGHT)   System.out.print("WN|");
			if(board[ROW_6][COLUMN_2] == WHITEBISHOP)   System.out.print("WB|");
			if(board[ROW_6][COLUMN_2] == WHITEQUEEN)    System.out.print("WQ|");
			if(board[ROW_6][COLUMN_2] == WHITEKING)     System.out.print("WK|");
			if(board[ROW_6][COLUMN_2] == WHITEPAWN)     System.out.print("WP|");
			if(board[ROW_6][COLUMN_3] == EMPTY)         System.out.print("  |");
			if(board[ROW_6][COLUMN_3] == BLACKTOWER)    System.out.print("BT|");
			if(board[ROW_6][COLUMN_3] == BLACKKNIGHT)   System.out.print("BN|");
			if(board[ROW_6][COLUMN_3] == BLACKBISHOP)   System.out.print("BB|");
			if(board[ROW_6][COLUMN_3] == BLACKQUEEN)    System.out.print("BQ|");
			if(board[ROW_6][COLUMN_3] == BLACKKING)     System.out.print("BK|");
			if(board[ROW_6][COLUMN_3] == BLACKPAWN)     System.out.print("BP|");
			if(board[ROW_6][COLUMN_3] == WHITETOWER)    System.out.print("WT|");
			if(board[ROW_6][COLUMN_3] == WHITEKNIGHT)   System.out.print("WN|");
			if(board[ROW_6][COLUMN_3] == WHITEBISHOP)   System.out.print("WB|");
			if(board[ROW_6][COLUMN_3] == WHITEQUEEN)    System.out.print("WQ|");
			if(board[ROW_6][COLUMN_3] == WHITEKING)     System.out.print("WK|");
			if(board[ROW_6][COLUMN_3] == WHITEPAWN)     System.out.print("WP|");
			if(board[ROW_6][COLUMN_4] == EMPTY)         System.out.print("  |");
			if(board[ROW_6][COLUMN_4] == BLACKTOWER)    System.out.print("BT|");
			if(board[ROW_6][COLUMN_4] == BLACKKNIGHT)   System.out.print("BN|");
			if(board[ROW_6][COLUMN_4] == BLACKBISHOP)   System.out.print("BB|");
			if(board[ROW_6][COLUMN_4] == BLACKQUEEN)    System.out.print("BQ|");
			if(board[ROW_6][COLUMN_4] == BLACKKING)     System.out.print("BK|");
			if(board[ROW_6][COLUMN_4] == BLACKPAWN)     System.out.print("BP|");
			if(board[ROW_6][COLUMN_4] == WHITETOWER)    System.out.print("WT|");
			if(board[ROW_6][COLUMN_4] == WHITEKNIGHT)   System.out.print("WN|");
			if(board[ROW_6][COLUMN_4] == WHITEBISHOP)   System.out.print("WB|");
			if(board[ROW_6][COLUMN_4] == WHITEQUEEN)    System.out.print("WQ|");
			if(board[ROW_6][COLUMN_4] == WHITEKING)     System.out.print("WK|");
			if(board[ROW_6][COLUMN_4] == WHITEPAWN)     System.out.print("WP|");
			if(board[ROW_6][COLUMN_5] == EMPTY)         System.out.print("  |");
			if(board[ROW_6][COLUMN_5] == BLACKTOWER)    System.out.print("BT|");
			if(board[ROW_6][COLUMN_5] == BLACKKNIGHT)   System.out.print("BN|");
			if(board[ROW_6][COLUMN_5] == BLACKBISHOP)   System.out.print("BB|");
			if(board[ROW_6][COLUMN_5] == BLACKQUEEN)    System.out.print("BQ|");
			if(board[ROW_6][COLUMN_5] == BLACKKING)     System.out.print("BK|");
			if(board[ROW_6][COLUMN_5] == BLACKPAWN)     System.out.print("BP|");
			if(board[ROW_6][COLUMN_5] == WHITETOWER)    System.out.print("WT|");
			if(board[ROW_6][COLUMN_5] == WHITEKNIGHT)   System.out.print("WN|");
			if(board[ROW_6][COLUMN_5] == WHITEBISHOP)   System.out.print("WB|");
			if(board[ROW_6][COLUMN_5] == WHITEQUEEN)    System.out.print("WQ|");
			if(board[ROW_6][COLUMN_5] == WHITEKING)     System.out.print("WK|");
			if(board[ROW_6][COLUMN_5] == WHITEPAWN)     System.out.print("WP|");
			if(board[ROW_6][COLUMN_6] == EMPTY)         System.out.print("  |");
			if(board[ROW_6][COLUMN_6] == BLACKTOWER)    System.out.print("BT|");
			if(board[ROW_6][COLUMN_6] == BLACKKNIGHT)   System.out.print("BN|");
			if(board[ROW_6][COLUMN_6] == BLACKBISHOP)   System.out.print("BB|");
			if(board[ROW_6][COLUMN_6] == BLACKQUEEN)    System.out.print("BQ|");
			if(board[ROW_6][COLUMN_6] == BLACKKING)     System.out.print("BK|");
			if(board[ROW_6][COLUMN_6] == BLACKPAWN)     System.out.print("BP|");
			if(board[ROW_6][COLUMN_6] == WHITETOWER)    System.out.print("WT|");
			if(board[ROW_6][COLUMN_6] == WHITEKNIGHT)   System.out.print("WN|");
			if(board[ROW_6][COLUMN_6] == WHITEBISHOP)   System.out.print("WB|");
			if(board[ROW_6][COLUMN_6] == WHITEQUEEN)    System.out.print("WQ|");
			if(board[ROW_6][COLUMN_6] == WHITEKING)     System.out.print("WK|");
			if(board[ROW_6][COLUMN_6] == WHITEPAWN)     System.out.print("WP|");
			if(board[ROW_6][COLUMN_7] == EMPTY)         System.out.print("  |");
			if(board[ROW_6][COLUMN_7] == BLACKTOWER)    System.out.print("BT|");
			if(board[ROW_6][COLUMN_7] == BLACKKNIGHT)   System.out.print("BN|");
			if(board[ROW_6][COLUMN_7] == BLACKBISHOP)   System.out.print("BB|");
			if(board[ROW_6][COLUMN_7] == BLACKQUEEN)    System.out.print("BQ|");
			if(board[ROW_6][COLUMN_7] == BLACKKING)     System.out.print("BK|");
			if(board[ROW_6][COLUMN_7] == BLACKPAWN)     System.out.print("BP|");
			if(board[ROW_6][COLUMN_7] == WHITETOWER)    System.out.print("WT|");
			if(board[ROW_6][COLUMN_7] == WHITEKNIGHT)   System.out.print("WN|");
			if(board[ROW_6][COLUMN_7] == WHITEBISHOP)   System.out.print("WB|");
			if(board[ROW_6][COLUMN_7] == WHITEQUEEN)    System.out.print("WQ|");
			if(board[ROW_6][COLUMN_7] == WHITEKING)     System.out.print("WK|");
			if(board[ROW_6][COLUMN_7] == WHITEPAWN)     System.out.print("WP|");
			if(board[ROW_6][COLUMN_8] == EMPTY)         System.out.print("  |\n");
			if(board[ROW_6][COLUMN_8] == BLACKTOWER)    System.out.print("BT|\n");
			if(board[ROW_6][COLUMN_8] == BLACKKNIGHT)   System.out.print("BN|\n");
			if(board[ROW_6][COLUMN_8] == BLACKBISHOP)   System.out.print("BB|\n");
			if(board[ROW_6][COLUMN_8] == BLACKQUEEN)    System.out.print("BQ|\n");
			if(board[ROW_6][COLUMN_8] == BLACKKING)     System.out.print("BK|\n");
			if(board[ROW_6][COLUMN_8] == BLACKPAWN)     System.out.print("BP|\n");
			if(board[ROW_6][COLUMN_8] == WHITETOWER)    System.out.print("WT|\n");
			if(board[ROW_6][COLUMN_8] == WHITEKNIGHT)   System.out.print("WN|\n");
			if(board[ROW_6][COLUMN_8] == WHITEBISHOP)   System.out.print("WB|\n");
			if(board[ROW_6][COLUMN_8] == WHITEQUEEN)    System.out.print("WQ|\n");
			if(board[ROW_6][COLUMN_8] == WHITEKING)     System.out.print("WK|\n");
			if(board[ROW_6][COLUMN_8] == WHITEPAWN)     System.out.print("WP|\n");
			System.out.printf("  _______________________\n");
			System.out.print("2 ");
			if(board[ROW_7][COLUMN_1] == EMPTY)         System.out.print("  |");
			if(board[ROW_7][COLUMN_1] == BLACKTOWER)    System.out.print("BT|");
			if(board[ROW_7][COLUMN_1] == BLACKKNIGHT)   System.out.print("BN|");
			if(board[ROW_7][COLUMN_1] == BLACKBISHOP)   System.out.print("BB|");
			if(board[ROW_7][COLUMN_1] == BLACKQUEEN)    System.out.print("BQ|");
			if(board[ROW_7][COLUMN_1] == BLACKKING)     System.out.print("BK|");
			if(board[ROW_7][COLUMN_1] == BLACKPAWN)     System.out.print("BP|");
			if(board[ROW_7][COLUMN_1] == WHITETOWER)    System.out.print("WT|");
			if(board[ROW_7][COLUMN_1] == WHITEKNIGHT)   System.out.print("WN|");
			if(board[ROW_7][COLUMN_1] == WHITEBISHOP)   System.out.print("WB|");
			if(board[ROW_7][COLUMN_1] == WHITEQUEEN)    System.out.print("WQ|");
			if(board[ROW_7][COLUMN_1] == WHITEKING)     System.out.print("WK|");
			if(board[ROW_7][COLUMN_1] == WHITEPAWN)     System.out.print("WP|");
			if(board[ROW_7][COLUMN_2] == EMPTY)         System.out.print("  |");
			if(board[ROW_7][COLUMN_2] == BLACKTOWER)    System.out.print("BT|");
			if(board[ROW_7][COLUMN_2] == BLACKKNIGHT)   System.out.print("BN|");
			if(board[ROW_7][COLUMN_2] == BLACKBISHOP)   System.out.print("BB|");
			if(board[ROW_7][COLUMN_2] == BLACKQUEEN)    System.out.print("BQ|");
			if(board[ROW_7][COLUMN_2] == BLACKKING)     System.out.print("BK|");
			if(board[ROW_7][COLUMN_2] == BLACKPAWN)     System.out.print("BP|");
			if(board[ROW_7][COLUMN_2] == WHITETOWER)    System.out.print("WT|");
			if(board[ROW_7][COLUMN_2] == WHITEKNIGHT)   System.out.print("WN|");
			if(board[ROW_7][COLUMN_2] == WHITEBISHOP)   System.out.print("WB|");
			if(board[ROW_7][COLUMN_2] == WHITEQUEEN)    System.out.print("WQ|");
			if(board[ROW_7][COLUMN_2] == WHITEKING)     System.out.print("WK|");
			if(board[ROW_7][COLUMN_2] == WHITEPAWN)     System.out.print("WP|");
			if(board[ROW_7][COLUMN_3] == EMPTY)         System.out.print("  |");
			if(board[ROW_7][COLUMN_3] == BLACKTOWER)    System.out.print("BT|");
			if(board[ROW_7][COLUMN_3] == BLACKKNIGHT)   System.out.print("BN|");
			if(board[ROW_7][COLUMN_3] == BLACKBISHOP)   System.out.print("BB|");
			if(board[ROW_7][COLUMN_3] == BLACKQUEEN)    System.out.print("BQ|");
			if(board[ROW_7][COLUMN_3] == BLACKKING)     System.out.print("BK|");
			if(board[ROW_7][COLUMN_3] == BLACKPAWN)     System.out.print("BP|");
			if(board[ROW_7][COLUMN_3] == WHITETOWER)    System.out.print("WT|");
			if(board[ROW_7][COLUMN_3] == WHITEKNIGHT)   System.out.print("WN|");
			if(board[ROW_7][COLUMN_3] == WHITEBISHOP)   System.out.print("WB|");
			if(board[ROW_7][COLUMN_3] == WHITEQUEEN)    System.out.print("WQ|");
			if(board[ROW_7][COLUMN_3] == WHITEKING)     System.out.print("WK|");
			if(board[ROW_7][COLUMN_3] == WHITEPAWN)     System.out.print("WP|");
			if(board[ROW_7][COLUMN_4] == EMPTY)         System.out.print("  |");
			if(board[ROW_7][COLUMN_4] == BLACKTOWER)    System.out.print("BT|");
			if(board[ROW_7][COLUMN_4] == BLACKKNIGHT)   System.out.print("BN|");
			if(board[ROW_7][COLUMN_4] == BLACKBISHOP)   System.out.print("BB|");
			if(board[ROW_7][COLUMN_4] == BLACKQUEEN)    System.out.print("BQ|");
			if(board[ROW_7][COLUMN_4] == BLACKKING)     System.out.print("BK|");
			if(board[ROW_7][COLUMN_4] == BLACKPAWN)     System.out.print("BP|");
			if(board[ROW_7][COLUMN_4] == WHITETOWER)    System.out.print("WT|");
			if(board[ROW_7][COLUMN_4] == WHITEKNIGHT)   System.out.print("WN|");
			if(board[ROW_7][COLUMN_4] == WHITEBISHOP)   System.out.print("WB|");
			if(board[ROW_7][COLUMN_4] == WHITEQUEEN)    System.out.print("WQ|");
			if(board[ROW_7][COLUMN_4] == WHITEKING)     System.out.print("WK|");
			if(board[ROW_7][COLUMN_4] == WHITEPAWN)     System.out.print("WP|");
			if(board[ROW_7][COLUMN_5] == EMPTY)         System.out.print("  |");
			if(board[ROW_7][COLUMN_5] == BLACKTOWER)    System.out.print("BT|");
			if(board[ROW_7][COLUMN_5] == BLACKKNIGHT)   System.out.print("BN|");
			if(board[ROW_7][COLUMN_5] == BLACKBISHOP)   System.out.print("BB|");
			if(board[ROW_7][COLUMN_5] == BLACKQUEEN)    System.out.print("BQ|");
			if(board[ROW_7][COLUMN_5] == BLACKKING)     System.out.print("BK|");
			if(board[ROW_7][COLUMN_5] == BLACKPAWN)     System.out.print("BP|");
			if(board[ROW_7][COLUMN_5] == WHITETOWER)    System.out.print("WT|");
			if(board[ROW_7][COLUMN_5] == WHITEKNIGHT)   System.out.print("WN|");
			if(board[ROW_7][COLUMN_5] == WHITEBISHOP)   System.out.print("WB|");
			if(board[ROW_7][COLUMN_5] == WHITEQUEEN)    System.out.print("WQ|");
			if(board[ROW_7][COLUMN_5] == WHITEKING)     System.out.print("WK|");
			if(board[ROW_7][COLUMN_5] == WHITEPAWN)     System.out.print("WP|");
			if(board[ROW_7][COLUMN_6] == EMPTY)         System.out.print("  |");
			if(board[ROW_7][COLUMN_6] == BLACKTOWER)    System.out.print("BT|");
			if(board[ROW_7][COLUMN_6] == BLACKKNIGHT)   System.out.print("BN|");
			if(board[ROW_7][COLUMN_6] == BLACKBISHOP)   System.out.print("BB|");
			if(board[ROW_7][COLUMN_6] == BLACKQUEEN)    System.out.print("BQ|");
			if(board[ROW_7][COLUMN_6] == BLACKKING)     System.out.print("BK|");
			if(board[ROW_7][COLUMN_6] == BLACKPAWN)     System.out.print("BP|");
			if(board[ROW_7][COLUMN_6] == WHITETOWER)    System.out.print("WT|");
			if(board[ROW_7][COLUMN_6] == WHITEKNIGHT)   System.out.print("WN|");
			if(board[ROW_7][COLUMN_6] == WHITEBISHOP)   System.out.print("WB|");
			if(board[ROW_7][COLUMN_6] == WHITEQUEEN)    System.out.print("WQ|");
			if(board[ROW_7][COLUMN_6] == WHITEKING)     System.out.print("WK|");
			if(board[ROW_7][COLUMN_6] == WHITEPAWN)     System.out.print("WP|");
			if(board[ROW_7][COLUMN_7] == EMPTY)         System.out.print("  |");
			if(board[ROW_7][COLUMN_7] == BLACKTOWER)    System.out.print("BT|");
			if(board[ROW_7][COLUMN_7] == BLACKKNIGHT)   System.out.print("BN|");
			if(board[ROW_7][COLUMN_7] == BLACKBISHOP)   System.out.print("BB|");
			if(board[ROW_7][COLUMN_7] == BLACKQUEEN)    System.out.print("BQ|");
			if(board[ROW_7][COLUMN_7] == BLACKKING)     System.out.print("BK|");
			if(board[ROW_7][COLUMN_7] == BLACKPAWN)     System.out.print("BP|");
			if(board[ROW_7][COLUMN_7] == WHITETOWER)    System.out.print("WT|");
			if(board[ROW_7][COLUMN_7] == WHITEKNIGHT)   System.out.print("WN|");
			if(board[ROW_7][COLUMN_7] == WHITEBISHOP)   System.out.print("WB|");
			if(board[ROW_7][COLUMN_7] == WHITEQUEEN)    System.out.print("WQ|");
			if(board[ROW_7][COLUMN_7] == WHITEKING)     System.out.print("WK|");
			if(board[ROW_7][COLUMN_7] == WHITEPAWN)     System.out.print("WP|");
			if(board[ROW_7][COLUMN_8] == EMPTY)         System.out.print("  |\n");
			if(board[ROW_7][COLUMN_8] == BLACKTOWER)    System.out.print("BT|\n");
			if(board[ROW_7][COLUMN_8] == BLACKKNIGHT)   System.out.print("BN|\n");
			if(board[ROW_7][COLUMN_8] == BLACKBISHOP)   System.out.print("BB|\n");
			if(board[ROW_7][COLUMN_8] == BLACKQUEEN)    System.out.print("BQ|\n");
			if(board[ROW_7][COLUMN_8] == BLACKKING)     System.out.print("BK|\n");
			if(board[ROW_7][COLUMN_8] == BLACKPAWN)     System.out.print("BP|\n");
			if(board[ROW_7][COLUMN_8] == WHITETOWER)    System.out.print("WT|\n");
			if(board[ROW_7][COLUMN_8] == WHITEKNIGHT)   System.out.print("WN|\n");
			if(board[ROW_7][COLUMN_8] == WHITEBISHOP)   System.out.print("WB|\n");
			if(board[ROW_7][COLUMN_8] == WHITEQUEEN)    System.out.print("WQ|\n");
			if(board[ROW_7][COLUMN_8] == WHITEKING)     System.out.print("WK|\n");
			if(board[ROW_7][COLUMN_8] == WHITEPAWN)     System.out.print("WP|\n");
			System.out.printf("  _______________________\n");
			System.out.print("1 ");
			if(board[ROW_8][COLUMN_1] == EMPTY)         System.out.print("  |");
			if(board[ROW_8][COLUMN_1] == BLACKTOWER)    System.out.print("BT|");
			if(board[ROW_8][COLUMN_1] == BLACKKNIGHT)   System.out.print("BN|");
			if(board[ROW_8][COLUMN_1] == BLACKBISHOP)   System.out.print("BB|");
			if(board[ROW_8][COLUMN_1] == BLACKQUEEN)    System.out.print("BQ|");
			if(board[ROW_8][COLUMN_1] == BLACKKING)     System.out.print("BK|");
			if(board[ROW_8][COLUMN_1] == BLACKPAWN)     System.out.print("BP|");
			if(board[ROW_8][COLUMN_1] == WHITETOWER)    System.out.print("WT|");
			if(board[ROW_8][COLUMN_1] == WHITEKNIGHT)   System.out.print("WN|");
			if(board[ROW_8][COLUMN_1] == WHITEBISHOP)   System.out.print("WB|");
			if(board[ROW_8][COLUMN_1] == WHITEQUEEN)    System.out.print("WQ|");
			if(board[ROW_8][COLUMN_1] == WHITEKING)     System.out.print("WK|");
			if(board[ROW_8][COLUMN_1] == WHITEPAWN)     System.out.print("WP|");
			if(board[ROW_8][COLUMN_2] == EMPTY)         System.out.print("  |");
			if(board[ROW_8][COLUMN_2] == BLACKTOWER)    System.out.print("BT|");
			if(board[ROW_8][COLUMN_2] == BLACKKNIGHT)   System.out.print("BN|");
			if(board[ROW_8][COLUMN_2] == BLACKBISHOP)   System.out.print("BB|");
			if(board[ROW_8][COLUMN_2] == BLACKQUEEN)    System.out.print("BQ|");
			if(board[ROW_8][COLUMN_2] == BLACKKING)     System.out.print("BK|");
			if(board[ROW_8][COLUMN_2] == BLACKPAWN)     System.out.print("BP|");
			if(board[ROW_8][COLUMN_2] == WHITETOWER)    System.out.print("WT|");
			if(board[ROW_8][COLUMN_2] == WHITEKNIGHT)   System.out.print("WN|");
			if(board[ROW_8][COLUMN_2] == WHITEBISHOP)   System.out.print("WB|");
			if(board[ROW_8][COLUMN_2] == WHITEQUEEN)    System.out.print("WQ|");
			if(board[ROW_8][COLUMN_2] == WHITEKING)     System.out.print("WK|");
			if(board[ROW_8][COLUMN_2] == WHITEPAWN)     System.out.print("WP|");
			if(board[ROW_8][COLUMN_3] == EMPTY)         System.out.print("  |");
			if(board[ROW_8][COLUMN_3] == BLACKTOWER)    System.out.print("BT|");
			if(board[ROW_8][COLUMN_3] == BLACKKNIGHT)   System.out.print("BN|");
			if(board[ROW_8][COLUMN_3] == BLACKBISHOP)   System.out.print("BB|");
			if(board[ROW_8][COLUMN_3] == BLACKQUEEN)    System.out.print("BQ|");
			if(board[ROW_8][COLUMN_3] == BLACKKING)     System.out.print("BK|");
			if(board[ROW_8][COLUMN_3] == BLACKPAWN)     System.out.print("BP|");
			if(board[ROW_8][COLUMN_3] == WHITETOWER)    System.out.print("WT|");
			if(board[ROW_8][COLUMN_3] == WHITEKNIGHT)   System.out.print("WN|");
			if(board[ROW_8][COLUMN_3] == WHITEBISHOP)   System.out.print("WB|");
			if(board[ROW_8][COLUMN_3] == WHITEQUEEN)    System.out.print("WQ|");
			if(board[ROW_8][COLUMN_3] == WHITEKING)     System.out.print("WK|");
			if(board[ROW_8][COLUMN_3] == WHITEPAWN)     System.out.print("WP|");
			if(board[ROW_8][COLUMN_4] == EMPTY)         System.out.print("  |");
			if(board[ROW_8][COLUMN_4] == BLACKTOWER)    System.out.print("BT|");
			if(board[ROW_8][COLUMN_4] == BLACKKNIGHT)   System.out.print("BN|");
			if(board[ROW_8][COLUMN_4] == BLACKBISHOP)   System.out.print("BB|");
			if(board[ROW_8][COLUMN_4] == BLACKQUEEN)    System.out.print("BQ|");
			if(board[ROW_8][COLUMN_4] == BLACKKING)     System.out.print("BK|");
			if(board[ROW_8][COLUMN_4] == BLACKPAWN)     System.out.print("BP|");
			if(board[ROW_8][COLUMN_4] == WHITETOWER)    System.out.print("WT|");
			if(board[ROW_8][COLUMN_4] == WHITEKNIGHT)   System.out.print("WN|");
			if(board[ROW_8][COLUMN_4] == WHITEBISHOP)   System.out.print("WB|");
			if(board[ROW_8][COLUMN_4] == WHITEQUEEN)    System.out.print("WQ|");
			if(board[ROW_8][COLUMN_4] == WHITEKING)     System.out.print("WK|");
			if(board[ROW_8][COLUMN_4] == WHITEPAWN)     System.out.print("WP|");
			if(board[ROW_8][COLUMN_5] == EMPTY)         System.out.print("  |");
			if(board[ROW_8][COLUMN_5] == BLACKTOWER)    System.out.print("BT|");
			if(board[ROW_8][COLUMN_5] == BLACKKNIGHT)   System.out.print("BN|");
			if(board[ROW_8][COLUMN_5] == BLACKBISHOP)   System.out.print("BB|");
			if(board[ROW_8][COLUMN_5] == BLACKQUEEN)    System.out.print("BQ|");
			if(board[ROW_8][COLUMN_5] == BLACKKING)     System.out.print("BK|");
			if(board[ROW_8][COLUMN_5] == BLACKPAWN)     System.out.print("BP|");
			if(board[ROW_8][COLUMN_5] == WHITETOWER)    System.out.print("WT|");
			if(board[ROW_8][COLUMN_5] == WHITEKNIGHT)   System.out.print("WN|");
			if(board[ROW_8][COLUMN_5] == WHITEBISHOP)   System.out.print("WB|");
			if(board[ROW_8][COLUMN_5] == WHITEQUEEN)    System.out.print("WQ|");
			if(board[ROW_8][COLUMN_5] == WHITEKING)     System.out.print("WK|");
			if(board[ROW_8][COLUMN_5] == WHITEPAWN)     System.out.print("WP|");
			if(board[ROW_8][COLUMN_6] == EMPTY)         System.out.print("  |");
			if(board[ROW_8][COLUMN_6] == BLACKTOWER)    System.out.print("BT|");
			if(board[ROW_8][COLUMN_6] == BLACKKNIGHT)   System.out.print("BN|");
			if(board[ROW_8][COLUMN_6] == BLACKBISHOP)   System.out.print("BB|");
			if(board[ROW_8][COLUMN_6] == BLACKQUEEN)    System.out.print("BQ|");
			if(board[ROW_8][COLUMN_6] == BLACKKING)     System.out.print("BK|");
			if(board[ROW_8][COLUMN_6] == BLACKPAWN)     System.out.print("BP|");
			if(board[ROW_8][COLUMN_6] == WHITETOWER)    System.out.print("WT|");
			if(board[ROW_8][COLUMN_6] == WHITEKNIGHT)   System.out.print("WN|");
			if(board[ROW_8][COLUMN_6] == WHITEBISHOP)   System.out.print("WB|");
			if(board[ROW_8][COLUMN_6] == WHITEQUEEN)    System.out.print("WQ|");
			if(board[ROW_8][COLUMN_6] == WHITEKING)     System.out.print("WK|");
			if(board[ROW_8][COLUMN_6] == WHITEPAWN)     System.out.print("WP|");
			if(board[ROW_8][COLUMN_7] == EMPTY)         System.out.print("  |");
			if(board[ROW_8][COLUMN_7] == BLACKTOWER)    System.out.print("BT|");
			if(board[ROW_8][COLUMN_7] == BLACKKNIGHT)   System.out.print("BN|");
			if(board[ROW_8][COLUMN_7] == BLACKBISHOP)   System.out.print("BB|");
			if(board[ROW_8][COLUMN_7] == BLACKQUEEN)    System.out.print("BQ|");
			if(board[ROW_8][COLUMN_7] == BLACKKING)     System.out.print("BK|");
			if(board[ROW_8][COLUMN_7] == BLACKPAWN)     System.out.print("BP|");
			if(board[ROW_8][COLUMN_7] == WHITETOWER)    System.out.print("WT|");
			if(board[ROW_8][COLUMN_7] == WHITEKNIGHT)   System.out.print("WN|");
			if(board[ROW_8][COLUMN_7] == WHITEBISHOP)   System.out.print("WB|");
			if(board[ROW_8][COLUMN_7] == WHITEQUEEN)    System.out.print("WQ|");
			if(board[ROW_8][COLUMN_7] == WHITEKING)     System.out.print("WK|");
			if(board[ROW_8][COLUMN_7] == WHITEPAWN)     System.out.print("WP|");
			if(board[ROW_8][COLUMN_8] == EMPTY)         System.out.print("  |\n");
			if(board[ROW_8][COLUMN_8] == BLACKTOWER)    System.out.print("BT|\n");
			if(board[ROW_8][COLUMN_8] == BLACKKNIGHT)   System.out.print("BN|\n");
			if(board[ROW_8][COLUMN_8] == BLACKBISHOP)   System.out.print("BB|\n");
			if(board[ROW_8][COLUMN_8] == BLACKQUEEN)    System.out.print("BQ|\n");
			if(board[ROW_8][COLUMN_8] == BLACKKING)     System.out.print("BK|\n");
			if(board[ROW_8][COLUMN_8] == BLACKPAWN)     System.out.print("BP|\n");
			if(board[ROW_8][COLUMN_8] == WHITETOWER)    System.out.print("WT|\n");
			if(board[ROW_8][COLUMN_8] == WHITEKNIGHT)   System.out.print("WN|\n");
			if(board[ROW_8][COLUMN_8] == WHITEBISHOP)   System.out.print("WB|\n");
			if(board[ROW_8][COLUMN_8] == WHITEQUEEN)    System.out.print("WQ|\n");
			if(board[ROW_8][COLUMN_8] == WHITEKING)     System.out.print("WK|\n");
			if(board[ROW_8][COLUMN_8] == WHITEPAWN)     System.out.print("WP|\n");
			System.out.printf("  a  b  c  d  e  f  g  h\n");
		}
	}

	public void print(int piece) {
		switch(piece) {
		case 0:
			System.out.print("  |");
			break;
		case 7:
			System.out.print("BT|");
			break;
		case 3:
			System.out.print("BN|");
			break;
		case 5:
			System.out.print("BB|");
			break;
		case 9:
			System.out.print("BQ|");
			break;
		case 11:
			System.out.print("BK|");
			break;
		case 1:
			System.out.print("BP|");
			break;
		case 8:
			System.out.print("WT|");
			break;
		case 4:
			System.out.print("WN|");
			break;
		case 6:
			System.out.print("WB|");
			break;
		case 10:
			System.out.print("WQ|");
			break;
		case 12:
			System.out.print("WK|");
			break;
		case 2:
			System.out.print("WP|");
			break;		
	}
}
// VERIFICANDO MOVIMENTOS VÁLIDOS OU NÃO
	private boolean canMove(int lineOrigin, int collumOrigin, int lineDestiny, int collumDestiny) {
		switch(board[lineOrigin][collumOrigin]) {
			case WHITETOWER://MOVIMENTO TORRE - SO FAR WORKING - continuar daqui
				
				if((lineOrigin==lineDestiny)&&(collumOrigin==collumDestiny)) {// CASO ORIGEM IGUAL DESTINO
					erro1();
					return false;
				}
				if((lineOrigin != lineDestiny)&&(collumOrigin != collumDestiny)) {// Só MOVIMENTA VERTICAL OU HORIZONTAL
					System.out.print("Movimento Inválido 10.");
					return false;
				}
				//NÃO PODE COMER PEÇAS ALIADAS
				if((board[lineDestiny][collumDestiny] == WHITEBISHOP)||(board[lineDestiny][collumDestiny] == WHITEKING)||(board[lineDestiny][collumDestiny] == WHITEKNIGHT)||(board[lineDestiny][collumDestiny] == WHITEPAWN)||(board[lineDestiny][collumDestiny] == WHITEQUEEN)||(board[lineDestiny][collumDestiny] == WHITETOWER)) {
					erro3();
					return false;
				}
				//System.out.print("acontece???");
	
				if(lineOrigin==lineDestiny) {
					System.out.print("movimento pra direita, TORRE");
					if(collumOrigin>collumDestiny) {
						int b = collumOrigin-collumDestiny;
						for(int a = 1;a<b;a++) {//MOVIMENTO DA esqueda - direita SE O CAMINHO ESTÁ VAZIO
							System.out.printf("esq - DIR j=%d k=%d b=%d a=%d testando for i maior k \n",lineDestiny,collumDestiny,b,a);
							if(board[lineDestiny][collumDestiny+a]!=EMPTY) {
								System.out.print("Movimento Inválido 1.");
								return false;
							}
						}
					}else {//MOVIMENTO DA  direita PRA ESQUERDA SE O CAMINHO ESTÁ VAZIO
						int b = collumDestiny-collumOrigin;
						for(int a = 1;a<b;a++) {
							System.out.printf("DIR - ESQ ELSE j=%d k=%d b=%d a=%d testando for i menor k \n",lineDestiny,collumDestiny,b,a);
							if(board[lineDestiny][collumDestiny-a]!=EMPTY) {
								System.out.print("Movimento Inválido 2");
								return false;
							}
						}
					}
				}
				if(collumOrigin==collumDestiny) {
					if(lineOrigin>lineDestiny) {
						int b = lineOrigin-lineDestiny;
						for(int a = 1;a<b;a++) {//MOVIMENTO BAIXO PRA CIMA SE CAMINHO ESTÁ VAZIO
							System.out.printf("BAIXO cima j=%d k=%d b=%d a=%d testando for m maior j \n",lineDestiny,collumDestiny,b,a);
							//System.out.printf("coteúdo da passagem =%d conteúdo do destino %d ",board[j][k-a],board[j][k]);
							if(board[lineDestiny+a][collumDestiny]!=EMPTY) {
								System.out.print("Movimento Inválido 3");
								return false;
							}
						}
					}else {
						int b = lineDestiny-lineOrigin;
						for(int a = 1;a<b;a++) {//MOVIMENTO CIMA PRA BAIXO SE CAMINHO ESTÁ VAZIO
							System.out.printf("CIMA BAIXO else j=%d k=%d b=%d a=%d testando for m menor j \n",lineDestiny,collumDestiny,b,a);
							System.out.printf("coteúdo da passagem =%d conteúdo do destino %d ",board[lineDestiny-a][collumDestiny],board[lineDestiny][collumDestiny]);
							if(board[lineDestiny-a][collumDestiny]!=EMPTY) {
								System.out.print("Movimento Inválido 4");
								return false;
							}
						}
					}
				}
				System.out.printf("FINAL case WhiteTOwer linhaorigem=%d colunaorigem=%d linha destino=%d coluna destino=%d",lineOrigin,collumOrigin,lineDestiny,collumDestiny);
				return true;//now working
			case WHITEBISHOP:
				if((lineOrigin==lineDestiny)&&(collumOrigin==collumDestiny)) {// ORIGEM IGUAL DESTINO
					erro1();
					return false;
				}
				if((lineOrigin==lineDestiny)||(collumOrigin==collumDestiny)) {// bispo só diagonal
					erro2();
					return false;
				}
				if((board[lineDestiny][collumDestiny] == WHITEBISHOP)||(board[lineDestiny][collumDestiny] == WHITEKING)||(board[lineDestiny][collumDestiny] == WHITEKNIGHT)||(board[lineDestiny][collumDestiny] == WHITEPAWN)||(board[lineDestiny][collumDestiny] == WHITEQUEEN)||(board[lineDestiny][collumDestiny] == WHITETOWER)) {
					erro3();//não comer peça aliada
					return false;
				}
				//if(!(lineDestiny-))
				if((lineOrigin>lineDestiny)&&(collumOrigin<collumDestiny)) {//subindo pra direita
					if((lineOrigin-lineDestiny) != (collumDestiny-collumOrigin)) {
						//System.out.printf("linhaorigem=%d coluna origem=%d linha destino=%d coluna destino=%d, cal1=%d cal2=%d resultado=%d ",lineOrigin,collumOrigin,lineDestiny,collumDestiny,(lineOrigin-lineDestiny),((-1*collumOrigin)-collumDestiny),((lineOrigin-lineDestiny) != ((-1*collumOrigin)-collumDestiny)));
						erro2();
						return false;
					}	
				}
				if((lineOrigin>lineDestiny)&&(collumOrigin>collumDestiny)) {//subindo pra esquerda
					if((lineOrigin-lineDestiny) != ((collumOrigin)-collumDestiny)) {
						erro2();
						return false;
					}	
				}
				if((lineOrigin<lineDestiny)&&(collumOrigin<collumDestiny)) {//descendo
					if((lineDestiny-lineOrigin) != (collumDestiny-collumOrigin)) {
						erro2();
						return false;
					}	
				}
				if((lineOrigin<lineDestiny)&&(collumOrigin>collumDestiny)) {//descendo
					if((lineDestiny-lineOrigin) != ((collumOrigin)-collumDestiny)) {
						erro2();
						return false;
					}	
				}
				
				
				if((lineOrigin>lineDestiny)&&collumOrigin<collumDestiny){//subindo pra direita
					int b = lineOrigin-lineDestiny,d=collumDestiny-collumOrigin;
					for(int a=1;a<b;a++) {
						for(int c=1;c<d;c++) {
							if((a==c)&&(board[lineDestiny+a][collumDestiny-c]!=0)) {
								System.out.printf("linOri=%d colOri=%d linDest=%d colDest=%d, b=%d d=%d a=%d ",lineOrigin,collumOrigin,lineDestiny,collumDestiny,b,d,a);
								erro4();
								return false;
							}
						}
					}
					System.out.printf("linOri=%d colOri=%d linDest=%d colDest=%d, b=%d d=%d a= ",lineOrigin,collumOrigin,lineDestiny,collumDestiny,b,d);
						//System.out.printf("linOri=%d colOri=%d linDest=%d colDest=%d, cal1=%d cal2=%d resultado=%d ",lineOrigin,collumOrigin,lineDestiny,collumDestiny,(lineOrigin-lineDestiny),((-1*collumOrigin)-collumDestiny),((lineOrigin-lineDestiny) != ((-1*collumOrigin)-collumDestiny)));
						//return false;
						
				}
				if((lineOrigin>lineDestiny)&&collumOrigin>collumDestiny) {//subindo pra esquerda
					int b = lineOrigin-lineDestiny,d=collumOrigin-collumDestiny;
					for(int a=1;a<b;a++) {
						for(int c=1;c<d;c++) {
							//System.out.printf("linOri=%d colOri=%d linDest=%d colDest=%d, b=%d d=%d a=%d ",lineOrigin,collumOrigin,lineDestiny,collumDestiny,b,d,a);
							if((a==c)&&(board[lineDestiny+a][collumDestiny+c]!=0)) {
								System.out.printf("linOri=%d colOri=%d linDest=%d colDest=%d, b=%d d=%d a=%d ",lineOrigin,collumOrigin,lineDestiny,collumDestiny,b,d,a);
								erro4();
								return false;
							}
						}
					}
					System.out.printf("linOri=%d colOri=%d linDest=%d colDest=%d, b=%d d=%d a= ",lineOrigin,collumOrigin,lineDestiny,collumDestiny,b,d);
						//System.out.printf("linOri=%d colOri=%d linDest=%d colDest=%d, cal1=%d cal2=%d resultado=%d ",lineOrigin,collumOrigin,lineDestiny,collumDestiny,(lineOrigin-lineDestiny),((-1*collumOrigin)-collumDestiny),((lineOrigin-lineDestiny) != ((-1*collumOrigin)-collumDestiny)));
						//return false;
				
				}
				if((lineOrigin<lineDestiny)&&collumOrigin<collumDestiny) {//baixo direita
					int b = lineDestiny-lineOrigin,d=collumDestiny-collumOrigin;
					for(int a=1;a<b;a++) {
						for(int c=1;c<d;c++) {
							System.out.printf("789linOri=%d colOri=%d linDest=%d colDest=%d, b=%d d=%d a=%d c=%d\n",lineOrigin,collumOrigin,lineDestiny,collumDestiny,b,d,a,c);
							if((a==c)&&(board[lineDestiny-a][collumDestiny-c]!=0)) {
								System.out.printf("linOri=%d colOri=%d linDest=%d colDest=%d, b=%d d=%d a=%d ",lineOrigin,collumOrigin,lineDestiny,collumDestiny,b,d,a);
								erro4();
								return false;
							}
						}
					}
					System.out.printf("linOri=%d colOri=%d linDest=%d colDest=%d, b=%d d=%d a= ",lineOrigin,collumOrigin,lineDestiny,collumDestiny,b,d);
						//System.out.printf("linOri=%d colOri=%d linDest=%d colDest=%d, cal1=%d cal2=%d resultado=%d ",lineOrigin,collumOrigin,lineDestiny,collumDestiny,(lineOrigin-lineDestiny),((-1*collumOrigin)-collumDestiny),((lineOrigin-lineDestiny) != ((-1*collumOrigin)-collumDestiny)));
						//return false;
				
				}
				if((lineOrigin<lineDestiny)&&collumOrigin>collumDestiny) {//baixo esq
					int b = lineDestiny-lineOrigin,d=collumOrigin-collumDestiny;
					for(int a=1;a<b;a++) {
						for(int c=1;c<d;c++) {
							if((a==c)&&(board[lineDestiny-a][collumDestiny+c]!=0)) {
								System.out.printf("linOri=%d colOri=%d linDest=%d colDest=%d, b=%d d=%d a=%d ",lineOrigin,collumOrigin,lineDestiny,collumDestiny,b,d,a);
								erro4();
								return false;
							}
						}
					}
					System.out.printf("linOri=%d colOri=%d linDest=%d colDest=%d, b=%d d=%d a= ",lineOrigin,collumOrigin,lineDestiny,collumDestiny,b,d);
						//System.out.printf("linOri=%d colOri=%d linDest=%d colDest=%d, cal1=%d cal2=%d resultado=%d ",lineOrigin,collumOrigin,lineDestiny,collumDestiny,(lineOrigin-lineDestiny),((-1*collumOrigin)-collumDestiny),((lineOrigin-lineDestiny) != ((-1*collumOrigin)-collumDestiny)));
						//return false;
				
				}
				
				System.out.printf("linhaorigem=%d coluna origem=%d linha destino=%d coluna destino=%d",lineOrigin,collumOrigin,lineDestiny,collumDestiny);
				return true;
			case WHITEKNIGHT:
				if((lineOrigin==lineDestiny)&&(collumOrigin==collumDestiny)) {// ORIGEM IGUAL DESTINO
					erro1();
					return false;
				}
				if((board[lineDestiny][collumDestiny] == WHITEBISHOP)||(board[lineDestiny][collumDestiny] == WHITEKING)||(board[lineDestiny][collumDestiny] == WHITEKNIGHT)||(board[lineDestiny][collumDestiny] == WHITEPAWN)||(board[lineDestiny][collumDestiny] == WHITEQUEEN)||(board[lineDestiny][collumDestiny] == WHITETOWER)) {
					erro3();
					return false;
				}
				if(!((lineOrigin-lineDestiny==1)&&(collumOrigin-collumDestiny==2) || (lineOrigin-lineDestiny==1)&&(collumOrigin-collumDestiny==-2) || (lineOrigin-lineDestiny==-1)&&(collumOrigin-collumDestiny==2) || (lineOrigin-lineDestiny==-1)&&(collumOrigin-collumDestiny==-2) || (lineOrigin-lineDestiny==2)&&(collumOrigin-collumDestiny==1) || (lineOrigin-lineDestiny==2)&&(collumOrigin-collumDestiny==-1) || (lineOrigin-lineDestiny==-2)&&(collumOrigin-collumDestiny==1) || (lineOrigin-lineDestiny==-2)&&(collumOrigin-collumDestiny==-1))) {
				//(!((board[lineOrigin][collumOrigin] == board[lineDestiny+1][collumDestiny+2]) || (board[lineOrigin][collumOrigin] == board[lineDestiny+2][collumDestiny+1]) || (board[lineOrigin][collumOrigin] == board[lineDestiny-1][collumDestiny+2]) || (board[lineOrigin][collumOrigin] == board[lineDestiny-2][collumDestiny+1]) || (board[lineOrigin][collumOrigin] == board[lineDestiny-1][collumDestiny-2]) || (board[lineOrigin][collumOrigin] == board[lineDestiny-2][collumDestiny-1]) || (board[lineOrigin][collumOrigin] == board[lineDestiny+1][collumDestiny-2]) || (board[lineOrigin][collumOrigin] == board[lineDestiny+2][collumDestiny-1]))) {
					System.out.printf("linhaorigem=%d coluna origem=%d linha destino=%d coluna destino=%d",lineOrigin,collumOrigin,lineDestiny,collumDestiny);
					erro5();
					return false;
				}
				return true;
			case WHITEQUEEN:
				if((lineOrigin==lineDestiny)&&(collumOrigin==collumDestiny)) {// ORIGEM IGUAL DESTINO
					erro1();
					return false;
				}
				if((board[lineDestiny][collumDestiny] == WHITEBISHOP)||(board[lineDestiny][collumDestiny] == WHITEKING)||(board[lineDestiny][collumDestiny] == WHITEKNIGHT)||(board[lineDestiny][collumDestiny] == WHITEPAWN)||(board[lineDestiny][collumDestiny] == WHITEQUEEN)||(board[lineDestiny][collumDestiny] == WHITETOWER)) {
					erro3();
					return false;
				}
				if((lineOrigin>lineDestiny)&&collumOrigin<collumDestiny) {//subindo pra direita
					if((lineOrigin-lineDestiny) != (collumDestiny-collumOrigin)) {
						//System.out.printf("linhaorigem=%d coluna origem=%d linha destino=%d coluna destino=%d, cal1=%d cal2=%d resultado=%d ",lineOrigin,collumOrigin,lineDestiny,collumDestiny,(lineOrigin-lineDestiny),((-1*collumOrigin)-collumDestiny),((lineOrigin-lineDestiny) != ((-1*collumOrigin)-collumDestiny)));
						erro6();
						return false;
					}	
				}
				if((lineOrigin>lineDestiny)&&collumOrigin>collumDestiny) {//subindo pra esquerda
					if((lineOrigin-lineDestiny) != ((collumOrigin)-collumDestiny)) {
						erro6();
						return false;
					}	
				}
				if((lineOrigin<lineDestiny)&&collumOrigin<collumDestiny) {
					if((lineDestiny-lineOrigin) != (collumDestiny-collumOrigin)) {
						erro6();
						return false;
					}	
				}
				if((lineOrigin<lineDestiny)&&collumOrigin>collumDestiny) {
					if((lineDestiny-lineOrigin) != ((collumOrigin)-collumDestiny)) {
						erro6();
						return false;
					}	
				}
				
				
				if((lineOrigin>lineDestiny)&&collumOrigin<collumDestiny){//subindo pra direita
					int b = lineOrigin-lineDestiny,d=collumDestiny-collumOrigin;
					for(int a=1;a<b;a++) {
						for(int c=1;c<d;c++) {
							if((a==c)&&(board[lineDestiny+a][collumDestiny-c]!=0)) {
								System.out.printf("WB SD inside loop linOri=%d colOri=%d linDest=%d colDest=%d, b=%d d=%d a=%d ",lineOrigin,collumOrigin,lineDestiny,collumDestiny,b,d,a);
								erro4();
								return false;
							}
						}
					}
					System.out.printf("WB SD outside loop linOri=%d colOri=%d linDest=%d colDest=%d, b=%d d=%d a= ",lineOrigin,collumOrigin,lineDestiny,collumDestiny,b,d);
						//System.out.printf("linOri=%d colOri=%d linDest=%d colDest=%d, cal1=%d cal2=%d resultado=%d ",lineOrigin,collumOrigin,lineDestiny,collumDestiny,(lineOrigin-lineDestiny),((-1*collumOrigin)-collumDestiny),((lineOrigin-lineDestiny) != ((-1*collumOrigin)-collumDestiny)));
						//return false;
						
				}
				if((lineOrigin>lineDestiny)&&collumOrigin>collumDestiny) {//subindo pra esquerda
					int b = lineOrigin-lineDestiny,d=collumOrigin-collumDestiny;
					for(int a=1;a<b;a++) {
						for(int c=1;c<d;c++) {
							//System.out.printf("linOri=%d colOri=%d linDest=%d colDest=%d, b=%d d=%d a=%d ",lineOrigin,collumOrigin,lineDestiny,collumDestiny,b,d,a);
							if((a==c)&&(board[lineDestiny+a][collumDestiny+c]!=0)) {
								System.out.printf("WB SE insidde loop linOri=%d colOri=%d linDest=%d colDest=%d, b=%d d=%d a=%d ",lineOrigin,collumOrigin,lineDestiny,collumDestiny,b,d,a);
								erro4();
								return false;
							}
						}
					}
					System.out.printf("WB SE outsideloop linOri=%d colOri=%d linDest=%d colDest=%d, b=%d d=%d a= ",lineOrigin,collumOrigin,lineDestiny,collumDestiny,b,d);
						//System.out.printf("linOri=%d colOri=%d linDest=%d colDest=%d, cal1=%d cal2=%d resultado=%d ",lineOrigin,collumOrigin,lineDestiny,collumDestiny,(lineOrigin-lineDestiny),((-1*collumOrigin)-collumDestiny),((lineOrigin-lineDestiny) != ((-1*collumOrigin)-collumDestiny)));
						//return false;
				
				}
				if((lineOrigin<lineDestiny)&&collumOrigin<collumDestiny) {//baixo direita
					int b = lineDestiny-lineOrigin,d=collumDestiny-collumOrigin;
					for(int a=1;a<b;a++) {
						for(int c=1;c<d;c++) {
							System.out.printf("Loop WB BD linOri=%d colOri=%d linDest=%d colDest=%d, b=%d d=%d a=%d c=%d\n",lineOrigin,collumOrigin,lineDestiny,collumDestiny,b,d,a,c);
							if((a==c)&&(board[lineDestiny-a][collumDestiny-c]!=0)) {
								System.out.printf("linOri=%d colOri=%d linDest=%d colDest=%d, b=%d d=%d a=%d ",lineOrigin,collumOrigin,lineDestiny,collumDestiny,b,d,a);
								erro4();
								return false;
							}
						}
					}
					System.out.printf("WB BD outside loop linOri=%d colOri=%d linDest=%d colDest=%d, b=%d d=%d a= ",lineOrigin,collumOrigin,lineDestiny,collumDestiny,b,d);
						//System.out.printf("linOri=%d colOri=%d linDest=%d colDest=%d, cal1=%d cal2=%d resultado=%d ",lineOrigin,collumOrigin,lineDestiny,collumDestiny,(lineOrigin-lineDestiny),((-1*collumOrigin)-collumDestiny),((lineOrigin-lineDestiny) != ((-1*collumOrigin)-collumDestiny)));
						//return false;
				
				}
				if((lineOrigin<lineDestiny)&&collumOrigin>collumDestiny) {//baixo esq
					int b = lineDestiny-lineOrigin,d=collumOrigin-collumDestiny;
					for(int a=1;a<b;a++) {
						for(int c=1;c<d;c++) {
							if((a==c)&&(board[lineDestiny-a][collumDestiny+c]!=0)) {
								System.out.printf("WB BE inside loop linOri=%d colOri=%d linDest=%d colDest=%d, b=%d d=%d a=%d ",lineOrigin,collumOrigin,lineDestiny,collumDestiny,b,d,a);
								erro4();
								return false;
							}
						}
					}
					System.out.printf("WB BE outside loop linOri=%d colOri=%d linDest=%d colDest=%d, b=%d d=%d a= ",lineOrigin,collumOrigin,lineDestiny,collumDestiny,b,d);
						//System.out.printf("linOri=%d colOri=%d linDest=%d colDest=%d, cal1=%d cal2=%d resultado=%d ",lineOrigin,collumOrigin,lineDestiny,collumDestiny,(lineOrigin-lineDestiny),((-1*collumOrigin)-collumDestiny),((lineOrigin-lineDestiny) != ((-1*collumOrigin)-collumDestiny)));
						//return false;
				
				}
				if(lineOrigin==lineDestiny) {
					if(collumOrigin>collumDestiny) {
						int b = collumOrigin-collumDestiny;
						for(int a = 1;a<b;a++) {//MOVIMENTO DA esqueda - direita SE O CAMINHO ESTÁ VAZIO
							System.out.printf("esq - DIR j=%d k=%d b=%d a=%d testando for i maior k \n",lineDestiny,collumDestiny,b,a);
							if(board[lineDestiny][collumDestiny+a]!=EMPTY) {
								System.out.print("Movimento Inválido 1");
								return false;
							}
						}
					}else {//MOVIMENTO DA  direita PRA ESQUERDA SE O CAMINHO ESTÁ VAZIO
						int b = collumDestiny-collumOrigin;
						for(int a = 1;a<b;a++) {
							System.out.printf("DIR - ESQ ELSE j=%d k=%d b=%d a=%d testando for i menor k \n",lineDestiny,collumDestiny,b,a);
							if(board[lineDestiny][collumDestiny-a]!=EMPTY) {
								System.out.print("Movimento Inválido 2");
								return false;
							}
						}
					}
				}
				if(collumOrigin==collumDestiny) {
					if(lineOrigin>lineDestiny) {
						int b = lineOrigin-lineDestiny;
						for(int a = 1;a<b;a++) {//MOVIMENTO BAIXO PRA CIMA SE CAMINHO ESTÁ VAZIO
							System.out.printf("BAIXO cima j=%d k=%d b=%d a=%d testando for m maior j \n",lineDestiny,collumDestiny,b,a);
							//System.out.printf("coteúdo da passagem =%d conteúdo do destino %d ",board[j][k-a],board[j][k]);
							if(board[lineDestiny+a][collumDestiny]!=EMPTY) {
								erro4();
								return false;
							}
						}
					}else {
						int b = lineDestiny-lineOrigin;
						for(int a = 1;a<b;a++) {//MOVIMENTO CIMA PRA BAIXO SE CAMINHO ESTÁ VAZIO
							System.out.printf("CIMA BAIXO else j=%d k=%d b=%d a=%d testando for m menor j \n",lineDestiny,collumDestiny,b,a);
							System.out.printf("coteúdo da passagem =%d conteúdo do destino %d ",board[lineDestiny-a][collumDestiny],board[lineDestiny][collumDestiny]);
							if(board[lineDestiny-a][collumDestiny]!=EMPTY) {
								System.out.print("Movimento Inválido 4");
								return false;
							}
						}
					}
				}
				return true;
			case WHITEKING:
				if((lineOrigin==lineDestiny)&&(collumOrigin==collumDestiny)) {// ORIGEM IGUAL DESTINO
					erro1();
					return false;
				}
				if((board[lineDestiny][collumDestiny] == WHITEBISHOP)||(board[lineDestiny][collumDestiny] == WHITEKING)||(board[lineDestiny][collumDestiny] == WHITEKNIGHT)||(board[lineDestiny][collumDestiny] == WHITEPAWN)||(board[lineDestiny][collumDestiny] == WHITEQUEEN)||(board[lineDestiny][collumDestiny] == WHITETOWER)) {
					erro3();
					return false;
				}
				if(!(lineOrigin-lineDestiny==0 && collumOrigin-collumDestiny==-1 || lineOrigin-lineDestiny==-1 && collumOrigin-collumDestiny==-1 || lineOrigin-lineDestiny==-1 && collumOrigin-collumDestiny==0 || lineOrigin-lineDestiny==0 && collumOrigin-collumDestiny==1 || lineOrigin-lineDestiny==1 && collumOrigin-collumDestiny==0 || lineOrigin-lineDestiny==1 && collumOrigin-collumDestiny==1 || lineOrigin-lineDestiny==-1 && collumOrigin-collumDestiny==0 || lineOrigin-lineDestiny==-1 && collumOrigin-collumDestiny==1 )) {
					erro7();
					return false;
				}
				return true;
		}//fim do switch
		return true;
		
	}
	private void erro3() {
		System.out.print("NÃO PODE COMER PEÇAS ALIADAS");
	}
	//private void ifOriginEgualDestiny(int lineOrigin, int collumOrigin, int lineDestiny, int collumDestiny) {
	//	if((lineOrigin==lineDestiny)&&(collumOrigin==collumDestiny)){// ORIGEM IGUAL DESTINO
		//	System.out.print("Movimento Inválido 1");
			//break;}
	private void erro1() {
		System.out.print("A origem deve ser difente do destino.");
	}
	private void erro2() {
		System.out.print("O bispo só diagonal");
	}
	private void erro4() {
		System.out.print("O caminho não está livre");
	}
	private void erro5() {
		System.out.print("Só em L");
	}
	private void erro6() {
		System.out.print("Não é diagonal ou vertical ou horizontal");
	}
	private void erro7() {
		System.out.print("Rei só move 1 quadrado");
	}
	
}