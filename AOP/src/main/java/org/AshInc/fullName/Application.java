package org.AshInc.fullName;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

@SpringBootApplication
@EnableAspectJAutoProxy
public class Application implements CommandLineRunner {
    @Autowired
    FullName fullName;

    @Autowired
    SomeService someService;
    public static void main(String[] args) {
        SpringApplication.run(Application.class,args);
    }

    @Override
    public void run(String... args) throws Exception {
        fullName.composeFullName("Ash","Kan");
        someService.someMethod();
    }
}
