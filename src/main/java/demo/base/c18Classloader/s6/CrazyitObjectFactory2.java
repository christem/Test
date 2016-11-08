package demo.base.c18Classloader.s6;

import java.util.*;

import javax.swing.*;

import com.mysql.fabric.xmlrpc.base.Data;

public class CrazyitObjectFactory2 {
	public static <T> T getInstance(Class<T> cls) {
		try {
			return cls.newInstance();
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}

	public static void main(String[] args) {
		// 获取实例后无须类型转换
		Date d = CrazyitObjectFactory2.getInstance(Date.class);
		JFrame f = CrazyitObjectFactory2.getInstance(JFrame.class);
	}
}
