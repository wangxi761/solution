package topic.Backtracking;

public class BeautifulArrangement {
	public int countArrangement(int N) {
		int[] arr = new int[N];
		for (int i = 0; i < N; i++) {
			arr[i] = i + 1;
		}
		return recursive(arr, 0);
	}
	
	public int recursive(int[] arr, int num) {
		int sum = 0;
		if (num < arr.length) {
			for (int i = 0; i < arr.length; i++) {
				int value = arr[i];
				if (value < 0) continue;
				if (value % (num + 1) == 0 || (num + 1) % value == 0) {
					arr[i] = -1;
					sum += recursive(arr, num + 1);
					arr[i] = value;
				}
			}
		} else {
			sum++;
		}
		return sum;
	}
}
