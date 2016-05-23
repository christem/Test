package redis;

import java.util.List;

import redis.clients.jedis.Jedis;

public class RedisJava {

    public static void main(String[] args) {
	Jedis jedis = RedisUtil.getJedis();
	// System.out.println("Server is running: " + jedis.ping());

	// // String
	// jedis.set("w3ckey", "Redis tutorial");
	// // 获取存储的数据并输出
	// System.out.println("Stored string in redis:: " +
	// jedis.get("w3ckey"));
	//
	// // List
	// // 存储数据到列表中

	for (int i = 1; i <= 15; i++) {
	    long index = jedis.rpush("tutorial-list", "Redis" + i);
	    System.out.println(index);
	    if (index > 10) {
		jedis.lpop("tutorial-list");
	    }

	    // 获取存储的数据并输出
	    List<String> list = jedis.lrange("tutorial-list", 0, -1);
	    for (int j = 0; j < list.size(); j++) {
		System.out.println("Stored string in redis:: " + list.get(j));
	    }
	}
	// 获取数据并输出
	// HashSet<String> set = (HashSet<String>) jedis.keys("*");
	//
	// Iterator iterator = set.iterator();
	// while (iterator.hasNext()) {
	// System.out.println("List of stored keys:: " + iterator.next());
	//
	// }

	// jedis.zincrby("w3ckey", 2, "mysql");
	// jedis.zincrby("w3ckey", 2, "test");

	// Set<String> set = jedis.zrevrange("w3ckey", 0, 2);
	// Iterator iterator = set.iterator();
	// while (iterator.hasNext()) {
	// System.out.println("List of stored keys:: " + iterator.next());
	//
	// }

	// hash
	// jedis.hincrBy("test", "2016", 1);
	// jedis.hincrBy("test", "2015", 1);
	// jedis.hincrBy("test", "2014", 1);
	// jedis.hincrBy("test", "2013", 1);
	// jedis.hincrBy("test", "2019", 1);
	// System.out.println(jedis.hget("test", "2016"));
	// List<String> list = jedis.sort("test");
	// for (String str : list) {
	// System.out.println(str);
	// }
	// System.out.println(jedis.zscore("test", "2092"));

	// Set<String> set = jedis.zrangeByScore("test", 2, 2);
	// Iterator iterator = set.iterator();
	// System.out.println(set.size());
	// while (iterator.hasNext()) {
	// System.out.println("List of stored keys:: " + iterator.next());
	//
	// }
	RedisUtil.returnResource(jedis);
    }
}
