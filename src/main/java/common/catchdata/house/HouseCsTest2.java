package common.catchdata.house;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

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
public class HouseCsTest2 {
	public static void main(String[] args) throws IOException {

		HttpRequestMethod method = new HttpRequestMethod();
		List<Map<String, String>> list = null;
		List<Map<String, String>> buildList = null;
		Map<String, String> map = null;
		Map<String, String> buildmap = null;
		String readUrl;

		// 读取链接
		List<Map<String, String>> readList = new ExcelUtil().readXlsxRetList("D://test.xlsx");
		for (int a = 0; a < readList.size(); a++) {

			readUrl = readList.get(a).get("0");

			System.out.println("******************************讀取第" + a
					+ "个记录******************************");

			list = new ArrayList<Map<String, String>>();
			buildList = new ArrayList<Map<String, String>>();
			// 獲取數據
			String content = method.sendGet(readUrl, null); // post请求访问页面(URL及参数已处理)
			try {
				Document doc = Jsoup.parse(content);
				Elements tabs = doc.select("table");

				int c = 1;
				int d = 0;
				map = new HashMap<String, String>();
				for (int b = tabs.size() - 1; b >= 0; b--, c++) {
//					System.out.println(tabs.get(b));
					if (c == 7) {
						String text = tabs.get(b).select("td").get(0).text();
						map.put(d + "", text);
						++d;
					}

					if (c == 5) {

						Elements trs = tabs.get(b).select("tr");

						for (int i = 0; i < trs.size() - 1; i++) {

							Elements tds = trs.get(i).select("td");

							int tdsize = tds.size();

							for (int j = 0; j < tdsize; j++) {

								if (j % 2 == 0) {
									continue;
								}

								String text = tds.get(j).text();
								map.put(d + "", text);
								++d;
							}
						}
					}
					
					map.put(d+"", a+"");

					if (c == 1) {
						Elements trs = tabs.get(b).select("tr");

						for (int i = 1; i < trs.size() - 1; i++) {
							buildmap = new HashMap<String, String>();
							Elements tds = trs.get(i).select("td");

							if (i % 2 == 0) {
								continue;
							}

							int tdsize = tds.size();

							for (int j = 0; j < tdsize; j++) {
								String text;
								if (j == 8) {
									text = tds.get(j).attr("onclick");
								} else {
									text = tds.get(j).text();
								}

								buildmap.put(j + "", text);
							}
							
							buildmap.put("9", a+"");
							
							if (buildmap != null && buildmap.size() > 0) {
								buildList.add(buildmap);
							}
						}
					}
					System.out.println("********************" + c + "***********************");
				}

				if (map != null && map.size() > 0) {
					list.add(map);
				}
			} catch (Exception e) {
				e.printStackTrace();
			}

			// 導入excel
			new ExcelUtil().appendXlsx("D://house2.xlsx", list, 0, null);
			new ExcelUtil().appendXlsx("D://room.xlsx", buildList, 0, null);
		}
	}
}
