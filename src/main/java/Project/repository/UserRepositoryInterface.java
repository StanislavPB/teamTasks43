package Project.repository;

import Project.entity.User;

import java.util.List;
import java.util.Optional;

public interface UserRepositoryInterface {



        void addUser(User user);

        void removeUser(Long userId);

        Optional<User> getUserById(Long id);

        List<User> getUsersByName(String name);

        List<User> getAllUsers();

        void updateUser(User updatedUser);
    }


