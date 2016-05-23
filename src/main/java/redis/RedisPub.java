package redis;

import redis.clients.jedis.Jedis;

public class RedisPub {

    public static void main(String[] args) {
	// 连接本地的 Redis 服务
	Jedis jedis = RedisUtil.getJedis();
	long i = jedis.publish("channel1", "channel1的朋友们，你们好吗？亲");
	System.out.println(i + " 个订阅者接受到了 channel1 消息");
	i = jedis.publish("channel2", "你好呀，亲");
	System.out.println(i + " 个订阅者接受到了 channel2 消息");
	RedisUtil.returnResource(jedis);
    }
}
