package review._0320;

public class Board {

	private String[][] board;
	private Stone stone;
	private int x, y;

	public Board(int size) {

		stone = new Stone(size);

		board = new String[size][size];
		for (int y = 0; y < size; y++) {
			for (int x = 0; x < size; x++) {
				board[y][x] = "¦«¦¡";
			}
		}

		print(size);

	}

	public void inputBlack(int size) {

		stone.inputB(size);

		int count = stone.getCountB();
		int bx = stone.getBlackX()[count];
		int by = stone.getBlackY()[count];
		board[by][bx] = "¡Ü ";

		stone.setCountB(++count);

		print(size);

	}

	public void inputWhite(int size) {

		stone.inputW(size);

		int count = stone.getCountW();
		int wx = stone.getWhiteX()[stone.getCountW()];
		int wy = stone.getWhiteY()[stone.getCountW()];
		board[wy][wx] = "¡Û ";

		stone.setCountW(++count);

		print(size);

	}

	public void print(int size) {

		System.out.println();
		for (int y = 0; y < size; y++) {
			for (int x = 0; x < size; x++) {
				System.out.printf(board[y][x]);
			}
			System.out.println();
		}
	}

}
