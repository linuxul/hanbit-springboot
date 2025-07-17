package com.youtube.project.sample040.service;

import com.youtube.project.sample040.dto.MemberRequest;
import com.youtube.project.sample040.dto.MemberResponse;
import com.youtube.project.sample040.model.Member;
import com.youtube.project.sample040.repository.MemberRepository;
import com.youtube.project.sample040.exception.NotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
public class MemberService {
    private final MemberRepository memberRepository;


    private MemberResponse mapToMemberResponse(Member member) {
        return MemberResponse.builder()
                .id(member.getId())
                .name(member.getName())
                .email(member.getEmail())
                .age(member.getAge())
                .build();
    }

    public MemberResponse create(MemberRequest memberRequest) {
        Member member = Member.builder()
                .name(memberRequest.getName())
                .email(memberRequest.getEmail())
                .age(memberRequest.getAge())
                .enabled(true)
                .build();
        memberRepository.save(member);
        return mapToMemberResponse(member);
    }

    @Transactional
    public List<MemberResponse> createBatch(List<MemberRequest> memberRequests) {
        return memberRequests.stream().map(this::create).toList();
    }

    public List<MemberResponse> findAll() {
        return memberRepository
                .findAll()
                .stream()
                .map(this::mapToMemberResponse)
                .toList();
    }

    public MemberResponse findById(Long id) {
        Member member = memberRepository.findById(id).orElseThrow(NotFoundException::new);
        return mapToMemberResponse(member);
    }

    public MemberResponse update(Long id, MemberRequest memberRequest) {
        Member member = memberRepository.findById(id).orElseThrow(NotFoundException::new);
        // password, enable 필드를 유지해야 하므로 나머지 항목들만 업데이트
        member.setName(memberRequest.getName());
        member.setEmail(memberRequest.getEmail());
        member.setAge(memberRequest.getAge());
        memberRepository.save(member);
        return mapToMemberResponse(member);
    }

    public MemberResponse patch(Long id, MemberRequest memberRequest) {
        Member member = memberRepository.findById(id).orElseThrow(NotFoundException::new);

        if (memberRequest.getName() != null) {
            member.setName(memberRequest.getName());
        }
        if (memberRequest.getEmail() != null) {
            member.setEmail(memberRequest.getEmail());
        }
        if (memberRequest.getAge() != null) {
            member.setAge(memberRequest.getAge());
        }

        memberRepository.save(member);
        return mapToMemberResponse(member);
    }

    public void deleteById(Long id) {
        Member member = memberRepository.findById(id).orElseThrow(NotFoundException::new);
        memberRepository.delete(member);
    }
}
