package Project.repository;

import Project.entity.User;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

public class UserRepository implements UserRepositoryInterface{
    private final List<User> users= new ArrayList<>();
    private long idCounter = 1L;

    @Override
    public User save(User user) {
        if (user.getId() == null) {
            user.setId(idCounter++);
        }
        users.add(user);
        return user;
    }

    @Override
    public Optional<User> findByUserId(Long id) {
        return users.stream()
                .filter(user->user.getId().equals(id))
                .findFirst();
    }

    @Override
    public List<User> findAllUsers() {
        return users.stream().collect(Collectors.toList());
    }

    @Override
    public User updateUser(User user) {
       Optional<User> existingUser = findByUserId(user.getId());
       if(existingUser.isPresent()){
           users.remove(existingUser.get());
           users.add(user);
           return user;
       }else{
           throw new IllegalArgumentException("Пользователь не найден");
       }
    }

    @Override
    public boolean deleteUser(Long id) {
        Optional<User> userToDelete = users.stream()
                .filter(user->user.getId().equals(id))
                .findFirst();
        if(userToDelete.isPresent()) {
            users.remove(userToDelete.get());
            return true;
        }else{
                return false;
            }
        }
    public Optional<User> findByEmail(String email) {
        return users.stream()
                .filter(user -> user.getEmail().equals(email))
                .findFirst();
    }

    public List<User> findByRole(User.Role role) {
        return users.stream()
                .filter(user -> user.getRole() == role)
                .collect(Collectors.toList());
    }
}

