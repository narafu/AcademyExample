package ex00_Basic02;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Scanner;

public class Ex07_Sumprogram15 {

	public static void main(String[] args) throws IOException {

		FileInputStream fis = new FileInputStream("res/data.txt");
		Scanner scan = new Scanner(fis);

		int index = 0, count = 0, total = 0;
		float avg;

		while (scan.hasNext()) {
			int n = Integer.parseInt(scan.next());
			if (++index >= 10)
				total += n;
			++count;
		}

		scan.close();
		fis.close();

		avg = (float) total / count;

		System.out.printf("10��° ������ ����: %d\n", total);
		System.out.printf("10��° ������ ���: %6.2f\n", avg);

	}

}

// 10��° ������ ����, ���