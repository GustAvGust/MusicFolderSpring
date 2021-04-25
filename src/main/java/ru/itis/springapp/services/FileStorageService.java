package ru.itis.springapp.services;

import org.springframework.web.multipart.MultipartFile;
import ru.itis.springapp.models.FileInfo;

import javax.servlet.http.HttpServletResponse;

public interface FileStorageService {
    FileInfo saveFile(MultipartFile file);
    void writeFileToResponse(String fileName, HttpServletResponse response);
}
