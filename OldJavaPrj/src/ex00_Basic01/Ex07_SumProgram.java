package ex00_Basic01;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Scanner;

public class Ex07_SumProgram {

	public static void main(String[] args) throws IOException {

		FileInputStream fis = new FileInputStream("res/ex07data.txt");
		Scanner scan = new Scanner(fis);

//		int a = scan.nextInt();
//		System.out.println(a);
//		int b = scan.nextInt();
//		System.out.println(b);
//		int c = scan.nextInt();
//		System.out.println(c);
//		int d = scan.nextInt();
//		System.out.println(d);
//		int e = scan.nextInt();
//		System.out.println(e);
//		int f = scan.nextInt();
//		System.out.println(f);

//		int x;
//		x = scan.nextInt();
//		System.out.println(x);
//		x = scan.nextInt();
//		System.out.println(x);
//		x = scan.nextInt();
//		System.out.println(x);
//		x = scan.nextInt();
//		System.out.println(x);
//		x = scan.nextInt();
//		System.out.println(x);
//		x = scan.nextInt();
//		System.out.println(x);

//		String num;
//		num = scan.next();
//		System.out.println(num);
//		num = scan.next();
//		System.out.println(num);
//		num = scan.next();
//		System.out.println(num);
//		num = scan.next();
//		System.out.println(num);
//		num = scan.next();
//		System.out.println(num);
//		num = scan.next();
//		System.out.println(num);

		String num;
		int sum = 0;
		while (scan.hasNext()) {
			num = scan.next();
			sum += Integer.parseInt(num); // sum = sum + Integer.parseInt(num);
		}

		scan.close();
		fis.close();

		System.out.println(sum);
	}

}
