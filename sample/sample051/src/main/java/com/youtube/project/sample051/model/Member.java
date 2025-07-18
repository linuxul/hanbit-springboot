package com.youtube.project.sample051.model;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Member {
    public Long id;
    public String name;
    public String email;
    public Integer age;
}
