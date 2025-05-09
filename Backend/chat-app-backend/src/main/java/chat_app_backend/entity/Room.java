package chat_app_backend.entity;

import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.ArrayList;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Document(collection = "room")
public class Room {
    @Id
    private String id;
    private String roomId;

    private List<Messages> messege=new ArrayList<>();

}
