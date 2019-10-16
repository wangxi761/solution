package topic.concurrency;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;
import java.util.function.IntConsumer;

public class ZeroEvenOdd {
	private int n;
	
	public ZeroEvenOdd(int n) {
		this.n = n;
	}
	
	int state = 0, i = 1;
	Lock lock = new ReentrantLock();
	Condition a = lock.newCondition();
	Condition b = lock.newCondition();
	Condition c = lock.newCondition();
	
	// printNumber.accept(x) outputs "x", where x is an integer.
	public void zero(IntConsumer printNumber) throws InterruptedException {
		try {
			lock.lock();
			while (i <= n) {
				if (state == 0 || state == 2) {
					printNumber.accept(0);
					Condition condition = stateInrc();
					condition.signal();
				} else {
					a.await();
				}
				if (i > n) {
					b.signalAll();
				}
			}
		} finally {
			lock.unlock();
		}
	}
	
	public void even(IntConsumer printNumber) throws InterruptedException {
		try {
			lock.lock();
			while (i <= n) {
				if (state == 3) {
					printNumber.accept(n);
					Condition condition = stateInrc();
					condition.signal();
				} else {
					b.await();
				}
				if (i > n) {
					c.signalAll();
				}
			}
		} finally {
			lock.unlock();
		}
	}
	
	public void odd(IntConsumer printNumber) throws InterruptedException {
		try {
			lock.lock();
			while (i <= n) {
				if (state == 1) {
					printNumber.accept(n);
					Condition condition = stateInrc();
					condition.signal();
				} else {
					c.await();
				}
				if (i > n) {
					a.signalAll();
				}
			}
		} finally {
			lock.unlock();
		}
	}
	
	public Condition stateInrc() {
		switch (state) {
			case 0: {
				state = 1;
				return c;
			}
			case 1:
			case 3: {
				state = state == 3 ? 0 : 2;
				return a;
			}
			case 2: {
				state = 3;
				return b;
			}
		}
		return null;
	}
}
