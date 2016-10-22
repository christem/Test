package common.catchdata;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.URL;
import java.net.URLConnection;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.json.JSONObject;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;

import common.util.ExcelUtil;

public class GetHtmlDataTest {

	static URL realUrl = null;
	// 打开和URL之间的连接
	static URLConnection connection = null;

	static String host = "";

	/**
	 * 向指定URL发送GET方法的请求
	 * 
	 * @param url
	 *            发送请求的URL
	 * @param param
	 *            请求参数，请求参数应该是 name1=value1&name2=value2 的形式。
	 * @return URL 所代表远程资源的响应结果
	 */
	public static String sendGet(String url, String param) {
		String result = "";
		BufferedReader in = null;
		try {
			String urlNameString = url + "?" + param;
			realUrl = new URL(urlNameString);
			connection = realUrl.openConnection();
			// 设置通用的请求属性
			connection.setRequestProperty("accept", "*/*");
			connection.setRequestProperty("connection", "Keep-Alive");
			connection.setRequestProperty("user-agent",
					"Mozilla/4.0 (compatible; MSIE 6.0; Windows NT 5.1;SV1)");
			// 建立实际的连接
			connection.connect();
			// 获取所有响应头字段
			Map<String, List<String>> map = connection.getHeaderFields();
			// 遍历所有的响应头字段
			// 定义 BufferedReader输入流来读取URL的响应
			in = new BufferedReader(new InputStreamReader(
					connection.getInputStream(), "gb2312"));
			String line;
			while ((line = in.readLine()) != null) {
				result += line;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		// 使用finally块来关闭输入流
		finally {
			try {
				if (in != null) {
					in.close();
				}
			} catch (Exception e2) {
				e2.printStackTrace();
			}
		}
		return result;
	}

	/**
	 * 向指定 URL 发送POST方法的请求(网上找的，未经测试)
	 * 
	 * @param url
	 *            发送请求的 URL
	 * @param param
	 *            请求参数，请求参数应该是 name1=value1&name2=value2 的形式。
	 * @return 所代表远程资源的响应结果
	 */
	public static String sendPost(String url, String param) {
		PrintWriter out = null;
		BufferedReader in = null;
		String result = "";
		try {
			realUrl = new URL(url);
			// 打开和URL之间的连接
			connection = realUrl.openConnection();
			// 设置通用的请求属性
			connection.setRequestProperty("accept", "*/*");
			connection.setRequestProperty("connection", "Keep-Alive");
			connection.setRequestProperty("user-agent",
					"Mozilla/4.0 (compatible; MSIE 6.0; Windows NT 5.1;SV1)");
			// 发送POST请求必须设置如下两行
			connection.setDoOutput(true);
			connection.setDoInput(true);
			// 获取URLConnection对象对应的输出流
			out = new PrintWriter(connection.getOutputStream());
			// 发送请求参数
			out.print(param);
			// flush输出流的缓冲
			out.flush();
			host = realUrl.getHost();
			// 定义BufferedReader输入流来读取URL的响应
			in = new BufferedReader(new InputStreamReader(
					connection.getInputStream()));
			String line;
			while ((line = in.readLine()) != null) {
				result += line;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		// 使用finally块来关闭输出流、输入流
		finally {
			try {
				if (out != null) {
					out.close();
				}
				if (in != null) {
					in.close();
				}
			} catch (IOException ex) {
				ex.printStackTrace();
			}
		}
		return result;
	}

	public static void main(String[] args) throws IOException {

		List<Map<String, String>> list = null;
		Map<String, String> map = null;

		for (int pageNo = 1; pageNo < 314; pageNo++) {
			System.out.println("******************************讀取第" + pageNo
					+ "頁******************************");
			list = new ArrayList<Map<String, String>>();
			// 獲取數據
			String content = sendPost(
					"http://www.csfdc.gov.cn/index.php/home/Index/getnewslist/",
					"type=25&p=" + pageNo); // post请求访问页面(URL及参数已处理)
			JSONObject object;
			try {
				object = new JSONObject(content);
				String value = object.getString("content");
				Document doc = Jsoup.parse(value.toString());
				Elements trs = doc.select("table").select("tr");
				// System.out.println(realUrl);
				// System.out.println(connection);
				for (int i = 1; i < trs.size() - 1; i++) {

					map = new HashMap<String, String>();

					Elements tds = trs.get(i).select("td");

					int tdsize = tds.size();

					for (int j = 0; j < tdsize; j++) {
						String text = tds.get(j).text();
						// System.out.println(text);
						map.put(j + "", text);
					}

					Elements as = trs.get(i).select("a");
					for (int k = 0; k < as.size(); k++) {
						String url = as.get(k).attr("href");
						// System.out.println(host+url);
						map.put((k + tdsize) + "", host + url);
					}
					list.add(map);
				}
			} catch (Exception e) {
				e.printStackTrace();
			}

			// 導入excel
			ExcelUtil.appendXlsx("D://house.xlsx", list);
		}

	}
}
