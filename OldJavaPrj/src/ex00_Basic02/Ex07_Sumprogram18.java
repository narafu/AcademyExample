package ex00_Basic02;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Scanner;

public class Ex07_Sumprogram18 {

	public static void main(String[] args) throws IOException {

		FileInputStream fis = new FileInputStream("res/data.txt");
		Scanner scan = new Scanner(fis);

		int index = 0, total = 0, count = 0;
		float avg;

		while (scan.hasNext()) {
			int x = Integer.parseInt(scan.next());
			if (++index >= 30) {
				total += x;
				count++;
			}
		}

		avg = (float) total / count;

		scan.close();
		fis.close();

		System.out.printf("30��° ���� ����: %d\n", total);
		System.out.printf("30��° ���� ���: %6.2f\n", avg);

	}

}

// 30��° ������ ����, ���