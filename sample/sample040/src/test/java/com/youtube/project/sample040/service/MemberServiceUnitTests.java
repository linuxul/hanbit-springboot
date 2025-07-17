package com.youtube.project.sample040.service;

import com.youtube.project.sample040.dto.MemberResponse;
import com.youtube.project.sample040.model.Member;
import com.youtube.project.sample040.repository.MemberRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.bean.override.mockito.MockitoBean;

import java.util.Optional;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.mockito.Mockito.when;

@SpringBootTest
public class MemberServiceUnitTests {
    @MockitoBean
    private MemberRepository memberRepository;

    @Autowired
    private MemberService memberService;


    @Test
    public void findById() {
        when(memberRepository.findById(1L))
                .thenReturn(Optional.ofNullable(Member.builder()
                        .id(1L)
                        .name("윤서준")
                        .email("seojunyoou@hanbiti.co.kr")
                        .age(10)
                        .build()));

        MemberResponse response = memberService.findById(1L);

        assertThat(response.getId()).isEqualTo(1L);
        assertThat(response.getName()).isEqualTo("윤서준");
        assertThat(response.getEmail()).isEqualTo("seojunyoou@hanbiti.co.kr");
        assertThat(response.getAge()).isEqualTo(10);

    }


}
