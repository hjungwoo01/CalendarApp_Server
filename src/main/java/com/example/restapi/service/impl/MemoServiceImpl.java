package com.example.restapi.service.impl;

import java.util.List;

import org.springframework.stereotype.Service;

import com.example.restapi.exception.ResourceNotFoundException;
import com.example.restapi.model.Memo;
import com.example.restapi.repository.MemoRepository;
import com.example.restapi.service.MemoService;

@Service
public class MemoServiceImpl implements MemoService {

    private MemoRepository memoRepository;
    public MemoServiceImpl(MemoRepository memoRepository) {
        super();
        this.memoRepository = memoRepository;
    }
    @Override
    public Memo saveMemo(Memo memo) {
        return memoRepository.save(memo);
    }

    @Override
    public List<Memo> getAllMemos() {
        return memoRepository.findAll();
    }

    @Override
    public Memo getMemoById(long id) {
        return memoRepository.findById(id).orElseThrow(() ->
                new ResourceNotFoundException("Memo", "Id", id));
    }

    @Override
    public Memo updateMemo(Memo memo, long id) {
        // need to check whether event with given id exists in DB
        Memo existingMemo = memoRepository.findById(id).orElseThrow(
                () -> new ResourceNotFoundException("Memo", "Id", id));

        existingMemo.setReceiver(memo.getReceiver());
        existingMemo.setMemo(memo.getMemo());
        // save existing event to DB
        memoRepository.save(existingMemo);
        return existingMemo;
    }

    @Override
    public void deleteMemo(long id) {
        memoRepository.findById(id).orElseThrow(() ->
                new ResourceNotFoundException("Memo", "Id", id));
        memoRepository.deleteById(id);
    }
}
