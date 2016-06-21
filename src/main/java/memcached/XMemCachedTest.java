package memcached;

import java.io.IOException;
import java.util.concurrent.TimeoutException;

import net.rubyeye.xmemcached.Counter;
import net.rubyeye.xmemcached.MemcachedClient;
import net.rubyeye.xmemcached.MemcachedClientBuilder;
import net.rubyeye.xmemcached.XMemcachedClientBuilder;
import net.rubyeye.xmemcached.exception.MemcachedException;
import net.rubyeye.xmemcached.utils.AddrUtil;

/**
 * 使用memcached的缓存实用类.
 *
 */
public class XMemCachedTest {

    public static void main(String[] args) {

	try {
	    MemcachedClientBuilder builder = new XMemcachedClientBuilder(AddrUtil.getAddresses("localhost:11211"));
	    MemcachedClient client = builder.build();

	    // 简单实例
	    // client.set("hello", 0, "Hello,xmemcached");
	    // String value = (String) client.get("hello");
	    // System.out.println("hello=" + value);
	    // client.delete("hello");
	    // value = (String) client.get("hello");
	    // System.out.println("hello=" + value);

	    // 主要方法
	    // client.flushAll();
	    // if (!client.set("hello", 0, "world")) {
	    // System.err.println("set error");
	    // }
	    // System.out.println(client.get("hello"));
	    //
	    // if (client.add("hello", 0, "dennis")) {
	    // System.err.println("Add error,key is existed");
	    // }
	    // System.out.println(client.get("hello"));
	    //
	    // if (!client.replace("hello", 0, "dennis")) {
	    // System.err.println("replace error");
	    // }
	    // System.out.println(client.get("hello"));
	    //
	    // client.append("hello", " good");
	    // System.out.println(client.get("hello"));
	    //
	    // client.prepend("hello", "hello ");
	    // System.out.println(client.get("hello"));
	    //
	    // String name = client.get("hello", new StringTranscoder());
	    // System.out.println(name);
	    //
	    // client.deleteWithNoReply("hello");

	    // 迭代器
	    // client.flushAll();
	    // client.set("test1", 0, "hello");
	    // client.set("test2", 0, "world");
	    // client.set("test3", 0, "!");
	    // KeyIterator it =
	    // client.getKeyIterator(AddrUtil.getOneAddress("localhost:11211"));
	    // while (it.hasNext()) {
	    // // String key = it.next();
	    // System.out.println(it.next());
	    // }

	    Counter counter = client.getCounter("counter", 0);
	    System.out.println(counter.get());
	    counter.incrementAndGet();
	    System.out.println(counter.get());
	    counter.decrementAndGet();
	    System.out.println(counter.get());
	    counter.addAndGet(-10);
	    System.out.println(counter.get());

	    client.shutdown();
	} catch (MemcachedException e) {
	    System.err.println("MemcachedClient operation fail");
	    e.printStackTrace();
	} catch (InterruptedException e) {
	    // ignore
	} catch (TimeoutException e) {
	    // TODO Auto-generated catch block
	    e.printStackTrace();
	} catch (IOException e) {
	    System.err.println("Shutdown MemcachedClient fail");
	    e.printStackTrace();
	}
    }
}
