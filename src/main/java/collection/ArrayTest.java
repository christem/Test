package collection;

import java.util.Arrays;
import java.util.List;

import org.apache.commons.lang.StringUtils;

public class ArrayTest {

    public static List<String> getUserAttTeamList(String ret) {
	List<String> list = null;
	if (StringUtils.isNotEmpty(ret)) {
	    if (ret.startsWith(",")) {
		ret = ret.replaceFirst(",", "");
	    }
	    list = Arrays.asList(ret.split(","));
	}
	return list;
    }

    public static void main(String[] args) {
	String test = ",41,43,44,48,49,53,55,1532,1534,";
	List<String> list = getUserAttTeamList(test);
	for (String obj : list) {
	    System.out.println(Integer.parseInt(obj));
	}
    }
}
