package com.user_service.entity;

import com.user_service.utils.UserStatus;
import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Document(collection="user")
public class User {

    @Id
    private String mobileNumber;
    @Indexed(unique = true)
    private String emailId;
    private String name;
    @Indexed(unique = true)
    private String uid;
    private LocalDateTime createdTime;
    private UserStatus UserStatus;
    private List<ContactDetails> contactDetails;


    public User(String mobileNumber, String emailId, String name, LocalDateTime createdTime, UserStatus userStatus, List<ContactDetails> contactDetails) {
        this.mobileNumber = mobileNumber;
        this.emailId = emailId;
        this.name = name;
        this.uid = String.valueOf(UUID.randomUUID());
        this.createdTime = (createdTime != null) ? createdTime : LocalDateTime.now();
        UserStatus = userStatus;
        this.contactDetails = contactDetails;
    }
}
