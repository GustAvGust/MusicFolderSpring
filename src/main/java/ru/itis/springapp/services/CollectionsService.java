package ru.itis.springapp.services;

import ru.itis.springapp.dto.CollectionDto;
import ru.itis.springapp.dto.CollectionForm;
import ru.itis.springapp.models.Collection;
import ru.itis.springapp.models.User;

import java.util.List;

public interface CollectionsService {
    List<CollectionDto> getAllCollectionsByUser(User user, Integer page);

    Integer getCollectionPagesNumberByUser(User user);

    Collection findCollectionById(Long collectionId);

    void addNewCollection(CollectionForm collectionForm);

    void updateCollection(Collection collection, CollectionForm collectionForm);
}
