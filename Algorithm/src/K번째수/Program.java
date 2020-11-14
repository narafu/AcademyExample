package K번째수;

import java.util.Arrays;

public class Program {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		int[] array = { 1, 5, 2, 6, 3, 7, 4 };
		int[][] commands = { { 2, 5, 3 }, { 4, 4, 1 }, { 1, 7, 3 } };

		Solution solution = new Solution();
		int[] answer = solution.solution(array, commands);

		// 출력
		System.out.println("array : " + Arrays.toString(array));
		System.out.printf("commands : [%s], [%s], [%s]\n", Arrays.toString(commands[0]), Arrays.toString(commands[1]),
				Arrays.toString(commands[2]));
		System.out.println("answer : " + Arrays.toString(answer));

	}

}
