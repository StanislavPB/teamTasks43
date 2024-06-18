package service;

import dto.ProjectRequest;
import dto.UserRequest;
import entity.User;
import repository.UserRepository;

public class UserService {
    private UserRepository repository;

    public UserService(UserRepository repository) {
        this.repository = repository;
    }

    public boolean addNewUser(UserRequest userRequest) {
        if (userRequest != null) {
            String name = userRequest.getName();
            Long userId = userRequest.getId();
            String email = userRequest.getEmail();
            String password = userRequest.getPassword();
            User user = new User(12L, "John", "john@gmail.com", "Jonathan23");

            User saveUser = repository.addUser(user);
            return true;
        } else {
            return false;
        }


    }
}
