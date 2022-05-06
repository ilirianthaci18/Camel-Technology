package org.ubt.mail.controller;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.ubt.mail.model.EmailDetails;
import org.ubt.mail.service.EmailService;

@RestController
public class EmailController {
    private EmailService emailService;
    private String status;

    public EmailController(EmailService emailService) {
        this.emailService = emailService;
    }

    @PostMapping("/sendMail")
    public String sendMail(@RequestBody EmailDetails emailDetails){
        status=emailService.sendSimpleMail(emailDetails);
        return status;
    }

    @PostMapping("/sendMailWithAttachment")
    public String sendMailAttachment(@RequestBody EmailDetails emailDetails){
        status=emailService.sendMailWithAttachment(emailDetails);
        return status;
    }

    //TODO
    @PostMapping("/templateMail")
    public void sendTemplateMail(@RequestBody EmailDetails emailDetails){
        emailService.sendTemplatedMail(null,null,null,null,null,null);
    }
}
