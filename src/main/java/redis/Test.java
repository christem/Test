package redis;

import redis.clients.jedis.Jedis;

public class Test extends Thread {

    public static void main(String[] args) {

	Jedis jedis = new Jedis("localhost", 6379);

	// 连接本地的 Redis 服务
	// Jedis jedis = new Jedis("localhost", 6379);
	// jedis.select(0);
	// String key = "statistics:post:ip:3232236189";
	// int test = jedis.incr(key).intValue();
	// System.out.println(test);

	// for (int i = 0; i < 10; i++) {
	// for (int j = 0; j < 100; j++) {
	// new Thread() {
	//
	// @Override
	// public void run() {
	// // 连接本地的 Redis 服务
	// Jedis jedis = new Jedis("localhost", 6379);
	// jedis.select(0);
	// String key = "statistics:post:ip:3232236189";
	//
	// int test = jedis.incr(key).intValue();
	// System.out.println(test);
	// try {
	// Thread.sleep(10);
	// } catch (InterruptedException e) {
	// e.printStackTrace();
	// }
	// if (test == 1) {
	// jedis.expire(key, 60 * 60);
	// }
	// Long ttl = jedis.ttl(key);
	// if (ttl == -1) {
	// jedis.expire(key, 60 * 60);
	// }
	// }
	// }.start();
	// }
	// }

    }
}
