package com.web;

import java.io.File;
import java.util.Date;

import javax.annotation.Resource;

import org.junit.Test;

import com.hbdl.common.mail.EmailNotifyService;
import com.hbdl.common.mail.EmailVo;
import com.web.base.JUnitServiceBase;


/**
 * 邮件服务测试
 * @author ql
 *
 */
public class MailServiceTest extends JUnitServiceBase{

	@Resource
	EmailNotifyService emailNotifyService;
	
	@Test
	public void sendMail() throws Exception {
		EmailVo emailVo = new EmailVo();
		emailVo.setReceivers(new String[] { "411219762@qq.com" });
		emailVo.setCc(new String[] {});
		emailVo.setBcc(new String[] {});
		emailVo.setSubject("测试");
		emailVo.setSender("qilei321@163.com");
		emailVo.setEmailContent("<html><body><h1>中国人民</h1><h5>测试<font color=red><a href=\"http://www.baidu.com\">百度</a></font>试测试测试测试测试测试测试测试测试测试</h5></body></html>");

		File[] f = new File[] { new File("d:/aaa.jpg"), new File("d:/bbb.jpg") };
//		emailVo.setAttachFile(f);

//		emailNotifyService.sendEmailMessageOfHtmlText(emailVo, new Date());
		emailNotifyService.sendEmailMessageOfAttachedFileAndSimpleText(emailVo, new Date(), true);

	}
}
