package ex13_예외처리;

public class Calculator {

	public static int add(int x, int y) throws 백을넘는예외 {

		int result = x + y;

		if (100 < x)
			throw new 백을넘는예외();
		// 내가 처리하지 않고 나를 사용하는 놈한테 던지갰다는 의미

		return result;

	}

	public static int sub(int x, int y) throws 음수를만드는예외 {

		int result = x - y;

		if (x < y)
			throw new 음수를만드는예외();

		return result;

	}

	public static int div(int x, int y) {

		int result = x / y;

		return result;

	}

}