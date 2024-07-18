package org.itstep.app1;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@RestController
public class Application {
    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }

    @RequestMapping("/")
    private String helloWorld(){
        return "<h1>Hello World</h1>";
    }

    @RequestMapping("/{name}")
    private String helloName(@PathVariable("name") String name){
        return String.format("<h1>Hello %s</h1>",name);
    }

    @RequestMapping("/query")
    private String helloName2(@RequestParam("name") String name){
        return String.format("<h1>Hello %s</h1>",name);
    }
//    @RestController
    static class Controller{

    }
}
