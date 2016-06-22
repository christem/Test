package designMode.create.factoryMethod;

/**
 * 普通工厂模式，就是建立一个工厂类，对实现了同一接口的一些类进行实例的创建
 * 
 * @author lifeix
 *
 */
public class FactoryTest {
    public static void main(String[] args) {
	SendFactory factory = new SendFactory();
	Sender smssender = factory.produce("sms");
	smssender.Send();

	Sender mailsender = factory.produce("mail");
	mailsender.Send();
    }
}
