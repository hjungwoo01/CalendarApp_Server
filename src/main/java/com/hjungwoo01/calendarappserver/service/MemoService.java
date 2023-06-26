package com.hjungwoo01.calendarappserver.service;

import com.hjungwoo01.calendarappserver.model.Memo;

import java.util.List;

public interface MemoService {
    Memo saveMemo(Memo memo);
    List<Memo> getAllMemos();
    List<Memo> getMemosByReceiver(String receiver);
    Memo getMemoById(long id);
    Memo updateMemo(Memo memo, long id);
    void deleteMemo(long id);
    List<Memo> getMemosByOwner(String owner);
}
