package com.hbdl.common.encrypt;

import java.security.Key;
import java.security.SecureRandom;

import javax.crypto.Cipher;
import javax.crypto.SecretKey;
import javax.crypto.SecretKeyFactory;
import javax.crypto.spec.PBEKeySpec;
import javax.crypto.spec.PBEParameterSpec;

import org.bouncycastle.util.encoders.Base64;

import com.hbdl.common.exception.BaseException;


/**
 * 
* @ClassName: PBE 
* @Description: TODO(PBE 对称加密算法) 
* @author ql
* @date 2015年7月3日 下午2:09:30 
*
 */
public class PBE extends Encrypt {
	public static final String ALGORITHM = "PBEWITHMD5andDES";
	/** 迭代次数 */
	public static final int ITERATION_COUNT = 100;

	/**
	 * 盐初始化<br>
	 * 盐长度必须为8字节
	 * @return byte[] 盐
	 */
	public static byte[] initSalt() {
		SecureRandom random = new SecureRandom();
		return random.generateSeed(8);
	}

	/**
	 * 转换密钥
	 * 
	 * @param password
	 *            密码
	 * @return key 密钥
	 * @throws Exception
	 */
	private static Key toKey(String password) throws Exception {
		PBEKeySpec keySpec = new PBEKeySpec(password.toCharArray());
		SecretKeyFactory keyFactory = SecretKeyFactory.getInstance(ALGORITHM);
		SecretKey secretKey = keyFactory.generateSecret(keySpec);
		return secretKey;
	}

	/**
	 * 加密
	 * 
	 * @param data
	 *            数据
	 * @param password
	 *            密码
	 * @param salt
	 *            盐
	 * @return byte[] 加密数据
	 * @throws Exception
	 */
	public static byte[] encrypt(byte[] data, String password, byte[] salt)
			throws Exception {
		Key key = toKey(password);
		PBEParameterSpec parameterSpec = new PBEParameterSpec(salt, ITERATION_COUNT);
		Cipher cipher = Cipher.getInstance(ALGORITHM);
		cipher.init(Cipher.ENCRYPT_MODE, key, parameterSpec);
		return cipher.doFinal(data);
	}

	/**
	 * 解密
	 * 
	 * @param data
	 *            数据
	 * @param password
	 *            密码
	 * @param salt
	 *            盐
	 * @return byte[] 加密数据
	 * @throws Exception
	 */
	public static byte[] decrypt(byte[] data, String password, byte[] salt)
			throws Exception {
		Key key = toKey(password);
		PBEParameterSpec parameterSpec = new PBEParameterSpec(salt, ITERATION_COUNT);
		Cipher cipher = Cipher.getInstance(ALGORITHM);
		cipher.init(Cipher.DECRYPT_MODE, key, parameterSpec);
		return cipher.doFinal(data);
	}
	

	private static byte[] generateSalt(String key){
		return MD5.toMD5(key).substring(0, 8).getBytes();
	}
	
	public static String encryptPBE(String value, String key) {
//		try {
//			return Base64Util.encryptBASE64(encrypt(value.getBytes(), key, generateSalt(key)));
//		} catch (Exception e) {
//			throw new KissoException(e.toString());
//		}
		try {
			return Base64Util.encryptBASE64(encrypt(value.getBytes(), key, generateSalt(key)));
		} catch (Exception e) {
			throw new BaseException(e.toString());
		}
	}
	
	public static String decryptPBE(String value, String key) {
//		try {
//			return new String(decrypt(Base64Util.decryptBASE64(value), key, generateSalt(key)));
//		} catch (Exception e) {
//			throw new KissoException(e.toString());
//		}
		try {
			return new String(decrypt(Base64Util.decryptBASE64(value), key, generateSalt(key)));
		} catch (Exception e) {
			throw new BaseException(e.toString());
		}
	}

	@Override
	public String encrypt(String value, String key) throws Exception {
		return encryptPBE(value, key);
	}

	@Override
	public String decrypt(String value, String key) throws Exception {
		return decryptPBE(value, key);
	}
	
	/**
	 * 测试 PBE 加密算法
	 */
	public static void main(String[] args) throws Exception {
		String str = "kisso";//加密内容
		String password = "iloveu";//加密口令

		System.out.println("原文：" + str);
		System.out.println("密码：" + password);

		byte[] salt = PBE.initSalt();//初始化盐
		System.out.println("盐：" + Base64.encode(salt));
		
		byte[] data = PBE.encrypt(str.getBytes(), password, salt);//加密
		System.out.println("加密后：" + Base64Util.encryptBASE64(data));
		
		data = PBE.decrypt(data, password, salt);//解密
		System.out.println("解密后：" + new String(data));
	}
}
