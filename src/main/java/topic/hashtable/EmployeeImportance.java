package topic.hashtable;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class EmployeeImportance {
	class Employee {
		public int id;
		public int importance;
		public List<Integer> subordinates;
	}
	
	public int getImportance(List<Employee> employees, int id) {
		Map<Integer, Employee> cache = new HashMap<>();
		for (Employee employee : employees) {
			cache.put(employee.id, employee);
		}
		return recursive(cache, id);
	}
	
	public int recursive(Map<Integer, Employee> cache, int id) {
		int res = cache.get(id).importance;
		List<Integer> subordinates = cache.get(id).subordinates;
		if (subordinates != null && subordinates.size() > 0) {
			for (Integer sid : subordinates) {
				res += recursive(cache, sid);
			}
		}
		return res;
	}
}
