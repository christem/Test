package redis;

import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPubSub;

public class RedisSub1 {

    public static void main(String[] args) {
	Jedis jedis = RedisUtil.getJedis();
	JedisPubSub jedisPubSub = new MyJedisPubSub();
	jedis.subscribe(jedisPubSub, new String[] { "channel1", "channel2" });
	RedisUtil.returnResource(jedis);
    }
}

class MyJedisPubSub extends JedisPubSub {
    @Override
    public void onUnsubscribe(String channel, int number) {
	System.out.println("channel: " + channel);
	System.out.println("number :" + number);
    }

    @Override
    public void onSubscribe(String channel, int number) {
	System.out.println("channel: " + channel);
	System.out.println("number :" + number);
    }

    @Override
    public void onPUnsubscribe(String arg0, int arg1) {
    }

    @Override
    public void onPSubscribe(String arg0, int arg1) {
    }

    @Override
    public void onPMessage(String arg0, String arg1, String arg2) {
    }

    @Override
    public void onMessage(String channel, String msg) {
	System.out.println("收到频道 : 【" + channel + " 】的消息 ：" + msg);
    }
}
