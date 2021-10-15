package com.zerobase.fastlms2.member.service;

import com.zerobase.fastlms2.member.entity.Member;
import com.zerobase.fastlms2.member.model.MemberInput;
import com.zerobase.fastlms2.member.repository.MemberRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@RequiredArgsConstructor
@Service
public class MemberServiceImpl implements MemberService{

    private final MemberRepository memberRepository;

    @Override
    public boolean register(MemberInput parameter) {

        Member member = new Member();
        member.setUserId(parameter.getUserId());
        member.setUserName(parameter.getUserName());
        member.setPhone(parameter.getPhone());
        member.setPassword(parameter.getPassword());
        member.setRegDt(LocalDateTime.now());
        memberRepository.save(member);


        return false;
    }
}
