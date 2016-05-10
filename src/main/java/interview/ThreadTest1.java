package interview;

public class ThreadTest1 extends Thread {
	private static int num = 0, n = 100;
	static ThreadTest1 t1, t2;
	static int i = 0;
	static int x;
	static String ss = new String();

	public ThreadTest1() {
		start();
	}

	public void run() {
		for (x = 0; x < 200; x++) {
			synchronized (ss) {
				ss.notify();
				// Print();
				try {
					System.out.println(this.getName());
					ss.wait();
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
		synchronized (ss) {
			ss.notifyAll();
		}
	}

	public void Print() {
		if (i == 0) {
			i++;
			System.out.println(this.getName() + ":" + ++num);
		} else {
			i = (i + 1) % 2;
			System.out.println(this.getName() + ":" + n++);
		}

	}

	public static void main(String[] args) throws InterruptedException {
		t1 = new ThreadTest1();
		t2 = new ThreadTest1();
	}

}