package com.hjungwoo01.calendarappserver.model.dao.memo;

import com.hjungwoo01.calendarappserver.model.memo.Memo;

import java.util.List;

public interface MemoDAO {
    Memo save(Memo memo);
    List<Memo> getAll();
    Memo getById(long id);
    void delete(long id);
    List<Memo> getByOwner(String owner);
    List<Memo> getByReceiver(String receiver);
}