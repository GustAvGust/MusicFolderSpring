package ru.itis.springapp.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import ru.itis.springapp.models.FileInfo;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class UserForm {
    private String email;
    private String firstName;
    private String lastName;
    private String password;
    private FileInfo avatar;
}
