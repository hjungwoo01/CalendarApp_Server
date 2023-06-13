package com.example.restapi.model;

import java.util.List;

public interface MemoDAO {
    Memo save(Memo memo);
    List<Memo> getAll();
    Memo getById(long id);
    void delete(long id);
}