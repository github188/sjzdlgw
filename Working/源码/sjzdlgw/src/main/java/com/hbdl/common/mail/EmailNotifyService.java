package com.hbdl.common.mail;

import java.util.Date;

import javax.mail.MessagingException;

/**
 * Email通知消息发送
 * @author ql
 *
 */
public interface EmailNotifyService {
	/**
	 * 发送简单文本Email消息
	 * 
	 * @param emailVo
	 */
	public void sendEmailMessageOfSimpleText(EmailVo emailVo, Date date);

	/**
	 * 发送HTML格式的消息
	 * 
	 * @param emailVo
	 * @param date
	 */
	public void sendEmailMessageOfHtmlText(EmailVo emailVo, Date date)
			throws MessagingException;

	/**
	 * 带附件并且html格式邮件发送,带附件并简单文本格式邮件发送
	 * @param emailVo		邮件对象
	 * @param date			日期
	 * @param isHtmlText	
	 * @throws MessagingException
	 */
	public void sendEmailMessageOfAttachedFileAndSimpleText(EmailVo emailVo,
			Date date, boolean isHtmlText) throws MessagingException;

}