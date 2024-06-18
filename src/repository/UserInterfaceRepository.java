package repository;

import entity.User;

import java.util.List;
import java.util.Optional;

public interface UserInterfaceRepository {

    User addUser(User user);

    boolean removeUser(User user);

    User findByUserName(String userName);

    Optional<User> findByUserId(Integer userId);

    List<User> findAllUsers();


}
