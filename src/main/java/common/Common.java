package common;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Common {

    public static void main(String[] args) {

	// String eL = "(\\d){4}-(\\d){1,2}-(\\d){1,2}";
	// Pattern p = Pattern.compile(eL);
	// Matcher m = p.matcher("dasdfasfa0");
	// boolean dateFlag = m.matches();
	// if (!dateFlag) {
	// System.out.println("格式错误");
	// }
	// System.out.println("格式正确");
	SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd ");
	try {
	    Date date = sdf.parse("2016-06-17 00:00:00");
	    System.out.println(date);
	} catch (ParseException e) {
	    // TODO Auto-generated catch block
	    e.printStackTrace();
	}

	// SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
	// // Calendar cal = Calendar.getInstance();
	// // cal.add(Calendar.DATE, -1);
	// // String date = sdf.format(cal.getTime());
	// //
	// // try {
	// // Date statisticDate = sdf.parse(date);
	// // System.out.println(statisticDate);
	// // } catch (ParseException e) {
	// // // TODO Auto-generated catch block
	// // e.printStackTrace();
	// // }
	//
	// List<String> list = null;
	// if (list != null && list.size() > 50) {
	// System.out.println("111");
	// }
	// System.out.println("222");
    }
}
