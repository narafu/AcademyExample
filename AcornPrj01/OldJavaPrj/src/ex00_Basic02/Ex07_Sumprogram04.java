package ex00_Basic02;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Scanner;

public class Ex07_Sumprogram04 {

	public static void main(String[] args) throws IOException {

		FileInputStream fis = new FileInputStream("res/data.txt");
		Scanner scan = new Scanner(fis);

		String num;
		int sum;
		sum = 0;

		while (scan.hasNext()) {
			num = scan.next();
			sum += Integer.parseInt(num);
		}

		System.out.println(sum);

		scan.close();

	}
}
