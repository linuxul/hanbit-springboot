package com.example.sample041.controller;

import com.example.sample041.dto.MemberRequest;
import com.example.sample041.dto.MemberResponse;
import com.example.sample041.model.Member;
import com.example.sample041.repository.MemberRepository;
import com.example.sample041.service.MemberService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/members")
@RequiredArgsConstructor
public class MemberController {

    private final MemberRepository memberRepository;
    private final MemberService memberService;

//    @PostMapping
//    public Member post(@RequestBody Member member) {
//        return memberRepository.save(member);
//    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public MemberResponse post(@RequestBody MemberRequest memberRequest) {
        return memberService.create(memberRequest);
    }

//    @GetMapping
//    public List<Member> getAll() {
//        return memberRepository.findAll();
//    }

    @GetMapping
    public List<MemberResponse> getAll() {
        return memberService.findAll();
    }


//    @GetMapping("/{id}")
//    public Member get(@PathVariable("id") Long id) {
//        return memberRepository.findById(id).orElse(null);
//    }

    @GetMapping("/{id}")
    public MemberResponse get(@PathVariable("id") Long id) {
        return memberService.findById(id);
    }

//    @PutMapping("/{id}")
//    public Member put(@PathVariable("id") Long id, @RequestBody Member member) {
//        member.setId(id);
//        return memberRepository.save(member);
//    }

    @PutMapping("/{id}")
    public MemberResponse put(@PathVariable("id") Long id, @RequestBody MemberRequest memberRequest) {
        return memberService.update(id, memberRequest);
    }

//    @PatchMapping("/{id}")
//    public Member patch(@PathVariable("id") Long id, @RequestBody Member patchMember) {
//        Member member = memberRepository.findById(id).orElse(null);
//        if (member != null) {
//            if (patchMember.getName() != null) {
//                member.setName(patchMember.getName());
//            }
//            if (patchMember.getEmail() != null) {
//                member.setEmail(patchMember.getEmail());
//            }
//            if (patchMember.getAge() != null) {
//                member.setAge(patchMember.getAge());
//            }
//            memberRepository.save(member);
//        }
//        return member;
//    }

    @PatchMapping("/{id}")
    public MemberResponse patch(@PathVariable("id") Long id, @RequestBody MemberRequest patchMember) {
        return memberService.patch(id, patchMember);
    }

//    @DeleteMapping("/{id}")
//    public void delete(@PathVariable("id") Long id) {
//        Member member = memberRepository.findById(id).orElse(null);
//    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable("id") Long id) {
        memberService.deleteById(id);
    }
}
