package ex09_OOP_Has_A���_Exam;

import java.util.Random;
import java.util.Scanner;

public class Lotto {

	private int[] nums;

	public Lotto() {
		this.nums = new int[6];
	}

	public void genAuto() {
		System.out.println("�ڵ��Դϴ�.");
		Random rand = new Random();
		for (int i = 0; i < 6; i++) {
			this.nums[i] = rand.nextInt(45) + 1;
		}
	}

	public void genManual() {
		Scanner scan = new Scanner(System.in);
		System.out.println("�����Դϴ�.");
		for (int i = 0; i < 6; i++) {
			int num = Integer.parseInt(scan.next());
			this.nums[i] = num;
		}
	}

	public int[] getNums() {
		return nums;
	}

	public void setNums(int[] nums) {
		this.nums = nums;
	}

}
