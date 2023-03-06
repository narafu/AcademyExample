package ex00_Basic01;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.PrintStream;
import java.util.Scanner;

public class Ex03_SumProgram06 {

	public static void main(String[] args) throws IOException {

		FileInputStream fis = new FileInputStream("C:\\workspace\\data.txt");
		Scanner scan = new Scanner(fis);
		int x = scan.nextInt();
		int y = scan.nextInt();
		int result = x + y;
		scan.close(); // 생성한 역순으로 닫아야 한다.
		fis.close(); // 생성한 역순으로 닫아야 한다.

		FileOutputStream fos = new FileOutputStream("C:\\workspace\\data2.txt");
//		1. 파일 출력을 위한 FileOutputStream 객체 fos를 생성한다.
		PrintStream out = new PrintStream(fos);
//		2. 문자열 출력을 쉽게 하기 위해서 PrintStream 객체 out을 생성한다.
		out.println(result);
//		3. out 객체의 println() 함수를 이용해서 result 값을 출력한다.
		out.close();
		fos.close();
						
		System.out.println("작업완료");
		
	}

}
