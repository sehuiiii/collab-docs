package com.dgsw.collabdocs.domain;

import jakarta.persistence.*;
import lombok.*;


@Entity
@Table(name = "app_user")  // 테이블 이름 변경
@Getter @Setter
@NoArgsConstructor
@AllArgsConstructor
public class User {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(unique = true)
    private String username;
    private String password;
}
