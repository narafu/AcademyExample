package ex03_ShootingGame;

import ex03_ShootingGame.ui.ShootingFrame;

public class Program {

	public static void main(String[] args) {

		ShootingFrame frame = new ShootingFrame();

		frame.setVisible(true);
		// -> frame.repaint
		// -> frame.update
		// -> frame.paint
		frame.setSize(600, 1000);

		// ��Ʈ������: ��Ʈ ������ ������ �ϴ� ������ - ���������� �ʹ� Ŀ�� ��Ʈ������ �����ؾ��� �� ����Ѵ�.
//		int x = 0b0000_0000_0000_0000_0000_0000_0000_1111;
//		int y = 0x0000005;
//		int z = x | y;
//		System.out.printf("(x: %d), (y: %d), (z: %d)\n", x, y, z);

//		N(0001), NE(0011)
//		E(0010), ES(0110)
//		S(0100), SW(1100)
//		W(1000), NW(1001)

//		���� = 0000_0001 / ���� + â: 0000_0011
//		â = 0000_0010
//		�Ź� = 0000_0100

//		|(��) &(��) ^(��) ~(����)

//		int ���������� = 0b0000_0000_0000_0000_0000_0000_0000_0000;
//		final int ���� = 0b0000_0000_0000_0000_0000_0000_0000_0001;
//		final int ���� = 0b0000_0000_0000_0000_0000_0000_0000_0010;
//		final int �Ź� = 0b0000_0000_0000_0000_0000_0000_0000_0100;

//		System.out.printf("���������� ��Ȳ\n%s\n", Integer.toBinaryString(����������));
//		int temp = Integer.parseInt(Integer.toBinaryString(����������));
//		System.out.printf("���������� ��Ȳ\n%032d\n", temp);
//
//		���������� |= �Ź�;
//		���������� |= ����;
//		temp = Integer.parseInt(Integer.toBinaryString(����������));
//		System.out.printf("���������� ��Ȳ\n%032d\n", temp);
//
//		���������� ^= ����; /* =(���������� &= ~����); */
//		temp = Integer.parseInt(Integer.toBinaryString(����������));
//		System.out.printf("���������� ��Ȳ\n%032d\n", temp);
//
//		// ����Ʈ ������
//		���������� <<= 2;
//		temp = Integer.parseInt(Integer.toBinaryString(����������));
//		System.out.printf("���������� ��Ȳ\n%032d\n", temp);
//
//		int pos = 0;
//		// (7, 5) -> pos
//		pos = (7 << 8) | 5;
//		temp = Integer.parseInt(Integer.toString(pos, 2));
//		System.out.printf("pos:\n%032d\n", temp);

	}

}
