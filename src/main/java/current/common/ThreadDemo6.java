package current.common;

public class ThreadDemo6 {
	private static boolean flags = false;

	public static void main(String[] args) {
		class Goods {
			private String name;
			private int num;

			public synchronized void produce(String name) {
				while (flags)
					try {
						wait();
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				this.name = name + "编号：" + num++;
				System.out.println(Thread.currentThread().getName() + "生产了...."
						+ this.name);
				flags = true;
				notifyAll();
			}

			public synchronized void consume() {
				while (!flags)
					try {
						System.out.println("******尚无产品******");
						wait();
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				System.out.println(Thread.currentThread().getName()
						+ "消费了******" + name);
				flags = false;
				notifyAll();
			}

		}
		final Goods g = new Goods();
		new Thread(new Runnable() {
			public void run() {
				while (true) {
					g.produce("商品");
				}
			}
		}, "生产者1号").start();
		new Thread(new Runnable() {
			public void run() {
				while (true) {
					g.produce("商品");
				}
			}
		}, "生产者2号").start();
		new Thread(new Runnable() {
			public void run() {
				while (true) {
					g.consume();
				}
			}
		}, "***消费者1号").start();
		new Thread(new Runnable() {
			public void run() {
				while (true) {
					g.consume();
				}
			}
		}, "***消费者2号").start();
	}
}
