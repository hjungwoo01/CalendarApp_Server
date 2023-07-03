package com.hjungwoo01.calendarappserver.model.dao.file;

import com.hjungwoo01.calendarappserver.exception.ResourceNotFoundException;
import com.hjungwoo01.calendarappserver.model.file.File;
import com.hjungwoo01.calendarappserver.repositories.file.FileRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
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
    public List<File> getAll() {
        return fileRepository.findAll();
    }

    @Override
    public File getById(long id) {
        return fileRepository.findById(id).orElseThrow(() ->
                new ResourceNotFoundException("File", "Id", id));
    }

    @Override
    public File getByMemoId(long memoId) {
        return fileRepository.findById(memoId).orElseThrow(() ->
                new ResourceNotFoundException("File", "MemoId", memoId));
    }

    @Override
    public void delete(long id) {
        fileRepository.deleteById(id);
    }
}
