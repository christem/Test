package demo.base.c16Thread.s9;

import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.RecursiveAction;
import java.util.concurrent.TimeUnit;

//继承RecursiveAction来实现 可分解的任务
class PrintTask extends RecursiveAction {
	private static final long serialVersionUID = -8888117155977121805L;
	// 每个小任务最多只打印50个数
	private static final int THRESHOLD = 5;
	private int start;
	private int end;

	// 打印从start到end的任务
	public PrintTask(int start, int end) {
		this.start = start;
		this.end = end;
	}

	@Override
	protected void compute() {
		// 当end与start之间的差小于THRESHOLD时，开始打印
		if (end - start < THRESHOLD) {
			for (int i = start; i < end; i++) {
				System.out.println(Thread.currentThread().getName() + " 的i的值是"
						+ i);// + "start:" + start + ",end:" + end);
			}
		} else {
			// 当end与start之间的差大于THRESHOLD时，即要打印的数超过50个时
			// 讲大任务分解成两个小任务
			int middle = (end + start) / 2;
			PrintTask left = new PrintTask(start, middle);
			PrintTask right = new PrintTask(middle, end);
			// 并行执行两个小任务
			left.fork();
			right.fork();
		}
	}
}

public class ForkJoinPoolTest {

	public static void main(String[] args) throws Exception {
		ForkJoinPool pool = new ForkJoinPool();
		// 提交可分解的PrintTask任务
		pool.submit(new PrintTask(0, 30));
		pool.awaitTermination(2, TimeUnit.SECONDS);
		// 关闭线程池
		pool.shutdown();
	}
}
