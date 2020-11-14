package ex07_OOP캡슐화_Lotto;

import java.util.Random;
import java.util.Scanner;

public class Lotto {

	private int[] nums; // Lotto 의 번호들(속성)

	public Lotto() {

		this.nums = new int[6];

	}

	public void genAuto() {

		System.out.println("랜덤 값입니당.");

		Random rand = new Random();
		for (int i = 0; i < 6; i++) {
			this.nums[i] = rand.nextInt(45) + 1;
		}
	}

	public void genManual() {

		Scanner scan = new Scanner(System.in);
		System.out.println("수동 값 입력 하세요~");

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
