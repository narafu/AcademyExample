package ex00_Basic02;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Scanner;

public class Ex07_Sumprogram06 {

	public static void main(String[] args) throws IOException {

//	res ������ �ִ� data.txt�� ��� ������ ���� ���Ͻÿ�.

		FileInputStream fis = new FileInputStream("res/data.txt");
		Scanner scan = new Scanner(fis);

		int sum = 0;

		while (scan.hasNext()) {
			String num = scan.next();
			int n = Integer.parseInt(num);
//			System.out.println(n);
			sum += n;
		}

		scan.close();
		fis.close();

		System.out.println(sum);

	}
}
