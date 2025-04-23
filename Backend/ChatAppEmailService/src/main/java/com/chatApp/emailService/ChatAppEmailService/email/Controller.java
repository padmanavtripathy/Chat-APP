package com.chatApp.emailService.ChatAppEmailService.email;

import com.chatApp.emailService.ChatAppEmailService.dto.EmailDto;
import com.chatApp.emailService.ChatAppEmailService.service.EmailService;
import com.chatApp.emailService.ChatAppEmailService.utils.AESUtil;
import com.chatApp.emailService.ChatAppEmailService.utils.Constants;
import com.chatApp.emailService.ChatAppEmailService.utils.Helper;
import com.chatApp.emailService.ChatAppEmailService.utils.ObjectMapperUtils;
import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@Data
@RestController
@RequestMapping("/email")
public class Controller {

    @Autowired
    private EmailService emailService;
    @Autowired
    private Constants constants;

        @PostMapping("/sendOtp")
    public ResponseEntity<String> sendOtp(@Validated @RequestBody EmailDto emailDto, BindingResult result) throws Exception {
        if (result.hasErrors()){
            return ResponseEntity.badRequest().body(result.getAllErrors().toString());
        }
        Long otp = Helper.gennarateOtp(constants.OTPLENGTH);
        System.out.println("Otp for user"+otp);
        return ResponseEntity.ok(emailService.sendOtp(ObjectMapperUtils.mapToOtpModel(emailDto, AESUtil.encrypt(otp.toString()), constants.VALIDITY)));

    }

}
