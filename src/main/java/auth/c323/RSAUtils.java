package auth.c323;

import java.security.KeyFactory;
import java.security.KeyPair;
import java.security.KeyPairGenerator;
import java.security.PrivateKey;
import java.security.PublicKey;
import java.security.spec.PKCS8EncodedKeySpec;
import java.security.spec.X509EncodedKeySpec;

import javax.crypto.Cipher;

import auth.c321.Base64Utils;

public class RSAUtils {

	/** */
	/**
	 * <p>
	 * 生成密钥对(公钥和私钥)
	 * </p>
	 * 
	 * @return
	 * @throws Exception
	 */
	public static KeyPair genKeyPair() throws Exception {
		KeyPairGenerator keyPairGen = KeyPairGenerator.getInstance("RSA");
		keyPairGen.initialize(1024);
		KeyPair keyPair = keyPairGen.generateKeyPair();
		return keyPair;
	}

	/**
	 * 获取公钥
	 * 
	 * @param keyPair
	 * @return
	 * @throws Exception
	 */
	public static String getPublicKey(KeyPair keyPair) throws Exception {
		PublicKey publicKey = keyPair.getPublic();
		byte[] bytes = publicKey.getEncoded();
		String publicKeyStr = Base64Utils.byte2base64(bytes);
		System.out.println("1.获得的公钥：" + publicKeyStr);
		return publicKeyStr;
	}

	/**
	 * 获取私钥
	 * 
	 * @param keyMap
	 * @return
	 * @throws Exception
	 */
	public static String getPrivateKey(KeyPair keyPair) throws Exception {
		PrivateKey privateKey = keyPair.getPrivate();
		byte[] bytes = privateKey.getEncoded();
		String privateKeyStr = Base64Utils.byte2base64(bytes);
		System.out.println("1.获得的私钥：" + privateKeyStr);
		return privateKeyStr;
	}

	/**
	 * String类型的秘钥转换为PublicKey
	 * 
	 * @param publicKey
	 * @return
	 * @throws Exception
	 */
	public static PublicKey encryptByPublicKey(String publicKey)
			throws Exception {
		byte[] keyBytes = Base64Utils.base642byte(publicKey);
		X509EncodedKeySpec x509KeySpec = new X509EncodedKeySpec(keyBytes);
		KeyFactory keyFactory = KeyFactory.getInstance("RSA");
		PublicKey publicK = keyFactory.generatePublic(x509KeySpec);
		return publicK;
	}

	/**
	 * String类型的秘钥转换为privateKey
	 * 
	 * @param privateKey
	 * @return
	 * @throws Exception
	 */
	public static PrivateKey encryptByPrivateKey(String privateKey)
			throws Exception {
		byte[] keyBytes = Base64Utils.base642byte(privateKey);
		PKCS8EncodedKeySpec pkcs8KeySpec = new PKCS8EncodedKeySpec(keyBytes);
		KeyFactory keyFactory = KeyFactory.getInstance("RSA");
		PrivateKey privateK = keyFactory.generatePrivate(pkcs8KeySpec);
		return privateK;
	}

	/**
	 * 使用公钥加密
	 * 
	 * @param content
	 * @param publicKey
	 * @return
	 * @throws Exception
	 */
	public static byte[] publicKeyEncrypt(byte[] content, PublicKey publicKey)
			throws Exception {
		Cipher cipher = Cipher.getInstance("RSA");
		cipher.init(Cipher.ENCRYPT_MODE, publicKey);
		byte[] bytes = cipher.doFinal(content);
		System.out.println("2.使用公钥加密:" + new String(content) + " --> "
				+ new String(bytes));
		return bytes;
	}

	/**
	 * 使用私钥解密
	 * 
	 * @param content
	 * @param privateKey
	 * @return
	 * @throws Exception
	 */
	public static byte[] privateKeyDecrypt(byte[] content, PrivateKey privateKey)
			throws Exception {
		Cipher cipher = Cipher.getInstance("RSA");
		cipher.init(Cipher.DECRYPT_MODE, privateKey);
		byte[] bytes = cipher.doFinal(content);
		System.out.println("3.使用私钥解密:" + new String(content) + " --> "
				+ new String(bytes));
		return bytes;
	}

	/**
	 * 使用公钥解密
	 * 
	 * @param content
	 * @param publicKey
	 * @return
	 * @throws Exception
	 */
	public static byte[] publicKeyDecrypt(byte[] content, PublicKey publicKey)
			throws Exception {
		Cipher cipher = Cipher.getInstance("RSA");
		cipher.init(Cipher.DECRYPT_MODE, publicKey);
		byte[] bytes = cipher.doFinal(content);
		System.out.println("5.使用公钥解密:" + new String(content) + " --> "
				+ new String(bytes));
		return bytes;
	}

	/**
	 * 使用私钥加密
	 * 
	 * @param content
	 * @param privateKey
	 * @return
	 * @throws Exception
	 */
	public static byte[] privateKeyEncrypt(byte[] content, PrivateKey privateKey)
			throws Exception {
		Cipher cipher = Cipher.getInstance("RSA");
		cipher.init(Cipher.ENCRYPT_MODE, privateKey);
		byte[] bytes = cipher.doFinal(content);
		System.out.println("4.使用私钥加密:" + new String(content) + " --> "
				+ new String(bytes));
		return bytes;
	}

	public static void main(String[] args) throws Exception {

		// 1.生成密钥对(公钥和私钥)
		KeyPair keyPair = genKeyPair();
		String publicKeyStr = getPublicKey(keyPair);
		String privateKeyStr = getPrivateKey(keyPair);
		PublicKey publicKey = encryptByPublicKey(publicKeyStr);
		PrivateKey privateKey = encryptByPrivateKey(privateKeyStr);

		String test = "hello world!";
		// byte[] mess = publicKeyEncrypt(test.getBytes(), publicKey);
		// privateKeyDecrypt(mess, privateKey);

		byte[] mess2 = privateKeyEncrypt(test.getBytes(), privateKey);
		publicKeyDecrypt(mess2, publicKey);
	}
}
