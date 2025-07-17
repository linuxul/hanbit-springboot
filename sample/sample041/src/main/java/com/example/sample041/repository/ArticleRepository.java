package com.example.sample041.repository;

import com.example.sample041.model.Article;
import com.example.sample041.model.Member;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ArticleRepository extends JpaRepository<Article, Long> {

    List<Article> findByMember(Member member);
}
