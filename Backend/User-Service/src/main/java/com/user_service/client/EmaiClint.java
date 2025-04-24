package com.user_service.client;

import com.user_service.dto.EmailDto;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@Service
@FeignClient(name = "email-service")
public interface EmaiClint {
    @PostMapping("/sendOtp")
    public ResponseEntity<String> sendOtp(@RequestBody EmailDto emailDto);
    }
