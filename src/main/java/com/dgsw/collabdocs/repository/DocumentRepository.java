package com.dgsw.collabdocs.repository;

import com.dgsw.collabdocs.domain.Document;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface DocumentRepository extends JpaRepository<Document, Long> {
    List<Document> findByAuthor(String author); // 특정 사용자의 문서만 조회
}
