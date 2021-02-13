package ru.itis.springapp.dto;

import lombok.Data;

@Data
public class UserForm {
    private String email;
    private String firstName;
    private String lastName;
    private String password;
}
