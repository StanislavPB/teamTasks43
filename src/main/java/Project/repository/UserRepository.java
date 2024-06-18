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
        if(user.getId() != null){
            for(User u:users){
                if(u.getId().equals(user.getId())){
                    throw new IllegalArgumentException("Идентификатор пользователя уже существует");
                }
            }
        }else {
            user.setId(idCounter++);
        }
        for(User u:users){
            if(u.getEmail().equals(user.getEmail())){
                throw new IllegalArgumentException("Email уже используеться");
            }
        }
        if (user.getRole()==null){
            user.setRole(User.Role.USER);
        }
        users.add(user);
        return user;
    }

    @Override
    public Optional<User> findById(Long id) {
        return users.stream()
                .filter(user->user.getId().equals(id))
                .findFirst();
    }

    @Override
    public List<User> findAll() {
        return users.stream().collect(Collectors.toList());
    }

    @Override
    public User update(User user) {
       Optional<User> existingUser = findById(user.getId());
       if(existingUser.isPresent()){
           users.remove(existingUser.get());
           users.add(user);
           return user;
       }else{
           throw new IllegalArgumentException("Пользователь не найден");
       }
    }

    @Override
    public boolean delete(Long id) {
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
    }

