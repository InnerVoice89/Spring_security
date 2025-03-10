package ru.springsecuritynew.springsecuritynew.controllers;


import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import ru.springsecuritynew.springsecuritynew.models.Person;
import ru.springsecuritynew.springsecuritynew.security.PersonDetails;
import ru.springsecuritynew.springsecuritynew.services.PersonDetailsService;

@Controller
public class HelloController {


@GetMapping
    public String sayHello(){
    return "hello";
    }
    @GetMapping("/showUserInfo")
    public String showUserInfo(){
        Authentication authentication= SecurityContextHolder.getContext().getAuthentication();
       PersonDetails personDetails= (PersonDetails)authentication.getPrincipal();
       Person person= personDetails.getPerson();
        System.out.println(person.getPassword());
return "hello";
    }

    @GetMapping("/admin")
    public String adminPage(){
        System.out.println("Commit number 2");
    return "admin";

    }



}
