package com.youtube.project.sample040.controller;

import com.youtube.project.sample040.dto.ArticleRequest;
import com.youtube.project.sample040.dto.ArticleResponse;
import com.youtube.project.sample040.dto.MemberRequest;
import com.youtube.project.sample040.dto.MemberResponse;
import com.youtube.project.sample040.model.Member;
import com.youtube.project.sample040.repository.ArticleRepository;
import com.youtube.project.sample040.repository.MemberRepository;
import com.youtube.project.sample040.service.ArticleService;
import com.youtube.project.sample040.service.MemberService;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.util.List;

@RestController
@RequestMapping("/api/members")
@RequiredArgsConstructor
public class MemberController {
//    private final MemberRepository memberRepository;
    private final MemberService memberService;
    private final ArticleService articleService;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public MemberResponse post(@RequestBody MemberRequest memberRequest) {
        return memberService.create(memberRequest);
    }

    @GetMapping
    public List<MemberResponse> getAll() {
        return memberService.findAll();
    }

    @GetMapping("/{id}")
    public MemberResponse get(@PathVariable("id") Long id) {
        return memberService.findById(id);
    }

    @PutMapping("/{id}")
    public MemberResponse put(@PathVariable("id") Long id, @RequestBody MemberRequest memberRequest) {
        return memberService.update(id, memberRequest);
    }

    @PatchMapping("/{id}")
    public MemberResponse patch(@PathVariable("id") Long id, @RequestBody MemberRequest patchMember) {
        return memberService.patch(id, patchMember);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable("id") Long id) {
        memberService.deleteById(id);
    }

    @PostMapping("/{id}/articles")
    @ResponseStatus(HttpStatus.CREATED)
    public ArticleResponse postArticle(@PathVariable("id") Long id, @RequestBody ArticleRequest articleRequest) {
        return articleService.create(id, articleRequest);
    }

//    @GetMapping("/{id}/articles")
//    public void getArticles(@PathVariable("id") Long id,
//                            HttpServletResponse response) throws ServletException, IOException {
//        response.sendRedirect("/api/articles?memberId=" + id);
//    }

    @GetMapping("/{id}/articles")
    public void getArticle(@PathVariable("id") Long id,
                           HttpServletRequest request,
                           HttpServletResponse response) throws ServletException, IOException {
        request.getSession()
                .getServletContext()
                .getRequestDispatcher("/api/articles?memberId=" + id)
                .forward(request, response);
    }

//
//    @PostMapping
//    public Member save(@RequestBody Member member) {
//        return memberRepository.save(member);
//    }
//
//    @GetMapping
//    public List<Member> findAll() {
//        return memberRepository.findAll();
//    }
//
//    @GetMapping("/{id}")
//    public Member findById(@PathVariable Long id) {
//        return memberRepository.findById(id).orElse(null);
//    }
//
//    @PutMapping("/{id}")
//    public Member update(@PathVariable Long id, @RequestBody Member member) {
//        member.setId(id);
//        return memberRepository.save(member);
//    }
//
//    @PatchMapping("/{id}")
//    public Member patch(@PathVariable Long id, @RequestBody Member patch) {
//        Member member = memberRepository.findById(id).orElse(null);
//        if (member != null) {
//            if (patch.getName() != null) {
//                member.setName(patch.getName());
//            }
//            if (patch.getEmail() != null) {
//                member.setEmail(patch.getEmail());
//            }
//            if (patch.getAge() != null) {
//                member.setAge(patch.getAge());
//            }
//            memberRepository.save(member);
//        }
//        return member;
//    }
//
//    @DeleteMapping("/{id}")
//    public void delete(@PathVariable Long id) {
//        memberRepository.deleteById(id);
//    }

}
