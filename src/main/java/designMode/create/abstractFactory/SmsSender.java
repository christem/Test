package designMode.create.abstractFactory;

public class SmsSender implements Sender {

    @Override
    public void Send() {
	System.out.println("this is smssender!");
    }

}
