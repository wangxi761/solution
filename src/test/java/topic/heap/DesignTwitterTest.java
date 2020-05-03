package topic.heap;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

public class DesignTwitterTest {
	@Test
	public void test() {
		DesignTwitter.B.Twitter twitter = new DesignTwitter.B.Twitter();
		twitter.postTweet(1, 5);
		twitter.follow(1, 2);
		List<Integer> feed = twitter.getNewsFeed(1);
		System.out.println(feed);
	}
	
	@Test
	public void test1() {
		String str = "";
		int[] nums = new int[str.length()];
		char[] chs = str.toCharArray();
		for (int i = 0; i < nums.length; i++) {
			nums[i] = chs[i] - '0';
		}
	}
	
	@Test
	public void test2() {
		String str = "123";
		int[] nums = new int[str.length()];
		String[] sp = str.split("");
		for (int i = 0; i < nums.length; i++) {
			nums[i] = Integer.parseInt(sp[i]);
		}
		System.out.println(Arrays.toString(nums));
	}
	
	@Test
	public void test3() {
		System.out.println(((int) '1'));
	}
}