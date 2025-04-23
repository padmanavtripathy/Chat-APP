package chat_app_backend.entity;

import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDateTime;
@Data
@Getter
@Setter
@NoArgsConstructor
@Document(collection = "message")
public class Messages {

    @Id
    private String messageId;
    private String content;
    private String sender;
    private LocalDateTime timestamp;

    public Messages(String sender, String content, LocalDateTime timestamp) {
        this.sender = sender;
        this.content = content;
        this.timestamp = LocalDateTime.now();
    }
}
