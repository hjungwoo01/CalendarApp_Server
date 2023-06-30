package com.hjungwoo01.calendarappserver.repositories.file;


import com.hjungwoo01.calendarappserver.model.file.File;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FileRepository extends JpaRepository<File, String> {

}