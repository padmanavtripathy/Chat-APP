package com.chatApp.emailService.ChatAppEmailService.utils;
import org.springframework.stereotype.Component;

@Component
public class Helper {


    public static Long gennarateOtp(int otpLength){
        long otp=0L;
        for (int i=0;i<otpLength;i++){
            long random= (long) ((Math.random() * 9) + 1);
            otp=(otp*10)+random;
        }
        return otp;
    }

}
