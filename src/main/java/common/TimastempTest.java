package common;

public class TimastempTest {

    public static void main(String[] args) {
	// TODO Auto-generated method stub
	for (int i = 0; i < 300; i++) {
	    try {
		Thread.sleep(1);
		System.out.println("第" + i + "次：" + System.currentTimeMillis());
	    } catch (InterruptedException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	    }

	}

    }

}
