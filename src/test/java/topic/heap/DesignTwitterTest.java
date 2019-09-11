package topic.heap;

import org.junit.Test;

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
}