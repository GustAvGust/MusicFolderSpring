package ru.itis.springapp.services;

import ru.itis.springapp.dto.TeaDto;
import ru.itis.springapp.dto.TeaForm;
import ru.itis.springapp.models.User;

import java.util.List;

public interface TeasService {
    List<TeaDto> getAllTeasByUser(User user, Integer page);
    void addNewTea(TeaForm teaForm);
    Integer getTeaPagesNumberByUser(User user);
}
