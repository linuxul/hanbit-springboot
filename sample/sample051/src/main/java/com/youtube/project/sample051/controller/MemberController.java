package com.youtube.project.sample051.controller;

import com.youtube.project.sample051.model.Member;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@Controller
@Slf4j
public class MemberController {
    private List<Member> members = List.of(
            new Member(1L, "윤서일", "yoon1@hanbit.co.kr", 10),
            new Member(2L, "윤서이", "yoon2@hanbit.co.kr", 20),
            new Member(3L, "윤서삼", "yoon3@hanbit.co.kr", 30),
            new Member(4L, "윤서사", "yoon4@hanbit.co.kr", 40)
    );

    @GetMapping("/member/list")
    public String getMembers(Model model) {
        model.addAttribute("members", members);
        return "member-list";
    }
}
