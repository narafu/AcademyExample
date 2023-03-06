package ex12_AutoBoxing;

public class Program {

	public static void main(String[] args) {

//		Object x = new Integer(3);
		Object x = Integer.valueOf(3);
		Object y = 3;

		int a = 3; // 기본값 0
		Integer b = 3; // 기본값 null
		int z = a + b; // int 와 Integer 다르다!

		System.out.printf("x is %d\n", x);
		System.out.printf("y is %d\n", y);

	}

}
