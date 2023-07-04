package com.hjungwoo01.calendarappserver.controller;

import com.hjungwoo01.calendarappserver.message.*;
import com.hjungwoo01.calendarappserver.model.file.File;
import com.hjungwoo01.calendarappserver.service.FileService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.core.io.ByteArrayResource;
import org.springframework.core.io.Resource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.util.stream.Collectors;
import java.util.List;

@RestController
@RequestMapping("/memos/files")
public class FileController {
    private Logger logger = LoggerFactory.getLogger(FileController.class);
    private FileService fileService;
    public FileController(FileService fileService) {
        super();
        this.fileService = fileService;
    }
    @GetMapping("/get-all")
    public ResponseEntity<List<ResponseFile>> getAllFiles() {
        List<ResponseFile> files = fileService.getAllFiles().stream().map(file -> {
            String fileDownloadUri = ServletUriComponentsBuilder
                    .fromCurrentContextPath()
                    .path("/")
                    .path(String.valueOf(file.getId()))
                    .toUriString();

            return new ResponseFile(
                    file.getName(),
                    fileDownloadUri,
                    file.getType(),
                    file.getData().length);
        }).collect(Collectors.toList());

        return ResponseEntity.status(HttpStatus.OK).body(files);
    }

    @GetMapping("/get/{id}")
    public ResponseEntity<Resource> getFileById(@PathVariable("id") long id) {
        File file = fileService.getFile(id);
        return ResponseEntity.ok()
                .contentType(MediaType.parseMediaType(file.getType()))
                .header(HttpHeaders.CONTENT_DISPOSITION, "/attachment; filename=\"" + file.getName() + "\"")
                .body(new ByteArrayResource(file.getData()));
    }

    @GetMapping("/getByMemoId/{memoId}")
    public ResponseEntity<Resource> getFileByMemoId(@PathVariable("memoId") long memoId) {
        File file = fileService.getFileByMemoId(memoId);
        return ResponseEntity.ok()
                .contentType(MediaType.parseMediaType(file.getType()))
                .header(HttpHeaders.CONTENT_DISPOSITION, "/attachment; filename=\"" + file.getName() + "\"")
                .body(new ByteArrayResource(file.getData()));
    }

    @PostMapping("/upload")
    public ResponseEntity<ResponseMessage> uploadFile(@RequestBody File file) {
        String message = "";
        try {
            File savedFile = fileService.uploadFile(file);
            if(savedFile != null) {
                message = "File uploaded.";
                return ResponseEntity.status(HttpStatus.CREATED).body(new ResponseMessage(message));
            } else {
                message = "File empty.";
                return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(new ResponseMessage(message));
            }
        } catch (Exception e) {
            message = "File failed to upload.";
            return ResponseEntity.status(HttpStatus.EXPECTATION_FAILED).body(new ResponseMessage(message));
        }
    }

    @PutMapping("/updateByMemoId/{memoId}")
    public ResponseEntity<String> updateFileByMemoId(@PathVariable ("memoId") long memoId, @RequestBody File file) {
        File updateFile = fileService.updateFileByMemoId(file, memoId);
        if(updateFile != null) {
            return ResponseEntity.status(HttpStatus.OK).body("File updated.");
        } else {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("File update failed.");
        }
    }

    @DeleteMapping("/deleteByMemoId/{memoId}")
    public ResponseEntity<String> deleteFileByMemoId(@PathVariable("memoId") long memoId) {
        File fileToDelete = fileService.getFileByMemoId(memoId);
        fileService.deleteFile(fileToDelete.getId());
        return new ResponseEntity<String>("File deleted.", HttpStatus.OK);
    }
}