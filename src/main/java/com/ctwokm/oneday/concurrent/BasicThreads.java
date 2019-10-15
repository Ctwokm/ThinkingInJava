package com.ctwokm.oneday.concurrent;
//: concurrency/BasicThreads.java

// The most basic use of the Thread class.

public class BasicThreads {
	public static void main(String[] args) {
		// ����Runnable����һ����ʱ�����������run()�����������������κ��߳������������Ҫʵ���߳���Ϊ��������ʽ�Ľ������ŵ��߳���
		// Thread������ֻ��Ҫһ��Runnable����
		Thread t = new Thread(new LiftOff());
		// ����Thread�����start()����ִ�б���ĳ�ʼ��������Ȼ�����Runnable��run()�������Ա�������µ��߳�������������
		// ����������Ƕ�run�����ĵ��ã�������Ϊ���������δ����������Իῴ����������������ִ��
		t.start();
		System.out.println("Waiting for LiftOff");
	}
} /*
	 * Output: (90% match) Waiting for LiftOff #0(9), #0(8), #0(7), #0(6),
	 * #0(5), #0(4), #0(3), #0(2), #0(1), #0(Liftoff!),
	 */// :~