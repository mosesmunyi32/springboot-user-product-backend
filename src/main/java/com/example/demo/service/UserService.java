package com.example.demo.service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;

import com.example.demo.dto.CreateProductRequest;
import com.example.demo.dto.CreateUserRequest;
import com.example.demo.dto.UserResponse;
import com.example.demo.exception.UserNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import com.example.demo.repository.UserRepository;
import com.example.demo.model.User;


@Service
public class UserService {

    private final UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public User createUser(CreateUserRequest requestUser) {

        User user = new User();
        user.setName(requestUser.getName());
        user.setEmail(requestUser.getEmail());
        user.setPassword(requestUser.getPassword());
       return userRepository.save(user);
    }

    //get all the users
    public List<User>  getAllUsers() {

       return userRepository.findAll();
    }

    public UserResponse getUserById(Long id) {
      User user = userRepository.findById(id).orElseThrow(() -> new UserNotFoundException("User not found with id: "+ id) );

      return toUserResponse(user);


    }



    public UserResponse updateUser(Long id, CreateUserRequest updatedUser) {
        User existingUSer = userRepository.findById(id).orElseThrow(() -> new UserNotFoundException("User not found with Id: "+ id));

        existingUSer.setName(updatedUser.getName());
        existingUSer.setEmail(updatedUser.getEmail());
        existingUSer.setPassword(updatedUser.getPassword());

        User saved = userRepository.save(existingUSer);
        return toUserResponse(saved);


    }


    public String deleteUser(Long id) {
    if(userRepository.existsById(id)) {
        userRepository.deleteById(id);
        return "User deleted Successfully";
    }

    return "User not found";
}

public UserResponse toUserResponse(User user) {
        return new UserResponse(user.getName(), user.getEmail());

}

    

    
}
