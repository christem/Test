package concurrent;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Semaphore;

public class ConTest {

    private static int concurrentNum = 1000;

    private static int thread_num = 10;

    // private static int client_num = 10;

    private static int num = 0;

    public static int getNo() {
	num = num + 1;
	System.out.println(num);
	return num;
    }

    private static Map keywordMap = new HashMap();

    // static {
    // try {
    //
    // InputStreamReader isr = new InputStreamReader(new FileInputStream(
    //
    // new File("clicks.txt")), "GBK");
    //
    // BufferedReader buffer = new BufferedReader(isr);
    //
    // String line = "";
    //
    // while ((line = buffer.readLine()) != null) {
    //
    // keywordMap.put(line.substring(0, line.lastIndexOf(":")), "");
    //
    // }
    //
    // } catch (Exception e) {
    //
    // e.printStackTrace();
    //
    // }
    // }

    public static void main(String[] args) {

	int size = keywordMap.size();

	ExecutorService exec = Executors.newCachedThreadPool();

	keywordMap.put("test01", "38338");
	keywordMap.put("test02", "38339");
	keywordMap.put("test03", "38340");
	keywordMap.put("test04", "38341");
	keywordMap.put("test05", "38342");
	keywordMap.put("test06", "38343");
	keywordMap.put("test07", "38344");
	keywordMap.put("test08", "38345");
	keywordMap.put("test09", "38346");
	keywordMap.put("test10", "38347");
	// 50个线程可以同时访问

	final Semaphore semp = new Semaphore(thread_num);

	// 模拟2000个客户端访问
	Set set = keywordMap.keySet();//

	Iterator it = set.iterator();

	int index = 0;

	while (it.hasNext()) {

	    String userName = (String) it.next();//
	    final String pass = keywordMap.get(userName).toString();

	    Runnable run = new Runnable() {
		int NO = concurrentNum;

		public void run() {

		    try {

			// 获取许可
			semp.acquire();
			System.out.println("Thread:" + NO);
			String host = "http://192.168.0.137:8080/MessageWeb/messageSrevlet.do?";
			String para = "m=reqcalltaxi&id="
			        + pass
			        + "&key=35bc7f25daa881fa0974730276868f12&phone=13401038652&bx=116.311754&by=40.034496&"

			        + "bLocation=%E4%B8%8A%E5%9C%B0&bDes=%E5%8C%97%E4%BA%AC%E5%B8%82%E6%B5%B7%E6%B7%80%E5%8C%BA%E4%B8%8A%E5%9C%B03%E8%A1%97%E7%8E%AF%E5%B2%9B%E8%A5%BF%E5%8D%97%E8%A7%92(%E8%BF%91%E4%B8%8A%E5%9C%B0%E7%8E%AF%E5%B2%9B)&"

			        + "ex=116.315942&ey=40.05343&eLocation=%E8%A5%BF%E4%BA%8C%E6%97%97&eDes=333%E8%B7%AF%E5%86%85%E7%8E%AF,333%E8%B7%AF%E5%A4%96%E7%8E%AF,392%E8%B7%AF,%E8%BF%90%E9%80%9A114%E8%B7%AF,636%E8%B7%AF&"

			        + "time=15&userNum=1&isSalute=1&name=%E6%9C%B1%E5%85%88%E7%94%9F&level=3&credit=-3&bytime=2012-07-12%2016:34:17&type=0¬ifytime=2012-07-12%2016:34:17&s=123456&"

			        + "jsoncallback=jQuery16208664285382739452_1342059526704&_=1342059557372";

			System.out.println(host + para);

			URL url = new URL(host);// 此处填写供测试的url

			HttpURLConnection connection = (HttpURLConnection) url.openConnection();
			// connection.setRequestMethod("POST");
			// connection.setRequestProperty("Proxy-Connection","Keep-Alive");
			connection.setDoOutput(true);
			connection.setDoInput(true);
			PrintWriter out = new PrintWriter(connection.getOutputStream());
			out.print(para);
			out.flush();
			out.close();
			BufferedReader in = new BufferedReader(new InputStreamReader(connection.getInputStream()));
			String line = "";
			String result = "";
			while ((line = in.readLine()) != null) {
			    result += line;
			}
			// System.out.println(result);
			// Thread.sleep((long) (Math.random()) * 1000);
			// 释放
			System.out.println("第：" + NO + " 个");
			semp.release();
		    } catch (Exception e) {
			e.printStackTrace();
		    }

		}

	    };
	    exec.execute(run);

	}
	// 退出线程池
	exec.shutdown();
    }

}
