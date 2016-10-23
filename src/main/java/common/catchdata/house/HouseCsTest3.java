package common.catchdata.house;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.json.JSONObject;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;

import common.catchdata.HttpRequestMethod;
import common.util.ExcelUtil;

/**
 * 第一步获取楼盘列表
 * 
 * @author Suny
 *
 */
public class HouseCsTest3 {
	public static void main(String[] args) throws IOException {

		HttpRequestMethod method = new HttpRequestMethod();
		List<Map<String, String>> list = null;
		Map<String, String> map = null;
		String saleNo;

		// 读取链接
		List<Map<String, String>> readList = new ExcelUtil()
				.readXlsxRetList("D://test2.xlsx");
		for (int a = 0; a < readList.size(); a++) {

			saleNo = readList.get(a).get("0");

			if (a == 438) {
				System.out.println("err");
			}

			System.out.println("******************************讀取第" + a
					+ "个记录******************************");

			list = new ArrayList<Map<String, String>>();
			// 獲取數據
			String content = method.sendPost(
					"http://www.csfdc.gov.cn/index.php/home/Index/geths/",
					"ywzh=" + saleNo); // post请求访问页面(URL及参数已处理)
			JSONObject object;

			try {
				object = new JSONObject(content);
				String value = object.getString("content");
				Document doc = Jsoup.parse(value.toString());
				Elements trs = doc.select("table").select("tr");
				// System.out.println(realUrl);
				// System.out.println(connection);
				for (int i = 1; i < trs.size() - 1; i++) {
					int k = 0;
					map = new HashMap<String, String>();
					map.put(k + "", saleNo);
					++k;
					Elements tds = trs.get(i).select("td");

					int tdsize = tds.size();

					for (int j = 0; j < tdsize; j++, k++) {
						String text = tds.get(j).text();
						// System.out.println(text);
						map.put(k + "", text);
					}
					list.add(map);
				}
			} catch (Exception e) {
				e.printStackTrace();
			}

			// 導入excel
			new ExcelUtil().appendXlsx("D://sale.xlsx", list, 0);

		}
	}
}
