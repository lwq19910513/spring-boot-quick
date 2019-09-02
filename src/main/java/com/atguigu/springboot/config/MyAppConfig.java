package com.atguigu.springboot.config;

import com.atguigu.springboot.component.LoginHandlerIntercaptor;
import com.atguigu.springboot.component.MyLocaleResolver;
import com.atguigu.springboot.service.HelloService;
import org.springframework.boot.web.server.ConfigurableWebServerFactory;
import org.springframework.boot.web.server.WebServerFactoryCustomizer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

@Configuration
public class MyAppConfig implements WebMvcConfigurer {

    @Bean
    public HelloService helloService() {
        System.out.println("配置类@Bean给容器中添加组件了。。。");
        return new HelloService();
    }

    @Override
    public void addViewControllers(ViewControllerRegistry registry) {
        registry.addViewController("/").setViewName("login");
        registry.addViewController("/index").setViewName("login");
        registry.addViewController("/main.html").setViewName("dashboard");
    }

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
//        registry.addInterceptor(new LoginHandlerIntercaptor()).addPathPatterns("/**")
//                .excludePathPatterns("/", "/index", "/user/login", "/css/**", "/js/**");
    }

    @Bean
    public MyLocaleResolver localeResolver() {
        return new MyLocaleResolver();
    }
}
