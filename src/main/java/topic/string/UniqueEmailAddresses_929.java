package topic.string;

import static org.junit.Assert.*;

import java.util.HashSet;
import java.util.Set;

import org.junit.Test;

public class UniqueEmailAddresses_929 {

	public int numUniqueEmailsI(String[] emails) {
		Set<String> set = new HashSet<>();
		for (String i : emails) {
			String[] split = i.split("@");
			set.add(split[0].replace(".", "").split("\\+")[0] + split[1]);
		}
		return set.size();
	}
	public int numUniqueEmails(String[] emails) {
		Set<String> set = new HashSet<>();
		for (String i : emails) {
			String[] split = i.split("@");
			set.add(split[0].split("\\+",2)[0].replace(".", "") + split[1]);
		}
		return set.size();
	}
	public int numUniqueEmailsII(String[] emails) {
		Set<String> set = new HashSet<>();
		for (String i : emails) {
			String[] split = i.split("@");
			String substring = i.substring(0,split[0].indexOf("+")).replace(".", "")+split[1];
			set.add(substring);
		}
		return set.size();
	}

	
	
	@Test
	public void test() throws Exception {
		String[] es= {"test.email+alex@leetcode.com","test.e.mail+bob.cathy@leetcode.com","testemail+david@lee.tcode.com"};
		int num = numUniqueEmails(es);
		assertEquals(2, num);
	}
	
}
