package com.wsloan;

import org.springframework.boot.web.support.SpringBootServletInitializer;

public class SpringApplicationBuilder extends SpringBootServletInitializer {

    @Override
    protected org.springframework.boot.builder.SpringApplicationBuilder configure(org.springframework.boot.builder.SpringApplicationBuilder application) {
        return application.sources(TenMillionApplication.class);
    }
}
