package com.example.restapi.service;

import com.example.restapi.model.Memo;

import java.util.List;

public interface MemoService {
    Memo saveMemo(Memo memo);
    List<Memo> getAllMemos();
    Memo getMemoById(long id);
    Memo updateMemo(Memo memo, long id);
    void deleteMemo(long id);
}
