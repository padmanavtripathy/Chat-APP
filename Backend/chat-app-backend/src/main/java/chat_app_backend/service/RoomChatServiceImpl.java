package chat_app_backend.service;

import chat_app_backend.entity.MessageRequest;
import chat_app_backend.entity.Messages;
import chat_app_backend.entity.Room;
import chat_app_backend.repository.Roomrepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class RoomChatServiceImpl implements RoomChatService{
    @Autowired
    private Roomrepository roomrepository;

    public ResponseEntity<?> createRoom(String roomId){
        if(roomrepository.findByRoomId(roomId)!= null){
            return ResponseEntity.badRequest().body("Room already exist");

        }
        Room room= new Room();
        room.setRoomId(roomId);
        Room saved=roomrepository.save(room);
        return ResponseEntity.status(HttpStatus.CREATED).body(room);
    }

    public ResponseEntity<?> joinRoom(String roomId){
        Room room=roomrepository.findByRoomId(roomId);
        if (room==null)
        {
            return ResponseEntity.badRequest().body("Room not found on the given roomId");
        }
        return ResponseEntity.ok(room);

    }

    public ResponseEntity<?> getMessages(String roomId,int page,int size){
        Room room=roomrepository.findByRoomId(roomId);
        if(room==null){
            return ResponseEntity.badRequest().build();
        }
        List<Messages> messages = room.getMessege();
        int start=Math.max(0,messages.size()-(page+1)*size);
        int end=Math.min(messages.size(),start+size);
        List<Messages> peginatedMessage = messages.subList(start, end);
        return ResponseEntity.ok(peginatedMessage);
    }

    public Room findByRoomId(String roomId){
        Room room=roomrepository.findByRoomId(roomId);
        return room;
    }
    public Messages addMessage(String roomId,MessageRequest messageRequest){
        Room room = roomrepository.findByRoomId(roomId);
        Messages message = new Messages(messageRequest.getContent(), messageRequest.getSender(), LocalDateTime.now());
        if (room != null) {
            room.getMessege().add(message);
            roomrepository.save(room);
        }
        else {
            throw  new RuntimeException("Room not found Exception");
        }
        return message;
    }
}
