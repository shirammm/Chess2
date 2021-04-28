
public class main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Board b = new Board();
		System.out.println(b.recognizeType(0b1111));
		b.printWhitePrespective();
		System.out.println("\n\n*******************************************************\n");
		b.printBlackPrespective();
	}

}
