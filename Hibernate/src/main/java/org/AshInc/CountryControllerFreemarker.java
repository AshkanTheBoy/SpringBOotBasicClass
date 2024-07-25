package org.AshInc;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import java.util.HashMap;
import java.util.List;
import java.util.stream.Collectors;

@Controller
public class CountryControllerFreemarker {
    @Autowired
    CountryService countryService;

    @GetMapping("/countries/all")
    public ModelAndView getCountries(){
        var countries = countryService.findAll();
        var params = new HashMap<String, Object>();
        params.put("countries", countries);
        return new ModelAndView("showCountries",params);
    }

    @GetMapping("/countries/{character}")
    public ModelAndView getCountriesStartingWithChar(@PathVariable Character character){
        var countries = countryService.findAll()
                .stream()
                .filter(country->country.getName().toLowerCase().charAt(0)==character)
                .collect(Collectors.toList());
        var params = new HashMap<String, Object>();
        params.put("countries", countries);
        params.put("character",(char)(character-32));
        return new ModelAndView("showCountriesStartingWithCharacter",params);
    }

    @GetMapping("/countries/random")
    public ModelAndView getRandomCountry(){
        Long id = Math.round(Math.random()*countryService.countryCount());
        Country country = countryService.findById(id);
        var params = new HashMap<String, Object>();
        params.put("country", country);
        return new ModelAndView("showRandomCountry",params);
    }

}
