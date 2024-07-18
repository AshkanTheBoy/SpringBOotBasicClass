package org.ashInc.scan;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;

//@SpringBootApplication
@ComponentScan
public class Application {
    private static ApplicationContext applicationContext = new AnnotationConfigApplicationContext(Application.class);

    public static void main(String[] args) {
        for (String bean: applicationContext.getBeanDefinitionNames()){
            System.out.println(bean);
        }
    }
} 