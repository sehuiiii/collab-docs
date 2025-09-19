package com.dgsw.collabdocs.service;

import com.dgsw.collabdocs.domain.Document;
import com.dgsw.collabdocs.repository.DocumentRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class DocumentService {

    private final DocumentRepository documentRepository;

    public List<Document> getAllDocuments() {
        return documentRepository.findAll();
    }

    public List<Document> getDocumentsByAuthor(String author) {
        return documentRepository.findByAuthor(author);
    }

    public Document createDocument(String title, String content, String author) {
        Document doc = Document.builder()
                .title(title)
                .content(content)
                .author(author)
                .createdAt(LocalDateTime.now())
                .updatedAt(LocalDateTime.now())
                .build();
        return documentRepository.save(doc);
    }

    public Optional<Document> getDocument(Long id) {
        return documentRepository.findById(id);
    }

    public Document updateDocument(Long id, String title, String content) {
        Document doc = documentRepository.findById(id).orElseThrow();
        doc.setTitle(title);
        doc.setContent(content);
        doc.setUpdatedAt(LocalDateTime.now());
        return documentRepository.save(doc);
    }

    public void deleteDocument(Long id) {
        documentRepository.deleteById(id);
    }
}
