package ex00_Basic02;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Scanner;

public class Ex07_SumProgram02 {

	public static void main(String[] args) throws IOException {

		FileInputStream fis = new FileInputStream("res/data.txt");
		Scanner scan = new Scanner(fis);
		
		String x;
		x = scan.next();
		int y = Integer.parseInt(x);
				
		System.out.println(x);
		System.out.println(y);
		
		scan.close();
	}

}
