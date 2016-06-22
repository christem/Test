package designMode.create.prototype;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;

/**
 * 创建型 --原型模式 Prototype
 * 
 * 原型模式虽然是创建型的模式，但是与工程模式没有关系，从名字即可看出， 该模式的
 * 思想就是将一个对象作为原型，对其进行复制、克隆，产生一个和原对象类似的新对象
 * 
 * 只需要实现Cloneable接口，覆写clone方法
 */
public class Prototype implements Cloneable, Serializable {

    private static final long serialVersionUID = 1L;
    private String string;

    private SerializableObject obj;

    public String getString() {
	return string;
    }

    public void setString(String string) {
	this.string = string;
    }

    public SerializableObject getObj() {
	return obj;
    }

    public void setObj(SerializableObject obj) {
	this.obj = obj;
    }

    /*
     * 浅复制：将一个对象复制后，基本数据类型的变量都会重新创建，而引用类型，指向的还是原对象所指向的。
     * 
     * @see java.lang.Object#clone()
     */
    public Object clone() throws CloneNotSupportedException {
	Prototype proto = (Prototype) super.clone();
	return proto;
    }

    /*
     * 深复制：将一个对象复制后，不论是基本数据类型还有引用类型，都是重新创建的。
     * 
     * 简单来说，就是深复制进行了完全彻底的复制，而浅复制不彻底。
     */
    public Object deepClone() throws IOException, ClassNotFoundException {

	/* 写入当前对象的二进制流 */
	ByteArrayOutputStream bos = new ByteArrayOutputStream();
	ObjectOutputStream oos = new ObjectOutputStream(bos);
	oos.writeObject(this);

	/* 读出二进制流产生的新对象 */
	ByteArrayInputStream bis = new ByteArrayInputStream(bos.toByteArray());
	ObjectInputStream ois = new ObjectInputStream(bis);
	return ois.readObject();
    }

    public static void main(String args[]) {
	Student s1 = new Student();
	s1.setAge(11);
	s1.setName("tom");
	Concat concat1 = new Concat();
	concat1.setPhone("18588455213");
	concat1.setAddress("未知");
	s1.setConcat(concat1);

	Student s3 = new Student();
	s3.setAge(11);
	s3.setName("tom");
	Concat concat2 = new Concat();
	concat2.setPhone("18588455213");
	concat2.setAddress("未知");
	s3.setConcat(concat2);

	Student s2;
	Student s4;
	try {
	    // s2深拷贝s1
	    s2 = (Student) s1.deepClone();
	    s2.getConcat().setPhone("123");
	    // s4浅拷贝s3
	    s4 = (Student) s3.clone();
	    s3.getConcat().setPhone("123");
	    System.out.println(s1.getAge() + " " + s1.getName() + " " + s1.getConcat().getPhone());
	    System.out.println(s2.getAge() + " " + s2.getName() + " " + s2.getConcat().getPhone());
	    System.out.println(s3.getAge() + " " + s3.getName() + " " + s3.getConcat().getPhone());
	    System.out.println(s4.getAge() + " " + s4.getName() + " " + s4.getConcat().getPhone());
	} catch (Exception e) {
	    e.printStackTrace();
	}

    }
}

class SerializableObject implements Serializable {
    private static final long serialVersionUID = 1L;
}

class Concat implements Cloneable, Serializable {

    private static final long serialVersionUID = 3798782139858461107L;
    private String phone;
    private String address;

    public String getPhone() {
	return phone;
    }

    public void setPhone(String phone) {
	this.phone = phone;
    }

    public String getAddress() {
	return address;
    }

    public void setAddress(String address) {
	this.address = address;
    }
}

class Student extends Prototype {
    private static final long serialVersionUID = 1698765029629938507L;
    private String name;
    private int age;

    private Concat concat;

    public String getName() {
	return name;
    }

    public void setName(String name) {
	this.name = name;
    }

    public int getAge() {
	return age;
    }

    public void setAge(int age) {
	this.age = age;
    }

    public Concat getConcat() {
	return concat;
    }

    public void setConcat(Concat concat) {
	this.concat = concat;
    }
}
