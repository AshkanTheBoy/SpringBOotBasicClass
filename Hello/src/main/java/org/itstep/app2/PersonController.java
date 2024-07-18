package org.itstep.app2;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/persons")
public class PersonController {
    private List<Person1> persons = new ArrayList<>();

    {
        persons.add(new Person1(1L,"Ivan","Ivanov"));
        persons.add(new Person1(2L,"навИ","вонавИ"));
    }

    @GetMapping({"","/"})
    public List<Person1> getAllPersons(){
        return persons;
    }

    @GetMapping("/{id}")
    public ResponseEntity<Person1> getPerson(@PathVariable("id") Long id){
        Person1 person = persons.stream()
                .filter(p->p.getId().equals(id))
                .findFirst()
                .orElse(null);
        if (person==null){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        } else {
            return new ResponseEntity<>(person, HttpStatus.OK);
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletePerson(@PathVariable("id") Long id){
        Person1 person = persons.stream()
                .filter(p->p.getId().equals(id))
                .findFirst()
                .orElse(null);
        if (person==null){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        } else {
            persons.remove(person);
            return new ResponseEntity<>(HttpStatus.OK);
        }
    }

    @PostMapping
    public ResponseEntity<Person1> createPerson(@RequestBody Person1 person){
        persons.add(person);
        return new ResponseEntity<>(person, HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Person1> updatePerson(@PathVariable("id") Long id, @RequestBody Person1 person){
        Person1 personOld = persons.stream()
                        .filter(p->p.getId().equals(id))
                        .findFirst()
                        .orElse(null);
        if (personOld==null)
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        personOld.setName(person.getName());
        personOld.setSurname(person.getSurname());
        return new ResponseEntity<>(person, HttpStatus.OK);
    }
    /*
  fetch('http://localhost:8080/persons', {
    method: 'GET'
  })
  .then(response=>response.json());

fetch('http://localhost:8080/persons', {
            method: 'POST',
            headers: {
              'Accept': 'application/json',
              'Content-Type': 'application/json'
            },
            body: JSON.stringify({"id":3, "name": "Jane", "surname": "Doe"})
          });

  fetch('http://localhost:8080/persons/1', {
    method: 'PUT',
    headers: {
      'Accept': 'application/json',
      'Content-Type': 'application/json'
    },
    body: JSON.stringify({"name":"noname"})
  });

  fetch('http://localhost:8080/persons/1', {
    method: 'DELETE'
  });
 */
}
