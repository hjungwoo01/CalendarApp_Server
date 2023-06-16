package com.hjungwoo01.calendarappserver.service.impl;

import java.util.List;

import com.hjungwoo01.calendarappserver.model.dao.MemoDAO;
import com.hjungwoo01.calendarappserver.exception.ResourceNotFoundException;
import com.hjungwoo01.calendarappserver.model.Memo;
import com.hjungwoo01.calendarappserver.service.MemoService;
import org.springframework.stereotype.Service;

@Service
public class MemoServiceImpl implements MemoService {
    private final MemoDAO memoDAO;

    public MemoServiceImpl(MemoDAO memoDAO) {
        this.memoDAO = memoDAO;
    }
    @Override
    public Memo saveMemo(Memo memo) {
        return memoDAO.save(memo);
    }

    @Override
    public List<Memo> getAllMemos() {
        return memoDAO.getAll();
    }

    @Override
    public Memo getMemoById(long id) {
        Memo memo = memoDAO.getById(id);
        if (memo == null) {
            throw new ResourceNotFoundException("Memo", "Id", id);
        }
        return memo;
    }

    @Override
    public Memo updateMemo(Memo memo, long id) {
        Memo existingMemo = getMemoById(id);
        existingMemo.setReceiver(memo.getReceiver());
        existingMemo.setMemo(memo.getMemo());
        return memoDAO.save(existingMemo);
    }

    @Override
    public void deleteMemo(long id) {
        getMemoById(id);
        memoDAO.delete(id);
    }
}