package com.example.Memo.service;

import com.example.Memo.dto.MemoDTO;
import com.example.Memo.entity.Memo;
import com.example.Memo.repository.MemoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class MemoService {

    private final MemoRepository memoRepository;

    @Autowired
    public MemoService(MemoRepository memoRepository) {
        this.memoRepository = memoRepository;
    }

    // Memo 생성
    public MemoDTO createMemo(String content) {
        Memo memo = new Memo(content);
        Memo savedMemo = memoRepository.save(memo);
        return new MemoDTO(savedMemo.getId(), savedMemo.getContent());
    }

    // Memo 전체 조회
    public List<MemoDTO> getAllMemos() {
        return memoRepository.findAll()
                .stream()
                .map(memo -> new MemoDTO(memo.getId(), memo.getContent()))
                .collect(Collectors.toList());
    }

    // Memo 조회
    public Optional<MemoDTO> getMemoById(Long id) {
        return memoRepository.findById(id)
                .map(memo -> new MemoDTO(memo.getId(), memo.getContent()));
    }

    // Memo 수정
    public MemoDTO updateMemo(Long id, String content) {
        Optional<Memo> existingMemo = memoRepository.findById(id);
        if (existingMemo.isPresent()) {
            Memo memo = existingMemo.get();
            memo.setContent(content);
            Memo updatedMemo = memoRepository.save(memo);
            return new MemoDTO(updatedMemo.getId(), updatedMemo.getContent());
        }
        return null;
    }

    // Memo 삭제
    public boolean deleteMemo(Long id) {
        if (memoRepository.existsById(id)) {
            memoRepository.deleteById(id);
            return true;
        }
        return false;
    }
}

