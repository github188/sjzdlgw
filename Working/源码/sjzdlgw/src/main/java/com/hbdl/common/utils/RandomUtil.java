package com.hbdl.common.utils;

import java.util.Random;
import java.util.UUID;

/**
 * 
 * @ClassName: RandomUtil 
 * @Description: TODO(随机数工具类) 
 * @author ql
 * @date 2015年7月3日 下午2:25:36 
 *
 */
public class RandomUtil {

	/**
	 * @Description 生产长度为length的随机字母数字混合字符串
	 * @param length
	 *            指定字符串长度
	 * @return
	 */
	public static String getCharacterAndNumber(int length) {
		String val = "";
		Random random = new Random();
		for (int i = 0; i < length; i++) {
			// 输出字母还是数字
			String charOrNum = random.nextInt(2) % 2 == 0 ? "char" : "num";
			// 字符串
			if ("char".equalsIgnoreCase(charOrNum)) {
				// 取得大写字母还是小写字母
				int choice = random.nextInt(2) % 2 == 0 ? 65 : 97;
				val += (char) (choice + random.nextInt(26));
			}
			// 数字
			else if ("num".equalsIgnoreCase(charOrNum)) {
				val += String.valueOf(random.nextInt(10));
			}
		}
		return val;
	}
	
	/**
	 * 获取去掉"-" UUID
	 * @return
	 */
	public static String get32UUID() {
		return UUID.randomUUID().toString().replace("-", "");
	}

}