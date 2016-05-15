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
			System.out.println(Thread.currentThread().getName() + "����lock");
			// ������ͣ5s
			Thread.sleep(5000);
			System.out.println(Thread.currentThread().getName() + "�ͷ�lock");
		} catch (Exception ex) {
			ex.printStackTrace();
		} finally {
			lock.unlock();
		}
	}

	// ������io
	public static void nioTest() {
		FileChannel channel = null;
		FileOutputStream fileOutputStream = null;
		try {
			// ʹ��FileOutputStream��ȡFileChannel
			fileOutputStream = new FileOutputStream(
					"E:/Code/MyGitProject/Test/src/main/java/demo/base/c15IO/s9/a.txt");
			channel = fileOutputStream.getChannel();
			// ʹ�÷�����ʽ��ʽ��ָ���ļ�����
			FileLock lock = channel.tryLock();
			System.out.println(Thread.currentThread().getName() + "����lock");
			// ������ͣ5s
			Thread.sleep(5000);
			// �ͷ���
			lock.release();
			System.out.println(Thread.currentThread().getName() + "�ͷ�lock");
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
