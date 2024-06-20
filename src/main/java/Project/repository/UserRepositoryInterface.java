package Project.repository;
import Project.entity.User;

import java.util.List;
import java.util.Optional;

public interface UserRepositoryInterface {
        User save(User user);
        Optional<User> findByUserId(Long id);
        List<User> findAllUsers();
        User updateUser(User user);
        boolean deleteUser(Long id);
}