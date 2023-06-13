package com.hjungwoo01.calendarappserver.model.dao;

import com.hjungwoo01.calendarappserver.model.Memo;

import java.util.List;

public interface MemoDAO {
    Memo save(Memo memo);
    List<Memo> getAll();
    Memo getById(long id);
    void delete(long id);
}