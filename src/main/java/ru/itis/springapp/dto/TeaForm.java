package ru.itis.springapp.dto;

import lombok.Builder;
import lombok.Data;
import ru.itis.springapp.models.User;

@Data
@Builder
public class TeaForm {
    private String name;
    private String description;
    private User user;
}
