package ex00_Basic02;
import java.util.Random;

public class Ex12_LottoProgram05 {

	public static void main(String[] args) {

		Random random = new Random();
		int[] lotto = new int[6];

		for (int i = 0; i < 6; i++) {
			lotto[i] = random.nextInt(45) + 1;
			System.out.printf("%d ", lotto[i]);
		}

	}

}
