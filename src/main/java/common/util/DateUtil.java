package common.util;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class DateUtil {

    public static Date LongToDate(Long longtime) {
	Date date = null;
	try {
	    // 时间戳转化为Sting或Date
	    SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
	    Long time = new Long(longtime);
	    String d = format.format(time);

	    date = format.parse(d);

	    System.out.println("Format To String(Date):" + d);
	    System.out.println("Format To Date:" + date);
	} catch (ParseException e) {
	    e.printStackTrace();
	}
	return date;
    }

    public static void main(String args[]) {
	LongToDate(1464033600000L);
    }
}
