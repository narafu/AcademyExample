package ex00_Basic02;
import java.util.Random;

public class Ex11_OmokSwitchProgram08 {

	public static void main(String[] args) {

		// ¹è¿­ & ·£´ý

		Random random = new Random();

		int index = 6;
		int[] lotto = new int[index];

		for (int j = 0; j < 5; j++) {
			System.out.printf("[%d] ", j);
			for (int i = 0; i < index; i++) {
				lotto[i] = random.nextInt(45) + 1;
				System.out.printf("%2d ¦¢ ", lotto[i]);
			}
			System.out.println();
		}

	}

}
