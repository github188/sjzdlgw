package com.hbdl.common.encrypt;

import com.hbdl.common.utils.RandomUtil;


/**
 * sso 密钥生成类
 * @ClassName: SecretKey 
 * @author ql
 * @date 2015年7月3日 下午2:10:55 
 *
 */
public class SecretKey {

	/**
	 * 生成 18 位随机字符串密钥
	 * <p>
	 * 替换配置文件 sso.properties 属性 sso.secretkey=随机18位字符串
	 */
	public static String ssoSecretKey() {
		return RandomUtil.getCharacterAndNumber(18);
	}


	public static void main( String[] args ) {
		System.out.println(ssoSecretKey());
	}
}
