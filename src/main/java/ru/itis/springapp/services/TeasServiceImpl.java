package ru.itis.springapp.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Component;
import ru.itis.springapp.dto.TeaDto;
import ru.itis.springapp.dto.TeaForm;
import ru.itis.springapp.models.Tea;
import ru.itis.springapp.models.User;
import ru.itis.springapp.repositories.TeasRepository;

import java.util.List;

@Component
public class TeasServiceImpl implements TeasService {

    @Autowired
    private TeasRepository teasRepository;

    private static final Integer PAGE_SIZE = 10;
    @Override
    public List<TeaDto> getAllTeasByUser(User user, Integer page) {
        Pageable pageable = PageRequest.of(page, PAGE_SIZE);
        return TeaDto.from(teasRepository.findAllByUser(user, pageable));
    }

    @Override
    public void addNewTea(TeaForm teaForm) {
        Tea tea = Tea.builder()
                        .name(teaForm.getName())
                        .description(teaForm.getDescription())
                        .user(teaForm.getUser())
                        .build();
        teasRepository.save(tea);
    }

    @Override
    public Integer getTeaPagesNumberByUser(User user) {
        return Math.round(teasRepository.countAllByUser(user) / PAGE_SIZE);
    }
}
