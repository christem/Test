package demo.base.c16Thread.s7;

/**
 * Description: <br/>
 * Copyright (C), 2008-2010, Yeeku.H.Lee <br/>
 * This program is protected by copyright laws. <br/>
 * Program Name: <br/>
 * Date:
 * 
 * @author Yeeku.H.Lee kongyeeku@163.com
 * @version 1.0
 */
// 定义自己的异常处理器
class MyExHandler implements Thread.UncaughtExceptionHandler {
	// 实现uncaughtException方法，该方法将处理线程的未处理异常
	public void uncaughtException(Thread t, Throwable e) {
		System.out.println(t.getName() + " 线程出现了异常：" + e);
	}
}

class TestThread2 extends Thread {
	// 提供指定线程名的构造器
	public TestThread2(String name) {
		super(name);
		this.setUncaughtExceptionHandler(new MyExHandler());
	}

	// 提供指定线程名、线程组的构造器
	public TestThread2(ThreadGroup group, String name) {
		super(group, name);
		this.setUncaughtExceptionHandler(new MyExHandler());
	}

	public void run() {
		int a = 5 / 0;
		System.out.println(a);
	}
}

public class ExHandler {
	public static void main(String[] args) {
		// 设置主线程的异常处理器
		// Thread.currentThread().setUncaughtExceptionHandler(new
		// MyExHandler());
		new TestThread2("测试线程").start();
	}
}
