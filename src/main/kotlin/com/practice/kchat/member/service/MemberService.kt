package com.practice.kchat.member.service

import com.practice.kchat.member.dto.MemberDtoRequest
import com.practice.kchat.member.entity.Member
import com.practice.kchat.member.repository.MemberRepository
import jakarta.transaction.Transactional
import org.springframework.stereotype.Service

@Transactional
@Service
class MemberService (
    private val memberRepository: MemberRepository
) {
    /*
        회원가입
     */
    fun signUp(memberDtoRequest: MemberDtoRequest): String {
        var member: Member? = memberRepository.findByLoginId(memberDtoRequest.loginId)
        if(member != null) {
            return "이미 등록된 ID 입니다."
        }

        member = Member(
                null,
                memberDtoRequest.loginId,
                memberDtoRequest.password,
                memberDtoRequest.name,
                memberDtoRequest.birthDate,
                memberDtoRequest.gender,
                memberDtoRequest.email
        )
        memberRepository.save(member)

        return "회원가입이 완료되었습니다."
    }
}