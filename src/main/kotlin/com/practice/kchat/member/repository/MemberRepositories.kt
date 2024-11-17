package com.practice.kchat.member.repository;

import com.practice.kchat.member.entity.Member
import org.springframework.data.jpa.repository.JpaRepository

interface MemberRepository : JpaRepository<Member, Long> {
        fun findByLoginId(loginId: String): Member?

        }
