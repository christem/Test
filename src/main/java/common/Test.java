package common;

import java.util.HashMap;
import java.util.Map;

public class Test {

    public static void main(String[] args) {
	// List<Double> list = new ArrayList<Double>();
	// list.add(20D);
	// list.add(50D);
	// list.add(100D);
	// list.add(500D);
	// Double double1 = 20D;
	// System.out.println(list.indexOf(double1));
	// try {
	// int type = 10;
	// Map<String, Integer> map = null;
	// JSONObject contestCount = null;
	// if (false) {
	// map = new HashMap<String, Integer>();
	// map.put("0", 0);
	// map.put("1", 0);
	// map.put("10", 0);
	// contestCount = new JSONObject(map);
	// } else {
	// contestCount = new JSONObject("{\"1\":1,\"10\":0,\"0\":0}");
	// }
	// int nums = contestCount.getInt(String.valueOf(type));
	// contestCount.put(String.valueOf(type), ++nums);
	//
	// System.out.println(contestCount);
	// } catch (Exception e) {
	// // TODO Auto-generated catch block
	// e.printStackTrace();
	// }

	// try {
	// // String str = "{\"1\":1,\"10\":0,\"0\":0}";
	// String str = "";
	// int type = 0;
	// JSONObject contestCount = null;
	// if (StringUtils.isEmpty(str)) {
	// contestCount = new JSONObject();
	// contestCount.put("0", 0);
	// contestCount.put("1", 0);
	// contestCount.put("10", 0);
	// } else {
	// contestCount = new JSONObject(str);
	// }
	//
	// // 取上次结算统计下注值
	// int nums = 0;
	// nums = contestCount.getInt(String.valueOf(type));
	// contestCount.put(String.valueOf(type), ++nums);
	// System.out.println(contestCount);
	// } catch (Exception e) {
	// e.printStackTrace();
	// }
	// String regex = "http(s)?://([\\w-]+\\.)+[\\w-]+(/[\\w- ./?%&=]*)?";
	// Pattern p = Pattern.compile(regex, Pattern.CASE_INSENSITIVE);
	// Matcher m = p.matcher("http://1.html");
	//
	// if (m.find()) {
	// System.out.println(m.group());
	// }

	// lifeixfunc();

	// String test = "{\"1\":1,\"10\":0,\"0\":0}";
	// System.out.println(test.getBytes().length);
	// testMap();

    }

    public static void testMap() {
	Map<Long, Student> map = new HashMap<Long, Student>();
	long t1 = System.currentTimeMillis();
	for (long i = 0; i < 120; i++) {
	    map.put(i, new Student((int) i, "A" + i, i + ""));
	}
	Student student = map.get(60);
	System.out.println("2消耗时间：" + (System.currentTimeMillis() - t1));
    }

    public static void lifeixfunc() {
	// List<Student> listDB = new ArrayList<Student>();
	// listDB.add(new Student(1, "A", "1"));
	// listDB.add(new Student(2, "B", "2"));
	// listDB.add(new Student(3, "C", "3"));
	//
	// List<Student> list = new ArrayList<Student>();
	// list.add(new Student(1, "A", "1"));
	// list.add(new Student(8, "A", "1"));
	// list.add(new Student(2, "B", "2"));
	// list.add(new Student(9, "B", "1"));
	// list.add(new Student(10, "C", "1"));
	// list.add(new Student(3, "C", "3"));
	// list.add(new Student(4, "D", "4"));
	// list.add(new Student(5, "E", "5"));
	// list.add(new Student(6, "F", "6"));
	// list.add(new Student(7, "G", "7"));
	//
	// // 1.取list中用户建立一个hashset
	// HashSet<String> set = new HashSet<String>();
	//
	// for (Student s : list) {
	// set.add(s.getName());
	// }
	// System.out.println(set.toString());
	//
	// // 2.查询所有用户记录listDB（MyBatis）
	//
	// // 3.redis hash(update) 将2中所有记录插入 ：key为用户id value为记录值
	// Map<String, Student> map = new HashMap<String, Student>();
	// for (Student s : listDB) {
	// map.put(s.getName(), s);
	// }
	//
	// // 4.遍历list 更新hash值
	// String flag = "update";
	// String status = "exits";
	// // Student s = 查redis hash(update)
	//
	// if (s == null) {
	// flag="insert";
	// s = 查redis hash(insert);
	//
	// if (s == null) {
	// status ="not exits";
	// s = new Student();
	// }
	// }
	//
	// //处理业务逻辑
	//
	// if (flag == "update") {
	// 更新 redis hash(update);
	// } else if (flag == "insert") {
	// hset redis hash(insert);
	// }

	// 5.批量插入与更新
    }
}

class Student {
    private int age;
    private String name;
    private String phone;

    public Student() {
    }

    public Student(int age, String name, String phone) {
	super();
	this.age = age;
	this.name = name;
	this.phone = phone;
    }

    public int getAge() {
	return age;
    }

    public void setAge(int age) {
	this.age = age;
    }

    public String getName() {
	return name;
    }

    public void setName(String name) {
	this.name = name;
    }

    public String getPhone() {
	return phone;
    }

    public void setPhone(String phone) {
	this.phone = phone;
    }

}