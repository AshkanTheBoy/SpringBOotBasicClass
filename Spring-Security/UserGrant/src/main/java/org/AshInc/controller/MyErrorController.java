package org.AshInc.controller;

import org.springframework.boot.web.servlet.error.ErrorController;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class MyErrorController implements ErrorController {
    @RequestMapping(value = "/403")
    public String denied(){
        return "403";
    }

    @RequestMapping(value = "/error")
    public String notFound(){
        return "404";
    }
}
