package designMode.structure.Adapter;

/**
 * 适配器模式将某个类的接口转换成客户端期望的另一个接口表示，目的是消除由于接口不匹配所造成的类的兼容性问题。
 * 主要分为三类：类的适配器模式、对象的适配器模式、接口的适配器模式。
 *
 * 类的适配器模式：当希望将一个类转换成满足另一个新接口的类时，可以使用类的适配器模式，创建一个新类，继承原有的类，实现新的接口即可。
 * 
 * 类的适配器模式
 *
 */
public class Adapter extends Source implements Targetable {

    @Override
    public void method2() {
	System.out.println("this is the targetable method!");
    }

    public static void main(String[] args) {
	Targetable target = new Adapter();
	target.method1();
	target.method2();
    }
}
