package redis;

import redis.clients.jedis.Jedis;

public class RedisHashes {

    public static void main(String[] args) {
	// 连接本地的 Redis 服务
	Jedis jedis = RedisUtil.getJedis(1);

	//
	System.out.println(jedis.hset("hashes:test1", "1", "test1"));
	System.out.println(jedis.hset("hashes:test1", "2", "test2"));
	System.out.println(jedis.hset("hashes:test1", "3", "test3"));
	System.out.println(jedis.hset("hashes:test1", "3", "10"));
	// System.out.println(jedis.hset("hashes:test1", "5", "10"));
	// System.out.println(jedis.hgetAll("hashes:test1"));
	// System.out.println(jedis.hvals("hashes:test1"));
	// System.out.println(jedis.hget("hashes:test1", "1"));
	// System.out.println(jedis.hexists("hashes:test1", "1"));
	// System.out.println(jedis.hexists("hashes:test1", "4"));
	// System.out.println(jedis.hincrBy("hashes:test1", "1", 1));
	// System.out.println(jedis.hincrBy("hashes:test1", "1", 1));
	// System.out.println(jedis.hincrBy("hashes:test1", "2", 1));
	// System.out.println(jedis.hincrBy("hashes:test2", "1", 1));
	// System.out.println(jedis.hincrBy("hashes:test2", "2", 1));
	// System.out.println(jedis.del("hashes:test1"));
	// System.out.println(jedis.hsetnx("hashes:test1", "3", "10"));
	// System.out.println(jedis.hgetAll("hashes:test1"));
	// System.out.println(jedis.hkeys("hashes:test1"));
	// System.out.println(jedis.hlen("hashes:test1"));
	// System.out.println(jedis.hdel("hashes:test1", "1"));
	// System.out.println(jedis.hlen("hashes:test1"));

	RedisUtil.returnResource(jedis);
    }
}
