package topic.concurrency;

import org.junit.jupiter.api.Test;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class FizzBuzzMultithreadedTest {
	FizzBuzzMultithreaded test = new FizzBuzzMultithreaded(15);
	int i = 1, n = 10;
	Lock lock = new ReentrantLock();
	Condition a = lock.newCondition();
	Condition b = lock.newCondition();
	Condition c = lock.newCondition();
	Condition d = lock.newCondition();
	CountDownLatch latch = new CountDownLatch(4);
	
	@Test
	public void test() throws InterruptedException {
		
		new Thread(() -> {
			try {
				lock.lock();
				while (i <= n) {
					if (getState() == 0) {
						System.out.println("0");
						i++;
					} else if (getState() == 1) {
						b.signal();
						a.await();
					} else if (getState() == 2) {
						c.signal();
						a.await();
					} else {
						d.signal();
						a.await();
					}
					if (i > n) {
//						b.signal();
//						c.signal();
//						d.signal();
						a.signalAll();
					}
				}
			} catch (InterruptedException e) {
				e.printStackTrace();
			} finally {
				lock.unlock();
				latch.countDown();
			}
		}).start();
		new Thread(() -> {
			try {
				lock.lock();
				while (i <= n) {
					if (getState() == 0) {
						a.signal();
						b.await();
					} else if (getState() == 1) {
						System.out.println("1");
						i++;
					} else if (getState() == 2) {
						c.signal();
						b.await();
					} else {
						d.signal();
						b.await();
					}
					if (i > n) {
//						a.signal();
//						c.signal();
//						d.signal();
						b.signalAll();
					}
				}
			} catch (InterruptedException e) {
				e.printStackTrace();
			} finally {
				lock.unlock();
				latch.countDown();
			}
		}).start();
		new Thread(() -> {
			try {
				lock.lock();
				while (i <= n) {
					if (getState() == 0) {
						a.signal();
						c.await();
					} else if (getState() == 1) {
						b.signal();
						c.await();
					} else if (getState() == 2) {
						System.out.println("2");
						i++;
					} else {
						d.signal();
						c.await();
					}
					if (i > n) {
//						b.signal();
//						a.signal();
//						d.signal();
						c.signalAll();
					}
				}
			} catch (InterruptedException e) {
				e.printStackTrace();
			} finally {
				latch.countDown();
				lock.unlock();
			}
		}).start();
		new Thread(() -> {
			try {
				lock.lock();
				while (i <= n) {
					if (getState() == 0) {
						a.signal();
						d.await();
					} else if (getState() == 1) {
						b.signal();
						d.await();
					} else if (getState() == 2) {
						c.signal();
						d.await();
					} else {
						System.out.println("3");
						i++;
					}
					if (i > n) {
//						a.signal();
//						b.signal();
//						c.signal();
						d.signalAll();
					}
				}
			} catch (InterruptedException e) {
				e.printStackTrace();
			} finally {
				latch.countDown();
				lock.unlock();
			}
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