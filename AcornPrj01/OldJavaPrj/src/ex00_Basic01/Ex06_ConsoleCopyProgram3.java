package ex00_Basic01;
public class Ex06_ConsoleCopyProgram3 {

	public static void main(String[] args) {

		byte a = 3; // byte(1) ���Ŀ� int(4) ���� ��Ҵ�. / �⺻ũ�Ⱑ 4byte
//		byte b = 3L; // byte(1) ���Ŀ� long(8) ���� ��Ҵ�. / ���İ� ���� �ٸ�����, ���� �� �� Ŀ��, ����
		int c = a; // int(4) ���Ŀ� byte(1) ���� ��Ҵ�. / ���İ� ���� �ٸ�����, ������ �� Ŀ��, �ڵ���ȯ
		
//		float d = 3.4; // float(4) ���Ŀ� double(8) ���� ��Ҵ�. / ���İ� ���� �ٸ�����, ���� �� �� Ŀ��, ����
		double e = 3.4f; // double(8) ���Ŀ� float(4) ���� ��Ҵ�. / ���İ� ���� �ٸ�����, ������ �� Ŀ��, �ڵ���ȯ
		double f = 3; // double(8) ���Ŀ� int(4) ���� ��Ҵ�. / ���İ� ���� �ٸ�����, ������ �� Ŀ��, �ڵ���ȯ
//		int g = 3.4f; // int(4) ���Ŀ� float(4) ���� ��Ҵ�. / ũ��� ������, ���� ������ �Ǽ� ���̶� ����?

		char h = 65; // char(2) ���Ŀ� int(4) ���� ��Ҵ�. / ������ ����ȯ
		int i = 'A'; // int(4) ���Ŀ� char(2) ���� ��Ҵ�. / ������ ����ȯ
//		System.out.println(h);
		
//		boolean j = 1; // X
//		boolean k = (boolean) 1; // X
		
		// ���İ� ���� ���̰� ���� ��, �Ǵ� ����, ������ ����ȯ �����̴�.
		
//		String l = 3.4;
		String.valueOf(3.4); // �Ǽ��� ���ڿ��� 
		
//		float m = "3.4";
		Float.parseFloat("3.4"); // ���ڿ��� �Ǽ���

//		int n = "3";
		Integer.parseInt("3"); // ���ڿ��� ������
		
//		boolean o = "true";
		Boolean.parseBoolean("true"); // ���ڿ��� �ο��
		
		String p = "34.2";
		Double.parseDouble("34.2"); // ���ڿ��� �Ǽ�double��
		

	}

}