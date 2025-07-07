package com.example.sample034;

import com.example.sample034.repository.MemberRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

@Component
@Slf4j
@RequiredArgsConstructor
public class JpaApplication implements ApplicationRunner {

    private final MemberRepository memberRepository;


    @Override
    public void run(ApplicationArguments args) throws Exception {

        Member memberOne = Member.builder()
                .name("대박나")
                .email("niceday@gmail.com")
                .age(18)
                .build();

        Member memberTwo = Member.builder()
                .name("나캐치")
                .email("catch@gmail.com")
                .age(22)
                .build();


        memberRepository.save(memberOne);
        memberRepository.save(memberTwo);
    }
}
