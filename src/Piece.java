
public class Piece {

	public static final int black = 0b0;
	public static final int white = 0b1;
	
	public static final int pawn = 0b001;
	public static final int rook = 0b010;
	public static final int knight = 0b011;
	public static final int bishop = 0b100;
	public static final int queen = 0b101;
	public static final int king = 0b111;
	
	
	public static int pieceType(int piece){
		return piece & 0b1110;
	}
	
	public static boolean pieceColor(int piece){
		return (piece & 0b1) == 1;
	}
	
}
