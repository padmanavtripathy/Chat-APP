package dto;

import jakarta.validation.Valid;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class AddContactDto {
    @NotBlank(message = "UserId is required")
    private String userId;
    @NotBlank(message = "Contact number is required")
    @Size(min = 10, max = 15, message = "Mobile number must be between 10 and 15 digits")
    private String contactID;
    private List<String> messageId;
}
