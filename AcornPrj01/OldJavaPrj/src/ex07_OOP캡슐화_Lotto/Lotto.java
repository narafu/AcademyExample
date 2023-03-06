package ex07_OOPĸ��ȭ_Lotto;

import java.util.Random;
import java.util.Scanner;

public class Lotto {

	private int[] nums; // Lotto �� ��ȣ��(�Ӽ�)

	public Lotto() {

		this.nums = new int[6];

	}

	public void genAuto() {

		System.out.println("���� ���Դϴ�.");

		Random rand = new Random();
		for (int i = 0; i < 6; i++) {
			this.nums[i] = rand.nextInt(45) + 1;
		}
	}

	public void genManual() {

		Scanner scan = new Scanner(System.in);
		System.out.println("���� �� �Է� �ϼ���~");

		for (int i = 0; i < 6; i++) {
			int num = Integer.parseInt(scan.next());
			this.nums[i] = num;

		}

	}

	public void print() {
		for (int i = 0; i < 6; i++)
			System.out.printf("%d ", this.nums[i]);
		System.out.println();
	}

}
