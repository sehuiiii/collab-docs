package com.dgsw.collabdocs.controller;

import com.dgsw.collabdocs.domain.Document;
import com.dgsw.collabdocs.service.DocumentService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/documents")
@RequiredArgsConstructor
public class DocumentController {

    private final DocumentService documentService;

    @GetMapping
    public List<Document> getAllDocuments() {
        return documentService.getAllDocuments();
    }

    @GetMapping("/{id}")
    public Document getDocument(@PathVariable Long id) {
        return documentService.getDocument(id).orElseThrow();
    }

    @PostMapping
    public Document createDocument(@RequestParam String title,
                                   @RequestParam String content,
                                   @RequestParam String author) {
        return documentService.createDocument(title, content, author);
    }

    @PutMapping("/{id}")
    public Document updateDocument(@PathVariable Long id,
                                   @RequestParam String title,
                                   @RequestParam String content) {
        return documentService.updateDocument(id, title, content);
    }

    @DeleteMapping("/{id}")
    public void deleteDocument(@PathVariable Long id) {
        documentService.deleteDocument(id);
    }
}
