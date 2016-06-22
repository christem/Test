package auth.c321;

import java.io.IOException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class SHA1Utils {

	// 1.数字摘要

	// SHA1
	public static byte[] getSHA1(String content)
			throws NoSuchAlgorithmException {
		MessageDigest mdDigest = MessageDigest.getInstance("SHA-1");
		byte[] bytes = mdDigest.digest(content.getBytes());
		System.out.println("SHA1:" + content + " --> " + bytes);
		return bytes;
	}

	public static void main(String[] args) throws NoSuchAlgorithmException,
			IOException {
		String test = "test";

		getSHA1(test);
	}
}
