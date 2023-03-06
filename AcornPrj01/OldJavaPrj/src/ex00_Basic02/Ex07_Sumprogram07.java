package ex00_Basic02;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Scanner;

public class Ex07_Sumprogram07 {

	public static void main(String[] args) throws IOException {

		FileInputStream fis = new FileInputStream("res/data.txt");

		Scanner scan = new Scanner(fis);

//		res 폴더에 있는 data.txt의 10번째 이후 수의 합을 구하시오.

		String num;
		int total10Up = 0;
		int count = 0;

		while (scan.hasNext()) {
			num = scan.next();
			int n = Integer.parseInt(num);
			count++;
			if (count >= 10)
				total10Up += n;
		}

		scan.close();

		System.out.printf("10번째 이후 수의 합: %d\n", total10Up);
	}
}
