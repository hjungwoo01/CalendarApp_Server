package com.hjungwoo01.calendarappserver.service;

import com.hjungwoo01.calendarappserver.model.file.File;

import java.io.IOException;
import java.util.List;


public interface FileService {
     File uploadFile(File file) throws IOException;
     File getFile(long id);
     File getFileByMemoId(long memoId);
     List<File> getAllFiles();
     File updateFile(File file, long id);
     void deleteFile(long id);
}
