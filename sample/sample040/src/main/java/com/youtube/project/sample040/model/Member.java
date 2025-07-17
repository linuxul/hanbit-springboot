package com.youtube.project.sample040.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Entity
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Member {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(unique = true)
    private String name;
    private String email;
    private Integer age;
    private String password;
    private Boolean enabled;
    @OneToMany(mappedBy = "member", cascade = CascadeType.ALL,  orphanRemoval = true)
    private List<Article> articles;
}
