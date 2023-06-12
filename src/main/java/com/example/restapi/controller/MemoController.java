package com.example.restapi.controller;

import com.example.restapi.model.Memo;
import com.example.restapi.service.MemoService;
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

    @GetMapping
    public List<Memo> getAllMemos() {
        return memoService.getAllMemos();
    }

    @GetMapping("{id}")
    public ResponseEntity<Memo> getMemoById(@PathVariable("id") long memoId) {
        return new ResponseEntity<>(memoService.getMemoById(memoId), HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<String> saveMemo(@RequestBody Memo memo) {
        Memo savedMemo = memoService.saveMemo(memo);
        if (savedMemo != null) {
            return ResponseEntity.status(HttpStatus.CREATED).body("Memo added successfully.");
        } else {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Failed to save memo.");
        }
    }

    @PutMapping("{id}")
    public ResponseEntity<Memo> updateMemo(@PathVariable ("id") long id, @RequestBody Memo memo) {
        return new ResponseEntity<>(memoService.updateMemo(memo, id), HttpStatus.OK);
    }

    @DeleteMapping("{id}")
    public ResponseEntity<String> deleteMemo(@PathVariable("id") long id) {
        // delete event from DB
        memoService.deleteMemo(id);
        return new ResponseEntity<String>("Memo deleted successfully.", HttpStatus.OK);
    }
}