package topic.concurrency;

import org.junit.Test;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

public class PrintInOrderTest {
	int i = 0;
	
	@Test
	public void test() throws InterruptedException {
		ReentrantLock lock = new ReentrantLock();
		Condition a = lock.newCondition();
		Condition b = lock.newCondition();
		Condition c = lock.newCondition();
		CountDownLatch latch = new CountDownLatch(3);
//		new Thread(() -> {
////			lock.lock();
////			if (i == 0) {
////				System.out.println("first");
////				i=1;
////				b.signal();
////			} else {
////				try {
////					a.await();
////				} catch (InterruptedException e) {
////					e.printStackTrace();
////				}
////			}
////			lock.unlock();
////			latch.countDown();
////		}).start();
////		new Thread(() -> {
////			lock.lock();
////			if (i == 1) {
////				System.out.println("second");
////				i = 2;
////				c.signal();
////			} else {
////				try {
////					b.await();
////				} catch (InterruptedException e) {
////					e.printStackTrace();
////				}
////			}
////			lock.unlock();
////			latch.countDown();
////		}).start();
////		;
////		new Thread(() -> {
////			lock.lock();
////			if (i == 2) {
////				System.out.println("third");
////				i = 0;
////				a.signal();
////			} else {
////				try {
////					c.await();
////				} catch (InterruptedException e) {
////					e.printStackTrace();
////				}
////			}
////			lock.unlock();
////			latch.countDown();
////		}).start();
		Thread first = new Thread(() -> {
			lock.lock();
			System.out.print("first");
			a.signal();
			lock.unlock();
			latch.countDown();
		});
		Thread second = new Thread(() -> {
			try {
				lock.lock();
				a.await();
				System.out.print("second");
				b.signal();
				lock.unlock();
				latch.countDown();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		});
		Thread third = new Thread(() -> {
			try {
				lock.lock();
				b.await();
				System.out.print("third");
				lock.unlock();
				latch.countDown();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		});
		third.start();
		second.start();
		first.start();
		latch.await();
		
	}
}