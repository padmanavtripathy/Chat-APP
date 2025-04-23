package chat_app_backend.contoller;

import chat_app_backend.entity.MessageRequest;
import chat_app_backend.entity.Messages;
import chat_app_backend.service.RoomChatService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.handler.annotation.DestinationVariable;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;

@Controller
@CrossOrigin("http://localhost:5173")
public class ChatController {
    @Autowired
    private RoomChatService roomChatService;

    @MessageMapping("/sendMessage/{roomId}") //send message on app/sendMessage/roomId
    @SendTo("/topic/room/{roomId}")//subscribe/first hand shake
    public Messages sendMesssage(
            @DestinationVariable String roomId,
             @RequestBody MessageRequest messageRequest
    ){
            return roomChatService.addMessage(roomId,messageRequest);
    }
}
