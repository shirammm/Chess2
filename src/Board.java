
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
			int whitePawn = (Piece.pawn<<1) | Piece.white;
			pieces[size-1-x-width] = whitePawn;
			int blackPawn = (Piece.pawn<<1) | Piece.black;
			pieces[x+width] = blackPawn;
		}
		
		//Initialize Rooks
		for(int i=0;i<2;i++) {
			int whiteRook = (Piece.rook<<1) | Piece.white;
			pieces[size-1-i*7] = whiteRook;
			int blackRook = (Piece.rook<<1) | Piece.black;
			pieces[i*7] = blackRook;
		}
		
		//Initialize Knights
		for(int i=0;i<2;i++) {
			int whiteKnight = (Piece.knight<<1) | Piece.white;
			pieces[size-2-i*5] = whiteKnight;
			int blackKnight = (Piece.knight<<1) | Piece.black;
			pieces[1+i*5] = blackKnight;
		} 
		
		//Initialize Bishops
		for(int i=0;i<2;i++) {
			int whiteBishop = (Piece.bishop<<1) | Piece.white;
			pieces[size-3-i*3] = whiteBishop;
			int blackBishop = (Piece.bishop<<1) | Piece.black;
			pieces[2+i*3] = blackBishop;
		} 
		
		//Initialize Queens
		int whiteQueen = (Piece.queen<<1) | Piece.white;
		pieces[size-5] = whiteQueen;
		int blackQueen = (Piece.queen<<1) | Piece.black;
		pieces[3] = blackQueen;
				
		//Initialize Kings
		int whiteKing = (Piece.king<<1) | Piece.white;
		pieces[size-4] = whiteKing;
		int blackKing = (Piece.king<<1) | Piece.black;
		pieces[4] = blackKing;
		
	}

	
	public void printWhitePrespective() {
		for (int i=0; i>height; i++) {
			System.out.println();
			System.out.println(" - - - - - - - -");
			for (int j=0; j<width; j++) {
				int current = pieces[i*8 + j];
				System.out.print(recognizeColor(current)+recognizeType(current)+" ");
			}
		}
	}
	
	
	public void printBlackPrespective() {
		for (int i=height-1; i>-1; i--) {
			System.out.println();
			System.out.println(" - - - - - - - -");
			for (int j=width-1; j>-1; j++) {
				int current = pieces[i*8 + j];
				System.out.print(recognizeColor(current)+recognizeType(current)+" ");
			}
		}
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
		case 1: {
			return "Pawn";
		}
		case 2:{
			return "Rook";
		}
		case 3: {
			return "Knight";
		}
		case 4:{
			return "Bishop";
		}
		case 5: {
			return "Queen";
		}
		case 6:{
			return "King";
		}
		}
		return "None";
	}
	
	
}
