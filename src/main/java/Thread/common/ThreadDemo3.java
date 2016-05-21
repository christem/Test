package Thread.common;

public class ThreadDemo3 {
	public static void main(String[] args) {
		Ticket t = new Ticket();
		Thread t1 = new Thread(t, "窗口一");
		Thread t2 = new Thread(t, "窗口二");
		Thread t3 = new Thread(t, "窗口三");
		Thread t4 = new Thread(t, "窗口四");
		t1.start();
		t2.start();
		t3.start();
		t4.start();
	}
}

class Ticket implements Runnable {
	private int ticket = 4000;

	public void run() {
		while (true) {
			synchronized (new Object()) {
				try {
					Thread.sleep(1);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				if (ticket <= 0)
					break;
				System.out.println(Thread.currentThread().getName() + "---卖出"
						+ ticket--);
			}
		}
	}
}

// 同步函数锁是this 静态同步函数锁是class
class Ticket2 implements Runnable {
	private int ticket = 4000;

	public synchronized void saleTicket() {
		if (ticket > 0)
			System.out.println(Thread.currentThread().getName() + "卖出了"
					+ ticket--);

	}

	public void run() {
		while (true) {
			saleTicket();
		}
	}
}
