package designMode.structure.Adapter;

/**
 * 对象的适配器模式
 * 基本思路和类的适配器模式相同，只是将Adapter类作修改，这次不继承Source类，而是持有Source类的实例，以达到解决兼容性的问题
 * 
 * 对象的适配器模式：当希望将一个对象转换成满足另一个新接口的对象时，可以创建一个Wrapper类，持有原类的一个实例，在Wrapper类的方法中，
 * 调用实例的方法就行。
 */
public class Adapter2 {

    public static void main(String[] args) {
	Source source = new Source();
	Targetable target = new Wrapper(source);
	target.method1();
	target.method2();
    }

}
