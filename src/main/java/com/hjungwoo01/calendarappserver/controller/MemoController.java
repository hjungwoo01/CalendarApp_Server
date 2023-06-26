package com.hjungwoo01.calendarappserver.controller;

import com.hjungwoo01.calendarappserver.model.Event;
import com.hjungwoo01.calendarappserver.model.Memo;
import com.hjungwoo01.calendarappserver.service.MemoService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/db_calendar/memos")
public class MemoController {
    private MemoService memoService;

    public MemoController(MemoService memoService) {
        super();
        this.memoService = memoService;
    }

    @GetMapping("/get-all")
    public List<Memo> getAllMemos() {
        return memoService.getAllMemos();
    }

    @GetMapping("/get-by-owner/{owner}")
    public ResponseEntity<List<Memo>> getMemosByOwner(@PathVariable("owner") String owner) {
        List<Memo> memos = memoService.getMemosByOwner(owner);
        if (!memos.isEmpty()) {
            return ResponseEntity.ok(memos);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @GetMapping("/get-by-receiver/{receiver}")
    public ResponseEntity<List<Memo>> getMemosByReceiver(@PathVariable("receiver") String receiver) {
        List<Memo> memos = memoService.getMemosByReceiver(receiver);
        if (!memos.isEmpty()) {
            return ResponseEntity.ok(memos);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @GetMapping("/get/{id}")
    public ResponseEntity<Memo> getMemoById(@PathVariable("id") long memoId) {
        return new ResponseEntity<>(memoService.getMemoById(memoId), HttpStatus.OK);
    }

    @PostMapping("/save")
    public ResponseEntity<String> saveMemo(@RequestBody Memo memo) {
        Memo savedMemo = memoService.saveMemo(memo);
        if (savedMemo != null) {
            return ResponseEntity.status(HttpStatus.CREATED).body("Memo added successfully.");
        } else {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Failed to save memo.");
        }
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<String> updateMemo(@PathVariable ("id") long id, @RequestBody Memo memo) {
        Memo updateMemo = memoService.updateMemo(memo,id);
        if(updateMemo != null) {
            return ResponseEntity.status(HttpStatus.OK).body("Memo updated.");
        } else {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Memo update failed.");
        }
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<String> deleteMemo(@PathVariable("id") long id) {
        // delete event from DB
        memoService.deleteMemo(id);
        return new ResponseEntity<String>("Memo deleted.", HttpStatus.OK);
    }
}