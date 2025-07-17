package com.example.sample041.dto;

import lombok.Builder;
import lombok.Data;

import java.sql.Date;

@Data
@Builder
public class ArticleResponse {
    private Long id;
    private Long memberId;
    private String name;
    private String email;
    private String title;
    private String description;
    private Date created;
    private Date updated;
}
