package ex00_Basic02;
public class Ex14_ArrayBasic03 {

	public static void main(String[] args) {

//		int[][] lottos = new int[2][6];
//		int[][] lottos = new int[][] {{1,2,3,4,5,6},{7,8,9,10,11,12}} ; // 2���迭 �ʱ�ȭ ���
		int[][] lottos = { { 1, 2, 3, 4, 5, 6 }, { 7, 8, 9, 10, 11, 12 } }; // 2���迭 �ʱ�ȭ ���(�ڹ� 1.8���� ���ĸ�)

		for (int i = 0; i < 2; i++) {
			for (int j = 0; j < 6; j++)
				System.out.printf("%2d ", lottos[i][j]);
			System.out.println();
		}

		
		
	}
}
