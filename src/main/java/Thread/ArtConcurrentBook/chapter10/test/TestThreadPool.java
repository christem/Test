package Thread.ArtConcurrentBook.chapter10.test;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

public class TestThreadPool {  
	  
    private static int produceTaskSleepTime = 2;  
      
    private static int produceTaskMaxNumber = 10;  
  
    public static void main(String[] args) {  
    	
    	
        // ����һ���̳߳�  
        ThreadPoolExecutor threadPool = new ThreadPoolExecutor(2, 4, 3,  
                TimeUnit.SECONDS, new ArrayBlockingQueue<Runnable>(3),  
                new ThreadPoolExecutor.DiscardOldestPolicy());  
        
        for (int i = 1; i <= produceTaskMaxNumber; i++) {  
            try {  
                String task = "task@ " + i;  
                System.out.println("���������ύ���̳߳��У�" + task);  
                threadPool.execute(new ThreadPoolTask(task));  
  
                Thread.sleep(produceTaskSleepTime);  
            } catch (Exception e) {  
                e.printStackTrace();  
            }  
        }  
    }  
}  
