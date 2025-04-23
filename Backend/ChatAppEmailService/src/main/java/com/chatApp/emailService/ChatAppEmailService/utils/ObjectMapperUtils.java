package com.chatApp.emailService.ChatAppEmailService.utils;

import com.chatApp.emailService.ChatAppEmailService.dto.EmailDto;
import com.chatApp.emailService.ChatAppEmailService.entity.OtpModel;
import org.springframework.beans.factory.annotation.Autowired;

import java.time.LocalDateTime;

public class ObjectMapperUtils {

    public static OtpModel mapToOtpModel(EmailDto emailDto,String otp,String validity) {
        OtpModel otpModel=new OtpModel();
        otpModel.setMobileNo(emailDto.getMobileNo());
        otpModel.setEmailAddress(emailDto.getEmailAddress());
        otpModel.setDevice(emailDto.getDevice());
        otpModel.setOtp(otp);
        otpModel.setValidity(validity);
        otpModel.setGenerationTime(LocalDateTime.now());

        return otpModel;
    }
}
