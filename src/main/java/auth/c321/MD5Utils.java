package auth.c321;

import java.io.IOException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class MD5Utils {

	// 1.数字摘要
	// MD5
	public static byte[] getMD5(String content) throws NoSuchAlgorithmException {
		MessageDigest mdDigest = MessageDigest.getInstance("MD5");
		byte[] bytes = mdDigest.digest(content.getBytes());
		System.out.println("MD5:" + content + " --> " + bytes);
		return bytes;
	}

	public static void main(String[] args) throws NoSuchAlgorithmException,
			IOException {
		String test = "test";
		getMD5(test);
	}
}
