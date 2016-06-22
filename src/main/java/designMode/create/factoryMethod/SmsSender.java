package designMode.create.factoryMethod;

public class SmsSender implements Sender {

    @Override
    public void Send() {
	System.out.println("this is sms sender!");
    }
}