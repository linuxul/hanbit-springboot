package com.example.sample034.repository;


import com.example.sample034.model.Member;
import jakarta.transaction.Transactional;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface MemberRepository extends JpaRepository<Member, Long> {

    // 나이 정보가 존재하지 않는 회원 조회
    List<Member> findByAgeIsNull();

    // 나이 정보가 존재하는 회원 정보
    List<Member> findByAgeIsNotNull();

    // 매개변수로 전달된 나이로 회원 조회
    List<Member> findByAgeIs(Integer age);

    // 매개변수로 전달된 나이보다 나이가 더 많은 회원 조회
    List<Member> findByAgeGreaterThan(Integer age);
    List<Member> findByAgeAfter(Integer age);

    // 매개변수로 전달된 나이보다 나이가 더 많거나 같은 회웢 조회
    List<Member> findByAgeGreaterThanEqual(Integer age);

    // 매개변수로 전달된 나이보다 나이가 더 적은 회원 조회
    List<Member> findByAgeLessThan(Integer age);
    List<Member> findByAgeBefore(Integer age);

    // 매개변수로 전달된 나이보다 나이가 더 적거나 같은 회원 조회
    List<Member> findByAgeLessThanEqual(Integer age);

    // 매개변수로 전달된 나이를 포함해 그 사이 나이의 회원 조회
    List<Member> findByAgeBetween(Integer min, Integer max);

    // SELECT * FROM MEMBER WHERE name = '...' AND email = '...' OR age>
    List<Member> findByNameIsAndEmailIsOrAgeIsGreaterThan(String name, String email, Integer age);
    List<Member> queryByNameEqualsAndEmailIsOrAgeGreaterThan(String name, String email, Integer age);
    List<Member> searchByNameAndEmailIsOrAgeGreaterThan(String name, String email, Integer age);

    // 이름순으로 조회
    List<Member> findByOrderByNameAsc();

    // 이름의 역순으로 조회
    List<Member> findByOrderByNameDesc();

    // 이름순으로 조회하고 이름이 같은 경우에는 나이의 역순으로 조회
    List<Member> findByOrderByNameAscAgeDesc();

    // 이름의 일부로 검색하고 그 결과는 이름순으로 조회
    // 조건과 정렬 방법 등이 함께 이름에 사용되면 이름이 길어져 가독성이 떨어진다.
    List<Member> findByNameContainsOrderByNameAsc(String name);

    // 나이순으로 정렬하고 나이가 가정 적은 한 명을 조회
    Member findFirstByOrderByAgeDesc();
    Member findTopByOrderByAgeDesc();

    // 나이순으로 정렬하고 나이가 가장 적은 두 명을 조회
    List<Member> findFirst2ByOrderByAgeDesc();
    List<Member> findTop2ByOrderByAgeAsc();

    // 이름의 일부분으로 검색하고 Sort 객체의 정보를 기반으로 정렬
    List<Member> findByNameContaining(String name, Sort sort);

    // 이름의 일부분으로 검색하고 Pageable 객체의 정보를 기반으로 페이지 조회
    Page<Member> findByNameContaining(String name, Pageable pageable);

    // 이메일을 사용해 회원 삭제
    @Transactional
    int deleteByEmail(String email);

    // 이름을 사용해 회원 삭제
    @Transactional
    int deleteByName(String name);

}
