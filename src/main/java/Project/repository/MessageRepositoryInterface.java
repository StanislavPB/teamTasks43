package Project.repository;

import Project.entity.Message;
import Project.entity.User;

import java.util.List;
import java.util.Optional;

public interface MessageRepositoryInterface {
    Message addMessage(Message message);
    boolean removeMessage(Long messageId);
    List<Message> getAllMessages();
    Optional<Message> findById(Long id);
    List<Message> findBySender(User sender);
    List<Message> findByReceiver(User receiver);
}