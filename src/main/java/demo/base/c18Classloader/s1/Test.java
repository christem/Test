package demo.base.c18Classloader.s1;

public class Test {
	static {
		// 使用静态初始化块为变量b指定出初始值
		b = 6;
		System.out.println("----------");
	}
	// 声明变量a时指定初始值
	static int a = 5;
	static int b = 9; // ①
	static int c;
	static {
		// 使用静态初始化块为变量b指定出初始值
		a = 7;
		System.out.println("----------");
	}
	public static void main(String[] args) {
		System.out.println(Test.b);
		System.out.println(Test.a);
	}
}
