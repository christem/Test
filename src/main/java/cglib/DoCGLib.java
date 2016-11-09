/**   
 * @Project: Test 
 * @Title: DoCGLib.java 
 * @Package cglib 
 * @Description: TODO 
 * @author suny 
 * @date 2016年11月8日 下午5:41:24 
 * @Copyright: 2016 年 研信科技. All rights reserved  
 * @version V1.0   
 */
package cglib;

/** 
 * @ClassName DoCGLib  
 * @Description TODO 
 * @author suny 
 * @date 2016年11月8日  
 *   
 */
public class DoCGLib {
	public static void main(String[] args) {
		CglibProxy proxy = new CglibProxy();
		// 通过生成子类的方式创建代理类
		SayHello proxyImp = (SayHello) proxy.getProxy(SayHello.class);
		proxyImp.say();
	}
}
