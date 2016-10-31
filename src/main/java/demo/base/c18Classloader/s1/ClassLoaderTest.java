package demo.base.c18Classloader.s1;

class Tester {
	static {
		System.out.println("Tester类的静态初始化块...");
	}
}

public class ClassLoaderTest {
	public static void main(String[] args) throws ClassNotFoundException {
		ClassLoader cl = ClassLoader.getSystemClassLoader();
		// 下面语句仅仅是加载Tester类
		cl.loadClass("demo.base.c18Classloader.s1.Tester");
		System.out.println("系统加载Tester类");
		// 下面语句才会初始化Tester类
		Class.forName("demo.base.c18Classloader.s1.Tester");
	}
}
