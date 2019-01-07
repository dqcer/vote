package com.dqcer.vote.service;

import javax.mail.MessagingException;

/**
 * @Author: dongQin
 * @Date: 2019/1/7 17:38
 * @Description: 邮件接口
 */

public interface MailService {

    void sendMessageMail(Object params, String title, String templateName);

     void sendSimpleMail(String to, String subject, String content);

     void sendHtmlMail(String to, String subject, String content) throws MessagingException;

     void sendAttachmentsMail(String to, String subject, String content, String filePath);

     void sendInlineResourceMail(String to, String subject, String content, String rscPath, String rscId);
}
