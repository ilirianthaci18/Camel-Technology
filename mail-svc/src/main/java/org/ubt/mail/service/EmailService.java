package org.ubt.mail.service;

import org.ubt.mail.model.EmailDetails;

import java.util.List;
import java.util.Map;

public interface EmailService {
    String sendSimpleMail(EmailDetails details);
    String sendMailWithAttachment(EmailDetails details);
    void sendTemplatedMail(String from, List<String> to, String subject, String templateName, Map<String , Object> templateData,
                           String attachmentName);

    void receiveMsgToKafka(Object obj);
}
