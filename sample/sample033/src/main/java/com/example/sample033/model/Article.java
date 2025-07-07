package com.example.sample033.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Article {
    private Long id;
    private String title;
    private String description;
    private String created;
    private String updated;
    private Long memberId;

}
