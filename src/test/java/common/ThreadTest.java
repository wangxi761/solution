package common;

import org.junit.Test;
import sun.misc.Unsafe;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.atomic.AtomicInteger;

public class ThreadTest {
	AtomicInteger i = new AtomicInteger(0);
	
	@Test
	public void test() throws InterruptedException {
		int num = 2, count = 100;
		CountDownLatch countDownLatch = new CountDownLatch(num);
		Runnable addOne = () -> {
			for (int j = 0; j < 10000; j++) {
				i.incrementAndGet();
			}
			countDownLatch.countDown();
		};
		for (int j = 0; j < num; j++) {
			new Thread(addOne).start();
		}
		countDownLatch.await();
		System.out.println(i);
	}
}
