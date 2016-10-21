package redis;

import redis.clients.jedis.Jedis;

public class RedisString {

    public static void main(String[] args) {
	// 连接本地的 Redis 服务
	Jedis jedis = RedisUtil.getJedis(1);
	// 1.字符添加(Append)
	 System.out.println(jedis.set("test", "hello"));
	 System.out.println(jedis.get("test"));
	 System.out.println(jedis.incr("test"));
	 System.out.println(jedis.get("test"));
	 
	// System.out.println(jedis.append("test", " redis"));

	// 2.设置value为整型 进行加减操作
	// System.out.println(jedis.set("testStr", "9"));
	// // 减1
	// System.out.println(jedis.decr("testStr"));
	// // 减5
	// System.out.println(jedis.decrBy("testStr", 5));
	// // 加1
	// System.out.println(jedis.incr("testStr"));
	// // 加8
	// System.out.println(jedis.incrBy("testStr", 8));
	// System.out.println(jedis.set("testStr2", "9.1"));

	// 3.get
	// System.out.println(jedis.set("test", "hello world"));
	//
	// System.out.println(jedis.get("test"));
	// System.out.println(jedis.getrange("test", 0, 4));
	// System.out.println(jedis.getbit("test", 4));

	// 4.mget mset
	// System.out.println(jedis.set("test1", "hello "));
	// System.out.println(jedis.set("test2", "world"));
	// System.out.println(jedis.mget("test1", "test2"));
	// System.out.println(jedis.mget("test1", "test2", "test3"));
	//
	// System.out.println(jedis.mset("test4", "hello ", "test5", "world "));
	// System.out.println(jedis.mget("test4", "test5"));

	// 5.setrange
	// System.out.println(jedis.set("test1", "0123456789"));
	// System.out.println(jedis.setrange("test1", 0, "abcde"));
	// System.out.println(jedis.get("test1"));
	// System.out.println(jedis.setrange("test1", 11, "abcde"));
	// System.out.println(jedis.get("test1"));

	// 6.strlen
	// System.out.println(jedis.set("str1", "test1"));
	// // System.out.println(jedis.strlen("test1"));
	// System.out.println(jedis.setnx("str1", "test2"));
	// System.out.println(jedis.setnx("str2", "test3"));
	// System.out.println(jedis.setnx("str1", "test1"));
	// System.out.println(jedis.getSet("str1", "test2"));
	// System.out.println(jedis.getSet("str2", "test3"));
	// int timemills = 15;
	// System.out.println(jedis.expire("str2", timemills));
	// try {
	// while (timemills > 0) {
	// timemills = jedis.ttl("str2") != null ? jedis.ttl("str2").intValue()
	// : 0;
	// Thread.sleep(500);
	// System.out.println(timemills);
	// }
	// } catch (InterruptedException e) {
	// // TODO Auto-generated catch block
	// e.printStackTrace();
	// }

	System.out.println(jedis.set("String:testStr", "test1"));
	System.out.println(jedis.set("String:testStr", "test2"));
	System.out.println(jedis.set("String:testStr", "test3"));
	jedis.expire("String:testStr", 60 * 60 * 2);

	RedisUtil.returnResource(jedis);
    }
}
