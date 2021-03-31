package solution;

import java.util.*;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String arrStr = sc.nextLine();
		List<Integer> list=new ArrayList<>();
		String[] splits = arrStr.substring(1, arrStr.length() - 1).split(",");
		if (splits.length > 0) {
			for (String s : splits) {
				list.add(Integer.parseInt(s));
			}
		}
		
		Map<Integer, Integer> map = new HashMap<>();
		for (int j : list) {
			map.put(j, map.getOrDefault(j, 0) + 1);
		}
		int sum = 0;
		for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
			if (Objects.equals(entry.getKey(), entry.getValue())) {
				sum += entry.getKey();
			} else {
				sum += entry.getKey() + 1;
			}
		}
		System.out.println(sum);
	}
}
