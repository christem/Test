package auth.c322;

import java.io.IOException;

import javax.crypto.Cipher;
import javax.crypto.KeyGenerator;
import javax.crypto.SecretKey;
import javax.crypto.spec.SecretKeySpec;

import auth.c321.Base64Utils;

public class KeyGeneratorTest {

	// 2.对称加密
	public static void main(String[] args) throws Exception {

		// 1.获取base64str
		String base64str2 = genKeyAES();
		// 2.获取SecretKey
		SecretKey key2 = loadKeyAES(base64str2);

		// 3.加密
		String test2 = "hello world!";
		byte[] bytes2 = encryptAES(test2.getBytes(), key2);
		// 4.解密
		decryptAES(bytes2, key2);

	}

	// AES算法
	public static String genKeyAES() throws Exception {
		KeyGenerator keyGenerator = KeyGenerator.getInstance("AES");
		keyGenerator.init(128);
		SecretKey key = keyGenerator.generateKey();
		String base64Str = Base64Utils.byte2base64(key.getEncoded());
		System.out.println("1.获取base64str:" + base64Str);
		return base64Str;
	}

	public static SecretKey loadKeyAES(String base64Key) throws IOException {
		byte[] bytes = Base64Utils.base642byte(base64Key);
		SecretKey key = new SecretKeySpec(bytes, "AES");
		System.out.println("2.获取SecretKey:" + key);
		return key;
	}

	// 加密&解密
	public static byte[] encryptAES(byte[] source, SecretKey key)
			throws Exception {
		Cipher cipher = Cipher.getInstance("AES");
		cipher.init(Cipher.ENCRYPT_MODE, key);
		byte[] bytes = cipher.doFinal(source);
		System.out.println("3.加密:" + new String(source) + ", " + key + " --> "
				+ new String(bytes));
		return bytes;
	}

	public static byte[] decryptAES(byte[] source, SecretKey key)
			throws Exception {
		Cipher cipher = Cipher.getInstance("AES");
		cipher.init(Cipher.DECRYPT_MODE, key);
		byte[] bytes = cipher.doFinal(source);
		System.out.println("4.解密:" + new String(source) + ", " + key + " --> "
				+ new String(bytes));
		return bytes;
	}
}
