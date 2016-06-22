package auth.c322;

import java.io.IOException;
import java.security.NoSuchAlgorithmException;

import javax.crypto.Cipher;
import javax.crypto.KeyGenerator;
import javax.crypto.SecretKey;
import javax.crypto.spec.SecretKeySpec;

import auth.c321.Base64Utils;

public class DESUtils {

	// 2.对称加密
	// DES -- 生成DES秘钥
	public static String genKeyDES() throws NoSuchAlgorithmException {
		KeyGenerator keyGenerator = KeyGenerator.getInstance("DES");
		keyGenerator.init(56);
		SecretKey key = keyGenerator.generateKey();
		String base64Str = Base64Utils.byte2base64(key.getEncoded());
		System.out.println("1.获取base64str:" + base64Str);
		return base64Str;
	}

	public static SecretKey loadKeyDES(String base64Key) throws IOException {
		byte[] bytes = Base64Utils.base642byte(base64Key);
		SecretKey key = new SecretKeySpec(bytes, "DES");
		System.out.println("2.获取SecretKey:" + key);
		return key;
	}

	// 加密&解密
	public static byte[] encryptDES(byte[] source, SecretKey key)
			throws Exception {
		Cipher cipher = Cipher.getInstance("DES");
		cipher.init(Cipher.ENCRYPT_MODE, key);
		byte[] bytes = cipher.doFinal(source);
		System.out.println("3.加密:" + new String(source) + ", " + key + " --> "
				+ new String(bytes));
		return bytes;
	}

	public static byte[] decryptDES(byte[] source, SecretKey key)
			throws Exception {
		Cipher cipher = Cipher.getInstance("DES");
		cipher.init(Cipher.DECRYPT_MODE, key);
		byte[] bytes = cipher.doFinal(source);
		System.out.println("4.解密:" + new String(source) + ", " + key + " --> "
				+ new String(bytes));
		return bytes;
	}

	public static void main(String[] args) throws Exception {
		// 1.获取base64str
		String base64str = genKeyDES();
		// 2.获取SecretKey
		SecretKey key = loadKeyDES(base64str);

		// 3.加密
		String test = "hello world!";
		byte[] bytes = encryptDES(test.getBytes(), key);
		// 4.解密
		decryptDES(bytes, key);
	}
}
