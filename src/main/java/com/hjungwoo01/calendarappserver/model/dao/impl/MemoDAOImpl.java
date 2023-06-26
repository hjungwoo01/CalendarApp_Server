package com.hjungwoo01.calendarappserver.model.dao.impl;

import com.hjungwoo01.calendarappserver.exception.ResourceNotFoundException;
import com.hjungwoo01.calendarappserver.model.Event;
import com.hjungwoo01.calendarappserver.model.Memo;
import com.hjungwoo01.calendarappserver.model.dao.MemoDAO;
import com.hjungwoo01.calendarappserver.repository.MemoRepository;
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
    public List<Memo> getByOwner(String owner) {
        return memoRepository.findByOwner(owner);
    }

    @Override
    public List<Memo> getByReceiver(String receiver) {
        return memoRepository.findByReceiver(receiver);
    }

    @Override
    public void delete(long id) {
        memoRepository.deleteById(id);
    }
}
