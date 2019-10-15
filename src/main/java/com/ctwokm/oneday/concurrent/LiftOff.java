package com.ctwokm.oneday.concurrent;

//: concurrency/LiftOff.java
//Demonstration of the Runnable interface.

public class LiftOff implements Runnable {
	protected int countDown = 10; // Default
	private static int taskCount = 0;
	private final int id = taskCount++;

	public LiftOff() {
	}

	public LiftOff(int countDown) {
		this.countDown = countDown;
	}

	public String status() {
		return "#" + id + "(" + (countDown > 0 ? countDown : "Liftoff!") + "), ";
	}

	public void run() {
		while (countDown-- > 0) {
			System.out.print(status());
			// Thread.yield()方法调用的是对线程调度器的一种建议，表示我已经执行完最重要的部分，现在是执行其他任务的最佳时机
			Thread.yield();
		}
	}
} /// :~
