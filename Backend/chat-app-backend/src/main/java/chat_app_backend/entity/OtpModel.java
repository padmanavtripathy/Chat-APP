package chat_app_backend.entity;

import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@Getter
@Setter
@NoArgsConstructor
@Document(collection = "otpModel")
public class OtpModel {
    @Id
    private String id;
    @Indexed(unique = true)
    private String mobileNo;
    private String Otp;
}
