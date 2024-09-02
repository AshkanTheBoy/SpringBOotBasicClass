package org.AshInc;

import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MyController {
    @GetMapping("/root")
    @PreAuthorize("hasAuthority('write')")
    public String root(){
        return "root";
    }

    @GetMapping("/user")
    @PreAuthorize("hasAnyAuthority('write','user')")
    public String user(){
        return "user";
    }
}
