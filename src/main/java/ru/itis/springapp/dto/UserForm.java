package ru.itis.springapp.dto;

import lombok.Builder;
import lombok.Data;
import ru.itis.springapp.models.FileInfo;

@Data
@Builder
public class UserForm {
    private String email;
    private String firstName;
    private String lastName;
    private String password;
    private FileInfo avatar;
}
