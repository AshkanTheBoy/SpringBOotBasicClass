package org.AshInc.WeatherController;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.time.LocalDateTime;

@Controller
public class WeatherController {
    @GetMapping({"","/"})
    public String getWeather(Model model){
        LocalDateTime now =
                LocalDateTime.now
                        ();
        int currentHour = now.getHour();
        int temperature = WeatherNow.temperatures[currentHour];
        model.addAttribute("currentHour", currentHour);
        model.addAttribute("temperature", temperature);
        model.addAttribute("temperatures", WeatherNow.temperatures);
        return "temperature";
    }
}
