package ex00_Basic01;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Scanner;

public class Ex03_SumProgram05 {

	public static void main(String[] args) throws IOException {

		FileInputStream fis = new FileInputStream("C:\\workspace\\data.txt");
// 1. ���� �Է� ���� ��ü fis�� �����Ѵ�.
		Scanner scan = new Scanner(fis);
// 2. fis ��ü�� �̿��ؼ� �ܾ�� �о��ִ� Scanner ��ü scan�� �����Ѵ�.
		int x = scan.nextInt();
// 3. scan�� ��� nextInt �Լ��� �̿��ؼ� ù ��° ���� ���� �о x ������ �����Ѵ�.
		int y = scan.nextInt();
// 4. nextInt() �Լ��� �ٽ� ȣ���ؼ� �ι�° �������� �о y ������ �����Ѵ�.	
		scan.close();
		System.out.println(x + y);
// 5. x�� y���� ���� ����� ȭ�鿡 ����Ѵ�.
		
	}

}
