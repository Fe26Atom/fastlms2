package com.zerobase.fastlms2;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
public class MainPage {

    @RequestMapping("/")
    public String index(){
        return "Index page";
    }

    @RequestMapping("/hello")
    public String Hello(){

        String msg = "<html>" +
                "<head>" +
                "</head>" +
                "<p>hello</p> <p>fastlms website!!!</p>" +
                "</body>" +
                "</html>";
        return msg;
    }
}

