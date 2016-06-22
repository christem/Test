package auth.c321;

import java.io.IOException;
import java.security.NoSuchAlgorithmException;

import sun.misc.BASE64Decoder;
import sun.misc.BASE64Encoder;

public class Base64Utils {

	// 1.数字摘要

	// BASE64
	public static String byte2base64(byte[] bytes) {
		BASE64Encoder encoder = new BASE64Encoder();
		String content = encoder.encode(bytes);
		System.out.println("BASE64Encoder:" + new String(bytes) + " --> "
				+ content);
		return content;
	}

	public static byte[] base642byte(String content) throws IOException {
		BASE64Decoder decoder = new BASE64Decoder();
		byte[] bytes = decoder.decodeBuffer(content);
		System.out.println("BASE64Decoder:" + content + " --> "
				+ new String(bytes));
		return bytes;
	}

	public static void main(String[] args) throws NoSuchAlgorithmException,
			IOException {
		String test = "test";
		String content = byte2base64(test.getBytes());
		base642byte(content);
	}
}
