package com.chatApp.emailService.ChatAppEmailService.service;

import com.chatApp.emailService.ChatAppEmailService.entity.OtpModel;
import com.chatApp.emailService.ChatAppEmailService.repo.Otprepo;
import com.chatApp.emailService.ChatAppEmailService.utils.AESUtil;
import com.chatApp.emailService.ChatAppEmailService.utils.Constants;
import jakarta.mail.MessagingException;
import jakarta.mail.internet.MimeMessage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;
import org.thymeleaf.TemplateEngine;
import org.thymeleaf.context.Context;

import java.util.HashMap;
import java.util.Map;

@Service
public class EmailServiceImpl implements EmailService{
    @Autowired
    private Otprepo otprepo;

    @Autowired
    private JavaMailSender javaMailSender;
    @Autowired
    private TemplateEngine templateEngine;

    @Autowired
    private Constants constants;

    @Override
    public String sendOtp(OtpModel otpModel) {
        MimeMessage message = javaMailSender.createMimeMessage();
        try{
            MimeMessageHelper helper=new MimeMessageHelper(message,true);
            Map<String, Object> templateModel = new HashMap<>();
            templateModel.put(constants.EMAIL_DETAILS, AESUtil.decrypt(otpModel.getOtp()));
            System.out.println("personalHtmlContent"+templateModel);
            Context context = new Context();
            helper.setFrom(String.valueOf(constants.SENDER));
            helper.setTo(otpModel.getEmailAddress());
            helper.setSubject(String.valueOf(constants.OTPSUBJECT));
            context.setVariables(templateModel);
            String personalHtmlContent = templateEngine.process("otpTemplate", context);
            System.out.println(personalHtmlContent);
            helper.setText(personalHtmlContent,true);
            javaMailSender.send(message);
            System.out.println("Otp sent to : "+otpModel.getEmailAddress());
            otprepo.save(otpModel);
            return "Otp Sent to the User";
        } catch (Exception e) {
            return e.getMessage();
        }
    }
}
