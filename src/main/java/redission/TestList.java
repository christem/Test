package redission;

import java.util.List;

import org.redisson.Config;
import org.redisson.Redisson;
import org.redisson.RedissonClient;

public class TestList {

    protected static RedissonClient redisson;

    public static Config createConfig() {
	String redisAddress = System.getProperty("redisAddress");
	if (redisAddress == null) {
	    redisAddress = "127.0.0.1:6379";
	}
	Config config = new Config();
	config.useSingleServer().setAddress(redisAddress);
	return config;
    }

    public static RedissonClient createInstance() {
	Config config = createConfig();
	return Redisson.create(config);
    }

    public static void main(String args[]) {
	RedissonClient redisson = createInstance();

	List<Integer> list = redisson.getList("redissonlist");
	list.add(1);
	list.add(2);
	list.add(3);
	list.add(4);
	list.add(5);
	list.set(4, 6);

    }
}
