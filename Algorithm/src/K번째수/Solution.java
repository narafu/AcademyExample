package K번째수;

public class Solution {

	public int[] solution(int[] array, int[][] commands) {

		int length = commands.length;
		int[] answer = new int[length];

		for (int i = 0; i < length; i++) {

			int startNum = commands[i][0] - 1;
			int lastNum = commands[i][1];
			int indexNum = commands[i][2] - 1;

			int[] array_ = new int[lastNum - startNum];

			int index = 0;
			for (int j = startNum; j < lastNum; j++) {
				array_[index++] = array[j];
			}

			array_ = sort(array_);
			answer[i] = array_[indexNum];
		}

		
		return answer;
	}

	public int[] sort(int[] arr) {

		for (int i = 0; i < arr.length; i++) {
			for (int j = 0; j < arr.length - i - 1; j++) {
				if (arr[j] > arr[j + 1]) {
					int temp = arr[j];
					arr[j] = arr[j + 1];
					arr[j + 1] = temp;
				}
			}
		}

		return arr;
	}

}