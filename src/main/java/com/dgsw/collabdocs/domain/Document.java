package com.dgsw.collabdocs.domain;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Document {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String title;

    @Lob // 긴 텍스트 저장
    private String content;

    private String author; // 작성자 username

    private LocalDateTime createdAt;

    private LocalDateTime updatedAt;
}
