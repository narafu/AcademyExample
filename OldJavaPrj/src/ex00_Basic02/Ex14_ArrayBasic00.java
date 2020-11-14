package ex00_Basic02;
public class Ex14_ArrayBasic00 {

	public static void main(String[] args) {

		int[] nums = new int[10];

		for (int i = 0; i < 10; i++)
			nums[i] = i + 1;

		for (int i = 0; i < 10; i++) {
			System.out.printf("%d", nums[i]);
			if (i < 9)
				System.out.print(", ");
		}

		System.out.println();

	}
}
