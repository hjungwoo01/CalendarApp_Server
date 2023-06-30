package com.hjungwoo01.calendarappserver.model.dao.file;

import com.hjungwoo01.calendarappserver.model.file.File;

import java.util.stream.Stream;

public interface FileDAO {
    File upload(File file);
    Stream<File> getAll();
    File getById(String id);
    void delete(String id);
}
