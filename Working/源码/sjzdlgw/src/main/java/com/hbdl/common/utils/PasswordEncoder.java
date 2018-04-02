package com.hbdl.common.utils;

public class PasswordEncoder {

	public static String encrypt(String src, Object salt) {
		return encrypt(src, String.valueOf(salt));
	}

	/**
	 * md5密码加密（加密一次）
	* @param src 密码
	* @param salt 账号 不为null，加密2次，为null加密一次
	* @return
	 */
	public static String encrypt(String src, String salt) {
		if(salt != null){
			return EncryptUtils.MD5_HEX(EncryptUtils.MD5_HEX(src) + salt); // 二次加密
		}
		return EncryptUtils.MD5_HEX(src);	// 一次加密
	}

	public static void main(String[] args) {
		System.out.println(encrypt("admin", "admin"));
	}
}
