package com.chatApp.emailService.ChatAppEmailService.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class UserLogin {

    private String sender;
    private String receiver;
    private String Otp;
    private String subject;
}
