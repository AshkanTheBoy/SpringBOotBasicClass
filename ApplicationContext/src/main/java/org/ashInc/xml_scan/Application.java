package org.ashInc.xml_scan;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import javax.swing.*;

//@SpringBootApplication
@ComponentScan
public class Application {

    private class ExampleBean{}
    @Bean
    public ExampleBean exampleBean(){
        return new ExampleBean();
    }
    private static ApplicationContext applicationContext = new ClassPathXmlApplicationContext(new String[]{"daos.xml"});

    public static void main(String[] args) {
        for (String bean: applicationContext.getBeanDefinitionNames()){
            System.out.println(bean);
        }
        applicationContext.getBean(Dog.class).sound();

        System.out.println(applicationContext.containsBean("catDao"));

    }
} 