package com.hbdl.common.encrypt;

/**
 * @ClassName: Encrypt
 * @Description: TODO(SSO 对称加密父类)
 * @author ql
 * @date 2015年7月3日 下午2:08:37
 *
 */
public abstract class Encrypt {

	/**
	 * 字符串内容加密
	 * <p>
	 * @param value 加密内容
	 * @param key 密钥
	 * @return
	 * @throws Exception
	 */
	public abstract String encrypt(String value, String key) throws Exception;

	/**
	 * 字符串内容解密
	 * <p>
	 * @param value 解密内容
	 * @param key 密钥
	 * @return
	 * @throws Exception
	 */
	public abstract String decrypt(String value, String key) throws Exception;
}
