package view;

import java.util.Scanner;

import controller.Engine;

public class Start {

	private static Scanner sc;
	private int toStart;
	private boolean start = true;
	private int level;
	private int toPiece;
	private boolean piece;

	public void start() {
//		while(true){
//			System.out.println("In�cio - Jogo da Velha");
			sc = new Scanner(System.in);
//			while(true){
//				System.out.println("Quer come�ar? Se sim digite: 0. Se n�o digite: 1 ");
//				toStart = sc.nextInt();
//				if( toStart == 0 || toStart == 1){
//					if(toStart==0) start =true;
//					else start = false;
//					break;
//				}		
//			}
//			while(true){
//				System.out.println("Quer ser X ou O? Se X, digite: true. Se n�o digite: false ");
//				toPiece = sc.nextInt();
//				if( toPiece == 0 || toPiece == 1){
//					if(toStart==0) piece =true;
//					else piece = false;
//					break;
//				}
//			}
//			while(true){
//				System.out.println("Escolha o n�vel. Para f�cil, digite 0 , m�dio 1, d�ficil 2.");
//				level = sc.nextInt();
//				if( level == 0 || level == 1 || level == 2) break;
//				//GameMaster newGame = new GameMaster(start, piece, level);
//			}
			play();
		}
//	}
public void play(){
		
		Board board = new Board();
		Engine engine = new Engine(level, board.getBoard());
				
		boolean loop = true;
		while (loop) {
			//board.reset();

			boolean inGameJogo = true;
			board.setupInicial();
			board.playerView(true);
			while (inGameJogo) {

				//if (start) {
					
					//Engine.print();//debug
					                 //board.playerPlay(getEixoX(), getEixoY());
					//engine.view();//debug
					                 //engine.update();
					                //board.playerView(piece);
					//System.out.printf("a \n");
					board.viewDecimal();//DEBUG
					
					board.playerMove(getOriginLetter(), getOriginNumber(), getDestinyLetter(), getDestinyNumber());
					board.playerView(true);
					//board.viewtest(); //funcionando com switch case
					//if(end()) break;
					start = false;
				//}
				//Engine.print();//debug
			//				start = true;
			//				System.out.println("Vez do computador.");
			//				board.setBoard(engine.moviment());
			//				
				//engine.view();//debug
			//				engine.update();
			//				board.playerView(piece);
			//				//board.view();//DEBUG
				//if(end()) break;
			}
				break;	
		}

	}
public boolean end(){
	if (Engine.velha()) {
		System.out.println("Deu velha.");
		return true;
	}
	if (Engine.aiWin()) {
		System.out.println("Você Perdeu.");
		return true;
	}
	if (Engine.playerWin()) {
		System.out.println("Você Ganhou.");
		return true;
	}
return false;
}
	public char getOriginLetter() {
		System.out.println("Escolha uma letra, para selecionar a coluna de origem (a-h)");
		return sc.next().charAt(0);
	}
	public int getOriginNumber() {
		System.out.println("Escolha um número, para selecionar a linha de origem (1-8)");	
		return sc.nextInt();
	}
	public char getDestinyLetter() {
		System.out.println("Escolha uma letra, para selecionar a coluna de destino (a-h)");
		return sc.next().charAt(0);
	}
	public int getDestinyNumber() {
		System.out.println("Escolha um número, para selecionar a linha de destino (1-8)");	
		return sc.nextInt();
	}
	
}
