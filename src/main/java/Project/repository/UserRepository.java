package Project.repository;

import Project.entity.User;

import java.util.List;
import java.util.Optional;

public class UserRepository implements UserRepositoryInterface{
    @Override
    public void addUser(User user) {

    }

    @Override
    public void removeUser(Long userId) {

    }

    @Override
    public Optional<User> getUserById(Long id) {
        return Optional.empty();
    }

    @Override
    public List<User> getUsersByName(String name) {
        return List.of();
    }

    @Override
    public List<User> getAllUsers() {
        return List.of();
    }

    @Override
    public void updateUser(User updatedUser) {

    }
}
