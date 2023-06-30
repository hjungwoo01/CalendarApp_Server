package com.hjungwoo01.calendarappserver.service.impl;

import com.hjungwoo01.calendarappserver.model.dao.file.FileDAO;
import com.hjungwoo01.calendarappserver.model.file.File;
import com.hjungwoo01.calendarappserver.service.FileService;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.Objects;
import java.util.stream.Stream;

@Service
public class FileServiceImpl implements FileService {

    private FileDAO fileDAO;

    public File uploadFile(MultipartFile multipartFile) throws IOException {
        String fileName = StringUtils.cleanPath(Objects.requireNonNull(multipartFile.getOriginalFilename()));
        File file = new File(fileName, multipartFile.getContentType(), multipartFile.getBytes());
        return fileDAO.upload(file);
    }

    public File getFile(String id) {
        return fileDAO.getById(id);
    }

    public Stream<File> getAllFiles() {
        return fileDAO.getAll();
    }

    @Override
    public File updateFile(File file, String id) {
        File existingFile = getFile(id);
        existingFile.setMemoId(file.getMemoId());
        existingFile.setName(file.getName());
        existingFile.setType(file.getType());
        existingFile.setData(file.getData());
        return fileDAO.upload(existingFile);
    }

    @Override
    public void deleteFile(String id) {
        getFile(id);
        fileDAO.delete(id);
    }
}