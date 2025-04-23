package chat_app_backend.service;

import chat_app_backend.entity.MessageRequest;
import chat_app_backend.entity.Messages;
import chat_app_backend.entity.Room;
import org.springframework.http.ResponseEntity;

public interface RoomChatService{
    ResponseEntity<?> createRoom(String roomId);
    ResponseEntity<?> joinRoom(String roomId);
    ResponseEntity<?> getMessages(String roomId,int page,int size);
    Room findByRoomId(String roomId);
    Messages addMessage(String roomId, MessageRequest messageRequest);
}
