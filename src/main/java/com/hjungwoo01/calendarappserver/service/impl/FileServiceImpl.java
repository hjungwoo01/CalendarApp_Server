package com.hjungwoo01.calendarappserver.service.impl;

import com.hjungwoo01.calendarappserver.model.dao.file.FileDAO;
import com.hjungwoo01.calendarappserver.model.file.File;
import com.hjungwoo01.calendarappserver.service.FileService;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.List;

@Service
public class FileServiceImpl implements FileService {

    private final FileDAO fileDAO;

    public FileServiceImpl(FileDAO fileDAO) {
        this.fileDAO = fileDAO;
    }
    public File uploadFile(File file) throws IOException {
        return fileDAO.upload(file);
    }

    public File getFile(long id) {
        return fileDAO.getById(id);
    }

    @Override
    public File getFileByMemoId(long memoId) {
        return fileDAO.getByMemoId(memoId);
    }

    public List<File> getAllFiles() {
        return fileDAO.getAll();
    }

    @Override
    public File updateFile(File file, long id) {
        File existingFile = getFile(id);
        existingFile.setMemoId(file.getMemoId());
        existingFile.setName(file.getName());
        existingFile.setType(file.getType());
        existingFile.setData(file.getData());
        return fileDAO.upload(existingFile);
    }

    @Override
    public void deleteFile(long id) {
        getFile(id);
        fileDAO.delete(id);
    }
}
