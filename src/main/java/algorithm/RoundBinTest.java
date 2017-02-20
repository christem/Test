/**   
 * @Project: Test 
 * @Title: RoundBinTest.java 
 * @Package algorithm 
 * @Description: TODO 
 * @author suny 
 * @date 2017年2月14日 下午3:44:04 
 * @Copyright: 2017 年 研信科技. All rights reserved  
 * @version V1.0   
 */
package algorithm;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;


public class RoundBinTest {

	public static List<String> list ;
	
	public static ConcurrentHashMap<String, Integer> map;

	static {
		map = new ConcurrentHashMap<String, Integer>();
		map.put("ser1", 1);
		map.put("ser2", 2);
		map.put("ser3", 3);
		map.put("ser4", 4);
		map.put("ser5", 5);
		map.put("ser6", 6);
	}
	
	/** 
	 * @Title: main 
	 * @Description: TODO(这里用一句话描述这个方法的作用) 
	 * @param args 参数说明
	 * @return void    返回类型
	 */
	public static void main(String[] args) {
		roundBin();
		Map<String, Integer> map = new HashMap<>();
		
		for (int i = 1; i < 100; i++) {
			String ser=getSer(i);
			
			if (map.containsKey(ser)) {
				int times = map.get(ser);
				map.put(ser, ++times);
			} else {
				map.put(ser, 1);
			}
		}
		System.out.println(map);
	}
	
	public static String getSer(int times){
		int size = list.size();
		 int position = times%size==0?size-1:times%size-1;
		 String value = list.get(position);
		 System.out.println(times+":"+position+":"+value);
		 return value;
	}
	
	
	public static void roundBin(){
		int max = getMaxPro();
		System.out.println(max);
		list = new ArrayList<>();

		Map<String, Integer> serMap = new HashMap<>();
		serMap.putAll(map);
		for (int i = 0; i < max; i++) {
			Set<String> set = serMap.keySet();
			Iterator<String> it = set.iterator();
			while (it.hasNext()) {
				String key = (String) it.next();
				Integer value = (Integer) serMap.get(key);
				if (value>0) {
					list.add(key);
					serMap.put(key, --value);
				}
			}
			System.out.println(serMap);
		}
		System.out.println(list);
	}
	
	public static int getMaxPro() {
		int max = 0;
		Set<Map.Entry<String, Integer>> set = map.entrySet();

		Iterator iterator = set.iterator();

		while (iterator.hasNext()) {
			Map.Entry<String, Integer> entry = (Entry) iterator.next();
			max = entry.getValue() > max ? entry.getValue() : max;
		}
		return max;
	}
}
