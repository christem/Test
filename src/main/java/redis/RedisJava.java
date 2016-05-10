package redis;

import java.util.Iterator;
import java.util.Set;

import redis.clients.jedis.Jedis;

public class RedisJava {

    public static void main(String[] args) {
	// TODO Auto-generated method stub
	// 连接本地的 Redis 服务
	Jedis jedis = new Jedis("localhost");
	System.out.println("Connection to server sucessfully");
	// 查看服务是否运行
	jedis.auth("redis");
	// System.out.println("Server is running: " + jedis.ping());

	// // String
	// jedis.set("w3ckey", "Redis tutorial");
	// // 获取存储的数据并输出
	// System.out.println("Stored string in redis:: " +
	// jedis.get("w3ckey"));
	//
	// // List
	// // 存储数据到列表中
	// jedis.lpush("tutorial-list", "Redis");
	// jedis.lpush("tutorial-list", "Mongodb");
	// jedis.lpush("tutorial-list", "Mysql");
	// // 获取存储的数据并输出
	// List<String> list = jedis.lrange("tutorial-list", 0, 5);
	// for (int i = 0; i < list.size(); i++) {
	// System.out.println("Stored string in redis:: " + list.get(i));
	// }

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

	Set<String> set = jedis.zrevrange("w3ckey", 0, 2);
	Iterator iterator = set.iterator();
	while (iterator.hasNext()) {
	    System.out.println("List of stored keys:: " + iterator.next());

	}
    }

}
