package com.hjungwoo01.calendarappserver.model.dao.file;

import com.hjungwoo01.calendarappserver.model.file.File;

import java.util.List;

public interface FileDAO {
    File upload(File file);
    List<File> getAll();
    File getById(long id);
    File getByMemoId(long memoId);
    void deleteFile(long id);
}
