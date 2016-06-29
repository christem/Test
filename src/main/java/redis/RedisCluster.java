package redis;

import java.util.HashSet;
import java.util.Set;

import redis.clients.jedis.HostAndPort;
import redis.clients.jedis.JedisCluster;
import redis.clients.util.JedisClusterCRC16;

public class RedisCluster {

    public static void main(String[] args) {

	// Jedis jedis = new Jedis("192.168.2.145", 6379);
	// jedis.set("singleTest", "6379");
	// System.out.println(jedis.get("singleTest"));

	String key = "6";
	// 这东西 可以直接看到key 的分片数，就能知道放哪个 节点
	System.out.println(JedisClusterCRC16.getSlot(key));
	Set<HostAndPort> jedisClusterNodes = new HashSet<HostAndPort>();
	jedisClusterNodes.add(new HostAndPort("192.168.2.145", 7000));
	jedisClusterNodes.add(new HostAndPort("192.168.2.145", 7001));
	jedisClusterNodes.add(new HostAndPort("192.168.2.145", 7002));
	jedisClusterNodes.add(new HostAndPort("192.168.2.145", 7003));
	jedisClusterNodes.add(new HostAndPort("192.168.2.145", 7004));
	jedisClusterNodes.add(new HostAndPort("192.168.2.145", 7005));
	// 3个master 节点
	JedisCluster jc = new JedisCluster(jedisClusterNodes);

	for (int i = 0; i < 10; i++) {
	    jc.set("test" + i, "Redis cluster" + i);
	    // // 获取存储的数据并输出
	    System.out.println("string in redis:: " + jc.get("test") + i);
	}
    }
}
