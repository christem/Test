package collection;

import java.util.Hashtable;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class LinkedHashMapTest {

    public static void main(String[] args) {

	Map<String, Object> map = new Hashtable<String, Object>();
	Map<String, Object> concurrentMap = new ConcurrentHashMap<String, Object>();
	// Map<String, Object> map = new HashMap<String, Object>();
	// System.out.println(map);
	// map.put("test1", 1);
	// map.put("test2", 2);
	// map.put("test3", 3);
	// map.put("test4", 4);
	// map.put("test5", 5);
	// map.put("test6", 6);
	// map.put("test7", 7);
	// map.put("test8", 8);
	// map.put("test9", 9);
	// map.put("test10", 10);
	// map.put("test11", 11);
	// map.put("test12", 12);
	// map.put("test13", 13);
	// map.put("test14", 14);
	// map.put("test15", 15);
	// map.put("test16", 16);
	// map.put("test17", 17);
	// map.put("test18", 18);
	// map.get("test1");
	// System.out.println(map.size());
	// System.out.println(map);

	// String key = "test";
	// int value = 5;
	// int v1 = Objects.hashCode(key);
	// int v2 = Objects.hashCode(value);
	// System.out.println((v1 ^ v2));
	// int a = 15;
	// int b = 2;
	// System.out.println("a 与 b 异或的结果是：" + (a ^ b));

	// Map<String, Integer> map = new LinkedHashMap<String, Integer>();
	//
	// map.put("s1", 1);
	// map.put("s2", 2);
	// map.put("s3", 3);
	// map.put("s4", 4);
	// map.put("s5", 5);
	// map.put(null, 9);
	// map.put("s6", 6);
	// map.put("s7", 7);
	// map.put("s8", 8);
	// map.put(null, 11);
	// for (Map.Entry<String, Integer> entry : map.entrySet()) {
	// System.out.println(entry.getKey() + ":" + entry.getValue());
	// }
	// System.out.println(map);

	// accessOrder默认为false，即按照插入顺序遍历
	// 如果设置为true则按照访问顺序遍历
	// Map<String, Integer> map = new LinkedHashMap<>(16, 0.75f, true);
	// map.put("s1", 1);
	// map.put("s2", 2);
	// map.put("s3", 3);
	// map.put("s4", 4);
	// map.put("s5", 5);
	// map.put(null, 9);
	// map.put("s6", 6);
	// map.put("s7", 7);
	// map.put("s8", 8);
	// map.put(null, 11);
	// map.get("s6");
	// for (Map.Entry<String, Integer> entry : map.entrySet()) {
	// System.out.println(entry.getKey() + ":" + entry.getValue());
	// }

	// Iterator<String> iterator = map.keySet().iterator();
	// while (iterator.hasNext()) {
	// String name = iterator.next();
	// System.out.print(name);
	// System.out.println("->" + map.get(name));
	// }

	// for (Iterator<String> iterator = map.keySet().iterator();
	// iterator.hasNext();) {
	// String name = iterator.next();
	// System.out.println(name + "->" + map.get(name));
	// }
    }
}
