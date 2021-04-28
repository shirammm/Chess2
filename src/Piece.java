
public class Piece {

	public static final int BLACK = 0;
	public static final int WHITE = 1;
	
	public static final int NONE = 0;
	public static final int PAWN = 0b0010;
	public static final int KING = 0b0100;
	public static final int KNIGHT = 0b0110;
	public static final int BISHOP = 0b1010;
	public static final int QUEEN = 0b1100;
	public static final int ROOK = 0b1110;
	
	public static final int pieceMask = 0b1110;
	public static final int colorMask = 0b1;
	
	public static int pieceType(int piece){
		return piece & pieceMask;
	}
	
	public static boolean pieceColor(int piece){
		return (piece & colorMask) == 1;
	}
	
}
