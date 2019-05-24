package topic.string;

import org.junit.Test;

public class FindDuplicateFileinSystemTest {
	FindDuplicateFileinSystem test = new FindDuplicateFileinSystem();
	
	@Test
	public void findDuplicate() {
		System.out.println(test.findDuplicate(new String[]{"root/a 1.txt(abcd) 2.txt(efgh)", "root/c 3.txt(abcd)", "root/c/d 4.txt(efgh)", "root 4.txt(efgh)"}));
	}
}