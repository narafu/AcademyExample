package ex12_AutoBoxing;

public class Program {

	public static void main(String[] args) {

//		Object x = new Integer(3);
		Object x = Integer.valueOf(3);
		Object y = 3;

		int a = 3; // �⺻�� 0
		Integer b = 3; // �⺻�� null
		int z = a + b; // int �� Integer �ٸ���!

		System.out.printf("x is %d\n", x);
		System.out.printf("y is %d\n", y);

	}

}
