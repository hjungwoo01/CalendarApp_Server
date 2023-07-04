package com.hjungwoo01.calendarappserver.repositories.file;


import com.hjungwoo01.calendarappserver.model.file.File;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface FileRepository extends JpaRepository<File, Long> {
    @Query("SELECT f FROM File f WHERE f.memoId = :memoId")
    Optional<File> findByMemoId(@Param("memoId") Long memoId);
}