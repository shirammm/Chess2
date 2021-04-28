
public class Board {

	private int[] pieces;
	private boolean isInCheck;
	private final int width = 8;		
	private final int height = 8;	
	private final int size = 64;
	
	public Board(){
		pieces = new int[size];
		initializePiecesArray();
		initializePieces();
		isInCheck = false;
	}
	
	//to make sure the rest of the array is all zeros
	private void initializePiecesArray() {
		for(int x = 16; x < 48; x++) 
			pieces[x]=0; 
	}
	
	private void initializePieces() {
	
		//Initialize Pawns
		for(int x = 0; x < width; x++) {
			int whitePawn = Piece.PAWN | Piece.WHITE;
			pieces[size-1-x-width] = whitePawn;
			int blackPawn = Piece.PAWN | Piece.BLACK;
			pieces[x+width] = blackPawn;
		}
		
		//Initialize Rooks
		for(int i=0;i<2;i++) {
			int whiteRook = Piece.ROOK | Piece.WHITE;
			pieces[size-1-i*7] = whiteRook;
			int blackRook = Piece.ROOK | Piece.BLACK;
			pieces[i*7] = blackRook;
		}
		
		//Initialize Knights
		for(int i=0;i<2;i++) {
			int whiteKnight = Piece.KNIGHT | Piece.WHITE;
			pieces[size-2-i*5] = whiteKnight;
			int blackKnight = Piece.KNIGHT | Piece.BLACK;
			pieces[1+i*5] = blackKnight;
		} 
		
		//Initialize Bishops
		for(int i=0;i<2;i++) {
			int whiteBishop = Piece.BISHOP | Piece.WHITE;
			pieces[size-3-i*3] = whiteBishop;
			int blackBishop = Piece.BISHOP | Piece.BLACK;
			pieces[2+i*3] = blackBishop;
		} 
		
		//Initialize Queens
		int whiteQueen = Piece.QUEEN | Piece.WHITE;
		pieces[size-5] = whiteQueen;
		int blackQueen = Piece.QUEEN | Piece.BLACK;
		pieces[3] = blackQueen;
				
		//Initialize Kings
		int whiteKing = Piece.KING | Piece.WHITE;
		pieces[size-4] = whiteKing;
		int blackKing = Piece.KING | Piece.BLACK;
		pieces[4] = blackKing;
		
	}

	
	public void printWhitePrespective() {
		System.out.println("White Prespective:");
		for (int i=0; i<height; i++) {
			System.out.println();
			System.out.println(" - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - -");
			System.out.print(" | ");
			for (int j=0; j<width; j++) {
				int current = pieces[i*8 + j];
				if(current==0)
					System.out.print("       |");
				else
					System.out.print(recognizeColor(current)+recognizeType(current)+" | ");
			}
		}
		System.out.println();
	}
	
	
	public void printBlackPrespective() {
		System.out.println("Black Prespective:");
		for (int i=height-1; i>-1; i--) {
			System.out.println();
			System.out.println(" - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - -");
			System.out.print(" | ");
			for (int j=width-1; j>-1; j--) {
				int current = pieces[i*8 + j];
				if(current==0)
					System.out.print("       |");
				else
					System.out.print(recognizeColor(current)+recognizeType(current)+" | ");
			}
		}
		System.out.println();
	}
	
	
	public String recognizeColor(int piece) {
		String color = "b";
		if(Piece.pieceColor(piece))
			color="w";
		return color;
	}
	
	
	public String recognizeType(int piece) {
		int type = Piece.pieceType(piece);
		switch (type) {
		case 2: {
			return "PAWN";
		}
		case 4:{
			return "KING";
		}
		case 6: {
			return "KNIGHT";
		}
		case 10:{
			return "BISHOP";
		}
		case 12: {
			return "QUEEN";
		}
		case 14:{
			return "ROOK";
		}
		}
		return "None";
	}
	
	
}
