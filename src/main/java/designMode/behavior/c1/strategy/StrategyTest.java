package designMode.behavior.c1.strategy;

/**
 * 策略模式（strategy）
 *
 * 策略模式定义了一系列算法，并将每个算法封装起来，使他们可以相互替换，且算法的变化不会影响到使用算法的客户。
 * 
 * 需要设计一个接口，为一系列实现类提供统一的方法，多个实现类实现该接口，设计一个抽象类（可有可无，属于辅助类），提供辅助函数
 */
public class StrategyTest {

    public static void main(String[] args) {
	String exp = "2+8";
	ICalculator cal = new Plus();
	int result = cal.calculate(exp);
	System.out.println(result);

	String exp2 = "2*8";
	ICalculator cal2 = new Multiply();
	int result2 = cal2.calculate(exp2);
	System.out.println(result2);
    }
}
