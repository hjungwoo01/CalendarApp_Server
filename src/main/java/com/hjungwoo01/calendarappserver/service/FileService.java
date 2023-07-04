package com.hjungwoo01.calendarappserver.service;

import com.hjungwoo01.calendarappserver.model.file.File;

import java.util.List;

public interface FileService {
     File uploadFile(File file);
     File getFile(long id);
     File getFileByMemoId(long memoId);
     List<File> getAllFiles();
     File updateFileByMemoId(File file, long memoId);
     void deleteFile(long id);
}
