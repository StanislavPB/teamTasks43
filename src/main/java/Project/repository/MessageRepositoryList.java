package Project.repository;

import Project.entity.Message;
import Project.entity.User;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class MessageRepositoryList implements MessageRepositoryInterface {
    private List<Message> messages;
    private Long counter = 0L;

    public MessageRepositoryList() {
        this.messages = new ArrayList<>();
    }

    @Override
    public Message addMessage(Message message) {
        message.setId(++counter);
        messages.add(message);
        return message;
    }

    @Override
    public boolean removeMessage(Long messageId) {
        Optional<Message> optionalMessage = findById(messageId);
        if (optionalMessage.isPresent()) {
            Message message = optionalMessage.get();
            messages.remove(message);
            return true;
        }
        return false;
    }


    @Override
    public List<Message> getAllMessages() {
        return messages;
    }

    @Override
    public Optional<Message> findById(Long id) {
        return messages.stream()
                .filter(message -> message.getId().equals(id))
                .findFirst();
    }

    @Override
    public List<Message> findBySender(User sender) {
        List<Message> result = new ArrayList<>();
        for (Message message : messages) {
            if (message.getSenderId().equals(sender.getId())) {
                result.add(message);
            }
        }
        return result;
    }

    @Override
    public List<Message> findByReceiver(User receiver) {
        List<Message> result = new ArrayList<>();
        for (Message message : messages) {
            if (message.getReceiverId().equals(receiver.getId())) {
                result.add(message);
            }
        }
        return result;
    }

}
