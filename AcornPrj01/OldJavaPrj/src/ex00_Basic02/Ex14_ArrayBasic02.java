package ex00_Basic02;
public class Ex14_ArrayBasic02 {

	public static void main(String[] args) {

//		int[][] lottos = new int[2][6];
//		int[][] lottos = new int[][] {{1,2,3,4,5,6},{7,8,9,10,11,12}} ; // 2차배열 초기화 방법
		int[][] lottos = { { 1, 2, 3, 4, 5, 6 }, { 7, 8, 9, 10, 11, 12 } }; // 2차배열 초기화 방법(자바 1.8버전 이후만)

		for (int i = 0; i < 2; i++) {
			for (int j = 0; j < 6; j++)
				System.out.printf("%2d ", lottos[i][j]);
			System.out.println();
		}

	}
}
