package com.dqcer.vote;

import com.dqcer.vote.service.MailService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.thymeleaf.TemplateEngine;
import org.thymeleaf.context.Context;

import javax.mail.MessagingException;

@RunWith(SpringRunner.class)
@SpringBootTest
public class VoteApplicationTests {

	@Test
	public void contextLoads() {
	}

	@Autowired
	private MailService mailService;

	@Autowired
	private TemplateEngine templateEngine;

	@Test
	public void testSimpleMail() throws Exception {
		mailService.sendSimpleMail("916466357@qq.com","test simple mail"," hello this is simple mail");
	}

	@Test
	public void testHtmlMail() throws Exception {
		String content="<html>\n" +
				"<body>\n" +
				"    <h3>hello world ! 这是一封html邮件!</h3>\n" +
				"</body>\n" +
				"</html>";
		mailService.sendHtmlMail("916466357@qq.com","test simple mail",content);
	}

	@Test
	public void sendAttachmentsMail() {
		String filePath="e:\\tmp\\application.log";
		mailService.sendAttachmentsMail("ityouknow@126.com", "主题：带附件的邮件", "有附件，请查收！", filePath);
	}


	@Test
	public void sendInlineResourceMail() {
		String rscId = "neo006";
		String content="<html><body>这是有图片的邮件：<img src=\'cid:" + rscId + "\' ></body></html>";
		String imgPath = "C:\\Users\\summer\\Pictures\\favicon.png";

		mailService.sendInlineResourceMail("ityouknow@126.com", "主题：这是有图片的邮件", content, imgPath, rscId);
	}


	/**
	 * @Author: dongQin
	 * @Date: 2019/1/7 17:58
	 * @Description:使用ftl模板格式发送邮件
	 * @Param: []
	 * @return: void
	 */
	@Test
	public void sendTemplateMail() throws MessagingException {
		//创建邮件正文
		Context context = new Context();
		context.setVariable("id", "006");
		String emailContent = templateEngine.process("emailTemplate", context);

		mailService.sendHtmlMail("916466357@qq.com","主题：这是模板邮件",emailContent);
	}

}

