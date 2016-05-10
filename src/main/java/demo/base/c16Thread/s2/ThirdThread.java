package demo.base.c16Thread.s2;

import java.util.concurrent.Callable;
import java.util.concurrent.FutureTask;

//实现callable接口来实现线程类
public class ThirdThread implements Callable<Integer> {
	int i = 0;
	// 实现call方法，作为线程执行体
	public Integer call() {
		
		for (; i < 100; i++) {
			System.out.println(Thread.currentThread().getName() + "  的循环变量i的值："
					+ i);
		}
		// call方法可以有返回值
		return i;
	}

	public static void main(String args[]) {
		//创建callacle对象
		ThirdThread thread = new ThirdThread();
		FutureTask<Integer> task = new FutureTask<Integer>(thread);
		for (int i=0; i < 100; i++) {
			System.out.println(Thread.currentThread().getName() + "  的循环变量i的值："
					+ i);
			if (i==20) {
				//实质是以callable对象来创建并启动线程
				new Thread(task,"有返回值的线程").start();
			}
		}
		try {
			//导致主线程阻塞，直到call方法返回值为止
			System.out.println("子线程的返回值："+task.get());
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}

}
