package com.hbdl.web.sys.utils;

public class ValidateUtil {

	/**
	 * 邮箱校验
	 * 
	 * @param email
	 * @return
	 */
	public static boolean isEmailAddress(String email) {
		if (email == null) {
			return false;
		}
		String regex = "[a-zA-Z0-9\\+\\.\\_\\%\\-\\+]{1,256}" + "\\@"
				+ "[a-zA-Z0-9][a-zA-Z0-9\\-]{0,64}" + "(" + "\\."
				+ "[a-zA-Z0-9][a-zA-Z0-9\\-]{0,25}" + ")+";

		return email.matches(regex);
	}

	public static void main(String[] args) {
		System.out.println(isEmailAddress("4169@qq.com"));
	}
}
