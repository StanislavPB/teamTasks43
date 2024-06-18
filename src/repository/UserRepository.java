package repository;

import entity.User;

import java.util.List;
import java.util.Optional;

public class UserRepository implements UserInterfaceRepository {

    private List<User> users;
    private Long counter = 0L;

    public UserRepository(List<User> users, Long counter) {
        this.users = users;
        this.counter = counter;
    }

    @Override
    public User addUser(User user) {
        user.setId(++counter);
        users.add(user);
        return user;
    }

    @Override
    public boolean removeUser(User user) {
        return users.remove(user);
    }

    @Override
    public User findByUserName(String userName) {
        for (User user : users) {
            if (user.getName().equals(userName)) ;
            return user;
        }
        return null;
    }

    @Override
    public Optional<User> findByUserId(Integer userId) {
        for (User user : users) {
            if (user.getId().equals(userId)) ;
            return Optional.of(user);
        }
        return Optional.empty();

    }

    @Override
    public List<User> findAllUsers() {
        return users;
    }
}
