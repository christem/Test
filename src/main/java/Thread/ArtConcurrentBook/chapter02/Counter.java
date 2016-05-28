package Thread.ArtConcurrentBook.chapter02;

/**
 * Alipay.com Inc.
 * Copyright (c) 2004-2015 All Rights Reserved.
 */

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * ������
 * 
 * @author tengfei.fangtf
 * @version $Id: Snippet.java, v 0.1 2015-7-31 ����11:32:42 tengfei.fangtf Exp $
 */
public class Counter {

    private AtomicInteger atomicI = new AtomicInteger(0);
    private int i = 0;
    private volatile int m = 0;
    private Integer n = 0;

    public static void main(String[] args) {
	final Counter cas = new Counter();
	List<Thread> ts = new ArrayList<Thread>(600);
	long start = System.currentTimeMillis();
	for (int j = 0; j < 100; j++) {
	    Thread t = new Thread(new Runnable() {
		public void run() {
		    for (int i = 0; i < 10000; i++) {
			cas.count();
			cas.safeCount();
			++cas.m;
			synchronized (cas.n) {
			    ++cas.n;
			}
		    }
		}
	    });
	    ts.add(t);
	}
	for (Thread t : ts) {
	    t.start();

	}
	// �ȴ������߳�ִ�����
	for (Thread t : ts) {
	    try {
		t.join();
	    } catch (InterruptedException e) {
		e.printStackTrace();
	    }

	}
	System.out.println(cas.i);
	System.out.println(cas.atomicI.get());
	System.out.println(cas.m);
	System.out.println(cas.n);
	System.out.println(System.currentTimeMillis() - start);
    }

    /**
     * ʹ��CASʵ���̰߳�ȫ������
     */
    private void safeCount() {
	for (;;) {
	    int i = atomicI.get();
	    boolean suc = atomicI.compareAndSet(i, ++i);
	    if (suc) {
		break;
	    }
	}
    }

    /**
     * ���̰߳�ȫ������
     */
    private void count() {
	i++;
    }

}
