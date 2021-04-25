package ru.itis.springapp.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import ru.itis.springapp.models.Tea;
import ru.itis.springapp.models.User;

import java.util.List;
import java.util.stream.Collectors;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class TeaDto {
    private Long id;
    private String name;
    private String description;
    private User user;

    public static TeaDto from(Tea tea) {
        return TeaDto.builder()
                .id(tea.getId())
                .name(tea.getName())
                .description(tea.getDescription())
                .user(tea.getUser())
                .build();
    }

    public static List<TeaDto> from(List<Tea> teas) {
        return teas.stream()
                .map(TeaDto::from)
                .collect(Collectors.toList());
    }
}
