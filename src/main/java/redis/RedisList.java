package redis;

import redis.clients.jedis.Jedis;

public class RedisList {

    public static void main(String[] args) {
	// 连接本地的 Redis 服务
	Jedis jedis = RedisUtil.getJedis(1);
	// System.out.println(jedis.rpushx("list:test1", "error"));
	// System.out.println(jedis.rpush("list:test1", "test0"));
	// System.out.println(jedis.rpush("list:test1", "test2"));
	// System.out.println(jedis.rpush("list:test1", "test3"));
	// System.out.println(jedis.rpush("list:test1", "test4"));
	// System.out.println(jedis.rpush("list:test1", "test5"));
	// System.out.println(jedis.rpush("list:test1", "test6"));
	// System.out.println(jedis.lset("list:test1", 0, "test1"));
	// System.out.println(jedis.lpush("list:test1", "test10"));
	// System.out.println(jedis.lrange("list:test1", 0, -1));
	//
	// System.out.println(jedis.lpop("list:test1"));
	// System.out.println(jedis.lrange("list:test1", 0, -1));
	// System.out.println(jedis.rpoplpush("list:test1", "new"));
	// System.out.println(jedis.lrange("list:test1", 0, -1));
	// System.out.println(jedis.llen("list:test1"));
	// System.out.println(jedis.lindex("list:test1", 3));
	// System.out.println(jedis.linsert("list:test1", LIST_POSITION.BEFORE,
	// "test3", "before"));
	// System.out.println(jedis.lrange("list:test1", 0, -1));
	// System.out.println(jedis.lrem("list:test1", 1, "test4"));
	// System.out.println(jedis.lrange("list:test1", 0, -1));
	// System.out.println(jedis.ltrim("list:test1", 1, -1));
	// System.out.println(jedis.lrange("list:test1", 0, -1));
	// System.out.println(jedis.rpush("list:test2", "error"));
	// System.out.println(jedis.rpush("list:test2", "error"));
	// System.out.println(jedis.rpush("list:test3", "error"));
	System.out.println(jedis.del("list"));

	RedisUtil.returnResource(jedis);
    }
}
