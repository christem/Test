
package common.catchdata.house;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CountDownLatch;

public class Test {

	/** 
	 * @Title: main 
	 * @Description: TODO(这里用一句话描述这个方法的作用) 
	 * @param args 参数说明
	 * @return void    返回类型
	 */
	public static void main(String[] args) {
		List<Integer> list = new ArrayList<Integer>();
		int k;
		for (int i = 0; i < 13419; i++) {
			k= i/300+1;
//			list.add(i);
			System.out.println(k+"   "+i);
		}
		
		
//		int fromIndex = 0;
//		int toIndex = 0;
//		int totalNum = list.size()/300+1;
//		for (int i = 1; i <= totalNum; i++) {
//			if (i == totalNum) {
//				toIndex = list.size();
//			} else {
//				toIndex = 300*i-1;
//			}
//		
//			list.subList(fromIndex, toIndex);
//			System.out.println(i +"  "+fromIndex+"   "+toIndex);
//			fromIndex = toIndex+1;
//			
//		}
		
//		List<Integer> list2 = list.subList(12900, 13199);
//		for (int i = 0; i <list2.size(); i++) {
//			System.out.println(list2.get(i));
//		}
		
	}

}
