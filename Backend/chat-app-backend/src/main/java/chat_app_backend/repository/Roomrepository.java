package chat_app_backend.repository;

import chat_app_backend.entity.Room;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

public interface Roomrepository extends MongoRepository<Room, String> {
    Room findByRoomId(String roomId);
}
