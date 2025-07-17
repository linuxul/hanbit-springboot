package com.youtube.project.sample040.controller;

import com.youtube.project.sample040.model.Member;
import com.youtube.project.sample040.repository.MemberRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/members")
@RequiredArgsConstructor
public class MemberController {
    private final MemberRepository memberRepository;

    @PostMapping
    public Member save(@RequestBody Member member) {
        return memberRepository.save(member);
    }

    @GetMapping
    public List<Member> findAll() {
        return memberRepository.findAll();
    }

    @GetMapping("/{id}")
    public Member findById(@PathVariable Long id) {
        return memberRepository.findById(id).orElse(null);
    }

    @PutMapping("/{id}")
    public Member update(@PathVariable Long id, @RequestBody Member member) {
        member.setId(id);
        return memberRepository.save(member);
    }

    @PatchMapping("/{id}")
    public Member patch(@PathVariable Long id, @RequestBody Member patch) {
        Member member = memberRepository.findById(id).orElse(null);
        if (member != null) {
            if (patch.getName() != null) {
                member.setName(patch.getName());
            }
            if (patch.getEmail() != null) {
                member.setEmail(patch.getEmail());
            }
            if (patch.getAge() != null) {
                member.setAge(patch.getAge());
            }
            memberRepository.save(member);
        }
        return member;
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        memberRepository.deleteById(id);
    }

}
