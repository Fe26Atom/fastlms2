package com.zerobase.fastlms2.main.controller;

import com.zerobase.fastlms2.components.MailComponents;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@RequiredArgsConstructor
@Controller
public class MainController {

    private final MailComponents mailComponent;
    @RequestMapping("/")
    public String index(){

        /*
        String email = "ddpm00720@naver.com";
        String subject = " 안녕하세요 제로베이스입니다. ";
        String text = " <p>안녕하세요.</p> <p>제로베이스 입니다. 방갑습니다. </P>";

        mailComponent.sendMail(email, subject, text);
        */

        return "index";
    }


    @RequestMapping("/error/denied")
    public String errorDenied(){
        return "error/denied";
    }

}

