package com.ctwokm.oneday.concurrent.exercise;
import java.util.*;
import java.util.concurrent.*;

class FibonacciA implements Runnable {
	int howMany = 0;

	private int fib(int n) {
		if (n < 2)
			return 1;
		return fib(n - 2) + fib(n - 1);
	}

	public void run() {
		int[] arr = new int[howMany];
		for (int i = 0; i < howMany; i++) {
			arr[i] = fib(i);
		}
		System.out.println(Arrays.toString(arr));
	}

	FibonacciA(int howMany) {
		this.howMany = howMany;
	}
}

public class Ch21ex04 {
	public static void main(String[] args) {
		ExecutorService execCached = Executors.newCachedThreadPool();
		execCached.execute(new FibonacciA(5));
		execCached.execute(new FibonacciA(10));
		execCached.execute(new FibonacciA(15));
		execCached.shutdown();
		ExecutorService execFixed = Executors.newFixedThreadPool(3);
		execFixed.execute(new FibonacciA(5));
		execFixed.execute(new FibonacciA(10));
		execFixed.execute(new FibonacciA(15));
		execFixed.shutdown();
		ExecutorService execSingle = Executors.newSingleThreadExecutor();
		execSingle.execute(new FibonacciA(5));
		execSingle.execute(new FibonacciA(10));
		execSingle.execute(new FibonacciA(15));
		execSingle.shutdown();
	}
}

/* Output:
[1, 1, 2, 3, 5]
[1, 1, 2, 3, 5, 8, 13, 21, 34, 55]
[1, 1, 2, 3, 5]
[1, 1, 2, 3, 5, 8, 13, 21, 34, 55]
[1, 1, 2, 3, 5]
[1, 1, 2, 3, 5, 8, 13, 21, 34, 55, 89, 144, 233, 377, 610]
[1, 1, 2, 3, 5, 8, 13, 21, 34, 55, 89, 144, 233, 377, 610]
[1, 1, 2, 3, 5, 8, 13, 21, 34, 55]
[1, 1, 2, 3, 5, 8, 13, 21, 34, 55, 89, 144, 233, 377, 610]
*/