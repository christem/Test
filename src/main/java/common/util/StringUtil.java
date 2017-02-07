/**   
 * @Project: SJDKSer 
 * @Title: StringUtil.java 
 * @Package com.yanxintec.sjdk.util 
 * @Description: TODO 
 * @author suny 
 * @date 2016年11月10日 下午2:34:43 
 * @Copyright: 2016 年 研信科技. All rights reserved  
 * @version V1.0   
 */
package common.util;

import org.apache.commons.lang.StringUtils;

/** 
 * @ClassName StringUtil  
 * @Description TODO 
 * @author suny 
 * @date 2016年11月10日  
 *   
 */
public class StringUtil {
	/**
     * 字符串分隔符
     */
    public static final String SEPARATOR = String.valueOf((char) 29);

    /**
     * 判断字符串是否为空
     */
    public static boolean hasValue(String str) {
        return !noValue(str);
    }
    
    /**
     * 判断字符串是否为空或者为null字符串
     */
    public static boolean noValue(String str) {
        if (str != null) {
            str = str.trim();
        }
        return StringUtils.isEmpty(str)||"null".equals(str);
    }
    
    /**
     * 判断字符串是否为空
     */
    public static boolean isEmpty(String str) {
        if (str != null) {
            str = str.trim();
        }
        return StringUtils.isEmpty(str);
    }

    /**
     * 判断字符串是否非空
     */
    public static boolean isNotEmpty(String str) {
        return !isEmpty(str);
    }

    /**
     * 分割固定格式的字符串
     */
    public static String[] splitString(String str, String separator) {
        return StringUtils.splitByWholeSeparator(str, separator);
    }
}
