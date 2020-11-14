package ex04_FunctionÀç»ç¿ë;

import java.util.Random;
import java.util.Scanner;

public class Lotto {

	public static void printLotto(int[] lotto) {
		for (int i = 0; i < 6; i++)
			System.out.printf("%d ", lotto[i]);
		System.out.println();
	}

	public static void genLottoManual(int[] lotto) {
		Scanner scanner = new Scanner(System.in);
		for (int i = 0; i < lotto.length; i++) {
			int num = Integer.parseInt(scanner.next());
			lotto[i] = num;
		}
	}

	public static void genLottoAuto(int[] lotto) {
		Random rand = new Random();
		for (int i = 0; i < 6; i++)
			lotto[i] = rand.nextInt(45) + 1;
	}

}
