package demo.base.c15IO.s9;

import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.channels.FileChannel;
import java.nio.channels.FileLock;
import java.util.concurrent.locks.ReentrantLock;

public class FileLockTest {

	static ReentrantLock lock = new ReentrantLock();

	public static void reentrantlockTest() {
		try {
			lock.lock();
			System.out.println(Thread.currentThread().getName() + "进入lock");
			// 程序暂停5s
			Thread.sleep(5000);
			System.out.println(Thread.currentThread().getName() + "释放lock");
		} catch (Exception ex) {
			ex.printStackTrace();
		} finally {
			lock.unlock();
		}
	}

	// 非阻塞io
	public static void nioTest() {
		FileChannel channel = null;
		FileOutputStream fileOutputStream = null;
		try {
			// 使用FileOutputStream获取FileChannel
			fileOutputStream = new FileOutputStream(
					"E:/Code/MyGitProject/Test/src/main/java/demo/base/c15IO/s9/a.txt");
			channel = fileOutputStream.getChannel();
			// 使用非阻塞式方式对指定文件加锁
			FileLock lock = channel.tryLock();
			System.out.println(Thread.currentThread().getName() + "进入lock");
			// 程序暂停5s
			Thread.sleep(5000);
			// 释放锁
			lock.release();
			System.out.println(Thread.currentThread().getName() + "释放lock");
		} catch (Exception ex) {
			ex.printStackTrace();
		} finally {
			try {
				if (channel != null)
					channel.close();
				fileOutputStream.close();
			} catch (IOException ex) {
				ex.printStackTrace();
			}
		}
	}

	public static void main(String[] args) {
		for (int i = 0; i < 5; i++) {
			new Thread("Thread" + i) {
				public void run() {
					nioTest();
				}
			}.start();
		}
	}
}
