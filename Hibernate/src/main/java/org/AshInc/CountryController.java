package org.AshInc;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api")
public class CountryController {
    @Autowired
    CountryService countryService;

    @GetMapping("/countries/all")
    public List<Country> getCountries(){
        return countryService.findAll();
    }

    @GetMapping("/countries/{character}")
    public List<Country> getCountriesStartingWithChar(@PathVariable Character character){
        var countries = countryService.findAll()
                .stream()
                .filter(country->country.getName().toLowerCase().charAt(0)==character)
                .collect(Collectors.toList());
        return countries;
    }

    @GetMapping("/countries/random")
    public Country getRandomCountry(){
        Long id = Math.round(Math.random()*countryService.countryCount());
        return countryService.findById(id);
    }

    @GetMapping("/countries/page")
    public List<Country> getCountriesPage(@RequestParam(defaultValue = "0", name="page") int page,
                                          @RequestParam(defaultValue = "10", name="size") int size){
        return countryService.findAll(page, size);
    }

}
