package com.practice.kchat.member.service

import com.practice.kchat.common.exception.InvalidInputException
import com.practice.kchat.common.status.ROLE
import com.practice.kchat.member.dto.MemberDtoRequest
import com.practice.kchat.member.entity.Member
import com.practice.kchat.member.entity.MemberRole
import com.practice.kchat.member.repository.MemberRepository
import com.practice.kchat.member.repository.MemberRoleRepository
import jakarta.transaction.Transactional
import org.springframework.stereotype.Service

@Transactional
@Service
class MemberService (
    private val memberRepository: MemberRepository,
    private val memberRoleRepository: MemberRoleRepository
) {
    /*
        회원가입
     */
    fun signUp(memberDtoRequest: MemberDtoRequest): String {
        var member: Member? = memberRepository.findByLoginId(memberDtoRequest.loginId)
        if(member != null) {
            throw InvalidInputException("loginId", "이미 등록된 ID 입니다.")
        }

        member = memberDtoRequest.toEntity()
        memberRepository.save(member)

        val memberRole = MemberRole(null, ROLE.MEMBER, member)
        memberRoleRepository.save(memberRole)

        return "회원가입이 완료되었습니다."
    }
}