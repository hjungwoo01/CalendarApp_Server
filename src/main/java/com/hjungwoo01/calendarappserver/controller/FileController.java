package com.hjungwoo01.calendarappserver.controller;

import com.hjungwoo01.calendarappserver.message.*;
import com.hjungwoo01.calendarappserver.model.file.File;
import com.hjungwoo01.calendarappserver.service.FileService;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.util.stream.Collectors;
import java.util.List;

@RestController
@RequestMapping("/memos/files")
public class FileController {
    private FileService fileService;
    @GetMapping("/get-all")
    public ResponseEntity<List<ResponseFile>> getAllFiles() {
        List<ResponseFile> files = fileService.getAllFiles().map(file -> {
            String fileDownloadUri = ServletUriComponentsBuilder
                    .fromCurrentContextPath()
                    .path("/")
                    .path(file.getId())
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
    public ResponseEntity<byte[]> getFile(@PathVariable String id) {
        File file = fileService.getFile(id);

        return ResponseEntity.ok()
                .header(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=\"" + file.getName() + "\"")
                .body(file.getData());
    }

    @PostMapping("/upload")
    public ResponseEntity<ResponseMessage> uploadFile(@RequestBody File file) {
        String message = "";
        try {
            fileService.uploadFile(file);
            message = "File uploaded.";
            return ResponseEntity.status(HttpStatus.OK).body(new ResponseMessage(message));
        } catch (Exception e) {
            message = "File failed to upload.";
            return ResponseEntity.status(HttpStatus.EXPECTATION_FAILED).body(new ResponseMessage(message));
        }
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<String> updateFile(@PathVariable ("id") String id, @RequestBody File file) {
        File updateFile = fileService.updateFile(file,id);
        if(updateFile != null) {
            return ResponseEntity.status(HttpStatus.OK).body("File updated.");
        } else {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("File update failed.");
        }
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<String> deleteFile(@PathVariable("id") String id) {
        fileService.deleteFile(id);
        return new ResponseEntity<String>("File deleted.", HttpStatus.OK);
    }
}