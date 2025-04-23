package com.chatApp.emailService.ChatAppEmailService.entity;
import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDateTime;

@Data
@NoArgsConstructor
@Document(collection = "otpModel")
public class OtpModel {

    private String mobileNo;
    @Id
    private String emailAddress;
    private String Otp;
    private LocalDateTime generationTime;
    private String device;
    private String validity;


    public String getMobileNo() {
        return mobileNo;
    }

    public void setMobileNo(String mobileNo) {
        this.mobileNo = mobileNo;
    }

    public String getEmailAddress() {
        return emailAddress;
    }

    public void setEmailAddress(String emailAddress) {
        this.emailAddress = emailAddress;
    }

    public String getOtp() {
        return Otp;
    }

    public void setOtp(String otp) {
        Otp = otp;
    }

    public LocalDateTime getGenerationTime() {
        return generationTime;
    }

    public void setGenerationTime(LocalDateTime generationTime) {
        this.generationTime = generationTime;
    }

    public String getDevice() {
        return device;
    }

    public void setDevice(String device) {
        this.device = device;
    }

    public String getValidity() {
        return validity;
    }

    public void setValidity(String validity) {
        this.validity = validity;
    }
}