package common;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

import org.junit.jupiter.api.Test;

public class ReentrantLockTest {
	Lock lock = new ReentrantLock();
	int tickets = 20000;
	@Test
	public void test() throws Exception {
		a();
	}
	public void a() {
		lock.lock();
		b();
		lock.unlock();
	}
	public void b() {
		lock.lock();
		c();
		lock.unlock();
	}
	public void c() {
		lock.lock();
		tickets--;
		lock.unlock();
	}
}
