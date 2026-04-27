package com.example.demo.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;

public class CreateUserRequest {
        @NotBlank(message = "name is required")
            private String name;

        @NotBlank(message = "email is required")
        @Email(message = "email format is invalid")
            private String email;
        @NotBlank(message = "password is required")
            private String password;
        public CreateUserRequest(String name, String email) {
            this.name = name;
            this.email = email;
}

public String getName() {
    return name;
}
public String getEmail() {
    return email;
}
public void setName(String name) {
    this.name = name;
}
public void setEmail(String email) {
    this.email = email;
}

public String getPassword() {
    return password;
}
public void setPassword(String password) {
    this.password = password;
}

}
