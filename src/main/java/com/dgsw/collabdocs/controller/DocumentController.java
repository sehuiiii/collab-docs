package com.dgsw.collabdocs.controller;

import com.dgsw.collabdocs.domain.Document;
import com.dgsw.collabdocs.repository.DocumentRepository;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/documents")
public class DocumentController {

    private final DocumentRepository documentRepository;

    public DocumentController(DocumentRepository documentRepository) {
        this.documentRepository = documentRepository;
    }

    @GetMapping
    public List<Document> getAll() {
        return documentRepository.findAll();
    }

    @PostMapping
    public Document create(@RequestBody Document doc) {
        return documentRepository.save(doc);
    }

    @PutMapping("/{id}")
    public Document update(@PathVariable Long id, @RequestBody Document doc) {
        Document existing = documentRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Document not found"));
        existing.setTitle(doc.getTitle());
        existing.setContent(doc.getContent());
        return documentRepository.save(existing);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        documentRepository.deleteById(id);
    }
}
