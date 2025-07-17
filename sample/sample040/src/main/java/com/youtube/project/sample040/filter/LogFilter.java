package com.youtube.project.sample040.filter;

import jakarta.servlet.*;
import jakarta.servlet.annotation.WebFilter;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.extern.slf4j.Slf4j;

import java.io.IOException;

//@WebFilter(urlPatterns = "/api/*")
@Slf4j
public class LogFilter implements Filter {


    @Override
    public void doFilter(ServletRequest servletRequest,
                         ServletResponse servletResponse,
                         FilterChain filterChain) throws IOException, ServletException {

        long start = System.currentTimeMillis();
        log.info("LogFilter start {}", ((HttpServletRequest) servletRequest).getRequestURI());

        filterChain.doFilter(servletRequest, servletResponse);

        long timeElapsed = System.currentTimeMillis() - start;
        log.info("LogFilter end {} status {} in {} ms", ((HttpServletRequest) servletRequest).getRequestURI(),
                ((HttpServletResponse)servletResponse).getStatus(), timeElapsed);

    }
}
