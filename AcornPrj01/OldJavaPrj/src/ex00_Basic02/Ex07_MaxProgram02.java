package ex00_Basic02;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Scanner;

public class Ex07_MaxProgram02 {

	public static void main(String[] args) throws IOException {

		FileInputStream fis = new FileInputStream("res/data.txt");
		Scanner scan = new Scanner(fis);

		int max = Integer.parseInt(scan.next());

		while (scan.hasNext()) {
			int n = Integer.parseInt(scan.next());

			if (max < n)
				max = n;

		}

		scan.close();
		fis.close();

		System.out.printf("최대값은 %d\n", max);

	}

}
