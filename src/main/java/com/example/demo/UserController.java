package com.example.demo;

import java.util.ArrayList;
import java.util.List;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/users")
public class UserController {

    private List<User> users = new ArrayList<>();

    @PostMapping
     public User createUser(@RequestBody User user ) {
        user.setId((long) (users.size() + 1) );
        users.add(user);
        return user;
     }

     @GetMapping("/{id}")
        public User getUserById(@PathVariable Long id ) {
           
            for(User user: users) {
                if(user.getId().equals(id)) {
                    return user;
                }  
                
            }
            return null;
        }

        @PutMapping("/{id}")
        public User updateUser(@PathVariable Long id, @RequestBody User updatedUser ) {
            for(User user: users) {
                if(user.getId().equals(id)) {
                    user.setName(updatedUser.getName());
                    user.setEmail(updatedUser.getEmail());
                    return user;
                }
            }
            return null;
        }


        @DeleteMapping("/{id}")
            public String deleteUser(@PathVariable Long id) {
                for(User user: users) {
                    if(user.getId().equals(id)) {
                        users.remove(user);
                        return "User deleted Succsffully";
                    }
                } 
                  
                return "User not found";

             }
             
    
}
