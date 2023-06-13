package com.hjungwoo01.calendarappserver.repository;

import com.hjungwoo01.calendarappserver.model.Memo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MemoRepository extends JpaRepository<Memo, Long> {
}