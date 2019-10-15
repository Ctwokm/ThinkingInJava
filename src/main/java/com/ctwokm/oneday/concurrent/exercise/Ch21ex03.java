package com.ctwokm.oneday.concurrent.exercise;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

class MyClassD implements Runnable {
	MyClassD() {
		System.out.println("Creation of MyClassD");
	}
	
	public void run() {
		for(int i = 0; i < 3; i++) {
			System.out.println("MyClassD.run()");
			Thread.yield();
		}
		System.out.println("Task from MyClassD completed");
		return;
	}
}

class MyClassE implements Runnable {
	MyClassE() {
		System.out.println("Creation of MyClassE");
	}
	
	public void run() {
		for(int i = 0; i < 3; i++) {
			System.out.println("MyClassE.run()");
			Thread.yield();
		}
		System.out.println("Task from MyClassE completed");
		return;
	}
}

class MyClassF implements Runnable {
	MyClassF() {
		System.out.println("Creation of MyClassF");
	}
	
	public void run() {
		for(int i = 0; i < 3; i++) {
			System.out.println("MyClassF.run()");
			Thread.yield();
		}
		System.out.println("Task from MyClassF completed");
		return;
	}
}




public class Ch21ex03 {

	public static void main(String[] args) {
		System.out.println("********* Beginning of main() *********");
		
		ExecutorService execCached = Executors.newCachedThreadPool();
		execCached.execute(new MyClassD());
		execCached.execute(new MyClassE());
		execCached.execute(new MyClassF());
		execCached.shutdown();
		ExecutorService execFixed = Executors.newFixedThreadPool(3);
		execFixed.execute(new MyClassD());
		execFixed.execute(new MyClassE());
		execFixed.execute(new MyClassF());
		execFixed.shutdown();
		ExecutorService execSingle = Executors.newSingleThreadExecutor();
		execSingle.execute(new MyClassD());
		execSingle.execute(new MyClassE());
		execSingle.execute(new MyClassF());
		execSingle.shutdown();
		System.out.println("********* End of main() *********");
	}

}

/* Output:
********* Beginning of main() *********
Creation of MyClassA
MyClassA.run()
MyClassA.run()
MyClassA.run()
Task from MyClassA completed
Creation of MyClassB
MyClassB.run()
MyClassB.run()
MyClassB.run()
Task from MyClassB completed
Creation of MyClassC
MyClassC.run()
MyClassC.run()
MyClassC.run()
Task from MyClassC completed
Creation of MyClassA
Creation of MyClassB
MyClassA.run()
MyClassA.run()
Creation of MyClassC
MyClassA.run()
MyClassB.run()
Task from MyClassA completed
MyClassB.run()
MyClassB.run()
Task from MyClassB completed
Creation of MyClassA
MyClassC.run()
MyClassC.run()
Creation of MyClassB
MyClassA.run()
MyClassC.run()
Creation of MyClassC
********* End of main() *********
Task from MyClassC completed
MyClassA.run()
MyClassA.run()
Task from MyClassA completed
MyClassB.run()
MyClassB.run()
MyClassB.run()
Task from MyClassB completed
MyClassC.run()
MyClassC.run()
MyClassC.run()
Task from MyClassC completed
*/