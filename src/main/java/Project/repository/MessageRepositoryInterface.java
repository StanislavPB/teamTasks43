package Project.repository;


import Project.entity.Message;
import Project.entity.User;

import java.util.List;
import java.util.Optional;
public interface MessageRepositoryInterface {

        public Message addMessage(Message message);

        public boolean removeMessage(Long messageId);

        List<Message> getAllMessages();
        public Optional<Message> findById(Long id);
        List<Message> findBySender(User sender);
        List<Message> findByReceiver(User receiver);


    }
