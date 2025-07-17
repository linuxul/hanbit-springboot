package com.youtube.project.sample040.repository;

import com.youtube.project.sample040.model.Member;
import org.junit.jupiter.api.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

@SpringBootTest
@DisplayName("회원 리포지터리 테스트")
public class MemberRepositoryTests {
    @Autowired
    MemberRepository memberRepository;

    @BeforeEach
    public void doBeforeEach() {
        // 각 테스트 전에 수행되어야 할 작업
        memberRepository.save(Member.builder()
                .name("윤서준")
                .email("seojun@hanbit.co.kr")
                .age(10)
                .build());
        memberRepository.save(Member.builder()
                .name("윤서이")
                .email("seojun2@hanbit.co.kr")
                .age(20)
                .build());
        memberRepository.save(Member.builder()
                .name("윤서삼")
                .email("seojun3@hanbit.co.kr")
                .age(30)
                .build());
        memberRepository.save(Member.builder()
                .name("윤서넷")
                .email("seojun4@hanbit.co.kr")
                .age(40)
                .build());

    }

    @AfterEach
    public void doAfterEach() {
        // 각 테스트가 종료된 후에 수행되어야 할 작업
        memberRepository.deleteAll();
    }

    @Test
    @DisplayName("조건 검색 테스트")
    public void testUserCase1() {
        // 회원 리포지터리에 저장된 개수가 4인지 검증
        assertThat(memberRepository.count()).isEqualTo(4);

        assertThat(memberRepository.findByName("윤서준").size()).isEqualTo(1);

        assertThat(memberRepository.findByNameAndEmail("윤서준", "seojun@hanbit.co.kr").size()).isEqualTo(1);

        assertThat(memberRepository.findByNameOrEmail("윤서준", "seojun2@hanbit.co.kr").size()).isEqualTo(2);

        assertThat(memberRepository.findByNameContaining("윤").size()).isEqualTo(4);

        assertThat(memberRepository.findByNameLike("윤%").size()).isEqualTo(4);

        assertThat(memberRepository.findByAgeGreaterThan(26).size()).isEqualTo(2);

        assertThat(memberRepository.findByAgeGreaterThanEqual(20).size()).isEqualTo(3);

        assertThat(memberRepository.findByAgeLessThan(20).size()).isEqualTo(1);

        assertThat(memberRepository.findByAgeLessThanEqual(20).size()).isEqualTo(2);

    }

    @Test
    @DisplayName("정렬 순서 테스트")
    @Disabled("잠시 테스트 중단")
    public void testUserCase2() {
        assertThat(memberRepository.findAllByOrderByNameAsc().size()).isEqualTo(4);

        assertThat(memberRepository.findAllByOrderByNameAsc().get(0).getName()).isEqualTo("윤서넷");
    }

    @RepeatedTest(3)
    @DisplayName("JPQL 테스트")
    public void testUserCase3() {
        assertThat(memberRepository.findMemberByName("윤서준").size()).isEqualTo(1);

        assertThat(memberRepository.findMemberByNameEmail("윤서넷", "seojun4@hanbit.co.kr").size()).isEqualTo(1);


    }

}
