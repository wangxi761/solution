package test;

import java.io.IOException;
import java.io.PrintWriter;

public class IoAndBreak {
	public static void main(String[] args)  {
		try(PrintWriter writer=new PrintWriter(System.out)) {
			for (int i = 0; i < 100; i++) {
				new Thread(new Runnable() {
					private int k;
					@Override
					public void run() {
						try {
							writer.println(Thread.currentThread().getId()+" "+k);
						} catch (Exception e) {
							e.printStackTrace();
						}
					}
					public Runnable setK(int k) {
						this.k = k;
						return this;
					}
				}.setK(i)).start();
			}
		}catch (Exception e) {
			e.printStackTrace();
		}
		
	}
}
