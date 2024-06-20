package Project.Service;

import Project.entity.Message;
import Project.entity.User;
import Project.repository.MessageRepository;

import java.util.List;
import java.util.Optional;

public class MessageService {
    private final MessageRepository messageRepository;

    public MessageService(MessageRepository messageRepository) {
        this.messageRepository = messageRepository;
    }

    public Message addMessage(Message message) {
        return messageRepository.addMessage(message);
    }

    public boolean removeMessage(Long messageId) {
        return messageRepository.removeMessage(messageId);
    }

    public List<Message> getAllMessages() {
        return messageRepository.getAllMessages();
    }

    public Optional<Message> findMessageById(Long messageId) {
        return messageRepository.findById(messageId);
    }

    public List<Message> findMessagesBySender(User sender) {
        return messageRepository.findBySender(sender);
    }

    public List<Message> findMessagesByReceiver(User receiver) {
        return messageRepository.findByReceiver(receiver);
    }
}
