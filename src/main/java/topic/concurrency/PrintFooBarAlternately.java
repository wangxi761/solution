package topic.concurrency;

import java.util.concurrent.Semaphore;

public class PrintFooBarAlternately {
	private int n;
	
	public PrintFooBarAlternately(int n) {
		this.n = n;
	}
	
	Semaphore s1 = new Semaphore(0);
	Semaphore s2 = new Semaphore(1);
	
	public void foo(Runnable printFoo) throws InterruptedException {
		
		for (int i = 0; i < n; i++) {
			s2.acquire();
			printFoo.run();
			s1.release();
		}
	}
	
	public void bar(Runnable printBar) throws InterruptedException {
		
		for (int i = 0; i < n; i++) {
			s1.acquire();
			printBar.run();
			s2.release();
		}
	}
	
}
