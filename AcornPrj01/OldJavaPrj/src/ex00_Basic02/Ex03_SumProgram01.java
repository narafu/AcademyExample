package ex00_Basic02;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Scanner;

public class Ex03_SumProgram01 {

	public static void main(String[] args) throws IOException {

		FileInputStream fis = new FileInputStream("C:\\Workspace\\data1.txt");
// 1. 파일 입력 버퍼 객체 fis를 생성한다.
		Scanner scan = new Scanner(fis);
// 2. fis 객체를 이용해서 단어로 읽어주는 Scanner 객체 scan을 생성한다.
		int x = scan.nextInt();
// 3. scan의 기능 nextInt() 함수를 이용해서 첫번째 정수 값을 읽어서 x 변수에 대입한다.
		int y = scan.nextInt();
// 4. nextInt() 함수를 다시 호출해서 두번째 정수값을 읽어서 y 변수에 대입한다.
		System.out.println(x + y);
// 5. x와 y값을 더한 결과를 화면에 출력한다.
		scan.close();
		fis.close();
		
	}

}
