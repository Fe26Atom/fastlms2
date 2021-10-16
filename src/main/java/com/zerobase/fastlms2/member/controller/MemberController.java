package com.zerobase.fastlms2.member.controller;

import com.zerobase.fastlms2.member.model.MemberInput;
import com.zerobase.fastlms2.member.service.MemberService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@RequiredArgsConstructor
@Controller
public class MemberController {

    private final MemberService memberService;

    @GetMapping("/member/register")
    public String register() {
        return "member/register";
    }


    @PostMapping("/member/register")
    public String registerSubmit(Model model, HttpServletRequest request
        , MemberInput parameter) {

        boolean result = memberService.register(parameter);

        model.addAttribute("result", result);
        return "member/register_complete";
    }
}
