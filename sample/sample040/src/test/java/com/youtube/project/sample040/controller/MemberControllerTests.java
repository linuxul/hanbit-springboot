package com.youtube.project.sample040.controller;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.youtube.project.sample040.dto.MemberRequest;
import com.youtube.project.sample040.dto.MemberResponse;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.ResultMatcher;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.springframework.test.web.client.match.MockRestRequestMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
@DisplayName("회원 컨트롤러 테스트")
public class MemberControllerTests {
    @Autowired
    private MockMvc mockMvc;
    @Autowired
    private ObjectMapper objectMapper;

    @Test
    @DisplayName("여러 명의 회원 생성 테스트")
    public void post() throws Exception {
        List<MemberRequest> memberRequests = List.of(
                // 1. 생성 요청할 회원 정보를 리스트 형식으로 작성
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

        // 2. 회원 목록을 HTTP Request Body에 넣기 위해 JSON 스트링으로 변환
        String requestBody = objectMapper.writeValueAsString(memberRequests);

//        // 3. MockMvc를 사용해 RESTful API 호출 시 사용할 HTTP Method, URI, Content Type, Request Body를 설정
//        RequestBuilder requestBuilder = MockMvcRequestBuilders
//                .post("/api/v1/members")
//                .contentType(MediaType.APPLICATION_JSON)
//                .accept(MediaType.APPLICATION_JSON)
//                .content(requestBody);
//
//        // 4. MockMvc 사용해 호출 /api/members
//        MvcResult mvcResult = mockMvc
//                .perform(requestBuilder)
//                .andExpect(status().is2xxSuccessful())
//                .andExpect((ResultMatcher) content().contentType(MediaType.APPLICATION_JSON))
//                .andReturn();

        RequestBuilder requestBuilder = MockMvcRequestBuilders
                .post("/api/v1/members")
                .contentType(MediaType.APPLICATION_JSON)
                .accept(MediaType.APPLICATION_JSON_VALUE)
                .content(requestBody);

        MvcResult mvcResult = mockMvc
                .perform(requestBuilder)
                .andExpect(status().is2xxSuccessful())
                .andExpect((ResultMatcher) content().contentType(MediaType.APPLICATION_JSON_UTF8_VALUE))
                .andReturn();

        // 5 json
        List<MemberResponse> memberResponses = objectMapper.readValue(
                mvcResult.getResponse().getContentAsByteArray(),
                new TypeReference<>() { }
        );

        // 6. Assert
        assertThat(memberResponses.size()).isEqualTo(4);
        assertThat(memberResponses.get(0).getId()).isNotNull();
        assertThat(memberResponses.get(1).getName()).isEqualTo("윤서일");
        assertThat(memberResponses.get(2).getId()).isNotNull();
        assertThat(memberResponses.get(1).getName()).isEqualTo("윤서이");

    }
}
