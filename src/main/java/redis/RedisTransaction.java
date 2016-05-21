package redis;

import redis.clients.jedis.Jedis;

public class RedisTransaction {

    public static void main(String[] args) {
	// 连接本地的 Redis 服务
	Jedis jedis = RedisUtil.getJedis();
	// 1.字符添加(Append)
	System.out.println(jedis.set("test", "hello"));
	System.out.println(jedis.append("test", " redis"));
	System.out.println(jedis.append("test", " redis"));

	RedisUtil.returnResource(jedis);
    }
}
