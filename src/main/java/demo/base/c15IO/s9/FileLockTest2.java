package demo.base.c15IO.s9;

import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.CharBuffer;
import java.nio.channels.FileChannel;
import java.nio.channels.FileLock;
import java.nio.charset.Charset;

public class FileLockTest2 {
	static Charset cn = Charset.forName("GBK");

	// 非阻塞io
	public static void nioTest() {
		FileChannel channel = null;
		FileOutputStream fileOutputStream = null;
		try {
			// 使用FileOutputStream获取FileChannel
			fileOutputStream = new FileOutputStream(
					"E:/Code/MyGitProject/Test/src/main/java/demo/base/c15IO/s9/nioTest.txt");
			channel = fileOutputStream.getChannel();
			// 使用非阻塞式方式对指定文件加锁
			FileLock lock = channel.tryLock();

			System.out.println(Thread.currentThread().getName() + "进入lock");

			CharBuffer cbuff = CharBuffer.allocate(256);
			String test = Thread.currentThread().getName() + "进入lock";
			cbuff.put(test);
			cbuff.flip();
			// 将CharBuffer中的字符序列转换成字节序列
			ByteBuffer bbuff = cn.newEncoder().encode(cbuff);

			channel.position(test.length());
			channel.write(bbuff);
			Thread.sleep(100000);
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

	// 阻塞io
	public static void bioTest() {
		FileOutputStream fileOutputStream = null;
		try {
			// 使用FileOutputStream获取FileChannel
			fileOutputStream = new FileOutputStream(
					"E:/Code/MyGitProject/Test/src/main/java/demo/base/c15IO/s9/bio.txt",
					true);

			// 使用非阻塞式方式对指定文件加锁
			System.out.println(Thread.currentThread().getName() + "进入lock");
			fileOutputStream.write(new String(Thread.currentThread().getName()
					+ "进入lock\n").getBytes("GBK"));
			Thread.sleep(5000);
			System.out.println(Thread.currentThread().getName() + "释放lock");
		} catch (Exception ex) {
			ex.printStackTrace();
		} finally {
			try {
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
					// File file = new File(
					// "E:/Code/MyGitProject/Test/src/main/java/demo/base/c15IO/s9/bio.txt");
					//
					// boolean flag = false;
					// if (file.exists()) {
					// flag = file.delete();
					// } else {
					// flag = true;
					// }
					//
					// if (flag) {
					// bioTest();
					nioTest();
					// }
				}
			}.start();
		}
	}
}
