package topic.concurrency;

import org.junit.Test;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class FizzBuzzMultithreadedTest {
	FizzBuzzMultithreaded test = new FizzBuzzMultithreaded(15);
	int i = 1, n = 15;
	Lock lock = new ReentrantLock();
	Condition a = lock.newCondition();
	Condition b = lock.newCondition();
	Condition c = lock.newCondition();
	Condition d = lock.newCondition();
	CountDownLatch latch = new CountDownLatch(4);
	
	@Test
	public void test() throws InterruptedException {
		
		new Thread(() -> {
			while (i <= n) {
				lock.lock();
				if (getState() == 0) {
					System.out.println("0");
					i++;
					b.signalAll();
				} else {
					try {
						a.await();
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
				}
				lock.unlock();
			}
			latch.countDown();
		}).start();
		new Thread(() -> {
			while (i <= n) {
				lock.lock();
				if (getState() == 1) {
					System.out.println("1");
					i++;
					c.signalAll();
				} else {
					try {
						b.await();
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
				}
				lock.unlock();
			}
			latch.countDown();
		}).start();
		new Thread(() -> {
			while (i <= n) {
				lock.lock();
				if (getState() == 2) {
					System.out.println("2");
					i++;
					d.signalAll();
				} else {
					try {
						c.await();
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
				}
				lock.unlock();
			}
			latch.countDown();
		}).start();
		new Thread(() -> {
			while (i <= n) {
				lock.lock();
				if (getState() == 3) {
					System.out.println("3");
					i++;
					a.signalAll();
				} else {
					try {
						d.await();
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
				}
				lock.unlock();
			}
			latch.countDown();
		}).start();
		latch.await();
	}
	
	public int getState() {
		if (i % 3 == 0 && i % 5 == 0) {
			return 2;
		} else if (i % 3 == 0) {
			return 0;
		} else if (i % 5 == 0) {
			return 1;
		} else {
			return 3;
		}
	}
}