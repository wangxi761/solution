package topic.concurrency;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;
import java.util.function.IntConsumer;

public class FizzBuzzMultithreaded {
	private int n;
	Lock lock = new ReentrantLock();
	Condition a = lock.newCondition();
	Condition b = lock.newCondition();
	Condition c = lock.newCondition();
	Condition d = lock.newCondition();
	volatile int i = 1;
	
	public FizzBuzzMultithreaded(int n) {
		this.n = n;
	}
	
	// printFizz.run() outputs "fizz".
	public void fizz(Runnable printFizz) throws InterruptedException {
		while (i <= n) {
			lock.lock();
			if (getState() == 0) {
				printFizz.run();
				i++;
				a.signalAll();
			} else {
				a.await();
			}
			lock.unlock();
		}
	}
	
	// printBuzz.run() outputs "buzz".
	public void buzz(Runnable printBuzz) throws InterruptedException {
		while (i <= n) {
			lock.lock();
			if (getState() == 1) {
				printBuzz.run();
				i++;
				b.signalAll();
			} else {
				b.await();
			}
			lock.unlock();
		}
	}
	
	// printFizzBuzz.run() outputs "fizzbuzz".
	public void fizzbuzz(Runnable printFizzBuzz) throws InterruptedException {
		while (i <= n) {
			lock.lock();
			if (getState() == 2) {
				printFizzBuzz.run();
				i++;
				c.signalAll();
			} else {
				c.await();
			}
			lock.unlock();
		}
	}
	
	// printNumber.accept(x) outputs "x", where x is an integer.
	public void number(IntConsumer printNumber) throws InterruptedException {
		while (i <= n) {
			lock.lock();
			if (getState() == 3) {
				printNumber.accept(i);
				i++;
				d.signalAll();
			} else {
				d.await();
			}
			lock.unlock();
		}
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
