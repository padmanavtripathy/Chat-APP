package com.user_service.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class EmailDto {
        @NotBlank(message = "Mobile number is required")
        @Size(min = 10, max = 15, message = "Mobile number must be between 10 and 15 digits")
        private String mobileNo;
        @NotBlank(message = "EmailAddress Is Required")
        private String emailAddress;
        private String device;

        public @NotBlank(message = "Mobile number is required") @Size(min = 10, max = 15, message = "Mobile number must be between 10 and 15 digits") String getMobileNo() {
                return mobileNo;
        }

        public void setMobileNo(@NotBlank(message = "Mobile number is required") @Size(min = 10, max = 15, message = "Mobile number must be between 10 and 15 digits") String mobileNo) {
                this.mobileNo = mobileNo;
        }

        public @NotBlank(message = "EmailAddress Is Required") String getEmailAddress() {
                return emailAddress;
        }

        public void setEmailAddress(@NotBlank(message = "EmailAddress Is Required") String emailAddress) {
                this.emailAddress = emailAddress;
        }

        public String getDevice() {
                return device;
        }

        public void setDevice(String device) {
                this.device = device;
        }
}
