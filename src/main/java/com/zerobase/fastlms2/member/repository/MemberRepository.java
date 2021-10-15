package com.zerobase.fastlms2.member.repository;

import com.zerobase.fastlms2.member.entity.Member;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MemberRepository extends JpaRepository <Member, String>{

}
