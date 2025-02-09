package com.example.Memo.repository;

import com.example.Memo.entity.Memo;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MemoRepository extends JpaRepository<Memo, Long> {
    // 필요한 추가 쿼리가 있으면 여기에 정의할 수 있습니다.
}

