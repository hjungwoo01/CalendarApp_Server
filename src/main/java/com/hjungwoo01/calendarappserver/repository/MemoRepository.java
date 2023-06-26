package com.hjungwoo01.calendarappserver.repository;

import com.hjungwoo01.calendarappserver.model.Memo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface MemoRepository extends JpaRepository<Memo, Long> {
    List<Memo> findByOwner(String owner);

    List<Memo> findByReceiver(String receiver);
}