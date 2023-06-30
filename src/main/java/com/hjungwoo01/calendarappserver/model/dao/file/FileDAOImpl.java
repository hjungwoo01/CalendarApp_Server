package com.hjungwoo01.calendarappserver.model.dao.file;

import com.hjungwoo01.calendarappserver.exception.ResourceNotFoundException;
import com.hjungwoo01.calendarappserver.model.file.File;
import com.hjungwoo01.calendarappserver.repositories.file.FileRepository;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.stream.Stream;

public class FileDAOImpl implements FileDAO {
    private final FileRepository fileRepository;

    @Autowired
    public FileDAOImpl(FileRepository fileRepository) {
        this.fileRepository = fileRepository;
    }

    @Override
    public File upload(File file) {
        return fileRepository.save(file);
    }

    @Override
    public Stream<File> getAll() {
        return fileRepository.findAll().stream();
    }

    @Override
    public File getById(String id) {
        return fileRepository.findById(id).orElseThrow(() ->
                new ResourceNotFoundException("File", "Id", id));
    }

    @Override
    public void delete(String id) {
        fileRepository.deleteById(id);
    }
}
