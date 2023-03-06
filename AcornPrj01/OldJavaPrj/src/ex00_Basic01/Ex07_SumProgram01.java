package ex00_Basic01;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Scanner;

public class Ex07_SumProgram01 {

	public static void main(String[] args) throws IOException {

		FileInputStream fis = new FileInputStream("res/ex07data.txt");
		Scanner scan = new Scanner(fis);

		String num;
		int total = 0;
		int count = 0;
		while (scan.hasNext()) {
			num = scan.next();
			total += Integer.parseInt(num);
			count++; // count = count + 1
		}

		scan.close();
		fis.close();

		System.out.printf("total is %d\n", total);
		System.out.printf("count is %d\n", count);
	}

}
