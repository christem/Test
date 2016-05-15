package demo.base.c15IO.s8;

public class Person implements java.io.Serializable {
	private static final long serialVersionUID = -5258433088587841815L;
	private String name;
	private int age;

	public Person(String name, int age) {
		System.out.println("有参数的构造器");
		this.name = name;
		this.age = age;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getName() {
		return this.name;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public int getAge() {
		return this.age;
	}
}