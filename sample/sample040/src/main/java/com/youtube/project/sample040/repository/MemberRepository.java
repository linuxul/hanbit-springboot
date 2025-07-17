package com.youtube.project.sample040.repository;

import com.youtube.project.sample040.model.Member;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MemberRepository extends JpaRepository<Member, Long> {
}
