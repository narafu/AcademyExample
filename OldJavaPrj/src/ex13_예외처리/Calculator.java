package ex13_����ó��;

public class Calculator {

	public static int add(int x, int y) throws �����Ѵ¿��� {

		int result = x + y;

		if (100 < x)
			throw new �����Ѵ¿���();
		// ���� ó������ �ʰ� ���� ����ϴ� ������ �������ٴ� �ǹ�

		return result;

	}

	public static int sub(int x, int y) throws ����������¿��� {

		int result = x - y;

		if (x < y)
			throw new ����������¿���();

		return result;

	}

	public static int div(int x, int y) {

		int result = x / y;

		return result;

	}

}