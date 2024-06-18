package Project.repository;
import Project.entity.User;

import java.util.List;
import java.util.Optional;

public interface UserRepositoryInterface {
        User save(User user);
        Optional<User> findById(Long id);
        List<User> findAll();
        User update(User user);
        boolean delete(Long id);
}