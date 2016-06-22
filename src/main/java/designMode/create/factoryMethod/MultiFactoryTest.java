package designMode.create.factoryMethod;

/**
 * 多个工厂方法模式，是对普通工厂方法模式的改进，
 * 在普通工厂方法模式中，如果传递的字符串出错，则不能正确创建对象，而多个工厂方法模式是提供多个工厂方法，分别创建对象
 *
 */
public class MultiFactoryTest {

    public static void main(String[] args) {
	MultiSendFactory factory = new MultiSendFactory();
	Sender mailsender = factory.produceMail();
	mailsender.Send();

	Sender smssender = factory.produceSms();
	smssender.Send();
    }
}