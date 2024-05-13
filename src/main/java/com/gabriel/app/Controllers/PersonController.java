package com.gabriel.app.Controllers;

import com.gabriel.app.Entities.Person;
import com.gabriel.app.Repositories.PersonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/user")
public class PersonController {
    @Autowired
    private PersonRepository personRepository;
    @GetMapping
    public List<Person> getAllPerson() {
        return personRepository.findAll();
    }
    @GetMapping("/{id}")
    public Person getPersonById(@PathVariable Long id) {
        return personRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("not found"));
    }
    @PostMapping
    public Person addPerson(@RequestBody Person person) {
        return personRepository.save(person);
    }
    @PutMapping("/{id}")
    public Person updatePerson(@PathVariable Long id, @RequestBody Person person) {
        Person person1 =  personRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Person not found id: " + id));
        person1.setUserName(person.getUserName());
        person1.setPassword(person.getPassword());
        return personRepository.save(person1);
    }
    @DeleteMapping("/{id}")
    public String deletePerson(@PathVariable Long id) {
        Person person2 = personRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Person not found id: " + id));
        personRepository.delete(person2);
        return "Person deleted";
    }
}
