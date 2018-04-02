package com.hbdl.common.mail;

import java.io.File;
import java.util.Date;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.FileSystemResource;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;

/**
 * Email发送
 * 
 * @author ql
 *
 */
@Service
public class EmailNotifyServiceImpl implements EmailNotifyService {

	@Autowired
	private JavaMailSender emailTemplate;

	public void setEmailTemplate(JavaMailSender emailTemplate) {
		this.emailTemplate = emailTemplate;
	}

	/**
	 * 发送简单文本Email消息
	 * 
	 * @param emailVo
	 */
	@Override
	public void sendEmailMessageOfSimpleText(EmailVo emailVo, Date date) {
		SimpleMailMessage simpleTextMessage = new SimpleMailMessage();
		simpleTextMessage.setFrom(emailVo.getSender());
		simpleTextMessage.setTo(emailVo.getReceivers());
		if (emailVo.getBcc().length > 0) {
			simpleTextMessage.setBcc(emailVo.getBcc());
		}
		if (emailVo.getCc().length > 0) {
			simpleTextMessage.setCc(emailVo.getCc());
		}
		simpleTextMessage.setText(emailVo.getEmailContent());

		if (null == date) {
			date = new Date();
		}
		simpleTextMessage.setSentDate(date);

		emailTemplate.send(simpleTextMessage);
	}

	/**
	 * 带附件并简单文本格式邮件发送
	 *
	 * @param emailVo
	 */
	@Override
	public void sendEmailMessageOfHtmlText(EmailVo emailVo, Date date) throws MessagingException {
		MimeMessage message = emailTemplate.createMimeMessage();
		MimeMessageHelper helper = new MimeMessageHelper(message);

		helper.setFrom(emailVo.getSender());
		helper.setValidateAddresses(true);
		if (StringUtils.isNotBlank(emailVo.getEmailContent())) {
			helper.setText(emailVo.getEmailContent(), true);
		}
		helper.setSubject(emailVo.getSubject());
		helper.setCc(emailVo.getCc());
		helper.setTo(emailVo.getReceivers());
		helper.setBcc(emailVo.getBcc());
		if (null == date) {
			date = new Date();
		}
		helper.setSentDate(date);

		emailTemplate.send(message);
	}

	/**
	 * 带附件并且html格式邮件发送,HTML格式的消息
	 * 
	 * @param emailVo
	 * @param date
	 */
	@Override
	public void sendEmailMessageOfAttachedFileAndSimpleText(EmailVo emailVo, Date date, boolean isHtmlText)
			throws MessagingException {
		MimeMessage message = emailTemplate.createMimeMessage();
		MimeMessageHelper helper = new MimeMessageHelper(message, true);

		helper.setFrom(emailVo.getSender());
		// helper.setValidateAddresses(true);
		helper.setText(emailVo.getEmailContent(), isHtmlText);
		helper.setSubject(emailVo.getSubject());
		helper.setCc(emailVo.getCc());
		helper.setTo(emailVo.getReceivers());
		helper.setBcc(emailVo.getBcc());
		if (null == date) {
			date = new Date();
		}
		helper.setSentDate(date);

		if (null != emailVo.getAttachFile()) {

			for (File file : emailVo.getAttachFile()) {
				FileSystemResource fileSystemResource = new FileSystemResource(file);
				helper.addAttachment(file.getName(), fileSystemResource);
			}
		}
		emailTemplate.send(message);
	}
}