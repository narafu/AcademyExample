package ex00_Basic02;
public class Ex14_ArrayBasic01 {

	public static void main(String[] args) {

		int[] nums = new int[] { 1, 2, 3, 4, 5, 6, 7, 8, 9, 10 }; // �迭�� ���� �־ ����� (�ʱ�ȭ)
		int[] numbers = { 1, 2, 3, 4, 5, 6, 7, 8, 9, 10 }; // ���� ���� �� (�ڹ� 1.8���� ���ĸ� ����)

		for (int i = 0; i < 10; i++) {
			System.out.printf("%d", nums[i]);
			if (i < 9)
				System.out.print(", ");
		}

		System.out.println();

		for (int i = 0; i < 10; i++) {
			System.out.printf("%d", numbers[i]);
			if (i < 9)
				System.out.print(", ");
		}

	}
}
