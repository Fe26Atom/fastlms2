package com.zerobase.fastlms2;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;


@Controller
public class MainPage {

    @RequestMapping("/")
    public String index(){
        return "Index page";
    }

    @RequestMapping("/hello")
    public void Hello(HttpServletRequest request, HttpServletResponse response) throws IOException {

        response.setContentType("text/html;charset=UTF-8");

        PrintWriter printWriter = response.getWriter();

        String msg = "<html>" +
                "<head>" +
                "<meta charset=\"UTF-8\">" +
                "</head>" +
                "<p>hello</p> <p>fastlms website!!!</p>"+
                "<p> 안녕하세요!!! ===> </p>" +
                "</body>" +
                "</html>";

       printWriter.write(msg);
       printWriter.close();
    }
}
