
public class Piece {

	public static final int BLACK = 0;
	public static final int WHITE = 1;
	
	public static final int NONE = 0;
	public static final int PAWN = 1;
	public static final int KING = 2;
	public static final int KNIGHT = 3;
	public static final int BISHOP = 5;
	public static final int QUEEN = 6;
	public static final int ROOK = 7;
	
	public static final int pieceMask = 0b1110;
	public static final int colorMask = 0b1;
	
	public static int pieceType(int piece){
		return piece & pieceMask;
	}
	
	public static boolean pieceColor(int piece){
		return (piece & colorMask) == 1;
	}
	
}
