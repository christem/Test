package Thread.ArtConcurrentBook.chapter10.test;

import java.io.Serializable;

public class ThreadPoolTask implements Runnable, Serializable {  
	  
	private static final long serialVersionUID = 562092376575890453L;
	
	private Object attachData;  
  
    ThreadPoolTask(Object tasks) {  
        this.attachData = tasks;  
    }  
  
    public void run() {  
          
        System.out.println("开始执行任务：" + attachData);  
          
        attachData = null;  
    }  
  
    public Object getTask() {  
        return this.attachData;  
    }  
}  
