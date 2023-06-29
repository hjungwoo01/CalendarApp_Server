package com.hjungwoo01.calendarappserver.repositories.memo;

import com.hjungwoo01.calendarappserver.model.memo.Memo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface MemoRepository extends JpaRepository<Memo, Long> {
    List<Memo> findByOwner(String owner);
    @Query("SELECT m FROM Memo m WHERE CONCAT(',', m.receiver, ',') LIKE CONCAT('%,', :receiver, ',%')")
    List<Memo> findByReceiver(String receiver);
}