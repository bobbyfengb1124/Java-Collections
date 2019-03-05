package leetcode.challenge;

import org.junit.Test;

public class TestThreadLocal {

	public static void main(String[] args) {

		MyThread t1 = new MyThread();
		MyThread t2 = new MyThread();
		MyThread t3 = new MyThread();
		MyThread t4 = new MyThread();

		t1.start();
		t2.start();
		t3.start();
		t4.start();

	}

	static class MyThread extends Thread {
		ThreadLocal<Integer> test = new ThreadLocal<Integer>();
		static int value = 10;

		@Override
		public void run() {
			test.set(value);
			value--;
//			System.out.println(test.);
		}
	}

}
