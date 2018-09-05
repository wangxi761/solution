package test;

import java.io.IOException;
import java.io.PrintWriter;

import org.junit.rules.Stopwatch;

public class IoAndBreak {
	static Action action1 = new Action() {
		@Override
		public void test() {
			int a = 10, b = 3;
			while (a > b) {
				b = b << 1;
				if (a > b)
					break;
			}
		}
	};
	static Action action2 = new Action() {
		@Override
		public void test() {
			int a = 10, b = 3;
			while (a > b) {
				b = b << 1;
			}
		}
	};

	public static void main(String[] args) {
		int number = 100000;
		long time1 = time(action1, number);
		long time2 = time(action2, number);
		System.out.println(time1);
		System.out.println(time2);
	}

	public static long time(Action action, int number) {
		long begin = System.currentTimeMillis();
		for (int i = 0; i < number; i++) {
			action.test();
		}
		long end = System.currentTimeMillis();
		return end - begin;
	}

	public interface Action {
		void test();
	}

}
