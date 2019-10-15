package com.ctwokm.oneday.concurrent;
//: concurrency/BasicThreads.java

// The most basic use of the Thread class.

public class BasicThreads {
	public static void main(String[] args) {
		// 当从Runnable导出一个类时，他必须具有run()方法，但他不产生任何线程能力，如果想要实现线程行为，必须显式的将任务附着到线程上
		// Thread构造器只需要一个Runnable对象
		Thread t = new Thread(new LiftOff());
		// 调用Thread对象的start()方法执行必须的初始化操作，然后调用Runnable的run()方法，以便在这个新的线程中启动该任务
		// 这里产生的是对run方法的调用，但是因为这个方法还未运行完成所以会看到下面的输出语句会先执行
		t.start();
		System.out.println("Waiting for LiftOff");
	}
} /*
	 * Output: (90% match) Waiting for LiftOff #0(9), #0(8), #0(7), #0(6),
	 * #0(5), #0(4), #0(3), #0(2), #0(1), #0(Liftoff!),
	 */// :~