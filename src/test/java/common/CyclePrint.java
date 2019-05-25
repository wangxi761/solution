package common;

import org.junit.Test;

import java.text.MessageFormat;
import java.util.List;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

public class CyclePrint {
	
	private final List<Character> list = List.of('a', 'e', 'i', 'o', 'u');
	
	int num = 0;
	AtomicInteger atomic = new AtomicInteger(0);
	
	@Test
	public void test() throws InterruptedException {
	
	}
	
	
	@Test
	public void test2() throws InterruptedException {
		CountDownLatch latch = new CountDownLatch(2);
		ReentrantLock lock = new ReentrantLock();
		Condition vowel = lock.newCondition();//
		Condition consonant = lock.newCondition();
		
		new Thread(() -> {
			while (num < 26) {
				lock.lock();
				try {
					char c = (char) ('a' + num);
					if (list.contains(c)) {
						System.out.println(MessageFormat.format("{0} : {1}", Thread.currentThread()
						                                                           .getName(), c));
						num++;
						consonant.signal();
					} else {
						vowel.await();
					}
				} catch (InterruptedException e) {
					e.printStackTrace();
				} finally {
					lock.unlock();
				}
			}
			latch.countDown();
		}).start();
		new Thread(() -> {
			while (num < 26) {
				lock.lock();
				try {
					char c = (char) ('a' + num);
					if (!list.contains(c)) {
						System.out.println(MessageFormat.format("{0} : {1}", Thread.currentThread()
						                                                           .getName(), c));
						num++;
						vowel.signal();
					} else {
						consonant.await();
					}
				} catch (InterruptedException e) {
					e.printStackTrace();
				} finally {
					lock.unlock();
				}
			}
			latch.countDown();
		}).start();
		latch.await();
	}
	
	@Test
	public void test1() throws InterruptedException {
		CountDownLatch latch = new CountDownLatch(2);
		new Thread(() -> {
			while (atomic.get() < 26) {
				char c = (char) ('a' + atomic.get());
				if (list.contains(c)) {
					String s = MessageFormat.format("{0} : {1}", Thread.currentThread()
					                                                   .getName(), (char) ('a' + atomic.getAndIncrement()));
					System.out.println(s);
					
				}
			}
			latch.countDown();
		}).start();
		new Thread(() -> {
			while (atomic.get() < 26) {
				char c = (char) ('a' + atomic.get());
				if (!list.contains(c)) {
					String s = MessageFormat.format("{0} : {1}", Thread.currentThread()
					                                                   .getName(), (char) ('a' + atomic.getAndIncrement()));
					System.out.println(s);
				}
			}
			latch.countDown();
		}).start();
		latch.await();
	}
}
