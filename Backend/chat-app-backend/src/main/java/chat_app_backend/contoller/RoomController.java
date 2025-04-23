package chat_app_backend.contoller;

import chat_app_backend.entity.Messages;
import chat_app_backend.entity.Room;
import chat_app_backend.service.RoomChatService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/v1/rooms")
@CrossOrigin("http://localhost:3000")
public class RoomController {

    @Autowired
    private RoomChatService roomChatService;

    @PostMapping
    public ResponseEntity<?> createRoom(@RequestBody String roomId){
        return roomChatService.createRoom(roomId);
    }

    @GetMapping("/{roomId}")
    public ResponseEntity<?> joinRoom(@PathVariable String roomId){
        return roomChatService.joinRoom(roomId);
    }

    @GetMapping("/{roomId}/messages")
    public ResponseEntity<?> getMessages(
            @PathVariable String roomId,
            @RequestParam(value = "page", defaultValue = "0",required = false) int page,
            @RequestParam(value = "size",defaultValue = "20",required = false) int size){
        return roomChatService.getMessages(roomId,page,size);
    }

}
