package redis;

import redis.clients.jedis.Jedis;

public class RedisSortedSets {

    public static void main(String[] args) {
	// 连接本地的 Redis 服务
	Jedis jedis = RedisUtil.getJedis(7);

	// System.out.println(jedis.zadd("sort-sets:test1", 1, "test1"));
	// System.out.println(jedis.zadd("sort-sets:test1", 2, "test2"));
	// System.out.println(jedis.zadd("sort-sets:test1", 3, "test3"));
	// System.out.println(jedis.zadd("sort-sets:test1", 4, "test4"));
	// System.out.println(jedis.zadd("sort-sets:test1", 5, "test5"));
	// System.out.println(jedis.zadd("sort-sets:test1", 6, "test6"));
	// System.out.println(jedis.zadd("sort-sets:test1", 7, "test7"));
	// System.out.println(jedis.zcard("sort-sets:test1"));
	// System.out.println(jedis.zcount("sort-sets:test1", 2, 5));
	// System.out.println(jedis.zincrby("sort-sets:test1", 2, "test7"));
	// System.out.println(jedis.zincrby("sort-sets:test1", 2, "test9"));
	// System.out.println(jedis.zadd("sort-sets:test2", 2, "one"));
	// System.out.println(jedis.zadd("sort-sets:test2", 3, "two"));
	// System.out.println(jedis.zadd("sort-sets:test3", 2, "one"));
	// System.out.println(jedis.zadd("sort-sets:test3", 3, "two"));
	// System.out.println(jedis.zadd("sort-sets:test3", 4, "three"));
	// ZParams zParams = new ZParams();
	// zParams.aggregate(Aggregate.SUM);
	// zParams.weightsByDouble(5, 6);
	// // one =2+2 two=3+3
	// System.out.println(jedis.zinterstore("sort-sets:out", zParams,
	// "sort-sets:test2", "sort-sets:test3"));
	// System.out.println(jedis.zrange("sort-sets:test1", 0, -1));
	// System.out.println(jedis.zrangeByScore("sort-sets:test1", 0, 3));
	// System.out.println(jedis.zrank("sort-sets:test1", "test1"));
	// System.out.println(jedis.zrange("sort-sets:test1", 0, -1));
	// System.out.println(jedis.zrem("sort-sets:test1", "test7"));
	// System.out.println(jedis.zrange("sort-sets:test1", 0, -1));
	// System.out.println(jedis.zremrangeByRank("sort-sets:test1", -2, -1));
	// System.out.println(jedis.zrange("sort-sets:test1", 0, -1));
	// System.out.println(jedis.zrange("sort-sets:test1", 0, -1));
	// System.out.println(jedis.zremrangeByScore("sort-sets:test1", 3, 3));
	// System.out.println(jedis.zrange("sort-sets:test1", 0, -1));
	// System.out.println(jedis.zrevrange("sort-sets:test1", 0, -1));
	// System.out.println(jedis.zrevrangeByScore("sort-sets:test1", 3, 1));
	// System.out.println(jedis.zrevrank("sort-sets:test1", "test4"));
	// System.out.println(jedis.zrevrank("sort-sets:test1", "test1"));
	// System.out.println(jedis.zscore("sort-sets:test1", "test4"));
	// try {
	//
	// System.out.println(jedis.zadd("sort-sets:test1",
	// System.currentTimeMillis(), "test1-10"));
	// System.out.println(jedis.zadd("sort-sets:test1",
	// System.currentTimeMillis(), "test1-5"));
	// Thread.sleep(1000);
	//
	// System.out.println(jedis.zadd("sort-sets:test1",
	// System.currentTimeMillis(), "test3-10"));
	// System.out.println(jedis.zadd("sort-sets:test1",
	// System.currentTimeMillis(), "test4-20"));
	// Thread.sleep(1000);
	// System.out.println(jedis.zadd("sort-sets:test1",
	// System.currentTimeMillis(), "test5-5"));
	// Thread.sleep(1000);
	// System.out.println(jedis.zadd("sort-sets:test1",
	// System.currentTimeMillis(), "test6-10"));
	// System.out.println(jedis.zadd("sort-sets:test1",
	// System.currentTimeMillis(), "test7-10"));
	// } catch (Exception e) {
	// // TODO: handle exception
	// e.printStackTrace();
	// }
	System.out.println(jedis.zrangeByScore("sort-sets:test1", 0, -1));

	RedisUtil.returnResource(jedis);
    }
}
