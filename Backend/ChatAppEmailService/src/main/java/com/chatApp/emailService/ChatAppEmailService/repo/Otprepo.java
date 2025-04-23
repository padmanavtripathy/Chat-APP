package com.chatApp.emailService.ChatAppEmailService.repo;

import com.chatApp.emailService.ChatAppEmailService.entity.OtpModel;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface Otprepo extends MongoRepository<OtpModel, String> {
}
