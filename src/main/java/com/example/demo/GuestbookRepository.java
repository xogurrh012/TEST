package com.example.demo;

import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;

public interface GuestbookRepository extends JpaRepository<Guestbook, Long> {
    // 최신순 정렬을 위해 ID 내림차순으로 조회하는 메서드 정의
    List<Guestbook> findAllByOrderByIdDesc();
}
