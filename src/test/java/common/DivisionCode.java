package common;

import org.junit.Test;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class DivisionCode {
	public static final String PATH = "C:\\Users\\ccf\\Desktop\\区划代码.txt";
	public static final String PATH1 = "C:\\Users\\ccf\\Desktop\\区划代码1.txt";
	
	@Test
	public void test() throws IOException {
		List<String> lines = Files.readAllLines(Paths.get(PATH));
		Map<String, String> map = new HashMap<>();
		for (int i = 0; i < lines.size(); i++) {
			String[] res = lines.get(i).split("\t");
			assert res[0].matches("\\d{6}");
			assert res.length == 2;
			String name = getName(res[0], map) + res[1];
			map.put(res[0], name);
		}
		Files.writeString(Paths.get(PATH1), map.entrySet().stream().sorted(Comparator.comparing(Map.Entry::getKey)).map(i -> i.getKey() + " " + i.getValue()).collect(Collectors.joining("\r\n")));
		
	}
	
	public String getName(String id, Map<String, String> map) {
		if (map.containsKey(id)) {
			return map.get(id);
		}
		if (id.endsWith("0000")) {
			return "";
		}
		if (id.endsWith("00")) {
			return getName(id.substring(0, 2) + "0000", map);
		}
		return getName(id.substring(0, 4) + "00", map);
	}
	
	public String getName(String id, String name, Map<String, String> map) {
		if (id.endsWith("0000")) {
			return name;
		} else if (id.endsWith("00")) {
			String newId = id.substring(0, 2) + "0000";
			if (map.containsKey(newId)) {
				name = map.get(newId) + name;
				return name;
			}
			return getName(newId, name, map);
		} else {
			String newId = id.substring(0, 4) + "00";
			if (map.containsKey(newId)) {
				name = map.get(newId) + name;
				return name;
			}
			return getName(newId, name, map);
		}
	}
}
