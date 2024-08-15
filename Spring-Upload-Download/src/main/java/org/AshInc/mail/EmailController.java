package org.AshInc.mail;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class EmailController {
    @Autowired
    EmailService emailService;

    @GetMapping("/send")
    public String sendSimple(Model model){
        Mail email = new Mail();
        email.setTo("ashkantheboyvisage@gmail.com");
        email.setFrom("ashkantheboyvisage@gmail.com");
        email.setSubject("Test text");
        email.setText("Test text");
        emailService.sendSimpleMessage(email);
        return "success";
    }
}
