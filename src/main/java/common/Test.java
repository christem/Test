package common;

import java.util.HashMap;
import java.util.Map;

import org.json.JSONObject;

public class Test {

    public static void main(String[] args) {
	// List<Double> list = new ArrayList<Double>();
	// list.add(20D);
	// list.add(50D);
	// list.add(100D);
	// list.add(500D);
	// Double double1 = 20D;
	// System.out.println(list.indexOf(double1));
	try {
	    int type = 10;
	    Map<String, Integer> map = null;
	    JSONObject contestCount = null;
	    if (false) {
		map = new HashMap<String, Integer>();
		map.put("0", 0);
		map.put("1", 0);
		map.put("10", 0);
		contestCount = new JSONObject(map);
	    } else {
		contestCount = new JSONObject("{\"1\":1,\"10\":0,\"0\":0}");
	    }
	    int nums = contestCount.getInt(String.valueOf(type));
	    contestCount.put(String.valueOf(type), ++nums);

	    System.out.println(contestCount);
	} catch (Exception e) {
	    // TODO Auto-generated catch block
	    e.printStackTrace();
	}

    }
}
