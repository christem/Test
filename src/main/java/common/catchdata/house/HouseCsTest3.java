package common.catchdata.house;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
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

		// 实例化Configuration，下面方法默认加载hibernate.cfg.xml文件
		Configuration conf = new Configuration()
				.configure("/common/catchdata/house/hibernate.cfg.xml");
		// 以Configuration创建SessionFactory
		SessionFactory sf = conf.buildSessionFactory();
		// 创建Session
		Session sess = sf.openSession();
		// 开始事务
		Transaction tx = sess.beginTransaction();
		
		
		HttpRequestMethod method = new HttpRequestMethod();
		List<SaleDto> list = null;
		SaleDto saleDto=null;
		SaleStaticDto saleStaticDto =null;
		
		String saleNo;
		// 读取链接
		List<Map<String, String>> readList = new ExcelUtil()
				.readXlsxRetList("D://test2.xlsx");
		int commitNums =0;
		int saleCount=0;
		for (int a = 5900; a < 5901; a++) {
			saleNo = readList.get(a).get("0");

			System.out.println("******************************讀取第" + a
					+ "个记录******************************");

			list = new ArrayList<SaleDto>();
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
				
				saleStaticDto = new SaleStaticDto();
				saleStaticDto.setSaleNo(saleNo);
				
				
				try {
					saleCount =trs.size()-1;
				} catch (Exception e) {
					// TODO: handle exception
					saleCount=0;
				}
				
				saleStaticDto.setCount(saleCount);
				sess.save(saleStaticDto);
				
				for (int i = 1; i < trs.size(); i++) {
					
					saleDto = new SaleDto();
					saleDto.setSaleNo(saleNo);
					
					Elements tds = trs.get(i).select("td");

					int tdsize = tds.size();

					for (int j = 0; j < tdsize; j++) {
						String text = tds.get(j).text();
						if (j==0) {
							saleDto.setRoomNo(text);
						} else if (j==1) {
							saleDto.setFloorNo(text);
						}else if (j==2) {
							saleDto.setHouseUse(text);
						}else if (j==3) {
							saleDto.setHousingType(text);
						}else if (j==4) {
							saleDto.setDecorationStatus(text);
						}else if (j==5) {
							saleDto.setBuiltArea(text);
						}else if (j==6) {
							saleDto.setInnerArea(text);
						}else if (j==7) {
							saleDto.setShareArea(text);
						}else if (j==8) {
							saleDto.setPrice(text);
						}else if (j==9) {
							saleDto.setTotalPrice(text);
						}else if (j==10) {
							saleDto.setSaleStatus(text);
						}
						
					}
					sess.save(saleDto);
					commitNums+=1;
					
					if (commitNums==1000) {
						sess.flush();  
						sess.clear();  
						commitNums=0;
						// 提交事务
						tx.commit();
						tx = sess.beginTransaction();
					}
				}
			} catch (Exception e) {
				e.printStackTrace();
				System.out.println("*************出错"+saleNo);
				continue;
			}

		}
		tx.commit();
		// 关闭Session
		sess.close();
		sf.close();
	}
}
