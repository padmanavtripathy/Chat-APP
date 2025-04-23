package com.chatApp.emailService.ChatAppEmailService.service;

import com.chatApp.emailService.ChatAppEmailService.entity.OtpModel;

public interface EmailService {
    public String sendOtp(OtpModel otpModel);
}
