package code;

public class KnightsTour {

	public static void main(String[] args) {
		LinkedGrid list = new LinkedGrid(5); //chess board is normally 8 but 8 takes too long to test.
		list.display();
		list.startTour();
	}

}
