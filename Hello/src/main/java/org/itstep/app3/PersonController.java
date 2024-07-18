package org.itstep.app3;

import org.itstep.app2.Person1;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("/persons")
public class PersonController {
    private List<Person1> persons = new ArrayList<>();

    {
        List<Person1> fakePersons = new ArrayList<>();
        Long id = 1L;

        fakePersons.add(new Person1("Ivan","Ivanov"));
        fakePersons.add(new Person1("навИ","вонавИ"));
        fakePersons.add(new Person1("Mode","Dovn"));
        fakePersons.add(new Person1("Mister","ADUN"));

        for (Person1 person: fakePersons){
            person.setId(id);
            persons.add(person);
            id++;
        }
    }

    @GetMapping("/hello")
    public String hello(Model model){
        model.addAttribute("message","Привет from  Freemarker");
        return "index";
    }

    @GetMapping({"/",""})
    public String getAllPersons(Model model){
        model.addAttribute("persons",persons);
        return "persons";
    }

    @PostMapping({"/",""})
    public String createPerson(Model model, @ModelAttribute("person") Person1 person){
        persons.add(person);
        model.addAttribute("persons",persons);
        return "redirect:/persons";
    }

    @PostMapping("/delete/{id}")
    public String deletePerson(Model model, @PathVariable("id") Long id){
        System.out.printf("delete %d%n",id);
        Person1 person = persons.stream()
                .filter(p->p.getId().equals(id))
                .findFirst()
                .orElse(null);
        persons.remove(person);
        model.addAttribute("persons",persons);
        return "redirect:/persons";
    }

    @PostMapping("/update/{id}")
    public String updatePerson(Model model,
                               @PathVariable("id") Long id,
                               @ModelAttribute("person") Person1 person){

        System.out.printf("update %d%n",id);
        Person1 personOld = persons.stream()
                .filter(p->p.getId().equals(id))
                .findFirst()
                .orElse(null);
        personOld.setId(person.getId());
        personOld.setName(person.getName());
        personOld.setSurname(person.getSurname());
        model.addAttribute("persons",persons);
        return "redirect:/persons";
    }

}
