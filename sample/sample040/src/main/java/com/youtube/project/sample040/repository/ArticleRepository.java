package com.youtube.project.sample040.repository;

import com.youtube.project.sample040.model.Article;
import com.youtube.project.sample040.model.Member;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ArticleRepository extends JpaRepository<Article, Long> {
    List<Article> findByMember(Member member);
}
