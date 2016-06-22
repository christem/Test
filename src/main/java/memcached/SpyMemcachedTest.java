package memcached;

import java.io.IOException;
import java.net.InetSocketAddress;

import net.spy.memcached.CASResponse;
import net.spy.memcached.CASValue;
import net.spy.memcached.MemcachedClient;

public class SpyMemcachedTest {

    /**
     * spymemcached客户端 是单线程的
     */
    public static void main(String[] args) {
	try {
	    MemcachedClient cached = new MemcachedClient(new InetSocketAddress("127.0.0.1", 11211));
	    cached.set("x", 1800, "aaa");
	    CASValue x1 = cached.gets("x");
	    CASValue x2 = cached.gets("x");
	    System.out.println("CAS x1: " + x1.getCas());
	    System.out.println("value x1: " + x1.getValue());
	    System.out.println("");
	    System.out.println("CAS x2: " + x2.getCas());
	    System.out.println("value x2: " + x2.getValue());
	    System.out.println("");

	    CASResponse rx2 = cached.cas("x", x2.getCas(), "bbb");
	    System.out.println("response x2: " + rx2.toString());
	    CASValue x3 = cached.gets("x");
	    System.out.println("CAS x3: " + x3.getCas());
	    System.out.println("value x3: " + x3.getValue());
	    System.out.println("");

	    CASResponse rx1 = cached.cas("x", x1.getCas(), "ccc");
	    System.out.println("response x1: " + rx1.toString());
	    CASValue x4 = cached.gets("x");
	    System.out.println("CAS x4: " + x4.getCas());
	    System.out.println("value x4: " + x4.getValue());
	    System.out.println("");

	    System.out.println("laster cax : " + cached.gets("x").getCas());

	    cached.flush();
	} catch (IOException e) {
	    e.printStackTrace();
	} finally {
	}
    }

}
