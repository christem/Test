package demo.base.c17Socket.s5;

import java.io.IOException;
import java.io.PrintStream;
import java.net.InetSocketAddress;
import java.net.MalformedURLException;
import java.net.Proxy;
import java.net.URL;
import java.net.URLConnection;
import java.util.Scanner;

public class ProxyTest {
	Proxy proxy;
	URL url;
	URLConnection conn;
	// ������ͨ�����������
	Scanner scan;
	PrintStream ps;
	// �����Ǵ���������ĵ�ַ�Ͷ˿ڣ�
	// ����ʵ����Ч�Ĵ���������ĵ�ַ�Ͷ˿�
	String proxyAddress = "118.249.118.63";
	int proxyPort;
	// ����������ͼ�򿪵���վ��ַ
	String urlStr = "http://www.oneedu.cn";

	public void init() {
		try {
			url = new URL(urlStr);
			// ����һ���������������
			proxy = new Proxy(Proxy.Type.HTTP, new InetSocketAddress(
					proxyAddress, proxyPort));
			// ʹ��ָ���Ĵ��������������
			conn = url.openConnection(proxy);
			// ���ó�ʱʱ����
			conn.setConnectTimeout(5000);
			scan = new Scanner(conn.getInputStream());
			// ��ʼ�������
			ps = new PrintStream(
					"E:/Code/MyGitProject/Test/src/main/java/demo/base/c17Socket/s5/Index.htm");
			while (scan.hasNextLine()) {
				String line = scan.nextLine();
				// �ڿ���̨�����ҳ��Դ����
				System.out.println(line);
				// ����ҳ��Դ���������ָ�������
				ps.println(line);
			}
		} catch (MalformedURLException ex) {
			System.out.println(urlStr + "������Ч����վ��ַ��");
		} catch (IOException ex) {
			ex.printStackTrace();
		}
		// �ر���Դ
		finally {
			if (ps != null) {
				ps.close();
			}
		}
	}

	public static void main(String[] args) {
		new ProxyTest().init();
	}
}