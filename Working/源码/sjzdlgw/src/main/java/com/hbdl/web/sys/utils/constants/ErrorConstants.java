package com.hbdl.web.sys.utils.constants;

public interface ErrorConstants {

	/**
	 * 系统繁忙或系统操作错误:SY10001
	 */
	public String SYSTEM_ERROR = "SY10001";

	/**
	 * 添加失败:SY10002
	 */
	public String SYSTEM_ADD_ERROR = "SY10002";

	/**
	 * 结果为空:SY10003
	 */
	public String SYSTEM_NULL = "SY10003";

	/**
	 * 修改失败:SY10004
	 */
	public String SYSTEM_UPDATE_ERROR = "SY10004";

	/**
	 * 修改成功:SY10005
	 */
	public String SYSTEM_UPDATE_SUCCESS = "SY10005";

	/**
	 * 添加成功:SY10006
	 */
	public String SYSTEM_ADD_SUCCESS = "SY10006";

	/**
	 * 操作失败:SY10007
	 */
	public String SYSTEM_OPERATOR_ERROR = "SY10007";
	
	/**
	 * 删除失败:SY10008
	 */
	public String SYSTEM_DELETE_ERROR = "SY10008";
	
	/**
	 * 删除成功:SY10009
	 */
	public String SYSTEM_DELETE_SUCCESS = "SY10009";
	
	/**
	 * 删除失败，数据正在被使用:SY100010
	 */
	public String SYSTEM_USING_ERROR = "SY100010";

	public interface JSONCODE {

		// JSON格式
		public String JSON = "JS2000";

		/**
		 * JSON格式错误:JS20001
		 */
		public String JSON_VALUE_NULL = JSON + "1";

	}

	public interface VALIDATECODE {

		// 校验
		public String VALIDATE = "VA3000";

		/**
		 * 系统校验失败:VA30001
		 */
		public String VALIDATE_ERROR = VALIDATE + "1";

	}

	public interface USERCODE {

		// 用户
		public String USER = "US4000";

		/**
		 * 登录失败,用户名或密码错误:US40001
		 */
		public String USER_LOGIN_FAIL = USER + "1";

		/**
		 * 用户名为空:US40002
		 */
		public String VALIDATE_USERNAME_NULL = USER + "2";

		/**
		 * 密码为空:US40003
		 */
		public String VALIDATE_PASSWORD_NULL = USER + "3";

		/**
		 * 用户名内含有特殊字符:US40004
		 */
		public String VALIDATE_USERNAME_PATTERN = USER + "4";

		/**
		 * 用户名已经存在:US40005
		 */
		public String VALIDATE_USERNAME_EXIST = USER + "5";

		/**
		 * 确认密码为空:US40006
		 */
		public String VALIDATE_REPASSWORD_NULL = USER + "6";

		/**
		 * 您两次输入的账号密码不一致:US40007
		 */
		public String VALIDATE_REPASSWORD_NOT_SAME = USER + "7";

		/**
		 * 邮箱为空:US40008
		 */
		public String VALIDATE_EMAIL_NULL = USER + "8";

		/**
		 * 邮箱格式错误:US40009
		 */
		public String VALIDATE_EMAIL_ERROR = USER + "9";

		/**
		 * 注册失败:US400010
		 */
		public String REGISTER_ERROR = USER + "10";

		/**
		 * 用户ID为空:US400011
		 */
		public String VALIDATE_USERID_NULL = USER + "11";

		/**
		 * 用户不存在:US400012
		 */
		public String VALIDATE_USER_NULL = USER + "12";

		/**
		 * 无效的手机号码:US400013
		 */
		public String VALIDATE_USER_MOBILE_INVALIDATE = USER + "13";

		/**
		 * 手机号已注册:US400014
		 */
		public String VALIDATE_USER_MOBILE_EXISTS = USER + "14";

		/**
		 * 手机号为空:US400015
		 */
		public String VALIDATE_USER_MOBILE_NULL = USER + "15";

		/**
		 * 短信验证码发送失败:US400016
		 */
		public String REGISTER_MOBILE_CODE_SEND_ERROR = USER + "16";

		/**
		 * 无效的短信验证码:US400017
		 */
		public String REGISTER_MOBILE_CODE_INVALIDATE = USER + "17";

		/**
		 * 短信验证码错误:US400018
		 */
		public String REGISTER_MOBILE_CODE_ERROR = USER + "18";

		/**
		 * 短信验证码为空:US400019
		 */
		public String REGISTER_MOBILE_CODE_NULL = USER + "19";

		/**
		 * 类型为空:US400020
		 */
		public String FORGETPWD_VALIDATE_TYPE_NULL = USER + "20";

		/**
		 * 类型值错误:US400021
		 */
		public String FORGETPWD_VALIDATE_TYPE_ERROR = USER + "21";

		/**
		 * 手机号不存在:US400022
		 */
		public String FORGETPWD_VALIDATE_MOBILE_NOT_EXIST = USER + "22";

		/**
		 * 邮箱已存在:US400023
		 */
		public String VALIDATE_EMAIL_EXIST = USER + "23";

		/**
		 * 邮箱不存在:US400024
		 */
		public String VALIDATE_EMAIL_NOT_EXIST = USER + "24";

		/**
		 * 验证码发送失败:US400025
		 */
		public String FORGETPWD_CODE_SEND_ERROR = USER + "25";

		/**
		 * 验证码为空:US400026
		 */
		public String FORGETPWD_CODE_NULL = USER + "26";

		/**
		 * 验证码错误:US400027
		 */
		public String FORGETPWD_CODE_ERROR = USER + "27";

		/**
		 * 修改密码失败:US400028
		 */
		public String UPDATE_PASSWORD_ERROR = USER + "28";

		/**
		 * 邮箱绑定失败:US400029
		 */
		public String USER_EMAIL_BIND_ERROR = USER + "29";

		/**
		 * 邮箱解绑失败:US400030
		 */
		public String USER_EMAIL_UNBIND_ERROR = USER + "30";

		/**
		 * 原密码不能为空:US400031
		 */
		public String USER_OLDPASSWORD_NULL = USER + "31";

		/**
		 *原密码输入错误:US400032
		 */
		public String USER_OLDPASSWORD_ERROR = USER + "32";

		/**
		 * 图片大小为0:US400033
		 */
		public String USER_HEADPHOTO_SIZE_ZERO = USER + "33";

		/**
		 * 图片格式错误:US400034
		 */
		public String USER_HEADPHOTO_TYPE = USER + "34";

		/**
		 * 图片上传失败:US400035
		 */
		public String USER_HEADPHOTO_UPLOAD_ERROR = USER + "35";

		/**
		 * enctype编码错误:US400036
		 */
		public String USER_HEADPHOTO_ENCTYPE_ERROR = USER + "36";

		/**
		 * 昵称为空:US400037
		 */
		public String USER_NICK_NAME_NULL = USER + "37";

		/**
		 * 昵称长度超过20:US400038
		 */
		public String USER_NICK_NAME_LENGHT = USER + "38";

		/**
		 * pushId为空:US400039
		 */
		public String VALIDATE_PUSH_ID_NULL = USER + "39";

		/**
		 * 邮箱已被其他账户绑定:US400040
		 */
		public String VALIDATE_EMAIL_BIND = USER + "40";

		/**
		 * 验证码已过期:US400041
		 */
		public String CODE_TIME_INVALIDE = USER + "41";

		/**
		 * token为空或无效:US400042
		 */
		public String TOKEN_INVALIDE = USER + "42";
		
		/**
		 * 手机号或密码不正确:US400043
		 */
		public String TEL_OR_PASSWORD_ERROR = USER + "43";

		/**
		 * 用户类型与客户端不匹配:US400044
		 */
		public String USERTYPE_MATCH_ERROR = USER + "44";
		
		/**
		 * 请输入正确的手机号码！:US400045
		 */
		public String TEL_IS_WRONG = USER + "45";
		
		/**
		 * 修改密码失败,用户名或密码错误:US400046
		 */
		public String UPDATE_PASSWORD_FAIL =USER + "46";
		
		/**
		 * 登录失败，用户状态不可用:US400047
		 */
		public String LOGIN_ERRORSTATUS =USER + "47";
		
		/**
		 * 用户最后登录IP为空:US400048
		 */
		public String LAST_LOGIN_IP_NULL =USER + "48";
	}

	public interface ADVICECODE {

		public String ADVICECODE = "AD2000";

		/**
		 * 内容为空:AD20001
		 */
		public String CONTENT_NULL = ADVICECODE + "1";

	}

	public interface ACCESSCODE{
		
		public String ACCESSCODE = "AS5000";
		
		/**
		 * ID为空:AS50001
		 */
		public String VALIDATE_ID_NULL = ACCESSCODE+"1";
		
		/**
		 * 标示为空:AS50002
		 */
		public String VALIDATE_SIGN_NULL = ACCESSCODE+"2";
		
		/**
		 * 标示不存在:AS50003
		 */
		public String VALIDATE_SIGN_ERROR = ACCESSCODE+"3";
		
		/**
		 * 接入系统名称为空:AS50004
		 */
		public String VALIDATE_NAME_NULL  = ACCESSCODE+"4";
		
		/**
		 * 接入系统URL为空:AS50005
		 */
		public String VALIDATE_URL_NULL = ACCESSCODE+"5";
		
		/**
		 * 盐值为空:AS50006
		 */
		public String VALDATE_SALT_NULL = ACCESSCODE+"7";
		
		
		
	}

	
	public interface WYCODE {

		public String WYCODE = "WY1000";
		/**
		 * 该房间未关联业主信息 : WY10001
		 */
		public String WY_CHARGE_1 = WYCODE + "1";
	}

}
