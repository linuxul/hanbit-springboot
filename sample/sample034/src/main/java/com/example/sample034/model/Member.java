package com.example.sample034.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "member", indexes = {
        @Index(name = "idx_age", columnList = "age"),
        @Index(name = "idx_email", columnList = "email")
})
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Member {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name="name", length = 255, nullable = false, unique = true)
    private String name;

    @Column(name="email")
    private String email;

    @Column(name="age", nullable = false, columnDefinition = "INTEGER DEFAULT 10")
    private Integer age;

    @Transient
    private String address;


}
