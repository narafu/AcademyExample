package ex00_Basic01;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.PrintStream;
import java.util.Scanner;

public class Ex01_Hello03 {
	public static void main(String[] args) throws IOException {

		FileOutputStream fos = new FileOutputStream("C:\\workspace\\print.txt");
		PrintStream ps = new PrintStream(fos);
		ps.print(65); // 2Byte - 문자열
		
		FileOutputStream foss = new FileOutputStream("C:\\workspace\\write.txt");
		foss.write(65); // 1Byte - 숫자
		
		FileOutputStream fosss = new FileOutputStream("C:\\workspace\\write300.txt");
		fosss.write(300);
		
		FileOutputStream fossss = new FileOutputStream("C:\\workspace\\write3000.txt");
		fossss.write(3000);
		
		FileInputStream fis = new FileInputStream("C:\\workspace\\print.txt");
		Scanner scan = new Scanner(fis);
		int x = scan.nextInt();
		
		System.out.println(x);
		
		
//		char x = 'A';
//		x = x + 1;
//		int ((int)x)+1;
//		System.out.println(x+1);
		
	}
}