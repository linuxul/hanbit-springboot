package com.youtube.project.sample040.service;

import com.youtube.project.sample040.dto.MemberRequest;
import com.youtube.project.sample040.dto.MemberResponse;
import com.youtube.project.sample040.repository.MemberRepository;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

@SpringBootTest
public class MemberServiceTest {
    @Autowired
    MemberRepository memberRepository;

    @Autowired
    MemberService memberService;

    @AfterEach
    public void doAfterEach() {
        memberRepository.deleteAll();
    }

    @Test
    @DisplayName("회원 추가 및 조회")
    public void testUsers() {
        MemberRequest userRequest = MemberRequest.builder()
                .name("윤서준")
                .age(10)
                .build();
        MemberResponse userResponse = memberService.create(userRequest);
        assertThat(userResponse.getId()).isNotNull();
        assertThat(userResponse.getName()).isEqualTo("윤서준");

        userRequest = MemberRequest.builder()
                .name("윤서이")
                .age(20)
                .build();
        userResponse = memberService.create(userRequest);
        assertThat(userResponse.getId()).isNotNull();

        List<MemberResponse> memberResponses = memberService.findAll();
        assertThat(memberResponses.size()).isEqualTo(2);
    }

    @Test
    @DisplayName("트랜잭션 커밋 테스트")
    public void testTransactionalCommit() {
        List<MemberRequest> userRequests = List.of(
                MemberRequest.builder()
                        .name("윤서일")
                        .email("yoon1@hanbit.co.kr")
                        .age(10)
                        .build(),
                MemberRequest.builder()
                        .name("윤서이")
                        .email("yoon2@hanbit.co.kr")
                        .age(20)
                        .build(),
                MemberRequest.builder()
                        .name("윤서삼")
                        .email("yoon3@hanbit.co.kr")
                        .age(30)
                        .build(),
                MemberRequest.builder()
                        .name("윤서사")
                        .email("yoon4@hanbit.co.kr")
                        .age(40)
                        .build()
        );

        try {
            memberService.createBatch(userRequests);
        } catch (Exception e) {

        }
        assertThat(memberRepository.count()).isEqualTo(4);
    }

    @Test
    @DisplayName("트랜잭션 롤백 테스트")
    public void testTransactionalRollback() {
        List<MemberRequest> userRequests = List.of(
                MemberRequest.builder()
                        .name("윤서일")
                        .email("yoon1@hanbit.co.kr")
                        .age(10)
                        .build(),
                MemberRequest.builder()
                        .name("윤서이")
                        .email("yoon2@hanbit.co.kr")
                        .age(20)
                        .build(),
                MemberRequest.builder()
                        .name("윤서삼")
                        .email("yoon1@hanbit.co.kr")
                        .age(30)
                        .build(),
                MemberRequest.builder()
                        .name("윤서사")
                        .email("yoon4@hanbit.co.kr")
                        .age(40)
                        .build()
        );

        try {
            memberService.createBatch(userRequests);
        } catch (Exception e) {

        }
        assertThat(memberRepository.count()).isEqualTo(0);
    }
}
