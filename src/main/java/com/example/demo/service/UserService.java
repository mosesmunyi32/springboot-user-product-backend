package com.example.demo.service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;

import com.example.demo.exception.UserNotFoundException;
import org.springframework.stereotype.Service;
import com.example.demo.repository.UserRepository;
import com.example.demo.model.User;


@Service
public class UserService {

    private final UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public User createUser(User user) {
        return userRepository.save(user);
    }

    //get all the users
    public List<User> getAllUsers() {
        return userRepository.findAll();
    }

    public User getUserById(Long id) {
      Optional<User> optionalUser = userRepository.findById(id);
      return optionalUser.orElseThrow(() -> new UserNotFoundException( "User not found with id: "+ id ));}

    public User updateUser(Long id, User updatedUser) {
        Optional<User> optionalUser = userRepository.findById(id);

        if(optionalUser.isPresent()) {
            User existingUser = optionalUser.get();
            existingUser.setName(updatedUser.getName());
            existingUser.setEmail(updatedUser.getEmail());
            return userRepository.save(existingUser);

        }
        return null;
    }

     public String deleteUser(Long id) {
    if(userRepository.existsById(id)) {
        userRepository.deleteById(id);
        return "User deleted Successfully";
    }

    return "User not found";
}

    

    
}
