package common.util;

import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;


/** 
 * @ClassName ExportTask  
 * @Description TODO 
 * @author suny 
 * @date 2016年11月17日  
 *   
 */
public class ExportCSVTask {
	
	private ExportCSVTask(){}
	
	private static ExportCSVTask exportCSVTask=null;
	
	public static ExportCSVTask getInstance(){
		if (exportCSVTask==null) {
			exportCSVTask = new ExportCSVTask();
		}
		return exportCSVTask;
	}
	
	Object lock = new Object();
	
	private static Map<String, ExecutorService> executorMap = new ConcurrentHashMap<String, ExecutorService>();
	
	private ExecutorService getExecutorService(String topic){
		if (StringUtil.isEmpty(topic)) {
			topic ="undefined";
		}
		
		ExecutorService executor;
//		synchronized (lock) {
			executor = executorMap.get(topic);
			if (executor==null) {
				executor = Executors.newSingleThreadExecutor();
				executorMap.put(topic, executor);
				System.out.println(executorMap.size()+"  "+executorMap);
				try {
					TimeUnit.MILLISECONDS.sleep(3000);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
//		}
		return executor;
	}
	
	public void csvWrite(String num,String path,List<List<String>> list){
		csvWrite(num,path,list,"undefined");
	}
	
	public void csvWrite(String num,String path,List<List<String>> list,String topic){
		
		ExecutorService executor =getExecutorService(topic);
		executor.submit(new ExportCSVThread(num,path,list));
	}
	
	
	public static void main(String args[]){
		for (int i = 0; i <10; i++) {
			new Thread(){
				public void run(){
					for (int j = 0; j < 5; j++) {
						ExportCSVTask.getInstance().getExecutorService("test"+j);
					}
				}
			}.start();
			
			new Thread(){
				public void run(){
					for (int j = 3; j < 8; j++) {
						ExportCSVTask.getInstance().getExecutorService("test"+j);
					}
				}
			}.start();
		}
//		
//		List<List<String>> stringListList1 = new ArrayList<List<String>>();
//		List<String> stringList  = new ArrayList<String>();
//		for (int i = 0; i < 5; i++) {
//			stringList.add("num"+i);
//			stringListList1.add(stringList);
//			executor.submit(new ExportCSVThread("D:\\test.csv",stringListList1));
//		}
	}
}

class ExportCSVThread extends Thread {
	
	String num;
	String path;
	List<List<String>> list;
	
	public ExportCSVThread(String num,String path,List<List<String>> list) {
		this.num=num;
		this.path=path;
		this.list = list;
	}

	public void run() {
		System.err.println("正在写入第"+num+"份");
		CSVFileUtil.appendCSVFile(path,list);
	}
}