package com.chatApp.emailService.ChatAppEmailService.utils;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public  class Constants {
    @Value("${app.email.otpLength}")
    public int OTPLENGTH;

    @Value("${app.email.sender}")
    public String SENDER;

    @Value("${app.email.otpSubject}")
    public String OTPSUBJECT;

    @Value("${app.email.emailDetails}")
    public String EMAIL_DETAILS;

    @Value("${app.email.validity}")
    public String VALIDITY;
    
}
