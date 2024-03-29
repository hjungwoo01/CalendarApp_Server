package com.hjungwoo01.calendarappserver.service.impl;

import java.util.List;

import com.hjungwoo01.calendarappserver.model.dao.memo.MemoDAO;
import com.hjungwoo01.calendarappserver.exception.ResourceNotFoundException;
import com.hjungwoo01.calendarappserver.model.memo.Memo;
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
    public List<Memo> getMemosByOwner(String owner) {
        return memoDAO.getByOwner(owner);
    }

    @Override
    public List<Memo> getMemosByReceiver(String receiver) {
        return memoDAO.getByReceiver(receiver);
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
        existingMemo.setOwner(memo.getOwner());
        existingMemo.setReceiver(memo.getReceiver());
        existingMemo.setMemoName(memo.getMemoName());
        existingMemo.setMemo(memo.getMemo());
        existingMemo.setDate(memo.getDate());
        existingMemo.setReadReceivers(memo.getReadReceivers());
        return memoDAO.save(existingMemo);
    }

    @Override
    public void deleteMemo(long id) {
        memoDAO.delete(id);
    }
}
