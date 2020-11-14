package review._0320;

import java.util.Scanner;

public class Stone {

	private int[] blackX, blackY, whiteX, whiteY;
	private int countB, countW;

	public Stone(int size) {
		blackX = new int[size];
		blackY = new int[size];
		whiteX = new int[size];
		whiteY = new int[size];
	}

	public void inputB(int size) {

		Scanner scan = new Scanner(System.in);

		System.out.print("\n흑돌을 입력하세요.(x, y) > ");
		blackX[countB] = scan.nextInt();
		blackY[countB] = scan.nextInt();

	}

	public void inputW(int size) {

		Scanner scan = new Scanner(System.in);
		
		System.out.print("\n백돌을 입력하세요.(x, y) > ");
		whiteX[countW] = scan.nextInt();
		whiteY[countW] = scan.nextInt();

	}

	public int[] getBlackX() {
		return blackX;
	}

	public int[] getBlackY() {
		return blackY;
	}

	public int[] getWhiteX() {
		return whiteX;
	}

	public int[] getWhiteY() {
		return whiteY;
	}

	public int getCountB() {
		return countB;
	}

	public int getCountW() {
		return countW;
	}

	public void setCountB(int countB) {
		this.countB = countB;
	}

	public void setCountW(int countW) {
		this.countW = countW;
	}

}
