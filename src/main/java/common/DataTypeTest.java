package common;

public class DataTypeTest {

    public static void main(String args[]) {
	// DataTypeTest dt = new DataTypeTest();

	Double a = Double.valueOf(100);
	Double b = 100D;
	// “==”比较的是地址，而a和b两个对象的地址不同，即是两个对象，所以都是false
	System.out.println("m11 result " + (a == b));

	// dt.m11();
	// dt.m12();
	//
	// dt.m31();
	// dt.m32();
	//
	// dt.m41();
	// dt.m42();
    }

    public void m11() {
	Integer a = new Integer(100);
	Integer b = 100;
	// “==”比较的是地址，而a和b两个对象的地址不同，即是两个对象，所以都是false
	System.out.println("m11 result " + (a == b));
    }

    public void m12() {
	Integer a = new Integer(128);
	Integer b = 128;
	System.out.println("m12 result " + (a == b));
    }

    public void m31() {
	Integer a = 100;
	Integer b = 100;
	// 在【-128，127】之间的数字，valueOf返回的是缓存中的对象，所以两次调用返回的是同一个对象。
	System.out.println("m31 result " + (a == b));
    }

    public void m32() {
	Integer a = 128;
	Integer b = 128;
	System.out.println("m32 result " + (a == b));
    }

    public void m41() {
	Integer a = Integer.valueOf(100);
	Integer b = 100;
	// 只适用了一次valueOf()，但字节码中出现了两次，说明自动装箱时也调用了valueOf()。
	System.out.println("m41 result " + (a == b));
    }

    public void m42() {
	Integer a = Integer.valueOf(128);
	Integer b = 128;
	System.out.println("m42 result " + (a == b));
    }

}
