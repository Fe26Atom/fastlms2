package com.zerobase.fastlms2.configuration;

import com.zerobase.fastlms2.Fastlms2Application;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;

public class ServletInitializer extends SpringBootServletInitializer {

    // 2021.10.14

    @Override
    protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
        return application.sources(Fastlms2Application.class);
    }

}
