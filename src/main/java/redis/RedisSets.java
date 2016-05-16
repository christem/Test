package redis;

import redis.clients.jedis.Jedis;

public class RedisSets {

    public static void main(String[] args) {
	// 连接本地的 Redis 服务
	Jedis jedis = RedisUtil.getJedis();
	// System.out.println(jedis.sadd("sets:test1", "a"));
	// System.out.println(jedis.sadd("sets:test1", "b"));
	// System.out.println(jedis.sadd("sets:test1", "c"));
	// System.out.println(jedis.sadd("sets:test1", "d"));
	// System.out.println(jedis.sadd("sets:test1", "e"));
	// System.out.println(jedis.sadd("sets:test1", "f"));
	// System.out.println(jedis.sadd("sets:test1", "g"));
	// System.out.println(jedis.smembers("sets:test1"));
	//
	// System.out.println(jedis.sadd("sets:test2", "a"));
	// System.out.println(jedis.sadd("sets:test2", "b"));
	// System.out.println(jedis.sadd("sets:test2", "e"));
	// System.out.println(jedis.smembers("sets:test2"));
	//
	// System.out.println(jedis.sadd("sets:test3", "e"));
	// System.out.println(jedis.sadd("sets:test3", "f"));
	// System.out.println(jedis.smembers("sets:test3"));
	//
	// System.out.println(jedis.scard("sets:test1"));
	// System.out.println(jedis.sdiff("sets:test1", "sets:test2",
	// "sets:test3"));
	//
	// System.out.println(jedis.sdiffstore("sets:test4", "sets:test1",
	// "sets:test2"));
	// System.out.println(jedis.smembers("sets:test4"));
	//
	// System.out.println(jedis.sinter("sets:test4", "sets:test1",
	// "sets:test2"));
	//
	// System.out.println(jedis.sinterstore("sets:test5", "sets:test1",
	// "sets:test2"));
	//
	// System.out.println(jedis.smembers("sets:test5"));
	//
	// System.out.println(jedis.sismember("sets:test5", "a"));
	//
	// System.out.println(jedis.smove("sets:test1", "sets:test3", "a"));
	//
	// System.out.println(jedis.smembers("sets:test1"));
	// System.out.println(jedis.smembers("sets:test3"));
	//
	// System.out.println(jedis.spop("sets:test1"));
	// System.out.println(jedis.smembers("sets:test1"));
	//
	// System.out.println(jedis.srandmember("sets:test1"));
	// System.out.println(jedis.srem("sets:test1", "g"));
	// System.out.println(jedis.smembers("sets:test1"));

	System.out.println(jedis.smembers("sets:test1"));
	System.out.println(jedis.sunionstore("sets:test4", "h", "i", "j"));
	System.out.println(jedis.smembers("sets:test4"));
	RedisUtil.returnResource(jedis);
    }
}
