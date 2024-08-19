package org.AshInc.mail;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import javax.mail.MessagingException;
import java.time.LocalDate;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

@Controller
public class EmailController {
    @Autowired
    EmailService emailService;

    @GetMapping("/send")
    public String sendSimple(){
        Mail email = new Mail();
        email.setTo("ashkantheboyvisage@gmail.com");
        email.setFrom("ashkantheboyvisage@gmail.com");
        email.setSubject("Test text");
        email.setText("Test text");
        emailService.sendSimpleMessage(email);
        return "success";
    }

    @GetMapping("/sendhtml")
    public String sendHtml(Model model){
        Mail email = new Mail();
        email.setTo("ashkantheboyvisage@gmail.com");
        email.setFrom("ashkantheboyvisage@gmail.com");
        email.setSubject("Test text");
        email.setText("Test text");
        email.setTemplate("email.html");
        Map<String, Object> properties = new HashMap<>();
        properties.put("name", "Ashish");
        properties.put("subscriptionDate", LocalDate.now().toString());
        properties.put("technologies", Arrays.asList("Python", "Go", "C#"));
        email.setProperties(properties);
        try {
            emailService.sendHtmlMessage(email);
        } catch (MessagingException e) {
            throw new RuntimeException(e);
        }
        return "success";
    }
}
