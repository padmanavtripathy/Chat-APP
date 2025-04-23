package com.user_service.dto;


import com.user_service.entity.ContactDetails;
import com.user_service.utils.UserStatus;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.*;

import java.time.LocalDateTime;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class UserDto {

    @NotBlank(message = "Mobile number is required")
    @Size(min = 10, max = 15, message = "Mobile number must be between 10 and 15 digits")
    private String mobileNumber;

    @NotBlank(message = "Email is required")
    @Email(message = "Invalid email format")
    private String emailId;

    @NotBlank(message = "Name is required")
    private String name;

    private String uid;

    private LocalDateTime createdTime;

    private UserStatus userStatus;

    private List<ContactDetails> contactDetails;
}