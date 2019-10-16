package topic.concurrency;

import org.junit.Test;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.Semaphore;

public class PrintFooBarAlternatelyTest {
	int state = 0, n = 1;
	
	@Test
	public void test() throws InterruptedException {
		Semaphore s1 = new Semaphore(0);
		Semaphore s2 = new Semaphore(1);
		CountDownLatch latch = new CountDownLatch(2);
		
		Thread foo = new Thread(() -> {
			try {
				for (int i = 0; i < n; i++) {
					s2.acquire();
					System.out.println("foo");
					s1.release();
				}
			} catch (InterruptedException e) {
				e.printStackTrace();
			} finally {
				latch.countDown();
			}
		});
		Thread bar = new Thread(() -> {
			try {
				for (int i = 0; i < n; i++) {
					s1.acquire();
					System.out.println("bar");
					s2.release();
				}
			} catch (InterruptedException e) {
				e.printStackTrace();
			} finally {
				latch.countDown();
			}
		});
		foo.start();
		bar.start();
		latch.await();
	}
}