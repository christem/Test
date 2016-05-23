package common;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;

/**
 * 权重随机算法在抽奖，资源调度等系统中应用还是比较广泛的，一个简单的按照权重来随机的实现，权重为几个随机对象(分类)的命中的比例，权重设置越高命中越容易，
 * 之和可以不等于100；
 * 
 * @author lifeix
 *
 */
public class WeightRandom {
    static List<WeightCategory> categorys = new ArrayList<WeightCategory>();
    private static Random random = new Random();
    private static Integer weightSum = 0;

    public static void initData() {
	WeightCategory wc1 = new WeightCategory(1, "A", 70);
	WeightCategory wc2 = new WeightCategory(1, "B", 30);
	categorys.add(wc1);
	categorys.add(wc2);
    }

    public static void main(String[] args) {
	initData();

	for (WeightCategory wc : categorys) {
	    weightSum += wc.getWeight();
	}

	if (weightSum <= 0) {
	    System.err.println("Error: weightSum=" + weightSum.toString());
	    return;
	}
	Map<String, Integer> count = new HashMap<String, Integer>();
	for (int i = 0; i < 1000; i++) {
	    test(count);
	}

	System.out.println(count);
    }

    public static void test(Map<String, Integer> count) {
	Integer n = random.nextInt(weightSum);
	Integer m = 0;

	for (WeightCategory wc : categorys) {
	    if (m <= n && n < m + wc.getWeight()) {
		System.out.println(wc.getCategory());
		Integer value = count.get(wc.getCategory());
		count.put(wc.getCategory(), value == null ? 1 : value + 1);
		break;
	    }
	    m += wc.getWeight();

	}

    }

}

class WeightCategory {
    private int key;
    private String category;
    private Integer weight;

    public WeightCategory() {
	super();
    }

    public WeightCategory(int key, String category, Integer weight) {
	super();
	this.setKey(key);
	this.setCategory(category);
	this.setWeight(weight);
    }

    public int getKey() {
	return key;
    }

    public void setKey(int key) {
	this.key = key;
    }

    public Integer getWeight() {
	return weight;
    }

    public void setWeight(Integer weight) {
	this.weight = weight;
    }

    public String getCategory() {
	return category;
    }

    public void setCategory(String category) {
	this.category = category;
    }
}
