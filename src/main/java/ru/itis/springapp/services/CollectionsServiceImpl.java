package ru.itis.springapp.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Component;
import ru.itis.springapp.dto.CollectionDto;
import ru.itis.springapp.dto.CollectionForm;
import ru.itis.springapp.models.Collection;
import ru.itis.springapp.models.User;
import ru.itis.springapp.repositories.CollectionsRepository;

import java.util.List;
import java.util.NoSuchElementException;

@Component
public class CollectionsServiceImpl implements CollectionsService {
    @Autowired
    private CollectionsRepository collectionsRepository;

    private static final Integer PAGE_SIZE = 10;
    
    @Override
    public List<CollectionDto> getAllCollectionsByUser(User user, Integer page) {
        Pageable pageable = PageRequest.of(page, PAGE_SIZE);
        return CollectionDto.from(collectionsRepository.findAllByUser(user, pageable));
    }

    @Override
    public Integer getCollectionPagesNumberByUser(User user) {
        return Math.round(collectionsRepository.countAllByUser(user) / PAGE_SIZE);
    }

    @Override
    public Collection findCollectionById(Long collectionId) {
        return collectionsRepository.findById(collectionId).orElseThrow(() -> new NoSuchElementException("Collection not found"));
    }

    @Override
    public void addNewCollection(CollectionForm collectionForm) {
        Collection collection = Collection.builder()
                .name(collectionForm.getName())
                .description(collectionForm.getDescription())
                .user(collectionForm.getUser())
                .build();
        collectionsRepository.save(collection);
    }

    @Override
    public void updateCollection(Collection collection, CollectionForm collectionParams) {
        if (collectionParams.getName() != null) {
            collection.setName(collectionParams.getName());
        }
        if (collectionParams.getDescription() != null) {
            collection.setDescription(collectionParams.getDescription());
        }
        collectionsRepository.save(collection);
    }
}
