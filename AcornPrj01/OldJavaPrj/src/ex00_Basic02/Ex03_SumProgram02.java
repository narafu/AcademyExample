package ex00_Basic02;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.PrintStream;
import java.util.Scanner;

public class Ex03_SumProgram02 {

	public static void main(String[] args) throws IOException {

		FileInputStream fis = new FileInputStream("C:\\Workspace\\data1.txt");
		Scanner scan = new Scanner(fis);
		int x = scan.nextInt();
		int y = scan.nextInt();
		int result = x + y;
		scan.close();
		fis.close();

// 1. 파일 출력을 위한 FileOutputStream 객체 fos를 생성한다.
		FileOutputStream fos = new FileOutputStream("C:\\Workspace\\data2.txt");
// 2. 문자열 출력을 쉽게 하기 위해서 PrintStream 객체 out을 생성한다.
		PrintStream out = new PrintStream(fos);
// 3. out 객체의 println() 함수를 이용해서 result 값을 출력한다.
		out.println(result);
		out.close();
		fos.close();

		System.out.println("작업완료");

	}

}
