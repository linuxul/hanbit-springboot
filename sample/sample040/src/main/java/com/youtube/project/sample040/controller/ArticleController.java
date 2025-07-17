package com.youtube.project.sample040.controller;

import com.youtube.project.sample040.dto.ArticleRequest;
import com.youtube.project.sample040.dto.ArticleResponse;
import com.youtube.project.sample040.service.ArticleService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/articles")
@RequiredArgsConstructor
public class ArticleController {
    private final ArticleService articleService;

    @GetMapping
    public List<ArticleResponse> getByMember(@RequestParam(name="memberId", required = false) Long memberId) {

        if (memberId == null) {
            return articleService.findAll();
        } else {
            return articleService.findByMemberId(memberId);
        }
    }

    @GetMapping("/{id}")
    public ArticleResponse get(@PathVariable Long id) {
        return articleService.findById(id);
    }

    @PutMapping("/{id}")
    public ArticleResponse put(@PathVariable Long id, @RequestBody ArticleRequest articleRequest) {
        return articleService.update(id, articleRequest);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        articleService.delete(id);
    }
}
