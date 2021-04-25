package ru.itis.springapp.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.itis.springapp.models.FileInfo;

public interface FileInfoRepository extends JpaRepository<FileInfo, Long> {
    FileInfo findByStorageFileName(String storageFileName);
}
