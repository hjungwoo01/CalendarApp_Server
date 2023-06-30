package com.hjungwoo01.calendarappserver.service;

import com.hjungwoo01.calendarappserver.model.file.File;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.stream.Stream;


public interface FileService {
     File uploadFile(MultipartFile file) throws IOException;
     File getFile(String id);
     Stream<File> getAllFiles();
     File updateFile(File file, String id);
     void deleteFile(String id);
}
