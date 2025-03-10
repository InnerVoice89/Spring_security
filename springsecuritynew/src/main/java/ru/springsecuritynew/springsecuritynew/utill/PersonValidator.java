package ru.springsecuritynew.springsecuritynew.utill;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;
import ru.springsecuritynew.springsecuritynew.models.Person;
import ru.springsecuritynew.springsecuritynew.security.PersonDetails;
import ru.springsecuritynew.springsecuritynew.services.PersonDetailsService;

import java.util.Optional;

@Component
public class PersonValidator implements Validator {
    private final PersonDetailsService personDetailsService;

    @Autowired
    public PersonValidator(PersonDetailsService personDetailsService) {
        this.personDetailsService = personDetailsService;
    }

    @Override
    public boolean supports(Class<?> clazz) {
        return Person.class.equals(clazz);
    }

    @Override
    public void validate(Object target, Errors errors) {
        Person person = (Person) target;
        try {
            personDetailsService.loadUserByUsername(person.getUserName());
            System.out.println("Пользователь найден! Добавляем ошибку...");
        } catch (UsernameNotFoundException ignored) {
            System.out.println("Пользователь не найден, всё ок");
            return;    //всё ок,пользователь не найден
        }
        errors.rejectValue("userName", ""
                , "Человек с таким именем пользователя уже существует");

    }
}
