package ex00_Basic02;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Scanner;

public class Ex07_Sumprogram09 {

	public static void main(String[] args) throws IOException {

		FileInputStream fis = new FileInputStream("res/data.txt");

		Scanner scan = new Scanner(fis);

		int count = 0;
		int total30Up = 0;
		float avg30Up = 0;

		while (scan.hasNext()) {

			String num = scan.next();
			int n = Integer.parseInt(num);
			count++;

			if (count >= 30)
				total30Up += n;

		}

		avg30Up = (float) total30Up / count - 29;

		scan.close();

		System.out.printf("30��° ���� ������ ����: %d\n", total30Up);
		System.out.printf("30��° ���� ������ ���: %f\n", avg30Up);

	}
}

// 1. res������ data.txt���� 30��° ������ ������ ���Ͻÿ�.
// 2. res������ data.txt���� 30��° ������ ����� ���Ͻÿ�.
