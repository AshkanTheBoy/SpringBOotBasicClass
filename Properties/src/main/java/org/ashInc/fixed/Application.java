package org.ashInc.fixed;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.PropertySource;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@PropertySource(value="classpath:app_ru_RU.properties")
public class Application {
    public static void main(String[] args) {
        SpringApplication.run(Application.class,args);
    }

    @RestController
    static class HelloController{
        @Value("${app.hello}")
        private String hello;

        @Value("${app.name}")
        private String name;

        @RequestMapping("/")
        public String index(){
            return hello+" "+name;
        }
    }
}
