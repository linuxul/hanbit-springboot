package com.example.sample041.controller;

import com.example.sample041.model.Member;
import com.example.sample041.repository.MemberRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/members")
@RequiredArgsConstructor
public class MemberController {

    private final MemberRepository memberRepository;

    @PostMapping
    public Member post(@RequestBody Member member) {
        return memberRepository.save(member);
    }

    @GetMapping
    public List<Member> getAll() {
        return memberRepository.findAll();
    }

    @GetMapping("/{id}")
    public Member get(@PathVariable("id") Long id) {
        return memberRepository.findById(id).orElse(null);
    }

    @PutMapping("/{id}")
    public Member put(@PathVariable("id") Long id, @RequestBody Member member) {
        member.setId(id);
        return memberRepository.save(member);
    }

    @PatchMapping("/{id}")
    public Member patch(@PathVariable("id") Long id, @RequestBody Member patchMember) {
        Member member = memberRepository.findById(id).orElse(null);
        if (member != null) {
            if (patchMember.getName() != null) {
                member.setName(patchMember.getName());
            }
            if (patchMember.getEmail() != null) {
                member.setEmail(patchMember.getEmail());
            }
            if (patchMember.getAge() != null) {
                member.setAge(patchMember.getAge());
            }
            memberRepository.save(member);
        }
        return member;
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable("id") Long id) {
        Member member = memberRepository.findById(id).orElse(null);

    }
}
