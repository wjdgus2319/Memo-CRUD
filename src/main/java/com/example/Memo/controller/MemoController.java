package com.example.Memo.controller;

import com.example.Memo.dto.MemoDTO;
import com.example.Memo.service.MemoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/memos")
public class MemoController {

    private final MemoService memoService;

    @Autowired
    public MemoController(MemoService memoService) {
        this.memoService = memoService;
    }

    // Memo 생성
    @PostMapping
    public ResponseEntity<MemoDTO> createMemo(@RequestBody String content) {
        MemoDTO memoDTO = memoService.createMemo(content);
        return ResponseEntity.ok(memoDTO);
    }

    // Memo 전체 조회
    @GetMapping
    public List<MemoDTO> getAllMemos() {
        return memoService.getAllMemos();
    }

    // Memo 조회
    @GetMapping("/{id}")
    public ResponseEntity<MemoDTO> getMemoById(@PathVariable Long id) {
        Optional<MemoDTO> memoDTO = memoService.getMemoById(id);
        return memoDTO.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    // Memo 수정
    @PutMapping("/{id}")
    public ResponseEntity<MemoDTO> updateMemo(@PathVariable Long id, @RequestBody String content) {
        MemoDTO updatedMemo = memoService.updateMemo(id, content);
        return updatedMemo != null ? ResponseEntity.ok(updatedMemo) : ResponseEntity.notFound().build();
    }

    // Memo 삭제
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteMemo(@PathVariable Long id) {
        return memoService.deleteMemo(id) ? ResponseEntity.ok().build() : ResponseEntity.notFound().build();
    }
}



