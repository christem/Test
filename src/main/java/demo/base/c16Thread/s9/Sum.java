package demo.base.c16Thread.s9;

import java.util.Random;
import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.Future;
import java.util.concurrent.RecursiveTask;

//继承RecursiveTask来实现 可分解的任务
class CalTask extends RecursiveTask<Integer> {
	// 每个小任务最多只打印20个数
	private static final int THRESHOLD = 20;
	private int arr[];
	private int start;
	private int end;

	// 打印从start到end的任务
	public CalTask(int arr[], int start, int end) {
		this.start = start;
		this.end = end;
		this.arr = arr;
	}

	@Override
	protected Integer compute() {
		int sum = 0;
		// 当end与start之间的差小于THRESHOLD时，开始进行实际累加
		if (end - start < THRESHOLD) {
			for (int i = start; i < end; i++) {
				sum += arr[i];
			}
			return sum;
		} else {
			// 当end与start之间的差大于THRESHOLD时，即要打印的数超过20个时
			// 讲大任务分解成两个小任务
			int middle = (end + start) / 2;
			CalTask left = new CalTask(arr, start, middle);
			CalTask right = new CalTask(arr, middle, end);
			// 并行执行两个小任务
			left.fork();
			right.fork();
			return left.join() + right.join();
		}
	}
}

public class Sum {

	public static void main(String[] args) throws Exception {

		int[] arr = new int[1000000];
		long t1 = System.currentTimeMillis();
		Random rand = new Random();
		int total = 0;
		for (int i = 0, len = arr.length; i < len; i++) {
			int tmp = rand.nextInt(20);
			total += (arr[i] = tmp);
		}
		System.out.println(System.currentTimeMillis() - t1 + ":" + total);
		long t2 = System.currentTimeMillis();
		ForkJoinPool pool = new ForkJoinPool();
		// 提交可分解的PrintTask任务
		Future<Integer> future = pool.submit(new CalTask(arr, 0, arr.length));
		System.out
				.println(System.currentTimeMillis() - t2 + ":" + future.get());
		// 关闭线程池
		pool.shutdown();
	}
}
