package ru.itis.springapp.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import ru.itis.springapp.models.Collection;
import ru.itis.springapp.models.User;

import java.util.List;
import java.util.stream.Collectors;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class CollectionDto {
    private Long id;
    private String name;
    private String description;
    private User user;

    public static CollectionDto from(Collection collection) {
        return CollectionDto.builder()
                .id(collection.getId())
                .name(collection.getName())
                .description(collection.getDescription())
                .user(collection.getUser())
                .build();
    }

    public static List<CollectionDto> from(List<Collection> collections) {
        return collections.stream()
                .map(CollectionDto::from)
                .collect(Collectors.toList());
    }
}
