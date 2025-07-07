package com.example.sample034;

import com.example.sample034.model.Article;
import com.example.sample034.model.Member;
import com.example.sample034.repository.ArticleRepository;
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
    private final ArticleRepository articleRepository;

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
                .age(25)
                .build();

        memberRepository.save(memberOne);
        memberRepository.save(memberTwo);

        log.info("read 대박나");
        Member readMember = memberRepository.findById(memberOne.getId()).orElseThrow();

        log.info("update 대박나");
        readMember.setAge(31);
        memberRepository.save(readMember);

        log.info("update member2");
        memberRepository.save(memberTwo);

        var articleInsert = Article.builder()
                .title("방학 첫날이다")
                .description("오늘은 열심히 방학 숙제를 했다.")
                .member(memberOne)
                .build();

        articleRepository.save(articleInsert);

        var articles = articleRepository.findAll();

        for (Article article : articles) {
            log.info(article.toString());
        }

    }
}
