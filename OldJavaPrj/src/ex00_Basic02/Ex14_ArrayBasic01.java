package ex00_Basic02;
public class Ex14_ArrayBasic01 {

	public static void main(String[] args) {

		int[] nums = new int[] { 1, 2, 3, 4, 5, 6, 7, 8, 9, 10 }; // 배열에 값을 넣어서 만든다 (초기화)
		int[] numbers = { 1, 2, 3, 4, 5, 6, 7, 8, 9, 10 }; // 위랑 같은 식 (자바 1.8버전 이후만 가능)

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
