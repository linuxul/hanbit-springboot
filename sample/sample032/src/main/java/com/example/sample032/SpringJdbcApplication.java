package com.example.sample032;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
@Slf4j
public class SpringJdbcApplication implements ApplicationRunner {

    private final MemberRepository memberRepository;

    @Override
    public void run(ApplicationArguments args) throws Exception {
        // create
        Member member = Member.builder()
                .name("정혁")
                .email("test222@gmail.com")
                .age(10)
                .build();
        memberRepository.save(member);

        // update
        member.setAge(44);
        memberRepository.save(member);

        // find all members
        var membersFindAll = memberRepository.findAll();
        log.info("{}", membersFindAll);

        // find member by id
        var memberFindId = memberRepository.findById(1L);
        log.info("{}", memberFindId);

        var memberTeenAge = memberRepository.findTeenAge();
        log.info("{}", memberTeenAge);
    }
}
