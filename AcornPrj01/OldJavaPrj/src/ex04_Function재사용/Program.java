package ex04_FunctionÀç»ç¿ë;

import java.util.Scanner;

public class Program {

	public static void main(String[] args) {

		int[] lotto = new int[6];
		int menu = inputMenu();
		switch (menu) {
		case 1:
			Lotto.genLottoAuto(lotto);
			break;
		case 2:
			Lotto.genLottoManual(lotto);
			break;
		default:
		}

		Lotto.printLotto(lotto);

	}

	private static int inputMenu() {
		Scanner scanner = new Scanner(System.in);
		int x = scanner.nextInt();
		return x;
	}

}