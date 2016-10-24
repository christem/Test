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
public class HouseCsTest1 {
	public static void main(String[] args) throws IOException {

		HttpRequestMethod method = new HttpRequestMethod();

		List<Map<String, String>> list = null;
		Map<String, String> map = null;

		for (int pageNo = 1; pageNo < 314; pageNo++) {
			System.out.println("******************************讀取第" + pageNo
					+ "頁******************************");
			list = new ArrayList<Map<String, String>>();
			// 獲取數據
			String content = method
					.sendPost(
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
						map.put((k + tdsize) + "", method.host + url);
					}
					list.add(map);
				}
			} catch (Exception e) {
				e.printStackTrace();
			}

			// 導入excel
			new ExcelUtil().appendXlsx("D://house.xlsx", list, 0,null);
		}
	}
}
