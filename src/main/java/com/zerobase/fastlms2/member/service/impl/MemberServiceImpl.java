package com.zerobase.fastlms2.member.service.impl;

import com.zerobase.fastlms2.components.MailComponents;
import com.zerobase.fastlms2.member.entity.Member;
import com.zerobase.fastlms2.member.model.MemberInput;
import com.zerobase.fastlms2.member.repository.MemberRepository;
import com.zerobase.fastlms2.member.service.MemberService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.Optional;
import java.util.UUID;

@RequiredArgsConstructor
@Service
public class MemberServiceImpl implements MemberService {

    private final MemberRepository memberRepository;
    private final MailComponents mailComponents;
    /**
     * 회원 가입
     */

    @Override
    public boolean register(MemberInput parameter) {

        Optional<Member> optionalMember = memberRepository.findById(parameter.getUserId());
        if(optionalMember.isPresent()) {
            //현재 userId에 해당하는 데이터 존재
            return false;
        }

        String uuid = UUID.randomUUID().toString();

        Member member = new Member();
        member.setUserId(parameter.getUserId());
        member.setUserName(parameter.getUserName());
        member.setPhone(parameter.getPhone());
        member.setPassword(parameter.getPassword());
        member.setRegDt(LocalDateTime.now());
        member.setEmailAuthYn(false);
        member.setEmailAuthKey(UUID.randomUUID().toString());
        memberRepository.save(member);

        String email = parameter.getUserId();
        String subject = "Fastlms 사이트 가입을 축하들빈다. ";
        String text = "<p>fastlms 사이트 가입을 축하드립니다. </p><p>아래 링크를 클릭하셔서 가입을 완료 하세요.</p>"
                + "<div> <a href='http://localhost:8080/memver/email-auth?id=" + uuid + "'> 가입 완료 </a></div>";
        mailComponents.sendMail(email, subject, text);


        return true;
    }
}