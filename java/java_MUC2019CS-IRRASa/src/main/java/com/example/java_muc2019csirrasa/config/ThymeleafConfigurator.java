//package com.example.java_muc2019csirrasa.config;
//
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//import org.thymeleaf.spring5.templateresolver.SpringResourceTemplateResolver;
//import org.thymeleaf.templatemode.TemplateMode;
//
//@Configuration
//public class ThymeleafConfigurator {
//
//    @Bean
//    public SpringResourceTemplateResolver templateResolver() {
//        SpringResourceTemplateResolver templateResolver = new SpringResourceTemplateResolver();
//        templateResolver.setPrefix("classpath:/templates/admin/");
//        templateResolver.setSuffix(".html");
//        templateResolver.setTemplateMode(TemplateMode.HTML);
//        templateResolver.setCharacterEncoding("UTF-8");
//        templateResolver.setOrder(1);
//        templateResolver.setCheckExistence(true);
//
//        return templateResolver;
//    }
//
//}
