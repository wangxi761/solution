package study.sort;

import java.util.ArrayList;
import java.util.List;

public class BucketSort implements Sort {
	int bucketSize = 10;

	@Override
	public void sort(int[] arr) {
		int max = arr[0], min = arr[0];
		for (int i : arr) {
			if (i > max)
				max = i;
			else if (i < min)
				min = i;
		}
		// create buckets
		int bucketsNum = (max - min) / 10 + 1;
		List<List<Integer>> buckets = new ArrayList<>();
		for (int i = 0; i < bucketsNum; i++) {
			buckets.add(new ArrayList<>());
		}
		// push into buckets
		for (int i = 0; i < arr.length; i++) {
			int index = (arr[i] - min) / 10;
			buckets.get(index)
					.add(arr[i]);
		}
		//aggregate buckets
		int count = 0;
		for (int i = 0; i < bucketsNum; i++) {
			List<Integer> list = buckets.get(i);
			if (list.isEmpty())
				continue;
			//Selection sort
			for (int j = 0; j < list.size(); j++) {
				int tmin = j;
				for (int k = j + 1; k < list.size(); k++) {
					if (list.get(k) < list.get(tmin)) {
						tmin = k;
					}
				}
				arr[count++] = list.get(tmin);
				list.set(tmin, list.get(j));
			}
		}
	}

}
