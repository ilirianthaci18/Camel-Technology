package org.ubt.mail.service;

import com.thoughtworks.xstream.core.util.Fields;
import lombok.SneakyThrows;
import lombok.extern.slf4j.Slf4j;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.io.FileSystemResource;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;
import org.ubt.mail.common.dto.OrderEmailDTO;
import org.ubt.mail.model.EmailDetails;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;
import java.io.File;
import java.lang.reflect.Array;
import java.lang.reflect.Field;
import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.List;
import java.util.Map;

@Slf4j
@Service
public class EmailServiceImpl implements EmailService{
    private JavaMailSender javaMailSender;

    public EmailServiceImpl(JavaMailSender javaMailSender){
        this.javaMailSender=javaMailSender;
    }

    @Value("${spring.mail.username}")
    private String sender;

    @Override
    public String sendSimpleMail(EmailDetails details) {
        try {
            SimpleMailMessage mailMessage = new SimpleMailMessage();

            mailMessage.setFrom(sender);
            mailMessage.setTo(details.getTo());
            mailMessage.setSubject(details.getSubject());
            mailMessage.setText(details.getText());

            javaMailSender.send(mailMessage);
            return "Mail Sent Successfully to "+details.getTo();
        }catch (Exception e){
            e.printStackTrace();
            return "Error while sending mail";
        }
    }

    @Override
    public String sendMailWithAttachment(EmailDetails details) {
        MimeMessage mimeMessage=javaMailSender.createMimeMessage();
        MimeMessageHelper mimeMessageHelper;

        try{
            mimeMessageHelper=new MimeMessageHelper(mimeMessage,true);

            mimeMessageHelper.setFrom(sender);
            mimeMessageHelper.setTo(details.getTo());
            mimeMessageHelper.setSubject(details.getSubject());
            mimeMessageHelper.setText(details.getText());

            FileSystemResource file=new FileSystemResource(new File(details.getAttachment()));

            mimeMessageHelper.addAttachment(file.getFilename(),file);

            javaMailSender.send(mimeMessage);
            return "Mail sent successfully";
        }catch (MessagingException e){
            return "Error while sending mail";
        }
    }

    @Override
    public void sendTemplatedMail(String from, List<String> to, String subject, String templateName, Map<String, Object> templateData, String attachmentName) {

    }

    @SneakyThrows
    @Override
    public void receiveMsgToKafka(Object obj) {
        log.info("Msg been received "+obj);
        ModelMapper modelMapper=new ModelMapper();
        OrderEmailDTO orderEmailDTO=modelMapper.map(obj,OrderEmailDTO.class);
        sendSimpleMail(new EmailDetails(orderEmailDTO.getEmail(),"Thank you for your order",
                "Your order price is :"+orderEmailDTO.getTotalPrice()+" shipped to "+orderEmailDTO.getShip_to()+" with status "+orderEmailDTO.getOrderStatus()+" with date "+ orderEmailDTO.getOrdered()));

    }
}
