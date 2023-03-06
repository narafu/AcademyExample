package ex00_Basic02;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.PrintStream;
import java.util.Scanner;

public class Ex03_SumProgram04 {

	public static void main(String[] args) throws IOException {

		FileOutputStream fis = new FileOutputStream("C:\\Workspace\\example1.txt");
		PrintStream out = new PrintStream(fis);
		out.printf("%d %d %d", 23, 41, 52);
		out.close();

		FileInputStream fos = new FileInputStream("C:\\Workspace\\example1.txt");
		Scanner scan = new Scanner(fos);
		int x = scan.nextInt();
		int y = scan.nextInt();
		int z = scan.nextInt();
		int total = x + y + z;
		scan.close();
		fos.close();

		System.out.println(total);
		System.out.println("작업완료");

	}

}
