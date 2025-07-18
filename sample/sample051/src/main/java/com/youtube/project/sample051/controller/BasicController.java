package com.youtube.project.sample051.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.awt.print.Book;

@Controller
public class BasicController {

    @GetMapping("/book")
    public String getBook(Model model) {
        model.addAttribute("title", "이것이 스프링 부트다 with 자바");
        model.addAttribute("description", "예제를 통해 공부해 부세요.");

        return "basic/book";
    }
}
