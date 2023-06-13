package com.example.restapi.model.dao.impl;

import com.example.restapi.exception.ResourceNotFoundException;
import com.example.restapi.model.Memo;
import com.example.restapi.model.dao.MemoDAO;
import com.example.restapi.repository.MemoRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class MemoDAOImpl implements MemoDAO {

    private final MemoRepository memoRepository;

    public MemoDAOImpl(MemoRepository memoRepository) {
        this.memoRepository = memoRepository;
    }

    @Override
    public Memo save(Memo memo) {
        return memoRepository.save(memo);
    }

    @Override
    public List<Memo> getAll() {
        return memoRepository.findAll();
    }

    @Override
    public Memo getById(long id) {
        return memoRepository.findById(id).orElseThrow(() ->
                new ResourceNotFoundException("Memo", "Id", id));
    }

    @Override
    public void delete(long id) {
        memoRepository.deleteById(id);
    }
}
