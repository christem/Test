package algorithm;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

public class RoundRobin {

	private int currentIndex = -1;// 当前位置
	private int currentWeight = 0 ;//当前权重
	private int maxGcd = 0 ;	//最大权重数
	private int maxWeight = 0;// 最大公约数
	private int servetCount = 0 ;// 总服务器数量
	
	private List<Server> serverLst; // 服务器列表 
	
	
	private int gcd (int a , int b){
		BigInteger b1 = new BigInteger(String.valueOf(a));
		BigInteger b2 = new BigInteger(String.valueOf(b));
		BigInteger result = b1.gcd(b2);
		return result.intValue();
	}
	
	private int getMaxCurrentGcd (List<Server> serverList){
		int result = 0 ;
		for(int i = 0,len = serverLst.size();i< len -1 ;i++){
			if(result == 0){
				result = gcd(serverLst.get(i).weight, serverLst.get(i+1).weight);
			}else{
				result = gcd (result,serverLst.get(i+1).weight);
			}
		}
		return result;
	}
	
	private int getMaxCurrentWeight(List<Server> serverList){
		int result = 0 ;
		for(int i = 0,len = serverLst.size();i< len -1 ;i++){
			if( result ==0 ){
				result = Math.max(serverLst.get(i).weight, serverLst.get(i+1).weight);
			}else{
				result= Math.max(result, serverLst.get(i).weight);
			}
		}
		return result ;
	}
	
	public static void main(String[] args){
		RoundRobin obj =new RoundRobin();
		obj.init();
		Map<String,Integer> map = new HashMap<String,Integer>();
		for(int i=0;i<10000;i++){
			
			Server ser = obj.getServer();
			String ip = ser.getIp();
			if(map.containsKey(ip)){
				map.put(ip, map.get(ip)+1);
			}else{
				map.put(ip, 1);
			}
		}
		System.out.println(map);
		for (Entry<String, Integer> m: map.entrySet()) {
			System.out.println("服务器 " + m.getKey() + " 请求次数： " + m.getValue());
		}
		
	}
	
	/**
	 * 
	 * @Title: getServer 
	 * @Description: 服务获取方式：
	 * 	1.初始化开始位置为-1,权重是0,
	 * 	2.第1次轮询获取服务器未当前服务器权重最高的
	 *  3.第2次轮询权重递减1,获取有大于等于该权限的服务器
	 *  4.重复第3步,直到权重为最小值0时,从第1步开始从新轮询
	 * @return 参数说明
	 * @return Server    返回类型
	 */
	public Server getServer(){
		while (true){
			currentIndex = (currentIndex + 1) % servetCount;
			if(currentIndex ==0 ){
				currentWeight = currentWeight - maxGcd; 
				if(currentWeight <= 0 ){
					currentWeight = maxWeight ;
					if(currentWeight == 0 )
						return null;
				}
			}
			if(serverLst.get(currentIndex).weight >= currentWeight ){
				return serverLst.get(currentIndex);
			}
		}
	}
	
	public Server getServerBySort(){
		
		return null;
	}

	public void init(){
		Server s1 = new Server("ser1", 1);
		Server s2 = new Server("ser2", 2);
		Server s3 = new Server("ser3", 3);
		Server s4 = new Server("ser4", 4);
		Server s5 = new Server("ser5", 5);
		Server s6 = new Server("ser6", 6);
		
		serverLst = new ArrayList<Server>();
		serverLst.add(s1);
		serverLst.add(s2);
		serverLst.add(s3);
		serverLst.add(s4);
		serverLst.add(s5);
		serverLst.add(s6);
		
		maxGcd = getMaxCurrentGcd(serverLst);
		maxWeight = getMaxCurrentWeight(serverLst);
		currentIndex = -1 ;
		currentWeight = 0 ;
		servetCount = serverLst.size();
	}
	
	public int getCurrentIndex() {
		return currentIndex;
	}
	public void setCurrentIndex(int currentIndex) {
		this.currentIndex = currentIndex;
	}
	public int getCurrentWeight() {
		return currentWeight;
	}
	public void setCurrentWeight(int currentWeight) {
		this.currentWeight = currentWeight;
	}
	public int getMaxGcd() {
		return maxGcd;
	}
	public void setMaxGcd(int maxGcd) {
		this.maxGcd = maxGcd;
	}
	public int getMaxWeight() {
		return maxWeight;
	}
	public void setMaxWeight(int maxWeight) {
		this.maxWeight = maxWeight;
	}
	public int getServetCount() {
		return servetCount;
	}
	public void setServetCount(int servetCount) {
		this.servetCount = servetCount;
	}


	class Server {
		private String ip;
		private int weight;
		
		public Server(String ip, int weight) {
			super();
			this.ip = ip;
			this.weight = weight;
		}
		public String getIp() {
			return ip;
		}
		public void setIp(String ip) {
			this.ip = ip;
		}
		public int getWeight() {
			return weight;
		}
		public void setWeight(int weight) {
			this.weight = weight;
		}
		
	}

}
