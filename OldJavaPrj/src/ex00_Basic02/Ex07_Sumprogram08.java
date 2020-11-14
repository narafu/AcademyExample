package ex00_Basic02;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Scanner;

public class Ex07_Sumprogram08 {

	public static void main(String[] args) throws IOException {

		FileInputStream fis = new FileInputStream("res/data.txt");
		Scanner scan = new Scanner(fis);

//		res������ �ִ� data.txt���� 15��° ������ ����� ���ϼ���.

		int count = 0;
		int total15Up = 0;

		while (scan.hasNext()) {
			String num = scan.next();
			int n = Integer.parseInt(num);
			count++;
			if (count >= 15)
				total15Up += n;
		}

		float avg15Up = (float) total15Up / (count - 14);

		scan.close();

		System.out.printf("15��° ���� ���� ������ %d\n", total15Up);
		System.out.printf("15��° ���� ���� ����� %f\n", avg15Up);
	}
}
